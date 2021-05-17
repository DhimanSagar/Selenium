
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

import Lib.ExeclDataConfig;
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

			WebElement Quantity = driver.findElement(By.xpath("//select[@id='qty']")); 
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
		    driver.findElement(By.xpath("//input[@id='search']")).sendKeys("aur");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//img[contains(@alt,\"Aureus\")]")).click();
			driver.findElement(By.xpath("//body/section[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]")).click();
			driver.findElement(By.cssSelector("#zipcode")).clear();
			driver.findElement(By.cssSelector("#zipcode")).sendKeys(excel.getData(0,2,1));
		    driver.findElement(By.cssSelector("#addtocart_pincode > .btn")).click();
		    Thread.sleep(3000);
		    
		    Alert alert = driver.switchTo().alert(); 
		     String alertMessage= alert.getText(); 
		     alert.accept();
		     System.out.println("Alert msg is : "+alertMessage);
	 } 

}
  