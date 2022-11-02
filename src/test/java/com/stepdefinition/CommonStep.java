package com.stepdefinition;

import org.junit.Assert;

import io.cucumber.java.en.Then;
/**
 * @Description statusCode verification step common for all feature file 
 * @Date 31-oct-22
 * @author hp
 *
 */
public class CommonStep {
	/**
	 * @Descripton verify status code "200"
	 * @Date 31-oct-22
	 * @param expStatusCode
	 */
	@Then("User verify the status code is {int}")
	public void userVerifyTheStatusCodeIs(int expStatusCode) {
		
		int actStatusCode = TC1_LoginStep.globalDatas.getStatusCode();
		Assert.assertEquals("verify status code",expStatusCode, actStatusCode);
	}

}
