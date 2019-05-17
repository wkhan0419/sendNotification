package ph.com.sunlife.loading.Sendnotification.dto;

import java.util.List;

public class Target {
    private List<String> userIds;
   // private List<String> platforms;
    
    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

   @Override
	public String toString() {
		return "target [userIds=" + userIds + "]";
	}
}
