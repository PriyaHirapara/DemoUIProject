package utilities;

import com.github.javafaker.Faker;

public class DataGenerator {

  public Faker faker = new Faker();

  public String getRandomStringParam(int param) {
    String randomString = faker.regexify(String.format("[A-Z]{3}[0-9]{10}", param));
    System.out.println("String generated: " + randomString);
    return randomString;
  }

  public String getRandomIntParam(int param) {
    return faker.regexify(String.format("[0-9]{%s}", param));
  }
}
