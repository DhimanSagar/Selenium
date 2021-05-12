package StepsDefination;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;


public class GooglesSearchSteps {

	WebDriver driver;
	@Given("^Browser is open$")
	public void browser_is_open() {
		 System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/Automation/Havells-UI-Auto/Havells_Ui_Auto/src/test/resources/Driver/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.freecrm.com/index.html");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	    System.out.println("outside Browser is open");
	}

	@And("User is on google search")
	public void user_is_on_google_search() {
		   System.out.println("User is on google search");
	    
	}

	@When("User enter a text in search box")
	public void user_enter_a_text_in_search_box() {
		 System.out.println("User enter a text in search box");
	  
	}

	@And("hit enter")
	public void hit_enter() {
	 System.out.println("User enter a text in search box");
	
	}

	@Then("User navigate to search page")
	public void user_navigate_to_search_page() {
		 System.out.println("User enter a text in search box");
	   
	}

}
