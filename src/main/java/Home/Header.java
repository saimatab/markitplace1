package Home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {

	public WebDriver driver;

	public Header(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By HeadLogo = By.xpath("//img[@class='logo']");
	By Searchbox = By.xpath("//input[@id='x_main-search']");

//By CartIcon=By.xpath("//span[@class='notify-badge']");
	By CartIcon = By.xpath("//div[@class='shopping-cart']//a");

//By CartIcon=By.xpath("//*[@id='top-header']/section/div[3]/div[2]/a");
	By FavrtIcon = By.xpath("//a[@class='my-lists' and text()='Favorites']");
//By TrackBtn=By.className("track ");
//By TrackBtn=By.xpath("//a[@class='track active ']");

	By TrackBtn = By.linkText("TRACK");
	By ShopBtn = By.linkText("SHOP");

//By TrackBtnFF=By.xpath("(//a[text()='Track'])[1]");

	By TrackBtnFF = By.xpath("(//a[text()='Track'])[1]");

//By OrderBtn=By.xpath("(//a[@class='top-link'])[4]");

	By OrderBtn = By.linkText("Orders");

	By QuoteBtn = By.xpath("(//a[@class='top-link'])[5]");
	By PARBtn = By.linkText("PARs");

	By Calendar = By.xpath("(//a[@class='top-link'])[1]");
//By PAnalysisBtn=By.xpath("(//a[@class='top-link'])[4]");
//By Reports=By.xpath("(//a[@class='top-link'])[2]");
	By Reports = By.xpath("//a[@class='top-link'][contains(text(),'Reports')]");

	By track = By.xpath(
			"(//div[contains(@class,'homepage-nav-item-container')]//a[contains(@class,'')][contains(text(),'Track')]");

	By PAnalysisBtn = By.xpath("//a[@class='top-link'][contains(text(),'Purchase Analysis')]");
	By Logo = By.xpath("//img[@class='logo']");
	By StanCatalogLink = By.xpath("//a[@class='top-link'][contains(text(),'Standards Catalog')]");
	By AllProductLink = By.xpath("//a[@class='top-link'][contains(text(),'All Products')]");
	By Resources = By.xpath("//a[@class='top-link'][contains(text(),'Resources')]");
//a[@class='top-link'][contains(text(),'Resources')]
//By Resources=By.xpath("(//a[@class='top-link'])[3]");
	By SpecialOffers = By.xpath("//a[@class='top-link'][contains(text(),'Special')]");
	By brand = By.xpath("//a[@class='top-link'][contains(text(),'Brands')]");
	By BellIcon = By.xpath("//a[@class='icon-bell']");
	By InternationalIcon = By.linkText("International");
	By CommunityIcon = By.linkText("Community");
	By HelpIcon = By.linkText("Help");
	By LegacyLink = By.xpath("//html/body/nav[2]/div/div[2]/a[5]");
	By MyAccountLink = By.xpath("//span[@class='account-title']");
	By ShippingAddressLink = By.linkText("Shipping Addresses");
	By MyProfileLink = By.linkText("My Profile");
	By logoutLink = By.linkText("My Profile");
	By changepassword = By.linkText("Change Password");
	By changepwdtitle = By.xpath("//h1[contains(text(),'Reset Your Password')]");
	By ShopIcon = By.xpath("(//a[text()='Shop'])[1]");
	By QuoteLink = By.xpath("//a[@class='top-link' and text()='Quotes']");
	By Welcomepg = By.xpath("//*[@alt='Not Your Traditional Reseller: Maximize Efficiencies, Cut Costs, Save Time']");

	public WebElement getQuoteLink() {
		return driver.findElement(QuoteLink);
	}

	public WebElement getShopIcon() {
		return driver.findElement(ShopIcon);
	}

	public WebElement getTrackBtnFF() {
		return driver.findElement(TrackBtnFF);
	}

	public WebElement getReports() {
		return driver.findElement(Reports);
	}

	public WebElement getCalendar() {
		return driver.findElement(Calendar);
	}

	public WebElement getChangePassword() {
		return driver.findElement(changepassword);
	}

	public WebElement getPAnalysisBtn() {
		return driver.findElement(PAnalysisBtn);
	}

	public WebElement getbrands() {
		return driver.findElement(brand);
	}

	public WebElement getTrack() {
		return driver.findElement(track);
	}

	public WebElement getOrderBtn() {
		return driver.findElement(OrderBtn);
	}

	public WebElement getQuoteBtn() {
		return driver.findElement(QuoteBtn);
	}

	public WebElement getPARBtn() {
		return driver.findElement(PARBtn);
	}

	public WebElement getHeadLogo() {
		return driver.findElement(HeadLogo);
	}

	public WebElement getlogoutLinkLink() {
		return driver.findElement(logoutLink);
	}

	public WebElement getMyProfileLink() {
		return driver.findElement(MyProfileLink);
	}

	public WebElement getMyAccountLink() {
		return driver.findElement(MyAccountLink);
	}

	public WebElement getShippingAddressLink() {
		return driver.findElement(ShippingAddressLink);
	}

	public WebElement getResetTitle() {
		return driver.findElement(changepwdtitle);
	}

	public WebElement getsearchbox() {
		return driver.findElement(Searchbox);
	}

	public WebElement getCartIcon() {
		return driver.findElement(CartIcon);
	}

	public WebElement getFavrtIcon() {
		return driver.findElement(FavrtIcon);
	}

	public List<WebElement> getFavrtIconCount() {
		return driver.findElements(FavrtIcon);
	}

	public WebElement getTrackBtn() {
		return driver.findElement(TrackBtn);
	}

	By ParStatus = By
			.xpath("//*[@class='order-container container clearfix']//li[1]//span[contains(text(),'Pending')]");
	By PONumber = By.xpath("//*[@class='order-container container clearfix']//li[1]//*[@class='detail']");
	By getApproveBt = By
			.xpath("//*[@class='order-container container clearfix']//li[1]//a[contains(text(),'Approve')]");
	By getRejectBtn = By
			.xpath("//*[@class='order-container container clearfix']//li[last()-6]//a[contains(text(),'Reject')]");

	By PARAfterCreationClose = By.xpath("//*[@class='modal-footer deactivate_footer']//button");

	By GetpurchaseRequestStatus = By
			.xpath("//*[@class='order-container container clearfix']//li[1]//*[@class='order-info-links']");

	By GetParDate = By.xpath("//*[@class='top-space clearfix']//p[@class='update-date']");

	By GetPARstatus = By.xpath("//*[@class='small-12 columns row-margin top-15']//span[@class='approval approved']");

	By PARApprovalOrderDetail = By.xpath("//*[@class='inv-half-box']//p[1]");

	public WebElement PARApprovalOrderDetail() {
		return driver.findElement(PARApprovalOrderDetail);
	}

	public WebElement GetPARstatus() {
		return driver.findElement(GetPARstatus);
	}

	public WebElement GetParDate() {
		return driver.findElement(GetParDate);
	}

	public WebElement GetpurchaseRequestStatus() {
		return driver.findElement(GetpurchaseRequestStatus);
	}

	public WebElement PARAfterCreationClose() {
		return driver.findElement(PARAfterCreationClose);
	}

	public WebElement getPONumber() {
		return driver.findElement(PONumber);
	}

	public WebElement getApproveBtn() {
		return driver.findElement(getApproveBt);
	}

	public WebElement getRejectBtn() {
		return driver.findElement(getRejectBtn);
	}

	public WebElement ParStatus() {
		return driver.findElement(ParStatus);
	}

	public WebElement getShopBtn() {
		return driver.findElement(ShopBtn);
	}

	public WebElement getLogo() {
		return driver.findElement(Logo);

	}

	public WebElement getStanCatalogLink() {
		return driver.findElement(StanCatalogLink);

	}

	public WebElement getAllProductLink() {
		return driver.findElement(AllProductLink);

	}

	public String WelcomePage() {
		return driver.findElement(Welcomepg).getText();
	}

	public WebElement getResources() {
		return driver.findElement(Resources);

	}

	public WebElement getSpecialOffers() {
		return driver.findElement(SpecialOffers);

	}

	public WebElement getBellIcon() {
		return driver.findElement(BellIcon);

	}

	public WebElement getInternationalIcon() {
		return driver.findElement(InternationalIcon);

	}

	public WebElement getCommunityIcon() {
		return driver.findElement(CommunityIcon);

	}

	public WebElement getHelpIcon() {
		return driver.findElement(HelpIcon);

	}

	public WebElement getLegacyLink() {
		return driver.findElement(LegacyLink);

	}

}
