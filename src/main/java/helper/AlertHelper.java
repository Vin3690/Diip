package helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;


public class AlertHelper {
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(AlertHelper.class);
	
	public AlertHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public Alert getAlert() {
		log.info("Alert text :"+driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public void acceptAlert() {
		getAlert().accept();
		log.info("alert accept done...!!");
	}
	
	public void dismissAlert() {
		getAlert().dismiss();
		log.info("alert dismiss done...!!");
	}
	
	public String getAlertText() {
		log.info("alert text is  :"+driver.switchTo().alert().getText());
		return driver.switchTo().alert().getText();

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			log.info("Alert is present..!!!");
			return true;
		}catch(NoAlertPresentException e) {
			log.info(e.getCause());
			return false;
		}
	}
	
	public void acceptAlertIfPresent() {
			if(isAlertPresent()) {
				acceptAlert();
			}else {
				log.info("Alert is not present..!!!");
			}
		}
	
	public void dismissAlertIfPresent() {
		if(isAlertPresent()) {
			dismissAlert();
		}else {
			log.info("Alert is not present..!!!");
		}
	}
	
	public void acceptPrompt(String text) {
		if(isAlertPresent()) {
			Alert alert=getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("Alert text is :"+ text);
		}
	}

}
