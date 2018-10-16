#PDP Feature - @Author Syed Zubair Mehdi
@Regression
Feature: PDP Feature

  Background: 
    Given Launch the Owners App
    When User clicks on "skip" option
    When User enters city "Washington,DC" in search Bar

#  Scenario: Verify presence of school section,School Ratings & School Gradings in PDP page (TC-12238/QO-7664),(TC-12239),(TC-12508/QO-7656),(TC-12512/QO-7660),(TC-12643) 
#    And User Clicks on any property to navigate to pdp page
#    And validate "school" section
#    And Verify if "Assigned Keyword" is displayed
#    And Verify "School Ratings" are displayed and validate it
#    And Verify "School Gradings" are displayed and validate it
#    Then User closes the app
#
#  Scenario: Sign in and Verify presence of school section,School Ratings & School Gradings in PDP page (TC-12238),(TC-12239),(TC-12507/QO-7655),(TC-12512/QO-7660),(TC-12520/QO-7663),(TC-12642),(TC-12643) 
#    And User clicks on "SigninTabFooter" option
#    And Enters "signinemailid"
#    And Enters "SigninPassword"
#    And User clicks on "onboarding_SignInBtn" option
#    And User Clicks on any property to navigate to pdp page
#    And validate "school" section
#    And Verify "School Ratings" are displayed and validate it
#    And Verify "School Gradings" are displayed and validate it
#    Then User closes the app
#
#  Scenario: Verify Tool Tip details & collapse option in school section (TC-12244/QO-7670),(TC-12239/QO-7665),(TC-12240/QO-7666),(TC-12519/QO-7662)(TC-12520/QO-7663)
#    And User Clicks on any property to navigate to pdp page
#    And User scrolls to text "school"
#    And verify tool tip details
#    And Verify "school section collapse" option presence and validate it
#    Then User closes the app
#
#  Scenario: Validate Number of schools present and first displayed school details in school section (TC-12241/QO-7667)
#    And User Clicks on any property to navigate to pdp page
#    And User scrolls to text "School"
#    And View number of schools and verify First school details
#    Then User closes the app
#
#  Scenario: view and Verify all school details in school section (TC-12242/QO-7668) ,(TC-12240)-d,(TC-12243/QO-7669)
#    And User Clicks on any property to navigate to pdp page
#    And User scrolls to text "School"
#    And Validate if all schools details are displayed
#    Then User closes the app
#
#  Scenario: Verify school data source information (TC-13057/QO-7671)
#    And User Clicks on any property to navigate to pdp page
#    And User scrolls to text "School"
#    And Verify school data source location
#    Then User closes the app

  Scenario: Check EMP estimated value and estimated info (TC-12245/QO-7528)
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Estimated monthly payment"
    And Verify EMP "estimated value"
    And Verify EMP "estimated info"
    Then User closes the app

  Scenario: Check EMP breakup (TC-12248/QO-7531),(TC-12247/QO-7530)
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

  Scenario: validate presence of "Make an offer" and "Ask a question" section 	(TC-13058/QO-7740),(TC-13059/QO-7741),(TC-13060/QO-7742),(TC-13061/QO-7743)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    Then User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Make an offer"
    And validate presence of "Make an offer" section
    And validate presence of "Ask a question" section
    Then User closes the app

  Scenario: Validate message information of section "Notify me when price changes" (TC-13190/QO-7731),(TC-13191/QO-7732),(TC-13192/QO-7733),(TC-13193/QO-7734)
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Notify me when price changes"
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And validate "Notify me when price changes" section
    And User scrolls to text "Beds"
    And Validate Property auto-favorited
    Then User closes the app

  Scenario: Adding,editing & deleting comment and verifying in PDP page (TC-12420/QO-7580),(TC-12421/QO-7581),(TC-12422/QO-7582),(TC-12573/QO-7596),(TC-12628/QO-7645)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And User adds a comment and verifies if the comment is displayed in pdp page
    And User edits the latest comment added in pdp page
    And User deletes the latest comment added in pdp page
    Then User closes the app

  Scenario: Adds image from camera and then deletes the image in pdp page (TC-12423/QO-7583),(TC-12424/QO-7584),(TC-12587/QO-7609),(TC-12593/QO-7613),(TC-12582/QO-7605),(TC-12611/QO-7630),(TC-12629)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    Then User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And User Adds image from assest and verifys in pdp page
    And User deletes the image added
    And User deletes the latest comment added
    Then User closes the app

  Scenario: Adds image from Gallery and then delete in pdp page (TC-12425/QO-7585),(TC-12424),(TC-12588/QO-7610),(TC-12602/QO-7621),(TC-12616/QO-7635)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    Then User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And User Adds image from Gallery and verifys in pdp page
    And User deletes the image added
    And User deletes the latest comment added in pdp page
    Then User closes the app

  Scenario: Count images in PDP page  and unauthenticated users tries to submit comment (TC-12427/QO-7586),(TC-12428/QO-7587),(TC-12588/QO-7610),(TC-12594/QO-7614)
    And User Clicks on any property to navigate to pdp page
    And User swipes photos in PDP page and countes it
    And Verify it is asking unauthenticated user to login when he tries to submit comment
    Then User closes the app

  Scenario: Add and delete multiline comments in PDP page (TC-12429/QO-7588)
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    Then User clicks on "onboarding_SignInBtn" option
    And User Clicks on any property to navigate to pdp page
    And add & delete multi line comments in pdp page and verify
    Then User closes the app

  Scenario: Validate Customize Calculations in pdp page (TC-12439/QO-7541),(TC-12440/QO-7542),(TC-12441/QO-7543),(TC-12442/QO-7544),(TC-12443/QO-7545),(TC-12444/QO-7546),(TC-12445/QO-7547),(TC-12446/QO-7548),(TC-12447/QO-7549),(TC-13024),(TC-13028),(TC-13034/QO-7575),(TC-13009/QO-7550)
    And User Clicks on any property to navigate to pdp page
    And compares property price is displayed same
    And increase or decrease "Down Payment" section
    And increase or decrease "interest rate" section
    And verify "Estimated montly payment" changes
    And Verify  emp price on pdp is not impacted
    Then User closes the app

  #close MAP SRP
  Scenario: Validate Presence of Share,Map and Request Info Option on PDP page (TC-12461/QO-7727),(TC-12462/QO-7728),(TC-12463/QO-7729),(TC-12464/QO-7702),(QO-132),(QO-133),(TC-13065/QO-7712),(TC-13049/QO-7720),(TC-13054/QO-7724)
    And User Clicks on any property to navigate to pdp page
    And Verify "Share" option presence and validate it
    And Verify "Map" option presence and validate it
    And Verify "Request Info" option presence and validate it
    Then User closes the app

  Scenario: Verify Property can be shared via Whatsapp,FaceBook and twitter (TC-13039/QO-7696),(TC-13040/QO-7697),(TC-13041/QO-7698)
    And User Clicks on any property to navigate to pdp page
    And User clicks on "share" button
    And Verifys property can be shared through Facebook,Whatsapp and twitter
    Then User closes the app

  Scenario: Validate footer (link and text) (TC-12465/QO-7714),(TC-12466/QO-7714),(TC-12471/QO-7716),(TC-12467),(TC-12467/QO-7715),(TC-14031)
    And User Clicks on any property to navigate to pdp page
    And Validate "Fair Housing and Equal Opportunity" text presence in footer section
    And Validate "here" text presence in footer section
    And Validate "Information About Brokerage Services, Consumer Protection Notice" text presence in footer section
    Then User closes the app



  Scenario Outline: User validates FHEO content from MAP & Swipe View (TC-13046/QO-7718),(TC-13047/QO-7719)
    When User enters city "Joseph City,AZ" in search Bar
    And User Clicks on property from "<Option>" view  to navigate to pdp page
    And Validate "Fair Housing and Equal Opportunity" text presence in footer section
    Then User closes the app

    Examples: 
      | Option |
      | Map    |
      | Swipe  |

  Scenario: Verify date & time fields are scrollable and date is single select and time is multiple select in a request a tour(TC-12501),(TC-12505/QO-7709)
    And User Clicks on any property to navigate to pdp page
    And Verify date & time fields are scrollable
    And Date is single select and Time is multiple select
    Then User closes the app

  Scenario: Verify all the fields are mandatory in the request a tour screen (TC-12506/QO-7710)
    And User clicks on "List" Tab
    And User selects date
    And Verify time field and other user details is mandatory in request tour form
    Then User closes the app

  Scenario: As Guest User Validate Estimate my commute in pdp page and  verify leave at time (TC-12559/QO-7692)
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

  Scenario: Sign in and validate Estimate my commute in pdp page and  verify leave at time (TC-12430),(TC-12432/QO-7674),(TC-12434/QO-7676),(TC-12435/QO-7677),(TC-12554/QO-7687),(TC-12555/QO-7688),(TC-12556/QO-7689),(TC-12558/QO-7691),(TC-12433)
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

  Scenario: Validate Estimate commute time for different regions:(TC-12436/QO-7678), (TC-12438/QO-7680),(TC-12439),(TC-12552/QO-7685)
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

  Scenario: verify commute message for mls and fsbo property (TC-12560/QO-7693),(TC-12561/QO-7694),(TC-12562/QO-7695),(TC-12433/QO-7675)
    And User Clicks on any property to navigate to pdp page
    And User scrolls to text "Estimate my commute"
    And User clicks on "Estimate My commute" button
    And Validate "Commute Message" is not displayed
    And Enters any place like "Miami,Fl" in destination
    And Verify if "Commute Message" is displayed
    And Verify "Address" field is not editable
    Then User closes the app

  Scenario: verify Estimate my commute and map cta is not displayed for property whose address is not public (TC-12550/QO-7683),(TC-13053/QO-7723)
    And User Clicks on any property to navigate to pdp page
    And User clicks on "back" option
    And User searches property with value "18013645" in search Bar
    And Selects "Address Not Public" Property
    And User Clicks on any property to navigate to pdp page
    And Validate "MAP CTA" is not displayed
    And Validate "Estimate My Commute Button" is not displayed
    Then User closes the app

  Scenario: verify in map srp when you can zoom in/zoom out and see only 1 property when scrolled up/down(TC-13052/QO-7722)
    And User Clicks on any property to navigate to pdp page
    And User clicks on "Map CTA" button
    And Verify only one property is visble when map scrolled up and down
    Then User closes the app

  #author - JAYABRATA
  Scenario: Check save listing notification is enabled (TC-13194/QO-7735),(TC-13196/QO-7737),(TC-13197/QO-7738)
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
