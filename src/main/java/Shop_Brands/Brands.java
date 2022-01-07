package Shop_Brands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Brands {
	
	public WebDriver driver;
	
	public Brands(WebDriver driver ) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	By TopSellerSecondProduct = By.xpath("//*[@class='feature-section container '][1]//article[@aria-hidden='false'][1]//a");
	By SecondSellerSecondProduct = By.xpath("//*[@class='feature-section container '][1]//article[@aria-hidden='false'][2]//a");
	By AppleSellerSecondProduct = By.xpath("//*[@class='feature-section container '][1]//article[@aria-hidden='false'][2]//a");
	
	
	public WebElement getAppleSellerSecondProduct()
	{
		return driver.findElement(AppleSellerSecondProduct);
	}
	
	public WebElement getSecondSellerSecondProduct()
	{
		return driver.findElement(SecondSellerSecondProduct);
	}
	
	public WebElement getTopSellingSurfaceSecondProduct()
	{
		return driver.findElement(TopSellerSecondProduct);
	}


}
