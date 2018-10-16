package ObjectRepository;

import org.openqa.selenium.By;

public interface OpenHouse_OR {

	public By srpMapBtn = By.id("com.owners.buyer:id/search_map_view");
	// public By srpListBtn = By.id("com.owners.buyer:id/search_list_view");
	// public By srpSwipeBtn = By.id("com.owners.buyer:id/search_swipe_view");
	public By filtersClearAll = By.id("com.owners.buyer:id/property_filters_clear_button");
	public By openHouseToggle = By.id("com.owners.buyer:id/filter_toggle_switch");
	public By appliedFilterTextInSRP = By.id("com.owners.buyer:id/filter_text");
	public By noResultErrorTextInSRP = By.id("com.owners.buyer:id/no_result_error_text");
	public By noResultErrorMessage = By.id("com.owners.buyer:id/no_result_error_container");
	public By noResultErrorHeader = By.id("com.owners.buyer:id/no_result_error");
	public By noResultErrorDescription = By.id("com.owners.buyer:id/no_result_error_description");
	public By editSearch = By.id("com.owners.buyer:id/no_result_error_edit_search");
	public By openTextInSRP = By.id("com.owners.buyer:id/search_result_open_house");
	public By openTimeInSRP = By.id("com.owners.buyer:id/search_result_open_house_time");
	public By openHouseHeaderTime = By.id("com.owners.buyer:id/search_result_open_house_time");
	public By openHouseHeaderText = By.id("com.owners.buyer:id/search_result_open_house");
	public By saveOpenHousePDP = By.id("com.owners.buyer:id/button_save_open_house");
	public By openHouseDate = By.id("com.owners.buyer:id/tv_open_house_date");
	public By openHouseTime = By.id("com.owners.buyer:id/tv_open_house_time");
	public By savedOpenHouse = By.id("com.owners.buyer:id/tv_open_house_saved_info");
	public By saveOpenHouseIcon = By.id("com.owners.buyer:id/img_open_house_saved_state");
	public By openHouseTabInMenu = By.xpath("//*[@text='Saved Open Houses']");
	// public By onboarding_SignInTabFooter = By
	// .xpath("//android.support.v7.app.ActionBar.Tab[5]//android.widget.LinearLayout");
	public By openHouseInMe = By.xpath("//*[contains(@text,'My Tours & Open Houses')]");
	public By viewOpenHouseFromMenu = By.id("com.owners.buyer:id/open_house_view");
	public By openHouseTittleInMenu = By.id("com.owners.buyer:id/open_house_view_titlee");
	public By noSavedOpenHouse = By.xpath("//*[contains(@text,'No Saved Open Houses')]");

	public By DOM = By.id("com.owners.buyer:id/search_result_filter_days_selection");
	public By lessSevenDaysDOM = By.xpath("//android.widget.LinearLayout[@index='3']");
	// public By PriceInSrp =
	// By.id("com.owners.buyer:id/search_result_property_price");

	// ----ohm----//
	public By myOpenHouseTime = By.id("com.owners.buyer:id/time");
	public By myOpenHouseMenu = By.id("com.owners.buyer:id/menu");
	public By addressLineOne = By.id("com.owners.buyer:id/property_address_line1");
	public By addressLineTwo = By.id("com.owners.buyer:id/property_address_line2");
	public By favIconInPDP = By.id("com.owners.buyer:id/property_details_favourite_fab");
	public By openHouseTabVerify = By.xpath("//*[contains(@text, 'My Open Houses')]");
	public By menuAddress = By.id("com.owners.buyer:id/openhouse_actions_address");
	public By menuPropertydetails = By.id("com.owners.buyer:id/openhouse_actions_property_details");
	public By menuRequestTour = By.id("com.owners.buyer:id/openhouse_actions_request_tour");
	public By menuCopyAddress = By.id("com.owners.buyer:id/openhouse_actions_copy_address");
	public By menuGetDirections = By.id("com.owners.buyer:id/openhouse_actions_get_directions");
	public By menuAddCalenderEvent = By.id("com.owners.buyer:id/openhouse_actions_add_calendar_event");
	public By menuDeleteOpenHouse = By.id("com.owners.buyer:id/openhouse_actions_delete");
	public By deleteDialouge = By.id("android:id/message");
	public By deleteConfirmationOK = By.id("android:id/button1");
	public By rqstTourHeader = By.id("com.owners.buyer:id/tour_date_title_text_view");
	public By mapNavigation = By.id("com.google.android.apps.maps:id/home_bottom_sheet_container");
	public By calenderNaviagtion = By.id("com.google.android.calendar:id/title_edit_text");
	public By calendarStartDate = By.id("com.google.android.calendar:id/first_line_text");
	public By calendarStartTime = By.id("com.google.android.calendar:id/right_action");
	public By errorText = By.id("com.owners.buyer:id/requested_tour_error_text_view");
	public By openTextInTile = By.id("com.owners.buyer:id/search_result_open_house");
	public By navigatingMeTab = By
			.xpath("//android.support.v7.app.ActionBar.Tab[5]//android.widget.LinearLayout/android.widget.TextView");
	public By navigateFavouriteTab = By
			.xpath("//android.support.v7.app.ActionBar.Tab[2]//android.widget.LinearLayout[1]");
	public By signOutText = By.xpath("//android.widget.TextView[contains(@text,'Sign Out')]");
	public By searchBarSRP = By.id("com.owners.buyer:id/search_result_title_text_view");
	public By openHouseItemAddress = By.id("com.owners.buyer:id/item_recent_property_info_line_1");
	public By openHouseItemAddressState = By.id("com.owners.buyer:id/item_recent_property_info_line_2");
	public By openHousePDPAddress = By.id("com.owners.buyer:id/property_item_address_text_view");
	public By favIconPDP = By.id("com.owners.buyer:id/property_details_favourite_fab");
	public By favToast = By.id("com.owners.buyer:id/favourite_text");
	public By pdpBackButton = By.id("com.owners.buyer:id/property_details_back_button");
	public By searchResultInSRP = By.id("com.owners.buyer:id/search_result_title_text_view");
	public By openTimeDiscoverTile = By.id("com.owners.buyer:id/search_result_open_house_time");
	public By openTimeSwipeSRP = By.id("com.owners.buyer:id/search_result_open_house_time_swipe");
	public By navigateSwipetab = By.id("com.owners.buyer:id/search_swipe_view");
	public By appliedFilterCount = By.id("com.owners.buyer:id/search_result_subtitle_text_view");
	public By heartIcon = By.xpath("//android.widget.ImageView[@index='0']");
	public By favButtonInFav = By.id("com.owners.buyer:id/fav_button");

	/// -----//
	public By openHouseTextInQuickView = By.id("com.owners.buyer:id/search_result_open_house");
	public By openHouseTimeInQuickView = By.id("com.owners.buyer:id/search_result_open_house_time");
	public By newTagInSRPView = By.id("com.owners.buyer:id/search_result_new");
	public By favIconInQuickView = By.id("com.owners.buyer:id/search_item_fav_button");
	public By openHouseTimeInSwipeView = By.id("com.owners.buyer:id/search_result_open_house_time_swipe");
}
