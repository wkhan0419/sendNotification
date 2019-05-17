package ph.com.sunlife.loading.Sendnotification.service.impl;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import ph.com.sunlife.loading.Sendnotification.Utility.Const;
import ph.com.sunlife.loading.Sendnotification.dto.Apns;
import ph.com.sunlife.loading.Sendnotification.dto.GCM;
import ph.com.sunlife.loading.Sendnotification.dto.MFPTokenResponseDTO;
import ph.com.sunlife.loading.Sendnotification.dto.Message;
import ph.com.sunlife.loading.Sendnotification.dto.NotiStateEnum;
import ph.com.sunlife.loading.Sendnotification.dto.Payload;
import ph.com.sunlife.loading.Sendnotification.dto.PushNotificationRequestDTO;
import ph.com.sunlife.loading.Sendnotification.dto.Settings;
import ph.com.sunlife.loading.Sendnotification.dto.Target;
import ph.com.sunlife.loading.Sendnotification.model.NotificationT;
import ph.com.sunlife.loading.Sendnotification.repository.NotificationRepository;
import ph.com.sunlife.loading.Sendnotification.service.interfaces.ISendNotificationService;
import ph.com.sunlife.loading.Sendnotification.service.interfaces.MasterDataService;
@Service
public class SendNotificationServiceImpl implements ISendNotificationService {
private final Logger logger = LoggerFactory.getLogger(SendNotificationServiceImpl.class);
//    private String baseEndPoint = "https://online-vn-st.sunlifecorp.com/vnClientApi/api/";
//    private String baseEndPoint = "https://online-vn-st.sunlifecorp.com/vnClientApi/api/";
//    private final Logger logger = LoggerFactory.getLogger(SendNotificationServiceImpl.class);
	
	@Value("${baseURLForToken}")
	private String baseURLToken;
	
	@Value("${baseURLForPush}")
	private String baseURLPush;
	
	@Value("${UserName}")
	private String user_Name;
	
	@Value("${Password}")
	private String passwords;
	
	@Value("${Scope}")
	private String scope;;
	
	@Value("${ApplicantId}")
	private String applicantId;
	
	@Value("${TokenExtendedUrl}")
	private String tokenExtendedUrl;
	
	@Autowired
	private NotificationRepository notiRepository;
//	@Autowired
//	private MasterDataService masterDataService;
	
    //private String baseURLForToken = "http://localhost:9080/mfp";
    /*private String baseURLForPush = "http://localhost:9080/imfpush/v1/";
    private String pushURL = "apps/com.sunlife.vietnam.clientApp/messages";*/
   // private String tokenURL ="api/az/v1/token";
    /*private String username = "pushTest";
    private String password = "pushTest";*/

    @Override
    public void sendNotification(){
    	logger.trace("in sendNotification method of class SendNotificationServiceImpl for sending push notifications");
        try {
            List<NotificationT> notiData = getNotificationData();
            if(null != notiData){
                String token = createAuthTokenForMFP();
                logger.trace("MFP token successfully generate");
                String baseURLForPush =baseURLPush;
                String applicationID =applicantId;
                if(!token.isEmpty()){
                    for(NotificationT notificationResponseDTO : notiData){
                        PushNotificationRequestDTO jsonPayload = makeNotificationPayloadAndSend(notificationResponseDTO);
                        HttpHeaders headers = new HttpHeaders();
                        headers.setContentType(MediaType.APPLICATION_JSON);
                        headers.add("Authorization", "Bearer " + token);
                        HttpEntity<PushNotificationRequestDTO> request = new HttpEntity<PushNotificationRequestDTO>(jsonPayload, headers);
                        ResponseEntity<Object> response = new RestTemplate().exchange(baseURLForPush+"apps"+applicationID+"messages", HttpMethod.POST, request, Object.class);
                        if(response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
                        	notificationResponseDTO.setNotiStat(NotiStateEnum.DELIVERED.getValue());
                        	notiRepository.save(notificationResponseDTO);
                        }
                    }
                }
            }else{
            	logger.trace("No data found to send via push notification");
            }
        }catch (Exception e){
        	e.printStackTrace();
            logger.error("error while sending push notification for notification id ", e.getMessage());
        }
    }

    private List<NotificationT> getNotificationData() {
        List<NotificationT> notificationResponseDTOS = sendNotification2();
        if(notificationResponseDTOS.size()>0){
            return notificationResponseDTOS;
        }else
            return null;
    }

    private PushNotificationRequestDTO makeNotificationPayloadAndSend(NotificationT notiData){

        PushNotificationRequestDTO notificationRequestDTO = new PushNotificationRequestDTO();
        Message message = new Message();
        message.setAlert(notiData.getLongDescription());
        notificationRequestDTO.setMessage(message);

        Settings settings = new Settings();
        GCM gcm = new GCM();
        Apns apns = new Apns();
        Payload payload = new Payload();
        payload.setId(notiData.getNotificationId().toString());
        payload.setPicture(notiData.getImageUrl());
        gcm.setPayload(payload);
        apns.setPayload(payload);
        settings.setApns(apns);
        settings.setGcm(gcm);
        notificationRequestDTO.setSettings(settings);

        Target target = new Target();
        List<String> userIds = new ArrayList<>();
        userIds.add(notiData.getUserId());
        target.setUserIds(userIds);
        notificationRequestDTO.setTarget(target);
        notificationRequestDTO.setNotificationType("1");
        return notificationRequestDTO;
    }

    @SuppressWarnings("deprecation")
	public String createAuthTokenForMFP(){
    	logger.trace("in createAuthTokenForMFP method of class SendNotificationServiceImpl for creating token for push notification");
    	String accessToken="";
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            String scopeVal = scope;
            String username = user_Name;
            String password = passwords;
            String baseURLForToken = baseURLToken;
            String tokenURL =tokenExtendedUrl;
            
            MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
            map.add(Const.GRANT_TYPE, Const.CLIENT_CRED);
            map.add(Const.SCOPE, scopeVal);
            //map.add(Const.SCOPE,"messages.write push.application.com.sunlife.vietnam.clientApp");
            RestTemplate restTemplateLocal = new RestTemplate();
            restTemplateLocal.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
            ResponseEntity<MFPTokenResponseDTO> response = restTemplateLocal.postForEntity( baseURLForToken+tokenURL, request, MFPTokenResponseDTO.class);
            if(response != null){
                accessToken = response.getBody().getAccess_token();
            }
        }catch (Exception e){
        	e.printStackTrace();
            logger.error("error while getting token from MFP server {}", e.getMessage());
        }
        return accessToken;
    }
    public List<NotificationT> sendNotification2() {
		List<NotificationT> finalNotiDataList = new ArrayList<>();
		try {
			LocalDateTime localtime = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);
			Date out = Date.from(localtime.atZone(ZoneId.systemDefault()).toInstant());
			List<NotificationT> notificationDataList =notiRepository.findByPublishDateBetween(out, new Date());
			finalNotiDataList = notificationDataList.stream()
					.filter(notiDataList -> NotiStateEnum.ERROR.getValue() == notiDataList.getNotiStat()
							|| NotiStateEnum.NEW.getValue() == notiDataList.getNotiStat())
					.collect(Collectors.toList());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalNotiDataList;
	}
	
    
//    
//    @Override
//    public void sendNotification(){
//        try {
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.add("Content-Type", "application/json");
//            restTemplate.getForEntity(baseEndPoint+"notification/sendNotification", ApiResponse.class);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
   
    }

