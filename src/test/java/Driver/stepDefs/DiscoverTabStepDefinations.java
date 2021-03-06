package Driver.stepDefs;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Driver.desiredCapabilities;
import ObjectRepository.DiscoverTab_OR;
import ObjectRepository.MeTab_OR;
import ObjectRepository.OpenHouse_OR;
import ObjectRepository.PropertDetailsPage_OR;
import ObjectRepository.Registration_OR;
import PageObjects.DiscoverTab_PO;
import PageObjects.PropertyDetailsPage2_PO;
import PageObjects.commonFunctions;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class DiscoverTabStepDefinations extends desiredCapabilities implements DiscoverTab_OR , PropertDetailsPage_OR,Registration_OR,MeTab_OR,OpenHouse_OR{
	
	commonFunctions cf = new commonFunctions();
	DiscoverTab_PO dt = new DiscoverTab_PO();
	PropertyDetailsPage2_PO pdp2 = new PropertyDetailsPage2_PO();
	String Text;
	String PropertyPrice;
	
	@And("^Click on any property in recently viewed section$")
	public void Click_on_any_property_in_recently_viewed_section() throws Throwable
	{
		driver.findElement(RecentlySectionProperty).click();
	}
	
	@And("^verify pdp page opens$")
	public void verify_pdp_page_opens() throws Throwable
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(priceInPDP));
		Assert.assertTrue(driver.findElement(priceInPDP).isDisplayed(), "PDP page is not opened when clicked on recently viewed section property");
	}
	
    @And("^verify New Listing section is updated with saved search$")
    public void verify_New_Listing_section_is_updated_with_saved_search() throws Throwable
    {
    	    wait.until(ExpectedConditions.visibilityOfElementLocated(NewListingAddress));
    	    String LocationText = driver.findElement(NewListingAddress).getText();
    	    System.out.println("Location name"+LocationText);
    	    Assert.assertTrue(LocationText.contains("Washington,"),"New Listing Section is not updated with saved search");
    }
    
    @And("^Clicks on any property on \"([^\"]*)\" section$")
    public void Clicks_on_any_property_on_section(String section) throws Throwable
    {
    	   if(section.equals("New Listing"))
    	   {   
    	   driver.findElement(NewListingTag).click();
    	   wait.until(ExpectedConditions.visibilityOfElementLocated(priceInPDP));
    	   Assert.assertTrue(driver.findElement(priceInPDP).isDisplayed(),"pdp page is opened from new listing section");
    	   }
    	   else if(section.equals("Recommended Properties"))
    	   {
    		   driver.findElement(RecommendedProperty).click();
        	   wait.until(ExpectedConditions.visibilityOfElementLocated(priceInPDP));
        	   Assert.assertTrue(driver.findElement(priceInPDP).isDisplayed(),"pdp page is opened from new listing section");
       }
    }
    
    @And("^Validates \"([^\"]*)\" text$")
    public void validate_text(String text) throws Throwable
    {
    	    try
    	    {
    	    if(text.equals("sign in"))
    	    {
    	    	wait.until(ExpectedConditions.visibilityOfElementLocated(onboarding_SignInTabFooter));
    	    	Text = driver.findElement(onboarding_SignInTabFooter).getText();
    	    System.out.println("footer text is"+Text);
    	    Assert.assertEquals(Text, "Sign In");
    	    }
    	    }
    	    catch(AssertionError ae)
    	    {
    	    	  ae.printStackTrace();
    	    	  System.out.println("Sign In text is not coming");
    	    }
    	    if(text.equals("sqft tool tip icon"))
    	    {
    	    	   driver.findElement(SqftToolTipIcon).click();
    	    	   wait.until(ExpectedConditions.visibilityOfElementLocated(SqftToolTipMessage));
    	    	   Assert.assertTrue(driver.findElement(SqftToolTipMessage).getText().equals("Tax Record"), "Sqft tool tip message is not present or its changed");
    	    	   driver.findElement(favButtonInAlert).click();
    	    }
    }
    
    @And("^click on \"([^\"]*)\" option$")
    public void click_on_option(String options) throws Throwable
    {
    	  if(options.equals("Save Search"))
    	  {
    		  cf.saveSearch(driver);
    	  }
    }

    @And("^verifys saved search property \"([^\"]*)\" is displayed in \"([^\"]*)\" section$")
    public void verifys_saved_search_is_displayed_here(String savedLocation,String Section) throws Throwable
    { 
    	   if(Section.equals("Just for Me"))
    	   {
    		//scrolling till advice section to verify saved location in just for me section   
   		cf.scrollToText("Advice", driver);
    	    Assert.assertTrue(driver.findElement(JustForMeLocation).isDisplayed(), "Saved Search Location is displayed in Just For Me section");
    	    Text = driver.findElement(JustForMeLocation).getText();
   	    Assert.assertTrue(Text.contains(savedLocation), "Saved Search Location is displayed in Just For Me section");
    	   }
    	   else if(Section.equals("Saved Searches"))
    	   {
    		   wait.until(ExpectedConditions.presenceOfElementLocated(SavedSearchLocation));
    		   Assert.assertTrue(driver.findElement(SavedSearchLocation).isDisplayed(), "Saved Search Location is displayed in Just For Me section");
    	   }
   	   

    }
    
    
 @Given("^Verify \"([^\"]*)\" tiles with contents present in advice section$")
