package utilities;

import java.time.Duration;

public class PropertyReader extends BaseReader {

  public static DataGenerator dataGenerator = new DataGenerator();

  public static String getLoginUrl() {
    return get("loginUrl");
  }

  public static String getBrowserName() {
    return get("browser");
  }

  public static Duration getWaitTime() {
    return Duration.ofSeconds(30);
  }

  public static String getAdminInvalidUsername() {
    return get("AdminInvalidUsername");
  }

  public static String getAdminInvalidPassword() {
    return get("AdminInvalidPassword");
  }

  public static String getAutomationAdminUserName() {
    return get("AutomationAdminUsername");
  }

  public static String getAutomationAdminPassword() {
    return get("AutomationAdminPassword");
  }

}
