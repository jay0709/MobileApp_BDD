#Pdp Notes-@Author:-Syed Zubair Mehdi
@Regression
Feature: Pdp Notes TestCases

  Background: 
    Given Launch the Owners App
    When User clicks on "skip" option
    And User clicks on "SigninTabFooter" option
    And Enters "signinemailid"
    And Enters "SigninPassword"
    And User clicks on "onboarding_SignInBtn" option
    When User enters city "Washington,DC" in search Bar

  Scenario: Enter Only Special Characters,Only Numeric values,Only A-Z in comment (TC-12570),(TC-12571),(TC-12572),(TC-15260) 
    And User Clicks on any property to navigate to pdp page
    And Verify User is allowed to enter characters in comment
      | !@##$$%%%                  |
      |                  123456789 |
      | ABCDEFGHIJKLMNOPQRSTUVWXYZ |
    And User deletes the latest comment added in pdp page
    Then User closes the app

  Scenario: User tries to submit comment with blank text and with single character (TC-12574/QO-7597),(TC-12569/QO-7592)
    And User Clicks on any property to navigate to pdp page
    And Verify User is not allowed to submit comment with empty text
    And Verify user is allowed to submit comment with single character
    And User deletes the latest comment added
    Then User closes the app

  Scenario: verify user is not allowed to enter more than 600 characters (TC-12577/QO-7600),(TC-12578/QO-7601),(TC-12580/QO-7603)
    #And Enter More then 600 characters
    #And Verify if characters are truncated beyond 600
    #And User deletes the latest comment added in pdp page
    #Then User closes the app
    And add & delete multi line comments in pdp page and verify
    Then User closes the app

  Scenario: User verifys a photo can be deleted with x mark before upload (TC-12596/QO-7616)
    And User Clicks on any property to navigate to pdp page
    And User selects the photo to upload
    And User clicks on "x" button
    And verifys photo is deleted before upload
    Then User closes the app

  Scenario: Verify image upload process should take place in background if user has moved from pdp page and verifys if image can be opened(TC-12597/QO-7617),(TC-12598/QO-7618)
    And User Clicks on any property to navigate to pdp page
    And User adds image from camera
    And User clicks on "back" option
    And comes back to pdp page and verifys image is uploaded
    And Verifys if the added image can be opened
    And User deletes the image added
    And User deletes the latest comment added
    Then User closes the app

  #Scenario: User verifies show previous notes functionality(TC-12603/QO-7622),(TC-12604/QO-7623),(TC-12605/QO-7624),(TC-12606/QO-7625),(TC-12567/QO-7590),(TC-12609/QO-7628)
    #And User Clicks on any property to navigate to pdp page
    #And Verify User is allowed to enter characters in comment
      #| !@##$$%%%                  |
      #|                  123456789 |
      #| ABCDEFGHIJKLMNOPQRSTUVWXYZ |
      #| Abc23467O0@#$              |
    #And verify "favourite box" dialog is visible and validate it
    #And User clicks on "Show All" button
    #And verifys all notes are displayed
    #And User clicks on "collapse Notes" button
    #And Validate "first comment" is not displayed
    #And User deletes the latest comment added in pdp page
    #Then User closes the app

  Scenario: After adding comment verify new text box is visible (TC-12566/QO-7589)
    And User Clicks on any property to navigate to pdp page
    And User adds a comment and verifies if the comment is displayed in pdp page
    And Verify "comment text box" field is visible
    And User deletes the latest comment added in pdp page
    Then User closes the app

  Scenario: Already Favourited property should not get the favourite dialog (TC-12568/QO-7591)
    And User marks property as favourite
    And User Clicks on any property to navigate to pdp page
    And User adds a comment and verifies if the comment is displayed in pdp page
    And Validate "favourite dialog box" is not displayed
    And User deletes the latest comment added in pdp page
    Then User closes the app


  Scenario: User Adds image from Swipe view and saved search view and opens it (TC-12600/QO-7619),(TC-12601/QO-7620)

    And click on "Save Search" option
    And Navigates to "Discover" Tab
    And verifys saved search property "Washington,DC" is displayed in "Saved Searches" section
    And User clicks on property in "saved search" section
    And User Clicks on any property to navigate to pdp page
    And User Adds image from assest and verifys in pdp page
    And Verifys if the added image can be opened
    And User deletes the image added
    And User deletes the latest comment added
    And User clicks on "back" option
    And User clicks on "Swipe" Tab
    And User Clicks on any property to navigate to pdp page from "Swipe" view
    And User Adds image from assest and verifys in pdp page
    And Verifys if the added image can be opened
    And User deletes the image added
    And User deletes the latest comment added
    Then User closes the app

  #Scenario: Upload image from camera and verify image count in pdp header and favourite tab(TC-12612/QO-7631),(TC-12613/QO-7632),(TC-12614/QO-7633)
    #And check if No saved listings are present
    #And User clicks on "back" button
    #And User Clicks on any property to navigate to pdp page
    #And User swipes photos in PDP page and countes it
    #And User Adds image from Gallery and verifys in pdp page
    #And Verifys that image count in pdp , favourite tab and in List view is increased
    #And User Clicks on any property to navigate to pdp page
    #And User deletes the image added
    #And User deletes the latest comment added in pdp page
    #Then User closes the app
 
   Scenario: verify image thumbnail in pdp from camera and Gallery (TC-12634/QO-7651),(TC-12635/QO-7652)
    And User Clicks on any property to navigate to pdp page
    And User Adds image from assest and verifys in pdp page
    And User clicks on "Show All" button
    And Verify if image thumbnail is viewable in collapse view
    And User clicks on "collapse Notes" button
    And User deletes the image added
    And User deletes the latest comment added in pdp page
    And User Adds image from Gallery and verifys in pdp page
    And Verify if image thumbnail is viewable in collapse view
    And User clicks on "collapse Notes" button
    And User deletes the image added
    And User deletes the latest comment added in pdp page
    Then User closes the app

   @Notes
   Scenario: - Verify user is able to see "User Photos" section when image is uploaded and not able to see when image is not uploaded(TC-12617/QO-7636),(TC-12618/QO-7637),(TC-12619/QO-7638),(TC-12620/QO-7639),(TC-12621/QO-7640)
    And User Clicks on any property to navigate to pdp page
    And Verify User Photos section is not displayed when image is not uploaded
    And User clicks on "back" option
    And User Adds image from assest and verifys in pdp page
    And Verify User Photos section is displayed when image is uploaded
    And Opens the image from User photos section and verifys text and bin icon
    And User clicks on "back" option
    And User scrolls to text "Notes"
    And User deletes the image added
    And verify comment is not deleted when image is deleted
    And User deletes the latest comment added in pdp page
    And Verify User Photos section is not displayed when image is not deleted
    Then User closes the app
