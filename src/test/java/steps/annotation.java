package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import infra.WebdriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class annotation {
    DesiredCapabilities capabilities = new DesiredCapabilities();

//    @Before
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//    }

//    @Before
//    public void setUp(){
//        capabilities.setBrowserName("chrome");
//        try {
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }

//    @After
//    public void afterScenario(Scenario scenario) {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }

    @Given("^I am on Facebook login page$")
    public void goToFacebook() {
        WebdriverHelper.getInstance().navigate().to("https://www.facebook.com/");
    }

    @When("^I enter username as \"(.*)\"$")
    public void enterUsername(String arg1) {
        WebdriverHelper.getInstance().findElement(By.id("email")).sendKeys(arg1);
    }

    @When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void I_enter_Username_as_and_Password_as(String arg1, String arg2) {
        WebdriverHelper.getInstance().findElement(By.id("email")).sendKeys(arg1);
        WebdriverHelper.getInstance().findElement(By.id("pass")).sendKeys(arg2);
        WebdriverHelper.getInstance().findElement(By.id("loginbutton")).click();
    }

    @When ("^I enter password as \"(.*)\"$")
    public void enterPassword(String arg1) {
        WebdriverHelper.getInstance().findElement(By.id("pass")).clear();
        WebdriverHelper.getInstance().findElement(By.id("pass")).sendKeys(arg1);
        WebdriverHelper.getInstance().findElement(By.id("loginbutton")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^Login should fail$")
    public void checkFail() {
        if(WebdriverHelper.getInstance().getCurrentUrl().equalsIgnoreCase(
                "https://www.facebook.com/login.php?login_attempt=1&lwv=110")){
            System.out.println("Test1 Pass");
        } else {
            System.out.println("Test1 Failed");
        }
//        driver.close();
    }

    @Then("^Relogin option should be available$")
    public void checkRelogin() {
        if(WebdriverHelper.getInstance().getCurrentUrl().equalsIgnoreCase(
                "https://www.facebook.com/login.php?login_attempt=1&lwv=110")){
            System.out.println("Test2 Pass");
        } else {
            System.out.println("Test2 Failed");
        }
//        driver.close();
    }

    @Then("^login should be unsuccessful$")
    public void validateRelogin() {
        if(WebdriverHelper.getInstance().getCurrentUrl().equalsIgnoreCase(
                "https://www.facebook.com/login.php?login_attempt=1&lwv=110")){
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Failed");
        }
//        driver.close();

        //
    }
}