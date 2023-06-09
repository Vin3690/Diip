package helper;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	private WebDriver driver;
	public Logger log=LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
		log.info("waithelper object is creted...");
	}
	
	public void setImplicitWait(long timeout, TimeUnit unit) {
		log.info("Implicit wait has been set to  :-"+ timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}
	
	public WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		wait.ignoring(ElementNotVisibleException.class);
		return wait;
	}
	
	public void waitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		log.info("Waiting for :"+element.toString()+"for :"+timeOutInSeconds+"  Seconds");
		WebDriverWait wait=getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is Visible now...!!!");
	
	}
	
	public void waitForElementClickable(WebElement element, int timeOutInSeconds) {
		log.info("Waiting for :"+element.toString()+"for :"+timeOutInSeconds+"  Seconds");
		WebDriverWait wait= new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is clickable now...!!!");
	}
	
	
	
	/**
	 * This method will make sure invisibilityOf element
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("element is invisibile now");
		return status;
	}

	/**
	 * This method will wait for frameToBeAvailableAndSwitchToIt
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("frame is available and switched");
	}

	/**
	 * This method will give is fluentWait object
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	private Wait<WebDriver> getfluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
		return fWait;
	}
	
	/**
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec){
		Wait<WebDriver> fwait = getfluentWait(timeOutInSeconds, pollingEveryInMiliSec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public void pageLoadTime(long timeout, TimeUnit unit){
		log.info("waiting for page to load for : "+ unit+ " seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("page is loaded");
	}
	
	/**
	 * This method will make sure elementToBeClickable
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElement(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}
	
	
	
	
   
}
