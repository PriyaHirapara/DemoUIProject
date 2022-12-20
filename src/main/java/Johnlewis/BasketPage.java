package Johnlewis;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserUtilities;
import utilities.PropertyReader;

import java.time.Duration;

public class BasketPage extends BrowserUtilities
{
    public BasketPage(WebDriver driver) {
        super(driver);
    }
    public static final String expectedEmptyShoppingBasketText ="Your basket is empty.";
    public static final String actualEmptyShoppingBasket_LinkText ="u-centred";
    public static final String actualFirstProductText_ByXpath ="//h2[@class=\"product-list-title\"]";
    public static final String inputProductQuantity_ByXpath ="//button[@class=\"quantity-increase-button\"]";
    public static final String actualFirstProductQuantity ="quantity-input";
    public static final String expectedFirstProductQuantity ="1";
    public static final String removeItem_ByXpath ="//button[@class=\"remove-basket-item-form-button\"]";

    private final By actualEmptyShoppingBasket = By.linkText(actualEmptyShoppingBasket_LinkText);
    private final By actualFirstProductText = By.xpath(actualFirstProductText_ByXpath);
    private final By inputProductQuantity = By.xpath(inputProductQuantity_ByXpath);
    private final By removeItem = By.xpath(removeItem_ByXpath);

    public final Duration WEB_DRIVER_WAIT = PropertyReader.getWaitTime();


    public void toVerifyShoppingBasketIsEmpty(){
        waitForElementToAppear(actualEmptyShoppingBasket,WEB_DRIVER_WAIT);
        String actualEmptyShoppingBasketTextValue = getDriver().getTitle();
        Assert.assertEquals(expectedEmptyShoppingBasketText,actualEmptyShoppingBasket_LinkText);
        //String actualEmptyShoppingBasketTextValue = elements.element_ClassName(actualEmptyShoppingBasketText).getText();
        //utilsAssert.verifyActualAndExpected(expectedEmptyShoppingBasketText,actualEmptyShoppingBasketTextValue);
    }
//
//    public void toVerifyFirstProductInCart(String expectedProductNameAndSize)
//    {
//        elements = new Elements();
//        utilsAssert = new UtilsAssert();
//        utilsWait = new UtilsWait();
//        utilsWait.waitForElementToBeVisibleXPath(actualFirstProductText, 40);
//        String actualNameValueFirstProductText = elements.element_XPath(actualFirstProductText).getText();
//        utilsAssert.verifyActualAndExpected(expectedProductNameAndSize, actualNameValueFirstProductText);
//        String actualQuantityOfFirstProduct = elements.element_ClassName(actualFirstProductQuantity).getAttribute("value");
//        System.out.println(actualNameValueFirstProductText + " :- " + actualQuantityOfFirstProduct);
//        utilsAssert.verifyActualAndExpected((expectedFirstProductQuantity), actualQuantityOfFirstProduct);
//    }
//
//    // This method is increasing product quantity
//    public void enterProductQuantity(int productQuantity)
//    {
//        elements = new Elements();
//        for (int i = 1; i <= (productQuantity - 1); i++)
//        {
//            elements.elementClickByXPath(inputProductQuantity);
//        }
//    }
//
//    public void toVerifyIncreasedProductQuantity(String expectedProductQuantity)
//    {
//        elements = new Elements();
//        utilsAssert = new UtilsAssert();
//        utilsWait = new UtilsWait();
//        utilsWait.waitForElementToBeVisibleXPath(actualFirstProductText,20);
//        String actualQuantityOfFirstProduct = elements.element_ClassName(actualFirstProductQuantity).getAttribute("value");
//        utilsAssert.verifyActualAndExpected((expectedProductQuantity),actualQuantityOfFirstProduct);
//
//    }
//
//    public void clickOnRemoveItem(){
//        elements = new Elements();
//        elements.elementClickByXPath(removeItem);
// }
}
