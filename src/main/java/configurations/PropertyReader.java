package configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import helper.BrowserType;
import helper.ResourceHelper;

public class PropertyReader implements ConfigReader {
	public static Properties prop;

	public PropertyReader() {
		String Filepath = ResourceHelper.getResourcePath("/src/main/resources/configFiles/config.properties");
		try {
			FileInputStream fiStream = new FileInputStream(new File(Filepath));
			prop = new Properties();
			prop.load(fiStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("Implicitwait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("Explicitwait"));
	}

	public int getPageLoadtime() {
		return Integer.parseInt(prop.getProperty("Pageloadtime"));
	}

	public BrowserType getBrowserType() {
		return BrowserType.valueOf(prop.getProperty("Browsertype"));
	}
	
	public String getUrl() {
		return prop.getProperty("applicationurl");
	}
	
	public String getEmail() {
		return prop.getProperty("email");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}
}
