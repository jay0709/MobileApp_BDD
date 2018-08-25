package Driver.stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.PropertDetailsPage_OR;
import PageObjects.commonFunctions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class PDPMortagageStepDefinations  extends desiredCapabilities implements PropertDetailsPage_OR {
	PDPStepDefinations po = new PDPStepDefinations();
	commonFunctions cf = new commonFunctions();
	PropertyData pr = new PropertyData();
	private String ActualPropertyPrice;
	private String PropertyPrice ;
	private String DownPaymentvalue;
	private String InterestRate;

	@Given("^User Scroll upwards randomly$")
	public void user_Scroll_upwards_randomly() throws Throwable {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		cf.verticalScrollDownwrds(driver);
	}

	@Given("^verify mortage calculator icon and mortage price is displayed in pdp page$")
	public void verify_mortage_calculator_icon_and_mortage_price_is_displayed_in_pdp_page() throws Throwable {
	   
	}

	@Given("^Compares whole property price in pdp page and in mortage calculator page$")
	public void compares_whole_property_price_in_pdp_page_and_in_mortage_calculator_page() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MortagageCalculatorPropertyPrice));
		String ExpectedMortagagePropertyPrice = driver.findElement(MortagageCalculatorPropertyPrice).getText();
		System.out.println("ExpectedMortagagePropertyPrice is"+ExpectedMortagagePropertyPrice);
		System.out.println("value here is"+ActualPropertyPrice);
        Assert.assertEquals(ActualPropertyPrice, ExpectedMortagagePropertyPrice,"property price in pdp and mortagage calculator page is not matching ");
		
    }
	
	@And("^retrieves \"([^\"]*)\" value$")
	public void retrieves_value(String RetrieveValue) throws Throwable
	{
		if(RetrieveValue.equals("Property price"))
		{
			PropertyPrice= driver.findElement(priceInPDP).getText();
            ActualPropertyPrice = PropertyPrice.substring(1);
			System.out.println("Actual Property Price is"+ActualPropertyPrice);

		}
	}
	
	@Given("^Validate the \"([^\"]*)\" field can take \"([^\"]*)\" digits$")
    public void validate_the_field_can_take_digits(String Field, String digits) throws Throwable {
	if(Field.equals("Property price"))
		{	
			driver.findElement(MortagageCalculatorPropertyPrice).clear();
			driver.findElement(MortagageCalculatorPropertyPrice).sendKeys(pr.SendNineDigitsPropertyPrice);
	    }

	}

	@Given("^Verify editing \"property price as not impacted property price on pdp$")
	public void verify_editing_property_price_as_not_impacted_property_price_on_pdp() throws Throwable {

		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().back();
        String impactPropertyPrice= driver.findElement(priceInPDP).getText();
		String impactActualPropertyPrice = impactPropertyPrice.substring(1);
        Assert.assertEquals(ActualPropertyPrice,impactActualPropertyPrice);
		
	}
	
	@And("^swap between the Loan types and verify emp does not change$")
	public void swap_between_the_loan_types_and_verify_emp_does_not_change() throws Throwable
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MortagageCalculator15YearLoanType));
		String ActualEMPPrice = driver.findElement(ExpectedEMPprice).getText();
		driver.findElement(MortagageCalculator15YearLoanType).click();
		String ExpectedEMPPricefor15Year = driver.findElement(ExpectedEMPprice).getText();
		Assert.assertNotSame(ActualEMPPrice, ExpectedEMPPricefor15Year,"Swapping loan types  to 15 year price emp price as changed");
		driver.findElement(MortagageCalculator30yearLoanType).click();
		String ExpectedEMPPricefor30Year = driver.findElement(ExpectedEMPprice).getText();
		Assert.assertEquals(ActualEMPPrice, ExpectedEMPPricefor30Year,"Swapping loan types back to 30 year price emp price as changed");

    }
	
	@And("^input decimal value in interest rate field$")
	public void input_decimal_value_in_interest_rate_field() throws Throwable
	{
		driver.findElement(interestRate).clear();
		driver.findElement(interestRate).sendKeys(pr.InputInterestRate);
		String InterestRate = driver.findElement(interestRate).getText();
		Assert.assertTrue(InterestRate.contains("."), "Interest Rate field does not accept decimal values");
	}
	
	@And("^Validates disclaimer on emp page$")
	public void Validates_disclaimer_on_emp_page() throws Throwable
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(MortagageDisclaimer));
		String MortagageDisclaimerText ="(Includes Property tax and HOA dues when available. Home insurance and other customary loan fees are not included. Calculations are for general information only. Actual terms of your loan may differ.)";
		String ExpectedMortageDisclaimerText = driver.findElement(MortagageDisclaimer).getText();
		Assert.assertEquals(MortagageDisclaimerText, ExpectedMortageDisclaimerText,"Mortage disclaimer text does not match");
	}
	
	@And("^Enters negative value in this \"([^\"]*)\"$")
	public void enters_negative_value_in_this(String Field) throws Throwable {
		
		if(Field.equals("property price"))
		{	
			driver.findElement(MortagageCalculatorPropertyPrice).clear();
			driver.findElement(MortagageCalculatorPropertyPrice).sendKeys(pr.propertyPriceNegativeValue);
			PropertyPrice = driver.findElement(MortagageCalculatorPropertyPrice).getText();
		}
		else if(Field.equals("down payment"))
		{	
			driver.findElement(DownPayment).clear();
			driver.findElement(DownPayment).sendKeys(pr.propertyPriceNegativeValue);
			 DownPaymentvalue = driver.findElement(DownPayment).getText();
		}
		else if(Field.equals("interest rates"))
		{
			driver.findElement(interestRate).clear();
			driver.findElement(interestRate).sendKeys(pr.propertyPriceNegativeValue);
			 InterestRate = driver.findElement(interestRate).getText();
		}	
		

	}

	@And("^verify that \"([^\"]*)\" negative value is not accepted$")
	public void verify_that_negative_value_is_not_accepted(String Fields) throws Throwable {

		if(Fields.equals("property price"))
		{	
			Assert.assertTrue(!PropertyPrice.contains("-"), "Negative Value is accepted");

		}
		else if(Fields.equals("down payment"))
		{	
			Assert.assertTrue(!DownPaymentvalue.contains("-"), "Negative Value is accepted");

		}
		else if(Fields.equals("interest rates"))
		{
			Assert.assertTrue(!InterestRate.contains("-"), "Negative Value is accepted");

		}	
	}

	@And("^Verify down payment & interest rates field takes only (\\d+) digits$")
	public void verify_down_payment_interest_rates_field_takes_only_digits(int arg1) throws Throwable {
		
	}

    @And("^Verify property price value is suffixed with dollar sign$")
    public void Verify_property_price_value_is_suffixed_with_sign() throws Throwable
    {
		System.out.println("Property Price is prefixed with"+PropertyPrice);
        Assert.assertTrue(PropertyPrice.contains("$"), "$ is not suffixed with property price");

    }
    
    @And("^Verify down payment takes only 3 digits$")
    public void Verify_down_payment_takes_only_3_digits() throws Throwable
    {
    	
    	     driver.findElement(DownPayment).clear();
    	     driver.findElement(DownPayment).sendKeys("2000");
    	     DownPaymentvalue = driver.findElement(DownPayment).getText();
    	     Assert.assertTrue(!DownPaymentvalue.equals("2000"), "Down payment accepts only 3 values");
    	     driver.navigate().back();

    	}
    
    @And("^Verify down payment and interest rates fields is suffixed with percent sign$")
    public void Verify_down_payment_and_interest_rates_fields_is_suffixed_with_percent_sign() throws Throwable
    {
    	
    	     Assert.assertTrue(DownPaymentvalue.contains("%"),"Down payment value is not suffixed with percent");
    	     wait.until(ExpectedConditions.visibilityOfElementLocated(interestRate));
	     InterestRate = driver.findElement(interestRate).getText();
	     Assert.assertTrue(InterestRate.contains("%"),"InterestRate is not suffixed with percent");

 	}
    
    @And("^User searches property with value \"([^\"]*)\" in search Bar$")
    public void User_searches_property_with_value_in_search_bar(String Location) throws Throwable
    {
    	  cf.SearchPropertyDirectly(Location, driver); 
    }

    @Given("^Validate HOA field is \"([^\"]*)\" in both pdp and emp$")
    public void validate_HOA_field_is_$_in_both_pdp_and_emp(String HOAValue) throws Throwable {
       
    	   System.out.println("Hoa value is" +HOAValue);
    	   wait.until(ExpectedConditions.visibilityOfElementLocated(priceInPDP));
    	   cf.scrollToText("Customize Calculations", driver);
    	   String hoaduesvalue = driver.findElement(empHOADues).getText();
    	   Assert.assertTrue(hoaduesvalue.equals(HOAValue), "hoa dues value in pdp is not $0");
    	   driver.findElement(empCustomizeCalculator).click();
    	   cf.verticalScrollUpwards(driver);
    	   Assert.assertTrue(driver.findElement(empHoaValueCalculator).getText().contains("0"), "hoa dues value in emp is not $0");

    	}
    
    @Given("^Verify down payment increases or decreases by (\\d+)%$")
    public void verify_down_payment_increases_or_decreases_by(int downpayment) throws Throwable {
    
	     DownPaymentvalue = driver.findElement(DownPayment).getText();
	     String ValueAfterSplit = DownPaymentvalue.substring(0, 2);
	     System.out.println("DP String value after split"+ValueAfterSplit);
	     downpayment = Integer.parseInt(ValueAfterSplit);
	     System.out.println("Down payment value is"+downpayment);
         driver.findElement(DPincrease).click();
         int DownPaymentAfterIncrease = downpayment + 1 ;
         System.out.println("DownPaymentAfterIncrease value is"+DownPaymentAfterIncrease);
         Assert.assertTrue(downpayment<DownPaymentAfterIncrease, "Down payment value as not been increased by one");
         
	 }

    @Given("^Verify interest field increases or decreases by (\\d+)\\.(\\d+)%$")
    public void verify_interest_field_increases_or_decreases_by(int IRValue, int arg2) throws Throwable {
    	
	     InterestRate = driver.findElement(interestRate).getText();
	     System.out.println("IR value is"+InterestRate);
	     driver.findElement(InterestIncrease).click();
	     String InterestRateAfterIncrease = driver.findElement(interestRate).getText();
	     Assert.assertNotEquals(InterestRate, InterestRateAfterIncrease, "Interest rate has not increased by 1");
	}

    @Given("^Verify \"([^\"]*)\" is not scrollable$")
    public void verify_is_not_scrollable(String arg1) throws Throwable {
        
    }

    


}
