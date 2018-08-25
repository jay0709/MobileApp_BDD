#Author :- jayabrata
@Regression
Feature: Me Tab

  Background: 
    Given Launch the Owners App
    When User clicks on "skip" option
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    Then User clicks on "onboarding_SignInBtn" option
    And User Taps on option "Me"

  Scenario: Verify by clicking on me Tab ,user can validate (TC-13225)
    And Verify different options in ME tab are present
      | Edit Profile           |
      | Update Password        |
      | My Tours & Open Houses |
      | Sell My Home           |
      | Notifications          |
      | Help                   |
      | Privacy Policy         |
      | Terms and Conditions   |
      | FAQs                   |
      | FeedBack               |
      | Sign Out               |
    Then User closes the app

  Scenario: verify user can edit profile and edits first name.last name etc (TC-13226),(TC-13227)
    And User clicks on "Edit" button
    And Verify if "Edit Profile Page" is displayed
    And Edits "Firts Name"
    And Edits "Last Name"
    And Edits "Location"
    And User clicks on "back" option
    And Verify "First & Last Name" fields are updated
    And Verify "Location" fields are updated
    Then User closes the app

  Scenario: validate working of sell My Home,privacy policy,Help,Terms and conditions,FAQs etc (	TC-13228),(TC-13229)
    And Validate all options in ME tab
      | Sell My Home       |
      | Privacy Policy     |
      | Help               |
      | Terms & Conditions |
      | FAQ's              |
    Then User closes the app

  Scenario: validate Sign Out option working and verify Sell My Home option is not present for non-logged user (TC-13230)
    And User clicks on "SignOut" option
    And User clicks on "SigninTabFooter" option
    And Verify it asks user to login
    And Validate "Sell My Home" is not displayed
    Then User closes the app

  Scenario: verify if user can submit feedback (TC-13232)
    And User scrolls to text "Feedback"
    And User clicks on "Feedback" button
    And User submits feed back form
    Then User closes the app

  Scenario: validate notifications components and toggles,and My Tour and open Houses (TC-13235),(TC-13236)
    And User clicks on "Notifications" button
    And Validates all notifications and toggles
    And User clicks on "back" option
    And User Taps on option "My Tours & Open Houses"
    And Validates "Requested Tours" tab
    And User Taps on option "Saved Open House"
    And Validates "Saved Open Houses" tab
    Then User closes the app
