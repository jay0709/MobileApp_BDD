/**
 * 
 */
package PageObjects;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.CommonFunctions_OR;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * @author isaacindeevervemula
 *
 */
public class commonFunctions extends desiredCapabilities implements CommonFunctions_OR {
	PropertyData prop = new PropertyData();
	DiscoverTab_PO dt = new DiscoverTab_PO();

	void startAppium() {

	}

	void stopAppium() {

	}

	public static String randomAlphaNumeric(int count) {
		final String token = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder builder = new StringBuilder();
		builder.append("test_");
		while (count-- != 0) {
			int character = (int) (Math.random() * token.length());
			builder.append(token.charAt(character));
		}
		return builder.toString();
	}

	public void takeScreenshot(String filename, AppiumDriver<MobileElement> driver)
			throws IOException, InterruptedException {
		File image1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(image1, new File(" " + filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] countBedBathSqft(String idText) {
		String elementId = idText;
		String[] splitValue = elementId.split(" • ");
		return splitValue;

	}

	@SuppressWarnings("unchecked")
	public void scrollToText(String text, AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		Thread.sleep(4000);

		if (prop.platformName.equalsIgnoreCase("Android")) {
			((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ text + "\").instance(0))");

		} else {
			// scroll to item in ios
			JavascriptExecutor js = (JavascriptExecutor) driver;
			@SuppressWarnings("rawtypes")
			HashMap scrollObject = new HashMap<>();
			scrollObject.put("predicateString", "value == '" + text + "'");
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);

		}

	}

	@SuppressWarnings("rawtypes")
	public void horizontalswipetowardsright(AppiumDriver<MobileElement> driver, double percentage) {
		// double percentage = 20 ;
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		int y = (int) (height * percentage);
		int startx = (int) (width * 0.20);
		int endx = (int) (width * 0.75);
		new TouchAction(driver).longPress(PointOption.point(startx, y))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(endx, y))
				.release().perform();
	}

	@SuppressWarnings("rawtypes")
	public void horizontalSwipeTowardslLeft(AppiumDriver<MobileElement> driver, double percentage) {
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		int y = (int) (height * percentage);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.20);
		new TouchAction(driver).longPress(PointOption.point(startx, y))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(endx, y))
				.release().perform();
	}

	@SuppressWarnings("rawtypes")
	public void verticalScrollUpwards(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		Dimension size;
		size = driver.manage().window().getSize();
		int xCoOrdinate = (int) (size.width * 0.5);
		int startY = (int) (size.height * 0.78);
		int endY = (int) (size.height * 0.30);
		new TouchAction(driver).press(PointOption.point(xCoOrdinate, startY)).waitAction()
				.moveTo(PointOption.point(xCoOrdinate, endY)).release().perform();
	}

	public void verticalScrollDownwrds(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		Dimension size;
		size = driver.manage().window().getSize();
		int xCoOrdinate = (int) (size.width * 0.5);
		int endY = (int) (size.height * 0.78);
		int startY = (int) (size.height * 0.30);
		new TouchAction(driver).press(PointOption.point(xCoOrdinate, startY)).waitAction()
				.moveTo(PointOption.point(xCoOrdinate, endY)).release().perform();
	}

	@SuppressWarnings("deprecation")
	public void searchMapSRP(String searchString, AppiumDriver<MobileElement> driver) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(navigatingSearchTab));
		driver.findElement(navigatingSearchTab).click();
		driver.findElement(clickSearchBar).click();
		driver.findElement(typeInsearchBar).sendKeys(searchString);
		wait.until(ExpectedConditions.textToBePresentInElement(searchResultStateName, searchString.split(",")[1]));
		driver.findElement(searchResultStateName).click();
		try {
			// Thread.sleep(20000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(srpMapBtn));
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
		wait.until(ExpectedConditions.elementToBeClickable(srpMapBtn));
		driver.findElement(srpMapBtn).click();
	}

	public void allowLocationAccess(AppiumDriver<MobileElement> driver) {

		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(popUpMessage));
			driver.findElement(allowPermission).click();
		} catch (Exception e) {
			System.out.println("Skip button not present...moving ahead..");
		}
	}

	public void relaunchApp(AppiumDriver<MobileElement> driver) {
		wait = new WebDriverWait(driver, 15);
		driver.closeApp();
		driver.launchApp();
		try {
			driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
		} catch (Exception e) {
			System.out.println("App update dialouge not present.. Moving ahead...");
		}
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(scheduleTourButton));
			driver.findElement(doNotAsk).click();
			Thread.sleep(2000);
			driver.findElement(cancelButton).click();
		} catch (Exception e1) {
			System.out.println("Schedule Tour dialouge not present.. Moving ahead...");
		}

	}

	public void clearAllFilters(AppiumDriver<MobileElement> driver) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(navigatingSearchTab));
		driver.findElement(navigatingSearchTab).click();
		driver.findElement(filtersTab).click();
		driver.findElement(clearFiltersButton).click();
		driver.findElement(applyFilterButton).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(searchingDialouge));
		Thread.sleep(2000);
		driver.findElement(mapViewSRPClick).click();
	}

	public void deleteAllSAvedSearch(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		// relaunchApp(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(clickDiscoverTab));
		driver.findElement(clickDiscoverTab).click();
		System.out.println("Discover Tab clicked");
		try {
			scrollToText("Saved Searches", driver);
			while (driver.findElement(savedSearchStar).isEnabled()) {
				driver.findElement(savedSearchStar).click();
				driver.findElement(scheduleTourButton).click();

			}
		} catch (Exception e) {
			System.out.println("All saved search deleted..!");
		}
	}

	public void saveSearch(AppiumDriver<MobileElement> driver) throws InterruptedException {
		// Thread.sleep(4000);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(mapViewSRPClick));
		driver.findElement(mapViewSRPClick).click();
		wait.until(ExpectedConditions.elementToBeClickable(saveSearchText));
		driver.findElement(saveSearchText).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (driver.findElement(saveSearchText).getText().equals("SAVED"))
			System.out.println("Search is Saved..!");
		else
			driver.findElement(saveSearchText).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void fromClusterToPinView(AppiumDriver<MobileElement> driver) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dt.navigateSearchTab(driver);

		// wait.until(ExpectedConditions.visibilityOfElementLocated(clusterToPIN));
		// driver.findElement(By.xpath("//android.view.View[@content-desc='Google
		// Map']/android.view.View[2]")).click();
		try {
			driver.findElement(By.xpath("//*[@index='0']")).click();

		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("//*[@index='0']")).click();
			e.printStackTrace();

		}
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		try {
			if (driver.findElement(quickViewFavIcon).isEnabled()) {
				System.out.println("PIN VIEW ENABLED...");
			}
		} catch (Exception e) {
			System.out.println("Not clicked on the PIN");
			driver.findElement(By.xpath("*//android.view.View[@index='1']")).click();
			fromClusterToPinView(driver);
		}
	}

	public void captureLog(AppiumDriver<MobileElement> driver, String testName) throws Exception {
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		driver.executeScript("adb logcat OkHttp:D *:S | grep 'BUYER'", null);
		String logPath = "//Users//Jayabrata//Documents//workspace//LeadsLog//";
		System.out.println(driver.getSessionId() + ": Saving device log...");
		System.out.println(driver.getSessionId() + ": Saving device log - Done.");
	}

	public void editSavedSearchTab(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		driver.findElement(clickSearchBar).click();
		// scrollToText("Saved Searches", driver);
		Thread.sleep(3000);
		isKeyboardPresent(driver);
		driver.findElement(threeDottedMenuDiscoverTab).click();
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(editSavedSearch));
		driver.findElement(editSavedSearch).click();
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(searchingDialouge));
		driver.findElement(By.id("com.owners.buyer:id/property_filters_clear_button")).click();

	}

	public void selectfilterBedBath(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		scrollToText("Baths", driver);
		driver.findElement(fourBedFilter).click();
		driver.findElement(fourBathFilter).click();
		Thread.sleep(2000);
		driver.findElement(applyFilterButton).click();
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(searchingDialouge));
	}

	public void openFSBOProperty(AppiumDriver<MobileElement> driver) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(navigatingSearchTab));
		driver.findElement(navigatingSearchTab).click();
		driver.findElement(clickSearchBar).click();
		driver.findElement(typeInsearchBar).sendKeys("WMM");
		wait.until(ExpectedConditions.textToBePresentInElement(searchResultName, "WMM"));
		driver.findElement(searchResultName).click();
	}

	public boolean isElementPresent(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			Assert.assertTrue(driver.findElement(locatorKey).isDisplayed(), "Element is not present");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public void ElementClickUsingJavaScript(By locatorKey) {

		WebElement element = driver.findElement(locatorKey);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void SearchPropertyDirectly(String searchString, AppiumDriver<MobileElement> driver) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(navigatingSearchTab));
		driver.findElement(navigatingSearchTab).click();
		driver.findElement(clickSearchBar).click();
		driver.findElement(typeInsearchBar).sendKeys(searchString);
		wait.until(ExpectedConditions.textToBePresentInElement(searchResultName, searchString));
		driver.findElement(searchResultName).click();
		try {
			// Thread.sleep(20000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(srpMapBtn));
			System.out.println("Map button lacated");
		} catch (Exception e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(searchingDialouge));
	}

	public boolean DateFormatValidation(String value) {

		try {
			new SimpleDateFormat("dd mmm,yyyy").parse(value);
			System.out.println("Date format is matched");
			return true;
		} catch (ParseException e) {
			System.out.println("Date format is not matched");
			return false;
		}
	}

	public void ClearAllFilters() {
		driver.findElement(clearFiltersButton).click();
	}

	public void verifyingSortingDialogue() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(sortingDialogueMessage));
	}

	public int convertingPriceStringtoIntValue(String priceFromApp) {
		int propertyPriceInValue;
		priceFromApp = priceFromApp.replaceAll(",", "");
		priceFromApp = priceFromApp.replace("$", "");
		propertyPriceInValue = Integer.parseInt(priceFromApp);
		return propertyPriceInValue;
	}

	public void isKeyboardPresent(AppiumDriver<MobileElement> driver) {
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
		}
	}

}
