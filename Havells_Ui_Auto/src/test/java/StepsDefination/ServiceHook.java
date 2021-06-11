package StepsDefination;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;


public class ServiceHook extends AbstractPageStepDefination {
	public WebDriver driver;
	
	@After(order = 1)
	public void teardown(Scenario scenario) throws InterruptedException, IOException{
		driver = super.getDriver();
	
    Thread.sleep(2000);
    if (scenario.isFailed()) {
           try {
               String screenshotName = scenario.getName().replaceAll(" ", "_"); 
               byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            File screenshot_with_scenario_name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
            FileUtils.copyFile(screenshot_with_scenario_name, new File("C:\\Users\\admin\\Desktop\\Automation\\Havells-UI-Auto\\Havells_Ui_Auto\\target\\Screenshot" + screenshotName + ".png"));
          
            System.out.println("testing pring the screenshot" + screenshotName);              

          File destinationPath = new File("C:\\Users\\admin\\Desktop\\Automation\\Havells-UI-Auto\\Havells_Ui_Auto\\target\\Screenshot" + screenshotName + ".png");
              
 //Copy taken screenshot from source location to destination location
            Files.copy(screenshot_with_scenario_name.toPath(), destinationPath.toPath()); 

        Reporter.addScreenCaptureFromPath(destinationPath.toString());
            Reporter.addScenarioLog(screenshotName);
            
            scenario.embed(screenshot, "image/png");
   
           } catch (IOException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
           }}}}
          