package Shop_Cart;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressesPage {
	public WebDriver driver ;
	//public Select Se1;
	
	
	public ShippingAddressesPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
//	Select Se3 = new Select(driver.findElement(By.className("state-filter")));
//	Select Se4 = new Select(driver.findElement(By.className("city-filter")));
	
	By SearchAddress= By.className("search-for-address");
	//Select Se5 = new Select(driver.findElement(By.id("address-select")));
	By Add_NewAddressBtn= By.linkText("Add New Address");
	By ClearSearch= By.linkText("Clear search");
	By MyProfile= By.linkText("My Profile");
	
    By multiselect=By.xpath("//div[@class='multiselect-address']");
	By LocationTextbox = By.xpath("//input[@name='location-name']");
	By Address = By.xpath("//input[@name='address']");
	By City = By.xpath("//input[@name='city']");
	By state = By.xpath("//select[@title='State']");
	By state1 = By.xpath("//div[@class='search-address']//div//select[@class='add-edit-state checkout-state state']");
	
By zip = By.xpath("//input[@name='zipcode']");
	By Phone = By.xpath("//input[@name='phone']");
	By SaveBtn=By.xpath("//input[@name='save-address']");
	By SuccessDialog=By.xpath("//div[@class='modal-dialog']");
	By CloseBtn = By.xpath("//button[@class='btn btn-default']");
	
	//Select Se3 = new Select(driver.findElement(By.className("state-filter")));
	//Select Se4 = new Select(driver.findElement(By.className("city-filter")));
	

	
	public WebElement getSearchAddress()
	{
		return driver.findElement(SearchAddress);
	}
	public WebElement getMultiSeletAddress()
	{
		return driver.findElement(multiselect);
	}
	public WebElement getAdd_NewAddressBtn()
	{
		return driver.findElement(Add_NewAddressBtn);
	}
	
	public WebElement getClearSearch()
	{
		return driver.findElement(ClearSearch);
	}
	
	/*public Select getStateFilter()
	{
		//return Se3;
	}
	
	public Select getCityFilter()
	{
		return Se4;
	}
	public Select getAddressDropdown()
	{
		return Se5;
	}*/
	
	public WebElement getMyProfile()
	{
		return driver.findElement(MyProfile);
	}

	
	public WebElement getCloseBtn()
	{
		return driver.findElement(CloseBtn);
	}
		
	public WebElement getSuccessDialog()
	{
		return driver.findElement(SuccessDialog);
	}
	
	
	public WebElement getSaveBtn()
	{
		return driver.findElement(SaveBtn);
	}
	
	
	public WebElement getLocationTextbox()
	{
		return driver.findElement(LocationTextbox);
	}
	
	public WebElement getAddress()
	{
		return driver.findElement(Address);
	}
	
	public WebElement getCity()
	{
		return driver.findElement(City);
	}
	
	public WebElement getstate()
	{
		return driver.findElement(state1);
	}
	
	public WebElement getzip()
	{
		return driver.findElement(zip);
	}
	
	
	public WebElement getPhone()
	{
		return driver.findElement(Phone);
	}
	
	
	//public Select getStateFilter()
	//{
		//return Se3;
	//}
	
	//public Select getCityFilter()
	//{
	//	return Se4;
	//}
	//public Select getAddressDropdown()
	//{
	//	return Se5;
	//}

}
