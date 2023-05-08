package testScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import configurations.ObjectReader;
import helper.LoggerHelper;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.TestBase;

public class HomePageTest extends TestBase{
	
	private final Logger log=LoggerHelper.getLogger(HomePageTest.class);
	LoginPage loginpage;
	
	
	@Test(description = "Verifying HomePage")
	public void testHomePage() {
		
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		loginpage=new LoginPage(driver);
		loginpage.verifyLogin(ObjectReader.reader.getEmail(), ObjectReader.reader.getPassword());
		
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnCloudAgent();
		homepage.clickOnDownloadNowButton();
		//homepage.clickOnUserName();
		//homepage.clickOnLogoutLink();
	}

}
