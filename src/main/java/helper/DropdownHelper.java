package helper;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class DropdownHelper {
	
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(DropdownHelper.class);
	
	
	public DropdownHelper(WebDriver driver) {
		this.driver=driver;
	}
	

public void selectByValue(WebElement element, String value) {
		
		Select select=new Select(element);
		log.info("Selected value using SelectByValue method and value is  :"+value);
		select.selectByValue(value);
		
	}
	
	public void selectByIndex(WebElement element, int index) {
		
		Select select=new Select(element);
		log.info("Selected value using SelectByIndex method and index value is  :"+index);
		select.selectByIndex(index);
		
	}
	
	public void selectByVisibleText(WebElement element, String text) {
		
		Select select=new Select(element);
		log.info("Selected value using SelectByVisibleText method and text value is  :"+text);
		select.selectByVisibleText(text);
		
	}
	
	public void deSelectByVisibleText(WebElement element, String text) {
		
		Select select=new Select(element);
		log.info("Deselected value using DeselectByVisibleText method and text value is  :"+text);
		select.deselectByVisibleText(text);
		
	}
	
	public void deSelectByValue(WebElement element, String value) {
		
		Select select=new Select(element);
		log.info("Deselected value using DeselectByValue method and text value is  :"+value);
		select.deselectByValue(value);
		
	}
	
	public void deSelectByIndex(WebElement element, int index) {
		
		Select select=new Select(element);
		log.info("Deselected value using DeselectByIndex method and text index is  :"+index);
		select.deselectByIndex(index);
		
	}
	
	public List<String> getAllDropDownData(WebElement element) {
		Select select=new Select(element);
		List<WebElement> elementlist=select.getOptions();
		List<String> valuelist=new LinkedList<String>();
		for(WebElement ele:elementlist) {
			log.info(ele.getText());
			valuelist.add(ele.getText());
		}
		return valuelist;
	}
}
