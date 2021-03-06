package ObjectRepository;

import org.openqa.selenium.By;

public interface PropertDetailsPage_OR {

	public By favIconInList = By.id("com.owners.buyer:id/search_result_fav_button");
	public By priceInList = By.id("com.owners.buyer:id/search_result_property_price");

	public By priceInPDP = By.id("com.owners.buyer:id/property_item_price_text_view");
	public By listBedBathSqft = By.id("com.owners.buyer:id/search_result_property_textview");
	public By pdpBedBathSqftId = By.id("com.owners.buyer:id/property_item_beds_text_view");
	public By expandSchoolInfo = By.id("com.owners.buyer:id/school_layout");
	public By viewAllSchools = By.id("com.owners.buyer:id/property_details_view_all_schools");
	public By statusOfProperty = By.id("com.owners.buyer:id/property_details_active_status");
	public By viewAllFeature = By.id("com.owners.buyer:id/property_details_features_button");
	public By backButton = By.id("com.owners.buyer:id/property_details_back_button");
	public By tourRequest = By.id("com.owners.buyer:id/property_details_call_to_action_text_view");
	// public By listSRPTab = By.id("com.owners.buyer:id/search_list_view");
	public By editTextNote = By.id("com.owners.buyer:id/et_text");
	// public By cameraIcon = By.id("com.owners.buyer:id/icon_camera");
	public By notesHeader = By.id("com.owners.buyer:id/property_details_section_title_text_view");

	// -------PDP------//

	public By pdpCommentView = By.id("com.owners.buyer:id/property_comment_text_view");
	public By imageCountInPDP = By.id("com.owners.buyer:id/property_photos_num_text_view");
	public By pdpGalleryFavIncon = By.id("com.owners.buyer:id/property_photos_fav_button");
	public By pdpGalleryRequestTour = By.id("com.owners.buyer:id/pdp_gallery_contact_seller");
	public By pdpGalleryPropertyPrice = By.id("com.owners.buyer:id/property_details_request_tour_price");
	public By pdpGalleryDeleteImage = By.id("com.owners.buyer:id/property_details_gallery_note_image_delete");
	public By pdpGalleryNote = By.id("com.owners.buyer:id/note_image_text");
	public By pdpGalleryImageCount = By.id("com.owners.buyer:id/property_photos_num_text_view");
	public By pdpGalleryBackButton = By.id("com.owners.buyer:id/property_photos_back_button");
	public By imageView = By
			.xpath("//*[@resource-id=\"com.owners.buyer:id/property_photos_view_pager\"]/android.widget.ImageView[1]");
	public By UserPhotosSection = By.xpath("//*[@text='User Photos']");
	public By UploadedPhoto = By
			.xpath("//*[@resource-id=\"com.owners.buyer:id/property_photos_view_list\"]/android.widget.FrameLayout[6]");
	public By UploadedImageText = By.id("com.owners.buyer:id/note_image_text");
	public By UploadedImageDeleteIcon = By.id("com.owners.buyer:id/property_details_gallery_note_image_delete");

	public By pdpfavIcon = By.id("com.owners.buyer:id/property_details_favourite_fab");
	public By pdpFavPropertyAlertTitle = By.id("com.owners.buyer:id/alertTitle");
	public By pdpFavPropertyALertMessage = By.id("android:id/message");
	public By doNotAskCheckBox = By.id("com.owners.buyer:id/checkbox");
	public By doNotFavButton = By.id("android:id/button2");
	public By favButtonInAlert = By.id("android:id/button1");

