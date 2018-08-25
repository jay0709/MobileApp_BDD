#PDP Feature - @Author jayabrata
@Regression
Feature: Favourite Tab

  Background: 
    Given Launch the Owners App
    When User clicks on "skip" option
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    Then User clicks on "onboarding_SignInBtn" option

  Scenario: Check if No favourites are present (TC-11210)
    And check if No saved listings are present
    Then User closes the app

  Scenario: Adding , editing & deleting comment and verifying (TC-11222),(TC-11282),(TC-11280),(TC-11259),(TC-12630)
    When User enters city "Concord,CA" in search Bar
    And  Verify user is logged in before save Listing
    And  Verify latest comment added with last comment displayed
    And  User edits the latest comment added
    And  User deletes the latest comment added
    And check if No saved listings are present
    Then User closes the app

  Scenario: Adds image from camera and then deletes the image(Asset) (TC-11221) (TC-11225),(TC-11236),(TC-12631)
    When User enters city "Washington,DC" in search Bar
    And  Verify user is logged in before save Listing 
    And User Adds image from assest and verifys
    And User deletes the image added
    And User deletes the latest comment added
    And check if No saved listings are present
    Then User closes the app

  Scenario: Add image from Gallery and then deletes the image (TC-11235),(TC-11236),(TC-11238)
    When User enters city "Concord,CA" in search Bar
    And  Verify user is logged in before save Listing 
    And User Adds image from Gallery and verifys
    And User deletes the image added
    And User deletes the latest comment added
    And check if No saved listings are present
    Then User closes the app

   Scenario: verify image thumbnail in favourite tab from camera and Gallery(TC-12636),(TC-12637)
    When User enters city "Concord,CA" in search Bar
    And  Verify user is logged in before save Listing 
    And User Adds image from assest and verifys
    And User clicks on "Show All" button
    And Verify if image thumbnail is viewable in collapse view
    And User clicks on "collapse Notes" button
    And User deletes the image added
    And User deletes the latest comment added
    And User Adds image from Gallery and verifys
    And Verify if image thumbnail is viewable in collapse view
    And User clicks on "collapse Notes" button
    And User deletes the image added
    And User deletes the latest comment added
    And check if No saved listings are present
    Then User closes the app

  Scenario: Count Images in favourite tab (TC-11242),(TC-11243),(TC-11211)(TC-11212)
    When User enters city "Concord,CA" in search Bar
    And  Verify user is logged in before save Listing 
    And Count number of images in favourite tab while swipe
    And check if No saved listings are present
    Then User closes the app

  Scenario: Set favourite property from Map View (TC-11208)
    And User enters city "Joseph city,AZ" in search Bar
    And User sets favourite property from Map view
    Then User closes the app

  Scenario: Add&DeleteMultiLine comments and verify (TC-11227)
    When User enters city "Concord,CA" in search Bar
    And  Verify user is logged in before save Listing 
    And add & delete multi line comments and verify
    And check if No saved listings are present
    Then User closes the app

  Scenario: Verify Asset in PDP Gallery (TC-11236),(TC-11238)
    When User enters city "Concord,CA" in search Bar
    And  Verify user is logged in before save Listing 
    And User adds image to view in PDP
    And User deletes the image added
    And User deletes the latest comment added
    And User clicks on "back" option
    And check if No saved listings are present
    Then User closes the app

  Scenario: verifyAssetInFavTab (TC-11225)(TC-11226)(TC-11228)
    And Add asset in favourite tab to view
    And check if No saved listings are present
    Then User closes the app

  Scenario: verifyToastMessageAfterfavorite (TC-11248)(TC-11249)
    And User enters city "Marietta,GA" in search Bar
    And User marks property as favourite
    Then User closes the app

  Scenario: verify schedule tour option ,user details and available times (TC-11271)(TC-11273)(TC-11274)(TC-11275)(TC-11278)
    And User verifys schedule tour in favourite tab
    And Check available times to schedule a tour
    And Verify User Details
    Then User closes the app

  Scenario: Verify No schedule tour option for FSBO property (TC-11272)
    And check if No saved listings are present
    And Verify No schedule tour option is present for FSBO property
    Then User closes the app

  Scenario: Add multiple assest in PDP (TC-11222)
    And Add multiple assests in PDP and verify
    And check if No saved listings are present
    Then User closes the app
