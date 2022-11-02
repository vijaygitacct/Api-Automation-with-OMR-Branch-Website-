package com.payload.address;

import com.pojo.address.AddUserAddress_Input_pojo;
import com.pojo.address.DeleteAddressInput;
import com.pojo.address.GetCityIdInput;
import com.pojo.address.UpdateUserAddress_Input_Pojo;
/**
 * @Description payLoad for address Endpoints
 * @Date 31-oct-22
 * @author hp
 *
 */
public class AddressPayload {
	/**
	 * @Description payLoad for add address Endpoints
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	public AddUserAddress_Input_pojo addUserAddress(String first_name, String last_name, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address, String address_type) {
		AddUserAddress_Input_pojo addUserAddress_Input_pojo = new AddUserAddress_Input_pojo(first_name, last_name,
				mobile, apartment, state, city, country, zipcode, address, address_type);
		return addUserAddress_Input_pojo;

	}
	/**
	 * @Description payLoad for update address Endpoints
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	public UpdateUserAddress_Input_Pojo updateUserAddress(String address_id, String first_name, String last_name,
			String mobile, String apartment, int state, int city, int country, String zipcode, String address,
			String address_type) {
		UpdateUserAddress_Input_Pojo updateUserAddressInput = new UpdateUserAddress_Input_Pojo(address_id, first_name, last_name,
				mobile, apartment, state, city, country, zipcode, address, address_type);
		return updateUserAddressInput;

	}
	/**
	 * @Description payLoad for delete address Endpoints
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */

	public DeleteAddressInput deleteUserAddress(String address_id) {
		DeleteAddressInput deleteAddressInput = new DeleteAddressInput(address_id);
		return deleteAddressInput;

	}
	/**
	 * @Description payLoad for getCityId Endpoints
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	public GetCityIdInput getCityId(String state_id) {
		GetCityIdInput getCityIdInput = new GetCityIdInput(state_id);
		return getCityIdInput;

	}





}
