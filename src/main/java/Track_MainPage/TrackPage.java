package Track_MainPage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TrackPage {
	public WebDriver driver ;
	
	public TrackPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	
	By SearchBox = By.xpath("//input[@name='terms']");
	
	By QuoteExpnd=By.xpath("(//a[@class='btn-expand'])[5]");
	
	By CalendarDiv = By.xpath("//*[@id='track-dashboard']/div[1]/div/div[1]/div[3]/div");
	By QuickFinder= By.xpath("//input[@class='quick-search']");
	By CalendarBtn=By.linkText("Calendar");
	By ReportsBtn=By.linkText("Reports");
	By OrdersBtn=By.linkText("Orders");
	By Purchase_Analysis_Btn=By.linkText("Purchase Analysis");
	By SavedReports=By.xpath("//a[@class='my-reports']");
	By View_Full_Calendar=By.linkText("View full calendar");
	By AllOrdersLink=By.linkText("See all orders");
	By SeeAllQuotes=By.linkText("See all quotes");
	By FooterTxt=By.xpath("//div[@class='alert alert-info permission-box']");
	By Notification_Section = By.xpath("(//div[@class='alert alert-info permission-box'])[1]");
	By Calendar_Section = By.xpath("(//div[@class='alert alert-info permission-box'])[2]");
	By BackBtn=By.xpath("(//a[text()=' Back'])[1]");
	By QuoteTab=By.xpath("(//a[text()='Quotes'])[3]");
	By SearchRslt=By.xpath("//div[@class='alert alert-info permission-box']");
	By Shop = By.xpath("(//a[text()='Shop'])[1]");
	By ROrderSect=By.xpath("(//div[@class='alert alert-info permission-box'])[1]");
	By RQuotesSec=By.xpath("(//div[@class='alert alert-info permission-box'])[2]");
	By DisEditQuote=By.xpath("(//a[@class='btn disabled tt-wrapper' and @alt='Edit Quote'])[1]");
	By DisDelQuote=By.xpath("(//a[@class='btn disabled tt-wrapper' and @alt='Delete Quote'])[1]");
	By QuoteDetails=By.xpath("//a[text()='Quote details' and @class='order-link']");
	By Disbl_CreateOrdr=By.xpath("(//a[@class='btn disabled tt-wrapper'])[1]");

	//By Day2ShipRpt=By.xpath("(//a[text()='Days to Ship'])[2]");

	By Day2ShipRpt=By.xpath("//ul[@class='column']//a[contains(text(),'Days to Ship')]");
	
	
	By AssetLnk=By.xpath("(//a[text()='Assets'])[3]");
	
	
	By ReqReturnPopup=By.xpath("(//div[@role='document'])[1]");
	
	By TrackBuyItemAgain=By.xpath("//a[@class='btn buy-again']");
	
	By TrackReturnConfirmclose=By.xpath("(//button[@class='btn btn-default'])[2]");
	
	By TrackReturnConfirmdialog=By.xpath("(//div[@class='modal-dialog'])[2]");
	
	By TrackRequestSubmitBtn=By.xpath("//button[@id='submit-return-btn']");
	
	By TrackRequestTextBox=By.xpath("//textarea[@id='requestDetail']");
	By TrackRequestTextBox1=By.xpath("//textarea[@id='_requestDetail']");
			
	By RequestReturnTrack=By.xpath("//a[@class='btn rma-btn']");
	By conditionDropDown=By.id("_condition");
	By ExpandIcon=By.xpath("(//a[@class='btn-expand-content'])[2]");
	
	By SearchResult=By.xpath("(//li[@class='accordion-list-item order-item'])[1]");
	
	By ViewOrder=By.xpath("//a[@href='order-detail/12480141']");
	By Circle1=By.xpath("(//span[@class='month'])[1]");
	By Link1=By.xpath("(//li[@class='darkblue'])[1]");
	By CloseBtn=By.xpath("(//button[@class='mfp-close'])[1]");
	By BuyItAgain=By.xpath("(//a[@class='btn buy-again'])[1]");

	By ReportBtn1=By.xpath("//a[text()='Reports']");

	///By BuyItemAgainPopup=By.xpath("(//div[@class='modal-content'])[4]");
	By BuyItemAgainPopup=By.xpath("//div[@id='cart-dialog']//div[@class='modal-content']");
	
	//By BuyItemAgainPopupClose=By.xpath("(//button[@class='mfp-close'])[1]");
	
	By BuyItemAgainPopupClose=By.xpath("//div[@id='cart-dialog']//button[@class='mfp-close']");
	
	By LoadMoreBtn=By.xpath("//button[text()='Load More']");
	By QuotesBtn=By.xpath("(//span[@class=''])[1]");
	By QuotesExpand=By.xpath("(//a[@class='btn-expand-content'])[1]");
	By CreateOrderBtn=By.xpath("//a[text()='Create order']");
	By CreateOrderClose=By.xpath("(//button[text()='Close'])[2]");
	By CreateOrderPopup = By.xpath("(//div[@class='modal-dialog'])[3]");
	By AssetBtn=By.xpath("//button[@class='btn btn-primary' and text()='Assign']");
	By radio1=By.xpath("//label[contains(text(),'Assign to existing user')]");
	By radio2=By.xpath("//label[contains(text(),'Assign to new user')]");
	
	By select=By.xpath("//ul[@id='user-select']//li[contains(text(),'23606, Joe Althaus, jalthaus@moredirect.com')]");
	
	
	//ul[@id='user-select']
	By AssetBtn1=By.xpath("//span[contains(text(),'Assets')]");
	By RecordExpandIcon=By.xpath("//a[text()='+']");
	By SearchText=By.xpath("//div[@class='search-matching-container']");
	By RptDropdown=By.xpath("(//i[@class='fa fa-caret-down'])[1]");
	//By VwAssetDetail=By.xpath("//a[text()='View Asset Details']");
	
	By VwAssetDetail=By.xpath("//div[@class='td-option-drop-wrapper show-for-tablet']//div[@class='td_option_drop reports-show-more']//div//a[contains(text(),'View Asset Details')]");
	
	
	
	
	
	By ReAssignBtn=By.xpath("//a[text()='Reassign Asset']");
	//By AssignBtn=By.xpath("//button[text()='Assign']");
	By AssignBtn=By.xpath("//a[@class='btn assign-asset']");

	By RetireAsset=By.xpath("//a[text()='Retire Asset']");
	By postRetireAsset=By.xpath("//a[text()='Un-retire and Assign Asset']");
	By AssetHistoryItem=By.xpath("//span[text()='Date:']");
	By UnRetireBtn=By.xpath("//a[text()='Un-retire and Assign Asset']");
	By HistoryText=By.xpath("//h2[@class='section-title' and text()='Asset History']");
	By ReportRegexp=By.xpath("//a[contains(@href,'/track/reports')]");
	By OrdersTab=By.xpath("//span[contains(text(),'Orders')]");
	By ReqOrderNum=By.xpath("//p[contains(text(),'#10360018')]");
	By Plus1st=By.xpath("(//a[@class='btn-expand-content'])[1]");
	By ReturnTextEmail=By.xpath("//input[@id='_email']");
	public WebElement getDisbl_CreateOrdr()
	{
		return driver.findElement(Disbl_CreateOrdr);
	}
	
	public WebElement getReturnEmail()
	{
		return driver.findElement(ReturnTextEmail);
	}
	public WebElement getPlus1st()
	{
		return driver.findElement(Plus1st);
	}
	public WebElement getSearchBox()
	{
		return driver.findElement(SearchBox);
	}
	public WebElement getselect()
	{
		return driver.findElement(select);
	}
	public WebElement getConditionDropDown()
	{
		return driver.findElement(conditionDropDown);
	}
	public WebElement getQuoteDetails()
	{
		return driver.findElement(QuoteDetails);
	}
	
	public WebElement getDisEditQuote()
	{
		return driver.findElement(DisEditQuote);
	}
	
	public WebElement getDisDelQuote()
	{
		return driver.findElement(DisDelQuote);
	}
	
	public WebElement getQuoteExpnd()
	{
		return driver.findElement(QuoteExpnd);
	}
	
	public WebElement getROrderSect()
	{
		return driver.findElement(ROrderSect);
	}
	public WebElement getRQuotesSec()
	{
		return driver.findElement(RQuotesSec);
	}
	
	public WebElement getShop()
	{
		return driver.findElement(Shop);
	}
	
	public WebElement getSearchRslt()
	{
		return driver.findElement(SearchRslt);
	}
	
	public WebElement getQuoteTab()
	{
		return driver.findElement(QuoteTab);
	}
	
	
	
	public WebElement getBackBtn()
	{
		return driver.findElement(BackBtn);
	}
	
	public WebElement getNotification_Section()
	{
		return driver.findElement(Notification_Section);
	}
	public WebElement getCalendar_Section()
	{
		return driver.findElement(Calendar_Section);
	}
	
	public WebElement getFooterTxt()
	{
		return driver.findElement(FooterTxt);
	}
	
	public WebElement getQuickFinder()
	{
		return driver.findElement(QuickFinder);
	}
	
	public WebElement getCalendarBtn()
	{
		return driver.findElement(CalendarBtn);
	}
	public WebElement getReportsBtn()
	{
		return driver.findElement(ReportsBtn);
	}
	
	public WebElement getOrdersBtnBtn()
	{
		return driver.findElement(OrdersBtn);
	}
	
	public WebElement get_Purchase_Analysis_BtnBtn()
	{
		return driver.findElement(Purchase_Analysis_Btn);
	}
	
	public WebElement getSavedReports()
	{
		return driver.findElement(SavedReports);
	}
	
	public WebElement getView_Full_Calendar()
	{
		return driver.findElement(View_Full_Calendar);
	}
	
	public WebElement getAllOrdersLink()
	{
		return driver.findElement(AllOrdersLink);
	}
	
	public WebElement getSeeAllQuotes()
	{
		return driver.findElement(SeeAllQuotes);
	}
	
	public WebElement getCalendarDiv()
	{
		return driver.findElement(CalendarDiv);
	}
	
	public WebElement getReportBtn1()
	{
		return driver.findElement(ReportBtn1);
	}
	
	public WebElement getReqOrderNum()
	{
		return driver.findElement(ReqOrderNum);
	}
	
	public WebElement getOrdersTab()
	{
		return driver.findElement(OrdersTab);
	}
	
	public WebElement getDay2ShipRpt()
	{
		return driver.findElement(Day2ShipRpt);
	}
		
	public List<WebElement> getReportRegexpCount()
	{
		return driver.findElements(ReportRegexp);
	}	
	public List<WebElement> getHistoryTextCount()
	{
		return driver.findElements(HistoryText);
	}	
			
	public WebElement getUnRetireBtn()
	{
		return driver.findElement(UnRetireBtn);
	}
	
	public List<WebElement> getUnRetireBtnCount()
	{
		return driver.findElements(UnRetireBtn);
	}
	
	public List<WebElement> getAssetHistoryItem()
	{
		return driver.findElements(AssetHistoryItem);
	}
	
	public List<WebElement> getpostRetireAssetCount()
	{
		return driver.findElements(postRetireAsset);
	}
	
	public List<WebElement> getRetireAssetCount()
	{
		return driver.findElements(RetireAsset);
	}
	
	public WebElement getRetireAsset()
	{
		return driver.findElement(RetireAsset);
	}
	
	public WebElement getAssignBtn()
	{
		return driver.findElement(AssignBtn);
	}
	
	public WebElement getReAssignBtn()
	{
		return driver.findElement(ReAssignBtn);
	}
	
	public List<WebElement> getReAssignBtnCount()
	{
		return driver.findElements(ReAssignBtn);
	}
	
	
	public WebElement getVwAssetDetail()
	{
		return driver.findElement(VwAssetDetail);
	}
	
	public WebElement getRptDropdown()
	{
		return driver.findElement(RptDropdown);
	}
	
	public WebElement getAssetLnk()
	{
		return driver.findElement(AssetLnk);
	}
	
	public WebElement getSearchText()
	{
		return driver.findElement(SearchText);
	}
	
	public List<WebElement> getRecordExpandIcon()
	{
		return driver.findElements(RecordExpandIcon);
	}
	
	
	public WebElement getReqReturnPopup()
	{
		return driver.findElement(ReqReturnPopup);
	}
	
	public WebElement getAssetBtn()
	{
		return driver.findElement(AssetBtn);
	}
	public WebElement getradio1()
	{
		return driver.findElement(radio1);
	}
	public WebElement getradio2()
	{
		return driver.findElement(radio2);
	}
	public WebElement getAssetBtn1()
	{
		return driver.findElement(AssetBtn1);
	}
	
	
	public WebElement getCreateOrderPopup()
	{
		return driver.findElement(CreateOrderPopup);
	}
	
	public WebElement getCreateOrderClose()
	{
		return driver.findElement(CreateOrderClose);
	}
	
	public WebElement getCreateOrderBtn()
	{
		return driver.findElement(CreateOrderBtn);
	}
	
	
	public WebElement getQuotesExpand()
	{
		return driver.findElement(QuotesExpand);
	}
	
	public WebElement getQuotesBtn()
	{
		return driver.findElement(QuotesBtn);
	}
	
	public WebElement getLoadMoreBtn()
	{
		return driver.findElement(LoadMoreBtn);
	}
	
	public WebElement getBuyItemAgainPopupClose()
	{
		return driver.findElement(BuyItemAgainPopupClose);
	}
	
	public WebElement getBuyItemAgainPopup()
	{
		return driver.findElement(BuyItemAgainPopup);
	}
	
	public WebElement getTrackBuyItemAgain()
	{
		return driver.findElement(TrackBuyItemAgain);
	}
	
	public WebElement getTrackReturnConfirmclose()
	{
		return driver.findElement(TrackReturnConfirmclose);
	}
		
	public WebElement getTrackReturnConfirmdialog()
	{
		return driver.findElement(TrackReturnConfirmdialog);
	}
	
	public WebElement getTrackRequestSubmitBtn()
	{
		return driver.findElement(TrackRequestSubmitBtn);
	}
	
	
	public WebElement getTrackRequestTextBox()
	{
		return driver.findElement(TrackRequestTextBox);
	}
	
	public WebElement getTrackRequestTextBox1()
	{
		return driver.findElement(TrackRequestTextBox1);
	}
	
	
	public WebElement getRequestReturnTrack()
	{
		return driver.findElement(RequestReturnTrack);
	}
	
	public WebElement getExpandIcon()
	{
		return driver.findElement(ExpandIcon);
	}
	
	
	public List<WebElement> getSearchResultCount()
	{
		return driver.findElements(SearchResult);
	}
	
	public WebElement getViewOrder()
	{
		return driver.findElement(ViewOrder);
	}
	
	
	public WebElement getCircle1()
	{
		return driver.findElement(Circle1);
	}
	
	public WebElement getLink1()
	{
		return driver.findElement(Link1);
	}
	
	public WebElement getCloseBtn()
	{
		return driver.findElement(CloseBtn);
	}
	
	public WebElement getBuyItAgain()
	{
		return driver.findElement(BuyItAgain);
	}
	
	
}
