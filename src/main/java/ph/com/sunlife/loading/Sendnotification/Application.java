package ph.com.sunlife.loading.Sendnotification;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ph.com.sunlife.loading.Sendnotification.service.interfaces.ISendNotificationService;


@SpringBootApplication
public class Application {
	private static final Logger LOGGER = Logger.getLogger(Application.class);

	public static void main(String[] args) {

		try (ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args)){
			ISendNotificationService iLoadMasterService = ctx.getBean(ISendNotificationService.class);
			iLoadMasterService.sendNotification();
		}catch (Exception e){
			LOGGER.error(e.getStackTrace());
		}
	}
}

