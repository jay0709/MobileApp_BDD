#Discover Tab:-@Author:- Syed Zubair Mehdi
@Regression
Feature: Discover Tab

  Background: 
    Given Launch the Owners App
    When User clicks on "skip" option

  Scenario: As UnAuthenticated user i should see "Recently Viewed" & "Advice" Section (TC-13139),(TC-13141),(TC-13146),(TC-13144) (TC-8511)	
    When User enters city "Concorde,CA" in search Bar
    And User Clicks on any property to navigate to pdp page
    And User clicks on "back" option
    And Navigates to "Discover" Tab
    And validate "recently viewed section" section
    And validate "Advice" section
    Then User closes the app

  Scenario: As Authenticated user i should see "Recently Viewed" & "Advice" Section(TC-13139),(TC-13141) (TC-2749) (TC-2748) (TC-9124)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And Navigates to "Discover" Tab
    And validate "recently viewed section" section
    And Click on any property in recently viewed section
    And verify pdp page opens
    And User clicks on "back" option
    And validate "Advice" section
    Then User closes the app

  Scenario: As an user i should be able to Navigate b/w different tabs(TC-13143),(TC-13164),(TC-13165),(TC-13166),(TC-13167) (TC-2740)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And Navigates to "Favorites" Tab
    And Navigates to "Discover" Tab
    And Navigates to "Contact Us" Tab
    And Navigates to "Search" Tab
    And User Taps on option "Me"
    And User clicks on "SignOut" option
    And Validates "sign in" text
    Then User closes the app

  Scenario: verify saved searches are displayed in "Just For Me" Section (TC-13140),(TC-13144),(TC-13147),(TC-13159) (TC-9338)
    And User enters city "Concord,CA" in search Bar
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And click on "Save Search" option
    And Navigates to "Discover" Tab
    And verifys saved search property "Concord,CA" is displayed in "Just for Me" section
    Then User closes the app

  #Scenario: Validate All tiles in advice section (TC-13148),(TC-13149),(TC-13150),(TC-13151),(TC-13152),(TC-13153),(TC-13154),(TC-13155),(TC-13156),(TC-13157),(TC-13158)
    #And Navigates to "Discover" Tab
    #And Verify "8 Questions to Ask When Buying a House" tiles with contents present in advice section
    #And Verify "5 Tips for winning a Home bidding war" tiles with contents present in advice section
    #And Verify "4 Things You Need to Get Your First Home Mortgage" tiles with contents present in advice section
    #And Verify "9 Simple Ways to Start Saving for a Down Payment" tiles with contents present in advice section
    #And Verify "Closing Costs 101: What Should You Expect?" tiles with contents present in advice section
    #And Verify "Buying and Selling a Home: 5 Tips for Deciding What to Do First" tiles with contents present in advice section
    #And Verify "How Much House Can You Afford? 3 Key Questions to Ask Yourself" tiles with contents present in advice section
    #And Verify "6 Ways to Compete with an All-Cash Buyer" tiles with contents present in advice section
    #And Verify "Getting Approved for a Mortgage: The Role of Your Credit History" tiles with contents present in advice section
    #And Verify "Buying a Condo: What You Need to Know" tiles with contents present in advice section
    #Then User closes the app

  #Scenario: verify Just for Me showing (250K-650k),Single Family and 3+ beds suggestions (TC-13160),(TC-13161),(TC-13162),(TC-13163)
    #And User enters city "Concord,CA" in search Bar
    #And User clicks on "SigninTabFooter" option
    #And Enters "signinemailid"
    #And Enters "SigninPassword"
    #And User clicks on "onboarding_SignInBtn" option
    #And Navigates to "Discover" Tab
    #And User scrolls to text "Advice" 
    #And verifys suggestions
      #| 250k-600k     |
      #| Single Family |
      #| 3+ Beds       |
    #Then User closes the app

  Scenario: Verify new  Listing section in Discover Tab (TC-13171),(TC-13173),(TC-13174),(TC-13175),(TC-13181)
    And User enters city "Washington,DC" in search Bar
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And click on "Save Search" option
    And Navigates to "Discover" Tab
    And User Scroll upwards
    And verify New Listing section is updated with saved search
    And Clicks on any property on "New Listing" section
    Then User closes the app

  Scenario: Verify New Listing section is not updated/deleted when saved search is deleted(TC-13172)
    And User enters city "Washington,DC" in search Bar
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And click on "Save Search" option
    And Navigates to "Discover" Tab
    And delete "Saved Search property"
    And Verify New listing property is not impacted
    Then User closes the app

  Scenario: Save Search Multiple Locations and do clear data and verify "New Listing" section does not exist (TC-13179)
    And User enters city "Washington,DC" in search Bar
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And click on "Save Search" option
    And User enters city "Concorde,CA" in search Bar
    And User clicks on "Save Search" option
    And User clears app data
    And User clicks on "skip" option
    And Navigates to "Discover" Tab
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And Validate "New Listings" is not displayed
    Then User closes the app

  Scenario: verify property recommendation section in discover tab (TC-13183),(TC-11434),(TC-11434) (TC-14646)
    And User enters city "Concorde,CA" in search Bar
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And User marks property as favourite
    And Navigates to "Discover" Tab
    And User scrolls to text "Recommended Properties"
    And validate "Recommended Properties" section
    Then User closes the app

  #Scenario: For Authecticated users Recommended section should not display if property is not favourited(TC-13184)
    #And User enters city "Concorde,CA" in search Bar
    #And User clicks on "SigninTabFooter" option
    #And Enters "signinemailid"
    #And Enters "SigninPassword"
    #And User clicks on "onboarding_SignInBtn" option
    #And check if No saved listings are present
    #And Navigates to "Discover" Tab
    #And Validate "Recommended Properties" is not displayed
    #Then User closes the app

  Scenario: For unauthenticated users Recommended section should not display(TC-13185),(TC-11433)
    And Navigates to "Discover" Tab
    And Validate "Recommended Properties" is not displayed
    Then User closes the app

  Scenario: Favouriting a property in recoommended section,should not display the favourited property(TC-13186 ),(TC-11431),(TC-11436 ),(TC-14659)
    And User enters city "Concorde,CA" in search Bar
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And User marks property as favourite
    And Navigates to "Discover" Tab
    And User scrolls to text "Open Houses Nearby"
    And Verifys property details is shown in recommended properties
    And Clicks on any property on "Recommended Properties" section
    And Validate "Favourited Property in Recommended section" is not displayed
    Then User closes the app
    
   Scenario: Verify recommended properties section is not showing the saved property (TC-11440)
     And User enters city "Concorde,CA" in search Bar
     And User clicks on "SigninTabFooter" option
     And Enters "signinemailid"
     And Enters "SigninPassword"
     And User clicks on "onboarding_SignInBtn" option
     And click on "Save Search" option
     And Navigates to "Discover" Tab
     And User scrolls to text "Recommended Properties"
     #And Verify Recommended property is not updated with saved search
     Then User closes the app
     
    Scenario: Verify the user should be able to see the Heart icon in RVP in PDP (TC-9115),(TC-9117),(TC-9120),(TC-9122),(TC-9123),(TC-8508)
     And User enters city "Concorde,CA" in search Bar
     And User clicks on "SigninTabFooter" option
     And Enters "signinemailid"
     And Enters "SigninPassword"
     And User clicks on "onboarding_SignInBtn" option
     And User marks property as favourite in srp page
     And User Retrieves Property Price
     And User clicks on "back" option
     And User Scroll upwards
     And User Clicks on any property to navigate to pdp page
     And User scrolls to text "Recently Viewed"
     And Verify favourited property are displayed in recently viewed in pdp
     And Click on any property in recently viewed section
     And User scrolls to text "Recently Viewed"
     And Verify favourited property are displayed in recently viewed in pdp
     And User clicks on "back" option
     And User clicks on "back" option
     And User Taps on option "Me"
     And User clicks on "SignOut" option
     And User Clicks on any property to navigate to pdp page
     And Validate "Favourited Property in Recently Viewed" is not displayed
     Then User closes the app
   
    Scenario: Verify Open Houses for section in discover Tab 	(TC-14655) (TC-14656)
     And User enters city "Concorde,CA" in search Bar
     And User clicks on "SigninTabFooter" option
     And Enters "signinemailid"
     And Enters "SigninPassword"
     And User clicks on "onboarding_SignInBtn" option
     And Navigates to "Discover" Tab
     And User scrolls to text "Open Houses Nearby"
     And Verify Open House Tag & Time are displayed
     And Verify Open House Property details is shown
     Then User closes the app  
     
    Scenario: Verify the change of index of property in RVP Section  (TC-9119) 
     And User enters city "Concord,CA" in search Bar
     And User clicks on "SigninTabFooter" option
     And Enters "signinemailid"
     And Enters "SigninPassword"
     And User clicks on "onboarding_SignInBtn" option
     And User Clicks on any property to navigate to pdp page
     And Favourites a property in PDP page and verify favourited property in discover tab
     And User enters city "Miami,FL" in search Bar
     And User Clicks on any property to navigate to pdp page
     And User clicks on "back" option
     And Navigates to "Discover" Tab
     And Verify index change when property is unfavorited from pdp
     Then User closes the app
     
    Scenario: Verify the property showing heart icon in discover tab after asset addition (TC-9121)
     And User enters city "Dallas,TX" in search Bar
     And User clicks on "SigninTabFooter" option
     And Enters "signinemailid"
     And Enters "SigninPassword"
     And User clicks on "onboarding_SignInBtn" option
     And User Clicks on any property to navigate to pdp page
     And User adds a comment and verifies if the comment is displayed in pdp page
     And Validate Property auto-favorited
     And Confirm the same PDP is showing heart icon in discover tab 
     Then User closes the app
     
    Scenario: Verify the property showing heart icon in discover tab after asset addition (TC-9121)
     And User enters city "Palo Alto,CA" in search Bar
     And User clicks on "SigninTabFooter" option
     And Enters "signinemailid"
     And Enters "SigninPassword"
     And User clicks on "onboarding_SignInBtn" option
     And User clicks on filters tab and enables open house filter
     And User Clicks on any property to navigate to pdp page
     And User saves open house
     And Validate Property auto-favorited
     And Confirm the same PDP is showing heart icon in discover tab
     Then User closes the app
     
    Scenario: Verify the property showing heart icon in discover tab after login from PDP (TC-9125)
     And User enters city "Miami,FL" in search Bar
     And User Clicks on any property to navigate to pdp page
     And User click favorite icon in PDP
     And Enters "signinemailid"
     And Enters "SigninPassword"
     And User clicks on "onboarding_SignInBtn" option
     And Validate Property auto-favorited
     And Confirm the same PDP is showing heart icon in discover tab
     Then User closes the app
     
     
	Scenario: Verify Recommended properties changed when logged in with different user (TC-11439)
	 And User enters city "Atlanta,GA" in search Bar
	 And User clicks on "SigninTabFooter" option
     And Enters "signinemailid"
     And Enters "SigninPassword"
     And User clicks on "onboarding_SignInBtn" option
     And Navigates to "Discover" Tab
     And User scrolls to text "Open Houses Nearby"
     And Check the address of the first property before sign out
     And Validate Sign in button replaced by Me button
     And User clicks on "SignOut" option
     And Validate that user as successfully logged out
     And User clicks on "SigninTabFooter" option
     And Enters "signinemailid2"
     And Enters "SigninPassword2"
     And User clicks on "onboarding_SignInBtn" option
     And Navigates to "Discover" Tab
     And User scrolls to text "Open Houses Nearby"
     And Check the address of the first property after signed in new account
	 Then User closes the app
	 
	Scenario: Verify the new listings are for current search term  (TC-14651)
	 And User enters city "Washington,DC" in search Bar
	 And User verify the same search term in New Listings
	 Then User closes the app
	 
	Scenario: Verify open houses are from current search rather than current saved search (TC-14661)
	   And User enters city "Atlanta,GA" in search Bar
	   And User clicks on "SigninTabFooter" option
	   And Enters "signinemailid"
     And Enters "SigninPassword"
     And User clicks on "onboarding_SignInBtn" option
     And click on "Save Search" option
     And Navigates to "Discover" Tab
     And User scrolls to text "Just for Me"
     And Verify Open House Tag & Time are displayed
     And Verify Open House Property details is shown
     And User enters city "Concord,CA" in search Bar
     And User verify the same search term in Open Houses
	 Then User closes the app
	 
	Scenario: Verify no Recommended properties for guest user (TC-14645) (TC-14644)
	 And User enters city "Concord,CA" in search Bar
	 And Navigates to "Discover" Tab
	 And Check for the Recommended Properties section
	 And User clicks on "SigninTabFooter" option
	 And Enters "signinemailid"
	 And Enters "SigninPassword"
	 And User clicks on "onboarding_SignInBtn" option
	 And Check for the Recommended Properties section
	 Then User closes the app
	 
	Scenario: Verify the updated RVP section when logged in from PDP (TC-8509)
	 And User enters city "Concord,CA" in search Bar
	 And User Clicks on any property to navigate to pdp page
	 And User Sign in from Notes section
	 And Enters "signinemailid"
	 And Enters "SigninPassword"
	 And User clicks on "onboarding_SignInBtn" option
	 And User adds a comment and verifies if the comment is displayed in pdp page
	 And Validate Property auto-favorited
	 And Confirm the same PDP is showing heart icon in discover tab 
	 Then User closes the app
	 
	 
	Scenario: Verify Most recent search & search my location is not present (TC-8833) (TC-8834) (TC-8835) (TC-8836)
	 And User enters city "Atlanta,GA" in search Bar
	 And Navigates to "Discover" Tab
	 And Verify Most recent search and search my location is not present 
	 And User clicks on "SigninTabFooter" option
	 And Enters "signinemailid"
   And Enters "SigninPassword"
   And User clicks on "onboarding_SignInBtn" option
   And Verify Most recent search and search my location is not present
   Then User closes the app
   
	 
	Scenario: Verify the Just For Me section is updated with search but not filter search (TC-9340) (TC-9342)
	 And User enters city "Atlanta,GA" in search Bar
	 And Navigates to "Discover" Tab
	 And User verfies the location in Just for me
	 And Navigates to "Search" Tab
	 And User enters city "94521,Concord,CA" in search Bar
	 And User clicks on filters tab and enables open house filter
	 And Navigates to "Discover" Tab
	 And User verfies the location in Just for me
	 Then User closes the app
	 
	 
	Scenario: Verify the change of index of property in RVP Section  (TC-9118) (TC-581)
     And User enters city "Concord,CA" in search Bar
     And User clicks on "SigninTabFooter" option
     And Enters "signinemailid"
     And Enters "SigninPassword"
     And User clicks on "onboarding_SignInBtn" option
     And User Clicks on any property to navigate to pdp page
     And Favourites a property in PDP page and verify favourited property in discover tab
     And check if No saved listings are present
     And Navigates to "Discover" Tab
     Then User closes the app
   
   Scenario: Verify the order of all the tabs (TC-2983) (TC-2984) (TC-2985)
     And User clicks on "SigninTabFooter" option
     And Enters "signinemailid"
     And Enters "SigninPassword"
     And User clicks on "onboarding_SignInBtn" option
     And User verify the order of the tabs
     Then User closes the app
     
     
     
     
   
	 
	 
	 
     
    