public void verify_with_contents_present_in_advice_section(String text) throws Throwable {
	
	String TextofTiles;
	

	if(text.equals("8 Questions to Ask When Buying a House"))
	{
   		cf.scrollToText("Advice", driver);
        wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdviceTilesOne));
		TextofTiles = driver.findElement(AdviceTilesOne).getText();
		Assert.assertTrue(driver.findElement(AdviceTilesOne).isDisplayed(),"Tile 1 is present");
		Assert.assertTrue(TextofTiles.equals("8 Questions to Ask When Buying a House"));
		System.out.println("Advice tile one is present");
	}
	else if(text.equals("5 Tips for winning a Home bidding war"))
	{
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdviceTilesTwo));
        TextofTiles = driver.findElement(AdviceTilesTwo).getText();
		Assert.assertTrue(driver.findElement(AdviceTilesTwo).isDisplayed(),"Tile 2 is present");
		Assert.assertTrue(TextofTiles.equals("5 Tips for Winning a Home Bidding War"));
		System.out.println("Advice tile Two is present");
    }
	else if(text.equals("4 Things You Need to Get Your First Home Mortgage"))
	{
//		//Get the size of screen.
//		  Dimension size = driver.manage().window().getSize();
//		  System.out.println(size);
//		  
//		  //Find swipe x points from screen's with and height.
//		  //Find x1 point which is at right side of screen.
//		  int x1 = (int) (size.width * 0.20);
//		  //Find x2 point which is at left side of screen.
//		  int x2 = (int) (size.width * 0.80);
//		  
//		  WebElement ele1 =  (WebElement) driver.findElement(AdviceTilesTwo);  
//
//	  TouchAction action = new TouchAction((PerformsTouchActions)driver);
//		  //action.longPress(ele1).moveTo(x1,595).release().perform();
			new TouchAction(driver).longPress(PointOption.point(743, 612)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(617,603)).release().perform();

		//Find swipe start and end point from screen's with and height.
		  //Find startx point which is at right side of screen.
		
		
//		Dimension size = driver.manage().window().getSize();
//
//		  int startx = (int) (size.width * 0.70);
//		  
//		  //Find endx point which is at left side of screen.
//		  int endx = (int) (size.width * 0.30);
//		  
//		  //Find vertical point where you wants to swipe. It is in middle of screen height.
//		  int starty = size.height / 2;
//		  System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);
//		new TouchAction(driver).longPress(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(endx,starty)).release().perform();

		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdviceTilesThree));
		Assert.assertTrue(driver.findElement(AdviceTilesThree).isDisplayed(),"Tile 3 is present");
		Thread.sleep(2000);
        TextofTiles = driver.findElement(AdviceTilesThree).getText();
        Assert.assertTrue(TextofTiles.equals("4 Things You Need to Get Your First Home Mortgage"));
		System.out.println("Advice tile Three is present");
	}
	else if(text.equals("9 Simple Ways to Start Saving for a Down Payment"))
	{
		
	    new TouchAction(driver).longPress(PointOption.point(563,1502)).waitAction().moveTo(PointOption.point(526, 1466)).release().perform();
        wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdviceTilesFour));
		Assert.assertTrue(driver.findElement(AdviceTilesFour).isDisplayed(),"Tile 4 is present");
		Thread.sleep(2000);
        TextofTiles = driver.findElement(AdviceTilesFour).getText();
        Assert.assertTrue(TextofTiles.equals("9 Simple Ways to Start Saving for a Down Payment"));
		System.out.println("Advice tile Four is present");
	}
	else if(text.equals("Closing Costs 101: What Should You Expect?"))
	{
		
		new TouchAction(driver).longPress(PointOption.point(526, 1466)).waitAction().moveTo(PointOption.point(502, 1494)).release().perform();
        wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdviceTilesFive));
		Assert.assertTrue(driver.findElement(AdviceTilesFive).isDisplayed(),"Tile 5 is present");
        Thread.sleep(2000);
        TextofTiles = driver.findElement(AdviceTilesFive).getText();
		Assert.assertTrue(TextofTiles.equals("Closing Costs 101: What Should You Expect?"));
		System.out.println("Advice tile Five is present");
    }
	else if(text.equals("Buying and Selling a Home: 5 Tips for Deciding What to Do First"))
	{
		
        new TouchAction(driver).longPress(PointOption.point(502, 1494)).waitAction().moveTo(PointOption.point(615, 1474)).release().perform();
        wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdviceTilesSix));
		Assert.assertTrue(driver.findElement(AdviceTilesSix).isDisplayed(),"Tile 6 is present");
		Thread.sleep(2000);
        TextofTiles = driver.findElement(AdviceTilesSix).getText();
        Assert.assertTrue(TextofTiles.equals("Buying and Selling a Home: 5 Tips for Deciding What to Do First"));
		System.out.println("Advice tile six is present");
	}
	else if(text.equals("How Much House Can You Afford? 3 Key Questions to Ask Yourself"))
	{
		
        new TouchAction(driver).longPress(PointOption.point(615, 1474)).waitAction().moveTo(PointOption.point(579, 1474)).release().perform();
        wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdviceTilesSeven));
		Thread.sleep(2000);
        TextofTiles = driver.findElement(AdviceTilesSeven).getText();
		Assert.assertTrue(driver.findElement(AdviceTilesSeven).isDisplayed(),"Tile 7 is present");
		Assert.assertTrue(TextofTiles.equals("How Much House Can You Afford? 3 Key Questions to Ask Yourself"));
		System.out.println("Advice tile seven is present");
    }
	else if(text.equals("6 Ways to Compete with an All-Cash Buyer"))
	{

		new TouchAction(driver).longPress(PointOption.point(579, 1474)).waitAction().moveTo(PointOption.point(571, 1486)).release().perform();
        wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdviceTilesEight));
		Assert.assertTrue(driver.findElement(AdviceTilesEight).isDisplayed(),"Tile 8 is present");
		Thread.sleep(2000);
        TextofTiles = driver.findElement(AdviceTilesEight).getText();
        Assert.assertTrue(TextofTiles.equals("6 Ways to Compete With an All-Cash Buyer"));
		System.out.println("Advice tile eight is present");
	}
	else if(text.equals("Getting Approved for a Mortgage: The Role of Your Credit History"))
	{
		new TouchAction(driver).longPress(PointOption.point(571, 1486)).waitAction().moveTo(PointOption.point(510, 1518)).release().perform();
        wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdviceTilesNine));
		Thread.sleep(2000);
         TextofTiles = driver.findElement(AdviceTilesNine).getText();
		Assert.assertTrue(driver.findElement(AdviceTilesNine).isDisplayed(),"Tile 9 is present");
		Assert.assertTrue(TextofTiles.equals("Getting Approved for a Mortgage: The Role of Your Credit History"));
		System.out.println("Advice tile seven is present");
    }
	else if(text.equals("Buying a Condo: What You Need to Know"))
	{
		

	    new TouchAction(driver).longPress(PointOption.point(510, 1518)).waitAction().moveTo(PointOption.point(842, 1563)).release().perform();
        wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdviceTilesTen));
		Assert.assertTrue(driver.findElement(AdviceTilesTen).isDisplayed(),"Tile 10 is present");
		Thread.sleep(2000);
        TextofTiles = driver.findElement(AdviceTilesTen).getText();
        Assert.assertTrue(TextofTiles.equals("Buying a Condo: What You Need to Know"));
		System.out.println("Advice tile Ten is present");
		driver.findElement(AdviceTilesTen).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AdviceTilesTenText));
		Assert.assertTrue(driver.findElement(AdviceTilesTenText).isDisplayed(),"Advice tile ten page is not opened");
	}
	else
	{	
		System.out.println("No tile present to be validated in advice section");
	}
	
}
 
 @Given("^verifys suggestions$")
 public void verifys_suggestions(DataTable Suggestions) throws Throwable {
		List<List<String>> data = Suggestions.raw();
		String Texts;
		wait.until(ExpectedConditions.visibilityOfElementLocated(JustForMeProertyValue));
		Texts = driver.findElement(JustForMeProertyValue).getText();
		Assert.assertTrue(driver.findElement(JustForMeProertyValue).isDisplayed(), "250-650k is not displayed");
		Assert.assertEquals(Texts, data.get(0).get(0));
		
		//validate Single Family
		wait.until(ExpectedConditions.visibilityOfElementLocated(SingleFamily));
		Texts = driver.findElement(SingleFamily).getText();
		Assert.assertTrue(driver.findElement(SingleFamily).isDisplayed(), "single Family is not displayed");
		Assert.assertEquals(Texts, data.get(1).get(0));
		
		//Validate 3+ beds
		Dimension size = driver.manage().window().getSize();
		  System.out.println(size);
		  
		  //Find swipe x points from screen's with and height.
		  //Find x1 point which is at right side of screen.
		  int x1 = (int) (size.width * 0.20);
		  //Find x2 point which is at left side of screen.
		  int x2 = (int) (size.width * 0.80);
		  
		  WebElement ele1 =  (WebElement) driver.findElement(SingleFamily);  

//		  TouchAction action = new TouchAction((PerformsTouchActions)driver);
//		  action.press((PointOption) ele1).moveTo(PointOption.point(x1,623).release().perform();
		  
		    new TouchAction(driver).longPress((PointOption) ele1).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(x1,623)).release().perform();

		  Thread.sleep(2000);
		  Texts = driver.findElement(ThreeBeds).getText();
	      Assert.assertTrue(driver.findElement(ThreeBeds).isDisplayed(), "Three Beds is not displayed");
		  Assert.assertEquals(Texts, data.get(2).get(0));
		  
		  
		  
}

 
 @And("^delete \"([^\"]*)\"$")
 public void delete(String ToDelete) throws Throwable {
	 
	 if(ToDelete.equals("Saved Search property"))
	 {
	 driver.findElement(SavedSearchMenuIcon).click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(SavedSearchDelete));
	 driver.findElement(SavedSearchDelete).click();
	 driver.findElement(onboarding_alertOKbtn).click();
	 Thread.sleep(2000);
	 }
	 
 }
 @And("^Verify New listing property is not impacted$")
 public void Verify_New_listing_property_is_not_impacted() throws Throwable
 {
	 verify_New_Listing_section_is_updated_with_saved_search();
 }
 
