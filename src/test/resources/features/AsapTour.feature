#@Author- Syed Zubair Mehdi
@Regression
Feature: Asap Tour Feature

  Background: 
    Given Launch the Owners App
    When User clicks on "skip" option
    When User enters city "Washington,DC" in search Bar

  Scenario: Request a tour  (TC-12472/QO-7711),(TC-12499/QO-7703),(TC-12500),(TC-12503/QO-7707),(TC-12504/QO-7708),(TC-12505),(TC-9359),(TC-9365)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And Verify "Request a Tour" option presence and validate it
    And Check available times to schedule a tour
    And Verify User Details
    Then User closes the app

  Scenario: Verify  ASAP option in a Request A Tour section for registered and unregistered section (TC-9355),(TC-18115)
    And User Clicks on any property to navigate to pdp page
    And Verify if "Asap tour button" is displayed
    And User clicks on "back" option
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And Verify if "Asap tour button" is displayed
    Then User closes the app

  Scenario: Asap tour form is filled (TC-9357),(TC-9356),(TC-9358)
    And User Clicks on any property to navigate to pdp page
    And User clicks on "Asap Tour" button
    And Verify if "Ask a question like page" is displayed
    And Verify Different fields are present on page and fill it
      | First Name |
      | Last Name  |
      | Email      |
      | Phone      |
    And Verify Mandatory fields
    Then User closes the app

  @integ
  Scenario: verify for registered user ask a question like form  should come mobile number is not present (TC-9362),(TC-9364 )
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid2"
    And Enters "SigninPassword2"
    And User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And User clicks on "Asap Tour" button
    And Verify if "Ask a question like page" is displayed
    Then User closes the app

  Scenario: footer Validation for registered and unregistered users (TC-18116),(TC-18117)
    And User clicks on "List" Tab
    And User selects date
    And Validate footer "Hey there!i am very intrested footer"
    And Validate footer "By submitting this form"
    And User clicks on "back" option
    And User clicks on "back" option
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And User clicks on "List" Tab
    And User selects date
    And Validate footer "Hey there!i am very intrested footer"
    Then User closes the app
