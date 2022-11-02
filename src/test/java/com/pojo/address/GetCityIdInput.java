package com.pojo.address;
/**
 * @description  request body for getCityId  endpoint
 * @Date 31-oct-22
 * @author hp
 *
 */
public class GetCityIdInput {
	 private String state_id;

	public GetCityIdInput(String state_id) {
		super();
		this.state_id = state_id;
	}

	public String getState_id() {
		return state_id;
	}

	public void setState_id(String state_id) {
		this.state_id = state_id;
	}

}
