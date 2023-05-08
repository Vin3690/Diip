package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configurations.ObjectReader;
import helper.LoggerHelper;
import helper.WaitHelper;
import testBase.TestBase;

public class ComputersPage {

	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(ComputersPage.class);
	private WaitHelper waithelper;
	
	
	@FindBy(xpath="//li[@id='Computers']")
	WebElement computers_menu;
	
	@FindBy(xpath="//tr[@class='dx-row dx-column-lines dx-header-row']/td/div/div[@class='dx-checkbox-container']")
	WebElement selectAllCheckbox;
	
	@FindBy(xpath="//li[@class='dropdown list_padding MaintainanceList right-gray-border']")
	WebElement maintenanceMenu;
	
	@FindBy(xpath="//li[@class='dropdown list_padding MaintainanceList right-gray-border']")
    WebElement maintenenceDropdown;
	
	@FindBy(xpath="//a[@id='aMaintenance_sendMessage']")
	WebElement sendMessage;
	
	@FindBy(xpath="//*[@id='dvpopup']/div/div/div[1]/div/button")
	WebElement closesendMessagedialog;
	
	@FindBy(xpath="//div/a[@id='logg_main']")
	WebElement userNameDropdown;
	
	@FindBy(xpath="//a[@id='aSignOut']")
	WebElement logoutLink;
	
	
	
	public ComputersPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//waithelper.waitForElement(computers_menu, ObjectReader.reader.getExplicitWait());
		
	}
	
	public void clickOnComputerMenu() {
		computers_menu.click();
		log.info("Clicked on Computer Menu...");
		TestBase.logExtentReport("Clicked on Computer Menu...");
	}
	
	
	public void selectComputers() {
		selectAllCheckbox.click();
		log.info("Select All check box is checked...");
		TestBase.logExtentReport("Select All check box is checked...");
	}
	
	public void mouseOverOnMaintenance() {
		log.info("doing mouse over on.... "+maintenanceMenu.getText());
		TestBase.logExtentReport("doing mouse over on.... "+maintenanceMenu.getText());
		Actions action=new Actions(driver);
		action.moveToElement(maintenanceMenu).build().perform();
	}
	
	public void sendMessage() {
		sendMessage.click();
		log.info("clicked on send Message option..");
		TestBase.logExtentReport("clicked on send Message option..");
	}
	
	public void closeSendMessagedialog() {
		closesendMessagedialog.click();
		log.info("clicked on send Message close icon..");
		TestBase.logExtentReport("clicked on send Message close icon..");
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
}
