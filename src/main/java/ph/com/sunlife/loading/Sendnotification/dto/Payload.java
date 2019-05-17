package ph.com.sunlife.loading.Sendnotification.dto;

public class Payload {
    private String picture;
    private String id;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "payload{" +
                "picture='" + picture + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
