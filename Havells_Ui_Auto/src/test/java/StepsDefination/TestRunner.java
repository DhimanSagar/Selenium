package StepsDefination;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

		@RunWith(Cucumber.class)
		@CucumberOptions(features = "classpath:Features",
		glue= {"classpath:StepsDefination"},
		//tags= "@Smoke",
		monochrome= true, 
		plugin = {
				"pretty", "html:target/HtmlReports",
				"json:target/JSONReports/report.json",
				"junit:target/JUNITReports/report.xml",
				//"de.monochromata.cucumber.report.PrettyReports:target/MavenCucumberReport"
				}
		)
		public class TestRunner {
				}
		
