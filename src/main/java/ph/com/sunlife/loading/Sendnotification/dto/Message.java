package ph.com.sunlife.loading.Sendnotification.dto;

public class Message {
    private String alert;

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    @Override
    public String toString() {
        return "message{" +
                "alert='" + alert + '\'' +
                '}';
    }
}
