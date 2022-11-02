package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.payload.productserach.ProductSearchPayload;
import com.pojo.product.SearchProductInput;
import com.pojo.product.SearchProduct_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @Description steps to get searched product from ProductList Endpoint
 * @Date 31-oct-22
 * @author hp
 *
 */
public class TC5_ProductSearchStep extends BaseClass {
	Response response;

	/**
	 * @Description User add header for accessing ProductList Endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@Given("User add header for accessing product list endpoint")
	public void userAddHeaderForAccessingProductListEndpoint() {
		List<Header> listHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h3);

		Headers headers = new Headers(listHeader);
		addHeaders(headers);

	}

	/**
	 * @Description User add request body search product name to ProductList
	 *              Endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@When("User add request body search product {string}")
	public void userAddRequestBodySearchProduct(String text) {
		ProductSearchPayload productSearchPayload = new ProductSearchPayload();
		SearchProductInput searchProductInput = productSearchPayload.searchProduct(text);
		addBody(searchProductInput);

	}

	/**
	 * @Description User send GET request for search product from ProductList
	 *              Endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@When("User send {string} request for search product endpoint")
	public void userSendRequestForSearchProductEndpoint(String type) {
		response = requestType(type, EndPoints.SERACHPRODUCT);
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	/**
	 * @Description User verify the search product response message from ProductList
	 *              Endpoint
	 * @Date 31-oct-22
	 * @author hp
	 *
	 */
	@Then("User verify the search product response message matches {string}")
	public void userVerifyTheSearchProductResponseMessageMatches(String expMessage) {
		SearchProduct_Output_Pojo as = response.as(SearchProduct_Output_Pojo.class);
		String actMessage = as.getMessage();
		System.out.println(actMessage);
		Assert.assertEquals("verify", expMessage, actMessage);
	}

}
