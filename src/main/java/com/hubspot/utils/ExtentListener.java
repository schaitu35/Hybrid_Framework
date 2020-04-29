package com.hubspot.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hubspot.base.TestBase;

public class ExtentListener extends TestBase implements ITestListener {
	
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports reports;
	public ExtentTest tests;
	
	
	@Override
	public void onStart(ITestContext testContext) {
		String ts = new SimpleDateFormat("yyyy_mm_dd_HH_mm_ss").format(new Date());
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/"+"Extent-"+ts+".html");
		//htmlReporter.loadXMLConfig("C:\\Users\\schai\\eclipse-workspace\\hubspot\\extent-config.xml");
		htmlReporter.config().setDocumentTitle("Automation");
		htmlReporter.config().setReportName("Myreport");
		htmlReporter.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("QA", "Chaithanya Kumar");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("Browser", "Chrome");
		}
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		tests = reports.createTest(tr.getName());
		tests.log(Status.PASS, tr.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		tests = reports.createTest(tr.getName());
		tests.log(Status.FAIL, tr.getName());
		tests.log(Status.FAIL, tr.getThrowable());
		try {
			tests.fail("Reference Image", 
					MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot()).build());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		tests = reports.createTest(tr.getName());
		tests.log(Status.SKIP, tr.getName());
	}

	@Override
	public void onFinish(ITestContext testContext) {
		reports.flush();
		
	}
	

	
	
}
