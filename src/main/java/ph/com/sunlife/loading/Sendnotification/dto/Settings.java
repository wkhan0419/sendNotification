package ph.com.sunlife.loading.Sendnotification.dto;

public class Settings {
    private GCM gcm;
    private Apns apns;

    public GCM getGcm() {
        return gcm;
    }

    public void setGcm(GCM gcm) {
        this.gcm = gcm;
    }

    public Apns getApns() {
        return apns;
    }

    public void setApns(Apns apns) {
        this.apns = apns;
    }

    @Override
	public String toString() {
		return "Settings [gcm=" + gcm + ", apns=" + apns + "]";
	}
}
