package StepsDefination;


import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import Lib.ExeclDataConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class SingleProduct {
	
	public static WebDriver driver=null;
	public static ExeclDataConfig excel = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	SingleProduct() throws IOException{
		ExeclDataConfig excel = new ExeclDataConfig("D:\\Excel Data\\TestData.xlsx");
		//System.out.println(excel.getData(0,5,1));	
		
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome90\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		   Map<String, Object> prefs = new HashMap<String, Object>();
		   prefs.put("profile.default_content_setting_values.notifications",1);
		   options.setExperimentalOption("prefs", prefs);
		   WebDriver driver = new ChromeDriver(options);
		
	}
	 	

		@Given("User is on home page")
		public void user_is_on_home_page() throws IOException 
		{
				driver.get("https://shoppoc.havells.com");
				driver.manage().window().maximize();
		}

		@When("click on the product from image")
		public void click_on_the_product_from_image() throws InterruptedException {
			driver.findElement(By.cssSelector(".slick-current > .category_thumb")).click();
			driver.findElement(By.cssSelector(":nth-child(6) > .other_details > a.btn")).click();
			driver.findElement(By.cssSelector("#zipcode")).sendKeys(excel.getData(0,2,1));
			driver.findElement(By.cssSelector(".pinCheck")).click();
			
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(3000);
		    driver.findElement(By.xpath("//a[contains(@title,'Go to Home Page')]")).click();
		     driver.findElement(By.cssSelector("[data-slick-index=\"2\"] > .category_thumb")).click();
		     driver.findElement(By.xpath("//a[contains(text(),'Split Air Conditioner 1.5 (GLS18I56HAWA)')]")).click();
		     driver.findElement(By.xpath("//input[contains(@id,'zipcode')]")).sendKeys(excel.getData(0,6,1));
		     		}

		@And("redirect to product details page")
		public void redirect_to_product_details_page() throws InterruptedException {
			 driver.findElement(By.xpath("//button[contains(text(),'Check')]")).click();
		     driver.findElement(By.xpath("//input[contains(@id,'zipcode')]")).clear();
		     driver.findElement(By.xpath("//input[contains(@id,'zipcode')]")).sendKeys(excel.getData(0,2,1));
		     driver.findElement(By.xpath("//button[contains(text(),'Check')]")).click();
		     Thread.sleep(3000);
		     
		     
		     driver.findElement(By.xpath("//body/section[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]")).click();
		     driver.findElement(By.cssSelector("#zipcode")).sendKeys(excel.getData(0,2,1));
		     driver.findElement(By.cssSelector("#addtocart_pincode > .btn")).click();
		     Thread.sleep(3000);
		     
		     Alert alert = driver.switchTo().alert(); 
		     String alertMessage= alert.getText(); 
		     alert.accept();
		     System.out.println("Alert msg is : "+alertMessage);
		}
			@And("Product is getting add to cart")
			public void Product_is_getting_add_to_cart() throws InterruptedException {
				 driver.navigate().refresh();
			     Thread.sleep(3000);
			   
			     driver.findElement(By.xpath("//img[contains(@src,'cart.jpg')]")).click();
			     driver.findElement(By.cssSelector(".proceede_btn > .btn")).click();
			    
		}

			@And("User signin with OTP")
			public void User_signin_with_OTP() throws InterruptedException {
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
			     js.executeScript("arguments[0].scrollIntoView(true);",ScrollRadio);
			  
			     System.out.println("radio Button will be select in next steps");
			     Thread.sleep(13000);
			     WebElement PayURadio = driver.findElement(By.xpath("//label[contains(text(),'PayU Biz')]"));
			     PayURadio.click();
			     
			     System.out.println("radio Button is selected correctly");
			     Thread.sleep(3000);
			     driver.findElement(By.xpath("//div[contains(@id,'payment-buttons-container')]/button[@type='button']")).click();
			
			     Thread.sleep(3000);
			     driver.findElement(By.xpath("//div[contains(@id,'review-buttons-container')]/button[@type='submit'] ")).click();
			     Thread.sleep(13000);		
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
		public void able_to_buy_the_product() {
			System.out.println("User is succesfully placed the order");
		   // throw new PendingException();
		}
		@And("Select the Quantity")
		public void Select_the_Quantity() {
		System.out.println("Print Select the Quantity");
		}
	}

