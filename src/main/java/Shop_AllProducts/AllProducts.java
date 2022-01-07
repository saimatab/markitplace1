package Shop_AllProducts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllProducts {
	
	public WebDriver driver;

	public AllProducts(WebDriver driver ) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	By AudioCables = By.xpath("//div[@data-tertiary-nav-id='cables']/div/div/ul[1]/li[1]/a[contains(text(),'Audio Cables')]");
	
	By AudioCablesFF=By.xpath("(//a[text()='Audio Cables'])[2]");
	
	By TopSellerSecondProduct = By.xpath("//*[@class='feature-section container '][1]//article[@aria-hidden='false'][2]");
	
	
	public WebElement getTopSellerSecondProduct()
	{
		return driver.findElement(TopSellerSecondProduct);
	}
	
	public WebElement getAudioCables()
	{
		return driver.findElement(AudioCables);
	}
	
	public WebElement getAudioCablesFF()
	{
		return driver.findElement(AudioCablesFF);
	}


}
