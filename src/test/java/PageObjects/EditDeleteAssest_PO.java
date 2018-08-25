/**
 * 
 */
package PageObjects;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.FavouriteProperty_OR;
import ObjectRepository.Registration_OR;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


/**
 * @author Jayabrata
 *
 */
public class EditDeleteAssest_PO extends desiredCapabilities implements FavouriteProperty_OR , Registration_OR{
	AppiumDriver<MobileElement> driver;
	WebElement element;
	WebDriverWait wait;
	commonFunctions cf = new commonFunctions();
	PropertyData pr = new PropertyData();
	FavouriteProperty_PO fp = new FavouriteProperty_PO();
	//FavTabID_PO ft = new FavTabID_PO();
	//FavoritesTab_PO ftpo = new FavoritesTab_PO();

	public void editCommentFromFavTab(AppiumDriver<MobileElement> driver, String textToBeAdded)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(commentTextView).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(commentdeleteButtonInEditPage));
		wait.until(ExpectedConditions.elementToBeClickable(saveNoteButtonInEditPage));
		driver.findElement(commentInEditPage).clear();
		System.out.println(
				"Default text in edit section is verified as : " + driver.findElement(commentInEditPage).getText());
		driver.findElement(commentInEditPage).sendKeys(textToBeAdded);
		Thread.sleep(2000);
		if (driver.findElement(commentInEditPage).getText().contains(textToBeAdded)) {
			driver.findElement(saveNoteButtonInEditPage).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(commentContainer));
			String lastComment = driver.findElement(commentTextView).getText().trim().substring(12);
			System.out.println(
					"Asset added time is: " + driver.findElement(commentTextView).getText().trim().substring(4, 10));
			System.out.println("New comment is : " + lastComment);
		} else
			System.out.println("Comment not edited properly...");

	}

	public void deleteCommentsFromProperty(AppiumDriver<MobileElement> driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(commentTextView));
		try {
			while (driver.findElement(commentTextView).isEnabled()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(commentTextView));
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				driver.findElement(commentTextView).click();
				try {
					wait.until(ExpectedConditions.visibilityOfElementLocated(commentdeleteButtonInEditPage));
				} catch (Exception e) {
					driver.findElement(commentTextView).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(commentdeleteButtonInEditPage));
				}
				driver.findElement(commentdeleteButtonInEditPage).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(deleteNoteConfirmationDialouge));
				System.out.println("Delete note confirmation dialouge is visible..!!");
				driver.findElement(delteNoteDeleteButton).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(commentTextView));
			}
		} catch (Exception e) {
			System.out.println("No Comments are found in the fav tab..!!");
		}

	}

	public void addImageAssetFromCamera(AppiumDriver<MobileElement> driver) throws InterruptedException, MalformedURLException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try
		{
			cf.scrollToText("Notes", driver);
			System.out.println(" its at Notes section");

		}
		catch(Exception e)
		{
			System.out.println("Already its at Notes section");
		}
		driver.findElement(editTextField).click();
		fp.confirmDisclaimer(driver);
		wait.until(ExpectedConditions.elementToBeClickable(cameraIcon));
		driver.findElement(cameraIcon).click();
		try {
			
			driver.findElement(allowMediaAccess).click();
		} catch (Exception e) {
			System.out.println("Media Access is already allowed..!!");
		}
		driver.findElement(cameraButtonInDialouge).click();
		wait.until(ExpectedConditions.elementToBeClickable(captureImageFromCamera));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(captureImageFromCamera).click();
		try
		{
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(saveImageAfterClicking);
		}
		catch(NoSuchElementException e)
		{
			driver.findElement(captureImageFromCamera).click();

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(saveImageAfterClicking));
		driver.findElement(saveImageAfterClicking).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(imageInAssetEditSection));
		driver.findElement(editTextField).sendKeys("Image from camera added as asset..!!");
		driver.hideKeyboard();
		try
		{
			cf.scrollToText("Save", driver);
			//cf.scrollToText("Estimated monthly payment", driver);
			driver.findElement(saveAssetButton);
			driver.findElement(saveAssetButton).isDisplayed();
            driver.findElement(saveAssetButton).click();

		}
		catch(Exception e)
		{
            driver.findElement(saveAssetButton).click();

         }
		wait.until(ExpectedConditions.invisibilityOfElementLocated(sendTextProgressBar));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(commentTextView));
			wait.until(ExpectedConditions.visibilityOfElementLocated(imageAddedAsAsset));
			System.out.println("Comment added as : " + driver.findElement(commentTextView).getText());
		} catch (Exception e) {
			System.out.println("Comment added but not relfected in the view..");
		}
		System.out.println("Asset addition completed.. CAMERA..");
	}

	public void addImageFromGallery(AppiumDriver<MobileElement> driver) throws InterruptedException, MalformedURLException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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
		fp.confirmDisclaimer(driver);
		driver.findElement(cameraIcon).click();
		try {
			driver.findElement(allowMediaAccess).click();
		} catch (Exception e) {
			System.out.println("Media Access is already allowed..!!");
		}

		driver.findElement(photoButtonInDialouge).click();
		wait.until(ExpectedConditions.elementToBeClickable(selectImageFromGallery));
		driver.findElement(selectImageFromGallery).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(imageInAssetEditSection));
		driver.findElement(editTextField).sendKeys("Image from Gallery added as asset..!!");
		driver.hideKeyboard();
		try
		{
			cf.scrollToText("Save", driver);
            driver.findElement(saveAssetButton).isDisplayed();
            driver.findElement(saveAssetButton).click();

		}
		catch(Exception e)
		{
            driver.findElement(saveAssetButton).click();

		}		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(sendTextProgressBar));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(commentTextView));
			wait.until(ExpectedConditions.visibilityOfElementLocated(imageAddedAsAsset));
			System.out.println("Comment added as : " + driver.findElement(commentTextView).getText());
		} catch (Exception e) {
			System.out.println("Comment added but not relfected in the view..");
		}
		System.out.println("Asset addition completed.. GALLERY..");
	}

	public void deleteImageFromAsset(AppiumDriver<MobileElement> driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try
		{
			cf.scrollToText("Show All", driver);
			System.out.println(" its Show All section");

		}
		catch(Exception e)
		{
			System.out.println("Already its at Show All section");
		}
		driver.findElement(showAllText).click();
		driver.findElement(commentTextView).click();
		wait.until(ExpectedConditions.elementToBeClickable(addedImageRemoveButton));
		driver.findElement(addedImageRemoveButton).click();
		System.out.println("Clicked on the delete button.. Saving the note now..!!");
		driver.findElement(saveNoteButtonInEditPage).click();
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(imageAddedAsAsset));
			System.out.println("Image has not been deleted from the comments section..!");
		} catch (Exception e) {
			System.out.println("Image is deleted from asset..!!");
		}
	}

}
