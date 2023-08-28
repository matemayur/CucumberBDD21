@ui @healthcheck
Feature: E-commerce Project Web Site Health Check

  Scenario: User is able to Open the browser, navigate to the URL and Search for Product
    Given user opened browser
    And user navigated to the home application url
    When user Search for product "Laptop"
    Then Search Result page is displayed with page title keyword contains "Laptop"
    
    
 Scenario: User is able to Open the browser, navigate to the URL and Search for Product
    Given user opened browser
    And user navigated to the home application url
    When user Search for product "Mobile"
    Then Search Result page is displayed with page title keyword contains "Mobile"
  
    
    
   Scenario: User is able to Open the browser, navigate to the URL and Search for Product
    Given user opened browser
    And user navigated to the home application url
    When user Search for product "Headphone"
    Then Search Result page is displayed with page title keyword contains "Headphone"  
    
    
    
    
    
    
    
    
    