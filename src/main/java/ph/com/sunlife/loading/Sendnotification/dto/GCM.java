package ph.com.sunlife.loading.Sendnotification.dto;

public class GCM   {
	private Payload payload;

	@Override
	public String toString() {
		return "gcm [payload=" + payload + "]";
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}
	
	
}
