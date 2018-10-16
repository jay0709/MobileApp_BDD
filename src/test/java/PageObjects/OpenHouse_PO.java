package PageObjects;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.CommonFunctions_OR;
import ObjectRepository.OpenHouse_OR;
import ObjectRepository.Registration_OR;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class OpenHouse_PO extends desiredCapabilities implements OpenHouse_OR, Registration_OR, CommonFunctions_OR {

	AppiumDriver<MobileElement> driver;
	WebElement element;
	WebDriverWait wait;
	commonFunctions cf = new commonFunctions();
	PropertyData pr = new PropertyData();

	public void turnOnOpenHouseFilter(AppiumDriver<MobileElement> driver)
			throws InterruptedException, MalformedURLException {
		driver.findElement(filtersTab).click();
		Thread.sleep(2000);
		driver.findElement(filtersClearAll).click();
		cf.scrollToText("Days on Owners.com", driver);
		cf.verticalScrollUpwards(driver);
		if (driver.findElement(openHouseToggle).getText().equals("OFF")) {
			try {
				driver.findElement(openHouseToggle).click();
				Thread.sleep(3000);
				Assert.assertEquals(driver.findElement(openHouseToggle).getText(), "ON",
						"Open house toggle is turned on..!");
			} catch (Exception e) {
				driver.findElement(openHouseToggle).click();
				Thread.sleep(3000);
				Assert.assertEquals(driver.findElement(openHouseToggle).getText(), "ON",
						"Open house toggle is turned on..!");
			}
		} else
			System.out.println("Open house filter already turned on..");
		driver.findElement(applyFilterButton).click();
	}

	public void openHouseDateVerify(AppiumDriver<MobileElement> driver)
			throws InterruptedException, MalformedURLException {
		Thread.sleep(4000);
		driver.findElement(srpListBtn).click();
		cf.verticalScrollUpwards(driver);
		Thread.sleep(2000);
		String srpDate = driver.findElement(openTimeInSRP).getText().toLowerCase();
		String[] dateSRP = srpDate.split(",");
		System.out.println("Open House details in List SRP View: " + driver.findElement(openTimeInSRP).getText());

		driver.findElement(openTimeInSRP).click();
		Thread.sleep(10000);
		// cf.verticalScrollUpwards(driver);
		String pdpDate = driver.findElement(openHouseHeaderTime).getText().toLowerCase();
		String[] datePDP = pdpDate.split(",");
		Assert.assertEquals(dateSRP[0], datePDP[0], "Open House DATE is not matching");
	}

	public void openHouseTimeVerify(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		String pdpTime = driver.findElement(openHouseHeaderTime).getText().toLowerCase();
		String timePDP = pdpTime.substring(pdpTime.indexOf(",") + 2, pdpTime.indexOf("-")).trim().toLowerCase();
		cf.scrollToText("SAVE TO OPEN HOUSE SCHEDULE", driver);
		String sectionTime = driver.findElement(openHouseTime).getText().toLowerCase();
		String[] timeSection = sectionTime.split("-");
		Assert.assertEquals(timePDP, timeSection[0], "Open House Time is not matching");
		System.out.println("** Open house date is: " + driver.findElement(openHouseDate).getText().toUpperCase());
		System.out.println("** Open house time is: " + sectionTime.toUpperCase());
	}

	public void noOfOpenHouseInSavedSearch(AppiumDriver<MobileElement> driver) {
		String openHouse = driver.findElement(openHouseTittleInMenu).getText();
		System.out.println(openHouse);
	}

	public void viewOpenHouse(AppiumDriver<MobileElement> driver) throws InterruptedException {
		driver.findElement(viewOpenHouseFromMenu).click();
		Thread.sleep(5000);
	}

	public void saveOpenHouse(AppiumDriver<MobileElement> driver) throws MalformedURLException, InterruptedException {
		cf.scrollToText("SAVE TO OPEN HOUSE SCHEDULE", driver);
		driver.findElement(saveOpenHousePDP).click();
		System.out.println("Clicked on Save Open House..!");
		wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(onboarding_SignInBtn));
			// Enter email ID
			driver.findElement(onboarding_RegnEmail).click();
			driver.findElement(onboarding_RegnEmail).sendKeys(pr.email1);
			System.out.println("Entered the email ID: " + pr.email1);

			// Enter PWD
			driver.hideKeyboard();
			driver.findElement(onboarding_RegnPassword).sendKeys(pr.password);
			System.out.println("Entered the password: " + pr.password);

			// Click on SignIn Button
			driver.hideKeyboard();
			driver.findElement(onboarding_SignInBtn).click();
			System.out.println("Clicked on Sign In Button");

			wait.until(ExpectedConditions.visibilityOfElementLocated(saveOpenHouseIcon));
			System.out.println(driver.findElement(savedOpenHouse).getText().toUpperCase());
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(saveOpenHouseIcon));
			Assert.assertEquals(driver.findElement(savedOpenHouse).getText(), "Saved to your Open Houses Schedule.",
					"Open house not saved");
			// System.out.println(driver.findElement(savedOpenHouse).getText().toUpperCase());
		}
	}

	public void viewSavedOpenHouse(AppiumDriver<MobileElement> driver) {
		wait = new WebDriverWait(driver, 10);
		String savedOpenHouseText = driver.findElement(savedOpenHouse).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(savedOpenHouse));
		wait.until(ExpectedConditions.visibilityOfElementLocated(saveOpenHouseIcon));
		Assert.assertEquals(savedOpenHouseText, "Saved to your Open Houses Schedule.", "Open house is not saved..");
		System.out.println("Open House icon is Visible..!");
		driver.findElement(savedOpenHouse).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(openHouseTabInMenu));
		driver.findElement(openHouseTabInMenu).click();
		System.out.println("User landed in My Open Houses section..!");
	}

	public void pinView(AppiumDriver<MobileElement> driver) throws MalformedURLException, InterruptedException {
		cf.fromClusterToPinView(driver);
	}

	public void lessSevenDaysFilterWithOpenHouse(AppiumDriver<MobileElement> driver)
			throws InterruptedException, MalformedURLException {
		driver.findElement(filtersTab).click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(filtersClearAll));
		driver.findElement(filtersClearAll).click();
		cf.scrollToText("Show Open Houses Only", driver);
		cf.verticalScrollUpwards(driver);
		System.out.println(driver.findElement(openHouseToggle).getText());
		if (driver.findElement(openHouseToggle).getText().equals("OFF")) {
			driver.findElement(openHouseToggle).click();
			Thread.sleep(3000);
			Assert.assertEquals(driver.findElement(openHouseToggle).getText(), "ON",
					"Open house toggle is turned on..!");
		} else
			System.out.println("Open house filter already turned on..");

		cf.scrollToText("Any", driver);
		driver.findElement(DOM).click();
		driver.findElement(lessSevenDaysDOM).click();
		driver.findElement(applyFilterButton).click();
	}

	public void noOpenHouseInSearch(AppiumDriver<MobileElement> driver)
			throws InterruptedException, MalformedURLException {
		wait = new WebDriverWait(driver, 10);
		cf.relaunchApp(driver);
		cf.searchMapSRP("Denver,IL", driver);
		turnOnOpenHouseFilter(driver);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(noResultErrorTextInSRP));
			System.out.println("Filter applied is : " + driver.findElement(noResultErrorTextInSRP).getText());
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(noResultErrorMessage));
			System.out.println(driver.findElement(noResultErrorHeader).getText());
			System.out.println(
					driver.findElement(noResultErrorDescription).getText() + driver.findElement(editSearch).getText());
			System.out.println("No open house found.. Error Message shown in SRP..");
		}
		cf.clearAllFilters(driver);

	}

	public void menuAddressVerify(AppiumDriver<MobileElement> driver) throws InterruptedException {
		wait = new WebDriverWait(driver, 10);

		// Getting the address of the open house
		String time = driver.findElement(myOpenHouseTime).getText();
		System.out.println("Open house time is: " + time);
		String addressMyOpenHouse = driver.findElement(addressLineOne).getText() + ", "
				+ driver.findElement(addressLineTwo).getText();
		driver.findElement(myOpenHouseMenu).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(menuAddress));

		// Verifying the menu address
		Assert.assertEquals(addressMyOpenHouse, driver.findElement(menuAddress).getText(),
				"Open house addess Mismatch..!");
		System.out.println("Open house address verified as: " + addressMyOpenHouse);
	}

	public void viewPDPFromOpenHouse(AppiumDriver<MobileElement> driver)
			throws InterruptedException, MalformedURLException {

		// Navigation to PDP
		driver.findElement(menuPropertydetails).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(openHouseHeaderTime));
		if (driver.findElement(favIconInPDP).isSelected()) {
			driver.findElement(favIconInPDP).click();
		}
		System.out.println("User is navigated to PDP from Open house..");
	}

	public void scheduleTourOpenHouse(AppiumDriver<MobileElement> driver) throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		// clickMenuInOpenHouse(driver);

		// navigation to Request A Tour section
		driver.findElement(menuRequestTour).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(rqstTourHeader));
		Assert.assertEquals(driver.findElement(rqstTourHeader).getText(), "Request a Tour",
				"Request a Tour section is not opened");
		System.out.println("User is naviagted to Request a Tour section..!");
		driver.navigate().back();
	}

	public void clickMenuInOpenHouse(AppiumDriver<MobileElement> driver) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(myOpenHouseMenu));
		driver.findElement(myOpenHouseMenu).click();
	}

	public void getDirectionsFromOpenHosuse(AppiumDriver<MobileElement> driver) throws InterruptedException {
		wait = new WebDriverWait(driver, 15);
		clickMenuInOpenHouse(driver);

		// Navigation to Maps
		driver.findElement(menuGetDirections).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(mapNavigation));
		System.out.println("User is navigated to Maps..!");
		driver.navigate().back();
	}

	public void navigateToCreateEvent(AppiumDriver<MobileElement> driver) throws InterruptedException {
		String addressMyOpenHouse = driver.findElement(addressLineOne).getText() + ", "
				+ driver.findElement(addressLineTwo).getText();
		System.out.println(addressMyOpenHouse);
		// driver.findElement(myOpenHouseMenu).click();
		clickMenuInOpenHouse(driver);
		driver.findElement(menuAddCalenderEvent).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(calenderNaviagtion));
		Assert.assertEquals(driver.findElement(calenderNaviagtion).getText(), "Open House",
				"User is not navigated to Calendar");
		System.out.println("Open house Date Verified as: " + driver.findElement(calendarStartDate).getText());
		System.out.println("Open house Start Time Verified as: " + driver.findElement(calendarStartTime).getText());
		driver.navigate().back();
		driver.navigate().back();

	}

	public void deleteOpenHouse(AppiumDriver<MobileElement> driver) throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		clickMenuInOpenHouse(driver);

		// Delete the Open house
		driver.findElement(menuDeleteOpenHouse).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(deleteDialouge));
		Assert.assertEquals(driver.findElement(deleteDialouge).getText(), "Delete this Open House?",
				"Confirmation dialouge is not visible..!");
		System.out.println("Confirmation before delete --> " + driver.findElement(deleteDialouge).getText());
		driver.findElement(deleteConfirmationOK).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(noSavedOpenHouse));
		Assert.assertEquals(driver.findElement(noSavedOpenHouse).getText(), "No Saved Open Houses",
				"All open house not cleared");
		System.out.println("No saved open house available..!");
	}

}
