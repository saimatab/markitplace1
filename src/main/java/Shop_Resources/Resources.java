package Shop_Resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Resources {
	
	public WebDriver driver;
	
	public Resources(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	By ResourceSeeMore = By.xpath("//*[@class='page-aligner']//a[@id='load-more']");
	
	public WebElement getResourceSeeMore()
	{
		return driver.findElement(ResourceSeeMore);
	}
	
	
}
