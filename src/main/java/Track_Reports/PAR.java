package Track_Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PAR {
	
	public WebDriver driver;
	
	public PAR(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By RejectedView=By.xpath("//*[@id='view']");
	By RejectedStatus=By.xpath("//*[@class='mobile-table']//tr[2]/td[@title='Rejected']");
	By ApprovedStatus=By.xpath("//*[@class='mobile-table']//tr[2]/td[@title='Approved']");
	By SelectAllFields= By.xpath("//*[@class='modal-content']//a[contains(text(),'Select All')]");
	By EmailFields= By.xpath("//*[@class='product-list-actions']//a[contains(text(),'Email')]");
	By SendEmail= By.xpath("//*[@id='emailForm']//button[contains(text(),'Send')]");
	
	public WebElement getSendEmail()
	{
		return driver.findElement(SendEmail);
	}
	
	public WebElement getEmailFields()
	{
		return driver.findElement(EmailFields);
	}
	
	
	public WebElement getSelectAllFields()
	{
		return driver.findElement(SelectAllFields);
	}
	
	
	public WebElement getApprovedStatus()
	{
		return driver.findElement(ApprovedStatus);
	}
	
	public WebElement getRejectedView()
	{
		return driver.findElement(RejectedView);
	}
	
	public WebElement getRejectedStatus()
	{
		return driver.findElement(RejectedStatus);
	}

}
