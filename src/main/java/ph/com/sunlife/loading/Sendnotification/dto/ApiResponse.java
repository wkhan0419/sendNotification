package ph.com.sunlife.loading.Sendnotification.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * This class is used for common api response
 * @author j519
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

	String  dataBean;
	String message;
	String result;
	int httpCode;

	public String  getDataBean() {
		return dataBean;
	}

	public void setDataBean(String dataBean) {
		this.dataBean = dataBean;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	@Override
	public String toString() {
		return "ApiResponse{" +
				"dataBean=" + dataBean +
				", message='" + message + '\'' +
				", result='" + result + '\'' +
				", httpCode=" + httpCode +
				'}';
	}
}
