package cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "steps", //place were steps are defined
        format = {"pretty", "html:target/cucumber"},
        features = {"src/test/java/features"}) //place where features located, it can be "classpath:features/annotation.feature"

public class runTest { }