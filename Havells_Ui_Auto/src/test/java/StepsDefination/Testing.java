package StepsDefination;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Testing {
public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		
		//ExcelDataconfig excel = new ExcelDataconfig("D:\\Excel Data\\TestData.xlsx");
		//System.out.println(excel.getData(0,5,1));	
		
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome90\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		   Map<String, Object> prefs = new HashMap<String, Object>();
		   prefs.put("profile.default_content_setting_values.notifications",1);
		   options.setExperimentalOption("prefs", prefs);
		   WebDriver driver = new ChromeDriver(options);
		
			driver.get("https://shoppoc.havells.com");
			driver.manage().window().maximize();
			List<WebElement> totalFrames = driver.findElements(By.xpath("//body/div[6]/section[1]/div[1]/div[1]/div[1]"));
			System.out.println("Total frame:-" + totalFrames.size());
			
}}
