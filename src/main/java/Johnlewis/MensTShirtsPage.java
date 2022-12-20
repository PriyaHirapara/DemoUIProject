package Johnlewis;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utilities.BrowserUtilities;

public class MensTShirtsPage extends BrowserUtilities
{
    public MensTShirtsPage(WebDriver driver) {
        super(driver);
    }

    public static final String expectedMensTShirtsText = "Men's T-Shirts";
    public static final String actualMensTShirtsText_byXpath = "//li[contains(text(),\"Men's T-Shirts\")]";
    public static final String firstProductQuickViewButtons_byXpath ="//h2[@class=\"title_title__1MULs title_title--four-lines__VHzXP\"]";
    public static final String productNameTextValue_byXpath ="//div[@class=\"xs-up\"]/h1";

    private final By productNameTextValue = By.xpath(productNameTextValue_byXpath);
    private final By actualMensTShirtsText = By.xpath(actualMensTShirtsText_byXpath);
    private final By firstProductQuickViewButtons = By.xpath(firstProductQuickViewButtons_byXpath);




//
//    public void toValidateMensTShirtsPage(){
//        elements = new Elements();
//        utilsWait = new UtilsWait();
//        utilsAssert = new UtilsAssert();
//        utilsWait.waitForElementToBeVisibleXPath(actualMensTShirtsText,20);
//        String actualMensTShirtsTextValue = elements.element_XPath(actualMensTShirtsText).getText();
//        utilsAssert.verifyActualAndExpected(expectedMensTShirtsText,actualMensTShirtsTextValue);
//        System.out.println("I am Navigate to Men's T-Shirts page successfully");
//    }
//
//    // This product include page scroll
//    public void clickOnFirstProduct(int ProductNumber)
//    {
//        elements = new Elements();
//        utilsWait = new UtilsWait();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("window.scrollBy(0,500)");
//        utilsWait.waitForElementToBeClickableXPath(firstProductQuickViewButtons,60);
//        elements.listElementByXPath(firstProductQuickViewButtons,ProductNumber);
//        System.out.println("Product number:- " + ProductNumber);
//        String expectedProductNameValue = elements.element_XPath(productNameTextValue).getText();
//        System.out.println("Product name:- " + expectedProductNameValue);
//    }
//

}
