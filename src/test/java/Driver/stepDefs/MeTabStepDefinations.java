package Driver.stepDefs;

import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Driver.desiredCapabilities;
import ObjectRepository.MeTab_OR;
import ObjectRepository.Registration_OR;
import PageObjects.commonFunctions;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class MeTabStepDefinations extends desiredCapabilities implements MeTab_OR,Registration_OR {
	
	commonFunctions cf = new commonFunctions();
	String FirstName;
	String LastName;
	String Location;
	
	 @Given("^Verify different options in ME tab are present$")
	 public void Verify_different_options_in_ME_tab_are_present(DataTable Suggestions) throws Throwable {
			List<List<String>> data = Suggestions.raw();
			
			if(data.get(0).get(0).equals("Edit Profile"))
			{
			     Assert.assertTrue(driver.findElement(EditProfile).isDisplayed(),data.get(0).get(0)+ "Element is not present in ME tab");
                 System.out.println(data.get(0).get(0)+"is still present in ME tab");

			}
		    if(data.get(1).get(0).equals("Update Password"))
			{
			     Assert.assertTrue(driver.findElement(UpdatePassword).isDisplayed(),data.get(1).get(0)+ "Element is not present in ME tab");
                 System.out.println(data.get(1).get(0)+"is still present in ME tab");
			}
		    if(data.get(2).get(0).equals("My Tours & Open Houses"))
			{
			    Assert.assertTrue(driver.findElement(MyToursAndOPenHouses).isDisplayed(),data.get(2).get(0)+ "Element is not present in ME tab");
				System.out.println(data.get(2).get(0)+"is still present in ME tab");
			}
		   if(data.get(3).get(0).equals("Sell My Home"))
			{
			    Assert.assertTrue(driver.findElement(SellMyHome).isDisplayed(),data.get(3).get(0)+ "Element is not present in ME tab");
				System.out.println(data.get(3).get(0)+"is still present in ME tab");
			}
		   if(data.get(4).get(0).equals("Notifications"))
			{
			     Assert.assertTrue(driver.findElement(Notifications).isDisplayed(),data.get(4).get(0)+ "Element is not present in ME tab");
				System.out.println(data.get(4).get(0)+"is still present in ME tab");
			}
		   if(data.get(5).get(0).equals("Help"))
			{
				 cf.scrollToText("Sign Out", driver);
			     Assert.assertTrue(driver.findElement(Help).isDisplayed(),data.get(5).get(0)+ "Element is not present in ME tab");
				 System.out.println(data.get(5).get(0)+"is still present in ME tab");
			}
		   if(data.get(6).get(0).equals("Privacy Policy"))
			{
			     Assert.assertTrue(driver.findElement(PrivacyPolicy).isDisplayed(),data.get(6).get(0)+ "Element is not present in ME tab");
				 System.out.println(data.get(6).get(0)+"is still present in ME tab");
			}
		    if(data.get(7).get(0).equals("Terms and Conditions"))
			{
			     Assert.assertTrue(driver.findElement(TermsAndConditions).isDisplayed(),data.get(7).get(0)+ "Element is not present in ME tab");
				 System.out.println(data.get(7).get(0)+"is still present in ME tab");
			}
		    if(data.get(8).get(0).equals("FAQs"))
			{
			     Assert.assertTrue(driver.findElement(FAQ).isDisplayed(),data.get(8).get(0)+ "Element is not present in ME tab");
				 System.out.println(data.get(8).get(0)+"is still present in ME tab");
			}
		   if(data.get(9).get(0).equals("FeedBack"))
			{
			     Assert.assertTrue(driver.findElement(Feedback).isDisplayed(),data.get(9).get(0)+ "Element is not present in ME tab");
				 System.out.println(data.get(9).get(0)+"is still present in ME tab");
			}
		   if(data.get(10).get(0).equals("Sign Out"))
			{
			     Assert.assertTrue(driver.findElement(onboarding_SignOutLink).isDisplayed(),data.get(10).get(0)+ "Element is not present in ME tab");
				 System.out.println(data.get(10).get(0)+"is still present in ME tab");
			}
		   else
		   { 
			    System.out.println("No section requires to be validate in ME tab");
		   }
			
			
	 }
	 
	 @And("^Edits \"([^\"]*)\"$")
	 public void Edits_details(String formfields) throws Throwable {
	 
		 if(formfields.equals("Firts Name"))
		 {
			 driver.findElement(EditProfileFirstName).clear();
			 driver.findElement(EditProfileFirstName).sendKeys("ThirdOne");
			 FirstName = driver.findElement(EditProfileFirstName).getText();

		 }
		 else if(formfields.equals("Last Name"))
		 {
			 driver.findElement(EditProfileSecondName).clear();
			 driver.findElement(EditProfileSecondName).sendKeys("Costopper");
			 LastName = driver.findElement(EditProfileSecondName).getText();

		 }
		 else if(formfields.equals("Location"))
		 {
			 driver.findElement(EditProfileLocation).sendKeys("Delhi");
			 Location = driver.findElement(EditProfileLocation).getText();
             driver.findElement(EditProfileDone).click();

		 }
	 }
	 
	 @And("^Verify \"([^\"]*)\" fields are updated$")
	 public void Verify_fields_are_updated(String fields) throws Throwable
	 {
		 if(fields.equals("First & Last Name"))
		 {
			 String ReflectedName = driver.findElement(UpdatedName).getText();
			 Assert.assertTrue(ReflectedName.contains(FirstName) && ReflectedName.contains(LastName), "FirstName and Last Name are not updated");
		 }
		 else if(fields.equals("Location"))
		 {
			 String ReflectedLocation = driver.findElement(UpdatedLocation).getText();
			 Assert.assertTrue(ReflectedLocation.contains(Location) , "Location is not updated");

		 }
	 }
	 
	 @SuppressWarnings("deprecation")
	@And("^Validate all options in ME tab$")
	 public void Validate_all_options_in_ME_tab(DataTable Suggestions) throws Throwable
	 {
			List<List<String>> data = Suggestions.raw();
             
			if (data.get(0).get(0).equals("Sell My Home"))
			{
				wait.until(ExpectedConditions.textToBePresentInElement(SellMyHome, "Sell My Home"));
				driver.findElement(SellMyHome).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(SellPageOpen));
				Assert.assertTrue(driver.findElement(SellPageOpen).isDisplayed(), "Sell page is not opened");
				driver.navigate().back();
			}
			if (data.get(1).get(0).equals("Privacy Policy"))
			{
				 cf.scrollToText("Sign Out", driver);
				wait.until(ExpectedConditions.textToBePresentInElement(PrivacyPolicy, "Privacy Policy"));
				driver.findElement(PrivacyPolicy).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(PageOpenElement));
				Assert.assertTrue(driver.findElement(PageOpenElement).isDisplayed(), "Privacy page is not opened");
				driver.navigate().back();

			}
			if (data.get(2).get(0).equals("Help"))
			{
				wait.until(ExpectedConditions.textToBePresentInElement(Help, "Help"));
				driver.findElement(Help).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(PageOpenElement));
				Assert.assertTrue(driver.findElement(PageOpenElement).isDisplayed(), "Help page is not opened");
				driver.navigate().back();

			} 
			if (data.get(3).get(0).equals("Terms & Conditions"))
			{
				wait.until(ExpectedConditions.textToBePresentInElement(TermsAndConditions, "Terms and Conditions"));
				driver.findElement(TermsAndConditions).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(PageOpenElement));
				Assert.assertTrue(driver.findElement(PageOpenElement).isDisplayed(), "Terms and Conditions page is not opened");
				driver.navigate().back();
            }
			if (data.get(4).get(0).equals("FAQ's"))
			{
				wait.until(ExpectedConditions.textToBePresentInElement(FAQ, "FAQs"));
				driver.findElement(FAQ).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(PageOpenElement));
				Assert.assertTrue(driver.findElement(PageOpenElement).isDisplayed(), "FAQ page is not opened");
            }
			else
			{	
				System.out.println("No ME tab section to be validated");
			}
			
		}
	 
	   @And("^Verify it asks user to login$")
	   public void Verify_it_asks_user_to_login() throws Throwable
	   {
		   Assert.assertTrue(driver.findElement(onboarding_SignInBtn).isDisplayed(), "it is not asking user to sign in");
	   }
	   
	   @And("^User submits feed back form$")
	   public void User_submits_feed_back_form() throws Throwable
	   {
		   wait.until(ExpectedConditions.presenceOfElementLocated(FeedbackPageHappyCheckBox));
		   driver.findElement(FeedbackPageHappyCheckBox).click();
		   cf.scrollToText("Submit", driver);
		   driver.findElement(FeedbackpageSubmit).click();
	   }
	   
	   @And("^Validates all notifications and toggles$")
	   public void Validates_all_notifications_and_toggles() throws Throwable
	   {
		   wait.until(ExpectedConditions.presenceOfElementLocated(NotificationsFavourite));
		   String NotificationName = driver.findElement(NotificationsFavourite).getText();
		   Assert.assertTrue(NotificationName.equals("Favorites"), "Favourite Notification is not present");
		   driver.findElement(FavouriteToggle).click();
		   driver.findElement(FavouriteToggle).click();
		   String ToggleValue = driver.findElement(FavouriteToggle).getText();
		   Assert.assertTrue(ToggleValue.equals("ON"), "Favourite Notification is not present");
       }
	   
	   @SuppressWarnings("deprecation")
	@And("^Validates \"([^\"]*)\" tab$")
	   public void Validates_tab(String tab) throws Throwable
	   {
		   if(tab.equals("Requested Tours"))
		   {
	            wait.until(ExpectedConditions.textToBePresentInElement(PastTourMessage, "No Requested Tours"));
			   Assert.assertTrue(driver.findElement(PastTourMessage).isDisplayed(), "Request Tour tab is not opened");
		   }
		   else if(tab.equals("Saved Open Houses"))
		   {
	            wait.until(ExpectedConditions.textToBePresentInElement(SavedOpenHousesMessage, "No Saved Open Houses"));
                Assert.assertTrue(driver.findElement(SavedOpenHousesMessage).isDisplayed(), "Saved open house tab is not opened");

		   }
		   else
		   {
			   System.out.println("No tab present to be validated");
		   }
	   }
	   
	 

}
