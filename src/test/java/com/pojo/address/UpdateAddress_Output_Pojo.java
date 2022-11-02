package com.pojo.address;
/**
 * @description address response body for update address endpoint
 * @Date 31-oct-22
 * @author hp
 *
 */
public class UpdateAddress_Output_Pojo {
	private int status;
	private String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
