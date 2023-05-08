package configurations;

import helper.BrowserType;

public interface ConfigReader {
	
	public int getImplicitWait();
	public int getExplicitWait();
	public int getPageLoadtime();
	public BrowserType getBrowserType();
	public String getUrl();
	public String getEmail();
	public String getPassword();

}
