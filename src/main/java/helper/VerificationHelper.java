package helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class VerificationHelper {

	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(VerificationHelper.class);
	
	
	public VerificationHelper(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("Element is displayed..."+ element.getText());
			return true;	
		}catch(Exception e) {
			log.error("Element is not displayed..."+e.getCause());
			return false;
		}
	}
	
	public boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("Element is displayed..."+ element.getText());
			return false;
		}catch(Exception e) {
			log.error("Element is not displayed...");
			return true;
		}
	}
	
	public String getText(WebElement element) {
		if(element==null) {
			log.error("Element is null...");
			return null;
		}
		boolean status=isDisplayed(element);
		if(status) {
			log.info("Element text is..."+element.getText());
			return element.getText();
		}else {
			return null;
		}
	}
	
	public String getTitle() {
		String title=driver.getTitle();
		log.info("Page title is..."+title);
		return title;
	}
}