	public By pdpPriceView = By.id("com.owners.buyer:id/property_item_price_text_view");
	public By pdpSchoolSection = By.id("com.owners.buyer:id/school_layout");
	// public By pdpBackButton =
	// By.id("com.owners.buyer:id/property_details_back_button");
	public By favToastMessage = By.id("com.owners.buyer:id/favourite_text");
	public By saveNoteButton = By.id("com.owners.buyer:id/send_layout");
	public By navigateSearchTab = By.xpath("//android.support.v7.app.ActionBar.Tab[1]//android.widget.LinearLayout[1]");
	public By requestTourPageHader = By.id("com.owners.buyer:id/tour_date_title_text_view");
	public By requestTourPageAddressFirstLine = By.id("com.owners.buyer:id/property_address_text_first");
	public By requestTourPageAddressSecondLine = By.id("com.owners.buyer:id/property_address_text_second");
	public By requestASAPTile = By.id("com.owners.buyer:id/tour_quick_date_asap");
	public By requestTourMonth = By.id("com.owners.buyer:id/tour_quick_date_month");
	public By requestTourDayOfMonth = By.id("com.owners.buyer:id/tour_quick_date_day_of_month");
	public By requestTourDayOfWeek = By.id("com.owners.buyer:id/tour_quick_date_day_of_week");
	public By requestTourEmailUser = By.id("com.owners.buyer:id/tour_email");
	public By requestTourComment = By.id("com.owners.buyer:id/contact_seller_message_edit_text");
	public By requestTourTime = By.id("com.owners.buyer:id/tour_quick_time");
	public By requestTourConsent = By.id("com.owners.buyer:id/phone_consent_text_view");
	public By requestTourSubmit = By.id("com.owners.buyer:id/contact_seller_send");
	public By requetsTourPageBackButton = By.id("com.owners.buyer:id/tour_date_back_button");
	public By requestTourFirstName = By.xpath("//*[@text='First Name']/android.widget.FrameLayout[1]");
	public By requestTourLastName = By
			.xpath("//*[@resource-id='com.owners.buyer:id/input_two_text_input']/android.widget.FrameLayout[1]");
	public By requestTourEmailID = By.xpath("//*[@text='Email']/android.widget.FrameLayout[1]");
	public By requestTourInvalidInput = By.id("com.owners.buyer:id/textinput_error");
	public By requestTourPhone = By.xpath("//*[@text='Phone']/android.widget.FrameLayout[1]");
	public By AskAQuestionFormSubmitButton = By.id("com.owners.buyer:id/contact_seller_send_fab");
	public By AskAQuestionFormPhoneError = By.xpath("//*[@text='Enter phone number']");

	// public By

	// ----PDP school & other sections----//

	public By pdpSchoolLayout = By.id("com.owners.buyer:id/school_layout");
	public By pdpSchoolExpand = By.id("com.owners.buyer:id/expand_Button");
	public By pdpTopSchoolList = By.id("com.owners.buyer:id/school_Details_Layout");
	public By pdpSchoolToolTip = By.id("com.owners.buyer:id/property_details_school_district_info");
	public By pdpSchoolName = By.id("com.owners.buyer:id/school_info_name");
	public By pdpSchoolInfo = By.id("com.owners.buyer:id/school_info_students");
	public By pdpSchoolRating = By.id("com.owners.buyer:id/school_info_rating");
	public By pdpSchoolInfoGrade = By.id("com.owners.buyer:id/school_info_student_grade_range");
	public By pdpSchoolInfoDistance = By.id("com.owners.buyer:id/school_info_student_distance");
	public By pdpViewAllSchools = By.id("com.owners.buyer:id/property_details_view_all_schools");
	public By pdpSchoolDataSource = By.id("com.owners.buyer:id/tv_data_source");
	public By pdpSchooDeatilslListHeader = By.id("com.owners.buyer:id/property_features_title_text_view");
	public By pdpSchoolListBackButton = By.id("com.owners.buyer:id/property_school_district_info_back_button");
	public By pdpSchoolDialogueTittle = By.id("com.owners.buyer:id/alertTitle");
	public By pdpSchoolDialogueDescription = By.id("android:id/message");
	public By pdpSchoolDialogueOK = By.id("android:id/button1");
	public By chromeURLBar = By.id("com.android.chrome:id/url_bar");
	public By SchoolRating = By.id("com.owners.buyer:id/school_info_rating");
	public By SchoolGrading = By.id("com.owners.buyer:id/school_info_student_grade_range");
	public By collapseButton = By.id("com.owners.buyer:id/collapse_Button");
	public By pdpHeaderAddress = By.id("com.owners.buyer:id/property_details_title_text_view");

	// ----EMP Section----//
	public By estimatedTotalValue = By.id("com.owners.buyer:id/estimated_total_value");
	public By empInfo = By.id("com.owners.buyer:id/estimated_info_img");
	public By empInfoMessage = By.id("android:id/message");
	public By empMessageClose = By.id("android:id/button1");
	public By empPrincipleValue = By.id("com.owners.buyer:id/estimated_principal_value");
	public By empTaxValue = By.id("com.owners.buyer:id/estimated_tax_value");
	public By empSource = By.id("com.owners.buyer:id/estimated_tax_source");
	public By empHOADues = By.id("com.owners.buyer:id/estimated_hoa_dues");
	public By empCustomizeCalculator = By.id("com.owners.buyer:id/customize_calculator");
	public By propertyTaxValue = By.id("com.owners.buyer:id/property_details_tax_value");
	public By empCalculatorIconOnPdp = By.id("com.owners.buyer:id/property_item_payments_text_view");
	public By empSectionTaxEditor = By.id("com.owners.buyer:id/property_payments_tax_edit_text");

