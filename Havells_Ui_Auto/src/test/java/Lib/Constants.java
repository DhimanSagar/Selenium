package Lib;

import org.openqa.selenium.By;

public final class Constants {

	//SingleProduct
	public static final By ITEM_TITLE = By.cssSelector("[data-slick-index=\"2\"] > .category_thumb");
	public static final By LLOYD_PORDUCT = By.xpath("//a[contains(text(),' Split Air Conditioner 1.5 (GLS18I52WBEL)')]");
	public static final By ZIPCODE = By.xpath("//input[contains(@id,'zipcode')]");
	public static final By CHECK_PINCODE = By.xpath("//button[contains(text(),'Check')]");
	public static final By ADDToCART= By.xpath("//body/section[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]");
	public static final By POPUP_ZIPCODE = By.cssSelector("#zipcode");
	public static final By ATC_POPUP = By.cssSelector("#addtocart_pincode > .btn");
	public static final By ATC_Icon = By.xpath("//img[contains(@src,'cart.jpg')]");
	public static final By CHECKOUT = By.cssSelector(".proceede_btn > .btn");
	public static final By Mobile_Number = By.cssSelector("#mobile");
	public static final By Send_OTP = By.cssSelector("#get_otp");
	public static final By LOGIN_OTP = By.cssSelector("#login_otp");
	public static final By Billing_Address_Continue = By.xpath("//div[contains(@id,'billing-buttons-container')][contains(.,'Continue')]");
	public static final By ShippingMethod = By.xpath("//div[@id='shipping-method-buttons-container']");
	public static final By PayUBizRadioButton = By.xpath("//label[contains(text(),'PayU Biz')]");
	public static final By PayMent_Information_Save = By.xpath("//div[contains(@id,'payment-buttons-container')]/button[@type='button']");
	public static final By CHECKOUT_LAST = By.xpath("//div[contains(@id,'review-buttons-container')]/button[@type='submit'] ");
	public static final By CardNumber = By.xpath("//input[contains(@name,'ccard_number')]");
	public static final By CardName = By.xpath("//input[contains(@name,'ccvv_number')]");
	public static final By CardMonth = By.xpath("//select[contains(@id,'cexpiry_date_month')]");
	public static final By CardYear = By.xpath("//select[contains(@id,'cexpiry_date_year')]");
	public static final By CVVNumber = By.xpath("//input[contains(@name,'ccvv_number')]");
	public static final By Booked = By.xpath("//div[contains(@class,'success_box')]");
	public static final By Switches = By.xpath("//a[contains(text(),'Switches')]");
	public static final By Accessories = By.xpath("//a[contains(text(),'Accessories')]");
	public static final By BidirectionalJumbo = By.xpath("//img[contains(@src,'0_287_3_7594.jpg')]");	
	
	//MultiProduct
	public static final By SearchBar = By.xpath("//input[@id='search']");
	public static final By MyAccount = By.xpath("//a[contains(text(),'Account')]");
	public static final By ViewDetails = By.xpath("//a[contains(text(),'View Details')]");
	public static final By Quantity =  By.xpath("//select[@id='qty']");
	public static final By Fan_Product =  By.xpath("//img[contains(@alt,\"Aureus\")]");
	
	
	//Coupon
	public static final By ApplyCoupon =  By.xpath("//button[contains(.,'Apply')]");
	public static final By ApplyGift = By.xpath("//body/section[2]/div[1]/div[2]/div[2]/div[2]/form[1]/button[1]");
	public static final By Coupon = By.xpath("//input[contains(@id,'coupon_code')]");
	public static final By Gift = By.xpath("//input[contains(@id,'giftcard_code')]");
	
	//AddnewAddress
	public static final By AddNewAddress = By.xpath("//a[contains(.,'Add New Address')]");
	public static final By NewUserFirstName = By.xpath("//input[contains(@id,'billing:firstname')]");
	public static final By NewUserLastName = By.xpath("//input[contains(@id,'billing:lastname')]");
	public static final By NewUserPhone = By.xpath("//input[contains(@id,'billing:telephone')]");
	public static final By NewUserZipcode = By.xpath("//input[contains(@id,'billing:post')]");
	public static final By NewUserCity = By.xpath("//input[contains(@title,'City')]");
	public static final By NewUserAddress = By.xpath("//input[contains(@id,'billing:street1')]");
	public static final By NewUserCountry = By.xpath("//select[contains(@id,'billing:region_id')]");
	public static final By NewUserSaveAddress = By.xpath(" //input[contains(@id,'billing:save_in_address_book')]");
	public static final By NewAdressSave = By.xpath("//button[contains(text(),'Save & Continue')]");
	public static final By ShiptoDifferent = By.xpath("//input[@id='billing:use_for_shipping_no']");
}
