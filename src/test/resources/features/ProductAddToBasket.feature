@TestCase1
Feature: As User I want to Add product to Basket and remove from Basket successfully

  Background:
    Given I am on JohnLewis Home Page

  @smoke
  Scenario Outline: I should be able to verify Add to your Basket successfully
    When I accepts the cookie banner
    Then I verify shopping basket is empty
    When I browses product
    And I able to select the product "<productNumber>"
    Then I should get product name"<expectedProductName>" with other product information
    When I selected product size "<productSize>"
    And I click on Add to your basket Button
    Then I am able to navigate to basketPage
    And I should get product with "<expectedProductNameAndSize>" Name and size
    When I selects multiple "<productQuantity>"quantities
    Then I should get product with "<expectedProductQuantity>" Quantity
    And I am able to deletes added product from basket


    Examples:
      | productNumber | expectedProductName                                                   | productSize | productQuantity | expectedProductNameAndSize                                                | expectedProductQuantity |
      | 0             | John Lewis & Partners Supima Cotton Fine Stripe T-Shirt, Grey Melange | XL          | 4               | John Lewis & Partners Supima Cotton Fine Stripe T-Shirt, Grey Melange, XL | 4                       |
