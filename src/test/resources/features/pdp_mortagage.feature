#@author:- Syed Zubair Mehdi
#PDP mortagage testCases
@Regression
Feature: - PDP mortagage testcases

  Background: 
    Given Launch the Owners App
    When User clicks on "skip" option
    When User enters city "Washington, DC" in search Bar
    And User Clicks on any property to navigate to pdp page

  Scenario: Verify Whole property price is same on pdp page and mortage calulator page,and mortage price is not editable (TC-12249/QO-7532),(TC-13014/QO-7555),(TC-13026/QO-7567),(TC-13031/QO-7572)
    And retrieves "Property price" value
    And User clicks on "mortagage calculator" button
    And Compares whole property price in pdp page and in mortage calculator page
    Then User closes the app

  Scenario: Verify the maximum number of digits that a property price field can take(TC-13015/QO-7556),(TC-13024/QO-7565),(TC-13028/QO-7560),(TC-13033/QO-7574),(TC-13032/QO-7573),(TC-13011/QO-7552),(TC-13019//QO-7560)
    And retrieves "Property price" value
    And Verify property price value is suffixed with dollar sign
    And User clicks on "mortagage calculator" button
    And Validate the "Property price" field can take "9" digits
    And Verify editing property price as not impacted property price on pdp
    Then User closes the app

  Scenario: swap between the Loan Types and verify emp and validate does interest rate accepts decimal value (TC-13022/QO-7563),(TC-13023/QO-7564)
    And User clicks on "mortagage calculator" button
    And swap between the Loan types and verify emp does not change
    And input decimal value in interest rate field
    Then User closes the app

  Scenario Outline: validate by entering negative values in property price,down payment,interest rates section (TC-13029//QO-7570)
    And User clicks on "mortagage calculator" button
    And Enters negative value in this "<fields>"
    And verify that "<fields>" negative value is not accepted
    Then User closes the app

    Examples: 
      | fields         |
      | property price |
      | down payment   |
      | interest rates |

  Scenario: Validate the disclaimer on emp page (TC-13035/QO-7576)
    And User clicks on "mortagage calculator" button
    And Validates disclaimer on emp page
    Then User closes the app

  Scenario: validate down payment and interest fields(TC-13016/QO-7557),(TC-13017/QO-7558)
    And User clicks on "mortagage calculator" button
    And Verify down payment takes only 3 digits
    And Verify down payment and interest rates fields is suffixed with percent sign
    Then User closes the app

  Scenario: Verify HOA field  for both in PDP and EMP page should be '$0' when HOA dues display $0(TC-12252/QO-7536)
    And User clicks on "back" option
    And User searches property with value "09401800" in search Bar
    And Validate HOA field is "$0" in both pdp and emp
    Then User closes the app


  Scenario: verify down payement and interest field increases/decreases by 1% and 0.1% respectively (TC-13020/QO-7561),(TC-13021/QO-7562)
    And User clicks on "mortagage calculator" button
    And Verify down payment increases or decreases by 1%
    And Verify interest field increases or decreases by 0.1%
    And Verify the tax amount should be rounded up
    Then User closes the app
  
  Scenario: Verify HOA field is not showing in View all features section (TC-12795)
    And User clicks on "back" option
    And User searches property with value "DC10357586" in search Bar
    And User verify no HOA details in view all features
    Then User closes the app
    
  Scenario: Verify Zero HOA value is  showing in View all features section (TC-12792)
    And User clicks on "back" option
    And User searches property with value "5967036" in search Bar
    And Validate HOA field is zero in view all feature section
    Then User closes the app
   
  Scenario: Compare EMP tool tip message with EMP Disclaimer message (TC-12772)
    And User scrolls to text "Estimated monthly payment"
    And Verify EMP tool tip message with EMP Disclaimer message
    Then User closes the app

    
    
