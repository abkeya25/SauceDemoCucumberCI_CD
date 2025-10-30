Feature: Login Data Driven with Excel
@Regression
  Scenario Outline: Login Data Driven Excel   
    Given the user passing email and password with excel row "<row_index>"
	Then verify the user should be redirected to the product Page as per results with excel row "<row_index>" 
    Examples: 
      | row_index |
      |         1 |
      |         2 |
     
