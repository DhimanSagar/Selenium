package StepsDefination;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Lib.Constants;
import Lib.ExeclDataConfig;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AddNewAddress extends AbstractPageStepDefination {
	
	public WebDriver driver;
	ExeclDataConfig excel;
	
	public AddNewAddress() throws IOException {
		driver = super.getDriver();
		excel = new ExeclDataConfig("D:\\Excel Data\\TestData.xlsx");
	}

	
	@When("User Add new Address")
	public void User_Add_new_Address() throws InterruptedException
	{
		 driver.findElement(Constants.AddNewAddress).click();
	     Thread.sleep(5000);
	     driver.findElement(Constants.NewUserFirstName).clear();
	     driver.findElement(Constants.NewUserFirstName).sendKeys(excel.getData(0,11,1));
	  
	     Thread.sleep(3000);
	     driver.findElement(Constants.NewUserLastName).clear();
	     driver.findElement(Constants.NewUserLastName).sendKeys(excel.getData(0,12,1));
	     
	     Thread.sleep(3000);
	     driver.findElement(Constants.NewUserPhone).clear();
	     driver.findElement(Constants.NewUserPhone).sendKeys(excel.getData(0,13,1));
	   
	     driver.findElement(Constants.NewUserZipcode).clear();
	     Thread.sleep(3000);
	     driver.findElement(Constants.NewUserZipcode).sendKeys(excel.getData(0,14,1));
	     
	     driver.findElement(Constants.NewUserCity).clear();
	     driver.findElement(Constants.NewUserCity).sendKeys(excel.getData(0,15,1));
	     
	     driver.findElement(Constants.NewUserAddress).clear();
	     driver.findElement(Constants.NewUserAddress).sendKeys(excel.getData(0,16,1));
	
	
	     WebElement Country = driver.findElement(Constants.NewUserCountry); 
	     Select dropdown = new Select(Country);
	     dropdown.selectByValue("518");
	     System.out.println(dropdown.getFirstSelectedOption().getText());
	     
	}
	
	@And("User Select the Details")
	public void User_Select_the_Details() throws InterruptedException 
	{
		
		driver.findElement(Constants.ShippingMethod).click();
		Thread.sleep(3000);
     
		WebElement ScrollRadio = driver.findElement(Constants.PayUBizRadioButton); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",ScrollRadio);
  
		System.out.println("radio Button will be select in next steps");
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		WebElement PayURadio = driver.findElement(Constants.PayUBizRadioButton);
		PayURadio.click();
		
		System.out.println("radio Button is selected correctly");
     	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
     	driver.findElement(Constants.PayMent_Information_Save).click();

     	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
     	driver.findElement(Constants.CHECKOUT_LAST).click();
     	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
	}
	@And("User click on Save in address book Checkbox")
	public void User_click_on_Save_in_address_book_Checkbox() throws InterruptedException 
	{
		driver.findElement(Constants.NewUserSaveAddress).click();
	     Thread.sleep(3000);
	}
	
	@Then("user is able to add address in address book")
	public void user_is_able_to_add_address_in_address_book() throws InterruptedException 
	{
		 driver.findElement(Constants.NewAdressSave).click();
	}

	@Then("User select the Ship to different address")
	public void User_select_the_Ship_to_different_address() throws InterruptedException 
	{
	  	JavascriptExecutor js = (JavascriptExecutor) driver;
	  	WebElement Shipdiff = driver.findElement(Constants.ShiptoDifferent);   
	  	js.executeScript("arguments[0].scrollIntoView(true);",Shipdiff);
	  
	  	System.out.println("Ship to next address Button will be select in next steps");
	    Thread.sleep(10000);
	    WebElement Shipdifferent = driver.findElement(Constants.ShiptoDifferent);
	    Shipdifferent.click();
	    Thread.sleep(2000);
        driver.findElement(Constants.Billing_Address_Continue).click();
        Thread.sleep(3000);
	
}
 
}
