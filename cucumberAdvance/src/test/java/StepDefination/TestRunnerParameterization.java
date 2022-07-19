package StepDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/paramerterization.feature", glue = {
		"StepDefination" }, monochrome = true, plugin = { "pretty", "html:reports/htmlReport/html",
				"json:Reports/JsonReportPara/Cucumber.json", "junit:Reports/JunitReportPara/report.xml" })

public class TestRunnerParameterization {

}