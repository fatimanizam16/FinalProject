package SeleniumAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CheckOutPopUp {
    private WebDriver driver;

    public CheckOutPopUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void isCheckOutPopUpVisibleWithAllfields() {
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='Budi']"));
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='budi@utomo.com']"));
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='081808466410']"));
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='Jakarta']"));
        driver.switchTo().parentFrame().findElement(By.xpath("//textarea[normalize-space()='MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11']"));
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='10220']"));
        WebDriverWait wait = new WebDriverWait(driver, 3);
    }

    public void isNameEditable(String input) {
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='Budi']")).clear();
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='Budi']")).sendKeys(input);
    }

    public void isEmailEditable(String input) {
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='budi@utomo.com']")).clear();
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='budi@utomo.com']")).sendKeys(input);
    }

    public void isPhoneNumberEditable(String input) {
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='081808466410']")).clear();
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='081808466410']")).sendKeys(input);
    }

    public void isCityEditable(String input) {
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='Jakarta']")).clear();
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='Jakarta']")).sendKeys(input);
    }

    public void isAddressEditable(String input) {
        driver.switchTo().parentFrame().findElement(By.xpath("//textarea[normalize-space()='MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11']")).clear();
        driver.switchTo().parentFrame().findElement(By.xpath("//textarea[normalize-space()='MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11']")).sendKeys(input);
    }

    public void isPostalCodeEditable(String input) {
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='10220']")).clear();
        driver.switchTo().parentFrame().findElement(By.xpath("//input[@value='10220']")).sendKeys(input);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    public void isCheckOutNowBtnClickable(){
        driver.switchTo().parentFrame().findElement(By.xpath("//div[@class='cart-checkout']")).click();
    }
}









