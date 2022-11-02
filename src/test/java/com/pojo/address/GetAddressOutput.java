package com.pojo.address;

import java.util.ArrayList;
/**
 * @description address response body for get address endpoint
 * @Date 31-oct-22
 * @author hp
 *
 */
public class GetAddressOutput {
	private int status;
	private String message;
	private ArrayList<AddressList> data;
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
	public ArrayList<AddressList> getData() {
		return data;
	}
	public void setData(ArrayList<AddressList> data) {
		this.data = data;
	}
}
