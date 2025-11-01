Feature: Login Functionality
  As a SauceDemo user
  I want to log in with valid and invalid credentials
  So that I can verify both successful and unsuccessful login scenarios
  
  @Smoke
  Scenario: Valid Login
    #Given the user is on the SauceDemo login page
    #Given the user opens the SauceDemo site
    Given enters username "standard_user" and password "secret_sauce"
    And clicks the Login button
    Then the user should be redirected to the Products page    
  
  @Smoke
  Scenario: Invalid Login
   # Given the user is on the SauceDemo login page
  #  Given the user opens the SauceDemo site
    Given enters username "locked_user" and password "wrong_password"
    And clicks the Login button
    Then an error message should be displayed as "Epic sadface: Username and password do not match any user in this service"
