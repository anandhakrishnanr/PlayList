package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"@target/failedtestcasesrerun.txt"},
        glue = "StepDefinition",
        monochrome=true,
        plugin = {
                "timeline:target/test-output-thread",
                "html:target/target1/cucumber-reports/output.html",
                "json:target/target1/json-report/cucumber.json",
                "rerun:target/target1/failedtestcasesrerun.txt",
        }
)
public class TestRunCucumberITFailed extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}
