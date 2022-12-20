package utilities;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ElementActions {
  void waitForElementToBeClickable(By locator, Duration timeOutSeconds);

  void waitForElementToBeClickable(WebElement element, Duration timeOutSeconds);

  WebElement findElement(By byLocator);

  public WebElement findElement(WebElement webElement, By byLocator);

  List<WebElement> findElements(By byLocator);

  List<WebElement> findElements(WebElement webElement, By byLocator);

  void click(By byLocator);

  void scrollToTheSpecifiedElement(By element);

  void clearInput(By byLocator);

  void writeText(By byLocator, String text);

  String readText(By byLocator);

  String readText(By byLocator, Duration timeOutInSeconds);

  String getValueFromElement(By byLocator);

  void hoverElement(By byLocator);

  void hoverElement(By byLocator, Duration timeOutInSeconds);

  void sendKeys(By byLocator, CharSequence... charSequences);

  void waitForElementToAppear(By locator, Duration timeOutInSeconds);

  void waitForTextToAppear(By locator, String text, Duration timeOutInSeconds);

  void waitForTextToContainTitle(String text, Duration timeOutInSeconds);

  void waitForElementToDisappear(By locator, Duration timeOutInSeconds);

  void waitForTextToDisappear(By locator, String text, Duration timeOutInSeconds);

  String getUrl();

  boolean isVisible(By locator);

  boolean isClickable(By locator, Duration timeOutInSeconds);

  void scroll(WebElement r, By locator);

  String scrollAndReturnCellText(WebElement r, By locator);

  void moveToElement(By byElement);

  void pressEscape(By byElement);

  void pressEnter(By byElement);

  void pressDown(By byElement);

  void waitForElementTextContainsString_IgnoreCase(
          By element, String expectedString, WebDriver driver, Duration specifiedTimeout);
}
