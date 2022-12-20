package stepDefinitions;

import Johnlewis.BasketPage;
import Johnlewis.HomePage;
import Johnlewis.MensTShirtsPage;
import Johnlewis.TShirtsProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Hooks;
import org.openqa.selenium.WebDriver;


public class StepDefs
{
    private final HomePage homePage;
    private final MensTShirtsPage mensTShirtsPage;
    private final TShirtsProductPage tShirtsProductPage;
    private final BasketPage basketPage;

    private WebDriver driver;

    public StepDefs(Hooks hooksDriver) {
        driver = hooksDriver.getDriver();
        homePage = new HomePage(driver);
        mensTShirtsPage = new MensTShirtsPage(driver);
        tShirtsProductPage = new TShirtsProductPage(driver);
        basketPage = new BasketPage(driver);
    }



    @Given("^I am on JohnLewis Home Page$")
    public void i_am_on_JohnLewis_Home_Page()
    {
        homePage.validateJohnLewisHomePage();
    }

    @When("^I accepts the cookie banner$")
    public void i_accepts_the_cookie_banner()
    {
        homePage.clickAcceptAllCookies();
    }

    @Then("^I verify shopping basket is empty$")
    public void iVerifyShoppingBasketIsEmpty()
    {
        homePage.clickOnShoppingBasket();
        basketPage.toVerifyShoppingBasketIsEmpty();
    }

    @When("^I browses product$")
    public void iBrowsesProduct()
    {
        //homePage.clickOnTShirts();
    }

    @And("^I able to select the product \"([^\"]*)\"$")
    public void i_able_to_select_the_product(int ProductNumber)
    {
        //mensTShirtsPage.toValidateMensTShirtsPage();
        //mensTShirtsPage.clickOnFirstProduct(ProductNumber);
    }

    @Then("^I should get product name\"([^\"]*)\" with other product information$")
    public void i_should_get_product_name_with_other_product_information(String expectedProductName)
    {
        //tShirtsProductPage.toVerifyTShirtProduct(expectedProductName);
    }

    @When("^I selected product size \"([^\"]*)\"$")
    public void iSelectedProductSize(String productSize)
    {
        //tShirtsProductPage.selectProductSize(productSize);
    }

    @And("^I click on Add to your basket Button$")
    public void iClickOnAddToYourBasketButton()
    {
       // tShirtsProductPage.clickOnAddToBasketButton();
    }

    @Then("^I am able to navigate to basketPage$")
    public void iAmAbleToNavigateToBasketPage()
    {
        //homePage.clickOnShoppingBasket();
    }

    @And("^I should get product with \"([^\"]*)\" Name and size$")
    public void iShouldGetProductWithNameAndSize(String expectedProductName)
    {
        //basketPage.toVerifyFirstProductInCart(expectedProductName);
    }

    @When("^I selects multiple \"([^\"]*)\"quantities$")
    public void iSelectsMultipleQuantities(int productQuantity)
    {
        //basketPage.enterProductQuantity(productQuantity);
    }

    @Then("^I should get product with \"([^\"]*)\" Quantity$")
    public void iShouldGetProductWithQuantity(String expectedProductQuantity)
    {
        //basketPage.toVerifyIncreasedProductQuantity(expectedProductQuantity);
    }

    @And("^I am able to deletes added product from basket$")
    public void i_am_able_to_deletes_added_product_from_basket()
    {
       // basketPage.clickOnRemoveItem();
    }

}
