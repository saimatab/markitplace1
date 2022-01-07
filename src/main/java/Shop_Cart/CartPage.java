package Shop_Cart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CartPage {

	public WebDriver driver;

	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By CheckoutBtnFF = By.xpath("//a[@class='btn btn-primary proceed-checkout ']");
	// By CheckoutBtnFF=By.xpath("//a[text()='Create Order']");
	// By CheckoutBtn=By.xpath("//a[text()='Create Order']");

	By CheckoutBtn = By.xpath("//a[@class='btn btn-primary'][contains(text(),'Create Order')]");
	// By CheckoutBtn1=By.xpath("//a[contains(@class,'btn btn-primary
	// proceed-checkout')]");
	By CheckoutBtn1 = By.xpath("//div[contains(@class,'main-btn cart-create-order')]");

	// By PARBtn=By.xpath("//a[@class='btn secondary left'][contains(text(),'Create
	// PAR')]");
	By PARBtn = By
			.xpath("//div[@class='sub-col-right cart-modal-btns']//li[@class='option'][contains(text(),'Create PAR')]");

	By drop = By.xpath("//*[@id='cart-dialog']/div[1]/div[1]/div/div/div/div/div[5]/div/div/div/div");
	By PARSelect = By.xpath("//div[@class='item-sub-row clearfix show-for-tablet']/div/div/div/a");
	// div[@class='sub-col-right
	// cart-modal-btns']//li[@class='option'][contains(text(),'Create PAR')]

	// By Quote=By.xpath("//a[@class='btn secondary left'][contains(text(),'Create
	// Quote')]");
	By Quote = By.xpath(
			"//div[@class='sub-col-right cart-modal-btns']//li[@class='option'][contains(text(),'Create Quote')]");
	By Quote1 = By.xpath(
			"//div[@class='sub-col-right cart-modal-btns']//div[@class='main-btn'][contains(text(),'Create Quote')]");

	// By createorder=By.xpath("//a[@class='btn
	// btn-primary'][contains(text(),'Create Order')]");
	By createorder = By.xpath(
			"//div[@class='sub-col-right cart-modal-btns']//div[@class='main-btn'][contains(text(),'Create Order')]");

	By continueshop = By
			.xpath("//div[@class='sub-col-right cart-modal-btns']//a[contains(text(),'Continue Shopping')]");
	By CartSubtotal = By.xpath("//h2[@class='sub-total sub-total-heading']");
	By ItemsCount = By.xpath("//span[@class='items-total']");
	By Subtotal = By.xpath("//span[@class='right sub-total']");
	By EstimatedTax = By.xpath("//span[@class='right estimated-tax']");
	By EstimatedShipping = By.xpath("//span[@class='right estimated-shipping']");
	By EstimatedTotal = By.xpath("//span[@class='right estimated-total']");
	By RemoveAll = By.linkText("Remove all");
	// By Remove1=By.xpath("(//a[@class='btn text-color cart-remove'])[1]");
	// 9march/By Remove1=By.xpath("//a[@id='remove-item-12577638']");

	By Remove1 = By.xpath("(//a[@class='btn text-color cart-remove'])[1]");
	By Remove1Count = By.xpath("//a[@id='remove-item-12577638']");
	By Quote_Btn = By.xpath("//a[text()='Create Quote']");
	By createbundle = By
			.xpath("//span[@class='pull-left']//a[@class='btn secondary'][contains(text(),'Create Standards Bundle')]");
	By bundlename = By.xpath("//input[@id='bundlename']");
	By bundlecategory = By.xpath("//div[@class='predictive-dropdown-arrow']");
	By standbundleorder = By.xpath("//input[@class='btn btn-primary']");
	By bundleEdit = By.xpath("//a[@class='btn btn-default hide-for-print bundle-edit-enabled']");
	By bundleOptional = By.xpath("//div[@class='cart-items']//div[1]//div[1]//label[1]//span[2]");
//div[@class='right-button-area hidden-print']
	By bundleQTY = By.xpath("(//input[@class='hide-for-print mode-edit-e'])[2]");
	By bundleQTY1 = By.xpath("(//input[contains(@id,'quantity-')])[2]");
//input[contains(@id,'quantity-')]
	By bundlesave = By.xpath("//input[@class='btn btn-primary']");
	By Addstandard = By.xpath("//a[@class='addtostandards']");
	By SelectstandardCategory = By.xpath("//div[@class='predictive-dropdown-arrow']");
	By categorymodal = By.xpath(
			"//div[@class='predictive-quickfind-container active']//li[@class='ep-parent'][contains(text(),'Enterprise Desktops & Monitors')]");
	By categorymodalsave = By.xpath("//button[@class='btn btn-primary']");

	By categorymodalsaveclose = By.xpath("//div[@id='shop-content']//button[@class='mfp-close'][contains(text(),'×')]");

	By abc = By.xpath("//li[contains(text(),'Enterprise Laptops')]");

	By Additemfromcart = By.xpath("//a[@class='btn btn-default add-to-cart-modal open_hide_modal']");
	By Additemfromcartmodalbutton = By.xpath(
			"//div[@class='modal-footer show-for-tablet']//a[@class='btn btn-primary'][contains(text(),'Add to Standard #')]");
//dynamic IDs 
	By bottomcart = By.xpath("//a[contains(@id,'add_to_recommended_')]");

	By cartclose = By.xpath("//body/div[@id='cart-dialog']/div/div[1]/div[1]/div[1]/div[1]/button[1]");
	By viewCart = By.xpath("//*[@class='sub-col-right cart-modal-btns']//a[text()='View Cart']");
	By SecondPositionData = By.xpath("//*[@class='product-list-grid clearfix print-product-list pro-list grid']/div[@data-position='2']/a");
	By ProductPurchaseAddToCart = By.xpath("//*[@class='product-purchase']//a[@attr='1'][contains(text(),'Cart')]");
	By CartDialogBoxAddToCart = By.xpath("//*[@class='item-sub-row clearfix show-for-tablet']//div[contains(text(),'Create Order')]");
	
	public WebElement getCartDialogBoxAddToCart() {
		return driver.findElement(CartDialogBoxAddToCart);
	}
	
	public WebElement getProductPurchaseAddToCart() {
		return driver.findElement(ProductPurchaseAddToCart);
	}
	
	public WebElement getSecondPositionData() {
		return driver.findElement(SecondPositionData);
	}
	
	public WebElement getQuote_Btn() {
		return driver.findElement(Quote_Btn);
	}

	public WebElement getcreateorder() {
		return driver.findElement(createorder);
	}

	public WebElement getcreatestandardbundleorder() {
		return driver.findElement(standbundleorder);
	}

	public WebElement getcategorymodalsaveclose() {
		return driver.findElement(categorymodalsaveclose);
	}

	public WebElement getstandlink() {
		return driver.findElement(Addstandard);
	}

	public WebElement getcartclose() {
		return driver.findElement(cartclose);
	}

	public WebElement getbottomcart() {
		return driver.findElement(bottomcart);
	}

	public WebElement getstancategory() {
		return driver.findElement(SelectstandardCategory);
	}

	public WebElement getaddfromcart() {
		return driver.findElement(Additemfromcart);
	}

	public WebElement getaddfromcartbuttonmodal() {
		return driver.findElement(Additemfromcartmodalbutton);
	}

	// a[@class='btn btn-default add-to-cart-modal open_hide_modal']

	public WebElement getcategorymodal() {
		return driver.findElement(categorymodal);
	}

	public WebElement getcategorymodal1() {
		return driver.findElement(abc);
	}

	public WebElement getcategorymodalsave() {
		return driver.findElement(categorymodalsave);
	}

	public WebElement getbundlename() {
		return driver.findElement(bundlename);
	}

	public WebElement getbundleEdit() {
		return driver.findElement(bundleEdit);
	}

	public WebElement getbundleOptional() {
		return driver.findElement(bundleOptional);
	}

	public WebElement getbundleOQty() {
		return driver.findElement(bundleQTY);
	}

	public WebElement getbundleOQty1() {
		return driver.findElement(bundleQTY1);
	}

	public WebElement getbundlesave() {
		return driver.findElement(bundlesave);
	}

	public WebElement getbundlecat() {
		return driver.findElement(bundlecategory);
	}

	public WebElement getcreatebundle() {
		return driver.findElement(createbundle);
	}

	public WebElement getcontshopping() {
		return driver.findElement(continueshop);
	}

	public WebElement getCheckoutBtnFF() {
		return driver.findElement(CheckoutBtnFF);
	}

	public WebElement getdrop() {
		return driver.findElement(drop);
	}

	public WebElement PARSelect() {
		return driver.findElement(PARSelect);
	}

	public List<WebElement> getRemove1Count() {
		return driver.findElements(Remove1Count);
	}

	public WebElement getRemove1() {
		return driver.findElement(Remove1);
	}

	public WebElement getPARBtn() {
		return driver.findElement(PARBtn);
	}

	public WebElement getQuoteBtn() {
		return driver.findElement(Quote);
	}

	public WebElement getQuoteBtn1() {
		return driver.findElement(Quote1);
	}

	public WebElement getCheckoutBtn() {
		return driver.findElement(CheckoutBtn);
	}

	public WebElement getCheckoutBtn1() {
		return driver.findElement(CheckoutBtn1);
	}

	public WebElement getCartSubtotal() {
		return driver.findElement(CartSubtotal);
	}

	public WebElement getItemsCount() {
		return driver.findElement(ItemsCount);
	}

	public WebElement getSubtotal() {
		return driver.findElement(Subtotal);
	}

	public WebElement getEstimatedTax() {
		return driver.findElement(EstimatedTax);
	}

	public WebElement getEstimatedShipping() {
		return driver.findElement(EstimatedShipping);
	}

	public WebElement getEstimatedTotal() {
		return driver.findElement(EstimatedTotal);
	}

	public WebElement getRemoveAll() {
		return driver.findElement(RemoveAll);
	}

}