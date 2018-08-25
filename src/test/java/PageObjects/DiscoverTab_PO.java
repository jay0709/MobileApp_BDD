/**
 * 
 */
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Driver.desiredCapabilities;
import ObjectRepository.DiscoverTab_OR;
import ObjectRepository.FavouriteProperty_OR;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


/**
 * @author chakraja
 *
 */
public class DiscoverTab_PO extends desiredCapabilities implements DiscoverTab_OR,FavouriteProperty_OR{
	WebElement element;
	
	public void navigateDiscoverTab(AppiumDriver<MobileElement> driver) {
		wait.until(ExpectedConditions.elementToBeClickable(clickDiscoverTab));
		driver.findElement(clickDiscoverTab).click();
		System.out.println("Discover Tab clicked");
	}
	
	public void navigateSearchTab(AppiumDriver<MobileElement> driver){
		wait.until(ExpectedConditions.elementToBeClickable(navigatingSearchTab));
		driver.findElement(navigatingSearchTab).click();
		System.out.println("Search Tab clicked");
	}
	
	public void navigateFavouriteTab(AppiumDriver<MobileElement> driver) throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(clickFavouriteTab));
		driver.findElement(clickFavouriteTab).click();
		System.out.println("Favourite Tab clicked");
	}
	
	
	public void navigateContactUsTab(AppiumDriver<MobileElement> driver){
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
		System.out.println("The section here is"+element.getText());
        Assert.assertEquals(element.getText(), "Saved Searches", "No Saved searches are present");
		//wait.until(ExpectedConditions.presenceOfElementLocated(savedSearchName));
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
	
	public void recommendedPropertySection(AppiumDriver<MobileElement> driver)
	{
		
	}
}
