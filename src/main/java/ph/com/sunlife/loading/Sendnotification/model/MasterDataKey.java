package ph.com.sunlife.loading.Sendnotification.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



/**
 * This class is used for master data key table
 * @author j519
 *
 */
@Entity
@Table(name = "CLP_MSTR_DATA_KEY")
public class MasterDataKey extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "mstKeyIdSeq", sequenceName = "SEQ_CLP_MSTR_DATA_KEY_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mstKeyIdSeq")
	@Column(name = "CLP_MSTR_DATA_KEY_ID",unique = true, nullable = false, precision = 10, scale = 0)
	private Long mstDataKeyId;
	
	@Column(name = "MSTR_DATA_KEY", length = 45)
	private String mstDataKey;
	
	@Column(name = "DATA_KEY_DESC", length = 45)
	private String mstDataDesc;
	
	public Long getMstDataKeyId() {
		return mstDataKeyId;
	}

	public void setMstDataKeyId(Long mstDataKeyId) {
		this.mstDataKeyId = mstDataKeyId;
	}

	public String getMstDataKey() {
		return mstDataKey;
	}

	public void setMstDataKey(String mstDataKey) {
		this.mstDataKey = mstDataKey;
	}

	public String getMstDataDesc() {
		return mstDataDesc;
	}

	public void setMstDataDesc(String mstDataDesc) {
		this.mstDataDesc = mstDataDesc;
	}

}
