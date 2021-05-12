package StepsDefination;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import Lib.ExeclDataConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

public class SingleProduct {
	
	ExeclDataConfig excel;
	WebDriver driver;
	   
	public SingleProduct() throws IOException {
		excel = new ExeclDataConfig("D:\\Excel Data\\TestData.xlsx");
		System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/Automation/Havells-UI-Auto/Havells_Ui_Auto/src/test/resources/Driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		  Map<String, Object> prefs = new HashMap<String, Object>();
		  prefs.put("profile.default_content_setting_values.notifications",1);
		  options.setExperimentalOption("prefs", prefs);
		  driver = new ChromeDriver(options); 
	}
		@Given("User is on home page")
		public void user_is_on_home_page() throws IOException 
		{
			   System.setProperty("webdriver.chrome.driver","C:/Users/admin/Desktop/Automation/Havells-UI-Auto/Havells_Ui_Auto/src/test/resources/Driver/chromedriver.exe");
			   driver = new ChromeDriver();
			   driver.get("https://shoppoc.havells.com");
		       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		       driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		       System.out.println("outside Browser is open");
			   driver.manage().window().maximize();
		}

		@When("click on the product from image")
		public void click_on_the_product_from_image() throws InterruptedException {
			driver.findElement(By.cssSelector("[data-slick-index=\"2\"] > .category_thumb")).click();
			driver.findElement(By.xpath("//a[contains(text(),' Split Air Conditioner 1.5 (GLS18I52WBEL)')]")).click();
			//driver.findElement(By.cssSelector(".slick-current > .category_thumb")).click();
			//driver.findElement(By.cssSelector(":nth-child(6) > .other_details > a.btn")).click();
			//driver.findElement(By.cssSelector("#zipcode")).sendKeys(excel.getData(0,2,1));
			//System.out.println(excel.getData(0,2,1));

			//driver.findElement(By.cssSelector(".pinCheck")).click();
			//System.out.println(driver.findElement(By.xpath("//div[contains(@id,'result')]")).getText());
			Thread.sleep(3000);
			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		    //driver.findElement(By.xpath("//a[contains(@title,'Go to Home Page')]")).click();
		    
		     		}

		@And("redirect to products details page")
		public void redirect_to_product_details_page() throws InterruptedException {
			 driver.findElement(By.xpath("//input[contains(@id,'zipcode')]")).sendKeys(excel.getData(0,6,1));
			 driver.findElement(By.xpath("//button[contains(text(),'Check')]")).click();
		     driver.findElement(By.xpath("//input[contains(@id,'zipcode')]")).clear();
		     driver.findElement(By.xpath("//input[contains(@id,'zipcode')]")).sendKeys(excel.getData(0,2,1));
		     driver.findElement(By.xpath("//button[contains(text(),'Check')]")).click();
		     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		     
		     
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
				 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			   
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
		public void able_to_buy_the_product() {
			System.out.println("User is succesfully placed the order");
		   // throw new PendingException();
		}
			
		@When("click on the Subcategory of product")
		public void click_on_the_Subcategory_of_product() throws InterruptedException {
		 WebElement btnmenu = driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[4]/nav[1]/ul[1]/li[3]/a[1]"));
		 Actions action = new Actions(driver);
		    String btnbordercolor = btnmenu.getCssValue("border-button");
		    System.out.println("Before mouse hover"+btnbordercolor);
		    action.moveToElement(btnmenu).perform();
		    String btnbordercolorAfter = btnmenu.getCssValue("border-button");
		    System.out.println("Before mouse hover"+btnbordercolorAfter);
		    Thread.sleep(3000);
		    
		 WebElement btmCat = driver.findElement(By.xpath("//a[contains(text(),'Table Fans')]"));
		 List<WebElement> anchorTags = btmCat.findElements(By.tagName("a"));
		 System.out.println("Number of elements in the Subcategory:="+anchorTags.size());
		 
		 for(WebElement menu: anchorTags) {
			 if(menu.getText().equals("Table Fans")) {
				 menu.click();
				 break;
			 }
		 }}
		 

@When("Select the product from dropdown")
public void select_the_product_from_dropdown() throws InterruptedException {
	driver.findElement(By.xpath("//input[@id='search']")).sendKeys("aur");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
  
}

@Given("User is on the My account")
public void User_is_on_the_My_account () {
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
	List<WebElement> anchorTags = Myacc.findElements(By.tagName("a"));
	System.out.println("Number of elements in the Subcategory:="+anchorTags.size());
	
	for(WebElement User: anchorTags)
	{
		 if(User.getText().equals("My Account"))
		 {
			 User.click();
			 break;
		 
}}}
	@And("Click on product name")
	public void Click_on_product_name () {
	driver.findElement(By.xpath("//a[contains(text(),'View Details')]")).click();
}}