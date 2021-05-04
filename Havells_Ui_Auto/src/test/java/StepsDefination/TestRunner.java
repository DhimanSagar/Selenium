package StepsDefination;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:Features/GoogleSearch.feature",
glue= {"classpath:StepsDefination"},
monochrome= true, 
plugin = {"pretty", "html:target/HtmlReports","json:target/JSONReports/report.json","junit:target/JUNITReports/report.xml"}

)
public class TestRunner {

}
