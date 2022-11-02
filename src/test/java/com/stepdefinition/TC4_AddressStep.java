package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.payload.address.AddressPayload;
import com.pojo.address.AddUserAddress_Input_pojo;
import com.pojo.address.AddUserAddress_Output_Pojo;
import com.pojo.address.DeleteAddressInput;
import com.pojo.address.DeleteAddressOutput;
import com.pojo.address.GetAddressOutput;
import com.pojo.address.UpdateAddress_Output_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @Description steps to address related functionalities in address Endpoints
 * @Date 31-oct-22
 * @author hp
 *
 */
public class TC4_AddressStep extends BaseClass {
	Response response;
	String address_id;
	static AddressPayload addressPayload = new AddressPayload();
	String logtoken;

	/**
	 * @Description User add header and bearer authorization for accessing add
	 *              Address endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@Given("User add header and bearer authorization for accessing address endpoint")
	public void userAddHeaderAndBearerAuthorizationForAccessingAddressEndpoint() {
		List<Header> listHeaders = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");

		listHeaders.add(h1);
		listHeaders.add(h2);
		listHeaders.add(h3);
		Headers header = new Headers(listHeaders);
		addHeaders(header);
	}

	/**
	 * @Description User add request body for add new address to add Address
	 *              endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */

	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userAddRequestBodyForAddNewAddressAnd(String first_name, String last_name, String mobile,
			String apartment, String stateId, String cityId, String country, String zipcode, String address,
			String address_type) {
		int countryCode = Integer.parseInt(country);

		AddUserAddress_Input_pojo addUserAddress_Input_pojo = addressPayload.addUserAddress(first_name, last_name,
				mobile, apartment, TC1_LoginStep.globalDatas.getStateId(), TC1_LoginStep.globalDatas.getCityId(),
				countryCode, zipcode, address, address_type);
		addBody(addUserAddress_Input_pojo);

	}

	/**
	 * @Description User send POST request for addUserAddress endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */

	@When("User send {string} request for addUserAddress endpoint")
	public void userSendRequestForAddUserAddressEndpoint(String type) {
		response = requestType(type, EndPoints.ADDUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	/**
	 * @Description User verify the addUserAddress response message from
	 *              addUserAddress endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */

	@Then("User verify the addUserAddress response message matches {string}")
	public void userVerifyTheAddUserAddressResponseMessageMatches(String expMessage) {
		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		String actMessage = addUserAddress_Output_Pojo.getMessage();
		System.out.println(actMessage);
		int address_idNum = addUserAddress_Output_Pojo.getAddress_id();
		address_id = String.valueOf(address_idNum);
		TC1_LoginStep.globalDatas.setAddress_id(address_id);
		Assert.assertEquals("verify Address added successfully", actMessage, expMessage);

	}

	/**
	 * @Description User add request body for update new address to
	 *              updateUserAddress endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@When("User add request body for update new address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userAddRequestBodyForUpdateNewAddressAnd(String address_id, String first_name, String last_name,
			String mobile, String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {
		int countryCode = Integer.parseInt(country);
		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = addressPayload.updateUserAddress(
				TC1_LoginStep.globalDatas.getAddress_id(), first_name, last_name, mobile, apartment,
				TC1_LoginStep.globalDatas.getStateId(), TC1_LoginStep.globalDatas.getCityId(), countryCode, zipcode,
				address, address_type);
		addBody(updateUserAddress_Input_Pojo);

	}

	/**
	 * @Description User send PUT request for updateUserAddress endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */

	@When("User send {string} request for updateUserAddress endpoint")
	public void userSendRequestForUpdateUserAddressEndpoint(String type) {
		response = requestType(type, EndPoints.UPDATEUSERADDRESS);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	/**
	 * @Description User verify the updateUserAddress response message from
	 *              updateUserAddress endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */

	@Then("User verify the updateUserAddress response message matches {string}")
	public void userVerifyTheUpdateUserAddressResponseMessageMatches(String expMessage) {
		UpdateAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateAddress_Output_Pojo.class);
		String actMessage = updateUserAddress_Output_Pojo.getMessage();
		System.out.println(actMessage);
		Assert.assertEquals("Verify Address Updated Successfully", expMessage, actMessage);

	}

	/**
	 * @Description User send GET request for getUserAddress endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */

	@When("User send {string} request for getUserAddress endpoint")
	public void userSendRequestForGetUserAddressEndpoint(String type) {
		response = requestType(type, EndPoints.GETADDRESS);
		int statusCode = response.getStatusCode();
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	/**
	 * @Description User verify the getUserAddress response message from
	 *              getUserAddress endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */

	@Then("User verify the getUserAddress response message matches {string}")
	public void userVerifyTheGetUserAddressResponseMessageMatches(String expMessage) {
		GetAddressOutput as = response.as(GetAddressOutput.class);
		String actMessage = as.getMessage();
		System.out.println(actMessage);
		Assert.assertEquals("verify", expMessage, actMessage);
	}

	/**
	 * @Description User add request body for delete address to deleteUserAddress
	 *              endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@When("User add request body for delete user address {string}")
	public void userAddRequestBodyForDeleteUserAddress(String address_id) {

		DeleteAddressInput deleteAddressInput = addressPayload
				.deleteUserAddress(TC1_LoginStep.globalDatas.getAddress_id());
		addBody(deleteAddressInput);
	}

	/**
	 * @Description User send DELETE request for deleteUserAddress endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */

	@When("User send {string} request for deleteUserAddress endpoint")
	public void userSendRequestForDeleteUserAddressEndpoint(String type) {
		response = requestType(type, EndPoints.DELETEADDRESS);
		int statusCode = response.getStatusCode();
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	/**
	 * @Description User verify the deleteUserAddress response message from
	 *              deleteUserAddress endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */

	@Then("User verify the deleteUserAddress response message matches {string}")
	public void userVerifyTheDeleteUserAddressResponseMessageMatches(String expMessage) {
		DeleteAddressOutput as2 = response.as(DeleteAddressOutput.class);
		String actMessage = as2.getMessage();
		System.out.println(actMessage);
		Assert.assertEquals("verify", expMessage, actMessage);
	}

}
