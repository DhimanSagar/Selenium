package StepsDefination;

import java.io.IOException; 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Lib.ExeclDataConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;

public class SingleProduct extends AbstractPageStepDefination {
	WebDriver driver;
	ExeclDataConfig excel;
	
	public SingleProduct() throws IOException 
		{
		excel = new ExeclDataConfig("D:\\Excel Data\\TestData.xlsx");
     	System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/Automation/Havells-UI-Auto/Havells_Ui_Auto/src/test/resources/Driver/chromedriver.exe");
     	
		}
		
		@Given("User is on home page")
		public void user_is_on_home_page() throws IOException 
			{
			    driver = super.getDriver();
				//driver = new ChromeDriver();	
				driver.get("https://shoppoc.havells.com");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
				driver.manage().window().maximize();
				//List<WebElement> totalFrames = driver.findElements(By.xpath("//body/div[6]/section[1]/div[1]/div[1]/div[1]"));
				//System.out.println("Total frame:-" + totalFrames.size());
			}

		@When("click on the product from image")
		public void click_on_the_product_from_image() throws InterruptedException
			{
				driver.findElement(By.cssSelector("[data-slick-index=\"2\"] > .category_thumb")).click();
				driver.findElement(By.xpath("//a[contains(text(),' Split Air Conditioner 1.5 (GLS18I52WBEL)')]")).click();
				Thread.sleep(3000);
		    }

		@And("redirect to products details page")
		public void redirect_to_product_details_page() throws InterruptedException
			{
			 driver.findElement(By.xpath("//input[contains(@id,'zipcode')]")).sendKeys(excel.getData(0,6,1));
			 driver.findElement(By.xpath("//button[contains(text(),'Check')]")).click();
			 Thread.sleep(2000);
		     driver.findElement(By.xpath("//input[contains(@id,'zipcode')]")).clear();
		     Thread.sleep(3000);
		     driver.findElement(By.xpath("//input[contains(@id,'zipcode')]")).sendKeys(excel.getData(0,2,1));
		     Thread.sleep(2000);
		     driver.findElement(By.xpath("//button[contains(text(),'Check')]")).click();
		     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		     
		     Thread.sleep(3000);
		     driver.findElement(By.xpath("//body/section[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]")).click();
		     driver.findElement(By.cssSelector("#zipcode")).clear();
		     driver.findElement(By.cssSelector("#zipcode")).sendKeys(excel.getData(0,2,1));
		     driver.findElement(By.cssSelector("#addtocart_pincode > .btn")).click();
		     Thread.sleep(3000);
		     
		     Alert alert = driver.switchTo().alert(); 
		     String alertMessage= alert.getText(); 
		     alert.accept();
		     System.out.println("Alert msg is : "+alertMessage);
		     driver.navigate().refresh();
		     
				}
			@And("Product is getting add to cart")
			public void Product_is_getting_add_to_cart() throws InterruptedException 
			{
//				 driver.navigate().refresh();
//				 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				 Thread.sleep(3000);
			     driver.findElement(By.xpath("//img[contains(@src,'cart.jpg')]")).click();
			     //
			}
			@And("User Click checkout")
			public void User_Click_checkout() throws InterruptedException
			{
			driver.findElement(By.cssSelector(".proceede_btn > .btn")).click();	
			}
			
			@And("User signin with OTP")
			public void User_signin_with_OTP() throws InterruptedException
			{
					
					driver.findElement(By.cssSelector("#mobile")).sendKeys(excel.getData(0,13,1));
					driver.findElement(By.cssSelector("#get_otp")).click();
					Thread.sleep(25000);
					driver.findElement(By.cssSelector("#login_otp")).click();
					Thread.sleep(3000);	
			}
			
