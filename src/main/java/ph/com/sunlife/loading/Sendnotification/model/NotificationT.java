package ph.com.sunlife.loading.Sendnotification.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;


/**
 * This class is used for the notif_t database table
 * @author j519
 *
 */
@Entity
@Table(name = "CLP_NOTI")
public class NotificationT extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name = "notiIdSeq", sequenceName = "SEQ_CLP_NOTI_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLP_NOTI_ID",unique = true, nullable = false, precision = 10, scale = 0)
	private Long notificationId;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "SHRT_DESC")
	private String shortDescription;
	
	@Column(name = "LNG_DESC")
	@Length(min=40,max=400)
	private String longDescription;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "NOTI_XPRY_DT")
	private Date expiryDate;
	
	@Column(name = "PUSH_NOTI_SEND_STAT")
	private int pushNotiSendStat;
	
	@Column(name = "NOTI_STAT")
	private Integer notiStat;
	
	@Column(name = "IMG_URL")
	private String imageUrl;
	
	@Column(name = "NOTI_IMG_URL")
	private String notiImgUrl;
	
	@Column(name = "REF_CLP_MSTR_DATA_KEY_ID")
	private Long mstKeyId;
	
	@Column(name="NOTI_TITLE")
	private String title;
	
	@Column(name="USER_GRP")
	private String grpId;
	
	@Column(name="PUB_DT")
	private Date publishDate;
	
	public String getGrpId() {
		return grpId;
	}

	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPushNotiSendStat() {
		return pushNotiSendStat;
	}

	public void setPushNotiSendStat(int pushNotiSendStat) {
		this.pushNotiSendStat = pushNotiSendStat;
	}

	public Integer getNotiStat() {
		return notiStat;
	}

	public void setNotiStat(Integer notiStat) {
		this.notiStat = notiStat;
	}

	public String getNotiImgUrl() {
		return notiImgUrl;
	}

	public void setNotiImgUrl(String notiImgUrl) {
		this.notiImgUrl = notiImgUrl;
	}

	public Long getMstKeyId() {
		return mstKeyId;
	}

	public void setMstKeyId(Long mstKeyId) {
		this.mstKeyId = mstKeyId;
	}
	
	@Override
	public String toString() {
		return "NotificationT [notificationId=" + notificationId + ", userId=" + userId + ", shortDescription="
				+ shortDescription + ", longDescription=" + longDescription + ", expiryDate=" + expiryDate
				+ ", pushNotiSendStat=" + pushNotiSendStat + ", notiStat=" + notiStat + ", imageUrl=" + imageUrl
				+ ", notiImgUrl=" + notiImgUrl + ", mstKeyId=" + mstKeyId + ", title=" + title + ", grpId=" + grpId
				+ ", publishDate=" + publishDate + "]";
	}
	
}
