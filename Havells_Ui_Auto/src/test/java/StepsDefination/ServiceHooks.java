package StepsDefination;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServiceHooks extends AbstractPageStepDefination {
	WebDriver driver;
	
	@After()
	public void takeSrcnshotOnFailure(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
	TakesScreenshot scrnShot = (TakesScreenshot) driver;
	byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
    scenario.embed(data, "image/png");	
	
		}
	}
	@After(order = 0)
	public void tearDown() {
		driver.close();
	}
}
