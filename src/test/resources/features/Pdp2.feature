#PDP2 Feature - @Author Syed Zubair Mehdi
@Regression
Feature: PDP 2 Feature

  Background: 
    Given Launch the Owners App
    When User clicks on "skip" option

  Scenario: Verify tool tip present next to sqft icon for Guest User (TC-12663)
    When User searches property with value "6058557" in search Bar
    And User Clicks on any property to navigate to pdp page
    And Verify if "sqft tool tip icon" is displayed
    And Validates "sqft tool tip icon" text
    Then User closes the app

  Scenario: Verify tool tip present next to sqft icon for Logined User (TC-12664),(TC-12665)
    When User searches property with value "6058557" in search Bar
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And Verify if "sqft tool tip icon" is displayed
    And Validates "sqft tool tip icon" text
    And User clicks on "back" option
    When User enters city "Washington,DC" in search Bar
    And User Clicks on any property to navigate to pdp page
    And Validate "sqft tool tip icon" is not displayed
    Then User closes the app

  Scenario: Verify Date format,date,event , price columns and source in price history (TC-12685),(TC-12686),(TC-12687),(TC-12692 )
    When User searches property with value "6058557" in search Bar
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Price History"
    And Verify "Date" format
    And Verify event "sold" is displayed
    And Verify if "Date Column" is displayed
    And Verify if "Event Column" is displayed
    And Verify if "Price Column" is displayed
    And Verify if "Source" is displayed
    And Verify spell of Date,Event and Price column
    Then User closes the app

  Scenario: Verify Date format,date,event , price columns and source in price history(TC-12693)
    When User searches property with value "6058557" in search Bar
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Price History"
    And Verify "Date" format
    And Verify event "sold" is displayed
    And Verify if "Date Column" is displayed
    And Verify if "Event Column" is displayed
    And Verify if "Price Column" is displayed
    And Verify if "Source" is displayed
    And Verify spell of Date,Event and Price column
    Then User closes the app
    
  Scenario: Verify contact seller for fsbo property and check if it can be filtered by listing as Owners (TC-12659),(TC-12662)
    When User enters city "Miami,FL" in search Bar
    And Filter Listing as "Owners" and apply filter
    And User Clicks on any property to navigate to pdp page
    And Verify if "Contact Seller" is displayed
    Then User closes the app
    
 Scenario: fill in contact  seller form and verify "make an offer,"request tour" and "ask a question" is not displayed (	TC-12660 ),(	TC-12661)
    When User enters city "Miami,FL" in search Bar
    And Filter Listing as "Owners" and apply filter
    And User Clicks on any property to navigate to pdp page
    And Validate "Request a tour" is not displayed
    And Validate "Make an offer" is not displayed
    And Validate "Ask a question" is not displayed
    And Click on contact seller option and validate terms and condition presence
    Then User closes the app 
    
   Scenario: Verify the Map button in PDP & its UI (TC-14452) (TC-14453) (TC-14454) (TC-14455) (TC-14457)
    When User enters city "Palo Alto,CA" in search Bar
    And User Clicks on any property to navigate to pdp page
    And User clicks on "MapView" button
    And Validate the Map button and its ui components
    And User clicks on "MapView" button
    And Verify the navigation to google maps
    Then User closes the app
    
    
    
