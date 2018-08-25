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

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.FavouriteProperty_OR;
import ObjectRepository.Registration_OR;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


/**
 * @author chakraja
 *
 */
public class FavouriteProperty_PO extends desiredCapabilities implements FavouriteProperty_OR , Registration_OR{
	WebElement element;
	PropertyData pr = new PropertyData();
	commonFunctions cf = new commonFunctions();
	PropertDetailsPage_PO pdp = new PropertDetailsPage_PO();

	public void favPropertyFromList(AppiumDriver<MobileElement> driver) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(favPropertyList).click();
		Thread.sleep(5000);
	}

	public String propertyAddressList(AppiumDriver<MobileElement> driver) {
		pr.propertyAddressList = driver.findElement(listPropertyAddress).getText();
		return pr.propertyAddressList;
	}
	
	public void checkNoSavedListingsText(AppiumDriver<MobileElement> driver) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(clickFavouriteTab).click();
		try {
			while (driver.findElement(favIcon).isEnabled()) {
				driver.findElement(favIcon).click();
				driver.findElement(onboarding_alertOKbtn).click();
			}
		} catch (Exception e) {
			System.out.println(driver.findElement(noFavProperties).getText() + " : No Fav properties Text Verified");
			System.out.println(driver.findElement(emptyMessage).getText() + " : Empty message text verified");
		}
		System.out.println("No favorites properties are present in the Fav Tab..!");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

    public void verifyPorpertyDetailsFavourite(AppiumDriver<MobileElement> driver)
			throws InterruptedException, MalformedURLException {
		pr.propertyPriceList = pdp.getProeprtyPriceFromList(driver);
		pr.listBedBathSqft = pdp.getPropertyBedBathSqftList(driver);
		pr.propertyAddressList = propertyAddressList(driver);
		favPropertyFromList(driver);
		driver.findElement(clickFavouriteTab).click();
		Thread.sleep(5000);
		pr.propertyPriceFav = driver.findElement(favPropertyPrice).getText();
		Assert.assertEquals(pr.propertyPriceList, pr.propertyPriceFav, "Price doesn't match..!");
		pr.porpertyAddressFav = driver.findElement(favPropertyAddress).getText();
		Assert.assertEquals(pr.propertyAddressList, pr.porpertyAddressFav, "Property Adrress not matching..!");
		element = driver.findElement(favPropertyDetails);
		pr.listBedBathSqft = cf.countBedBathSqft(element.getText());
		Assert.assertEquals(pr.listBedBathSqft[0], pr.listBedBathSqft[0], "Proprty Bed count does not match..!");
		Assert.assertEquals(pr.listBedBathSqft[1], pr.listBedBathSqft[1], "Proprty Bath count does not match..!");
		Assert.assertEquals(pr.listBedBathSqft[2], pr.listBedBathSqft[2], "Proprty SqFt does not match..!");
		System.out.println("Favourited property validated..");
		driver.findElement(By.id("com.owners.buyer:id/fav_button")).click();

	}
	public void verifyLoginBeforeSaveListing(AppiumDriver<MobileElement> driver) {
		driver.findElement(favPropertyList).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
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
			// driver.hideKeyboard();
			driver.findElement(onboarding_SignInBtn).click();
			System.out.println("Clicked on Sign In Button");

		} catch (Exception e) {
			System.out.println("User is Signed in..!");
		}

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(coShopAlertTitle));
			System.out.println(driver.findElement(coShopAlertTitle).getText());
			System.out.println(driver.findElement(alertTittleMessage).getText());
			driver.findElement(doNotAskAgain).click();
			driver.findElement(notNowButton).click();
		} catch (Exception e) {
			System.out.println("No co-shop alert is visible..!");
		}
	}
	
	public void confirmDisclaimer(AppiumDriver<MobileElement> driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDisclaimerFirstTime));
			System.out.println("Disclaimer page is shown..!");
			System.out
					.println(driver.findElement(privateNoteDescription).getText() + " : Description Text verified");
			driver.findElement(disclaimerAcceptButton).click();
			System.out.println("OK Button clicked -> Navigated to Fav tab.");
		} catch (Exception e) {
			System.out.println("Disclaimer page is not opened as user navigated to this page earlier as well..!");
		}

	}
	
	public void addTextInFavTab(AppiumDriver<MobileElement> driver, String textToEnter) throws InterruptedException {
		driver.findElement(clickFavouriteTab).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(editTextField).click();
		confirmDisclaimer(driver);
		driver.findElement(editTextField).sendKeys(textToEnter);
		driver.hideKeyboard();
		String[] chars = driver.findElement(remainingChars).getText().split("/");
		String maxLimit = chars[1];
		System.out.println("Max limit of enetering characters: " + maxLimit);
		System.out.println("Total characters entered: " + chars[0]);
		driver.findElement(saveAssetButton).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(sendTextProgressBar));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(commentTextView));
		} catch (Exception e) {
			System.out.println("Comment added but not relfected in the view..");
		}
		System.out.println("Asset addition completed..");
	}
	
	public void latestCommentVerify(AppiumDriver<MobileElement> driver, String assetToAdd)
			throws InterruptedException {
		addTextInFavTab(driver, assetToAdd);
		Thread.sleep(2000);
		System.out.println("Asset author initials are: " + driver.findElement(commentAuthorInitials).getText());
		String lastComment = driver.findElement(commentTextView).getText().trim().substring(12);
		System.out.println(
				"Asset added time is: " + driver.findElement(commentTextView).getText().trim().substring(4, 10));
		Assert.assertEquals(assetToAdd.trim(), lastComment.trim(), "Last comment does not match with the commet added");
	}
	
	public void swipePhotosInFavourite(AppiumDriver<MobileElement> driver) throws InterruptedException {
//		int xcoOrdinate = driver.findElement(imageContainerInFav).getCenter().getX();
//		int ycoOrdinate = driver.findElement(imageContainerInFav).getCenter().getY();
//		Dimension size = driver.findElement(imageContainerInFav).getSize();
//		int length = size.getWidth();
//		int xcoOrdinateStart = xcoOrdinate + length / 4;
//		int xcoOrdinateEnd = xcoOrdinate - length / 4;
		
		//new TouchAction(driver).press(PointOption.point(499, 647)).waitAction().moveTo(PointOption.point(158, 565)).release().perform();
        //new TouchAction(driver).longPress(PointOption.point(499, 647)).waitAction().moveTo(PointOption.point(158, 565)).release().perform();
//		double percentage = 20 ;
//        Dimension size = driver.manage().window().getSize();
//        int height = size.getHeight();
//		int width= size.getWidth();
//		int y=(int)(height * 0.20);
//		int startx=(int)(width * 0.75);
//		int endx=(int)(width * 0.20);
//		new TouchAction(driver).longPress(PointOption.point(startx, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(endx,y)).release().perform();

		cf.horizontalswipetowardsright(driver, 0.20);
	}
	
	public void countImagesWhileSwipe(AppiumDriver<MobileElement> driver) throws InterruptedException {
	
		swipePhotosInFavourite(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(imageConatinerPhotoCount));
		String currentImageNo = driver.findElement(imageConatinerPhotoCount).getText().split("/")[0];
		String totalImageCount = driver.findElement(imageConatinerPhotoCount).getText().split("/")[1];
		if (Integer.parseInt(currentImageNo) > 1) {
			System.out.println("Image swiped to image :" + Integer.parseInt(currentImageNo));
			System.out.println("Total Image count..: " + totalImageCount);
 		    swipePhotosInFavourite(driver);
		    Thread.sleep(3000);
		    swipePhotosInFavourite(driver);
		    Thread.sleep(3000);
            swipePhotosInFavourite(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(favPropertyAddress));
		} else
			System.out.println("Single image is available in the property.");

	}
	
	public void favPropertyFromMap(AppiumDriver<MobileElement> driver) throws InterruptedException {

		wait = new WebDriverWait(driver, 20);
		checkNoSavedListingsText(driver);
		cf.fromClusterToPinView(driver);
		wait.until(ExpectedConditions.elementToBeClickable(favIconInQuickSRP));
		driver.findElement(favIconInQuickSRP).click();
		String qPrice = driver.findElement(quickViewPrice).getText();
		String qBedBath = driver.findElement(bedBathSqFtQuickView).getText();
		String qAddress = driver.findElement(addressQuickView).getText();
		wait.until(ExpectedConditions.elementSelectionStateToBe(favIconInQuickSRP, true));
		if (driver.findElement(favIconInQuickSRP).isSelected()) {
			System.out.println("Property has been favorited from Quick SRP..!");
			Thread.sleep(5000);
			driver.findElement(clickFavouriteTab).click();
			Assert.assertEquals(qPrice, driver.findElement(favPropertyPrice).getText(),
					"Property Price not matching..!");
			System.out.println("Property Price matched as: " + qPrice);
			Assert.assertEquals(qBedBath, driver.findElement(favPropertyDetails).getText(),
					"Property Details not matching..!");
			System.out.println("Property details matched as: " + qBedBath);
			Assert.assertEquals(qAddress, driver.findElement(favPropertyAddress).getText(),
					"Property Address not matching..!");
			System.out.println("Property address matched as: " + qAddress);
		}

	}
	public void addDeleteMultilineNotes(AppiumDriver<MobileElement> driver) throws InterruptedException, MalformedURLException {
	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try
		{
			cf.scrollToText("Notes", driver);
			System.out.println(" its at Notes section");

		}
		catch(Exception e)
		{
			System.out.println("Already its at Notes section");
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(editTextField).click();
		confirmDisclaimer(driver);
		driver.findElement(editTextField).sendKeys("In Word 2013 or Word 2010, on the Review tab, in the Tracking group, in the Show Markup list, choose.");
		driver.hideKeyboard();
        Thread.sleep(2000);
        try
		{
            driver.findElement(saveAssetButton).isDisplayed();
            driver.findElement(saveAssetButton).click();

		}
		catch(Exception e)
		{
            driver.findElement(saveAssetButton).click();

		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(sendTextProgressBar));
		System.out.println("Multiline asset addition completed..");
		String multilineComment = driver.findElement(commentTextView).getText();
		if (multilineComment.contains("...")) {
			System.out.println(
					driver.findElement(commentTextView).getText() + "\n multiline comment added successfully..");
		}

		driver.findElement(showAllText).click();
		Thread.sleep(3000);
		String multilineCommentExpanded = driver.findElement(commentTextView).getText();
		System.out.println("Multilne comment is: " + multilineCommentExpanded);
		driver.findElement(commentTextView).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(commentdeleteButtonInEditPage));
		driver.findElement(commentdeleteButtonInEditPage).click();
		driver.findElement(delteNoteDeleteButton).click();
		Thread.sleep(2000);
	}

}
