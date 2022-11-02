package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.globaldatas.GlobalDatas;
import com.pojo.login.Login_Output_Json;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

/**
 * @Description login steps to get logtoken
 * @Date 31-oct-22
 * @author hp
 *
 */
public class TC1_LoginStep extends BaseClass {
	static GlobalDatas globalDatas = new GlobalDatas();
	Response response;

	/**
	 * @Description User add header in login endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@Given("User add header")
	public void userAddHeader() {
		addHeaader("Content-Type", "application/json");
	}

	/**
	 * @Description User add basicAuthentication for login in Login endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@When("User add basicAuthentication for login")
	public void userAddBasicAuthenticationForLogin() throws FileNotFoundException, IOException {
		basicAuth(getPropertyFileValue("userName"), getPropertyFileValue("password"));
	}

	/**
	 * @Description User send post request to Login endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */

	@When("User send {string} request for login")
	public void userSendRequestForLogin(String type) {

		response = requestType(type, EndPoints.POSTMANBASICAUTH);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		globalDatas.setStatusCode(statusCode);
	}

	/**
	 * @Description User verify the login response body firstName present in Login
	 *              endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@Then("User verify the login response body firstName present as {string} and get the logtoken get saved")
	public void userVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogtokenGetSaved(String expFirstName) {

		Login_Output_Json login_Output_Json = response.as(Login_Output_Json.class);

		String logtoken = login_Output_Json.getData().getLogtoken();
		globalDatas.setLogtoken(logtoken);
		String first_name = login_Output_Json.getData().getFirst_name();

		Assert.assertEquals("verify firstName", expFirstName, first_name);

	}

}
