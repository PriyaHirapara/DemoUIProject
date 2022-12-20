package utilities;

import java.time.Duration;
import java.util.*;
import org.hamcrest.Matcher;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtilities implements ElementActions {

  private WebDriver driver;
  private WebDriverWait wait;

  public final Duration WEB_DRIVER_WAIT = PropertyReader.getWaitTime();

  public BrowserUtilities(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
  }

  public void waitForElementToAppearAndClick(By locator, Duration timeOutInSeconds) {
    waitForElement(ExpectedConditions.visibilityOfElementLocated(locator), timeOutInSeconds);
    waitForElementToBeClickable(locator, timeOutInSeconds);
  }

  @Override
  public void waitForElementToBeClickable(By locator, Duration timeOutSeconds) {
    waitForElement(ExpectedConditions.elementToBeClickable(locator), timeOutSeconds);
  }

  @Override
  public void waitForElementToBeClickable(WebElement element, Duration timeOutSeconds) {
    waitForElement(ExpectedConditions.elementToBeClickable(element), timeOutSeconds);
  }

  public String waitForElementToAppearAndReadText(By locator, Duration timeOutInSeconds) {
    waitForElement(ExpectedConditions.visibilityOfElementLocated(locator), timeOutInSeconds);
    return readText(locator);
  }

  public WebElement findElement(By byLocator) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    WebElement element = driver.findElement(byLocator);
    highlightElement(element);
    return element;
  }

  public boolean doNotFindElement(By byLocator) {
    try {
      driver.findElement(byLocator);
    } catch (NoSuchElementException e) {
      return true;
    }
    return false;
  }

  @Override
  public WebElement findElement(WebElement webElement, By byLocator) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    WebElement element = webElement.findElement(byLocator);
    highlightElement(element);
    return element;
  }

  @Override
  public List<WebElement> findElements(By byLocator) {
    List<WebElement> elements = driver.findElements(byLocator);
    for (WebElement element : elements) {
      highlightElement(element);
    }
    return elements;
  }

  @Override
  public List<WebElement> findElements(WebElement webElement, By byLocator) {
    List<WebElement> elements = driver.findElements(byLocator);
    for (WebElement element : elements) {
      highlightElement(element);
    }
    return elements;
  }

  @Override
  public void click(By byLocator) {
    try {
      findElement(byLocator).click();
    } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
      executeScript("arguments[0].click();", findElement(byLocator));
    }
  }

  @Override
  public void scrollToTheSpecifiedElement(By element) {
    executeScript("arguments[0].scrollIntoView();", findElement(element));
  }

  @Override
  public void clearInput(By byLocator) {
    findElement(byLocator).click();
    findElement(byLocator).clear();
  }

  @Override
  public void writeText(By byLocator, String text) {
    findElement(byLocator).clear();
    click(byLocator);
    findElement(byLocator).sendKeys(text);
  }

  @Override
  public String readText(By byLocator) {
    try {
      return findElement(byLocator).getText();
    } catch (NoSuchElementException e) {
      return "";
    }
  }

  @Override
  public String readText(By byLocator, Duration timeOutInSeconds) {
    return null;
  }

  @Override
  public String getValueFromElement(By byLocator) {
    return findElement(byLocator).getAttribute("value");
  }

  @Override
  public void hoverElement(By byLocator) {
    Actions actions = new Actions(driver);
    actions.moveToElement(findElement(byLocator)).perform();
  }

  @Override
  public void hoverElement(By byLocator, Duration timeOutInSeconds) {
    Actions actions = new Actions(driver);
    WebElement element =
        waitForElement(ExpectedConditions.visibilityOfElementLocated(byLocator), timeOutInSeconds);
    actions.moveToElement(element).perform();
  }

  @Override
  public void sendKeys(By byLocator, CharSequence... charSequences) {
    findElement(byLocator).sendKeys(charSequences);
  }

  public void senKeys(By byLocator, String text) {
    try {
      findElement(byLocator).sendKeys(text);
    } catch (ElementClickInterceptedException e) {
      sendKeysWithJS(byLocator, text);
    }
  }

  public void sendKeysWithJS(By byLocator, String text) {
    executeScript("arguments[0].value='" + text + "';", driver.findElement(byLocator));
    executeScript(
        "arguments[0].dispatchEvent(new Event('input', { bubbles: true }))",
        findElement(byLocator));
  }

  @Override
  public void waitForElementToAppear(By locator, Duration timeOutInSeconds) {
    waitForElement(ExpectedConditions.visibilityOfElementLocated(locator), timeOutInSeconds);
  }

  @Override
  public void waitForTextToAppear(By locator, String text, Duration timeOutInSeconds) {}

  @Override
  public void waitForTextToContainTitle(String text, Duration timeOutInSeconds) {}

  @Override
  public void waitForElementToDisappear(By locator, Duration timeOutInSeconds) {}

  @Override
  public void waitForTextToDisappear(By locator, String text, Duration timeOutInSeconds) {}

  @Override
  public String getUrl() {
    return driver.getCurrentUrl();
  }

  @Override
  public boolean isVisible(By locator) {
    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    List<WebElement> list = findElements(locator);
    if (list.size() == 0) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public boolean isClickable(By locator, Duration timeOutInSeconds) {
    try {
      waitForElementToBeClickable(locator, timeOutInSeconds);
      return true;
    } catch (TimeoutException e) {
      return false;
    }
  }

  public void scrollToPosition(By by) {
    WebElement element = driver.findElement(by);
    Point location = element.getLocation();
    executeScript(
        "window.scrollTo("
            + location.getX()
            + ","
            + (location.getY() - 200)
            + ");"); // @TODO change to use the top bar dimensions
  }

  public void scrollDown() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,800)", "");
  }

  public void scrollRight() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(300,0)", "");
  }

  @Override
  public void scroll(WebElement r, By locator) {
    executeScript("arguments[0].scrollIntoView()", r.findElement(locator));
  }

  @Override
  public String scrollAndReturnCellText(WebElement r, By locator) {
    scroll(r, locator);
    return findElement(r, locator).getText();
  }

  @Override
  public void moveToElement(By byElement) {
    Actions actions = new Actions(driver);
    WebElement elem;
    elem = driver.findElement(byElement);
    actions.moveToElement(elem).perform();
    highlightElement(elem);
    elem.click();
  }

  @Override
  public void pressEscape(By byElement) {
    driver.findElement(byElement).sendKeys(Keys.ESCAPE);
  }

  @Override
  public void pressEnter(By byElement) {
    driver.findElement(byElement).sendKeys(Keys.ENTER);
  }

  @Override
  public void pressDown(By byElement) {
    driver.findElement(byElement).sendKeys(Keys.ARROW_DOWN);
  }

  public void pressEscapeWithoutElement() {
    Actions actions = new Actions(driver);
    actions.sendKeys(Keys.ESCAPE);
  }

  public void pressEnterWithoutElement() {
    Actions actions = new Actions(driver);
    actions.sendKeys(Keys.ENTER);
  }

  public void pressDownWithoutElement() {
    Actions actions = new Actions(driver);
    actions.sendKeys(Keys.DOWN);
  }

  public void open(String url) {
    driver.get(url);
  }

  public WebDriverWait getWait(Duration timeOutInSeconds) {
    return new WebDriverWait(driver, timeOutInSeconds);
  }

  public WebDriver getDriver() {
    return driver;
  }

  public void pageRefresh() {
    driver.navigate().refresh();
  }

  public Object executeScript(String script) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    return js.executeScript(script);
  }

  public Object executeScript(String script, Object... objects) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    return js.executeScript(script, objects);
  }

  public void moveToNextElement() {
    Actions actions = new Actions(getDriver());
    actions.sendKeys(Keys.TAB).perform();
  }

  private <V> V waitForElement(ExpectedCondition<WebElement> condition, Duration timeOutInSeconds) {
    V result = (V) getWait(timeOutInSeconds).until(condition);
    return result;
  }

  @Override
  public void waitForElementTextContainsString_IgnoreCase(
      By element, String expectedString, WebDriver driver, Duration specifiedTimeout) {
    WebDriverWait webDriverWait = new WebDriverWait(driver, specifiedTimeout);
    retrieveElement(element);
    ExpectedCondition<Boolean> elementTextContainsString =
        arg0 -> findElement(element).getText().toLowerCase().contains(expectedString.toLowerCase());
    wait.until(elementTextContainsString);
  }

  public By retrieveElement(By by) {
    int attempts = 0;
    while (attempts < 40) {
      try {
        findElement(by);
        break;
      } catch (StaleElementReferenceException e) {
        System.out.println("Element " + by + "was not found for " + attempts + "attempts");
      }
      attempts++;
    }
    return by;
  }

  private void highlightElement(WebElement element) {
    executeScript("arguments[0].style.border='1px solid red'", element);
  }

  public void clearInputFieldText(By locator) {
    waitForElementToAppear(locator, WEB_DRIVER_WAIT);
    click(locator);
    findElement(locator).clear();
  }

  public void clearAndWrite(By by, String text) {
    clearInputFieldText(by);
    if (text != null) {
      sendKeys(by, text);
    }
  }

  public void selectFromDropDown(String selectionName, By dropDownLocator, By optionLocator) {
    waitForElementToBeClickable(dropDownLocator, WEB_DRIVER_WAIT);
    click(dropDownLocator);
    waitForElementsToBePresent(optionLocator, WEB_DRIVER_WAIT);
    List<WebElement> webElementsList = this.findElements(optionLocator);
    for (WebElement webElement : webElementsList) {
      if (webElement.getText().equals(selectionName)) {
        webElement.click();
        break;
      }
    }
    click(dropDownLocator);
  }

  public Select selectFromDropDownByVisibleText(By byLocator, String text) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    WebElement element = driver.findElement(byLocator);
    Select select = new Select(element);
    select.selectByVisibleText(text);
    return select;
  }

  private void waitForElementsToBePresent(By locator, Duration timeOutInSeconds) {
    waitForElement(ExpectedConditions.visibilityOfElementLocated(locator), timeOutInSeconds);
  }

  public List<String> getOptionFromDropDown(By dropdownLocator) {
    List<String> list = new ArrayList<>();
    List<WebElement> options = new Select(findElement(dropdownLocator)).getOptions();
    for (int i = 0; i < options.size(); i++) {
      list.add(options.get(i).getAttribute("lable"));
    }
    return list;
  }

  public void selectDate(By locator, String select_day) {

    WebElement dateWidget = driver.findElement(locator);
    List<WebElement> days = dateWidget.findElements(By.tagName("td"));
    for (WebElement d : days) {
      if (d.getText().equals(select_day)) {
        d.findElement(By.linkText(select_day)).click();
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public Map<String, Integer> getColumnIndexFromTable(By locator) {
    List<WebElement> list = findElements(locator);
    Map<String, Integer> map = new HashMap<String, Integer>();
    List<String> colNames = new LinkedList<String>();
    for (WebElement col : list) {
      ((JavascriptExecutor) driver)
          .executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", col);
      colNames.add(col.getText().trim());
    }
    System.out.println(colNames.size());
    int index = 1;
    for (String colName : colNames) {
      map.put(colName, index);
      index += 1;
    }
    System.out.println(map);
    return map;
  }

  public void scrollIntoElement(WebElement ele) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", ele);
  }

  public void resetColumnSize(By columnHeader, By columnMenu) {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    List<WebElement> list = findElements(columnHeader);
    Actions action = new Actions(driver);
    action.moveToElement(list.get(0)).build().perform();
    action.click(findElement(columnMenu)).build().perform();
    action.click(findElement(By.xpath("//span[text()='Reset Columns']"))).build().perform();
  }

  public void sleep(long millisecond) {
    try {
      Thread.sleep(millisecond);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void scrollInToTheView(String xpath) {
    JavascriptExecutor je = (JavascriptExecutor) driver;
    WebElement element = driver.findElement(By.xpath(xpath));
    je.executeScript("arguments[0].scrollIntoView(true);", element);
  }

  public void Scrolltodivmostright(WebElement element) {
    ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", element);
  }
}
