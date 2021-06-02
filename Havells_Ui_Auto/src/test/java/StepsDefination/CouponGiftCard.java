package StepsDefination;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Lib.Constants;
import Lib.ExeclDataConfig;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class CouponGiftCard extends AbstractPageStepDefination {
		
		public WebDriver driver;
		ExeclDataConfig excel;
		
		public CouponGiftCard() throws IOException {
			driver = super.getDriver();
			excel = new ExeclDataConfig("D:\\Excel Data\\TestData.xlsx");
		}
		
		@When("User add the coupon")
		public void When_User_add_the_coupon() throws InterruptedException
		{
			Thread.sleep(2000);
			 driver.findElement(Constants.Coupon).sendKeys(excel.getData(0,4,1));
		     driver.findElement(Constants.ApplyCoupon).click();
		     System.out.println("Coupon is added:- "+ excel.getData(0,4,1));
		     System.out.println(driver.findElement(By.className("saving_info")).getText());
		}
		
		@When("User add the Gift certificate")
		public void User_add_the_Gift_certificate() throws InterruptedException
		{
			 driver.findElement(Constants.Gift).sendKeys(excel.getData(0,5,1));
		     driver.findElement(Constants.ApplyGift).click();
		     System.out.println("GiftCard is added:- "+ excel.getData(0,5,1));
		     }
		
		@And("Browser close")
		public void Browser_close() throws InterruptedException
		{
		   Thread.sleep(2000);
		   driver.close();
		   System.out.println("Browser is closed");
		}
		 @After("@browser")
			public void tearDown(Scenario scenario) {
			    if (scenario.isFailed()) {
			    	
			       final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			       scenario.embed(screenshot, "image/png"); //stick it in the report
			       System.out.println(scenario.getName());
			    }
			    driver.close();     
}
}

