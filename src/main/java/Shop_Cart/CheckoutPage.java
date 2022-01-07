package Shop_Cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	//By inst = By.id("Instructions");
	By inst = By.xpath("(//*[@class='step-subsection notes-section']//input)[1]");

	By Attention = By.xpath("(//div[@class='field-container']/input)[1]");
	By Newbtn = By.xpath("//a[@class='btn btn-primary use-this-address']");

	// a[@class='btn btn-primary use-this-address']
	// By PO = By.xpath("//input[@id='tbPO']");
	By PO = By.xpath("(//input[@type='text'])[1]");

	By CC = By.xpath("//input[@id='selectCustomField4556071']");
	By QuotePO = By.xpath("//input[@id='selectCustomField4556112']");

	By CCPO = By.xpath("//input[@id='selectCustomField4555917']");
	By BillingDropdown = By.xpath("//div[@class='predictive-dropdown-arrow']");
	By Listvalue = By.xpath("//li[@value='[object Object]']");
	By usediffshipAddress = By.xpath("//a[@class='use-different-s-address']");

	By billingaddress = By.xpath("//div[@class='predictive-quickfind-container']//li[2]");
	By billingaddressdrop = By.xpath("//div[@class='predictive-dropdown-arrow']");
	// div[@class='predictive-dropdown-arrow']

	// By ShippingAddValue=By.xpath("(//li[@value='[object Object]'])[1]");
	// By ShippingAddValue=By.xpath("//li[contains(text(),'Cali7, 4050 Taylor St ,
	// SAN DIEGO, CA, 921102737, 5555555555')]");
	By ShippingAddValue = By.xpath("//div[@class='multiselect-address']//li[3]");
	By ShippingAddValue1 = By.xpath("//div[@class='multiselect-address']//li[1]");
	// input[@id='Requester']
	By reqid = By.id("//input[@id='Requester']");
	By costcenter = By.id("selectCustomField2946144");
	By PlaceOrderBtn = By.xpath("(//a[@class='btn btn-primary btn-save placeOrderBtn'])[1]");
	By placeorderbtn1 = By.xpath("//a[@class='btn btn-primary btn-save placeOrderBtn' and text()='Place Order']");

	By PlaceOrderBtn2 = By.xpath("(//a[@class='btn btn-primary btn-save placeOrderBtn'])[2]");
	By EmailConfirm = By.xpath("//input[@id='tbEmailConfirmation']");
	By JavaClose = By.xpath("//button[@class='btn btn-default']");
	By Reference = By.xpath("//input[@type='text' and @id='tbReference']");
	By UseThisAddress = By.xpath("//a[@class='btn btn-primary use-this-address']");
	By LicenceRenewal = By.xpath("//select[@id='selectCustomField4671035']");
	By ApprovalGroup = By.xpath("//select[@title='Approval group']");
	By Type = By.xpath("//select[@id='selectCustomField4556223']");

	By shipadd = By.xpath("//div[@class='multiselect-address']//li[1]");
	By PurchaseApproval = By.xpath(
			"//div[@class='cart-summary-buttons']//a[@class='btn btn-primary btn-save placeOrderBtn'][contains(text(),'Process Purchase Approval')]");

	By punchoutProcess = By.xpath("//a[@class='btn btn-primary btn-save placeOrderBtn' and text()='Process']");

	By ref = By.id("selectCustomField4556072");
	By PARPO = By.id("selectCustomField4556112");
	// By
	// PARFailStatus=By.cssSelector(".modal-content")("//span[contains(text(),'Oops!
	// Your PAR could not be processed at this time')]");
	// By
	// PARFailStatus=By.xpath("//div[@class='modal-dialog']//span[contains(text(),'Credit
	// limit reached. Please contact your account')]");
	By creditlimitval = By.xpath(
			"//div[@class='modal-dialog']//div[@class='modal-body']//span[contains(text(),'Credit limit reached. Please contact your account')]");
	By PARcannotProcess = By.xpath(
			"//div[@class='modal-dialog']//div[@class='modal-body']//span[contains(text(),'Oops! Your PAR could not be processed at this time. Your Account Team is ready to help or try again')]");
	By OrdercannotProcess = By.xpath(
			"//div[@class='modal-dialog']//div[@class='modal-body']//span[contains(text(),'Oops! Your order could not be processed at this time. Your Account Team is ready to help or try again.')]");

	By close = By.xpath(
			"//div[@class='modal-dialog']//div[@class='modal-footer']//button[@class='btn btn-default'][contains(text(),'Close')]");
	By PAThanks = By.xpath("//h3[contains(text(),'Thank You! Your Purchase approval')]");
	By CCradiobox = By.xpath("//input[@id='pwc']");

	By placeorderbtn = By.xpath(
			"//div[@class='step-action btn-place-order-con']//a[@class='btn btn-primary btn-save placeOrderBtn'][contains(text(),'Place Order')]");
	By createquotebtn = By.xpath(
			"//div[@class='cart-summary-buttons']//a[@class='btn btn-primary btn-save placeOrderBtn'][contains(text(),'Create Quote')]");
	By CreditcardId = By.id("cardNumber");
	By CCExpiryMonth = By.xpath("//select[@class='exp-month native-drop native-drop-small']");
	By CCExpiryYear = By.xpath("//select[@class='exp-year native-drop native-drop-small']");
	By reviewlabel = By.xpath("//span[contains(text(),'Review Quote Details')]");

	By revieworder = By.xpath("//span[contains(text(),'Review Order Details')]");

	// span[contains(text(),'Review Order Details')]

	// select[@class='exp-month native-drop native-drop-small']
	public WebElement getcostcenter() {
		return driver.findElement(costcenter);
	}

	public WebElement getCCradiobox() {
		return driver.findElement(CCradiobox);
	}

	public WebElement getinst() {
		return driver.findElement(inst);
	}

	public WebElement getbillingaddress() {
		return driver.findElement(billingaddress);
	}

	public WebElement getbillingaddressdrop() {
		return driver.findElement(billingaddressdrop);
	}

	public WebElement getcreatequoetbtn() {
		return driver.findElement(createquotebtn);
	}

	public WebElement getplaceorderbtn() {
		return driver.findElement(placeorderbtn);
	}

	public WebElement getreviewlabel() {
		return driver.findElement(reviewlabel);
	}

	public WebElement getrevieworder() {
		return driver.findElement(revieworder);
	}

	public WebElement getreqid() {
		return driver.findElement(reqid);
	}

	public WebElement getCCid() {
		return driver.findElement(CreditcardId);
	}

	public WebElement getCCExpiryMonth() {
		return driver.findElement(CCExpiryMonth);
	}

	public WebElement getCCExpiryYear() {
		return driver.findElement(CCExpiryYear);
	}

	public WebElement getplaceorder() {
		return driver.findElement(placeorderbtn1);
	}

	public WebElement getquotePO() {
		return driver.findElement(QuotePO);
	}

	public WebElement getCreditcardPO() {
		return driver.findElement(CCPO);
	}

	public WebElement thankPAR() {
		return driver.findElement(PAThanks);
	}

	public WebElement PARCannotProcess() {
		return driver.findElement(PARcannotProcess);
	}

	public WebElement getclose1() {
		return driver.findElement(close);
	}

	public WebElement getcreditLimitValid() {
		return driver.findElement(creditlimitval);
	}

	public WebElement getordererror() {
		return driver.findElement(OrdercannotProcess);
	}

	public WebElement getuseDiffShipAddress() {
		return driver.findElement(usediffshipAddress);
	}

	public boolean isElementPresent(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			return false;
		}
	}

	public boolean isElementPresent1(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			return false;
		}
	}

	public WebElement getref() {
		return driver.findElement(ref);
	}

	public WebElement getparPO() {
		return driver.findElement(PARPO);
	}

	public WebElement getAttention() {
		return driver.findElement(Attention);
	}

	public WebElement getPunchoutProcess() {
		return driver.findElement(punchoutProcess);
	}

	public WebElement getPurchaseApproval() {
		return driver.findElement(PurchaseApproval);
	}

	By getMessage = By.xpath(
			"//*[@class='order-confirmation-container']/div/h3[contains(text(),'Thank You! Your purchase approval ')]");
	By getMessage1 = By.xpath("//*[@class='order-confirmation-container']/div/h3/span");

	public WebElement getMessage() {
		return driver.findElement(getMessage);

	}

	public WebElement getMessage1() {
		return driver.findElement(getMessage1);

	}

	public WebElement getshipadd() {
		return driver.findElement(shipadd);
	}

	public WebElement getApprovalGroupDropDown() {
		return driver.findElement(ApprovalGroup);
	}

	public WebElement getUseThisAddress() {
		return driver.findElement(UseThisAddress);
	}

	public WebElement getReference() {
		return driver.findElement(Reference);
	}

	public WebElement getNewbtn() {
		return driver.findElement(Newbtn);
	}

	public WebElement getJavaClose() {
		return driver.findElement(JavaClose);
	}

	public WebElement getEmailConfirm() {
		return driver.findElement(EmailConfirm);
	}

	public WebElement PlaceOrderBtn2() {
		return driver.findElement(PlaceOrderBtn2);
	}

	public WebElement getPO() {
		return driver.findElement(PO);
	}

	public WebElement getCC() {
		return driver.findElement(CC);
	}

	public WebElement getBillingDropdown() {
		return driver.findElement(BillingDropdown);
	}

	public WebElement getListvalue() {
		return driver.findElement(Listvalue);
	}

	public WebElement ValidateordersPage() {
		return driver.findElement(ShippingAddValue);

	}

	public WebElement getPlaceOrderBtn() {
		return driver.findElement(PlaceOrderBtn);
	}

	public WebElement getShippingAddValue() {
		return driver.findElement(ShippingAddValue);

	}

	public WebElement getLicenceRenewalDropdown() {
		return driver.findElement(LicenceRenewal);

	}

	public WebElement getType() {
		return driver.findElement(Type);

	}

	public WebElement getShippingAddValue1() {
		return driver.findElement(ShippingAddValue1);

	}
	// input[@id='tbPO']

}
