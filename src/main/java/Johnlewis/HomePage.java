package Johnlewis;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtilities;
import utilities.PropertyReader;

import javax.lang.model.util.Elements;
import java.time.Duration;

public class HomePage extends BrowserUtilities
{
    public HomePage(WebDriver driver) {
        super(driver);
    }
   //Elements elements;


    public static final String expectedHomePageUrl = "https://www.johnlewis.com/";
    public static final String acceptAllCookies_ByXpath = "//div[@class=\"pecr-cookie-banner-content__buttons-pG9aE\"]//button[1]";
    public static final String tShirts_LinkText = "T-Shirts";
    public static final String shoppingBasket_ByXpath ="//a[@id=\"minibasket-icon-anchor\"]";


    private final By shoppingBasket = By.xpath(shoppingBasket_ByXpath);
    private final By acceptAllCookies = By.xpath(acceptAllCookies_ByXpath);
    private final By tShirts = By.linkText(tShirts_LinkText);

    public final Duration WEB_DRIVER_WAIT = PropertyReader.getWaitTime();

    public void validateJohnLewisHomePage() {

       waitForElementToBeClickable(acceptAllCookies,WEB_DRIVER_WAIT);
        String actualUrlValue = getDriver().getCurrentUrl();
        Assert.assertEquals(expectedHomePageUrl, actualUrlValue);
        System.out.println("JohnLewis Home page loaded successfully.");

    }
    public void clickAcceptAllCookies()
       {
           waitForElementToBeClickable(acceptAllCookies,WEB_DRIVER_WAIT);
           click(acceptAllCookies);
//           elements.elementClickByXPath(acceptAllCookies);
//           utilsWait.waitForElementToBeInvisibleXPath(acceptAllCookies,20);
   }
    public void clickOnShoppingBasket()
    {
         waitForElementToBeClickable(acceptAllCookies,WEB_DRIVER_WAIT);
        click(shoppingBasket);
//        utilsWait.waitForElementToBeClickableXPath(shoppingBasket,60);
//        elements.elementClickByXPath(shoppingBasket);
    }
//
//    // This method is mouseHover on Men Button on header menu and clicking on TShirts option
//    public void clickOnTShirts()
//    {
//        elements = new Elements();
//        WebElement menHomePageHeader = driver.findElement(By.linkText("Men"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(menHomePageHeader).perform();
//        elements.
//                elementClickByLinkText(tShirtsLinkText);
   }


