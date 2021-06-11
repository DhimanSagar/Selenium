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

import Lib.Constants;
import Lib.ExeclDataConfig;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
				driver.findElement(Constants.ITEM_TITLE).click();
				driver.findElement(Constants.LLOYD_PORDUCT).click();
				Thread.sleep(3000);
		    }

		@And("redirect to products details page")
		public void redirect_to_product_details_page() throws InterruptedException
			{
			 driver.findElement(Constants.ZIPCODE).sendKeys(excel.getData(0,6,1));
			 driver.findElement(Constants.CHECK_PINCODE).click();
			 Thread.sleep(2000);
		     driver.findElement(Constants.ZIPCODE).clear();
		     Thread.sleep(3000);
		     driver.findElement(Constants.ZIPCODE).sendKeys(excel.getData(0,2,1));
		     Thread.sleep(2000);
		     driver.findElement(Constants.CHECK_PINCODE).click();
		     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		     
		     Thread.sleep(3000);
		     driver.findElement(Constants.ADDToCART).click();
		     driver.findElement(Constants.POPUP_ZIPCODE).clear();
		     driver.findElement(Constants.POPUP_ZIPCODE).sendKeys(excel.getData(0,2,1));
		     driver.findElement(Constants.ATC_POPUP).click();
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
			     driver.findElement(Constants.ATC_Icon).click();
			     //
			}
			@And("User Click checkout")
			public void User_Click_checkout() throws InterruptedException
			{
			driver.findElement(Constants.CHECKOUT).click();	
			}
			
			@And("User signin with OTP")
			public void User_signin_with_OTP() throws InterruptedException
			{
					
					driver.findElement(Constants.Mobile_Number).sendKeys(excel.getData(0,13,1));
					driver.findElement(Constants.Send_OTP).click();
					Thread.sleep(25000);
					driver.findElement(Constants.LOGIN_OTP).click();
					Thread.sleep(3000);	
			}
			
			@And("User Enter the Details")
			public void User_Enter_the_Details() throws InterruptedException {
				
					driver.findElement(Constants.Billing_Address_Continue).click();
					Thread.sleep(3000);
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
		
			@And("User enter the payment details")
			public void User_enter_the_payment_details()
			{
				 driver.findElement(Constants.CardNumber).sendKeys("5123");
			     driver.findElement(Constants.CardNumber).sendKeys("4567");
			     driver.findElement(Constants.CardNumber).sendKeys("8901");
			     driver.findElement(Constants.CardNumber).sendKeys("2346");
			     // CC name
			     driver.findElement(Constants.CardName).sendKeys("Sagar Kumar");
			     
			     driver.findElement(Constants.CVVNumber).sendKeys("123");
			    
			     WebElement MM = driver.findElement(Constants.CardMonth);
			     Select dropdown = new Select(MM);
			     dropdown.selectByValue("12");
			     System.out.println(dropdown.getFirstSelectedOption().getText());
			     
			     WebElement YY = driver.findElement(Constants.CardYear); 
			     Select dropdown1 = new Select(YY);
			     dropdown1.selectByValue("2029");
			     System.out.println(dropdown1.getFirstSelectedOption().getText());
			     driver.findElement(By.xpath("//input[contains(@name,'pay_button')]")).click();
			     driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("123456");
			     driver.findElement(By.xpath(" //input[contains(@id,'submitBtn')]")).click();
			     System.out.println(driver.findElement(Constants.Booked).getText());  
			}
			
		@Then("able to buy the product")
		public void able_to_buy_the_product() 
		{
			System.out.println("User is succesfully placed the order");
		   // throw new PendingException();
		}
			
		@When("click on the Subcategory of product")
		public void click_on_the_Subcategory_of_product() throws InterruptedException {
			WebElement btnmenu = driver.findElement(Constants.Switches);
			Actions action = new Actions(driver);
		    action.moveToElement(btnmenu).perform();
		    Thread.sleep(3000);
		    WebElement btnCat = driver.findElement(Constants.Accessories);
		    btnCat.click();
		    driver.findElement(Constants.BidirectionalJumbo).click(); 
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

			@When("Select the product from dropdown")
			public void select_the_product_from_dropdown() throws InterruptedException
			{
				driver.findElement(Constants.SearchBar).sendKeys("aur");
				Thread.sleep(3000);
				driver.findElement(Constants.SearchBar).sendKeys(Keys.ARROW_DOWN);
				driver.findElement(Constants.SearchBar).sendKeys(Keys.ENTER);
				driver.findElement(Constants.Fan_Product).click();
				driver.findElement(Constants.ADDToCART).click();
				driver.findElement(Constants.POPUP_ZIPCODE).clear();
				driver.findElement(Constants.POPUP_ZIPCODE).sendKeys(excel.getData(0,2,1));
			    driver.findElement(Constants.ATC_POPUP).click();
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
				WebElement account = driver.findElement(Constants.ATC_Icon);
				Actions action = new Actions(driver);
				action.moveToElement(account).perform();
				WebElement Myacc = driver.findElement(Constants.MyAccount);
				Myacc.click();
			}
			
			@And("Click on product name")
			public void Click_on_product_name () 
			{
			driver.findElement(Constants.ViewDetails).click();
			
			}
		}