package ph.com.sunlife.loading.Sendnotification.dto;

public class Apns {
	private  Payload payload;

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "apns [payload=" + payload + "]";
	}
	
}