	// ----other sections---//
	public By MakeAnOffer = By.xpath("//*[@text='Make an Offer']");
	public By askQuestions = By.xpath("//*[@text='Ask a Question']");
	public By NotifyMeOption = By.id("com.owners.buyer:id/property_details_section_title_info");
	public By NotifyMeMessage = By.id("android:id/message");
	public By NotifyMessageClose = By.id("android:id/button1");
	public By EstimateCommute = By.id("com.owners.buyer:id/property_details_icon_title_text_view");
	public By EstimateCommuteSearchBar = By.id("com.owners.buyer:id/commute_destination_text_view");
	public By CommuteDurationTime = By.id("com.owners.buyer:id/commute_duration_text_view");
	public By GetDirectionsButton = By.id("com.owners.buyer:id/commute_directions_button");
	public By GoogleMap = By.id("com.google.android.apps.maps:id/home_bottom_sheet_container");
	public By ActualEMPprice = By.id("com.owners.buyer:id/estimated_total_value");
	public By CustomizeCalculations = By.id("com.owners.buyer:id/customize_calculator");
	public By ExpectedEMPprice = By.id("com.owners.buyer:id/property_payments_title_text_view");
	public By DownPaymentPlusButton = By.id("com.owners.buyer:id/property_payments_title_text_view");
	public By InterestDecreaseButton = By.id("com.owners.buyer:id/property_payments_decrease_interest");
	public By pdpPropertyShareIcon = By.id("com.owners.buyer:id/property_details_share_button");
	public By ShareViaScreen = By.id("android:id/title");
	public By pdpMapIcon = By.id("com.owners.buyer:id/property_current_location");
	public By pdpMapLoaded = By.id("com.owners.buyer:id/bt_map");
	public By FooterText = By.id("com.owners.buyer:id/property_footer_text_view");
	public By RequestInfo = By.id("com.owners.buyer:id/request_info_button");
	public By propertyDetail = By.id("com.owners.buyer:id/property_item_address_text_view");
	public By RequestTourTile = By.id("com.owners.buyer:id/tour_quick_date_day_of_month");
	public By DayTile = By.id("com.owners.buyer:id/tour_quick_date_month");
	public By pdpFaceBook = By.xpath("//android.widget.TextView[text()='Facebook']");
	public By pdpTweet = By.xpath("//*[text()='Tweet']");
	public By pdpWhatsapp = By.xpath("//*[text()='WhatsApp']");
	public By sharePanel = By.id("android:id/resolver_list");
	public By SwipePrice = By.id("com.owners.buyer:id/search_card_price_text_view");
	public By dateField = By.id("com.owners.buyer:id/property_quick_book_tour_list");
	public By MapProperty = By.xpath("//android.view.View[@index='1']");
	public By SqftToolTipIcon = By.id("com.owners.buyer:id/property_item_sqft_info");
	public By SqftToolTipMessage = By.id("android:id/message");
	public By RequestTourHeader = By.id("com.owners.buyer:id/property_details_section_title_text_view");

	// Make an offer form fields
	public By OfferFirstName = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/TextInputLayout[1]/android.widget.FrameLayout/android.widget.EditText");
	public By OfferLastName = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/TextInputLayout[2]/android.widget.FrameLayout/android.widget.EditText");
	public By OfferEmail = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/TextInputLayout");
	public By OfferPhone = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[3]/android.widget.LinearLayout/TextInputLayout/android.widget.FrameLayout/android.widget.EditText");
	public By OfferMoney = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/TextInputLayout/android.widget.FrameLayout/android.widget.EditText");
	public By AllCashOption = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");
	public By BackButton = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
	public By NextButton = By.id("com.owners.buyer:id/page_navigation_next");

	// Ask A Question Form
	public By AskFirstName = By.xpath(
			"hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/TextInputLayout[1]/android.widget.FrameLayout/android.widget.EditText");
	public By AskLastName = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/TextInputLayout[2]/android.widget.FrameLayout/android.widget.EditText");
	public By AskEmail = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/TextInputLayout/android.widget.FrameLayout/android.widget.EditText");
	public By AskFooterDeatils = By.id("com.owners.buyer:id/contact_seller_message_edit_text");

	// ----Profile Notification Section----//
	public By profileNotification = By.xpath("*//android.widget.TextView[5]");
	public By favoriteNotificationToggle = By.id("com.owners.buyer:id/notification_toggle_switch");

