package Johnlewis;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utilities.BrowserUtilities;

public class TShirtsProductPage extends BrowserUtilities
{
    public TShirtsProductPage(WebDriver driver) {
        super(driver);
    }

     public static final String actualProductNameTextValue_byXpath ="//div[@class=\"xs-up\"]/h1";
     public static final String productSizeXS_byXpath ="//button[@data-size=\"XS\"]";
     public static final String productSizeS_byXpath ="//button[@data-size=\"S\"]";
     public static final String productSizeM_byXpath ="//button[@data-size=\"M\"]";
     public static final String productSizeL_byXpath ="//button[@data-size=\"L\"]";
     public static final String productSizeXL_byXpath ="//button[@data-size=\"XL\"]";
     public static final String productSizeXXL_byXpath ="//button[@data-size=\"XXL\"]";
     public static final String addToBasketButton_byXpath ="//button[@id=\"add-to-basket-button\"]";

     private final By actualProductNameTextValue = By.xpath(actualProductNameTextValue_byXpath);
     private final By productSizeXS = By.xpath(productSizeXS_byXpath);
     private final By productSizeS =  By.xpath(productSizeS_byXpath);
     private final By productSizeM =  By.xpath(productSizeM_byXpath);
     private final By productSizeL =  By.xpath(productSizeL_byXpath);
     private final By productSizeXL = By.xpath(productSizeXL_byXpath);
     private final By productSizeXXL = By.xpath(productSizeXXL_byXpath);
     private final By addToBasketButton = By.xpath(addToBasketButton_byXpath);

//    public void toVerifyTShirtProduct(String expectedProductName)
//    {

//        utilsWait.waitForElementToBeVisibleXPath(actualProductNameTextValue,20);
//        String actualMessageValue = elements.element_XPath(actualProductNameTextValue).getText();
//       // utilsAssert.verifyActualAndExpected(expectedProductName,actualMessageValue);
//    }
//
//    // This method is for select product size
//    public void selectProductSize(String productSize)
//    {
//        if (productSize.equalsIgnoreCase("XS"))
//        {
//            elements = new Elements();
//            utilsWait = new UtilsWait();
//            utilsWait.waitForElementToBeClickableXPath(productSizeXS,20);
//            elements.elementClickByXPath(productSizeXS);
//
//        }else if(productSize.equalsIgnoreCase("s"))
//        {
//            elements = new Elements();
//            utilsWait = new UtilsWait();
//            utilsWait.waitForElementToBeClickableXPath(productSizeS,20);
//            elements.elementClickByXPath(productSizeS);
//
//        }else if(productSize.equalsIgnoreCase("M"))
//        {
//            elements = new Elements();
//            utilsWait = new UtilsWait();
//            utilsWait.waitForElementToBeClickableXPath(productSizeM,20);
//            elements.elementClickByXPath(productSizeM);
//
//        }else if(productSize.equalsIgnoreCase("L"))
//        {
//            elements = new Elements();
//            utilsWait = new UtilsWait();
//            utilsWait.waitForElementToBeClickableXPath(productSizeL,20);
//            elements.elementClickByXPath(productSizeL);
//
//        }else if(productSize.equalsIgnoreCase("XL"))
//        {
//            elements = new Elements();
//            utilsWait = new UtilsWait();
//            utilsWait.waitForElementToBeClickableXPath(productSizeXL,20);
//            elements.elementClickByXPath(productSizeXL);
//
//        }else if(productSize.equalsIgnoreCase("XXL")){
//
//            elements = new Elements();
//            utilsWait = new UtilsWait();
//            utilsWait.waitForElementToBeClickableXPath(productSizeXXL,20);
//            elements.elementClickByXPath(productSizeXXL);
//
//        }else {
//
//            System.out.println("Please select size");
//        }
//    }
//
//    // This product include page scroll
//    public void clickOnAddToBasketButton()
//    {
//        elements = new Elements();
//        utilsWait = new UtilsWait();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("window.scrollBy(0,500)");
//        utilsWait.waitForElementToBeClickableXPath(addToBasketButton,20);
//        elements.elementClickByXPath(addToBasketButton);
//    }

}
