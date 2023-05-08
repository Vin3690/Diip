package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import helper.AssertionHelper;
import helper.LoggerHelper;
import helper.VerificationHelper;
import testBase.TestBase;

public class HomePage {
	
	
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(HomePage.class);
	
	//@FindBy(xpath="//*[@id='dvhomedashboard']/div[2]/div[1]/a/div/span/text()")
	
	@FindBy(xpath="//*[@id=\"dvhomedashboard\"]/div[2]/div[1]/a/div")
	WebElement cloudAgent;
	
	@FindBy(xpath="//input[@id='Install']")
	WebElement downloadNowbuttn;
	
	@FindBy(xpath="//li[@id='logg_main']")
	WebElement userNameDropdown;
	
	@FindBy(xpath="//a[@id='aSignOut']")
	WebElement logoutLink;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnCloudAgent() {
		cloudAgent.click();
		log.info("clicked on cloud agent button");
		TestBase.logExtentReport("clicked on cloud agent button");
	}
	
	public void clickOnDownloadNowButton() {
		downloadNowbuttn.click();
		log.info("clicked on Download Now button");
		TestBase.logExtentReport("clicked on Download Now button");
	}
	
	public void clickOnUserName() {
		userNameDropdown.click();
		log.info("clicked on UserName drpdown");
		TestBase.logExtentReport("clicked on UserName drpdown");
	}
	
	public LoginPage clickOnLogoutLink() {
		logoutLink.click();
		log.info("clicked on Logout link");
		TestBase.logExtentReport("clicked on Logout link....");
		return new LoginPage(driver);
	}
	
	public String verifySuccessLogoutMesage() {
		 
		return new VerificationHelper(driver).getTitle();
	}
	
}
