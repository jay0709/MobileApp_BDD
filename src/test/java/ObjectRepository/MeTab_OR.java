package ObjectRepository;

import org.openqa.selenium.By;

public interface MeTab_OR {
	
	public By EditProfile = By.xpath("//*[@text='Edit Profile']");
	public By UpdatePassword = By.xpath("//*[@text='Update Password']");
	public By MyToursAndOPenHouses = By.xpath("//*[@text='My Tours & Open Houses']");
	public By SellMyHome = By.xpath("//*[@text='Sell My Home']");
	public By Notifications = By.xpath("//*[@text='Notifications']");
	public By Help = By.xpath("//*[@text='Help']");
	public By PrivacyPolicy = By.xpath("//*[@text='Privacy Policy']");
	public By TermsAndConditions = By.xpath("//*[@text='Terms and Conditions']");
	public By FAQ = By.xpath("//*[@text='FAQs']");
	public By Feedback = By.xpath("//*[@text='Feedback']");
	public By EditProfileFirstName = By.id("com.owners.buyer:id/account_user_firstname");
	public By EditProfileSecondName = By.id("com.owners.buyer:id/account_user_lastname");
	public By EditProfileLocation = By.id("com.owners.buyer:id/account_user_location");
	public By EditProfileDone = By.id("com.owners.buyer:id/account_profile_done");
	public By SellPageOpen = By.id("zip");
	public By HelpPageAcceptAndDismiss = By.xpath("//*[text()='ACCEPT & DISMISS']");
	public By TermsAndConditionsPageOpen = By.xpath("//*[text()='Terms and Conditions']");
	public By FAQPageOpen = By.xpath("//*[text()='Frequently Asked Questions']");
	public By PageOpenElement = By.id("com.owners.buyer:id/policy_title");
	public By FeedbackPageHeader = By.xpath("//*[text()='Feedback']");
	public By FeedbackPageHappyCheckBox = By.xpath("//*[@text='Happy']");
	public By FeedbackpageSubmit = By.id("com.owners.buyer:id/send");
	public By NotificationsFavourite = By.id("com.owners.buyer:id/notification_toggle_title_text_view");
	//text :- Favorites
	//text :- ON
	public By FavouriteToggle = By.id("com.owners.buyer:id/notification_toggle_switch");
	public By UpdatedName = By.id("com.owners.buyer:id/account_header_user_name");
	public By UpdatedLocation = By.id("com.owners.buyer:id/account_header_user_location");
	public By PastTourMessage = By.xpath("//*[@text='No Requested Tours']");
	public By SavedOpenHousesMessage = By.xpath("//*[@text='No Saved Open Houses']");
	public By NotificationInstant = By.id("com.owners.buyer:id/notification_search_selection_instant");
    public By NotificationFilter = By.id("com.owners.buyer:id/notification_search_subtitle");

}
