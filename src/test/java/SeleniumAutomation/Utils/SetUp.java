package SeleniumAutomation.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class SetUp {
    public static WebDriver driver;
    public static WebDriver launchBrowser(String browserName) {


        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver","geckodriver");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            System.setProperty("webdriver.safari.driver","safari");
            driver= new SafariDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {

        } else if (browserName.equalsIgnoreCase("opera")) {
        } else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return driver;
    }
}
