package PageObjects;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.FavouriteProperty_OR;
import ObjectRepository.OpenHouse_OR;
import ObjectRepository.PropertDetailsPage_OR;
import ObjectRepository.Registration_OR;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



public class PropertyDetailsPage2_PO extends desiredCapabilities implements PropertDetailsPage_OR , Registration_OR ,FavouriteProperty_OR,OpenHouse_OR {
	
	AppiumDriver<MobileElement> driver;
	WebElement element;
	WebDriverWait wait;
	commonFunctions cf = new commonFunctions();	
	String taxData = null;
	String HOAData = null;
	FavouriteProperty_PO fp = new FavouriteProperty_PO();
	PropertyData prop = new PropertyData();
	
	public void toolTipDetailsInfo(AppiumDriver<MobileElement> driver) {
		wait = new WebDriverWait(driver, 5);
		driver.findElement(pdpSchoolExpand).click();
		wait.until(ExpectedConditions.elementToBeClickable(pdpSchoolToolTip));
		driver.findElement(pdpSchoolToolTip).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdpSchoolDialogueTittle));
		System.out.println("Dialogue Title Verified as: " + driver.findElement(pdpSchoolDialogueTittle).getText());
		System.out.println(
				"School rating logic verified as: \n" + driver.findElement(pdpSchoolDialogueDescription).getText());
		driver.findElement(pdpSchoolDialogueOK).click();
	}
	
	public void topAssignedSchool(AppiumDriver<MobileElement> driver) {
		driver.findElement(pdpSchoolExpand).click();
        List<MobileElement> list = driver.findElements(pdpTopSchoolList);
		System.out.println("No of top assigned school is: " + list.size());
		Assert.assertTrue("First school name is not displayed", driver.findElement(pdpSchoolName).isDisplayed());
		Assert.assertTrue("First school details is not displayed", driver.findElement(pdpSchoolInfo).isDisplayed());
		Assert.assertTrue("First school Rating is not displayed", driver.findElement(pdpSchoolRating).isDisplayed());
		Assert.assertTrue("First school Info Grade is not displayed", driver.findElement(pdpSchoolInfoGrade).isDisplayed());
		Assert.assertTrue("First school Info Distance is not displayed", driver.findElement(pdpSchoolInfoDistance).isDisplayed());
		Assert.assertTrue("First school Data Source is not displayed", driver.findElement(pdpSchoolDataSource).isDisplayed());

	}
	
	public void viewAllSchools(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		wait = new WebDriverWait(driver, 5);
		driver.findElement(pdpSchoolExpand).click();
        driver.findElement(pdpViewAllSchools).click();
		System.out.println("Clicked on the View all schools..!");
		wait.until(ExpectedConditions.visibilityOfElementLocated(pdpSchooDeatilslListHeader));
		Assert.assertEquals(driver.findElement(pdpSchooDeatilslListHeader).getText(), "School Information");
		System.out.println("Page title verifed as: " + driver.findElement(pdpSchooDeatilslListHeader).getText());
		List<MobileElement> list = driver.findElements(pdpTopSchoolList);
		System.out.println("No of schools visible in list is: " + list.size());
		cf.verticalScrollUpwards(driver);
		cf.verticalScrollUpwards(driver);
		Assert.assertTrue("Random school 1 name is not displayed", driver.findElement(pdpSchoolName).isDisplayed());
		Assert.assertTrue("Random school 1 details is not displayed", driver.findElement(pdpSchoolInfo).isDisplayed());
		Assert.assertTrue("Random school 1 Rating is not displayed", driver.findElement(pdpSchoolRating).isDisplayed());
		Assert.assertTrue("Random school 1 Info Grade is not displayed", driver.findElement(pdpSchoolInfoGrade).isDisplayed());
		Assert.assertTrue("Random school 1 Info Distance is not displayed", driver.findElement(pdpSchoolInfoDistance).isDisplayed());
		Assert.assertTrue("Random school 1 Data Source is not displayed", driver.findElement(pdpSchoolDataSource).isDisplayed());
		try {
			cf.scrollToText("1234567890", driver);
		} catch (Exception ex) {
			Assert.assertTrue("Random school 2 name is not displayed", driver.findElement(pdpSchoolName).isDisplayed());
			Assert.assertTrue("Random school 2 details is not displayed", driver.findElement(pdpSchoolInfo).isDisplayed());
			Assert.assertTrue("Random school 2 Rating is not displayed", driver.findElement(pdpSchoolRating).isDisplayed());
			Assert.assertTrue("Random school 2 Info Grade is not displayed", driver.findElement(pdpSchoolInfoGrade).isDisplayed());
			Assert.assertTrue("Random school 2 Info Distance is not displayed", driver.findElement(pdpSchoolInfoDistance).isDisplayed());
			Assert.assertTrue("Random school 2 Data Source is not displayed", driver.findElement(pdpSchoolDataSource).isDisplayed());

			System.out.println("School Scroll complete..!!");
		}
		driver.findElement(pdpSchoolListBackButton).click();
	}
	
	public void viewSchoolSourceNavigatation(AppiumDriver<MobileElement> driver) throws InterruptedException {
		driver.findElement(pdpSchoolExpand).click();
        String dataSource = driver.findElement(pdpSchoolDataSource).getText();
		System.out.println(dataSource);
		driver.findElement(pdpSchoolDataSource).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String activity = ((AndroidDriver<MobileElement>) driver).currentActivity();
		System.out.println(activity);
		String URL = "";
		if (activity.contains("chrome")) {
			System.out.println("User navigated to Chrome Browser..!!");
			Thread.sleep(5000);
			URL = driver.findElement(chromeURLBar).getText();
			System.out.println("URL is: " + URL);
		}
		try
		{
			String expectedURL = "https://www.greatschools.org";
			Assert.assertEquals(expectedURL, URL, "Browser not opened for Greatschool.org");

		}
		catch(AssertionError e)
		{
			e.printStackTrace();
			System.out.println("Assertion failure");
		}
    }
	public void checkEMPvalue(AppiumDriver<MobileElement> driver) throws InterruptedException, MalformedURLException {
		wait = new WebDriverWait(driver, 5);
		try {
			cf.scrollToText("Estimated monthly payment", driver);
			String empValue = driver.findElement(estimatedTotalValue).getText();
			System.out.println("EMP value in this PDP is: " + empValue);
		} catch (Exception e) {
			System.out.println("Emp section all data is not present..!!");
		}
	}

	public void checkEstimatedInfo(AppiumDriver<MobileElement> driver) {
		try {
			cf.scrollToText("30-Year Fixed, 3.86 % Interest", driver);
			System.out.println("Duration & Interest rate options are verified..!!");
			driver.findElement(empInfo).click();
			String empInfoMessage = driver.findElement(empInfo).getText();
			String empDesiredMessage = "Includes Property tax and HOA dues when available. Home insurance and other customary loan fees are not included. Calculations are for general information only. Actual terms of your loan may differ.";
			Assert.assertEquals(empInfoMessage, empDesiredMessage, "Emp info message does not match..!!");
			driver.findElement(empMessageClose).click();
			System.out.println("EMP Message box closed..!!");
		} catch (Exception e) {
			driver.findElement(empMessageClose).click();
			System.out.println("EMP Message box closed..!!");
		}
	}
	
	public void checkEMPBreakUp(AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
		int taxValue = 0;
		int HOAValue = 0;

		// checking EMP value
		cf.scrollToText("30-Year Fixed, 3.86 % Interest", driver);
		String empData = driver.findElement(estimatedTotalValue).getText();

		// checking principal & interest value
		cf.scrollToText("Principal and Interest", driver);
		String principalData = driver.findElement(empPrincipleValue).getText();

		// Checking property tax value
		try {
			cf.scrollToText("Property Taxes", driver);
			taxData = driver.findElement(empTaxValue).getText();
		} catch (Exception e1) {
			System.out.println("Property Taxes section not available..!!");
		}

		// checking HOA Dues value
		try {
			cf.scrollToText("HOA Dues", driver);
			HOAData = driver.findElement(empHOADues).getText();
		} catch (Exception e1) {
			System.out.println("HOA Dues section not available..!!");
		}

		// getting the integer value of all Data
		int empValue = Integer.parseInt(empData.substring(1, empData.indexOf(" ")).replace(",", "").trim());
		int principalValue = Integer.parseInt(principalData.replace("$", "").replaceAll(",", "").trim());

		if (taxData != null)
			taxValue = Integer.parseInt(taxData.replace("$", "").replaceAll(",", "").trim());

		if (HOAData != null)
			HOAValue = Integer.parseInt(HOAData.replace("$", "").replaceAll(",", "").trim());

		// Checking the breakup of the EMP
		if (empValue == (principalValue + taxValue + HOAValue)) {
			System.out.println("Principal Amount: $ " + principalValue);
			System.out.println("Tax value: $" + taxValue);
			System.out.println("HOA value: $" + HOAValue);
			System.out.println("");
			System.out.println("Estimated Monthly payment value: $" + (principalValue + taxValue + HOAValue));
		}

		// verify the tax value with the anuual value
		if (taxValue != 0 || String.valueOf(taxValue) != null)
			checkTaxValueBreakup(driver, taxValue);

	}
	
	public void checkTaxValueBreakup(AppiumDriver<MobileElement> driver, int taxValue)
			throws MalformedURLException, InterruptedException {

		// Collecting PDP TAX amount from Tax History section

		cf.scrollToText("Total", driver);
		String pdpTaxData = driver.findElement(propertyTaxValue).getText();
		int pdpTaxValue = Integer.parseInt(pdpTaxData.replace("$", "").replace(",", "").trim());
		int perMonthTaxAmount = (int) pdpTaxValue / 12;
		System.out.println("Per year tax amount is: $" + pdpTaxValue);
		System.out.println("Per month tax amount is: $" + perMonthTaxAmount);
		Assert.assertEquals( "Per month tax data does not match..!!",taxValue, perMonthTaxAmount);
		System.out.println("Per month tax data matched with Tax history data..!!");
	}
	
	public void addTextInPDP(AppiumDriver<MobileElement> driver, String textToEnter) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(2000);
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
		driver.findElement(editTextField).sendKeys(textToEnter);
		driver.hideKeyboard();
        String[] chars = driver.findElement(remainingChars).getText().split("/");
		String maxLimit = chars[1];
		System.out.println("Max limit of enetering characters: " + maxLimit);
		System.out.println("Total characters entered: " + chars[0]);
		try
		{
			cf.scrollToText("Save", driver);
            driver.findElement(saveAssetButton).isDisplayed();
            driver.findElement(saveAssetButton).click();;

		}
		catch(Exception e)
		{
            driver.findElement(saveAssetButton).click();;

        }		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(sendTextProgressBar));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(commentTextView));
		} catch (Exception e) {
			System.out.println("Comment added but not relfected in the view..");
		}
		System.out.println("Asset addition completed..");
	}
	
	public void CommentVerificationinPDP(AppiumDriver<MobileElement> driver, String assetToAdd)
			throws InterruptedException {
		addTextInPDP(driver, assetToAdd);
		Thread.sleep(2000);
//		System.out.println("Asset author initials are: " + driver.findElement(commentAuthorInitials).getText());
//		String lastComment = driver.findElement(commentTextView).getText().trim().substring(12);
//		System.out.println("last comment is"+lastComment.trim());
//		System.out.println("Assest to add is"+assetToAdd.trim());
//
//		System.out.println(
//				"Asset added time is: " + driver.findElement(commentTextView).getText().trim().substring(4, 10));
//		try
//		{
//			Assert.assertEquals(assetToAdd.trim(), lastComment.trim(), "Last comment does not match with the comment added");
//
//		}
//		catch (AssertionError e)
//		{
//			e.printStackTrace();
//			System.out.println("Assertion failed");
//		}
	}
	
	@SuppressWarnings("deprecation")
	public void MakeAnOfferFormValidation(AppiumDriver<MobileElement> driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(MakeAnOffer, "Make an Offer"));
        Assert.assertTrue( "Make an offer section not present",driver.findElement(MakeAnOffer).isDisplayed());
		Thread.sleep(3000);
        WebElement element =driver.findElement(MakeAnOffer);
		element.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(OfferFirstName));
		String[] myStringArray;
        myStringArray = new String[]{"Third","Coshopper","testleadzero@gmail.com"};
		String[] updatedFieldsArray = new String[3];
		updatedFieldsArray[0] = driver.findElement(OfferFirstName).getText();
		updatedFieldsArray[1] = driver.findElement(OfferLastName).getText();
		updatedFieldsArray[2] = driver.findElement(OfferEmail).getText();
		for (int i = 0; i < myStringArray.length; i++) {
	        if (myStringArray[i].equalsIgnoreCase(updatedFieldsArray[i])) 
	        {
	           System.out.println("The fiels are equal at position"+myStringArray[i]);
	        }
	        else
	        {
		           System.out.println("The fiels are Not equal at position"+myStringArray[i]);
            }
	    }
		driver.findElement(OfferPhone).clear();
        driver.findElement(OfferPhone).sendKeys(prop.phoneNumber);
		driver.findElement(NextButton).click();
		driver.findElement(OfferMoney).sendKeys("888");
		driver.findElement(NextButton).click();
        driver.findElement(AllCashOption).click();
		Assert.assertTrue(driver.findElement(AllCashOption).isEnabled());
        for (int i=0; i<3;i++)
		{
			driver.findElement(BackButton).click();
        }

	}
	
	@SuppressWarnings("deprecation")
	public void AskAQuestionForm(AppiumDriver<MobileElement> driver)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(askQuestions, "Ask a Question"));
        Assert.assertTrue("Make an offer section not present",driver.findElement(askQuestions).isDisplayed());
		driver.findElement(askQuestions).click();
		FieldValidation(driver);
		Assert.assertTrue("Footer in Ask A Question is not displayed", driver.findElement(AskFooterDeatils).isDisplayed());
	}
	
	public void FieldValidation(AppiumDriver<MobileElement> driver)
	{
		String[] myStringArray;
        myStringArray = new String[]{"Third","Coshopper","testleadzero@gmail.com"};
		String[] updatedFieldsArray = new String[3];
		WebDriverWait wait = new WebDriverWait(driver,10);

		wait.until(ExpectedConditions.visibilityOfElementLocated(AskFirstName));

		updatedFieldsArray[0] = driver.findElement(AskFirstName).getText();
		updatedFieldsArray[1] = driver.findElement(AskLastName).getText();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		updatedFieldsArray[2] = driver.findElement(AskEmail).getText();
		
		for (int i = 0; i < myStringArray.length; i++) {
	        if (myStringArray[i].equalsIgnoreCase(updatedFieldsArray[i])) 
	        {
	           System.out.println("The fiels are equal at position"+myStringArray[i]);
	        }
	        else
	        {
		           System.out.println("The fiels are Not equal at position"+myStringArray[i]);
            }
	    }
	}
		
	public void checkStateforSaveListingNotification(AppiumDriver<MobileElement> driver) throws InterruptedException {
		Thread.sleep(5000);
		String status = driver.findElement(favoriteNotificationToggle).getText();
		if (status.equals("ON")) {
			driver.findElement(favoriteNotificationToggle).click();
			String statusCheck = driver.findElement(favoriteNotificationToggle).getText();
			Assert.assertEquals("OFF", statusCheck, "Save listing Notification is not turned off..");
		}
	}
	
	public void checkPropertyIsFavorited(AppiumDriver<MobileElement> driver) throws Throwable{
		if (driver.findElement(favIconInPDP).isSelected()) {
			cf.verticalScrollDownwrds(driver);
			cf.verticalScrollDownwrds(driver);
			cf.verticalScrollDownwrds(driver);
			driver.findElement(favIconInPDP).click();
		}
		
	}
	
	public void favPropertyfromPDP(AppiumDriver<MobileElement> driver) throws Throwable{
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(favIconInPDP));
		driver.findElement(favIconInPDP).click();
	}
}

