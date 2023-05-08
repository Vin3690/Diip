package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import configurations.ObjectReader;
import helper.LoggerHelper;
import helper.VerificationHelper;
import helper.WaitHelper;
import testBase.TestBase;

public class LoginPage {
	
	
	private WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waithelper;
	
	
	@FindBy(xpath="//input[@id='txtUserName']")
	WebElement EmailAddress;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement EmailPassword;
	
	@FindBy(xpath="//input[@id='btnlogin']")
	WebElement Submitbuttn;
	
	@FindBy(xpath="//*[@id=\"header-fixed\"]/div[3]/div[1]/h1")
	WebElement successmsg;

	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);
		waithelper.waitForElement(Submitbuttn, ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationscreen(driver);
	}
	
	public void enterEmailAddress(String EmailAddress) {
		log.info("entering email address....");
		TestBase.logExtentReport("entering email address");
		this.EmailAddress.sendKeys(EmailAddress);
	}
	
	public void enterPassword(String EmailPassword) {
		log.info("entering email password....");
		TestBase.logExtentReport("entering email password");
		this.EmailPassword.sendKeys(EmailPassword);
	}
	
	
	public HomePage clickonSubmitbuttn() {
		log.info("clicking on submit button....");
		TestBase.logExtentReport("clicking on submit button");
		Submitbuttn.click();
		return new HomePage(driver);
	}
	
	public boolean verifysuccessMsg() {
		log.info("Suceessfully logged in to application");
		TestBase.logExtentReport("Suceessfully logged in to application");
		return new VerificationHelper(driver).isDisplayed(successmsg);
	}
	
	public void verifyLogin(String email, String pass) {
		enterEmailAddress(email);
		enterPassword(pass);
		clickonSubmitbuttn();
		
	}

}
