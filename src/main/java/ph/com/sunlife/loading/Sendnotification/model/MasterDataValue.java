package ph.com.sunlife.loading.Sendnotification.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * This class is used for master data value table
 * @author j519
 *
 */
@Entity
@Table(name = "CLP_MSTR_DATA_VALU")
public class MasterDataValue extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "mstValuIdSeq", sequenceName = "SEQ_CLP_MSTR_DATA_VALU_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mstValuIdSeq")
	@Column(name = "CLP_MSTR_DATA_VALU_ID",unique = true, nullable = false, precision = 10, scale = 0)
	private Long mstDataValueId;
	
	@Column(name = "MSTR_DATA_VALU", length = 100)
	private String mstDataValue;
	
	@Column(name = "MSTR_DATA_ID", length = 50)
	private String mstDataId;
	
	@Column(name = "DATA_VALU_DESC", length = 500)
	private String mstDataDesc;
	
	@Column(name = "REF_CLP_MSTR_DATA_KEY_ID")
	private Long masterDataKey;

	public Long getMstDataValueId() {
		return mstDataValueId;
	}

	public void setMstDataValueId(Long mstDataValueId) {
		this.mstDataValueId = mstDataValueId;
	}

	public String getMstDataValue() {
		return mstDataValue;
	}

	public void setMstDataValue(String mstDataValue) {
		this.mstDataValue = mstDataValue;
	}

	public String getMstDataId() {
		return mstDataId;
	}

	public void setMstDataId(String mstDataId) {
		this.mstDataId = mstDataId;
	}

	public String getMstDataDesc() {
		return mstDataDesc;
	}

	public void setMstDataDesc(String mstDataDesc) {
		this.mstDataDesc = mstDataDesc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getMasterDataKey() {
		return masterDataKey;
	}

	public void setMasterDataKey(Long masterDataKey) {
		this.masterDataKey = masterDataKey;
	}

}
