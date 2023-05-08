package helper;

import java.sql.Connection;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DatabaseHelper {
	
	private WebDriver driver;
	
	private Logger log=LoggerHelper.getLogger(DatabaseHelper.class);
	
	
	private static String url="";
	private static String username="";
	private static String paasword="";
    private static Connection  connection;
    
    
    

}
