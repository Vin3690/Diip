package helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {
	
	
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(FrameHelper.class);
	
	
	public FrameHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void switchToFrame(int frameindex) {
		driver.switchTo().frame(frameindex);
		log.info("Switched to"+frameindex+"frame");
	}

	public void switchToFrame(String framename) {
		driver.switchTo().frame(framename);
		log.info("Switched to"+framename+"frame");
	}
	
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
		log.info("Switched to"+element+"frame");
	}
	
	
}
