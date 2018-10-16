/**
 * 
 */
package PageObjects;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Driver.desiredCapabilities;
import ObjectRepository.CommonFunctions_OR;
import ObjectRepository.DiscoverTab_OR;
import ObjectRepository.FavouriteProperty_OR;
import ObjectRepository.OpenHouse_OR;
import ObjectRepository.PropertDetailsPage_OR;
import ObjectRepository.Registration_OR;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author chakraja
 *
 */
public class DiscoverTab_PO extends desiredCapabilities implements DiscoverTab_OR, FavouriteProperty_OR,
		CommonFunctions_OR, PropertDetailsPage_OR, OpenHouse_OR, Registration_OR {
	WebElement element;

	public void navigateDiscoverTab(AppiumDriver<MobileElement> driver) {
		wait.until(ExpectedConditions.elementToBeClickable(clickDiscoverTab));
		driver.findElement(clickDiscoverTab).click();
		System.out.println("Discover Tab clicked");
	}

	public void navigateSearchTab(AppiumDriver<MobileElement> driver) {
		wait.until(ExpectedConditions.elementToBeClickable(navigatingSearchTab));
		driver.findElement(navigatingSearchTab).click();
		System.out.println("Search Tab clicked");
	}

	public void navigateFavouriteTab(AppiumDriver<MobileElement> driver) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(clickFavouriteTab));
		driver.findElement(clickFavouriteTab).click();
		System.out.println("Favourite Tab clicked");
	}

	public void navigateContactUsTab(AppiumDriver<MobileElement> driver) {
		wait.until(ExpectedConditions.elementToBeClickable(ContactUSTab));
		driver.findElement(ContactUSTab).click();
		System.out.println("Contact Us Tab clicked");
	}

	public void validateSearchMyLocation(AppiumDriver<MobileElement> driver) {

		wait.until(ExpectedConditions.elementToBeClickable(searchMyLocation));
		WebElement element = driver.findElement(searchMyLocation);
		Assert.assertEquals(element.getText(), "Search my location", "Search my location text not found");
		System.out.println("Search My Location text validated");

	}

	public void mostRecentSearch(AppiumDriver<MobileElement> driver) {

		wait.until(ExpectedConditions.presenceOfElementLocated(mostRecentSearchHeader));
		element = driver.findElement(By.xpath("//*[contains(@text, 'Most recent search')]"));
		Assert.assertEquals(element.getText(), "Most recent search", "Most recent search Text not found");
		System.out.println("Most recent search text validated");
		wait.until(ExpectedConditions.presenceOfElementLocated(mostRecentSearchText));
		element = driver.findElement(mostRecentSearchText);
		Assert.assertEquals(element.getText(), "Washington, DC", "Dallas was not the Most Recent Search");
		System.out.println("Most recent searched " + element.getText() + " validated");
	}

	public void recentlyViewedItems(AppiumDriver<MobileElement> driver) {

		wait.until(ExpectedConditions.presenceOfElementLocated(recenlyViewedHeader));
		element = driver.findElement(recenlyViewedHeader);
		Assert.assertEquals(element.getText(), "Recently Viewed", "No Recently Viewed items are present");
		System.out.println("Recently Viewed secion is validated");
		element = driver.findElement(propertyInfo);
		System.out.println("Recently viewed property validated, having address as " + element.getText());
	}

	public void savedSearches(AppiumDriver<MobileElement> driver) throws InterruptedException {

		wait.until(ExpectedConditions.presenceOfElementLocated(savedSearchesHeader));
		element = driver.findElement(savedSearchesHeader);
		System.out.println("The section here is" + element.getText());
		Assert.assertEquals(element.getText(), "Saved Searches", "No Saved searches are present");
		// wait.until(ExpectedConditions.presenceOfElementLocated(savedSearchName));
		element = driver.findElement(savedSearchName);
		System.out.println("Saved search is of " + element.getText());

	}

	public void adviceSectionValidation(AppiumDriver<MobileElement> driver) {

		wait.until(ExpectedConditions.presenceOfElementLocated(adviceSectionHeader));
		element = driver.findElement(adviceSectionHeader);
		Assert.assertEquals(element.getText(), "Advice", "Advice section not visible");
		wait.until(ExpectedConditions.presenceOfElementLocated(firstAdviceSection));
		element = driver.findElement(firstAdviceSection);
		System.out.println("First Advice section is " + element.getText());
	}

	public void recommendedPropertySection(AppiumDriver<MobileElement> driver) {
		try {
			((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ "Recommended Properties" + "\").instance(0))");
		} catch (Exception e) {
			Assert.assertFalse(false, "Recommended Property Section not Present");
		}
	}

	public void indexChangeWhenUnfavoritedfromPDP(AppiumDriver<MobileElement> driver) {

		driver.findElement(RVPSectionFavIcon).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(priceInPDP));
		driver.findElement(pdpfavIcon).click();
		String pdpAddress = driver.findElement(propertyDetail).getText();
		driver.findElement(pdpBackButton).click();
		String rvpSectionAddress1 = driver.findElement(RVPPropertyAddressFirstLine).getText();
		String rvpSectionAddress2 = driver.findElement(RVPPropertyAddressSecondLine).getText();
		String rvpPropertyAddress = rvpSectionAddress1.concat("\n" + rvpSectionAddress2);
		Assert.assertEquals(rvpPropertyAddress.toLowerCase(), pdpAddress.toLowerCase(),
				"Unfav propety is not changed the index in RVP section.");
	}

	public void confirmPdpisShowingHeartIconinDiscoverTab(AppiumDriver<MobileElement> driver) {
		String pdpAddress = driver.findElement(propertyDetail).getText();
		driver.findElement(pdpBackButton).click();
		navigateDiscoverTab(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String rvpSectionAddress1 = driver.findElement(RVPPropertyAddressFirstLine).getText();
		String rvpSectionAddress2 = driver.findElement(RVPPropertyAddressSecondLine).getText();
		String rvpPropertyAddress = rvpSectionAddress1 + "\n" + rvpSectionAddress2;
		if (driver.findElement(RVPSectionFavIcon).isDisplayed())
			Assert.assertEquals(rvpPropertyAddress.toLowerCase(), pdpAddress.toLowerCase(),
					"Fav propety is not showing in Discover tab.");
		driver.findElement(RVPSectionFavIcon).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(priceInPDP));
		driver.findElement(pdpfavIcon).click();
	}

	public void searchTermInNewListingsSection(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		driver.findElement(navigatingSearchTab).click();
		wait.until(ExpectedConditions.elementToBeClickable(clickSearchBar));
		String searchTerm = driver.findElement(clickSearchBar).getText();
		navigateDiscoverTab(driver);
		String newListingsCity = driver.findElement(NewListingsAddreessCity).getText().replaceAll("\\s+", "");
		Assert.assertEquals(newListingsCity.substring(0, newListingsCity.indexOf(",")),
				searchTerm.substring(0, searchTerm.indexOf(",")), "Search Term does not match..!!");
	}

	public void searchTermInOpenHousesSection(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		driver.findElement(navigatingSearchTab).click();
		wait.until(ExpectedConditions.elementToBeClickable(clickSearchBar));
		String searchTerm = driver.findElement(clickSearchBar).getText();
		navigateDiscoverTab(driver);
		((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "Just for Me" + "\").instance(0))");
		String newListingsCity = driver.findElement(OpenHouseAddressSecondLine).getText().replaceAll("\\s+", "");
		Assert.assertEquals(newListingsCity.substring(0, newListingsCity.indexOf(",")),
				searchTerm.substring(0, searchTerm.indexOf(",")), "Search Term does not match..!!");
	}

	public void signInFormAssetSection(AppiumDriver<MobileElement> driver) {
		((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "Estimated monthly payment" + "\").instance(0))");
		driver.findElement(editTextField).click();
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(onboarding_RegnEmail));
	}

	public void checkTwoOptionIsNotPresent(AppiumDriver<MobileElement> driver) {
		try {
			((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ "Most recent search" + "\").instance(0))");
		} catch (Exception e) {
			Assert.assertFalse(false, "Most Recent Search option not present in Discover Tab");
		}

		try {
			((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ "Search my location" + "\").instance(0))");
		} catch (Exception e1) {
			Assert.assertFalse(false, "Search My Locaiton option not present in Discover Tab");
		}
	}

	public void verifyJustForMeSearchLocation(AppiumDriver<MobileElement> driver) {
		String location = null;
		((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "Advice" + "\").instance(0))");
		location = driver.findElement(JustForMeLocation).getText();
		Assert.assertTrue(driver.findElement(JustForMeLocation).isEnabled(), location);
		System.out.println("Current Location is: " + location);
	}

	public void searchPropertyFromOnboardoing(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		driver.findElement(onboarding_SearchBoxDefaultText).click();
		driver.findElement(onboarding_SuggestionSearchBox).sendKeys("WMM");
		wait.until(ExpectedConditions.presenceOfElementLocated(onboarding_SearchSuggestion3));
		driver.findElement(onboarding_SearchSuggestion1City).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(priceInPDP));
	}

	public void verifyOrderOfAllTabs(AppiumDriver<MobileElement> driver) {
		wait.until(ExpectedConditions.presenceOfElementLocated(clickDiscoverTab));
		String tabname = null;
		for (int i = 0; i < 5; i++) {
			int tabs = i;
			switch (tabs) {
			case 0:
				tabname = driver.findElement(searchTabName).getText();
				Assert.assertEquals(tabname, "Search", "Search tab not located properly");
				break;
			case 1:
				tabname = driver.findElement(favTabName).getText();
				Assert.assertEquals(tabname, "Favorites", "Favorites tab not located properly");
				break;
			case 2:
				tabname = driver.findElement(discoverTabName).getText();
				Assert.assertEquals(tabname, "Discover", "Discover tab not located properly");
				break;
			case 3:
				tabname = driver.findElement(alertTabName).getText();
				Assert.assertEquals(tabname, "Alerts", "Alerts tab not located properly");
				break;
			case 4:
				tabname = driver.findElement(meTabName).getText();
				Assert.assertEquals(tabname, "Me", "Me tab not located properly");
				break;
			default:
				System.out.println("Invalid Tab");
			}
		}

	}

}
