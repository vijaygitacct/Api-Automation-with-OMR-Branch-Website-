package com.pojo.address;
/**
 * @description address request body for delete address endpoint
 * @Date 31-oct-22
 * @author hp
 *
 */
public class DeleteAddressInput {
	private String address_id;

	public DeleteAddressInput(String address_id) {
		super();
		this.address_id = address_id;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
}