	// ---Mortagage Calculator---//
	public By MortagageCalculatorPropertyPrice = By.id("com.owners.buyer:id/property_payments_price_edit_text");
	public By MortagageCalculator15YearLoanType = By.id("com.owners.buyer:id/payments_selection_item_15fixed");
	public By MortagageCalculator30yearLoanType = By.id("com.owners.buyer:id/payments_selection_item_30fixed");
	public By interestRate = By.id("com.owners.buyer:id/property_payments_interest_edit_text");
	public By MortagageDisclaimer = By.id("com.owners.buyer:id/property_estimate_disclaimer");
	public By DownPayment = By.id("com.owners.buyer:id/property_payments_down_edit_text");
	public By empHoaValueCalculator = By.id("com.owners.buyer:id/property_payments_hoa_edit_text");
	public By DPincrease = By.id("com.owners.buyer:id/property_payments_increase_down");
	public By InterestIncrease = By.id("com.owners.buyer:id/property_payments_increase_interest");

	// ---Comments Section---//
	public By commentOne = By.xpath("//android.widget.TextView[contains(text(),'!@##$$%%%')]");
	public By commentTwo = By.xpath("//android.widget.TextView[contains(text(),'123456789')]");
	public By commentThree = By.xpath("//android.widget.TextView[contains(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ')]");

	// Request Form
	public By FirstNameErrorText = By.xpath("*//android.widget.LinearLayout[1]//android.widget.TextView");
	public By LastNameErrorText = By.xpath("*//android.widget.LinearLayout[1]//android.widget.TextView");
	public By EmailErrorText = By.xpath(
			"*//TextInputLayout[1]//android.widget.FrameLayout//android.widget.LinearLayout[1]//android.widget.TextView");
	public By PhoneErrorText = By.xpath(
			"*//TextInputLayout[1]//android.widget.FrameLayout//android.widget.LinearLayout[1]//android.widget.TextView");

	// SavedSearch
	public By SavedSearchLocation = By.id("com.owners.buyer:id/search_title");

	// Estimate My commute
	public By ArriveBy = By.id("com.owners.buyer:id/commute_arrive_by_view");
	public By DepartAt = By.id("com.owners.buyer:id/commute_depart_at_text_view");
	public By ArriveAndLeaveTime = By.id("com.owners.buyer:id/commute_arrival_time_text_view");
	public By AnalogClock = By.id("com.owners.buyer:id/commute_clock_view");
	public By InputTime = By.id("com.owners.buyer:id/commute_time_text_view");
	public By SelectTime = By.xpath("//*[@index='6']");
	public By DestinationCommuteTime = By.id("com.owners.buyer:id/property_details_icon_subtitle_text_view");
	public By CommuteMessage = By.id("com.owners.buyer:id/commute_average_time_text_view");
	public By AddressNotPublic = By.xpath("//*[@text='$575,000']");
	public By AddressField = By.id("com.owners.buyer:id/commute_starting_point_text_view");

	// Price History
	public By PriceHistoryDate = By.id("com.owners.buyer:id/sale_history_date");
	public By EventSold = By.xpath("//*[@text='Sold']");
	public By DateColumn = By.xpath("//*[@text='Date']");
	public By EventColumn = By.xpath("//*[@text='Event']");
	public By PriceColumn = By.xpath("//*[@text='Price']");
	public By PriceSource = By.id("com.owners.buyer:id/property_sale_history_source");

	// Contact Seller
	public By ContactSeller = By.id("com.owners.buyer:id/property_details_call_to_action_text_view");
	public By ContactSellerTnC = By.id("com.owners.buyer:id/phone_consent_text_view");

	// PDP map view
	public By pdpMapViewAddress = By.id("com.owners.buyer:id/property_details_map_address");
	public By sateliteButton = By.id("com.owners.buyer:id/bt_satellite");
	public By streetViewButton = By.id("com.owners.buyer:id/bt_street_view");
	public By getDirectionButton = By.id("com.owners.buyer:id/property_get_direction_title");
	public By pinInMapView = By.xpath("//android.view.View[@content-desc=\"Google Map\"]//android.view.View");
	public By mapContainer = By.id("com.google.android.apps.maps:id/compass_container");
	public By getDirectionBackButton = By
			.xpath("//android.widget.FrameLayout[@content-desc=\"Navigate up\"]//android.widget.ImageView");
	public By streetViewBackButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");

	// Get Direction CTA
	public By pdpGetDirectionText = By.id("com.owners.buyer:id/property_get_direction_title");
	public By pdpGetDirectionAddress = By.id("com.owners.buyer:id/property_get_direction_sub_title");
}
