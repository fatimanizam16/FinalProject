package SeleniumAutomation.Pages;

import SeleniumAutomation.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SummaryPage {
    WebDriver driver;

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void isAllInfoAboutOrderVisible(){
        driver.switchTo().parentFrame().findElements(By.className("content-table scroll-y order-modal-wrapper"));
        Utils.pauseExecution(2);
    }

    public void isAllPaymentMethodsVisible() {
        Utils.pauseExecution(2);
        driver.switchTo().frame("snap-midtrans");
        Utils.pauseExecution(5);


    }
    public void isCreditCardPaymentMethodClickable() {

        // Switch to the iframe containing the credit/debit card payment method
      //  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'midtrans-credit-card')]")));
        driver.findElement(By.xpath("//div[@class='logo-border-payment-list']/img[@alt='VISA']")).click();
        Utils.pauseExecution(5);
    }


    }


