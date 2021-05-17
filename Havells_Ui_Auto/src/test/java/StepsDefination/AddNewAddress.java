package StepsDefination;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
		driver.findElement(By.xpath("//a[contains(.,'Add New Address')]")).click();
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("//input[contains(@id,'billing:firstname')]")).clear();
	     driver.findElement(By.xpath("//input[contains(@id,'billing:firstname')]")).sendKeys(excel.getData(0,11,1));
	  
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//input[contains(@id,'billing:lastname')]")).clear();
	     driver.findElement(By.xpath("//input[contains(@id,'billing:lastname')]")).sendKeys(excel.getData(0,12,1));
	     
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//input[contains(@id,'billing:telephone')]")).clear();
	     driver.findElement(By.xpath("//input[contains(@id,'billing:telephone')]")).sendKeys(excel.getData(0,13,1));
	   
	     driver.findElement(By.xpath("//input[contains(@id,'billing:post')]")).clear();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//input[contains(@id,'billing:post')]")).sendKeys(excel.getData(0,14,1));
	     
	     driver.findElement(By.xpath("//input[contains(@title,'City')]")).clear();
	     driver.findElement(By.xpath("//input[contains(@title,'City')]")).sendKeys(excel.getData(0,15,1));
	     
	     driver.findElement(By.xpath("//input[contains(@id,'billing:street1')]")).clear();
	     driver.findElement(By.xpath("//input[contains(@id,'billing:street1')]")).sendKeys(excel.getData(0,16,1));
	
	
	     WebElement Country = driver.findElement(By.xpath("//select[contains(@id,'billing:region_id')]")); 
	     Select dropdown = new Select(Country);
	     dropdown.selectByValue("518");
	     System.out.println(dropdown.getFirstSelectedOption().getText());
	     
	}
	
	@And("User Select the Details")
	public void User_Select_the_Details() throws InterruptedException 
	{
		
		driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']")).click();
		Thread.sleep(3000);
     
		WebElement ScrollRadio = driver.findElement(By.xpath("//label[contains(text(),'PayU Biz')]")); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",ScrollRadio);
  
		System.out.println("radio Button will be select in next steps");
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		WebElement PayURadio = driver.findElement(By.xpath("//label[contains(text(),'PayU Biz')]"));
		PayURadio.click();
		
		System.out.println("radio Button is selected correctly");
     	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
     	driver.findElement(By.xpath("//div[contains(@id,'payment-buttons-container')]/button[@type='button']")).click();

     	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
     	driver.findElement(By.xpath("//div[contains(@id,'review-buttons-container')]/button[@type='submit'] ")).click();
     	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
	}
	@And("User click on Save in address book Checkbox")
	public void User_click_on_Save_in_address_book_Checkbox() throws InterruptedException 
	{
		driver.findElement(By.xpath(" //input[contains(@id,'billing:save_in_address_book')]")).click();
	     Thread.sleep(3000);
	}
	
	@Then("user is able to add address in address book")
	public void user_is_able_to_add_address_in_address_book() throws InterruptedException 
	{
		 driver.findElement(By.xpath("//button[contains(text(),'Save & Continue')]")).click();
	}

	@Then("User select the Ship to different address")
	public void User_select_the_Ship_to_different_address() throws InterruptedException 
	{
	  	JavascriptExecutor js = (JavascriptExecutor) driver;
	  	WebElement Shipdiff = driver.findElement(By.xpath("//input[@id='billing:use_for_shipping_no']"));   
	  	js.executeScript("arguments[0].scrollIntoView(true);",Shipdiff);
	  
	  	System.out.println("Ship to next address Button will be select in next steps");
	    Thread.sleep(10000);
	    WebElement Shipdifferent = driver.findElement(By.xpath("//input[@id='billing:use_for_shipping_no']"));
	    Shipdifferent.click();
	    Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@id,'billing-buttons-container')][contains(.,'Continue')]")).click();
        Thread.sleep(3000);
	}
	

}
