package Shop_MainPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
	public WebDriver driver;

	public SearchResultPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	// By prod4fav = By.xpath("(//a[contains(@id,'fav_btn_')])[1]");
	By prod4fav = By.xpath("(//a[contains(@id,'fav_btn_')])[1]");

	By CartBtn = By.xpath("//span[@alt='Shopping Cart']");
	By Product5Cart = By.xpath("(//a[@data-product-type='PRODUCT'])[1]");
	By Product6Cart = By.xpath("(//a[@data-product-type='PRODUCT'])[3]");
	By AddProductCartFirst = By.xpath("(//a[@data-product-type='PRODUCT'])[1]");

	By Compare1 = By.xpath("(//div[@class='control__indicator'])[1]");
	By Compare2 = By.xpath("(//div[@class='control__indicator'])[2]");
	By CompareBtn = By.linkText("Compare");
	// By ProductCart4=By.xpath("(//a[@class='product-name'])[4]");
	By ProductCart4 = By.xpath("(//h2[contains(@id,'product-name-')])[1]");

	By Products = By.xpath("//div[@class='product-list-grid clearfix print-product-list pro-list grid']");
	// By Product4Cart=By.xpath("//a[@id='add_to_cart_11273675']");
	// By fav1Product = By.xpath("//*[@id='fav_btn_10886231']");

	By Product4Cart = By.xpath("//a[@id='add_to_cart_16621385']");
	By fav1Product = By.xpath("//*[@id='fav_btn_16621385']");

	By Favdialog = By.xpath("//*[@id='products-content']/div/div[2]/div/div/div[1]/h4");
	// By Product1Name = By.xpath("//*[@id='product-name-10886231']");
	// By Product1Cart = By.xpath("//*[@id='add_to_cart_10886231']");
	By Product1Name = By.xpath("//*[@id='product-name-16621385']");
	By Product1Cart = By.xpath("//*[@id='add_to_cart_16621385']");
	// *[@id='add_to_cart_10886231']
	// By Product2Cart = By.xpath("//*[@id='add_to_cart_9707434']");
	// By Product2Cart = By.xpath("//a[@id='add_to_cart_9707434']");
	By Product2Cart = By.xpath("//a[@id='add_to_cart_16621385']");

	By CloseIcon = By.xpath("//*[@id='cart-dialog']/div[1]/div[1]/div/div/div/button");
	By ClosePopup = By.xpath("//button[@data-dismiss='modal']");
	By CloseIcon1 = By.xpath("(//button[@type='button' and @class='mfp-close'])[2]");
	By prod4fav1 = By.xpath("(//a[contains(@id,'fav_btn_')])[1]");
	By Product3Cart = By.xpath("//*[@id='add_to_cart_11224916']");
	By AddToCartCLose = By.xpath("//button[@class='mfp-close']");
	By favClose = By.xpath("//div[@class='modal-footer']//button[@class='btn btn-default' and text()='Close'][1]");
	By prod1name = By.xpath("//h2[@id='product-name-16621385']");

	public By Add2Cart = By.xpath("(//a[@class='add_to_cart btn btn-primary'])[2]");

	By CreateQuoteBtn = By.xpath("//a[@class='btn secondary left' and text() ='Create Quote']");

	public WebElement getprod4fav1() {
		return driver.findElement(prod4fav1);
	}

	public WebElement getprod4fav() {
		return driver.findElement(prod4fav);
	}

	public WebElement getaddcartfirst() {
		return driver.findElement(AddProductCartFirst);
	}

	public WebElement getClosePopup() {
		return driver.findElement(ClosePopup);
	}

	public WebElement getProductCart4() {
		return driver.findElement(ProductCart4);
	}

	public WebElement getCartBtn() {
		return driver.findElement(CartBtn);
	}

	public WebElement getCloseIcon1() {
		return driver.findElement(CloseIcon1);
	}

	public WebElement getCreateQuoteBtn() {
		return driver.findElement(CreateQuoteBtn);
	}

	public WebElement getAdd2Cart() {
		return driver.findElement(Add2Cart);
	}

	public By getAdd2Cartex() {
		return Add2Cart;
	}

	public WebElement getCompare1() {
		return driver.findElement(Compare1);
	}

	public WebElement getCompare2() {
		return driver.findElement(Compare2);
	}

	public WebElement getCompareBtn() {
		return driver.findElement(CompareBtn);
	}

	public WebElement getProduct4Cart() {
		return driver.findElement(Product4Cart);
	}

	public WebElement getprod1name() {
		return driver.findElement(prod1name);
	}

	public WebElement getfavClose() {
		return driver.findElement(favClose);
	}

	public WebElement getCloseIcon() {
		return driver.findElement(CloseIcon);
	}

	public List<WebElement> getCloseIconCount() {
		return driver.findElements(CloseIcon);
	}

	public WebElement getAddToCartCLose() {
		return driver.findElement(AddToCartCLose);
	}

	public WebElement getProduct3Cart() {
		return driver.findElement(Product3Cart);
	}

	public WebElement getProduct1Cart() {
		return driver.findElement(Product1Cart);
	}

	public WebElement getProduct2Cart() {
		return driver.findElement(Product2Cart);
	}

	public WebElement getAllProducts() {
		return driver.findElement(Products);
	}

	public WebElement getFav1Product() {
		return driver.findElement(fav1Product);
	}

	public WebElement getFavdialog() {
		return driver.findElement(Favdialog);
	}

	public WebElement getProduct1Name() {
		return driver.findElement(prod1name);
	}

	public List<WebElement> getProduct1NameCount() {
		return driver.findElements(prod1name);
	}

	public WebElement getProduct5Cart() {
		return driver.findElement(Product5Cart);
	}

	public WebElement getProduct6Cart() {
		return driver.findElement(Product6Cart);
	}

	public List<WebElement> getProduct5CartCount() {
		return driver.findElements(Product5Cart);
	}

}
