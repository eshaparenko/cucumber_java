package infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebdriverHelper {
    private static RemoteWebDriver driver;
    static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static WebDriver getInstance() {
        if (driver == null) {
            try {
                capabilities.setBrowserName("firefox");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
                driver.manage().window().fullscreen();
            } catch (MalformedURLException e) {
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