			@And("User Enter the Details")
			public void User_Enter_the_Details() throws InterruptedException {
				
					driver.findElement(By.xpath("//div[contains(@id,'billing-buttons-container')][contains(.,'Continue')]")).click();
					Thread.sleep(3000);
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
		
			@And("User enter the payment details")
			public void User_enter_the_payment_details()
			{
				 driver.findElement(By.xpath("//input[contains(@name,'ccard_number')]")).sendKeys("5123");
			     driver.findElement(By.xpath("//input[contains(@name,'ccard_number')]")).sendKeys("4567");
			     driver.findElement(By.xpath("//input[contains(@name,'ccard_number')]")).sendKeys("8901");
			     driver.findElement(By.xpath("//input[contains(@name,'ccard_number')]")).sendKeys("2346");
			     // CC name
			     driver.findElement(By.xpath("//input[contains(@name,'cname_on_card')]")).sendKeys("Sagar Kumar");
			     
			     driver.findElement(By.xpath("//input[contains(@name,'ccvv_number')]")).sendKeys("123");
			    
			     WebElement MM = driver.findElement(By.xpath("//select[contains(@id,'cexpiry_date_month')]")); 
			     Select dropdown = new Select(MM);
			     dropdown.selectByValue("12");
			     System.out.println(dropdown.getFirstSelectedOption().getText());
			     
			     WebElement YY = driver.findElement(By.xpath("//select[contains(@id,'cexpiry_date_year')]")); 
			     Select dropdown1 = new Select(YY);
			     dropdown1.selectByValue("2029");
			     System.out.println(dropdown1.getFirstSelectedOption().getText());
			     driver.findElement(By.xpath("//input[contains(@name,'pay_button')]")).click();
			     driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("123456");
			     driver.findElement(By.xpath(" //input[contains(@id,'submitBtn')]")).click();
			     System.out.println(driver.findElement(By.xpath("//div[contains(@class,'success_box')]")).getText());  
			}
			
		@Then("able to buy the product")
		public void able_to_buy_the_product() 
		{
			System.out.println("User is succesfully placed the order");
		   // throw new PendingException();
		}
			
		@When("click on the Subcategory of product")
		public void click_on_the_Subcategory_of_product() throws InterruptedException {
			WebElement btnmenu = driver.findElement(By.xpath(" //a[contains(text(),'Switches')]"));
			Actions action = new Actions(driver);
		    action.moveToElement(btnmenu).perform();
		    Thread.sleep(3000);
		    WebElement btnCat = driver.findElement(By.xpath("//a[contains(text(),'Accessories')]"));
		    btnCat.click();
		    driver.findElement(By.xpath("//img[contains(@src,'0_287_3_7594.jpg')]")).click(); 
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

			@When("Select the product from dropdown")
			public void select_the_product_from_dropdown() throws InterruptedException
			{
				driver.findElement(By.xpath("//input[@id='search']")).sendKeys("aur");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ARROW_DOWN);
				driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
				driver.findElement(By.xpath("//img[contains(@alt,\"Aureus\")]")).click();
				driver.findElement(By.xpath("//body/section[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]")).click();
				driver.findElement(By.cssSelector("#zipcode")).clear();
				driver.findElement(By.cssSelector("#zipcode")).sendKeys(excel.getData(0,2,1));
			    driver.findElement(By.cssSelector("#addtocart_pincode > .btn")).click();
			    Thread.sleep(2000);
			    Alert alert = driver.switchTo().alert(); 
			     String alertMessage= alert.getText(); 
			     alert.accept();
			     System.out.println("Alert msg is : "+alertMessage);
			  
			}

			@Given("User is on the My account")
			public void User_is_on_the_My_account () 
			{
				System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/Automation/Havells-UI-Auto/Havells_Ui_Auto/src/test/resources/Driver/chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("https://shoppoc.havells.com");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
				System.out.println("outside Browser is open");
				driver.manage().window().maximize();
				WebElement account = driver.findElement(By.xpath("//img[contains(@src,'account.jpg')]"));
				Actions action = new Actions(driver);
				action.moveToElement(account).perform();
				WebElement Myacc = driver.findElement(By.xpath("//a[contains(text(),'Account')]"));
				Myacc.click();
			}
			
			@And("Click on product name")
			public void Click_on_product_name () 
			{
			driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
		}}