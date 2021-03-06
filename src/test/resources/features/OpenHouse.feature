#PDP Feature - @Author Syed Zubair Mehdi
#@Regression
Feature: Open House

Background: 
Given Launch the Owners App
When User clicks on "skip" option


Scenario: VerifyOpenHousePropertyInSRP (TC-10819/QO-14413),(TC-10820/QO-14414),(TC-10821/QO-14415),(TC-10833/QO-14427)
When User enters city "Dallas,TX" in search Bar
And  User clicks on filters tab and enables open house filter
And  Verify open house filter is applied in SRP page
Then User closes the app

Scenario: Save Open House From PDP and Compare Open House SRP page adress with PDP page address (TC-10844/QO-14438),(TC-10813),(TC-10823),(TC-10824/QO-14418),(TC-10840)
When User enters city "Dallas,TX" in search Bar
And  User clicks on filters tab and enables open house filter
And User clicks on "SigninTabFooter" option
And Enters "signinemailid"
And Enters "SigninPassword"
And User clicks on "onboarding_SignInBtn" option
And User compares dates in srp and pdp page
And User compares time in both srp and pdp page
And User saves open house
And View saved open house 
And User compares address in both srp and pdp page 
Then User closes the app

Scenario: Verify and copy address in open house section (TC-10851/QO-14445)
And User clicks on "SigninTabFooter" option
And Enters "signinemailid"
And Enters "SigninPassword"
And User clicks on "onboarding_SignInBtn" option
And User Taps on option "Me"
And User Taps on option "My Tours & Open Houses" 
And User Taps on option "Saved Open House"
And User Taps on option "Open House Menu address"
And Users verifys opening of PDP page from open House section
Then User closes the app

Scenario: Verification of functionalities like Schedule a tour,Get Directions,Add to calender,Delete etc (TC-10852/QO-14446)(TC-10853/QO-14447)(TC-10854/QO-14448)(TC-10855/QO-14449)(TC-10850/QO-14444)
And User clicks on "SigninTabFooter" option
And Enters "signinemailid"
And Enters "SigninPassword"
And User clicks on "onboarding_SignInBtn" option
And User Taps on option "Me"
And User Taps on option "My Tours & Open Houses" 
And User Taps on option "Saved Open House"
And User Taps on option "Open House Menu address"
And User Verifys "Request a tour" section opens from open house menu
And User Verifys "Get Direction" section opens from open house menu
And User Verifys "Add to calender" section opens from open house menu
And User deletes open house from open house menu section
Then User closes the app

Scenario: user Verifys open houses in discover tab and verifys total openhouses (TC-10864),(TC-10838)-d
And User clicks on "SigninTabFooter" option
And Enters "signinemailid"
And Enters "SigninPassword"
And User clicks on "onboarding_SignInBtn" option
And Navigates to discover tab to verify open houses available
And User Taps on option "Me"
And User Taps on option "My Tours & Open Houses" 
And counts the number of open houses
Then User closes the app


Scenario: Pin view from cluster (TC-10821/QO-14415),(TC-10822/QO-14416)
When User enters city "Atlanta,GA" in search Bar
And  User sets filter to Less than 7 days
And  User verifys if pin view is enabled
Then User closes the app

Scenario: Set filter to display open houses within 7 days and verify new tag of open house is map and list view (TC-10823/QO-14417),(TC-10825/QO-14419),(TC-10827/QO-14421)
When User enters city "Atlanta,GA" in search Bar
And  User sets filter to Less than 7 days
Then User closes the app


Scenario: verify save search state  not gets affected after turning on open house filter(TC-10839/QO-14433)
When User enters city "Atlanta,GA" in search Bar
And User clicks on "SigninTabFooter" option
And Enters "signinemailid"
And Enters "SigninPassword"
And User clicks on "onboarding_SignInBtn" option
And User verifys saved text is not changed after applying open house filter
Then User closes the app

Scenario: Verify Open House Tag & Time in discover tab (TC-10864/QO-14458)
When User enters city "Atlanta,GA" in search Bar
And  User clicks on filters tab and enables open house filter
And User clicks on "SigninTabFooter" option
And Enters "signinemailid"
And Enters "SigninPassword"
And User clicks on "onboarding_SignInBtn" option
And Verify Open House tag & time are displayed in discover tab 
Then User closes the app

Scenario: Favourite and unfavourite property and verify in discover tab page (TC-10873/QO-14467),(TC-/QO-14468),(TC-10872/QO-14466),(TC-10871/QO-14465)
When User enters city "Atlanta,GA" in search Bar
And  User clicks on filters tab and enables open house filter
And User clicks on "SigninTabFooter" option
And Enters "signinemailid"
And Enters "SigninPassword"
And User clicks on "onboarding_SignInBtn" option
#And  Clicks on a open House Property
And  Favourites a property in PDP page and verify favourited property in discover tab
And  Unfavourite the property in favourite tab and verify unfavourited property in discover page
Then User closes the app


Scenario: Edit saved search (TC-10870/QO-14464)
And User clicks on "SigninTabFooter" option
And Enters "signinemailid"
And Enters "SigninPassword"
And User clicks on "onboarding_SignInBtn" option
And  Navigates to "Discover" Tab
And  Edit Saved search and verify open house list is updated in discover tab 
Then User closes the app

Scenario: verify network error in saved open houses section (TC-10856/QO-14450)
When User enters city "Dallas,TX" in search Bar
And User clicks on filters tab and enables open house filter
And User clicks on "SigninTabFooter" option
And Enters "signinemailid"
And Enters "SigninPassword"
And User clicks on "onboarding_SignInBtn" option
#And verifys network error in saved open house section 
Then User closes the app

Scenario: No openHouses should be shown for unauthenticated users (TC-10840/QO-14434),(TC-10841/QO-14435) (TC-10861/QO-14455)
And User clicks on "SigninTabFooter" option
And Enters "signinemailid"
And Enters "SigninPassword"
And User clicks on "onboarding_SignInBtn" option
And Navigates to discover tab to verify open houses available
And User Taps on option "Me"
And User clicks on "SignOut" option
And Navigates to "Discover" Tab
And Verify No open houses are displayed for unauthenticated users 
Then User closes the app