@And("^Validate \"([^\"]*)\" is not displayed$")
public void Validate_section_is_not_displayed(String section) throws Throwable
{
	if(section.equals("Recommended Properties"))
	{
		try
		{
			cf.scrollToText(section, driver);
			Assert.assertFalse(driver.findElement(RecommendedPropertiesSection).isDisplayed(), "RecommendedPropertiesSection is present");

		}
		catch(NoSuchElementException e)
		{
			System.out.println("Recommended property section is not present");
		}
	}
	else if(section.equals("Favourited Property in Recommended section"))
	{
		Assert.assertFalse(driver.findElement(pdpfavIcon).isSelected(),"Favourited property is present in recommended section");
	}
	else if(section.equals("New Listings"))
	{
		try
		{
			cf.scrollToText(section, driver);
			Assert.assertFalse(driver.findElement(NewListingsSection).isDisplayed(), "NewListingsSection is present");

		}
		catch(NoSuchElementException e)
		{
			System.out.println("Recommended property section is not present");
		}
	}
	else if(section.equals("first commen"))
	{
		cf.isElementPresent(commentOne);
	}
	else if(section.equals("Sell My Home"))
	{
		cf.isElementPresent(SellMyHome);
	}
	else if(section.equals("Commute Message"))
	{
		cf.isElementPresent(CommuteMessage);
	}
	else if(section.equals("MAP CTA"))
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(priceInPDP));
		cf.isElementPresent(pdpMapIcon);
	}
	else if(section.equals("Favourited Property in Recently Viewed"))
	{
		cf.scrollToText("Recently Viewed", driver);
		cf.isElementPresent(propertyInfo);
		
	}
	else if(section.equals("Estimate My Commute Button"))
	{
		try
		{
		cf.scrollToText("Estimate my commute", driver);
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			System.out.println("Estimate Commute Button is not present");
		}
	}
	else if(section.equals("sqft tool tip icon"))
	{
		cf.isElementPresent(SqftToolTipIcon);
	}
	else if(section.equals("Request a tour"))
	{
		cf.isElementPresent(RequestTourHeader);
	}
	else if(section.equals("Make an offer"))
	{
		try
		{
		cf.scrollToText("Make an Offer", driver);
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			System.out.println("Make an Offer Button is not present");
		}
	}
	else if(section.equals("Ask a question"))
	{
		try
		{
		cf.scrollToText("Ask a Question", driver);
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			System.out.println("Ask a question Button is not present");
		}
	}
				
}
@And("^User clears app data$")
public void User_clears_app_data() throws Throwable
{
	driver.resetApp();
	Thread.sleep(4000);
}


