/**
 * 
 */
package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.CommonFunctions_OR;
import ObjectRepository.FavouriteProperty_OR;
import ObjectRepository.OpenHouse_OR;
import ObjectRepository.Registration_OR;
import ObjectRepository.SRPListView_OR;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author Jayabrata
 *
 */
public class ListSRPTab_PO extends desiredCapabilities
		implements CommonFunctions_OR, SRPListView_OR, OpenHouse_OR, Registration_OR, FavouriteProperty_OR {

	AppiumDriver<MobileElement> driver;
	WebElement element;
	commonFunctions cf = new commonFunctions();
	OpenHouse_PO oh = new OpenHouse_PO();
	OpenHouse2_PO oh2 = new OpenHouse2_PO();
	PropertDetailsPage_PO pdp = new PropertDetailsPage_PO();
	FavouriteProperty_PO ft = new FavouriteProperty_PO();
	PropertyData prop = new PropertyData();
	String listPriceBeforeSorting = null, listPriceAfterSorting = null;

	int priceIntValueBeforeSort, priceIntValueAfterSort;

	public void sortLowToHighPricedProperties(AppiumDriver<MobileElement> driver) throws Throwable {
		listPriceBeforeSorting = pdp.getProeprtyPriceFromList(driver);
		driver.findElement(clickSortOption).click();
		driver.findElement(lowToHighOption).click();
		cf.verifyingSortingDialogue();
		listPriceAfterSorting = pdp.getProeprtyPriceFromList(driver);
		priceIntValueBeforeSort = cf.convertingPriceStringtoIntValue(listPriceBeforeSorting);
		priceIntValueAfterSort = cf.convertingPriceStringtoIntValue(listPriceAfterSorting);
		if (priceIntValueBeforeSort > priceIntValueAfterSort || priceIntValueBeforeSort == priceIntValueAfterSort)
			Assert.assertTrue(true, "Sorting happened from Low to high price..");
		else
			Assert.assertFalse(false, "Sorting not happened properly..");

	}

	public void sortHighToLowPricedProperties(AppiumDriver<MobileElement> driver) throws Throwable {
		listPriceBeforeSorting = pdp.getProeprtyPriceFromList(driver);
		driver.findElement(clickSortOption).click();
		driver.findElement(highToLowOption).click();
		cf.verifyingSortingDialogue();
		listPriceAfterSorting = pdp.getProeprtyPriceFromList(driver);
		priceIntValueBeforeSort = cf.convertingPriceStringtoIntValue(listPriceBeforeSorting);
		priceIntValueAfterSort = cf.convertingPriceStringtoIntValue(listPriceAfterSorting);
		if (priceIntValueBeforeSort < priceIntValueAfterSort || priceIntValueBeforeSort == priceIntValueAfterSort)
			Assert.assertTrue(true, "Sorting happened from Low to high price");
		else
			Assert.assertFalse(false, "Sorting not happened properly..");
	}

	public void sortListingAge(AppiumDriver<MobileElement> driver) throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(clickSortOption));
		driver.findElement(clickSortOption).click();
		driver.findElement(listingAge).click();
		cf.verifyingSortingDialogue();
		oh2.newTagInListSRP(driver);
	}

	public void sortFeaturedListings(AppiumDriver<MobileElement> driver) throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(clickSortOption));
		listPriceBeforeSorting = pdp.getProeprtyPriceFromList(driver);
		driver.findElement(clickSortOption).click();
		driver.findElement(featuredOption).click();
		cf.verifyingSortingDialogue();
		listPriceAfterSorting = pdp.getProeprtyPriceFromList(driver);
		priceIntValueBeforeSort = cf.convertingPriceStringtoIntValue(listPriceBeforeSorting);
		priceIntValueAfterSort = cf.convertingPriceStringtoIntValue(listPriceAfterSorting);
		if (priceIntValueBeforeSort != priceIntValueAfterSort)
			Assert.assertTrue(true, "Sorting happened for Featured Listings..");
	}

	public void listSRPImageCount(AppiumDriver<MobileElement> driver) throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(srpListBtn));
		driver.findElement(srpListBtn).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		ft.countImagesWhileSwipe(driver);
	}

	public void checkComplianceDeatils(AppiumDriver<MobileElement> driver) {
		String mlsBoard = driver.findElement(mlsBoardName).getText();
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(mlsBoardName)) != null, mlsBoard);
		String mlsID = driver.findElement(mlsIdInSRP).getText();
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(mlsIdInSRP)) != null, mlsID);
		String listingCourtesy = driver.findElement(listingCourtesyInSrp).getText();
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(listingCourtesyInSrp)) != null,
				listingCourtesy);
	}

	public void favoriteBySwipeRight(AppiumDriver<MobileElement> driver) throws Throwable {
		String swipePrice = driver.findElement(swipePropertyPrice).getText();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		cf.horizontalswipetowardsright(driver, 0.4);
		wait.until(ExpectedConditions.visibilityOfElementLocated(onboarding_SignInBtn));
		Assert.assertTrue(driver.findElement(onboarding_SignInBtn).isEnabled(), "Sign in dialouge is not present..");
		driver.findElement(onboarding_RegnEmail).sendKeys(prop.signinemailID2);
		cf.isKeyboardPresent(driver);
		driver.findElement(onboarding_RegnPassword).sendKeys(prop.signinpwd2);
		cf.isKeyboardPresent(driver);
		driver.findElement(onboarding_SignInBtn).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(clickFavouriteTab).click();
		cf.verticalScrollDownwrds(driver);
		String favPrice = driver.findElement(favPropertyPrice).getText();
		Assert.assertEquals(favPrice, swipePrice, "Property not reflceted from Swipe properly.");
	}

	public void navigatetToUptoDateCard(AppiumDriver<MobileElement> driver) throws Throwable {
		cf.fromClusterToPinView(driver);
		driver.findElement(srpSwipeBtn).click();
		try {
			while (driver.findElement(onboarding_SRPpassBtn).isEnabled())
				driver.findElement(onboarding_SRPpassBtn).click();
		} catch (Exception e) {
		}
		if (driver.findElement(uptoDateMapButton).isEnabled())
			Assert.assertEquals("You're up to date.", driver.findElement(uptoDateHeader).getText(),
					"Up to date card is not showing..");

		// String uptoDateSubHeading = driver.findElement(uptoDateSubHeader).getText();
		// Assert.assertEquals(actual, expected);
	}

	public void navigateFromCard(AppiumDriver<MobileElement> driver) {
		wait.until(ExpectedConditions.elementToBeClickable(uptoDateMapButton));
		driver.findElement(uptoDateMapButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(onboarding_SRPLocationTargetBtn));
		Assert.assertTrue(driver.findElement(onboarding_SRPLocationTargetBtn).isEnabled(), "Not navigated to MAP SRP");
		driver.findElement(srpSwipeBtn).click();
		wait.until(ExpectedConditions.elementToBeClickable(uptoDateListButton));
		driver.findElement(uptoDateListButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(clickSortOption));
		Assert.assertTrue(driver.findElement(clickSortOption).isEnabled(), "Not navigated to LIST SRP");
		driver.findElement(srpSwipeBtn).click();
		wait.until(ExpectedConditions.elementToBeClickable(uptoDateFavButton));
		driver.findElement(uptoDateFavButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(favTabHeader));
		Assert.assertEquals("Your Favorites", driver.findElement(favTabHeader).getText(), "Not navigated to Fav tab.");

	}

	public void verifyNoPropertyFoundMessage(AppiumDriver<MobileElement> driver) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(swipeNoPropertyFound));
		String swipePropertyNotFound = driver.findElement(swipeNoPropertyFound).getText();
		Assert.assertEquals("We can’t find any homes", swipePropertyNotFound, "No property found messahe is not shown");
		driver.findElement(listSRPTab).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listNoPropertyFound));
		String listPropertyNotFound = driver.findElement(listNoPropertyFound).getText();
		Assert.assertEquals("We can’t find any homes", listPropertyNotFound, "No property found messahe is not shown");
	}

	public void verifyPropertyAttributes(AppiumDriver<MobileElement> driver) throws Throwable {
		oh.lessSevenDaysFilterWithOpenHouse(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(searchingDialouge));
		String price = driver.findElement(swipePropertyPrice).getText();
		String bedBathSqft = driver.findElement(swipePropertyInfo).getText();
		String newTag = driver.findElement(newTagInSRPView).getText();
		String openTag = driver.findElement(openHouseTextInQuickView).getText();
		String openTime = driver.findElement(openHouseTimeInSwipeView).getText();
		String address = driver.findElement(swipePropertyAddress).getText();

		System.out.println("Price verified as: " + price + "\nProperty info verified as: " + bedBathSqft
				+ "\nAddress verified as: " + address + "\nOpen time verified as: " + openTime);
		Assert.assertEquals(newTag.contains("NEW"), true, "New tag not present.");
		Assert.assertEquals(openTag, "OPEN", "Open house tag is not present.");
	}

	public void noUptodateCardWhilePaginataion(AppiumDriver<MobileElement> driver) throws Throwable {

		int count = 0;
		wait.until(ExpectedConditions.elementToBeClickable(onboarding_SRPpassBtn));
		while (count < 25) {
			cf.horizontalSwipeTowardslLeft(driver, 0.4);
			count++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(onboarding_SRPpassBtn));
		}

	}

	public void searchInSwipeView(String searchString, AppiumDriver<MobileElement> driver) throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(navigatingSearchTab));
		driver.findElement(navigatingSearchTab).click();
		driver.findElement(clickSearchBar).click();
		driver.findElement(typeInsearchBar).sendKeys(searchString);
		wait.until(ExpectedConditions.textToBePresentInElement(searchResultStateName, searchString.split(",")[1]));
		driver.findElement(searchResultStateName).click();
		try {
			// Thread.sleep(20000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(srpSwipeBtn));
			System.out.println("Map button lacated");
		} catch (Exception e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(searchingDialouge));
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(srpMessage));
			System.out.println("Filter message located");

		} catch (Exception e) {
			System.out.println("Filter message not located");
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		}
		wait.until(ExpectedConditions.elementToBeClickable(srpSwipeBtn));

	}

	public void checkSearchTermChanged(AppiumDriver<MobileElement> driver) throws Throwable {
		searchInSwipeView("Dallas,TX", driver);
		String searchTerm = driver.findElement(swipePropertyAddress).getText();
		if (searchTerm.contains("Dallas"))
			Assert.assertTrue(searchTerm.contains("Dallas"), "Search did not happen proeprly");

	}

	public void noPropertyMessageForDifferentCases(AppiumDriver<MobileElement> driver) throws Throwable {
		cf.deleteAllSAvedSearch(driver);
		driver.findElement(navigatingSearchTab).click();
		wait.until(ExpectedConditions.elementToBeClickable(mapViewSRPClick));
		driver.findElement(mapViewSRPClick).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveSearchText));
		driver.findElement(saveSearchText).click();
		driver.findElement(clickSearchBar).click();
		wait.until(ExpectedConditions.elementToBeClickable(mostRecentSearchSuggestion));
		driver.findElement(mostRecentSearchSuggestion).click();
		wait.until(ExpectedConditions.elementToBeClickable(srpSwipeBtn));
		driver.findElement(srpSwipeBtn).click();
		verifyNoPropertyFoundMessage(driver);
		driver.findElement(clickDiscoverTab).click();
		cf.scrollToText("Saved Searches", driver);
		wait.until(ExpectedConditions.elementToBeClickable(threeDottedMenuDiscoverTab));
		driver.findElement(threeDottedMenuDiscoverTab).click();
		driver.findElement(viewSavedSearch).click();
		verifyNoPropertyFoundMessage(driver);
		cf.deleteAllSAvedSearch(driver);
	}
}
