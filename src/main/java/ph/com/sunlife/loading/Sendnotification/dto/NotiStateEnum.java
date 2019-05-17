package ph.com.sunlife.loading.Sendnotification.dto;

import java.util.HashMap;
import java.util.Map;

public enum NotiStateEnum {
	NEW(1), READ(2), DELIVERED(3), PENDING(4), ERROR(5);
	
	private static final Map<Integer, NotiStateEnum> MY_MAP = new HashMap<Integer, NotiStateEnum>();
	  static {
	    for (NotiStateEnum myEnum : values()) {
	      MY_MAP.put(myEnum.getValue(), myEnum);
	    }
	  }
	  
	  private int value;

	  private NotiStateEnum(int value) {
	    this.value = value;
	  }

	  public int getValue() {
	    return value;
	  }

	  public static NotiStateEnum getByValue(int value) {
	    return MY_MAP.get(value);
	  }

	  public String toString() {
	    return name() + "=" + value;
	  }
}
