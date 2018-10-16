/**
 * 
 */
/**
 * @author isaacindeevervemula
 *
 */
package ObjectRepository;

import org.openqa.selenium.By;

public interface CommonFunctions_OR {
	public By navigatingSearchTab = By
			.xpath("//android.support.v7.app.ActionBar.Tab[1]//android.widget.LinearLayout[1]");
	public By navigatingDiscoverTab = By
			.xpath("//android.support.v7.app.ActionBar.Tab[3]//android.widget.LinearLayout[1]");
	public By clickSearchBar = By.id("com.owners.buyer:id/search_result_title_text_view");
	public By typeInsearchBar = By.id("com.owners.buyer:id/search_suggestion_search");
	public By searchResultStateName = By.id("com.owners.buyer:id/suggestion_line_two");
	public By searchResultName = By.id("com.owners.buyer:id/suggestion_line_one");
	public By searchingDialouge = By.id("com.owners.buyer:id/dialog_account_message");
	public By searchNearby = By.name("Homes Near:");
	public By filtersTab = By.id("com.owners.buyer:id/search_filter_view");
	public By applyFilterButton = By.id("com.owners.buyer:id/property_filters_done_button");
	public By clearFiltersButton = By.id("com.owners.buyer:id/property_filters_clear_button");
	public By popUpMessage = By.id("com.android.packageinstaller:id/permission_message");
	public By allowPermission = By.id("com.android.packageinstaller:id/permission_allow_button");
	public By savedSearchStar = By.id("com.owners.buyer:id/star_icon");
	public By clickDiscoverTab = By.xpath("//android.support.v7.app.ActionBar.Tab[3]//android.widget.LinearLayout[1]");
	public By savedSearchesHeader = By.xpath("//*[contains(@text, 'Saved Searches')]");
	public By saveSearchText = By.id("com.owners.buyer:id/search_result_save_search_text_view");
	public By mapViewSRPClick = By.id("com.owners.buyer:id/search_map_view");
	public By clusterToPIN = By.xpath("*//android.view.View[@index='0']");
	public By quickViewFavIcon = By.id("com.owners.buyer:id/details_container");
	public By srpMapBtn = By.id("com.owners.buyer:id/search_map_view");
	public By scheduleTourButton = By.id("android:id/button1");
	public By cancelButton = By.id("android:id/button2");
	public By doNotAsk = By.id("com.owners.buyer:id/checkbox");
	public By threeDottedMenuDiscoverTab = By.id("com.owners.buyer:id/menu_icon");
	public By viewSavedSearch = By.xpath("//android.widget.LinearLayout[@index= '0']");
	public By editSavedSearch = By.xpath("//android.widget.LinearLayout[@index='1']");
	public By deleteSavedSearch = By.xpath("//android.widget.LinearLayout[@index= '2']");
	public By exactSwitchBedFilter = By.id("com.owners.buyer:id/filter_exact_bed_switch");
	public By exactSwitchBathFilter = By.id("com.owners.buyer:id/filter_exact_bath_switch");
	public By fourBedFilter = By.id("com.owners.buyer:id/filter_selection_item_four");
	public By OneBedFilter = By.id("com.owners.buyer:id/filter_selection_item_one");
	public By fourBathFilter = By.xpath(
			"//android.widget.FrameLayout[contains(@resource-id,'search_result_filter_baths_selection')]//android.widget.TextView[contains(@resource-id,'filter_selection_item_four')]");
	public By onboarding_SetMinBed = By.id("com.owners.buyer:id/filter_selection_item_four");
	public By srpMessage = By
			.xpath("//*[text()='Have something particular in mind? Add a few filters to your criteria']");
	public By ListingByOwners = By.id("com.owners.buyer:id/filter_selection_item_owners");
	public By SearchBarThreeDotMenu = By.id("com.owners.buyer:id/suggestion_item_image_view_menu");
	public By sortingDialogueMessage = By.id("com.owners.buyer:id/dialog_account_message");
	public By mostRecentSearchSuggestion = By.xpath("*//android.widget.FrameLayout[@index='1']");

}