package SeleniumAutomation.Pages;

import SeleniumAutomation.Utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentVerification {
    private WebDriver driver;

    public PaymentVerification(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void doesOTPFieldEditable(String input){
      driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='iframe-3ds']")));
        Utils.pauseExecution(5);
        WebElement otpInput = driver.findElement(By.cssSelector("#otp"));
        otpInput.sendKeys(input);
//        if(otpInput.isDisplayed()){
//            otpInput.sendKeys(input);
//        }else{
//            throw new NoSuchElementException("OTP field not found");
//        }

    }
    public void doesOkBtnRedirectingToOrderSuccessPage(){
        driver.findElement(By.cssSelector("button[value='ok']")).click();
        Utils.pauseExecution(2);
        driver.switchTo().frame("snap-midtrans");
        driver.findElement(By.xpath("//div[@class='success-wrapper']")).isDisplayed();
        Utils.pauseExecution(2);
    }


    public void doesClickingOkBtnWithInvalidOtpFail(String input){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='iframe-3ds']")));
        Utils.pauseExecution(5);
        WebElement otpInput = driver.findElement(By.cssSelector("#otp"));
        otpInput.sendKeys(input);
        if(otpInput.isDisplayed()){
            otpInput.sendKeys(input);
        }else{
            throw new NoSuchElementException("OTP field not found");
        }
        driver.findElement(By.cssSelector("button[value='ok']")).click();
        Utils.pauseExecution(5);
        driver.switchTo().frame("snap-midtrans");
        driver.findElement(By.xpath("//div[@class='cancel-modal-content']")).isDisplayed();
        Utils.pauseExecution(5);

    }
    public void doesClickCancelWork(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='iframe-3ds']")));
        Utils.pauseExecution(5);
         driver.findElement(By.cssSelector("h1[class='left']")).isDisplayed();
        driver.findElement(By.cssSelector("button[name='cancel']")).click();
        driver.switchTo().frame("snap-midtrans");
        driver.findElement(By.xpath("//div[@class='cancel-modal-content']")).isDisplayed();
        Utils.pauseExecution(5);
    }
}
