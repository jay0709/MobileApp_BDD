package PageObjects;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.CommonFunctions_OR;
import ObjectRepository.FavouriteProperty_OR;
import ObjectRepository.OpenHouse_OR;
import ObjectRepository.Registration_OR;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class OpenHouse2_PO extends desiredCapabilities
		implements OpenHouse_OR, Registration_OR, CommonFunctions_OR, FavouriteProperty_OR {
	AppiumDriver<MobileElement> driver;
	WebElement element;
	commonFunctions cf = new commonFunctions();
	PropertyData pr = new PropertyData();
	OpenHouse_PO opn = new OpenHouse_PO();
	DiscoverTab_PO dp = new DiscoverTab_PO();

	public void discovertabopenhouses(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		wait = new WebDriverWait(driver, 20);

		// Delete all saved search & Save a new one
		cf.deleteAllSAvedSearch(driver);
		cf.searchMapSRP(pr.searchName, driver);
		cf.clearAllFilters(driver);
		cf.saveSearch(driver);

		// Getting search name from search Bar
		pr.searchName = driver.findElement(searchBarSRP).getText();

		// navigation to Discover tab
		wait.until(ExpectedConditions.presenceOfElementLocated(navigatingDiscoverTab));
		driver.findElement(navigatingDiscoverTab).click();

		// Verifying the Open houses section with items
		try {
			cf.scrollToText("Open Houses", driver);
			cf.scrollToText("Advice", driver);
			Assert.assertEquals(driver.findElement(openHouseItemAddressState).getText().split(",")[0],
					pr.searchName.split(",")[0],
					"Location of the Open houses does not macth with Saved search Locaiton");
			System.out.println("Open houses are visible for the Recent Saved Search..!");
		} catch (Exception e) {
			System.out.println("No Open house found for the Recent Saved search");
		}
	}

	public void totalOpenHouseInMenu(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(openHouseTittleInMenu));
		System.out.println(driver.findElement(openHouseTittleInMenu).getText());
		driver.findElement(viewOpenHouseFromMenu).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(searchingDialouge));
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultInSRP));
		Assert.assertEquals(driver.findElement(searchResultInSRP).getText().split(",")[0], pr.searchName.split(",")[0],
				"Wrong search triggered..!");
		wait.until(ExpectedConditions.visibilityOfElementLocated(openHouseHeaderText));
		if (driver.findElement(appliedFilterCount).getText().equals("1"))
			System.out.println("Open house filter is auto applied from Open house section search..!");
		else
			System.out.println("Open house filter is not auto applied..!");
		Assert.assertEquals(driver.findElement(saveSearchText).getText(), "SAVED", "Search is not saved..!");
		System.out.println("Saved search status does not changed..!");
		Thread.sleep(5000);
	}

	public void swipeViewOpenHosueVerificaion(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {

		String ListSRPTime = driver.findElement(openTimeDiscoverTile).getText();
		// Navigate to Swipe Tab
		driver.findElement(navigateSwipetab).click();
		String SwipeSRPTime = driver.findElement(openTimeSwipeSRP).getText();
		Assert.assertEquals(SwipeSRPTime, ListSRPTime, "Open house time does not match..!");
		System.out.println(driver.findElement(openHouseHeaderText).getText() + " House Tag available in Swipe SRP..!");
		System.out.println("Open House details in Quick View: " + driver.findElement(openTimeSwipeSRP).getText());
		cf.deleteAllSAvedSearch(driver);
	}

	public void saveSearchNotAffected(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {

		// Delete all saved search & Save a new one
		// cf.deleteAllSAvedSearch(driver);

		cf.saveSearch(driver);

		// Checking the status of the saved search.
		Assert.assertEquals(driver.findElement(saveSearchText).getText(), "SAVED", "Search is not saved..!");
		opn.turnOnOpenHouseFilter(driver);
		Assert.assertEquals(driver.findElement(saveSearchText).getText(), "SAVED",
				"Search state is changed after applying open house filter...!");
		System.out.println("Search state is not changed after applying open house filter..!");

	}

	public void verifyTagTimeInDiscoverPage(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {

		// navigation to Discover tab
		dp.navigateDiscoverTab(driver);

		// Check the Tag & Time
		try {
			cf.scrollToText("Open Houses", driver);
			cf.scrollToText("Advice", driver);
			System.out.println("Open houses are visible for the Recent Saved Search..!");
		} catch (Exception e) {
			System.out.println("No Open house found for the Recent Saved search");
		}
		String verifyOpenTag = driver.findElement(openTextInTile).getText();
		if (verifyOpenTag.equals("OPEN")) {
			System.out.println("Open Tag present in the Discover page Tiles..");
		}

		String verifyTime = driver.findElement(openTimeDiscoverTile).getText();
		System.out.println(
				"Open house time for " + driver.findElement(openHouseItemAddress).getText() + " is: " + verifyTime);

	}

	public void matchDataInPDP(AppiumDriver<MobileElement> driver) throws MalformedURLException, InterruptedException {
		String addressDiscover[] = driver.findElement(openHouseItemAddress).getText().split(" ");
		String srpDate = driver.findElement(openTimeDiscoverTile).getText().toLowerCase();
		String[] dateSRP = srpDate.split(",");
		driver.findElement(openTimeDiscoverTile).click();
		Thread.sleep(10000);
		String pdpDate = driver.findElement(openHouseHeaderTime).getText().toLowerCase();
		String[] datePDP = pdpDate.split(",");
		Assert.assertEquals(dateSRP[0], datePDP[0], "Open House DATE is not matching");
		String[] pdpAddress = driver.findElement(openHousePDPAddress).getText().split(" ");
		System.out.println(pdpAddress);
		System.out.println("PDP Address is: " + driver.findElement(openHousePDPAddress).getText());
		Assert.assertEquals(addressDiscover[0], addressDiscover[0], "PDP is opened but address not matching..!");
	}

	public void noOpenHouseUnauthenticatedUser(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		cf.deleteAllSAvedSearch(driver);
		cf.searchMapSRP("Atlanta,GA", driver);
		cf.clearAllFilters(driver);
		cf.saveSearch(driver);

		// navigation to Discover tab
		dp.navigateDiscoverTab(driver);

		// Verifying the Open houses section with items
		try {
			cf.scrollToText("Open Houses", driver);
			cf.scrollToText("Advice", driver);
			System.out.println("Open houses are visible for the Recent Saved Search..!");
		} catch (Exception e) {
			System.out.println("No Open house found for the Recent Saved search");
		}

		// Log out from the app
		driver.findElement(navigatingMeTab).click();
		driver.findElement(navigatingMeTab).click();
		cf.scrollToText("Sign Out", driver);
		driver.findElement(signOutText).click();
		driver.findElement(signOutOkBtn).click();
		Thread.sleep(5000);

		// Navigate to Discover tab to check open house section
		wait.until(ExpectedConditions.presenceOfElementLocated(navigatingDiscoverTab));
		driver.findElement(navigatingDiscoverTab).click();

		try {
			cf.scrollToText("Open Houses", driver);
			System.out.println("Open houses are visible for the Recent Saved Search..! THIS TEST CASE IS FAILED");
		} catch (Exception e) {
			System.out.println("No Open house section found as user is logged out");
		}
	}

	public void favOpenHousePDP(AppiumDriver<MobileElement> driver) throws MalformedURLException, InterruptedException {
		driver.findElement(favIconPDP).click();
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(favToast));
		System.out.println("Property has been favorited..!");
		driver.findElement(pdpBackButton).click();
		Thread.sleep(2000);
		dp.navigateDiscoverTab(driver);

		// cf.scrollToText("Advice", driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(heartIcon));
		if (driver.findElement(heartIcon).isEnabled())
			System.out.println("Heart Icon Present in the discover tab tiles..!");
		else
			System.out.println("Property favorited but Heart icon not appeared in the Discover page tiles..!");

	}

	public void unFavOpenHouse(AppiumDriver<MobileElement> driver) throws MalformedURLException, InterruptedException {
		driver.findElement(navigateFavouriteTab).click();
		Thread.sleep(4000);
		driver.findElement(favButtonInFav).click();
		Thread.sleep(5000);
		driver.findElement(navigatingDiscoverTab).click();
		try {
			driver.findElement(heartIcon).isEnabled();
			System.out.println("Property is not unfavorited properly..!!");
		} catch (Exception e) {
			System.out.println("Property is unfavorited properly from Disocver tiles..!!");
		}

	}

	public void openHouseAfterChangeSavedSearch(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		String addressDiscoverAfter = null;
		// driver.findElement(navigatingDiscoverTab).click();
		cf.scrollToText("Advice", driver);
		String addressDiscoverBefore = driver.findElement(openHouseItemAddress).getText();
		cf.editSavedSearchTab(driver);
		cf.selectfilterBedBath(driver);
		driver.findElement(navigatingDiscoverTab).click();
		cf.scrollToText("Advice", driver);
		try {
			addressDiscoverAfter = driver.findElement(openHouseItemAddress).getText();
		} catch (Exception e) {
			System.out.println("No Open House available in the applied filter..!");
			throw new RuntimeException();
		}
		System.out.println("Previous property in the tiles was: " + addressDiscoverBefore);
		System.out.println("Now the address has been showing as: " + addressDiscoverAfter);
		if (addressDiscoverAfter.equals(addressDiscoverBefore))
			System.out.println("Saved Search updated but first property is not changed in the list..!");
		else
			System.out.println("Open house list has been updated..!");

	}

	public void newTagInQuickSRP(AppiumDriver<MobileElement> driver) throws InterruptedException {
		cf.fromClusterToPinView(driver);
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(newTagInSRPView));
			System.out.println("New Tag Available in Quick View..!");
			String newTag = driver.findElement(newTagInSRPView).getText();
			if (newTag.length() < 4)
				System.out.println("Only new string is available..!");
			else {
				String time = newTag.substring(3, newTag.length());
				if (time.contains("M")) {
					time = time.replace("M", "MINUTE(S)");
					System.out.println("Property has been onboarded" + time);
				} else if (time.contains("H")) {
					time = time.replace("H", "HOUR(S)");
					System.out.println("Property has been onboarded" + time);
				} else {
					time = time.replace("D", "DAY(S)");
					System.out.println("Property has been onboarded" + time);
				}
			}
		} catch (Exception e1) {
			System.out.println("This property is onboarded beyond 7 Days..!");
		}

	}

	public void newTagInListSRP(AppiumDriver<MobileElement> driver) throws InterruptedException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(newTagInSRPView));
			System.out.println("New Tag Available in List View..!");
			String newTag = driver.findElement(newTagInSRPView).getText();
			if (newTag.length() < 4)
				System.out.println("Only new string is available..!");
			else {
				String time = newTag.substring(3, newTag.length());
				if (time.contains("M")) {
					time = time.replace("M", "MINUTE(S)");
					System.out.println("Property has been onboarded" + time);
				} else if (time.contains("H")) {
					time = time.replace("H", "HOUR(S)");
					System.out.println("Property has been onboarded" + time);
				} else {
					time = time.replace("D", "DAY(S)");
					System.out.println("Property has been onboarded" + time);
				}
			}
		} catch (Exception e1) {
			System.out.println(e1);
			System.out.println("This property is onboarded beyond 7 Days..!");
		}

	}

	public void newPropertiesWithOpenHouse(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 10);
		opn.lessSevenDaysFilterWithOpenHouse(driver);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(onboarding_alertTitle));
			System.out.println("No open house properties available in search area which are onboarded withing 7 Days");
		} catch (Exception e) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(searchingDialouge));
			newTagInQuickSRP(driver);
			driver.findElement(srpListBtn).click();
			Thread.sleep(2000);
			newTagInListSRP(driver);

		}
	}

//public void myOpenHouseInNoNetwork(AppiumDriver<MobileElement> driver) throws InterruptedException {
//		try
//		{
//			((AndroidDriver<MobileElement>) driver).setConnection(Connection.AIRPLANE);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			System.out.println("it has come out of Airplane Mode");
//		}
//		driver.findElement(onboarding_RegnMeBtn).click();
//		Thread.sleep(2000);
//		driver.findElement(openHouseInMe).click();
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		String errorNoNetwork = driver.findElement(errorText).getText();
//		Assert.assertEquals(errorNoNetwork, "An error has occurred, please try again later.",
//				"Test Case failed due to network issue..!");
//		System.out.println(errorNoNetwork);
//		try
//		{
//		((AndroidDriver<MobileElement>) driver).setConnection(Connection.ALL);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			System.out.println("it has come out of Airplane Mode");
//		}
//
//	}
}