@And("^ReLaunches the app$")
public void ReLaunches_the_app() throws Throwable
 {
   cf.relaunchApp(driver);
 
 }

@And("^Verifys property details is shown in recommended properties$")
public void Verifys_property_details_is_shown_in_recommended_properties() throws Throwable
{
	Assert.assertTrue(driver.findElement(propertyInfo).isDisplayed(), "Property info is at line 1 is not displayed");
	Assert.assertTrue(driver.findElement(NewListingAddress).isDisplayed(), "Property Info at Line 2 is not displayed");
	Assert.assertTrue(driver.findElement(NewListingAddress).getText().contains("Concord"));
}

@And("^User Retrieves Property Price$")
public void User_Retrieves_Property_Price() throws Throwable
{
	driver.findElement(priceInList).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(priceInPDP));
	PropertyPrice = driver.findElement(priceInPDP).getText();
	System.out.println("Retrieved property price"+PropertyPrice);

	
}

@And("^Verify favourited property are displayed in recently viewed in pdp$")
public void Verify_favourited_property_are_displayed_in_pdp() throws Throwable
{
	String FavouritedPropertyPrice = driver.findElement(propertyInfo).getText();
	System.out.println("Favourited property price"+FavouritedPropertyPrice);
	Assert.assertEquals(PropertyPrice, FavouritedPropertyPrice,"Favourited Property is not present in recently viewed in pdp");
}

