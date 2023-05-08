package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.beust.jcommander.JCommander.Builder;

import configurations.ObjectReader;
import helper.LoggerHelper;
import helper.WaitHelper;
import testBase.TestBase;

public class HomePageNavigationMenu {
	
	
	private WebDriver driver;
	private final Logger log=LoggerHelper.getLogger(HomePageNavigationMenu.class);
	WaitHelper waithelper;
	
	@FindBy(xpath="//div[@class='icon-home active']")
	WebElement homeicon;
	
	@FindBy(xpath="//li[@id='Computers']")
	WebElement computers_menu;
	
	@FindBy(xpath="//li[@id='Groups']")
	WebElement groups_menu;
	
	@FindBy(xpath="//li[@id='Policy']")
	WebElement policy_menu;
	
	@FindBy(xpath="//li[@id='DeepFreezeonDemand']")
	WebElement deepfreezeondemand_menu;
	
	@FindBy(xpath="//li[@id='UsageStats']")
	WebElement usagestats_menu;
	
	@FindBy(xpath="//a[@id='nav-a-mdm']")
	WebElement mdm_menu;
	
	@FindBy(xpath="//a[text()=\"REPORTS\"]")
	WebElement reports_menu;
	
	
	@FindBy(xpath="//a[text()=\"OTHERS\"]")
	WebElement others_menu;
	
	
	public HomePageNavigationMenu(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);
		waithelper.waitForElement(homeicon, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("HomePageNavigationMenu object is created...");
		new TestBase().getNavigationscreen(driver);
	}
	
	public void mouseOver(String data) {
		log.info("doing mouse over on.... "+data);
		TestBase.logExtentReport("doing mouse over on.... "+data);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*contains[(text(),'"+data+"')]"))).build().perform();
	}
	
	public menuCatagoryPage clickOnNavigationMenuItems(String data) {
		log.info("Clicking on ...."+data +"menu");
		TestBase.logExtentReport("Clicking on ...."+data +"menu");
		driver.findElement(By.xpath("//*contains[(text(),'"+data+"')]")).click();
		return new menuCatagoryPage(driver);
	}
	
	
	public menuCatagoryPage clickOnNavigationMenu(WebElement element) {
		log.info("Clicking on ...."+element.getText());
		element.click();
		return new menuCatagoryPage(driver);
		
	}
	
	
	
	
	
	
	

}
