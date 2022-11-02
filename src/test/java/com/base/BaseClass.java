package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @Description Reusable methods for API automation
 * @Date 31-oct-22
 * @author hp
 *
 */
public class BaseClass {
	RequestSpecification reqSpec;
	Response response;

	/**
	 * @Description add header to the request body
	 * @Date 31-oct-22
	 * @param key
	 * @param value
	 */
	public void addHeaader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}

	/**
	 * @Description add query parameter to the request body
	 * @Date 31-oct-22
	 * @param key
	 * @param value
	 */
	public void addQueryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}

	/**
	 * @Description add path parameter to the request body
	 * @Date 31-oct-22
	 * @param key
	 * @param value
	 */
	public void addPathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}

	/**
	 * @Description add String body parameter to the request body
	 * @Date 31-oct-22
	 * @param body
	 */
	public void addBody(String body) {
		reqSpec = reqSpec.body(body);
	}

	/**
	 * @Description add Object body parameter to the request body
	 * @Date 31-oct-22
	 * @param body
	 */
	public void addBody(Object body) {
		reqSpec = reqSpec.body(body);
	}

	/**
	 * @Description add request type to EndPoint
	 * @Date 31-oct-22
	 * @param type
	 * @param endPoint
	 * @return
	 */
	public Response requestType(String type, String endPoint) {
		switch (type) {
		case "GET":
			response = reqSpec.log().all().get(endPoint);

			break;

		case "POST":
			response = reqSpec.log().all().post(endPoint);

			break;
		case "PUT":
			response = reqSpec.log().all().put(endPoint);

			break;
		case "DELETE":
			response = reqSpec.log().all().delete(endPoint);

			break;

		default:
			break;
		}
		return response;

	}

	/**
	 * @Description form data request body for change profile pic Endpoint
	 * @Date 31-oct-22
	 * @param key
	 * @param value
	 */
	public void formData(String key, File value) {
		reqSpec = reqSpec.multiPart(key, value);
	}

	/**
	 * @Description add header for accessing Endpoints
	 * @Date 31-oct-22
	 * @param header
	 */
	public void addHeader(Header header) {
		reqSpec = RestAssured.given().header(header);
	}

	/**
	 * @Description add headers for accessing Endpoints
	 * @Date 31-oct-22
	 * @param headers
	 */
	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
	}

	/**
	 * @Description get status code from Endpoint
	 * @Date 31-oct-22
	 * @param response
	 * @return
	 */
	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;

	}

	/**
	 * @Description get response body as String
	 * @Date 31-oct-22
	 * @return
	 */
	public String getBodyasString() {
		String asString = response.asString();
		return asString;
	}

	/**
	 * @Description get response body as prettyString
	 * @Date 31-oct-22
	 * @param response
	 * @return
	 */
	public String getBodyasPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}

	/**
	 * @Description basic Authentication for login accessing Endpoint
	 * @Date 31-oct-22
	 * @param userName
	 * @param passWord
	 */
	public void basicAuth(String userName, String passWord) {
		reqSpec = reqSpec.auth().preemptive().basic(userName, passWord);

	}

	/**
	 * @Description To get property file values from file location
	 * @Date 31-oct-22
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\config\\config.properties"));
		String value = (String) properties.get(key);
		return value;

	}

	/**
	 * @Description To get project path
	 * @Date 31-oct-22
	 * @return
	 */
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;

	}

}
