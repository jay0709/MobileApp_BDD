#Author: Syed Zubair Mehdi
Feature: LogIn/LogOut

  Background: 
    Given Launch the Owners App

  Scenario: Verify user should be propmpted for login while favouriting or saving a property (TC-15244),(TC-15245)
    When User clicks on "skip" option
    And User enters city "Joseph city,AZ" in search Bar
    And User sets favourite property from Map view
    And Verify if "Sign In Pop-up" is displayed
    And User clicks on "back" option
    And click on "Save Search" option
    And Verify if "Sign In Pop-up" is displayed
    Then User closes the app

  Scenario: Verify Same Email cannot be used twice (TC-15248),(TC-15254),(TC-15258),(TC-15264)
    When User clicks on "skip" option
    And User clicks on "SigninTabFooter" option
    And User clicks on "Register" option
    And Enters "First Name"
    And Enters "Last Name"
    And Enters Email Id "One@Ownerstest.com" and Stores it
    And Enters "Password"
    And User clicks on "Registration" option
    And Verify User is returned to SRP View
    And User Taps on option "Me"
    And User clicks on "Edit" button
    And Verify if "Phone Number in Edit Profile" is displayed
    And User clicks on "SignOut" option
    And User clicks on "SigninTabFooter" option
    And User clicks on "Register" option
    And Enters "First Name"
    And Enters "Last Name"
    And Enters Email Id "One@Ownerstest.com" and Stores it
    And Validate text "Email Id already registered" on page
    Then User closes the app

  Scenario: Verify non-logged in user is prompted to sign on swipe and on adding pdp Notes (TC-15252),(TC-15253),(TC-15255),(TC-15259),(TC-15261),(TC-15263)
    When User clicks on "skip" option
    And User enters 3 letters in search bar
    And Verify if "Auto sugesstion list" is displayed
    And User enters city "Joseph city,AZ" in search Bar
    And User clicks on "Swipe" Tab
    And User tries to swipe right side
    Then Verify if "Sign In Pop-up" is displayed
    And User clicks on "back" option
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Notes"
    And User clicks on comment text box to enter some text
    And Verify if "Sign In Pop-up" is displayed
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And User clicks on comment text box to enter some text
    And Validate "Sign In Pop-up" is not displayed
    Then User closes the app

  Scenario: Verify contents in sign in pop-up (TC-15256)
    When User clicks on "skip" option
    And User clicks on "SigninTabFooter" option
    And User verifys contents in signin popup
      | Email           |
      | Password        |
      | Forgot Password |
      | Register        |
      | Sign In         |
    Then User closes the app

  Scenario: Verify Where do you want to live on skip page (TC-15262),(TC-15264), (TC-15265),(TC-15267),(TC-15268).(TC-15268),(TC-15273),(TC-15274)
    And Validate text "Where do you want to leave" on page
    When User enters city "Miami,FL" in onboarding search Bar
    And Validate text "What's your price range" on page
    And User clicks on "Next" option
    And Validate text "Any other filters?" on page
    And User clicks on "Onboarding Back" button
    And Set & Verify "Max price filter"
    And User clicks on "skip" option
    And Verify User is returned to SRP View
    Then User closes the app
