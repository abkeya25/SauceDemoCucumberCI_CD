Feature: Checkout Process
  As a logged-in user with products in the cart
  I want to complete the checkout process
  So that I can place a successful order

  @Sanity
  Scenario: Successful checkout
    Given the user has products added to the cart
    When the user navigates to the cart
    And clicks on Checkout
    And enters user information:
      | First Name | John  |
      | Last Name  | Doe   |
      | Zip        | 12345 |
    And clicks Continue and Finish
    Then a confirmation message "Thank you for your order!" should be displayed
