package com.pojo.profilepic;
/**
 * @description response body for change profile pic endpoint
 * @Date 31-oct-22
 * @author hp
 *
 */

public class ChangeProfile_Output_Pojo {

	private int status;
	private String message;
	private Data Data;
	private int cart_count;
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
	public Data getData() {
		return Data;
	}
	public void setData(Data data) {
		Data = data;
	}
	public int getCart_count() {
		return cart_count;
	}
	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}
}
