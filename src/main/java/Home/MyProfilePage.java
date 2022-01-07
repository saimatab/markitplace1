package Home;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfilePage {
	
	public WebDriver driver;

	public MyProfilePage(WebDriver driver ) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	//By HomePageTextbox=By.id("homePageUrl");
	By HomePageTextbox=By.xpath("//div[@class='predictive-dropdown-arrow']");
	
	
	By AccountDropdown=By.xpath("(//i[@class='fa fa-caret-down'])[1]");
	By EditProfBtn=By.linkText("Edit Profile");
	By ShippingAddressLink=By.linkText("Shipping Addresses");
	By MyProfileLinkLink=By.linkText("My Profile");
	By um=By.xpath("//div[@class='account-menu']//a[contains(text(),'User Management')]");
	By logout=By.xpath("//div[@class='account-menu']//a[contains(text(),'Logout')]");
	By info=By.xpath("//label[contains(text(),'My home page:')]");
	By info1=By.xpath("//p[contains(text(),'Shop Home')]");
	
	By MyAccount=By.xpath("(//span[text()='My Account '])[1]");
	By SaveBtn=By.xpath("//input[@class='btn btn-primary']");
	By ShippingAddressLinkFF=By.xpath("(//a[text()='Shipping Addresses'])[3]");
	
	By ln=By.id("lastName");
	By ph=By.id("phone");
	
	
	
	
	
	
	
	public WebElement getAccountDropdown1()
	{
		return driver.findElement(AccountDropdown);
	}
	public WebElement getum()
	{
		return driver.findElement(um);
	}
	public WebElement getSaveBtn()
	{
		return driver.findElement(SaveBtn);
	}
	
	public WebElement getShippingAddressLinkFF()
	{
		return driver.findElement(ShippingAddressLinkFF);
	}
	
	public WebElement getHomePageTextbox()
	{
		return driver.findElement(HomePageTextbox);
	}
	public WebElement getph()
	{
		return driver.findElement(ph);
	}
	
	public WebElement getname()
	{
		return driver.findElement(ln);
	}
	
	
	public WebElement getAccountDropdown()
	{
		return driver.findElement(AccountDropdown);
	}

public WebElement getEditProfBtn()
{
	return driver.findElement(EditProfBtn);
}

public WebElement getShippingAddressLink()
{
	return driver.findElement(ShippingAddressLink);
}

public WebElement getMyProfileLinkLink()
{
	return driver.findElement(MyProfileLinkLink);
}
public WebElement getMyAccount()
{
	return driver.findElement(MyAccount);
}

public WebElement getinfo()
{
	return driver.findElement(info);
}
public WebElement getinfo1()
{
	return driver.findElement(info1);
}

public  WebElement getlogout() throws IOException, InterruptedException
{
	return driver.findElement(logout);
   
}
}