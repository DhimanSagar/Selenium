package StepsDefination;
import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


		@RunWith(Cucumber.class)
		@CucumberOptions(features = "classpath:Features",
		glue= {"classpath:StepsDefination"},
		tags= "@testing",
		monochrome= true, 
		plugin = {
				"pretty", 
				"html:target/HtmlReports",
				"json:target/JSONReports/report.json",
				"junit:target/JUNITReports/report.xml",
				"com.cucumber.listener.ExtentCucumberFormatter:target/MavenCucumberReport/ExtentReports/Extent.html",
				"com.cucumber.listener.ExtentCucumberFormatter:target/MavenCucumberReport/PDFReport/Extent.pdf"
				}
		)
		public class TestRunner {
			
			@AfterClass
			public static void setup()
			{
			Reporter.loadXMLConfig(new File("src/test/resources/ConfigReport/extent-config.xml"));
			Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
			Reporter.setSystemInfo("User Name", "Sagar Kumar");
			Reporter.setSystemInfo("Application Name", "Havells");
			Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
			Reporter.setSystemInfo("Environment", "POC");
			Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
		//	Reporter.addScreenCaptureFromPath(C:\\Users\\admin\\Desktop\\Automation\\Havells-UI-Auto\\Havells_Ui_Auto\\target\\Screenshot);
				}}