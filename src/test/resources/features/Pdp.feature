#PDP Feature - @Author jayabrata
@Regression
Feature: PDP Feature

  Background: 
    Given Launch the Owners App
    When User clicks on "skip" option
    When User enters city "Washington,DC" in search Bar

  Scenario: Verify presence of school section,School Ratings & School Gradings in PDP page (TC-12238),(TC-12239),(TC-12508),(TC-12512)
    And User Clicks on any property to navigate to pdp page
    And validate "school" section
    And Verify if "Assigned Keyword" is displayed
    And Verify "School Ratings" are displayed and validate it
    And Verify "School Gradings" are displayed and validate it
    Then User closes the app

  Scenario: Sign in and Verify presence of school section,School Ratings & School Gradings in PDP page (TC-12238),(TC-12239),(TC-12507),(TC-12512),(	TC-12520)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And validate "school" section
    And Verify "School Ratings" are displayed and validate it
    And Verify "School Gradings" are displayed and validate it
    Then User closes the app

  Scenario: Verify Tool Tip details & collapse option in school section (TC-12244),(TC-12239),(TC-12240),(TC-12519)(TC-12520)
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "school"
    And verify tool tip details
    And Verify "school section collapse" option presence and validate it
    Then User closes the app

  Scenario: Validate Number of schools present and first displayed school details in school section (TC-12241)
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "School"
    And View number of schools and verify First school details
    Then User closes the app

  Scenario: view and Verify all school details in school section (TC-12242) ,(TC-12240)-d,(TC-12243 )
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "School"
    And Validate if all schools details are displayed
    Then User closes the app

  Scenario: Verify school data source information (TC-13057)
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "School"
    And Verify school data source location
    Then User closes the app

  Scenario: Check EMP estimated value and estimated info (TC-12245)
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Estimated monthly payment"
    And Verify EMP "estimated value"
    And Verify EMP "estimated info"
    Then User closes the app

  Scenario: Check EMP breakup (TC-12248),(TC-12247)
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Estimated monthly payment"
    And Verify EMP components like principal and interest property taxes and HOA dues
    Then User closes the app

  Scenario: Validate PDP components (TC-4082)
    And validate "property details like price,bath sqft etc" section
    And validate "school" section
    And validate "Notes" section
    And validate "property status" section
    And validate "property tax" section
    And validate "estimated monthly payment & mortagage calculator" section
    And validate "property type" section
    Then User closes the app

  Scenario: validate presence of "Make an offer" and "Ask a question" section 	(TC-13058),(TC-13059),(TC-13060),(TC-13061)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    Then User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Make an offer"
    And validate presence of "Make an offer" section
    And validate presence of "Ask a question" section
    Then User closes the app

  Scenario: Validate message information of section "Notify me when price changes" (TC-13190),(TC-13191),(TC-13192),(TC-13193)
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Notify me when price changes"
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And validate "Notify me when price changes" section
    And User scrolls to text "Beds"
    And Validate Property auto-favorited
    Then User closes the app

  Scenario: Adding,editing & deleting comment and verifying in PDP page (TC-12420),(TC-12421),(TC-12422),(TC-12573),(TC-12628)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And User adds a comment and verifies if the comment is displayed in pdp page
    And User edits the latest comment added in pdp page
    And User deletes the latest comment added in pdp page
    Then User closes the app

  Scenario: Adds image from camera and then deletes the image in pdp page (TC-12423),(TC-12424),(TC-12587),(TC-12593),(TC-12582),(TC-12611),(TC-12629)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    Then User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And User Adds image from assest and verifys in pdp page
    And User deletes the image added
    And User deletes the latest comment added
    Then User closes the app

  Scenario: Adds image from Gallery and then delete in pdp page (TC-12425),(TC-12424),(TC-12588),(TC-12602),(TC-12616)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    Then User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And User Adds image from Gallery and verifys in pdp page
    And User deletes the image added
    And User deletes the latest comment added in pdp page
    Then User closes the app

  Scenario: Count images in PDP page  and unauthenticated users tries to submit comment (TC-12427),(TC-12428),(TC-12588),(TC-12594)
    And User Clicks on any property to navigate to pdp page
    And User swipes photos in PDP page and countes it
    And Verify it is asking unauthenticated user to login when he tries to submit comment
    Then User closes the app

  Scenario: Add and delete multiline comments in PDP page (TC-12429)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    Then User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And add & delete multi line comments in pdp page and verify
    Then User closes the app

  Scenario: Validate Customize Calculations in pdp page (TC-12439),(TC-12440),(TC-12441),(TC-12442),(TC-12443),(TC-12444),(TC-12445),(TC-12446),(TC-12447),(TC-13024),(TC-13028),(TC-13034),(TC-13009)
    And User Clicks on any property to navigate to pdp page
    And compares property price is displayed same
    And increase or decrease "Down Payment" section
    And increase or decrease "interest rate" section
    And verify "Estimated montly payment" changes
    And Verify  emp price on pdp is not impacted
    Then User closes the app

  #close MAP SRP
  Scenario: Validate Presence of Share,Map and Request Info Option on PDP page (TC-12461),(TC-12462),(TC-12464),(QO-132),(QO-133),(TC-13065),(TC-12463),(TC-13049),(TC-13054)
    And User Clicks on any property to navigate to pdp page
    And Verify "Share" option presence and validate it
    And Verify "Map" option presence and validate it
    And Verify "Request Info" option presence and validate it
    Then User closes the app

  Scenario: Verify Property can be shared via Whatsapp,FaceBook and twitter (TC-13039),(TC-13040),(TC-13041)
    And User Clicks on any property to navigate to pdp page
    And User clicks on "share" button
    And Verifys property can be shared through Facebook,Whatsapp and twitter
    Then User closes the app

  Scenario: Validate footer (link and text) (TC-12465),(TC-12466),(TC-12471),(TC-12467),(TC-12467),(TC-14031)
    And User Clicks on any property to navigate to pdp page
    And Validate "Fair Housing and Equal Opportunity" text presence in footer section
    And Validate "here" text presence in footer section
    And Validate "Information About Brokerage Services, Consumer Protection Notice" text presence in footer section
    Then User closes the app

  Scenario: Request a tour  (TC-12472),(TC-12499),(TC-12500),(TC-12503),(TC-12504),(TC-12505)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    Then User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And Verify "Request a Tour" option presence and validate it
    And Check available times to schedule a tour
    And Verify User Details
    Then User closes the app

  Scenario Outline: User validates FHEO content from MAP & Swipe View (TC-13046),(TC-13047)
    When User enters city "Joseph City,AZ" in search Bar
    And User Clicks on property from "<Option>" view  to navigate to pdp page
    And Validate "Fair Housing and Equal Opportunity" text presence in footer section
    Then User closes the app

    Examples: 
      | Option |
      | Map    |
      | Swipe  |

  Scenario: Verify date & time fields are scrollable and date is single select and time is multiple select in a request a tour(TC-12501),(TC-12505)
    And User Clicks on any property to navigate to pdp page
    And Verify date & time fields are scrollable
    And Date is single select and Time is multiple select
    Then User closes the app

  Scenario: Verify all the fields are mandatory in the request a tour screen (TC-12506)
    And User clicks on "List" Tab
    And User selects date
    And Verify time field and other user details is mandatory in request tour form
    Then User closes the app

  Scenario: As Guest User Validate Estimate my commute in pdp page and  verify leave at time (TC-12559)
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Estimate my commute"
    And Enters any place like "Miami,Fl" in destination
    And Verify if "Time" is displayed
    And Input "Arrive By" date and time
    And Verify if "LeaveBy/ArriveBy time" is displayed
    And Input "Depart By" date and time
    And Verify if "LeaveBy/ArriveBy time" is displayed
    And Verify if "Analog clock" is displayed
    And User clicks on "Get Directions" button
    And Verify if map is loaded
    Then User closes the app

  Scenario: Sign in and validate Estimate my commute in pdp page and  verify leave at time (TC-12430),(TC-12432),(TC-12434),(TC-12435),(TC-12554),(TC-12555),(	TC-12556 ),(TC-12558),(TC-12433)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    Then User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Estimate my commute"
    And Enters any place like "Miami,Fl" in destination
    And Verify if "Time" is displayed
    And Input "Arrive By" date and time
    And Verify if "LeaveBy/ArriveBy time" is displayed
    And Input "Depart By" date and time
    And Verify if "LeaveBy/ArriveBy time" is displayed
    And Verify if "Analog clock" is displayed
    And User clicks on "Get Directions" button
    And Verify if map is loaded
    Then User closes the app

  Scenario: Validate Estimate commute time for different regions:(TC-12436), (TC-12438),(TC-12439),(TC-12552)
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Estimate my commute"
    And Enters any place like "Miami,Fl" in destination
    And User clicks on "back" option
    And Verify if "X hour Y minute typical commute to address at Z am/p" is displayed from region "Washington,DC"
    And User clicks on "back" option
    And User enters city "Concord,CA" in search Bar
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "1 d 20 h typical commute"
    And Verify if "X hour Y minute typical commute to address at Z am/p" is displayed from region "Concord,CA"
    Then User closes the app

  Scenario: verify commute message for mls and fsbo property (TC-12560),(TC-12561),(TC-12562),(TC-12433)
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Estimate my commute"
    And User clicks on "Estimate My commute" button
    And Validate "Commute Message" is not displayed
    And Enters any place like "Miami,Fl" in destination
    And Verify if "Commute Message" is displayed
    And Verify "Address" field is not editable
    Then User closes the app

  Scenario: verify Estimate my commute and map cta is not displayed for property whose address is not public (TC-12550),(TC-13053)
    And User Clicks on any property to navigate to pdp page
    And User clicks on "back" option
    And User searches property with value "18013645" in search Bar
    And Selects "Address Not Public" Property
    And User Clicks on any property to navigate to pdp page
    And Validate "MAP CTA" is not displayed
    And Validate "Estimate My Commute Button" is not displayed
    Then User closes the app

  Scenario: verify in map srp when you can zoom in/zoom out and see only 1 property when scrolled up/down(TC-13052)
    And User Clicks on any property to navigate to pdp page
    And User clicks on "Map CTA" button
    And Verify only one property is visble when map scrolled up and down
    Then User closes the app

  #author - JAYABRATA
  Scenario: Check save listing notification is enabled (TC-13194),(TC-13196),(TC-13197)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    Then User clicks on "onboarding_SignInBtn" option
    And User clicks on "SigninTabFooter" option
    And User scrolls to text "Notifications"
    And User clicks on "Notifications" option
    And User turn off the notification
    Then User clicks on "back" option
    And Navigates to "Search" Tab
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Notify me when price changes"
    And validate "Notify me when price changes" section
    Then User clicks on "back" option
    And User clicks on "SigninTabFooter" option
    And User scrolls to text "Notifications"
    And User clicks on "Notifications" option
    And Verify the state of the Save Listing notification
