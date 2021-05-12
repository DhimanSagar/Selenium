package StepsDefination;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:Features/GoogleSearch.feature",
glue= {"classpath:StepsDefination"},
monochrome= true, 
plugin = {"pretty", "html:target/HtmlReports","json:target/JSONReports/report.json","junit:target/JUNITReports/report.xml"}

)
public class TestRunner {

}
