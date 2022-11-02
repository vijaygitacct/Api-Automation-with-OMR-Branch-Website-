package com.pojo.address;

import java.util.ArrayList;
/**
 * @description  response body for getCityId endpoint
 * @Date 31-oct-22
 * @author hp
 *
 */
public class GetCityIdOutPut {

	
		private int status;
		private String message;
		private ArrayList<cityList> data;
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
		public ArrayList<cityList> getData() {
			return data;
		}
		public void setData(ArrayList<cityList> data) {
			this.data = data;
		}
}
