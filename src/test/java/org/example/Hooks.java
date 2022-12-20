package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilities.PropertyReader;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Hooks {

  private WebDriver driver;

  @Before
  public void setUp() {
    if (PropertyReader.getBrowserName().contains("chrome")) {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--window-size=1920,1080");
      options.addArguments("--incognito");
      options.setHeadless(false);
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver(options);
      System.out.println("Created new chrome WebDriver");
    } else if (PropertyReader.getBrowserName().contains("firefox")) {
      FirefoxOptions options = new FirefoxOptions();
      options.addArguments("--window-size=1920,1080");
      options.addArguments("--incognito");
      options.setHeadless(false);
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver(options);
      System.out.println("Created new firefox WebDriver");
    }
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.get(PropertyReader.getLoginUrl());
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
  }

  @After
  public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
      System.out.println("Failed scenario");
      byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      scenario.attach(screenshot, "image/png", "name");
      File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      File destFile =
          new File(
              "screenshot_"
                  + DateTimeFormatter.ofPattern("HHmmssSSS")
                      .withZone(ZoneOffset.UTC)
                      .format(Instant.now())
                  + "png");
      try {
        FileUtils.copyFile(srcFile, destFile);
        System.out.println("Wrote file to:" + destFile);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("scenario did not fail");
    }
    if (driver != null) {
      System.out.println("Termination webdriver");
      // driver.quit();
    }
  }

  public WebDriver getDriver() {
    return driver;
  }
}
