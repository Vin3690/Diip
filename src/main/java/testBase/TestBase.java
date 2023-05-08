package testBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import configurations.ObjectReader;
import configurations.PropertyReader;
import helper.BrowserType;
import helper.ChromeBrowser;
import helper.FirefoxBrowser;
import helper.LoggerHelper;
import helper.ResourceHelper;
import helper.WaitHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentManager;

public class TestBase {

	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	private Logger log = LoggerHelper.getLogger(TestBase.class);
	public static File screenshotDirectory;
	

	@BeforeSuite
	public void beforeSuit() {
		extent = ExtentManager.getInstance();
	}
	
	@BeforeTest
	public void beforeTest() throws Exception{
		ObjectReader.reader=new PropertyReader();
		screenshotDirectory=new File(ResourceHelper.getResourcePath("/src/main/resources/Screenshots"));
		setUpDriver(ObjectReader.reader.getBrowserType());
		
	}

	@BeforeClass
	public void beforeClass() {

		test = extent.createTest(getClass().getName());
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + "   test started");

	}

	@AfterMethod
	public void AfterMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + "  is passed");

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		}

		extent.flush();

	}

	public WebDriver getBrowserObject(BrowserType btype) throws Exception {
		try {
			switch (btype) {
			case Chrome:
				WebDriverManager.chromedriver().setup();
				return new ChromeDriver();

			case Firefox:
				FirefoxBrowser ff = new FirefoxBrowser();
				FirefoxOptions options = ff.getFirefoxOptions();
				return ff.getFirefoxDriver(options);
			default:
				throw new Exception("Driver not found" + btype.name());
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}
	
	public void setUpDriver(BrowserType btype) throws Exception {
		driver=getBrowserObject(btype);
		log.info("Initilize the driver  "+driver.hashCode());
		WaitHelper wait=new WaitHelper(driver);
		wait.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
		wait.pageLoadTime(ObjectReader.reader.getPageLoadtime(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public String captureScreen(String filename, WebDriver driver) {
		if(driver == null) {
			log.info("driver is null....");
			return null;
		}
		if(filename=="") {
			filename="blank";
		}
		File destFile=null;
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formater=new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			destFile=new File(screenshotDirectory+"/"+filename+"_"+formater.format(calendar.getTime())+".png");
			FileUtils.copyFile(srcFile, destFile);
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height=100 width=100 /></a>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}
	
	public void getNavigationscreen(WebDriver driver) {
		
		log.info("capturing ui navigation screen");
		String screen=captureScreen("", driver);
		try {
			test.addScreenCaptureFromPath(screen);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void logExtentReport(String s1) {
		test.log(Status.INFO, s1);
	}
	
	public void getApplicationUrl(String url) {
		driver.get(url);
		logExtentReport("navigating to...."+ url);
	}

}
