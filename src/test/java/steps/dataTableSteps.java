package steps;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import infra.WebdriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class dataTableSteps
{


//    @Before
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//    }

    @Given("^I am on the new user registration page$")
    public void goToFacebook() {
        WebdriverHelper.getInstance().get("https://www.facebook.com/");
    }

    @When("^I enter invalid data on the page$")
    public void enterData(DataTable table){
        //Initialize data table
        List<List<String>> data = table.raw();
        System.out.println(data.get(1).get(1));

        //Enter data
        WebdriverHelper.getInstance().findElement(By.name("firstname")).sendKeys(data.get(1).get(1));
        WebdriverHelper.getInstance().findElement(By.name("lastname")).sendKeys(data.get(2).get(1));
        WebdriverHelper.getInstance().findElement(By.name("reg_email__")).sendKeys(data.get(3).get(1));
        WebdriverHelper.getInstance().findElement(By.name("reg_email_confirmation__")).
                sendKeys(data.get(4).get(1));
        WebdriverHelper.getInstance().findElement(By.name("reg_passwd__")).sendKeys(data.get(5).get(1));

        Select dropdownB = new Select(WebdriverHelper.getInstance().findElement(By.name("birthday_day")));
        dropdownB.selectByValue("15");

        Select dropdownM = new Select(WebdriverHelper.getInstance().findElement(By.name("birthday_month")));
        dropdownM.selectByValue("6");

        Select dropdownY = new Select(WebdriverHelper.getInstance().findElement(By.name("birthday_year")));
        dropdownY.selectByValue("1990");

        WebdriverHelper.getInstance().findElement(By.className("_58mt")).click();
        // Click submit button driver.findElement(By.name("websubmit")).click();
    }

    @Then("^user registration should be unsuccessful$")
    public void User_registration_should_be_unsuccessful() {
        if(WebdriverHelper.getInstance().getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/")){
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Failed");
        }
    }
}
