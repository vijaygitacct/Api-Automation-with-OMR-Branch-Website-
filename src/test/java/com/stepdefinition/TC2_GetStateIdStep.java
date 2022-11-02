package com.stepdefinition;

import java.util.ArrayList;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.address.StateList;
import com.pojo.address.StateList_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

/**
 * @Description steps to get state id from statelist endpoint
 * @Date 31-oct-22
 * @author hp
 *
 */
public class TC2_GetStateIdStep extends BaseClass {
	Response response;
	int stateIdNum;
	String stateId;

	/**
	 * @Description User add header for accessing stateList endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@Given("User add header for accessing stateList endpoint")
	public void userAddHeaderForAccessingStateListEndpoint() {
		addHeaader("accept", "application/json");
	}

	/**
	 * @Description User send GET request for get stateId to statelist endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */

	@When("User send {string} request for StateList endpoint")
	public void userSendRequestForStateListEndpoint(String type) {
		response = requestType(type, EndPoints.STATELIST);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	/**
	 * @Description User verify the getStateId response message matches with
	 *              statelist endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */

	@Then("User verify the getStateId response message matches {string}")
	public void userVerifyTheGetStateIdResponseMessageMatches(String expStateName) {

		StateList_Output_Pojo as = response.as(StateList_Output_Pojo.class);
		ArrayList<StateList> data = as.getData();
		for (StateList eachStateList : data) {
			String actStateName = eachStateList.getName();
			if (actStateName.equals(expStateName)) {
				stateIdNum = eachStateList.getId();
				stateId = String.valueOf(stateIdNum);
				TC1_LoginStep.globalDatas.setStateIdtext(stateId);
				System.out.println(stateId);
				Assert.assertEquals("verify State name", expStateName, actStateName);
				break;

			}
		}

	}

}
