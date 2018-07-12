package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import infra.WebdriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class commonSteps {
    @Before
    public void setUp(){
            WebdriverHelper.getInstance();
    }
    @After
    public void cleanUp(){
        WebdriverHelper.closeDriver();
    }
}
