package ph.com.sunlife.loading.Sendnotification.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This class is used for Base entity 
 * @author j519
 *
 */

@MappedSuperclass
public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "CREAT_BY", updatable = false, length = 10)
	protected String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREAT_DT", updatable = false)
	protected Date createdDate;
	@Column(name = "UPDT_BY", length = 10)
	protected String updatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDT_DT")
	protected Date updatedDate;
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	

}
