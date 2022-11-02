package com.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.profilepic.ChangeProfile_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @Description steps to get change profile picture in ChangeProfilePicture
 *              Endpoint
 * @Date 31-oct-22
 * @author hp
 *
 */
public class TC6_ChangeProfileStep extends BaseClass {

	Response response;

	/**
	 * @Description User add header and bearer authorization for accessing
	 *              changeProfilePic endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@Given("User add header and bearer authorization for accessing changeProfilePic endpoint")
	public void userAddHeaderAndBearerAuthorizationForAccessingChangeProfilePicEndpoint() {
		List<Header> listHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "multipart/form-data");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);

		Headers headers = new Headers(listHeader);
		addHeaders(headers);

	}

	/**
	 * @Description User add formData for profilePic file to ChangeProfilePicture
	 *              Endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@When("User add formData for profilePic file")
	public void userAddFormDataForProfilePicFile() {
		File file = new File(System.getProperty("user.dir") + "\\images\\lab1.jpg");
		formData("profile_picture", file);
	}

	/**
	 * @Description User send POST request for ChangeProfilePicture Endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@When("User send {string} request for changeProfilePic endpoint")
	public void userSendRequestForChangeProfilePicEndpoint(String type) {
		response = requestType(type, EndPoints.CHANGEPROFILEPIC);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	/**
	 * @Description User verify the changeProfilePic response message from
	 *              ChangeProfilePicture Endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@Then("User verify the changeProfilePic response message matches {string}")
	public void userVerifyTheChangeProfilePicResponseMessageMatches(String expMessage) {
		ChangeProfile_Output_Pojo as = response.as(ChangeProfile_Output_Pojo.class);
		String actMessage = as.getMessage();
		System.out.println(actMessage);
		Assert.assertEquals("verify", expMessage, actMessage);

	}

}
