package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.payload.address.AddressPayload;
import com.pojo.address.GetCityIdInput;
import com.pojo.address.GetCityIdOutPut;
import com.pojo.address.cityList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
/**
 * @Description steps to get CItyId from CityList Endpoint
 * @Date 31-oct-22
 * @author hp
 *
 */
public class TC3_GetCityIdStep extends BaseClass {
	Response response;
	int cityId;

	/**
	 * @Description steps to get CItyId from CityList Endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@Given("User add header for accessing cityList endpoint")
	public void userAddHeaderForAccessingCityListEndpoint() {
		List<Header> list = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		list.add(h1);
		list.add(h2);
		Headers header = new Headers(list);
		addHeaders(header);
	}

	/**
	 * @Description User add request body stateId to get cityList
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@When("User add request body stateId to get cityList")
	public void userAddRequestBodyStateIdToGetCityList() {
		AddressPayload addressPayload = new AddressPayload();
		GetCityIdInput cityId = addressPayload.getCityId(TC1_LoginStep.globalDatas.getStateIdtext());
		addBody(cityId);

	}

	/**
	 * @Description User send GET request to get CItyId from CityList Endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@When("User send {string} request for cityList endpoint")
	public void userSendRequestForCityListEndpoint(String type) {
		response = requestType(type, EndPoints.CITYLIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	/**
	 * @Description User verify the getCityId response message matches with CityList Endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@Then("User verify the getCityId response message matches {string}")
	public void userVerifyTheGetCityIdResponseMessageMatches(String expCityName) {
		GetCityIdOutPut as = response.as(GetCityIdOutPut.class);
		ArrayList<cityList> data = as.getData();
		for (cityList eachCityList : data) {
			String name = eachCityList.getName();
			if (name.equals(expCityName)) {
				cityId = eachCityList.getId();
				System.out.println(cityId);
				Assert.assertEquals("verify ", expCityName, name);
				break;

			}

		}

	}

}
