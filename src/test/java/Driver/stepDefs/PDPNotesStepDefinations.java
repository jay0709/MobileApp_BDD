package Driver.stepDefs;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.CommonFunctions_OR;
import ObjectRepository.FavouriteProperty_OR;
import ObjectRepository.PropertDetailsPage_OR;
import ObjectRepository.Registration_OR;
import PageObjects.FavouriteProperty_PO;
import PageObjects.PropertyDetailsPage2_PO;
import PageObjects.commonFunctions;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;


public class PDPNotesStepDefinations extends desiredCapabilities implements PropertDetailsPage_OR,FavouriteProperty_OR,CommonFunctions_OR ,Registration_OR{
	
	PropertyDetailsPage2_PO pd = new PropertyDetailsPage2_PO();
	FavouriteProperty_PO fp = new FavouriteProperty_PO();
	commonFunctions cf = new commonFunctions();
	PropertyData prop = new PropertyData();

	
	@Given("^Verify User is allowed to enter characters in comment$")
	public void verify_User_is_allowed_to_enter_characters_in_comment(DataTable Characters) throws Throwable {
	   
		List<List<String>> data = Characters.raw();
        for(int i=0;i<3;i++)
        {
		pd.CommentVerificationinPDP(driver, data.get(i).get(0));
        }
		
	}
	
	@And("^Verify User is not allowed to submit comment with empty text$")
	public void Verify_User_is_not_allowed_to_submit_comment_with_empty_text() throws Throwable
	{
		try
		{
			cf.scrollToText("Notes", driver);
			System.out.println(" its at Notes section");

		}
		catch(Exception e)
		{
			System.out.println("Already its at Notes section");
		}
		Thread.sleep(2000);
		driver.findElement(editTextField).click();
		fp.confirmDisclaimer(driver);
		driver.findElement(editTextField).sendKeys("");
		driver.findElement(saveAssetButton).click();
		cf.isElementPresent(sendTextProgressBar);
		
	}
	@And("^Verify user is allowed to submit comment with single character$")
	public void Verify_user_is_allowed_to_submit_comment_with_single_character() throws Throwable
	{
		pd.CommentVerificationinPDP(driver, prop.SingleCharacter);

	}
	