@And("^Verify Open House Tag & Time are displayed$")
public void Verify_Open_House_Tag() throws Throwable
{
	Assert.assertTrue(driver.findElement(openHouseHeaderText).isDisplayed(),"Open House Section for searched location is not displayed");
	Assert.assertTrue(driver.findElement(openHouseHeaderTime).isDisplayed(),"Open House Section for searched location is not displayed");
}

@And("^Verify Open House Property details is shown$")
public void Verify_Open_House_Property_details() throws Throwable
{
	Assert.assertTrue(driver.findElement(propertyInfo).isDisplayed(),"Property details are not shown");
}

@And("^Verify index change when property is unfavorited from pdp$")
public void Verify_index_change_when_property_is_unfavorited_from_PDP() throws Throwable{
	driver.findElement(RVPSectionFavIcon).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(priceInPDP));
	driver.findElement(pdpfavIcon).click();
	String pdpAddress = driver.findElement(propertyDetail).getText();
	driver.findElement(pdpBackButton).click();
	String rvpSectionAddress1 = driver.findElement(RVPPropertyAddressFirstLine).getText();
	String rvpSectionAddress2 = driver.findElement(RVPPropertyAddressSecondLine).getText();
	String rvpPropertyAddress = rvpSectionAddress1.concat("\n"+rvpSectionAddress2);
	Assert.assertEquals(rvpPropertyAddress.toLowerCase(), pdpAddress.toLowerCase(), "Unfav propety is not changed the index in RVP section.");
}

@And("^Confirm the same PDP is showing heart icon in discover tab$")
public void Confirm_the_same_PDP_is_showing_heart_icon_in_discover_tab() throws Throwable {
	String pdpAddress = driver.findElement(propertyDetail).getText();
	driver.findElement(pdpBackButton).click();
	dt.navigateDiscoverTab(driver);
	String rvpSectionAddress1 = driver.findElement(RVPPropertyAddressFirstLine).getText();
	String rvpSectionAddress2 = driver.findElement(RVPPropertyAddressSecondLine).getText();
	String rvpPropertyAddress = rvpSectionAddress1.concat("\n"+rvpSectionAddress2);
	System.out.println(rvpPropertyAddress);
	System.out.println(pdpAddress);
	if(driver.findElement(RVPSectionFavIcon).isDisplayed())
	Assert.assertEquals(rvpPropertyAddress.toLowerCase(), pdpAddress.toLowerCase(), "Fav propety is not showing in Discover tab.");
	driver.findElement(RVPSectionFavIcon).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(priceInPDP));
	driver.findElement(pdpfavIcon).click();
}

@And("^User click favorite icon in PDP$")
public void User_click_favorite_icon_in_PDP() throws Throwable {
	pdp2.favPropertyfromPDP(driver);
}


}
