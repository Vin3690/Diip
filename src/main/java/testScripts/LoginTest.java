package testScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import configurations.ObjectReader;
import helper.AssertionHelper;
import helper.LoggerHelper;
import pageObjects.LoginPage;
import testBase.TestBase;

public class LoginTest extends TestBase {
	
	private final Logger log=LoggerHelper.getLogger(LoginTest.class);
	
	@Test(description = "Login test with valid credentials")
	public void testToLoginApplication() {
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		LoginPage login=new LoginPage(driver);
		login.verifyLogin(ObjectReader.reader.getEmail(), ObjectReader.reader.getPassword());
		boolean status=login.verifysuccessMsg();
		AssertionHelper.updateTestStatus(status);
		
	}

}
