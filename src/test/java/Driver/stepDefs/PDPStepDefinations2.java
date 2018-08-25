package Driver.stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Driver.desiredCapabilities;
import ObjectRepository.CommonFunctions_OR;
import ObjectRepository.PropertDetailsPage_OR;
import ObjectRepository.Registration_OR;
import PageObjects.PropertDetailsPage_PO;
import PageObjects.commonFunctions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;


public class PDPStepDefinations2 extends desiredCapabilities implements PropertDetailsPage_OR,Registration_OR,CommonFunctions_OR {
	
	PropertDetailsPage_PO pdp = new PropertDetailsPage_PO();
    commonFunctions  cf = new commonFunctions();
    
	
	@And("^Input \"([^\"]*)\" date and time$")
	public void Input_date_and_time(String inputTime) throws Throwable 
	{
		if(inputTime.equals("Arrive By"))
		{
			driver.findElement(ArriveBy).click();
			pdp.InputTime(driver);
		}
		else if(inputTime.equals("Depart By"))
		{
			driver.findElement(DepartAt).click();
			pdp.InputTime(driver);

		}
	}
	
	
	@Given("^Verify if \"([^\"]*)\" is displayed from region \"([^\"]*)\"$")
	public void verify_if_is_displayed_from_region(String TimeDisplay, String Location) throws Throwable {
		
		Assert.assertTrue(driver.findElement(DestinationCommuteTime).isDisplayed(),"Destination commute time is not displayed from location"+Location);
		
	 }
	
	@And("^Selects \"([^\"]*)\" Property$")
	public void Select_any_property(String property) throws Throwable
	{
		
		driver.findElement(onboarding_SRPsortBtn).click();
		driver.findElement(SrpPricehighToLow).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}
	
	@And("^Verify \"([^\"]*)\" field is not editable$")
	public void Verify_field_is_not_editable(String FieldLocator) throws Throwable
	{
		if(FieldLocator.equals("Address"))
		{
		pdp.EditableOrNotEditable(AddressField);
		System.out.println("This"+FieldLocator+"field is not editable");
		
		}
	}
	
	@And("^Verify only one property is visble when map scrolled up and down$")
	public void Verify_only_one_property_is_visble_when_scrolled_up_and_down() throws Throwable
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdpMapLoaded));
        cf.isElementPresent(MapProperty);
		cf.verticalScrollUpwards(driver);
		cf.isElementPresent(MapProperty);

	}
	
	@And("^Verify \"([^\"]*)\" format$")
	public void Verify_date_format(String date) throws Throwable
	{
	    String dateformat = driver.findElement(PriceHistoryDate).getText();
	    System.out.println("Date format is"+dateformat);
		cf.DateFormatValidation(dateformat);
	}
	
	@And("^Verify event \"([^\"]*)\" is displayed$")
	public void Verify_event_is_displayed(String Event) throws Throwable
	{
		if(Event.equals("sold"))
		{
			String currentEvent = driver.findElement(EventSold).getText();
			Assert.assertTrue(currentEvent.equals("Sold"), "Event here is not sold");
		}
	}
	
	@And("^Verify spell of Date,Event and Price column$")
	public void Verify_spell_of_Date_Event_and_Price_column() throws Throwable
	{
		Assert.assertTrue(driver.findElement(DateColumn).getText().equals("Date"));
		Assert.assertTrue(driver.findElement(EventColumn).getText().equals("Event"));
		Assert.assertTrue(driver.findElement(PriceColumn).getText().equals("Price"));
    }

	@And("^Filter Listing as \"([^\"]*)\" and apply filter$")
	public void Filter_listeing_and_apply_filter(String Filter) throws Throwable
	{
		if(Filter.equals("Owners"))
		{
			driver.findElement(onboarding_SRPsetFilters).click();
			cf.scrollToText("Listed by", driver);
			driver.findElement(ListingByOwners).click();
			driver.findElement(onboarding_FilertsDoneBtn).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(searchingDialouge));
		}
	}
	
	@And("^Click on contact seller option and validate terms and condition presence$")
	public void Click_on_contact_seller_option_and_validate_terms_and_condition_presence() throws Throwable
	{
		driver.findElement(ContactSeller).click();
		Assert.assertTrue(driver.findElement(ContactSellerTnC).isDisplayed(),"Contact seller form is not opened");
	}
}
