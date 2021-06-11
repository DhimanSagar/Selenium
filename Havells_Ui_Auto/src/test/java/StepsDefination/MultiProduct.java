 
package StepsDefination;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Lib.Constants;
import Lib.ExeclDataConfig;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class MultiProduct extends AbstractPageStepDefination {
	
	public WebDriver driver;
	ExeclDataConfig excel;
	
	public MultiProduct() throws IOException {
		driver = super.getDriver();
		excel = new ExeclDataConfig("D:\\Excel Data\\TestData.xlsx");
	}
	
	 @When("Select the Quantity")
		public void Select_the_Quantity() throws InterruptedException
	 {
		 	System.out.println("Scroll to Quantity Section");
			WebElement scroll = driver.findElement(By.name("qty"));//u can use By.xpath or By.id here
			Actions actions = new Actions(driver);
			actions.moveToElement(scroll);
			actions.perform(); 
			WebElement Quantity = driver.findElement(Constants.Quantity); 
			Select dropdown = new Select(Quantity);
		    dropdown.selectByValue("3");
		    System.out.println(dropdown.getFirstSelectedOption().getText()); 
	 }
	 
	 @And("click on Home link")
		public void click_on_Home_link() throws InterruptedException
	 {
		 	driver.findElement(By.xpath("//a[contains(@title,\"Go to Home Page\")]")).click();
	 }
	 @And("Select the Another product")
		public void Select_the_Another_product() throws InterruptedException
	 {
		    driver.findElement(Constants.SearchBar).sendKeys("aur");
			Thread.sleep(3000);
			driver.findElement(Constants.SearchBar).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(Constants.SearchBar).sendKeys(Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.findElement(Constants.Fan_Product).click();
			driver.findElement(Constants.ADDToCART).click();
			driver.findElement(Constants.POPUP_ZIPCODE).clear();
			driver.findElement(Constants.POPUP_ZIPCODE).sendKeys(excel.getData(0,2,1));
		    driver.findElement(Constants.ATC_POPUP).click();
		    Thread.sleep(3000);
		    Alert alert = driver.switchTo().alert(); 
		    String alertMessage= alert.getText(); 
		    alert.accept();
		    System.out.println("Alert msg is : "+alertMessage);    	
	  
}
}
  