	@And("^User selects the photo to upload$")
	public void User_selects_the_photo_to_upload() throws Throwable{
		try
		{
			cf.scrollToText("Notes", driver);
			System.out.println(" its at Notes section");

		}
		catch(Exception e)
		{
			System.out.println("Already its at Notes section");
		}
		driver.findElement(editTextField).click();
		fp.confirmDisclaimer(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(cameraIcon).click();
		try {
			
			driver.findElement(allowMediaAccess).click();
		} catch (Exception e) {
			System.out.println("Media Access is already allowed..!!");
		}
		driver.findElement(cameraButtonInDialouge).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(captureImageFromCamera));
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(captureImageFromCamera).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(saveImageAfterClicking));
		driver.findElement(saveImageAfterClicking).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(imageInAssetEditSection));
	}
	
	@And("^verifys photo is deleted before upload$")
	public void verifys_photo_is_deleted_before_upload() throws Throwable
	{
		cf.isElementPresent(imageInAssetEditSection);
	}
	@And("^User adds image from camera$")
	public void User_adds_image_from_camera() throws Throwable
	{
		 User_selects_the_photo_to_upload();
		 driver.findElement(editTextField).sendKeys("Image from camera added as asset..!!");
	     driver.hideKeyboard();
			try
			{
				cf.scrollToText("Save", driver);
	            driver.findElement(saveAssetButton).isDisplayed();
	            driver.findElement(saveAssetButton).click();

			}
			catch(Exception e)
			{
                 driver.findElement(saveAssetButton).click();

			}
		 
	}
	@And("^comes back to pdp page and verifys image is uploaded$")
	public void comes_back_to_pdp_page_and_verifys_image_is_uploaded() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(priceInList).click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(priceInPDP));
	}
	@And("^Verifys if the added image can be opened$")
	public void Verifys_if_the_added_image_can_be_opened() throws Throwable
	{
		driver.findElement(imageAddedAsAsset).click();
		cf.isElementPresent(notesHeader);
		driver.navigate().back();
	}
	
	@And("^verifys all notes are displayed$")
	public void verifys_all_notes_are_displayed() throws Throwable
	{
       cf.isElementPresent(commentOne);
       cf.isElementPresent(commentTwo);
       cf.isElementPresent(commentThree);
     }
	
	@And("^Verify \"([^\"]*)\" field is visible$")
	public void verify_field_is_visible(String field) throws Throwable
	{
		if(field.equals("comment text box"))
		{
			Assert.assertTrue(driver.findElement(editTextNote).isDisplayed(), "New comment box is not visible after adding comment");
		}
	}
	
	@And("^User clicks on property in \"([^\"]*)\" section")
	public void User_clicks_on_property_in_section(String Section) throws Throwable
	{
	  if(Section.equals("saved search"))
  	   {
		  driver.findElement(SavedSearchLocation).click();
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(searchingDialouge));

  	   }
	}
	@And("^User Clicks on any property to navigate to pdp page from \"([^\"]*)\" view$")
	public void User_Clicks_on_any_property_to_navigate_to_pdp_page_from_view(String View) throws Throwable
	{
		if(View.equals("Swipe"))
		{
			driver.findElement(SwipePrice).click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(priceInPDP));

		}
	}
	
	
	@And("^Verify it is asking unauthenticated user to login when he tries to submit comment$")
	public void Verify_it_is_asking_unauthenticated_user_to_login_when_he_tries_to_submit_comment() throws Throwable
	{
		try
		{
			cf.scrollToText("Notes", driver);
			System.out.println(" its at Notes section");

		}
		catch(Exception e)
		{
			System.out.println("Already its at Notes section");
		}
		driver.findElement(editTextField).click();
		Assert.assertTrue(driver.findElement(onboarding_SignInBtn).isDisplayed(), "Not asking unauthenticated user to login");

	}
	
	@And("^Verify User Photos section is not displayed when image is not uploaded$")
	public void Verify_User_Photos_section_is_not_displayed_when_image_is_not_uploaded_or_deleted() throws Throwable
	{
		driver.findElement(imageView).click();
		for(int i=0;i<13;i++)
		{
			cf.verticalScrollUpwards(driver);
		}
		cf.isElementPresent(UserPhotosSection);
	}
	@And("^Verify User Photos section is displayed when image is uploaded$")
	public void Verify_User_Photos_section_is_displayed_when_image_is_uploaded() throws Throwable
	{
		for(int i=0;i<4;i++)
		{
			cf.verticalScrollDownwrds(driver);
		}
		Verify_User_Photos_section_is_not_displayed_when_image_is_not_uploaded_or_deleted();
		//Assert.assertTrue(driver.findElement(UserPhotosSection).isDisplayed(), "User Photos section is not displayed");
	}
	@And("^Opens the image from User photos section and verifys text and bin icon$")
	public void Opens_the_image_from_User_photos_section_and_verifys_text_and_bin_icon() throws Throwable
	{
		driver.findElement(UploadedPhoto).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(UploadedImageText));
		Assert.assertTrue(driver.findElement(UploadedImageText).isDisplayed(), "Image Text on uploaded image is not displayed");
		Assert.assertTrue(driver.findElement(UploadedImageDeleteIcon).isDisplayed(), "Delete Icon on Uploaded image is not displayed");
		driver.navigate().back();
		
    }
	@And("^verify comment is not deleted when image is deleted$")
	public void verify_comment_is_not_deleted_when_image_is_deleted() throws Throwable
	{
		Assert.assertTrue(driver.findElement(commentTextView).isDisplayed(), "Comment is deleted when image is deleted");

	}
	@And("^Verify User Photos section is not displayed when image is not deleted$")
	public void Verify_User_Photos_section_is_not_displayed_when_image_is_not_deleted() throws Throwable
	{
		Verify_User_Photos_section_is_displayed_when_image_is_uploaded();
	}
	
	@And("^Verify if image thumbnail is viewable in collapse view$")
	public void Verify_if_image_thumbnail_is_viewable_in_collapse_view() throws Throwable
	{
		String Collapsetext = driver.findElement(collapseAllButton).getText();
		Assert.assertEquals(Collapsetext, "Collapse");
		Assert.assertTrue(driver.findElement(imageInAssetEditSection).isDisplayed(), "Image Thumbnail is not visible in collapse section");
	}

}
