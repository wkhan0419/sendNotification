package ph.com.sunlife.loading.Sendnotification.dto;

public class ClpMasterKeyRequestDTO {
    private String masterKeyId;
    private String masterKey;
    private String masterDesc;
    private String status;

    public String getMasterKeyId() {
        return masterKeyId;
    }

    public void setMasterKeyId(String masterKeyId) {
        this.masterKeyId = masterKeyId;
    }

    public String getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }

    public String getMasterDesc() {
        return masterDesc;
    }

    public void setMasterDesc(String masterDesc) {
        this.masterDesc = masterDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClpMasterKeyRequestDTO{" +
                "masterKeyId='" + masterKeyId + '\'' +
                ", masterKey='" + masterKey + '\'' +
                ", masterDesc='" + masterDesc + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
