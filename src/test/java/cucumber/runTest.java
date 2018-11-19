package cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "steps", //place were steps are defined
        plugin = {"pretty", "html:target/html/", "json:target/cucumber-report/cucumber.json"},
        features = {"src/test/java/features"},
        tags = {"@SmokeTest"}) //place where features located, it can be "classpath:features/annotation.feature"

public class runTest { }