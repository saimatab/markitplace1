package Track_Orders;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Orders {
	
	public WebDriver driver ;
	
	By Downloads = By.xpath("//a[@class='action-icon icon-download']");
	By email = By.xpath("//*[@id=\"track-orders\"]/section/div/div/div[1]/span/a[2]");
	By emailtxtbox=By.xpath("//input[@name='email_addresses']");
	By SndBtn=By.xpath("//button[@class='btn btn-primary']");
	By emailDialog=By.xpath("(//div[@class='modal-content'])[7]");
	By RequestReturnBtn = By.xpath("//a[@id='returnRequestlBtn']");
	By ReturnPopup=By.xpath("(//div[@role='document'])[2]");
	By ReturnTextbox=By.xpath("//textarea[@id='requestDetail']");
	By ReturnTextEmail=By.xpath("//input[@id='email']");
	
	
	By SubmitReturn=By.xpath("//a[@id='submit-return-btn']");
	By ReturnConfirmClose=By.xpath("(//button[@class='btn btn-default close-mdl'])[3]");
	By ReturnConfirmPopup=By.xpath("(//div[@class='modal-dialog'])[3]");
	By BuyItemAgainBtn=By.xpath("//a[@data-order-id='12480141']");
	By BuyItemAgainPopupClose=By.xpath("(//button[@class='mfp-close'])[1]");
	By BuyItemAgainPopup=By.xpath("(//div[@class='modal-content'])[4]");
	By ViewInvoiceBtn = By.xpath("(//a[@class='btn view-orders hide-for-print'])[1]");
	By DaysDropDown=By.xpath("//select[@title='Select Time Period']");
	By Plus1st=By.xpath("(//a[@class='btn-expand-content'])[1]");
	By ReqReturn1st=By.xpath("(//a[@class='btn rma-btn'])[1]");
	By ReturnTextBox1=By.xpath("//textarea[@id='_requestDetail']");
	By ReqReturnSubmitBtn=By.id("submit-return-btn");
	By RmaCloseBtn=By.xpath("//button[text()='Submit Return Request']");
	By RmaCloseBtn1=By.xpath("(//button[text()='Close'])[1]");
	By BuyItemAgain1=By.xpath("(//a[contains(text(),'Buy Item(s) Again')])[1]");
	By BuyItemClose=By.xpath("(//button[@title='Close (Esc)'])[4]");
	By LoadMoreBtn=By.xpath("//button[text()='Load More']");
	By RowRecord=By.xpath("//a[@class='btn-expand-content']");
	By DateRecord=By.xpath("//div[@class='title-row']/div[1]/div[2]/p");
	By BuyAgainBtn=By.xpath("//a[@class='btn buy-again']");
	By getOrderLink=By.xpath("//*[@class='top-space clearfix']//a[text()='Create Order']");
	By PlaceOrderDownButton=By.xpath("//*[@id='checkout-control']//div[@class='step-action btn-place-order-con']/a[contains(text(),'Place Order')]");
	By EditQuote=By.xpath("//*[@class='top-space clearfix']//a[text()='Edit Quote']");
	By ViewOrderBtn=By.xpath("//*[@class='order-container container clearfix']//li[1]//a[contains(text(),'View order')]");
	By ShippedOredrs = By.xpath("//*[@class='order-container container clearfix']//li[1]//span[contains(text(),'Shipped')]");
	By BuyAgain = By.xpath("//*[@class='order-container container clearfix']//li[1]//div[@class='action-area clearfix']//a[@class='btn buy-again']");
	By SearchOrder= By.xpath("//*[@id='quick-finder-form']/input");
	By ViewFullHistort = By.xpath("//*[@id='order-top']//a[@class='full-order-history']");
	
	
	public WebElement GetViewFullHistort()
	{
		return driver.findElement(ViewFullHistort);
	}
	
	
	public WebElement SearchOrder()
	{
		return driver.findElement(SearchOrder);
	}
	
	
	public WebElement GetBuyAgains()
	{
		return driver.findElement(BuyAgain);
	}
	
	
	public WebElement GetShippedOredrs()
	{
		return driver.findElement(ShippedOredrs);
	}
	
	
	public WebElement GetViewOrderBtn()
	{
		return driver.findElement(ViewOrderBtn);
	}
	
	public WebElement ClickEditQuote()
	{
		return driver.findElement(EditQuote);
	}
	
	public WebElement ClickPlaceOrder()
	{
		return driver.findElement(PlaceOrderDownButton);
	}
	
	
	public WebElement getOrder()
	{
		return driver.findElement(getOrderLink);
	}
	
	public WebElement getBuyAgainBtn()
	{
		return driver.findElement(BuyAgainBtn);
	}
	
	public List<WebElement> getDateRecordCount()
	{
		return driver.findElements(DateRecord);
	}
		
	public List<WebElement> getRowRecordCount()
	{
		return driver.findElements(RowRecord);
	}
		
	public WebElement getLoadMoreBtn()
	{
		return driver.findElement(LoadMoreBtn);
	}
	
	public WebElement getBuyItemClose()
	{
		return driver.findElement(BuyItemClose);
	}
	public WebElement getBuyItemAgain1()
	{
		return driver.findElement(BuyItemAgain1);
	}
	public WebElement getRmaCloseBtn()
	{
		return driver.findElement(RmaCloseBtn);
	}
	public WebElement getRmaCloseBtn1()
	{
		return driver.findElement(RmaCloseBtn1);
	}
	public WebElement getReqReturnSubmitBtn()
	{
	return driver.findElement(ReqReturnSubmitBtn);
	}
	public WebElement getReturnTextBox1()
	{
		return driver.findElement(ReturnTextBox1);
	}
	
	public WebElement getReqReturn1st()
	{
		return driver.findElement(ReqReturn1st);
	}
	public boolean isElementPresent(By locatorKey) {
	    try {
	        driver.findElement(locatorKey);
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
	
	public WebElement getPlus1st()
	{
		return driver.findElement(Plus1st);
	}
	
	public WebElement getDaysDropDown()
	{
		return driver.findElement(DaysDropDown);
	}
	
	public WebElement getReturnConfirmPopup()
	{
		return driver.findElement(ReturnConfirmPopup);
	}
	
	public WebElement getViewInvoiceBtn()
	{
		return driver.findElement(ViewInvoiceBtn);
	}
	
	public WebElement getBuyItemAgainPopup()
	{
		return driver.findElement(BuyItemAgainPopup);
	}
	public WebElement getBuyItemAgainPopupClose()
	{
		return driver.findElement(BuyItemAgainPopupClose);
	}
	
	public WebElement getBuyItemAgainBtn()
	{
		return driver.findElement(BuyItemAgainBtn);
	}
	
	public WebElement getReturnConfirmClose()
	{
		return driver.findElement(ReturnConfirmClose);
	}
	
	
	public WebElement getSubmitReturn()
	{
		return driver.findElement(SubmitReturn);
	}
	
	
	public WebElement getReturnTextbox()
	{
		return driver.findElement(ReturnTextbox);
	}
	
	public WebElement getReturnEmail()
	{
		return driver.findElement(ReturnTextEmail);
	}
	
	public WebElement getReturnPopup()
	{
		return driver.findElement(ReturnPopup);
	}
	
	
	public WebElement getRequestReturnBtn()
	{
		return driver.findElement(RequestReturnBtn);
	}
	
	public WebElement getemailDialog()
	{
		return driver.findElement(emailDialog);
	}
	
	public Orders(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement getDownloads()
	{
		return driver.findElement(Downloads);
	}
	
	public WebElement getemail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getemailtxtbox()
	{
		return driver.findElement(emailtxtbox);
	}
	
	public WebElement getSndBtn()
	{
		return driver.findElement(SndBtn);
	}
}