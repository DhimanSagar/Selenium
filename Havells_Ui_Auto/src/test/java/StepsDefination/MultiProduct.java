
package StepsDefination;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.When;

public class MultiProduct extends AbstractPageStepDefination {
	
	//WebDriver driver = getDriver();
	
	 @When("Select the Quantity")
		public void Select_the_Quantity() throws InterruptedException {
		 Thread.sleep(5000 );
		driver.findElement(By.xpath("//input[contains(@id,'zipcode')]")).sendKeys("247667");
		System.out.println("Moving to MultipleProduct");
		
		Thread.sleep(2000);
		
		WebElement scroll = driver.findElement(By.name("qty"));//u can use By.xpath or By.id here
		Actions actions = new Actions(driver);
		actions.moveToElement(scroll);
		actions.perform();

		System.out.println("Moving to MultipleProduct after scroll");
		WebElement Quantity = driver.findElement(By.xpath("//select[@id='qty']")); 
		Select dropdown = new Select(Quantity);
	    dropdown.selectByValue("3");
	    System.out.println(dropdown.getFirstSelectedOption().getText());
	   
		Thread.sleep(3000);
	    
	 }}
  