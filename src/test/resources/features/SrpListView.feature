#List SRP - @Author Jayabrata
@Regression
Feature: SRP View

	Background: 
     Given Launch the Owners App
     When User clicks on "skip" option
    
    Scenario: As a user I can sort the propties according to Price	(TC-515) (TC-283) (TC-284)
     When User enters city "Miami,FL" in search Bar
     And User clicks on "List" Tab
     And User sort properties from low to high
     And User sort properties from high to low
     Then User closes the app
     
    Scenario: As a user I can sort properties according to Listing age & Featured Listings (TC-285) (TC-286) (TC-287)
     When User enters city "Dallas,TX" in search Bar
     And User clicks on "List" Tab
     And User sort properties acoording to listing age
     And User sort properties according to featured listings
     Then User closes the app
     
    Scenario: Count the number of image while swipe in list srp (TC-9107)
     When User enters city "Concord,CA" in search Bar
     And User clicks on "List" Tab
     And Count number of images in list tab while swipe
     Then User closes the app
     
    Scenario: Verify the MlsId Board Name Listing Courtesy (TC-5372) (TC-5376)
     When User enters city "Concord,CA" in search Bar
     And User clicks on "List" Tab
     And User verify the MlsId Board Name Listing Courtesy in list 
     Then User closes the app
     
    Scenario: Verify sign in prompt for guest user & signs in (TC-512) (TC-513) (TC-511)
     When User enters city "Concord,CA" in search Bar
     And User clicks on "Swipe" Tab
     And User swipe right to favorite property
     Then User closes the app
     
    Scenario: Verify the up to date card (TC-9143) (TC-9144) (TC-9145) (TC-5374)
     When User enters city "Concord,CA" in search Bar
     And User clicks on "SigninTabFooter" option
     And Enters "signinemailid"
     And Enters "SigninPassword"
     And User clicks on "onboarding_SignInBtn" option
     And User verifies the upto date card
     And User navigate to other screens using the card view
     Then User closes the app
     
     Scenario: Verify the UI elements in Swipe tab (TC-9141) (TC-5875) (TC-9142) (TC-9148) (TC-1175) (TC-1177) (TC-1178)
      When User enters city "Palo Alto,CA" in search Bar
      And User clicks on "Swipe" Tab
      And Verify all property details
      Then User closes the app

     Scenario: Verify no properties message when no properties availavle in search (TC-9147) (TC-5899) (TC-5903) (TC-5905) (TC-5904)
      When User enters city "Delaney Square,TN" in search Bar
      And User clicks on "Swipe" Tab
      And User verify the no property found message
      And User clicks on "SigninTabFooter" option
      And Enters "signinemailid"
      And Enters "SigninPassword"
      And User clicks on "onboarding_SignInBtn" option
      And User verify same message for different cases
      Then User closes the app
      
     Scenario: Verify sign in prompt for guest user & signs in 	(TC-9146)
      When User enters city "Atlanta,GA" in search Bar
      And User clicks on "Swipe" Tab
      And Verify no up to date card while pagination
      Then User closes the app
     
     Scenario: Verify user can search in Swipe view (TC-510)
      When User enters city "Atlanta,GA" in search Bar
      And User clicks on "Swipe" Tab
      And User search in Swipe tab
      Then User closes the app
	
	
     
     
     