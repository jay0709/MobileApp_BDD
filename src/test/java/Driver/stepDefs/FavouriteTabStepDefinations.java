/**
 * @author Syed Zubair
 *
 */
package Driver.stepDefs;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.FavouriteProperty_OR;
import ObjectRepository.Registration_OR;
import PageObjects.AddAssetForPDP_PO;
import PageObjects.EditDeleteAssest_PO;
import PageObjects.FavTabRequestTour_PO;
import PageObjects.FavouriteProperty_PO;
import PageObjects.commonFunctions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FavouriteTabStepDefinations extends desiredCapabilities implements FavouriteProperty_OR ,Registration_OR{
	
	FavouriteProperty_PO ft = new FavouriteProperty_PO();
	commonFunctions cf = new commonFunctions();
	PropertyData prop = new PropertyData();
	EditDeleteAssest_PO ed = new EditDeleteAssest_PO();
	AddAssetForPDP_PO add = new AddAssetForPDP_PO();
	FavTabRequestTour_PO ftr = new FavTabRequestTour_PO();

	@Then("^check if No saved listings are present$")
	public void check_if_No_saved_listings_are_present() throws Throwable {
	    
		ft.checkNoSavedListingsText(driver);
    }

	@When("^Verify user is logged in before save Listing$")
	public void verify_user_is_logged_in_before_save_Listing() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(listSRPTab).click();
		Thread.sleep(2000);
		cf.verticalScrollUpwards(driver);
		ft.verifyLoginBeforeSaveListing(driver);
	}

	@When("^Verify latest comment added with last comment displayed$")
	public void verify_latest_comment_added_with_last_comment_displayed() throws Throwable {
        Thread.sleep(5000);
		ft.latestCommentVerify(driver, prop.newAsset);
	}

	@When("^User edits the latest comment added$")
	public void user_edits_the_latest_comment_added() throws Throwable {
	    
		Thread.sleep(2000);
		driver.findElement(clickFavouriteTab).click();
		ed.editCommentFromFavTab(driver, "NEW text 123");
	}

	@When("^User deletes the latest comment added$")
	public void user_deletes_the_latest_comment_added() throws Throwable {
	    
		ed.deleteCommentsFromProperty(driver);
	}
	
	@Then("^User Adds image from assest and verifys$")
	public void user_Adds_image_from_assest() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(clickFavouriteTab));
	    driver.findElement(clickFavouriteTab).click();
		ed.addImageAssetFromCamera(driver);

	}

	@Then("^User Adds image from Gallery and verifys$")
	public void user_Adds_image_from_Gallery() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(clickFavouriteTab));
        driver.findElement(clickFavouriteTab).click();
		ed.addImageFromGallery(driver);
	}
	
	@Then("^User deletes the image added$")
	public void user_Deletes_the_image_added() throws Throwable {
		ed.deleteImageFromAsset(driver);
    }

	@Then("^Count number of images in favourite tab while swipe$")
	public void count_number_of_images_in_favourite_tab_while_swipe() throws Throwable {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(clickFavouriteTab));
		driver.findElement(clickFavouriteTab).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		ft.countImagesWhileSwipe(driver);
	 }
	
	@And("^User sets favourite property from Map view$")
	public void user_sets_favourite_property_from_Map_view() throws Throwable {
        ft.favPropertyFromMap(driver);
	}

	@Given("^add & delete multi line comments and verify$")
	public void add_delete_multi_line_comments_and_verify() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(clickFavouriteTab));
		driver.findElement(clickFavouriteTab).click();
	    ft.addDeleteMultilineNotes(driver);
	}

	@Given("^User adds image to view in PDP$")
	public void user_adds_image_to_view_in_PDP() throws Throwable {
		add.addImageToViewInPDP(driver);
	}

	@Given("^Add asset in favourite tab to view$")
	public void add_asset_in_favourite_tab_to_view() throws Throwable {
		add.addAssetToViewInFavTab(driver, "This note has been added from PDP");
    }
	
	//------next------//
	@And("^User marks property as favourite$")
	public void User_marks_property_as_favourite() throws Throwable
	{
		add.checkToastMessageInPDP(driver);
	}
	@And("^User verifys schedule tour in favourite tab$")
	public void User_verifys_schedule_tour_in_favourite_tab() throws Throwable
	{
		ftr.checkSchduleTourMLS(driver);
	}
	@And("^Check available times to schedule a tour$")
	public void Check_available_times_to_schedule_a_tour() throws Throwable
	{
		ftr.checkAvailableTimes(driver);
	}
	@And("^Verify User Details$")
	public void Verify_User_Details() throws Throwable
	{
		ftr.checkUserDetails(driver);
	}
	@And("^Verify No schedule tour option is present for FSBO property$")
	public void Verify_No_schedule_tour_option_is_present_for_FSBO_property() throws Throwable
	{
		ftr.checkSchduleTourFSBO(driver);
	}
	@And("^Add multiple assests in PDP and verify$")
	public void Add_multiple_assests_in_PDP_and_verify() throws Throwable
	{
		add.addMultipleAssetInPDP(driver);
	}
	
	@And("^User marks property as favourite in srp page$")
	public void User_marks_property_as_favourite_in_srp_page() throws Throwable
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
		
		driver.findElement(favPropertyList).click();
	}
	
}
