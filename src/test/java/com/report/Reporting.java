package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
/**
 * @Description generate JVM report from JSON file
 * @Date 31-oct-22
 * @author hp
 *
 */
public class Reporting {
	/**
	 * @Description configure JSON file to get JVM report
	 * @Date 31-oct-22
	 * @param jsonFile
	 */
	public static void generateJvmReport(String jsonFile) {

		File file = new File("C:\\Users\\hp\\eclipse-workspace\\OMRBranchAPIAutomation\\target");

		Configuration configuration = new Configuration(file, "Adactin Hotel page Automation");

		configuration.addClassifications("Browser Name ", "Chrome");
		configuration.addClassifications("Browser Version", "104");
		configuration.addClassifications("Os", "Windows 10");
		configuration.addClassifications("Spirint", "34");
		
		List<String> jsonFiles=new ArrayList<String>();
		jsonFiles.add(jsonFile);
		
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();


	}


}
