package Track_Quotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuoteDetail {

	public WebDriver driver;

	public QuoteDetail(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By EditQuote = By.xpath("(//a[@class='btn btn-primary disabled q-d-disabled tt-wrapper'])[1]");
	By DelQuote = By.xpath("(//a[@class='btn btn-primary disabled q-d-disabled tt-wrapper'])[4]");

	By CreateOrder_Dsbl = By.xpath("(//a[@class='btn btn-primary disabled q-d-disabled tt-wrapper'])[1]");

	By Deletedsbl = By.xpath("(//a[@class='btn btn-primary disabled q-d-disabled tt-wrapper'])[2]");

	By Row_Plus = By.xpath("(//a[@class='btn-expand-content' and text()='+'])[1]");

	By GetViewQuoteLink = By
			.xpath("//*[@class='order-container container clearfix']/ul/li[1]//a[contains(text(),'View quote')]");

	By getTrackQuoteLink = By.xpath("");

	public WebElement getTrackQuote() {
		return driver.findElement(getTrackQuoteLink);
	}

	public WebElement GetViewQuote() {
		return driver.findElement(GetViewQuoteLink);
	}

	public WebElement getRow_Plus() {
		return driver.findElement(Row_Plus);
	}

	public WebElement getCreateOrder_Dsbl() {
		return driver.findElement(CreateOrder_Dsbl);
	}

	public WebElement getDeletedsbl() {
		return driver.findElement(Deletedsbl);
	}

	public WebElement getDelQuote() {
		return driver.findElement(DelQuote);
	}

	public WebElement getEditQuote() {
		return driver.findElement(EditQuote);
	}

	By QUOTEBtn = By.xpath(
			"//div[@class='sub-col-right cart-modal-btns']//li[@class='option'][contains(text(),'Create Quote')]");

	By ReplacementSystem = By.xpath("//select[@id='selectCustomField4903432']");

	By ApprovalGroup = By.xpath("//select[@title='Approval group']");

	By QuoteApprovalBtn = By.xpath(
			"//div[@class='cart-summary-buttons']//a[@class='btn btn-primary btn-save placeOrderBtn'][contains(text(),'Create Quote')]");

	By GetMessage = By.xpath("//*[@class='order-confirmation-container']//h3");

	By PoNum = By.xpath("//*[@class='order-confirmation-container']//span[@class='detail-info po-number blue']");

	By QuoteConfirmation = By.xpath("//*[@id='track-quotes']//div[@class='clearfix action-icon-container']/h2");

	By CreateParAftQuote = By
			.xpath("//*[@id='track-quotes']//*[@class='btn btn-default'][contains(text(),'Create PAR')]");

	By QuoteEdit = By.xpath("//*[@class='qts-dtls-edit clearfix']//a[text()='Edit']");
	By AddQty = By.xpath("//input[@class='qu_quentity hide-for-print']");
	By SaveQTY = By.xpath("//*[@class='qts-dtls-edit clearfix']//a[text()='Save']");
	By AddItemFromCart = By.xpath("//*[@class='top-space clearfix']//a[text()='Add Items from Cart']");
	By AddToQuote = By.xpath("//*[@class='modal-footer show-for-tablet']//a[contains(text(),'Add to Quote')]");
	By QuoteSaveChanges = By.xpath(
			"//*[@class='right-button-area col-sm-3 hide-for-print col-xs-12 edit-quote-sidebar']//a[text()='Save Changes']");
	
	By OrderDeleteQuote = By.xpath("//*[@class='right-button-area col-sm-3 hide-for-print col-xs-12']//a[text()='Create Order & Delete Quote']");
	
	By Download=By.xpath("//*[@class='product-list-actions']//a[text()='Download']");
	By email=By.xpath("//*[@class='product-list-actions']//a[text()='Email']");
	By emailPDFAttachment=By.xpath("//*[@id='email_addresses']");
	By emailPDFAttachmentSave=By.xpath("//*[@class='btn btn-primary'][text()=' Send']");
	By print=By.xpath("//*[@class='product-list-actions']//a[text()='Print']");
	By QuoteDelete=By.xpath("//*[@class='right-button-area col-sm-3 hide-for-print col-xs-12']//a[text()='Delete']");
	By DeleteConfirmation=By.xpath("//*[@class='modal-footer']//button[text()='Delete']");
	
	public WebElement clickDeleteConfirmation() {
		return driver.findElement(DeleteConfirmation);
	}
	
	public WebElement clickQuoteDelete() {
		return driver.findElement(QuoteDelete);
	}
	
	public WebElement clickprint() {
		return driver.findElement(print);
	}
	
	public WebElement clickemailPDFAttachmentSave() {
		return driver.findElement(emailPDFAttachmentSave);
	}
	
	public WebElement clickemailPDFAttachment() {
		return driver.findElement(emailPDFAttachment);
	}
	
	public WebElement clickemail() {
		return driver.findElement(email);
	}
	
	public WebElement clickDownload() {
		return driver.findElement(Download);
	}
	
	public WebElement clickOrderDeleteQuote() {
		return driver.findElement(OrderDeleteQuote);
	}

	public WebElement clickAddToQuote() {
		return driver.findElement(AddToQuote);
	}
	
	public WebElement clickAddItemFromCart() {
		return driver.findElement(AddItemFromCart);
	}

	public WebElement clickQuoteSaveChanges() {
		return driver.findElement(QuoteSaveChanges);
	}

	public WebElement clickSaveQTYy() {
		return driver.findElement(SaveQTY);
	}

	public WebElement clickAddQty() {
		return driver.findElement(AddQty);
	}

	public WebElement clickQuoteEdit() {
		return driver.findElement(QuoteEdit);
	}

	public WebElement getQuoteBtn() {
		return driver.findElement(QUOTEBtn);
	}

	public WebElement GetReplacementSystem() {
		return driver.findElement(ReplacementSystem);
	}

	public WebElement GetQuoteApprovalBtn() {
		return driver.findElement(QuoteApprovalBtn);
	}

	public WebElement GetMessage() {
		return driver.findElement(GetMessage);
	}

	public WebElement GetPONum() {
		return driver.findElement(PoNum);
	}

	public WebElement GetQuoteConfirmation() {
		return driver.findElement(QuoteConfirmation);
	}

	public WebElement GetCreateParAftQuote() {
		return driver.findElement(CreateParAftQuote);
	}

	public WebElement GetApprovalGroupValue() {
		return driver.findElement(ApprovalGroup);
	}

}
