package StepsDefination;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GooglesSearchSteps {
	
	WebDriver driver = null;
	
	@Given("Browser is open")
	public void browser_is_open() {
		   System.out.println("Inside Browser is open");
		    
		   System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/Automation/Havells-UI-Auto/Havells_Ui_Auto/src/test/resources/Driver2/chromedriver.exe");
		//String ProjectPath = System.getProperty("user. dir");
		//System.out.println("Project Path is : "+ProjectPath);
	     //System.setProperty("webdriver.chrome.driver",ProjectPath+"/test/resources/Driver/chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
	    driver = new ChromeDriver();  
//		ChromeOptions options = new ChromeOptions();
//		   Map<String, Object> prefs = new HashMap<String, Object>();
//		   prefs.put("profile.default_content_setting_values.notifications",1);
//		   options.setExperimentalOption("prefs", prefs);
//		   WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	    System.out.println("outside Browser is open");
	}

	@And("User is on google search")
	public void user_is_on_google_search() {
		   System.out.println("User is on google search");
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enter a text in search box")
	public void user_enter_a_text_in_search_box() {
		 System.out.println("User enter a text in search box");
	    throw new io.cucumber.java.PendingException();
	}

	@And("hit enter")
	public void hit_enter() {
	 System.out.println("User enter a text in search box");
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User navigate to search page")
	public void user_navigate_to_search_page() {
		 System.out.println("User enter a text in search box");
	    throw new io.cucumber.java.PendingException();
	}

}
