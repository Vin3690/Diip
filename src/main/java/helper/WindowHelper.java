package helper;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WindowHelper {
	
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(WindowHelper.class);
	
	public WindowHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void switchToParentWindow() {
		log.info("Switching to parent window..!!!");
		driver.switchTo().defaultContent();
	}
	
	public void switchToWindow(int index) {
		Set<String> Windows = driver.getWindowHandles();
		int i=1;
		for(String window:Windows) {
			if(i==index) {
				driver.switchTo().window(window);
			}else {
				i++;
			}
		}
	}
	
	public void closeAllTabsAndSwitchToMainWindow() {
		Set<String> windows=driver.getWindowHandles();
		String mainwindow=driver.getWindowHandle();
		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainwindow)) {
				driver.close();
			} else {
				driver.switchTo().window(mainwindow);
			}
		}
	}
	
	/**
	 * This method will navigate browser to backward
	 */
	public void navigateBack() {
		log.info("navigating browser back...");
		driver.navigate().back();
	}

	/**
	 * This method will navigate browser to forward
	 */
	public void navigateForward() {
		log.info("navigating browser forward...");
		driver.navigate().forward();
	}

	/**
	 * This method will refresh the browser
	 */
	public void refreshBrowser() {
		log.info("refreshing the browser...");
		driver.navigate().refresh();
	}

}
