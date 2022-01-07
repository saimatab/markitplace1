package Shop_ProductDetail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PDP {
	
	public WebDriver driver ;
	//public Select Se1;
	
	
	public PDP(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	//body/div[@id='cart-dialog']/div/div[1]/div[1]/div[1]/div[1]/button[1]
	//By CartClose= By.xpath("(//button[@class='mfp-close'])[1]");
	By CartClose= By.xpath("//body/div[@id='cart-dialog']/div/div[1]/div[1]/div[1]/div[1]/button[1]");
	
	//body/div[@id='cart-dialog']/div/div[1]/div[1]/div[1]/div[1]/button[1]
	By Cartbtn=By.xpath("//a[@class='add_to_cart btn btn-primary show-for-tablet modal-btn hide-for-print']");
	By favoriteIcon= By.xpath("//a[@class='my-lists' and text()='Favorites']");

		//By submitCart= By.xpath("//a[@class='btn btn-primary' and text()='Submit Cart']");
	
		By submitCart= By.xpath("//div[@class='sub-col-right cart-modal-btns']//div[@class='main-btn'][contains(text(),'Submit Cart')]");

	By viewCart= By.xpath("//a[@class='btn secondary left' and text()='View Cart']");
	
		
		public WebElement getfavoriteIcon()
	{
		return driver.findElement(favoriteIcon);
		
	}
	public WebElement getCartbtn()
	{
		return driver.findElement(Cartbtn);
	}
	public WebElement getsubmitCart()
	{
		return driver.findElement(submitCart);
	}
	public WebElement getviewCart()
	{
		return driver.findElement(viewCart);
	}
	public WebElement getCartClose()
	{
		return driver.findElement(CartClose);
	}
	
	
	By headlogo= By.xpath("//img[@class='logo']");


	By favrtlink = By.xpath("//a[@id='fav_btn_10886231']");
	By emaillink = By.xpath("//a[@class='action-icon icon-mail']");
	By emailbox =By.xpath("//input[@name='email_addresses']");
	By SendBtn=By.xpath("//button[@class='btn btn-primary']");
	By emailpopup=By.xpath("//div[@class='white-popup popup-small zoom-anim-dialog mfp-show email-modal']");
	By ShoppingCartIcon=By.xpath("//span[@alt='Shopping Cart']");
	
	
	public WebElement getShoppingCartIcon()
	{
		return driver.findElement(ShoppingCartIcon);
	}
	public WebElement getheadlogo()
	{
		return driver.findElement(headlogo);
	}
	public WebElement getemailpopup()
	{
		return driver.findElement(emailpopup);
	}
	
	public WebElement getSendBtn()
	{
		return driver.findElement(SendBtn);
	}
	public WebElement getemailbox()
	{
		return driver.findElement(emailbox);
	}
	
	public WebElement getemaillink()
	{
		return driver.findElement(emaillink);
	}
	
	public WebElement getfavrtlink()
	{
		return driver.findElement(favrtlink);
	}
	
	

	
	
	
	
	
	
	
}
