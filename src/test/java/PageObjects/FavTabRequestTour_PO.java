package PageObjects;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Driver.PropertyData;
import ObjectRepository.FavouriteProperty_OR;
import ObjectRepository.PropertDetailsPage_OR;
import ObjectRepository.Registration_OR;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class FavTabRequestTour_PO  implements FavouriteProperty_OR , Registration_OR ,PropertDetailsPage_OR {
	AppiumDriver<MobileElement> driver;
	WebElement element;
	WebDriverWait wait;
	commonFunctions cf = new commonFunctions();
	PropertyData pr = new PropertyData();
	FavouriteProperty_PO ft = new FavouriteProperty_PO();
	String AddressLine1;
	String AddressLine2;
	String pdpAddress;


	public String saveFSBOListing(AppiumDriver<MobileElement> driver) throws InterruptedException {
		cf.openFSBOProperty(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdpfavIcon));
		String pdpPrice = driver.findElement(pdpPriceView).getText();
		driver.findElement(pdpfavIcon).click();
		return pdpPrice;
	}

	public void checkSchduleTourFSBO(AppiumDriver<MobileElement> driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String pdpPrice = saveFSBOListing(driver);
		Thread.sleep(3000);
		driver.findElement(favToastMessage).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(favPropertyPrice));
		Assert.assertEquals(pdpPrice, driver.findElement(favPropertyPrice).getText(),
				"Property Price does not match..!!");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(schduleTourButton));
			System.out.println("Request Tour Button present for FSBO property. TEST CASE FAILED..!!");
		} catch (Exception ex) {
			System.out.println("Request Tour Button not present for FSBO property. TEST CASE PASSED..!!");
		}
	}

	public void checkSchduleTourMLS(AppiumDriver<MobileElement> driver)
			throws InterruptedException, MalformedURLException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(clickFavouriteTab).click();
		Thread.sleep(5000);
		 pdpAddress = driver.findElement(favPropertyAddress).getText();
		 AddressLine1 = pdpAddress.substring(0, pdpAddress.indexOf(",")).trim();
		 AddressLine2 = pdpAddress.substring(pdpAddress.indexOf(",") + 1, pdpAddress.length()).trim();
		wait.until(ExpectedConditions.visibilityOfElementLocated(schduleTourButton));
		System.out.println("Request Tour button present in the Fav Tab for property..!!");
		driver.findElement(schduleTourButton).click();
	       wait.until(ExpectedConditions.visibilityOfElementLocated(requestTourPageAddressFirstLine));
			String requestTourHeader = driver.findElement(requestTourPageHader).getText();
			Assert.assertEquals(requestTourHeader, "Request a Tour", "Header text does not macth...!!");
			try {
				String pdpAddressLine1 = driver.findElement(requestTourPageAddressFirstLine).getText().trim();
				String pdpAddressLine2 = driver.findElement(requestTourPageAddressSecondLine).getText().trim();
				Assert.assertEquals(AddressLine1, pdpAddressLine1, "Address does not match..!!");
				Assert.assertEquals(AddressLine2, pdpAddressLine2, "Address does not match..!!");
				System.out.println(" Address matched as: " + pdpAddress);
			} catch (Exception e) {
				System.out.println("Address does not match..Moving ahead!!");
			}
			try {
				String asap = driver.findElement(requestASAPTile).getText();
				Assert.assertEquals(asap, "ASAP", "ASAP option verified..!!");
			} catch (Exception ex) {
				try {
					String month = driver.findElement(requestTourMonth).getText();
					String date = driver.findElement(requestTourDayOfMonth).getText();
					String day = driver.findElement(requestTourDayOfWeek).getText();
					System.out.println("First tour date is: " + day + " " + date + " " + month);
				} catch (Exception e) {

				}
			}
			String email = driver.findElement(requestTourEmailUser).getText();
			Assert.assertEquals(email.toLowerCase(), pr.email1.toLowerCase(),
					"Email ID does not match with logged in user");
			System.out.println("Email id verified as: " + email);
			String comments = driver.findElement(requestTourComment).getText();
			System.out.println("Pre-filled commment text: " + comments);		

	}
	


	public void checkAvailableTimes(AppiumDriver<MobileElement> driver)
			throws InterruptedException, MalformedURLException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(requestASAPTile));
			System.out.println("ASAP tile available.. clicking on the next slot..");
			driver.findElement(requestTourDayOfMonth).click();
			System.out.println("Clicked on the tour date slot...");
			wait.until(ExpectedConditions.visibilityOfElementLocated(requestTourTime));
			System.out.println("Time slots are visible now..!");
		} catch (Exception e) {
			driver.findElement(requestTourDayOfMonth).click();
			System.out.println("Clicked on the tour date slot...");
			wait.until(ExpectedConditions.visibilityOfElementLocated(requestTourTime));
			System.out.println("Time slots are visible now..!");
		}
		String month = driver.findElement(requestTourMonth).getText();
		String date = driver.findElement(requestTourDayOfMonth).getText();
		String day = driver.findElement(requestTourDayOfWeek).getText();
		String time = driver.findElement(requestTourTime).getText();
		System.out.println("First tour date is: " + day + " " + date + " " + month + " with  first time slot: " + time);

	}

	public void checkUserDetails(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		driver.findElement(requestTourEmailUser).click();
		Thread.sleep(2000);
		System.out.println("First Name verified as: " + driver.findElement(requestTourFirstName).getText());
		System.out.println("Last Name verified as: " + driver.findElement(requestTourLastName).getText());
		firstNameValidation(driver);
		lastNameValidation(driver);
		cf.scrollToText("Additional comments(optional)", driver);
		emailFieldValidation(driver);
		System.out.println(
				"Email ID verified as: " + driver.findElement(requestTourEmailID).getText().replaceAll("-", ""));
		System.out.println("Consent Text verified as: " + driver.findElement(requestTourConsent).getText());
		driver.findElement(requetsTourPageBackButton).click();
		//ft.checkNoSavedListingsText(driver);
	}

	public void emailFieldValidation(AppiumDriver<MobileElement> driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(requestTourEmailID).clear();
		driver.hideKeyboard();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(requestTourInvalidInput));
		System.out.println("Email is blank of Invalid --> Validated");
		driver.findElement(requestTourEmailID).sendKeys("testaccount@gmail");
		driver.hideKeyboard();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(requestTourInvalidInput));
		System.out.println("Invalid email id --> Validated");
	}

	public void firstNameValidation(AppiumDriver<MobileElement> driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(requestTourFirstName).clear();
		driver.hideKeyboard();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(requestTourInvalidInput));
		System.out.println("First Name is blank of Invalid --> Validated");
		driver.findElement(requestTourFirstName).sendKeys("Test123");
		driver.hideKeyboard();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(requestTourInvalidInput));
		System.out.println("Invalid first name  --> Validated");
	}

	public void lastNameValidation(AppiumDriver<MobileElement> driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(requestTourLastName).clear();
		driver.hideKeyboard();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(requestTourInvalidInput));
		System.out.println("Last Name is blank of Invalid --> Validated");
		driver.findElement(requestTourLastName).sendKeys("Last123");
		driver.hideKeyboard();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(requestTourInvalidInput));
		System.out.println("Invalid last name  --> Validated");
	}
}
