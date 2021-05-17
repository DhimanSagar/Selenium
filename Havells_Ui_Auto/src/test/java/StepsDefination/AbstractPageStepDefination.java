package StepsDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AbstractPageStepDefination {
	
	private static WebDriver driver;
   // private static ChromeOptions options;
   // private static Map<String, Object> prefs;
	public static WebDriver getDriver() {
		if(driver == null) {
			System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/Automation/Havells-UI-Auto/Havells_Ui_Auto/src/test/resources/Driver/chromedriver.exe");
//			options = new ChromeOptions();
//		    prefs = new HashMap<String, Object>();
//			prefs.put("profile.default_content_setting_values.notifications",1);
//			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(); 
		}
		return driver;
	}
}

