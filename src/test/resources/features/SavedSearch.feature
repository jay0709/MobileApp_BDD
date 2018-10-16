#Saved Search - @Author Syed Zubair Mehdi
@Regression
Feature: Saved Search Feature

 Background:
    Given Launch the Owners App
    When User clicks on "skip" option

 Scenario: A logged user should be able to view all saved searches(TC-2968)
    And User enters city "Washington,DC" in search Bar
    And User clicks on "Search" field
    And Verify if "Most Recent Search" is displayed
    And Verify if "Search Nearby" is displayed
    And User searches property with value "Miami Heights Elementary School" in search Bar
    And User clicks on "Search" field
    And Verify if "School Name" is displayed in most recent search
    Then User closes the app

 Scenario: Verify logged in user is able to view saved search,edit and delete saved search option (TC-2979),(TC-2980),(TC-2981),(TC-2972),(TC-2973),(TC-2974),(TC-2976),(TC-3729),(TC-3730),(TC-3731),(TC-3733),(TC-3734),(TC-3745),(TC-5925)
    And User enters city "Washington,DC" in search Bar
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And click on "Save Search" option
    And Navigates to "Discover" Tab
    And User clicks on three dot menu
    And Verify if "View Saved Search" is displayed
    And Verify if "Edit Saved Search" is displayed
    And Verify if "Delete Saved Search" is displayed
    And User clicks on "View Saved Search" button
    And User clicks on "List" Tab
    And Verify if "View Saved Search Results" is displayed
    And Navigates to "Discover" Tab
    And User clicks on three dot menu
    And User clicks on "Edit Saved Search" button
    And Verify if "Filter Page" is displayed
    And Apply filters on "Beds"
    And Verify if "Search results in srp" is displayed
    And Navigates to "Discover" Tab
    And Verify Saved Search is updated with filter
    And User clicks on three dot menu
    And User clicks on "Delete Saved Search" button
    And Validate "Saved Searches" are deleted
    Then User closes the app

 Scenario: Verify for non-logged in user is not able to view saved search option (TC-2969)
    And Navigates to "Discover" Tab
    And Validate "Saved Searches Header" is not displayed
    Then User closes the app

 Scenario: User should see star icon and list of filters is saved search (TC-2971),(TC-2975),(TC-3724),(TC-3725),(TC-3727),(TC-3728)
    And User enters city "Washington,DC" in search Bar
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And Apply filters on "Beds and Baths"
    And click on "Save Search" option
    And User clicks on "Search" field
    And Verify if "Saved Searches" is displayed in most recent search
    And User enters city "Atlanta,GA" in search Bar
    And click on "Save Search" option
    And Navigates to "Discover" Tab
    And Verify if "Star Icon in saved search" is displayed
    And Verify Saved Search is updated with filter
    And Verify Multiple tiles present in "Saved Searches" tab
    Then User closes the app

 Scenario: Verify Saved Searches in Notifications tab (TC-2977),(TC-2978)
    And User enters city "Washington,DC" in search Bar
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And Apply filters on "Beds and Baths"
    And click on "Save Search" option
    And User Taps on option "Me"
    And User clicks on "Notifications" button
    And Verify the state is Instant by default for the saved search
    And Verify if "Applied Filter in Notifications" is displayed
    Then User closes the app

Scenario: Verify if the view saved search and edit saved search can be accessed from search bar(TC-3746),(TC-3747),(TC-5382),(TC-5383),(TC-5386),(TC-5387),(TC-5390),(TC-5393),(TC-5923),(TC-5924),(TC-5927)
    And User enters city "Washington,DC" in search Bar
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And click on "Save Search" option
    And User clicks on "Search" field
    And Verify "View Saved Search" can be accessed from Search Bar
    And User clicks on "View Saved Search" button
    And User clicks on "List" Tab
    And Verify if "View Saved Search Results" is displayed
    And User clicks on "Search" field
    And Verify "Edit Saved Search" can be accessed from Search Bar
    And User clicks on "Edit Saved Search" button
    And Verify if "Filter Page" is displayed
    And Apply filters on "Beds"
    And User clicks on "Search" field
    And Verify updated saved search is displayed in search bar
    And Apply filters on "Beds and Baths"
    And User Taps on option "Me"
    And User clicks on "Notifications" button
    And User scrolls to text "Instant"
    And Verify if "Applied Filter in Notifications" is displayed
    And Navigates to "Discover" Tab
    And Verify Saved Search is updated with filter
    Then User closes the app

 Scenario: Verify User is able to delete saved search by clicking on star icon (TC-5389),(TC-5391),(TC-5926)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And User enters city "Joseph City,AZ" in search Bar
    And Apply filters on "Beds and Baths"
    And Navigates to "Discover" Tab
    And Validate "Saved Search with Joseph City" is not displayed
    And Navigates to "Search" Tab
    And click on "Save Search" option
    And Navigates to "Discover" Tab
    And User clicks on "Star Icon" button
    And Validate "Saved Search with Joseph City" are deleted
    And User closes the app

 Scenario: Verify old saved search is not replaced when clicked on cancel button and edited saved seearch should be showed as most recent search(TC-5392),(TC-3735)
    And User enters city "Washington,DC" in search Bar
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And Apply filters on "Beds and Baths"
    And click on "Save Search" option
    And Navigates to "Discover" Tab
    And Apply new bed filter and click on cancel
    And Navigates to "Discover" Tab
    And Verify the same saved search with old filters is retained
    And User clicks on three dot menu
    And User clicks on "Edit Saved Search" button
    And Clear All Filters
    And Apply filters on "Beds"
    And Navigates to "Discover" Tab
    And Verify that edited saved search is showed as most recent saved search
    Then User closes the app