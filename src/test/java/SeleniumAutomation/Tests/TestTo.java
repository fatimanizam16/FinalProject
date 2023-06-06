package SeleniumAutomation.Tests;

import SeleniumAutomation.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestTo {
    public static WebDriver driver;
    public static Properties proper= new Properties();
    public static HomePage homePage;
    public static CheckOutPopUp checkOutPopUp;
    public static SummaryPage summaryPage;
    public static CreditCardDetails creditCardDetails;
    public static PaymentVerification paymentVerification;
    public TestTo() {
        try{
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ File.separator+"resources"+File.separator+"testdata"+File.separator+"Configuration.properties");
            proper.load(file);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e1){
            e1.printStackTrace();
        }

    }
    @BeforeClass(alwaysRun = true)
    public void launchTest(){
        launchBrowser(proper.getProperty("browser"));
        driver.get(proper.getProperty("url"));
        homePage = new HomePage(driver);
        checkOutPopUp= new CheckOutPopUp(driver);
        summaryPage=new SummaryPage(driver);
        creditCardDetails= new CreditCardDetails(driver);
        paymentVerification=new PaymentVerification(driver);
    }
    @Test(priority = 1, groups = {"Regression"})
    public static void VerifyMidtransPillowHasAddedIntoCart(){
       Assert.assertTrue(homePage.doesBuyNowBtnInteractable());
        homePage.didPillowAddedPillowIntoCart();
    }
    @Test(priority = 2,groups = {"Regression","Smoke"})
    public static void VerifyBuyNowBtnTookToShoppingCart(){
        Assert.assertTrue(homePage.doesShoppingCartHasPillow());
    }
    @Test(priority = 3,groups = {"Regression"})
    public static void VerifyNameEmailCityAddressPhoneNumberPostalCodeIsAvailable(){
        checkOutPopUp.isCheckOutPopUpVisibleWithAllfields();
    }
    @Test(priority = 4,groups = {"Regression"})
    public static void VerifyNameEmailCityAddressPhoneNumberPostalCodeIsEditable() {
    checkOutPopUp.isNameEditable(proper.getProperty("name"));
    checkOutPopUp.isEmailEditable(proper.getProperty("email"));
    checkOutPopUp.isPhoneNumberEditable(proper.getProperty("phoneNumber"));
    checkOutPopUp.isCityEditable(proper.getProperty("city"));
    checkOutPopUp.isAddressEditable(proper.getProperty("address"));
    checkOutPopUp.isPostalCodeEditable(proper.getProperty("postalcode"));
    }
    @Test(priority = 5,groups = {"Regression","Smoke"})
    public static void VerifyCheckOutBtnRedirectsToSummaryPage(){
        checkOutPopUp.isCheckOutNowBtnClickable();
    }

    @Test(priority = 6,groups = {"Regression"})
    public static void VerifyAllInfoAboutOrderIsVisibleOnSummaryPopUp(){
    summaryPage.isAllInfoAboutOrderVisible();
    }
    @Test(priority = 7,groups = {"Regression","Smoke"})
    public static void VerifyAllPaymentMethodsListedOnSummaryPage(){
        summaryPage.isAllPaymentMethodsVisible();
    }
    @Test(priority = 8,groups = {"Regression"})
    public static void VerifyCickingOnCreditOrDebitCardRedirectToCardDetails(){
       summaryPage.isCreditCardPaymentMethodClickable();
    }
    @Test(priority = 9,groups = {"Regression","Smoke"})
    public static void VerifyOrderAmountOnCreditCardScreen(){
        creditCardDetails.doesCreditCardDetailScreenHasTotalAmountDisplayed();
        creditCardDetails.doesCreditCardDetailScreenHasTotalAmountDisplayed();
    }
    @Test(priority = 10,groups = {"Regression"})
    public static void VerifyCardDetailsAreEditable(){
       creditCardDetails.isCreditCardNumberEditable(proper.getProperty("cardnumber"));
       creditCardDetails.isCreditCardExpiryEditable(proper.getProperty("expirydate"));
       creditCardDetails.isCreditCardCVVEditable(proper.getProperty("cvv"));
    }
    @Test (priority = 11,groups = {"Regression","Smoke"})
    public static void VerifyPromoCodeBtnWorks(){
        creditCardDetails.doesPromoCodeWork();
    }
    @Test (priority = 12,groups = {"Regression"})
    public static void VerifyClickingOnPaynowRedirectUsrtoBankPaymentScreen(){
        creditCardDetails.doesPayNowBtnWork();
    }
     @Test (priority = 13,groups = {"Regression","Smoke"})
    public static void VerifyClickingOnOKBtnWithValidOTP() {
        paymentVerification.doesOTPFieldEditable(proper.getProperty("OTP"));
        paymentVerification.doesOkBtnRedirectingToOrderSuccessPage();
    }
//    @Test (priority = 14,groups = {"Regression"})
//    public static void VerifyClickingOnOKBtnWithInvalidOTPFailPayment() {
//        paymentVerification.doesClickingOkBtnWithInvalidOtpFail(proper.getProperty("OTP"));
//
//    }
//    @Test (priority = 15,groups = {"Regression"})
//    public static void VerifyClickingOCancelBtnCancelRedirectsToPaymentMerchant() {
//       paymentVerification.doesClickCancelWork();
//
//    }


    @AfterClass(alwaysRun = true)
    public static void terminateTest(){
        driver.quit();
    }


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

