package SeleniumAutomation.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Utils {
    private WebDriver driver;
    public static void pauseExecution(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
//    public void isCheckOutPopUpVisibleWithAllfields(WebDriver driver) {
//        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='Budi']"));
//    }
}