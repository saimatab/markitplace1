package Shop_StandardsCatalog;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StandardsCatalog {
	public WebDriver driver;

	public StandardsCatalog(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By Product1 = By.xpath("//img[@alt='10032.']");
	By LeftPaneEnterprise = By.xpath("//*[@class='parent st-parent  children-bk   active ']/a");
	By LeftpaneEnterpriseDesktopAndMonitor = By
			.xpath("//*[@class='parent st-parent  children-bk   active ']/ul/li[@class='st-parent  ']/a");

	By Product1New = By.xpath("//img[@alt='Miraca monitor']");
	By Add2cartbtn = By.xpath("//a[@id='add_to_cart_desk_10886231']");
	By Closeicon = By.xpath("(//button[@title='Close (Esc)'])[2]");
	By Product2New = By.xpath("(//a[@class='image-link hitProductForDetail'])[5]");

	By ListView = By.xpath("//a[@id='bt-products-list']");
	By ListViewDsp = By.xpath("//a[@class='grid-control-icon icon-grid active']");
	By GridView = By.xpath("//a[@id='bt-products-grid']");
	By Qtybox = By.xpath("(//*[contains(@id,'product_qty_')])[1]");
	By CartBtn = By.xpath("(//*[contains(@id,'cart_btn_')])[1]");
	By favrtBtn = By.xpath("(//*[contains(@id,'fav_btn_')])[1]");
	// By Add2favReg=By.xpath("");
	By tablet = By.xpath("//a[text()='TABLETS']");

	By catar = By.xpath("//span[@class='parent-link']");
	By categoryselect = By.xpath("//a[contains(text(),'Enterprise Desktops & Monitors')]");
	By categoryselect1 = By.xpath("//a[contains(text(),'Enterprise Laptops')]");

	// li[contains(@class,'active')]//span[@class='parent-link']
	public List<WebElement> getListViewDspCount() {
		return driver.findElements(ListViewDsp);
	}

	public WebElement getProduct2New() {
		return driver.findElement(Product2New);
	}

	public WebElement getCloseicon() {
		return driver.findElement(Closeicon);
	}

	public WebElement getAdd2cartbtn() {
		return driver.findElement(Add2cartbtn);
	}

	public WebElement getProduct1() {
		return driver.findElement(Product1);
	}

	public List<WebElement> getProduct1Count() {
		return driver.findElements(Product1);
	}

	public WebElement getProduct1New() {
		return driver.findElement(Product1New);
	}

	public List<WebElement> getProduct1CountNew() {
		return driver.findElements(Product1New);
	}

	public WebElement gettablet() {
		return driver.findElement(tablet);
	}

	public WebElement getfavrtBtn() {
		return driver.findElement(favrtBtn);
	}

	public WebElement getCartBtn() {
		return driver.findElement(CartBtn);
	}

	public WebElement getQtybox() {
		return driver.findElement(Qtybox);
	}

	public WebElement getGridView() {
		return driver.findElement(GridView);
	}

	public WebElement getListView() {
		return driver.findElement(ListView);
	}

	public WebElement getcatarrow() {
		return driver.findElement(catar);
	}

	public WebElement getcatselect() {
		return driver.findElement(categoryselect);
	}

	public WebElement getcatselect1() {
		return driver.findElement(categoryselect1);
	}

	public WebElement getLeftPaneEnterpriseselect() {
		return driver.findElement(LeftPaneEnterprise);
	}

	public WebElement getLeftpaneEnterpriseDesktopAndMonitorselect() {
		return driver.findElement(LeftpaneEnterpriseDesktopAndMonitor);
	}

}
