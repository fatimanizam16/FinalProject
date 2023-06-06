package SeleniumAutomation.Pages;

import SeleniumAutomation.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class CreditCardDetails {
    private WebDriver driver;

    public CreditCardDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void doesCreditCardDetailScreenHasTotalAmountDisplayed(){
        driver.findElement(By.xpath("//img[@alt='expand']")).click();
        Utils.pauseExecution(2);
    }
    public void isCreditCardNumberEditable(String input) {

        WebElement CreditCardNumber = driver.findElement(By.xpath("//input[@autocomplete='cc-number']"));
        CreditCardNumber.clear();
        CreditCardNumber.sendKeys(input);
    }
    public void isCreditCardExpiryEditable(String input) {
        WebElement CardExpiry = driver.findElement(By.id("card-expiry"));
        CardExpiry.clear();
        CardExpiry.sendKeys(input);
    }
    public void isCreditCardCVVEditable(String input) {
        WebElement CardCvv= driver.findElement(By.id("card-cvv"));
        CardCvv.clear();
        CardCvv.sendKeys(input);
        Utils.pauseExecution(3);

    }
    public void doesPromoCodeWork(){
        driver.findElement(By.xpath("//span[contains(text(),'Potongan 10% - Demo Promo Engine')]")).click();
        Utils.pauseExecution(2);
    }
    public void doesPayNowBtnWork(){
       driver.findElement(By.xpath("/html/body/div[3]/div/div/div[7]/button")).click();
       WebDriverWait wait= new WebDriverWait(driver,10);

    }

}
