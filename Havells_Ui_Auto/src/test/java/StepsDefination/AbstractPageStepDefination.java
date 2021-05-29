package StepsDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;



public class AbstractPageStepDefination {
	
	Scenario scn;
	private static WebDriver driver;
 
	public static WebDriver getDriver() {
		if(driver == null) {
			System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/Automation/Havells-UI-Auto/Havells_Ui_Auto/src/test/resources/Driver/chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		return driver;
	}
	
		}
	


