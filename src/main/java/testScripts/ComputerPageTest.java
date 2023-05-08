package testScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import configurations.ObjectReader;
import dataPlaceHolder.ApplicationText;
import helper.LoggerHelper;
import pageObjects.ComputersPage;
import pageObjects.HomePageNavigationMenu;
import pageObjects.LoginPage;
import testBase.TestBase;

public class ComputerPageTest extends TestBase{
	
	private final Logger log=LoggerHelper.getLogger(ComputerPageTest.class);
	LoginPage loginpage;
	HomePageNavigationMenu homepageNavigationMenu;
	ComputersPage computerpage;
	
	
	
	@Test(description = "Verifying computer page...")
	public void VerifyComputerPage() {
		
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		loginpage=new LoginPage(driver);
		loginpage.enterEmailAddress(ObjectReader.reader.getEmail());
		loginpage.enterPassword(ObjectReader.reader.getPassword());
		loginpage.clickonSubmitbuttn();
		
		
		computerpage=new ComputersPage(driver);
		computerpage.clickOnComputerMenu();
		computerpage.selectComputers();
		computerpage.mouseOverOnMaintenance();
		computerpage.sendMessage();
		computerpage.closeSendMessagedialog();
		computerpage.clickOnUserName();
		computerpage.clickOnLogoutLink();
	
}
}