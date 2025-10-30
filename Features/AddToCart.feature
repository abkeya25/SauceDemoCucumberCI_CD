Feature: Add to Cart Functionality
  As a logged-in user
  I want to add and remove products from the cart
  So that I can verify cart item management

  @Sanity
  Scenario: Add product to cart
    #Given the user is logged into the SauceDemo site
    Given enters username "standard_user" and password "secret_sauce"
    And clicks the Login button
    And adds product "Sauce Labs Backpack" to the cart
    Then the product should be visible in the cart

  @Sanity
  Scenario: Remove product from cart
    Given the product "Sauce Labs Bike Light" is already added to the cart
    When the user navigates to the cart
    And clicks Remove on that product
    Then the product should be removed and the cart should be empty
