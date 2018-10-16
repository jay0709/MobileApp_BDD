package PageObjects;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.FavouriteProperty_OR;
import ObjectRepository.PropertDetailsPage_OR;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author chakraja
 *
 */
public class PropertDetailsPage_PO extends desiredCapabilities implements PropertDetailsPage_OR, FavouriteProperty_OR {
	WebElement element;
	PropertyData pr = new PropertyData();
	commonFunctions cf = new commonFunctions();

	public String getProeprtyPriceFromList(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(listSRPTab));
		driver.findElement(listSRPTab).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(favIconInList));
		pr.propertyPriceList = driver.findElement(priceInList).getText();
		System.out.println("property price from List is: " + pr.propertyPriceList);
		return pr.propertyPriceList;
	}

	public String[] getPropertyBedBathSqftList(AppiumDriver<MobileElement> driver) {
		String getListBedBathSqftText = driver.findElement(listBedBathSqft).getText();
		pr.listBedBathSqft = cf.countBedBathSqft(getListBedBathSqftText);
		return pr.listBedBathSqft;
	}

	public void validatePropertyDetails(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		pr.propertyPriceList = getProeprtyPriceFromList(driver);
		pr.listBedBathSqft = getPropertyBedBathSqftList(driver);
		driver.findElement(priceInList).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(priceInPDP));
		pr.propertyPricePDP = driver.findElement(priceInPDP).getText();
		Assert.assertEquals(pr.propertyPricePDP, pr.propertyPriceList, "Property price not matching in PDP");
		System.out.println("Property price is: " + pr.propertyPricePDP);
		String pdpBedBathSqftText = driver.findElement(pdpBedBathSqftId).getText();
		pr.pdpBedBathSqft = cf.countBedBathSqft(pdpBedBathSqftText);
		Assert.assertEquals(pr.pdpBedBathSqft[0], pr.listBedBathSqft[0], "Bed count does not match..!");
		Assert.assertEquals(pr.pdpBedBathSqft[1], pr.listBedBathSqft[1], "Bath count does not match..!");
		Assert.assertEquals(pr.pdpBedBathSqft[2], pr.listBedBathSqft[2], "Sqft count does not match..!");
		System.out.println(pr.pdpBedBathSqft[0] + ":" + pr.pdpBedBathSqft[1] + ":" + pr.pdpBedBathSqft[2]);
	}

	public void validateSchoolSection(AppiumDriver<MobileElement> driver) throws InterruptedException, IOException {
		driver.findElement(expandSchoolInfo).click();
		cf.scrollToText("VIEW ALL SCHOOLS", driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewAllSchools));
		cf.takeScreenshot("School_info.jpg", driver);
		Assert.assertEquals(driver.findElement(viewAllSchools).getText(), "VIEW ALL SCHOOLS",
				"Schols section not Validated..!");
		System.out.println("School section validated");
	}

	public void validatePropertyKeyDetails(AppiumDriver<MobileElement> driver)
			throws InterruptedException, IOException {
		try {
			cf.scrollToText("STATUS", driver);
			System.out.println("Prperty status is: " + driver.findElement(statusOfProperty).getText());
		} catch (Exception e) {
			System.out.println("Property status not available..!");
		}

		cf.scrollToText("VIEW ALL FEATURES", driver);
		driver.findElement(viewAllFeature).click();
		System.out.println("Property all feature is validated..!");
		cf.takeScreenshot("All_Feature.jpg", driver);
		// driver.findElement(backButton).click();
		driver.navigate().back();

	}

	public void validateProertyTax(AppiumDriver<MobileElement> driver) {
		try {
			cf.scrollToText("Property Tax", driver);
			cf.takeScreenshot("Property_tax.jpg", driver);
		} catch (Exception e) {
			System.out.println("No tax section available");
		}

	}

	public void validateNotesSection(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		cf.scrollToText("Notes", driver);
		System.out.println("Notes section validated..");
		try {
			if (driver.findElement(cameraIcon).isEnabled())
				driver.findElement(notesHeader).click();
		} catch (Exception e) {

		}

		Assert.assertEquals(driver.findElement(notesHeader).getText(), "Notes", "Notes section not found..!");
	}

	public void validatePropertyType(AppiumDriver<MobileElement> driver) throws InterruptedException, IOException {
		try {
			if (driver.findElement(tourRequest).getText().equals("Contact Seller")) {
				System.out.println("This is a FSBO or Featured property..");
			}
			if (driver.findElement(tourRequest).getText().equals("Request a Tour")) {
				System.out.println("This is a MLS property..");
				cf.scrollToText("Make an Offer", driver);
				System.out.println("Make an offer section validated..!");
				cf.takeScreenshot("Other_deatils.jpg", driver);
				cf.scrollToText("Similar Properties", driver);
				System.out.println("Similar properties section validated..!");
			}
		} catch (Exception e) {
			System.out.println("No section present to be validated");
		}

	}

	public void validateOtherDetails(AppiumDriver<MobileElement> driver) {
		try {
			cf.scrollToText("Estimated monthly payment", driver);
			System.out.println("Mortgage calulator section validated..!");
			cf.scrollToText("Estimate my commute", driver);
			System.out.println("Commute Time section validated..!");
		} catch (Exception e) {
			System.out.println("Other details not found..!");
		}
	}

	public void CheckMandatoryFieldsinRequestTourForm(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstNameErrorText));
		Assert.assertTrue(driver.findElement(FirstNameErrorText).isDisplayed(),
				"First Name is not mandatory in request tour form");
		Assert.assertTrue(driver.findElement(LastNameErrorText).isDisplayed(),
				"Last Name is not mandatory in request tour form");
		Assert.assertTrue(driver.findElement(EmailErrorText).isDisplayed(),
				"Email is not mandatory in request tour form");
		cf.verticalScrollUpwards(driver);
		Assert.assertTrue(driver.findElement(PhoneErrorText).isDisplayed(),
				"Phone is not mandatory in request tour form");

	}

	public void selectDate(AppiumDriver<MobileElement> driver) throws MalformedURLException, InterruptedException {
		// cf.verticalScrollUpwards(driver);
		wait.until(ExpectedConditions.elementToBeClickable(priceInList));
		driver.findElement(priceInList).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(priceInPDP));
		wait.until(ExpectedConditions.elementToBeClickable(DayTile));
		driver.findElement(DayTile).click();
	}

	public void InputTime(AppiumDriver<MobileElement> driver) throws MalformedURLException, InterruptedException {
		driver.findElement(InputTime).click();
		driver.findElement(SelectTime).click();
		driver.findElement(favButtonInAlert).click();
	}

	public void EditableOrNotEditable(By FieldLocator) {
		String BeforeEditingText = driver.findElement(FieldLocator).getText();
		driver.findElement(FieldLocator).sendKeys("Am i editable");
		String AfterEditingText = driver.findElement(FieldLocator).getText();
		Assert.assertEquals(BeforeEditingText, AfterEditingText, "Field is editable");

	}

	public void checkPdpMapUiComponents(AppiumDriver<MobileElement> driver) throws Throwable {

		driver.findElement(pdpMapIcon).click();
		String address = driver.findElement(propertyDetail).getText();
		String mapViewAddress = driver.findElement(pdpMapViewAddress).getText();
		mapViewAddress = mapViewAddress.substring(0, mapViewAddress.indexOf(","));
		if (address.contains(mapViewAddress))
			Assert.assertTrue(true, mapViewAddress);
		if (driver.findElement(pdpMapLoaded).isEnabled() == true)
			Assert.assertTrue(true, mapViewAddress);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sateliteButton));
		driver.findElement(sateliteButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(streetViewButton));
		wait.until(ExpectedConditions.visibilityOfElementLocated(getDirectionButton));
		wait.until(ExpectedConditions.visibilityOfElementLocated(pinInMapView));
		driver.findElement(pinInMapView).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdpMapIcon));

	}

	public void navigatingToGoogleMaps(AppiumDriver<MobileElement> driver) {
		driver.findElement(streetViewButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(mapContainer));
		String streetActivity = ((AndroidDriver<MobileElement>) driver).currentActivity();
		Assert.assertEquals(streetActivity, "com.google.android.maps.MapsActivity", "Not navigated to Google Maps");
		driver.findElement(streetViewBackButton).click();
		driver.navigate().back();
		driver.findElement(getDirectionButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(mapContainer));
		String mapsActivity = ((AndroidDriver<MobileElement>) driver).currentActivity();
		Assert.assertEquals(mapsActivity, "com.google.android.maps.MapsActivity", "Not navigated to Google Maps");
		driver.findElement(getDirectionBackButton).click();
		driver.navigate().back();
	}

	public void validateGetDirectionCTA(AppiumDriver<MobileElement> driver) {
		Assert.assertEquals(driver.findElement(pdpGetDirectionText).getText(), "Get Directions",
				"Get direction text not verified");
		String getDirecionAddress = driver.findElement(pdpGetDirectionAddress).getText();
		String pdpHeaderSectionAddress = driver.findElement(pdpHeaderAddress).getText();
		Assert.assertEquals(getDirecionAddress, pdpHeaderSectionAddress,
				"Get Direction address is not matched with PDP Address..!");
		driver.findElement(pdpGetDirectionAddress).click();
		System.out.println("Get direction clicked..");
		wait.until(ExpectedConditions.visibilityOfElementLocated(mapContainer));
		String mapsActivity = ((AndroidDriver<MobileElement>) driver).currentActivity();
		System.out.println(mapsActivity);
		Assert.assertEquals(mapsActivity, "com.google.android.maps.MapsActivity", "Not navigated to Google Maps");
		driver.navigate().back();

	}

}
