package com.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports reports;
	public ExtentTest tests;

	public void intialization() {
		loadconfig();
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\schai\\eclipse-workspace\\hubspot\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\schai\\eclipse-workspace\\hubspot\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\schai\\eclipse-workspace\\hubspot\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\schai\\eclipse-workspace\\hubspot\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

	public void loadconfig() {
		prop = new Properties();
		try {
			InputStream input = new FileInputStream(
					"C:\\Users\\schai\\eclipse-workspace\\hubspot\\src\\main\\java\\com\\hubspot\\config\\config.properties");
			prop.load(input);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getScreenShot() {

		String ts = new SimpleDateFormat("yyyy_mm_dd_HH_mm_ss").format(new Date());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("./ScreenShots/" + ts + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = System.getProperty("user.dir") + "/ScreenShots/" + ts + ".png";
		return path;

	}

}
