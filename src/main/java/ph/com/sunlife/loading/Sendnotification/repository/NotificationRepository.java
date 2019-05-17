package ph.com.sunlife.loading.Sendnotification.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ph.com.sunlife.loading.Sendnotification.model.NotificationT;


@Repository
public interface NotificationRepository extends PagingAndSortingRepository<NotificationT, Long> {
	
	public List<NotificationT> findAllByNotificationId(Long notificationId);
	public List<NotificationT> findAll();
	
	/*@Query("select t from NotificationT t where t.userId = ?1")
	public List<NotificationT> findbyUserId(String userId);*/
	
	@Query("select t from NotificationT t where t.userId = ?1 and t.mstKeyId = ?2")
	public List<NotificationT> findByUserIdAndNotiType(String userId, Long notiType);
	public long countByNotiStat(String notiStat);
	
	public NotificationT save(NotificationT notification);
	
	@Query("SELECT t FROM NotificationT t where t.userId = ?1 and t.createdDate = ?2")
	public List<NotificationT> findbyUserId(String userId,Date creationDate);
	
	@Query("SELECT distinct(createdDate)  FROM NotificationT ")
	public List<Date> findAllUniqueCrtionDate();
	
	@Query("SELECT distinct(createdDate) FROM NotificationT t where t.mstKeyId= ?1")
	public List<Date> findAllUnqueDatebyNotiType(Long Type);
	
	@Query("SELECT t FROM NotificationT t where t.mstKeyId= ?1 and t.userId= ?2 and t.createdDate= ?3")
	public List<NotificationT> findAllNotiTypeUsrIDAndDate(Long mstrId, String userId,Date creadtedDate);
	
	@Query("SELECT t FROM NotificationT t where t.publishDate between ?1 and ?2")
	public List<NotificationT> findAllByPubDate(String currentDate,String publishDate);
	
	public List<NotificationT> findByPublishDateBetween(Date currentDate, Date publishDate);
}
