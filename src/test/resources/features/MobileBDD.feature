#PDP Feature - @Author Syed Zubair Mehdi
#BDD Feature Mobile
@Regression
Feature: Sanity suite (Android)

  Background: 
    Given Launch the Owners App

  @Sanity 
  Scenario: New User Registration (TC-4060),(TC-15246),(TC-15249)  
    When User clicks on "skip" option
    And User clicks on "SigninTabFooter" option
    And User clicks on "Register" option
    And Enters "First Name"
    And Enters "Last Name"
    And Enters "email ID"
    And Enters "Password"
    And User clicks on "Registration" option
    And Validate Sign in button replaced by Me button
    Then User closes the app
  
  @Sanity
  Scenario: Validate User Sign in & signout happens Successfully (TC-4061),(TC-4062),(TC-15247),(TC-15249),(TC-15250),(TC-15251)    
    When User clicks on "skip" option
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And Validate Sign in button replaced by Me button
    And User clicks on "SignOut" option
    And Validate that user as successfully logged out
    Then User closes the app
   
  @Sanity 
  Scenario: Validate Onboarding users Registration Filters (TC-4061),(TC-15270),(TC-15271),(TC-15275)  
    When User enters city "Miami,FL" in onboarding search Bar
    And Validate text "What's your price range" on page
    And Validate text "Don't worry - you can change this later" on page
    And Set & Verify "Max price filter"
    And Set & Verify "Min price filter"
    And User clicks on "Next" option
    And set and validate any "Bath" value
    And set and validate any "Bed" value
    And User clicks on "NextSaveSearchButton" option
    And Validate text "Want to save this search" on page
    And Validate text "Sign in to save it - it's that easy" on page
    And validate Location "Miami,Fl" on save search page
    And Validate set price range - min & max and bed count
    And User clicks on "Sign in to save" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And Validate text "tell us about your home search" on page
    And User clicks on "surveyskiplink" option
    And Validate filtercount on SRP page and click on filter option
    And set price range picker to $500k
    And User clicks on "FiltersDone" option
    And Validate presence of saved button and it is enabled
    And Validate price,bed,bath count and Location on SRP page
    Then User closes the app

  @Sanity
  Scenario: Validate presence of Map,List & Swipe Tabs and its buttons #(Tc-4064)
    When User clicks on "skip" option
    And User enters city "Miami,FL" in search Bar
    And Validate presence of "Map" Tab
    And Validate presence of "List" Tab
    And Validate presence of "Swipe" Tab
    Then User closes the app

  @Sanity 
  Scenario: FavouritePropertyValidation (TC-4081)
    When User clicks on "skip" option
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And User enters city "Miami,FL" in search Bar
    And compare property details from List view & Favourite tab
    Then User closes the app

  @Sanity
  Scenario: Validate PDP components (TC-4082),(TC-12763) (TC-5910) (TC-6681)
    When User clicks on "skip" option
    And User enters city "Washington,DC" in search Bar
    And validate "property details like price,bath sqft etc" section
    And validate "school" section
    And validate "Notes" section
    And validate "property status" section
    And validate "property tax" section
    And validate "get direction" section
    And validate "estimated monthly payment & mortagage calculator" section
    And validate "property type" section
    Then User closes the app

  @Sanity
  Scenario: Validating discover tab components (Tc-4086)
    When User clicks on "skip" option
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And Navigates to "Discover" Tab
    And validate "recently viewed section" section
    And validate "saved search" section
    And validate "Advice" section
    Then User closes the app

  @Sanity
  Scenario: Validate search filter (TC-4066),(TC-1234)
    When User clicks on "skip" option
    And User enters city "30350,Atlanta" in search Bar
    And select and apply bed bath and price filters
    And Validate filters applied
    Then User closes the app

   @Sanity
   Scenario: Verify RVP section is updated when user open a PDP from Onboarding (TC-8514)
    When User opens PDP from Onboarding
    And User clicks on "back" option
    When User clicks on "skip" option
    And Navigates to "Discover" Tab
    And validate "recently viewed section" section
    Then User closes the app
   
