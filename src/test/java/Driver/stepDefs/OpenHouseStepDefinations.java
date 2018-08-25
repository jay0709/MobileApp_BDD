/**
 * @author Syed Zubair
 *
 */

package Driver.stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Driver.desiredCapabilities;
import ObjectRepository.CommonFunctions_OR;
import ObjectRepository.OpenHouse_OR;
import ObjectRepository.PropertDetailsPage_OR;
import ObjectRepository.Registration_OR;
import PageObjects.OpenHouse2_PO;
import PageObjects.OpenHouse_PO;
import PageObjects.commonFunctions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class OpenHouseStepDefinations extends desiredCapabilities implements CommonFunctions_OR,OpenHouse_OR ,Registration_OR ,PropertDetailsPage_OR{
	
	OpenHouse_PO oh = new OpenHouse_PO();
	commonFunctions cf = new commonFunctions();
	OpenHouse2_PO ohp = new OpenHouse2_PO();
	
	@When("^User clicks on filters tab and enables open house filter$")
	public void User_clicks_on_filters_tab_and_enables_open_house_filter() throws Throwable
	{
		wait.until(ExpectedConditions.elementToBeClickable(filtersTab));
		oh.turnOnOpenHouseFilter(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(searchingDialouge));
	}
	
	@And("^Verify open house filter is applied in SRP page$")
	public void verify_open_house_filter_is_applied_in_SRP_page() throws Throwable
	{
		driver.findElement(srpListBtn).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(searchingDialouge));
		cf.verticalScrollUpwards(driver);
		String openText = driver.findElement(openTextInSRP).getText();
		Assert.assertEquals(openText, "OPEN", "Open house filter applied..");
		System.out.println("Open house timings : " + driver.findElement(openTimeInSRP).getText());
	}
	
	@And("^User compares dates in srp and pdp page$")
	public void 	User_compares_dates_in_srp_and_pdp_page() throws Throwable
	{
		oh.openHouseDateVerify(driver);
	}
	@And("^User compares address in both srp and pdp page$")
	public void 	User_compares_address_in_srp_and_pdp_page() throws Throwable
	{
		oh.menuAddressVerify(driver);
	}
	
	@And("^User compares time in both srp and pdp page$")
	public void 	User_compares_time_in_both_srp_and_pdp_page() throws Throwable
	{
		oh.openHouseTimeVerify(driver);

	}
	@And("^User saves open house$")
	public void User_saves_open_house() throws Throwable
	{
		oh.saveOpenHouse(driver);
	}
	@And("^View saved open house$")
	public void View_saved_open_house() throws Throwable
	{
		oh.viewSavedOpenHouse(driver);
	}
	
    @And("^User Taps on option \"([^\"]*)\"$")
	public void user_Taps_on_option(String option) throws Throwable {
    	
    	    if(option.equals("Me"))
    	    {
    	    	    wait = new WebDriverWait(driver, 10);
    			wait.until(ExpectedConditions.elementToBeClickable(navigatingSearchTab));
    			driver.findElement(onboarding_RegnMeBtn).click();
    			
    	    }
    	    else if(option.equals("My Tours & Open Houses"))
    	    {
    	    	      Thread.sleep(3000);
    			  driver.findElement(openHouseInMe).click();
    			  
    	    }
    	    else if(option.equals("Saved Open House"))
    	    {
    	    	      wait.until(ExpectedConditions.visibilityOfElementLocated(openHouseTabInMenu));
    	        	  driver.findElement(openHouseTabInMenu).click();
  			  System.out.println("User landed in My Open Houses section..!");
  			  
    	    }
    	    else if(option.equals("Open House Menu address"))
    	    {
    	           wait.until(ExpectedConditions.visibilityOfElementLocated(myOpenHouseMenu));
    			  driver.findElement(myOpenHouseMenu).click();
    			  Assert.assertEquals(driver.findElement(menuCopyAddress).getText(), "Copy Address","Copy Address text not present..!");
    	    }
    	    else
    	    {
    	    	  System.out.println("No option available to be clicked");
    	    }

	}

	@And("^Users verifys opening of PDP page from open House section$")
	public void users_verifys_opening_of_PDP_page_from_open_House_section() throws Throwable {
	       oh.viewPDPFromOpenHouse(driver);     
	}
	
	@And("^User Verifys \"([^\"]*)\" section opens from open house menu$")
	public void user_Verifys_section_opens_from_open_house_menu(String Section) throws Throwable {
		
		if(Section.equals("Request a tour"))
		{
			oh.scheduleTourOpenHouse(driver);
		}
		else if(Section.equals("Get Direction"))
		{
			oh.getDirectionsFromOpenHosuse(driver);
		}
		else if(Section.equals("Add to calender"))
		{	
			oh.navigateToCreateEvent(driver);
		}
		else
		{
			System.out.println("No Section available");
		}
		
    }

	@And("^User deletes open house from open house menu section$")
	public void user_deletes_open_house_from_open_house_menu_section() throws Throwable {
		oh.deleteOpenHouse(driver);
	}
	@And("^Navigates to discover tab to verify open houses available$")
	public void Navigates_to_discover_tab_to_verify_open_houses_available() throws Throwable
	{
	    	ohp.discovertabopenhouses(driver);
	}
	@And("^counts the number of open houses$")
	public void counts_the_number_of_open_houses() throws Throwable
	{
		ohp.totalOpenHouseInMenu(driver);
	}
	@And("^User verifys if pin view is enabled$")
	public void User_verifys_if_pin_view_is_enabled() throws Throwable
	{
		oh.pinView(driver);
	}
	@And("^User sets filter to Less than (\\d+) days$")
	public void user_sets_filter_to_Less_than_days(int arg1) throws Throwable {
		ohp.newPropertiesWithOpenHouse(driver);

	}
	@And("^User verifys saved text is not changed after applying open house filter$")
	public void User_verifys_saved_text_is_not_changed_after_applying_open_house_filter() throws Throwable
	{
		ohp.saveSearchNotAffected(driver);
	}
	@And("^Verify Open House tag & time are displayed in discover tab$")
	public void Verify_Open_House_tag_and_time_are_displayed_in_discover_tab() throws Throwable
	{
	   	ohp.verifyTagTimeInDiscoverPage(driver);
	}
	@And("^User Clicks on any property to navigate to pdp page$")
	public void Clicks_on_any_Property() throws Throwable
	{
		 try
		 {
		   wait.until(ExpectedConditions.elementToBeClickable(srpListBtn));
		   driver.findElement(srpListBtn).click();
		 }
		 catch(NoSuchElementException e)
		 {
			 wait.until(ExpectedConditions.visibilityOfElementLocated(srpListBtn));
             driver.findElement(srpListBtn).click();
          }
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
         //cf.verticalScrollUpwards(driver);
		 wait.until(ExpectedConditions.elementToBeClickable(priceInList));
		 driver.findElement(priceInList).click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(priceInPDP));
		
	
	}
	@And("^Favourites a property in PDP page and verify favourited property in discover tab$")
	public void Favourites_a_property_in_PDP_page() throws Throwable
	{
		ohp.favOpenHousePDP(driver);
	}
	@And("^Unfavourite the property in favourite tab and verify unfavourited property in discover page$")
	public void Unfavourites_the_property_and_verify_unfavourited_property_in_discover_page() throws Throwable
	{
		ohp.unFavOpenHouse(driver);
	}
	@And("^Edit Saved search and verify open house list is updated in discover tab$")
	public void Edit_Saved_search() throws Throwable
	{
		ohp.openHouseAfterChangeSavedSearch(driver);
	}
	@And("^User scrolls to text \"([^\"]*)\"$")
	public void User_scrolls_to_text(String scrollTo) throws Throwable
	{
		if(scrollTo.equals("School"))
		{
			System.out.println("Ready for scrolling");
			Thread.sleep(4000);
			cf.scrollToText("SCHOOLS", driver);

		}
		else if(scrollTo.equals("Estimated monhtly payment"))
		{
			cf.scrollToText("Estimated monthly payment", driver);
		}
		else if(scrollTo.equals("Make an offer"))
		{
			driver.navigate().back();
			cf.verticalScrollUpwards(driver);
			Clicks_on_any_Property();
			cf.scrollToText("Make an Offer", driver);
		}
		else if(scrollTo.equals("Notify me when price changes"))
		{
			try
			{
				cf.scrollToText("Notify me when the price changes", driver);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(NotifyMeOption));
				Thread.sleep(3000);
				WebElement element = driver.findElement(NotifyMeOption);
				element.click();
			
			}
			catch(Exception e)
			{
				System.out.println("Notify me when the price changes section was not present so selecting another property");
				driver.navigate().back();
				cf.verticalScrollUpwards(driver);
				Clicks_on_any_Property();
				cf.scrollToText("Notify me when the price changes", driver);
				driver.findElement(NotifyMeOption).click();
				
			}
		}
		else if(scrollTo.equals("Beds")){
			cf.scrollToText("Beds", driver);
		}
		
		else if(scrollTo.equals("Notifications")){
			cf.scrollToText("Privacy Policy", driver);
		}
		else if(scrollTo.equals("Notes"))
		{
			cf.scrollToText("Notes", driver);
        }
		else if(scrollTo.equals("Recommended Properties"))
		{
			cf.scrollToText("Recommended Properties", driver);

		}
		else if(scrollTo.equals("Just for Me"))
		{
			cf.scrollToText("Just for Me", driver);

		}
		else if(scrollTo.equals("Price History"))
		{
			cf.scrollToText("Notify me when the price changes", driver);

		}
		
		else
		{	
			cf.scrollToText(scrollTo, driver);

			System.out.println("No section present to be scrolled");
		}
		
	}
//	@And("^verifys network error in saved open house section$")
//	public void verifys_network_error_in_saved_open_house_section() throws Throwable
//	{
//		ohp.myOpenHouseInNoNetwork(driver);
//	}
	@And("^Verify No open houses are displayed for unauthenticated users$")
	public void Verify_No_open_houses_are_displayed_for_unauthenticated_users() throws Throwable
	{
             try {
					cf.scrollToText("Open Houses", driver);
					Assert.assertFalse(driver.findElement(openHouseItemAddressState).isDisplayed(), "Open house section is showed for unauthenticated user");
					System.out.println("Open houses are visible for the Recent Saved Search..! THIS TEST CASE IS FAILED");
				} catch (Exception e) {
                     System.out.println("No Open house section found as user is logged out");
				}
	}
	
	@And("^User selects any random property and navigate to pdp page$")
	public void User_selects_any_random_property() throws Throwable
	{
		driver.navigate().back();
		cf.verticalScrollUpwards(driver);
		Clicks_on_any_Property();
	}
	
	
	
}
