package infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebdriverHelper {
    private static WebDriver driver;


    public static WebDriver getInstance() {
        if (driver == null) {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("chrome");
//                driver = new RemoteWebDriver(new URL("http://zalenium:4444/wd/hub"), capabilities);
                System.setProperty("webdriver.chrome.driver", "/Users/ysharpenko/Documents/drivers/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().fullscreen();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
