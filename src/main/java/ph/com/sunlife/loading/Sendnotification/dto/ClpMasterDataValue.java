package ph.com.sunlife.loading.Sendnotification.dto;

public class ClpMasterDataValue {

    private String mstrValueId;
    private String masterKeyId;
    private String valueDesc;
    private String masterDataId;
    private String mstrValue;
    private String status;

    public String getMstrValueId() {
        return mstrValueId;
    }

    public void setMstrValueId(String mstrValueId) {
        this.mstrValueId = mstrValueId;
    }

    public String getMasterKeyId() {
        return masterKeyId;
    }

    public void setMasterKeyId(String masterKeyId) {
        this.masterKeyId = masterKeyId;
    }

    public String getValueDesc() {
        return valueDesc;
    }

    public void setValueDesc(String valueDesc) {
        this.valueDesc = valueDesc;
    }

    public String getMasterDataId() {
        return masterDataId;
    }

    public void setMasterDataId(String masterDataId) {
        this.masterDataId = masterDataId;
    }

    public String getMstrValue() {
        return mstrValue;
    }

    public void setMstrValue(String mstrValue) {
        this.mstrValue = mstrValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClpMasterDataValue{" +
                "mstrValueId='" + mstrValueId + '\'' +
                ", masterKeyId='" + masterKeyId + '\'' +
                ", valueDesc='" + valueDesc + '\'' +
                ", masterDataId='" + masterDataId + '\'' +
                ", mstrValue='" + mstrValue + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
