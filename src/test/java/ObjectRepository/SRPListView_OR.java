/**
 * @author Jayabrata
 *
 */

package ObjectRepository;

import org.openqa.selenium.By;

public interface SRPListView_OR {
	// LIST SRP

	public By clickSortOption = By.id("com.owners.buyer:id/search_result_sort_text_view");
	public By featuredOption = By
			.xpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView");
	public By listingAge = By
			.xpath("//android.widget.LinearLayout[2]//android.widget.RelativeLayout//android.widget.TextView");
	public By lowToHighOption = By
			.xpath("//android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.TextView");
	public By highToLowOption = By
			.xpath("//android.widget.LinearLayout[4]//android.widget.RelativeLayout//android.widget.TextView");

	public By priceDecreaseTag = By.id("com.owners.buyer:id/layout_property_price_decrease");
	public By priceIncreaseTag = By.id("com.owners.buyer:id/layout_property_price_increase");
	public By mlsIdInSRP = By.id("com.owners.buyer:id/mlsId");
	public By mlsBoardName = By.id("com.owners.buyer:id/search_result_agent_board_name");
	public By listingCourtesyInSrp = By.id("com.owners.buyer:id/search_result_agent_text_view");

	// SWIPE SRP
	public By swipePropertyInfo = By.id("com.owners.buyer:id/search_card_info_text_view");
	public By swipePropertyPrice = By.id("com.owners.buyer:id/search_card_price_text_view");
	public By swipePropertyAddress = By.id("com.owners.buyer:id/search_card_address_text_view");
	public By swipeFavButton = By.id("com.owners.buyer:id/search_card_save_button");
	public By swipePropertyImage = By.id("com.owners.buyer:id/search_card_image_view");
	public By swipePropertyThumbnailImage = By.id("com.owners.buyer:id/search_card_thumbnail_one");
	public By swipeNoPropertyFound = By.id("com.owners.buyer:id/no_result_cant_find");
	public By listNoPropertyFound = By.id("com.owners.buyer:id/list_no_result_cant_find");

	// up to date card
	public By uptoDateMapButton = By.id("com.owners.buyer:id/swipe_info_card_map");
	public By uptoDateListButton = By.id("com.owners.buyer:id/swipe_info_card_list");
	public By uptoDateFavButton = By.id("com.owners.buyer:id/swipe_info_card_favorite");
	public By uptoDateHeader = By.xpath(
			"//android.widget.FrameLayout[2]//android.widget.FrameLayout//android.widget.LinearLayout//android.widget.FrameLayout//android.widget.LinearLayout//android.widget.TextView[1]");
	public By uptoDateSubHeader = By.xpath(
			"android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView21]");

}
