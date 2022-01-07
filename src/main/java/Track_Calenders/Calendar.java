package Track_Calenders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
public class Calendar {

	public WebDriver driver ;
	//public Select Se1;
	
	
	public Calendar(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	By ContBtnEnb=By.xpath("//button[@class='btn btn-primary']");
	By ExpirationDates=By.id("ExpirationDates");
	By ContBtnDis=By.xpath("//button[@class='btn btn-primary disabled']");
	By SubscribeBtn= By.id("subscribe-btn");
	By MonthlyView= By.xpath("//*[@id='track-calandar']/div/section/div[1]/div[2]/div/span");
	By DetailView= By.xpath("//*[@id='track-calandar']/div/section/div[1]/div[2]/div/a/span");
	By FirstPlus=By.xpath("(//a[@class='btn-expand-content'])[1]");
	By ReportLink=By.linkText("(6) PLANAR SYSTEMS");
	
	By CalendarDropdown=By.id("calendarSelectYearMonthly");
	
	//Select Se1= new Select(driver.findElement(By.className("small native-drop native-drop-large")));
	
	
By SubDialogBox=By.xpath("(//div[@class='modal-content'])[4]");
	
	
	By MonthViewBtn1=By.xpath("//span[text()='Monthly view']");

	By ContBtn=By.xpath("//button[text()='Continue']");
	By urlTextbox=By.xpath("//input[@id='subscribe-link']");
	By CopyURLBtn=By.xpath("//button[text()='Copy URL']");
	By LinkCopied=By.xpath("//button[text()='Link was copied']");
	By SubCloseBtn=By.xpath("(//button[text()='Close'])[3]");
	
	By SubCloseBtn1=By.xpath("//button[@class='btn btn-secondary']");
	
	By febExpand=By.xpath("(//a[@class='btn-expand-content'])[2]");
	By ReportLInk=By.xpath("(//li[@class='li warranty'])[1]");
	By ManufacturerWarrantiesExpiring=By.xpath("//*[@class='currentMonths']//div[@class='accordion-content clearfix active']//h3[contains(text(),'Manufacturer Warranties Expiring')]");

	public WebElement getManufacturerWarrantiesExpiring()
	{
		return driver.findElement(ManufacturerWarrantiesExpiring);
	}
	
	public WebElement getReportLInk()
	{
		return driver.findElement(ReportLInk);
	}
	
	public WebElement getfebExpand()
	{
		return driver.findElement(febExpand);
	}
	
	public WebElement getSubCloseBtn()
	{
		return driver.findElement(SubCloseBtn1);
	}
	public WebElement getLinkCopied()
	{
		return driver.findElement(LinkCopied);
	}

	
	
	//Select Se1= new Select(driver.findElement(By.className("small native-drop native-drop-large")));
	public WebElement getCopyURLBtn()
	{
		return driver.findElement(CopyURLBtn);
	}
	
	public WebElement geturlTextbox()
	{
		return driver.findElement(urlTextbox);
	}
	
	public WebElement getContBtn()
	{
		return driver.findElement(ContBtn);
	}
	
	
	public List<WebElement> getContBtnDisCount()
	{
		return driver.findElements(ContBtnDis);
	}
	
	
	
	public List<WebElement> getContBtnEnbCount()
	{
		return driver.findElements(ContBtnEnb);
	}
	
	
	public WebElement getExpirationDates()
	{
		return driver.findElement(ExpirationDates);
	}
	
	public WebElement getSubDialogBox()
	{
		return driver.findElement(SubDialogBox);
	}
	
	
	public WebElement getMonthViewBtn1()
	{
		return driver.findElement(MonthViewBtn1);
		
	}
	
	
	public WebElement getCalendarDropdown()
	{
		return driver.findElement(CalendarDropdown);
		
	}
	
	
	//public WebElement getReportLink()
	//{
		//return driver.findElement(ReportLink);
		
//	}
	
	public WebElement getFirstPlus()
	{
		return driver.findElement(FirstPlus);
		
	}
	
	public WebElement getSubscribeBtn()
	{
		return driver.findElement(SubscribeBtn);
		
	}
	
	public WebElement getMonthlyView()
	{
		return driver.findElement(MonthlyView);
		
	}

	public WebElement getDetailView()
	{
		return driver.findElement(DetailView);
		
	}
	
	public boolean isElementPresent(By locatorKey) {
	    try {
	        driver.findElement(locatorKey);
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
	
	
	public WebElement getReportLink()
	{
		return driver.findElement(ReportLink);
		
	}
	
	
	/*	public Select getCalendar()
	{
		
		return Se1;
		
	}*/
	
}
