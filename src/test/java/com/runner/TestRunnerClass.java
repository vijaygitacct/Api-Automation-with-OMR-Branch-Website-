package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
/**
 * @Description generate Snippet and JSON report
 * @Date 31-OCT-22
 * @author hp
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		tags= " ",
		dryRun=false,
		monochrome=true,
		stepNotifications=true,
		publish=true,
		snippets=SnippetType.CAMELCASE,
		plugin = {"pretty", "json:target\\report.json" },
		features="C:\\Users\\hp\\eclipse-workspace\\OMRBranchAPIAutomation\\src\\test\\resources\\Features",
		glue="com.stepdefinition")

/**
 * @description class used to run feature file and its steps
 * @Date 31-oct-22
 * @author hp
 *
 */
public class TestRunnerClass extends BaseClass {
	/**
	 * @Description generate JVM report
	 * @Date 31-oct-22
	 */
	@AfterClass
	public static void afterClass() {
		Reporting.generateJvmReport(getProjectPath() + "\\target\\report.json");

	}
	
}
