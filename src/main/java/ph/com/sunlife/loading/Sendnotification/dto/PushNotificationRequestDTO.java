package ph.com.sunlife.loading.Sendnotification.dto;

public class PushNotificationRequestDTO {
    private Message message;
    private Settings settings;
    private Target target;
    private String notificationType;

    public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    @Override
	public String toString() {
		return "PushNotificationRequestDTO [message=" + message + ", settings=" + settings + ", target=" + target
				+ ", notificationType=" + notificationType + "]";
	}
}
