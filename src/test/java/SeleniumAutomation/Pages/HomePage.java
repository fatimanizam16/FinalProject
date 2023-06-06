package SeleniumAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//a[@class='btn buy']")
    WebElement buyNowBtn;
    @FindBy (xpath = "//td[normalize-space()='Midtrans Pillow']")
    WebElement shoppingCart;

    public boolean doesBuyNowBtnInteractable(){
        return buyNowBtn.isEnabled();
    }
    public void didPillowAddedPillowIntoCart(){
        buyNowBtn.click();
    }
    public boolean doesShoppingCartHasPillow(){
        return shoppingCart.isDisplayed();
    }



}
