package ph.com.sunlife.loading.Sendnotification.service.interfaces;

import java.util.List;

import ph.com.sunlife.loading.Sendnotification.dto.ClpMasterDataValue;
import ph.com.sunlife.loading.Sendnotification.dto.ClpMasterKeyRequestDTO;
import ph.com.sunlife.loading.Sendnotification.model.MasterDataKey;
import ph.com.sunlife.loading.Sendnotification.model.MasterDataValue;


/**
 * This interface is used for master data service
 * @author j519
 *
 */
public interface MasterDataService {

	/**
	 * This function is used for get master data key
	 * @param mstDataKey
	 * @return
	 */
	public MasterDataKey getMasterDataByKey(String mstDataKey);
	
	/**
	 * This function is used for chack master data value is exists or not
	 * @param mstDataId
	 * @param mstDataKeyId
	 * @return
	 */
	public int isMasterDataValueExists(String mstDataId, long mstDataKeyId);
	
	/**
	 * This function is used for get master data value by mstDataId and masterDataKey
	 * @param mstDataId
	 * @param masterDataKey
	 * @return
	 */
	public MasterDataValue findByMstDataIdAndMasterDataKey(String mstDataId, Long masterDataKey); 
	
	public String saveOrUpdateMasterKey(List<ClpMasterKeyRequestDTO> requestDto);
	public String findByMstDataKey(String key);
	public String getPathForMaster();
	public String getPathForNoti();
	public String getEndPointUrl();
	public String saveOrUpdateMasterValue(List<ClpMasterDataValue> requestDto);
}

