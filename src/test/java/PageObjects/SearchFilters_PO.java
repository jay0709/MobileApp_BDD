/**
 * 
 */
package PageObjects;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.CommonFunctions_OR;
import ObjectRepository.PropertDetailsPage_OR;
import ObjectRepository.SearchFilters_OR;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author chakraja
 *
 */
public class SearchFilters_PO extends desiredCapabilities
		implements SearchFilters_OR, PropertDetailsPage_OR, CommonFunctions_OR {
	AppiumDriver<MobileElement> driver;
	WebElement element;
	WebDriverWait wait;
	PropertyData pr = new PropertyData();
	PropertDetailsPage_PO pdp = new PropertDetailsPage_PO();
	commonFunctions cf = new commonFunctions();

	public void selectAndApplyFilter(AppiumDriver<MobileElement> driver)
			throws InterruptedException, MalformedURLException {
		wait = new WebDriverWait(driver, 20);
		driver.findElement(filtersTab).click();
		wait.until(ExpectedConditions.elementToBeClickable(applyFilterButton));
		driver.findElement(fourBedFilter).click();
		cf.scrollToText("Baths", driver);
		// cf.verticalScrollUpwards(driver);
		driver.findElement(fourBathFilter).click();
		cf.verticalScrollUpwards(driver);
		driver.findElement(priceRangePicker).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(secondWheelSelector));
		for (int j = 0; j < 12; j++) {
			driver.findElement(secondWheelSelector).click();
		}
		for (int i = 0; i < 5; i++) {
			driver.findElement(firstWheelSelector).click();
		}
		driver.findElement(saveButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(applyFilterButton));
		driver.findElement(applyFilterButton).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(cf.searchingDialouge));
	}

	public void validateFiltersApplied(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(cf.searchingDialouge));
		pr.propertyPriceList = pdp.getProeprtyPriceFromList(driver).replace(",", "");
		pr.propertyPriceList = pr.propertyPriceList.replace("$", "");
		System.out.println(pr.propertyPriceList);
		element = driver.findElement(listBedBathSqft);
		String propertyDetails[] = cf.countBedBathSqft(element.getText());
		pr.filterListBeds = Integer.parseInt(propertyDetails[0].replaceAll(" Beds", ""));
		pr.filterListBaths = Integer.parseInt(propertyDetails[1].replaceAll(" Baths", ""));
		if (pr.filterListBeds >= 5 && pr.filterListBaths >= 4 && Integer.parseInt(pr.propertyPriceList) >= 250000
				&& Integer.parseInt(pr.propertyPriceList) < 800000) {
			System.out.println("Bed count is: " + pr.filterListBeds);
			System.out.println("Bath count is: " + pr.filterListBaths);
			System.out.println("Price of the property is :" + pr.propertyPriceList);
		}
	}

	public String getProeprtyPriceFromList(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		wait = new WebDriverWait(driver, 20);
		driver.findElement(listSRPTab).click();
		cf.verticalScrollUpwards(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(favIconList));
		pr.propertyPriceList = driver.findElement(priceInList).getText();
		return pr.propertyPriceList;
	}
}