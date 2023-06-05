package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags =  "@playlist",
         features = "src/test/resources/Features/",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failedtestcasesrerun.txt",
                "html:target/cucumber-reports/output.html",
                "json:target/json-report/cucumber.json"},
        monochrome = true,
        publish = true,
        glue = "StepDefinition")


public class TestRunCucumberIT extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}