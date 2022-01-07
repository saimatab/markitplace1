package Track_PurchaseAnalysis;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseAnalysis {

	public WebDriver driver;

	public PurchaseAnalysis(WebDriver driver ) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;

	}
	//div[@class='purchase-analysis-body']//div[@class='clearfix action-icon-container']//span[@class='product-list-actions']////a[@class='action-icon icon-mail' and text()='Email']

	By Email=By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/span[1]/a[2]");
	//By Email=By.xpath("//div[@class='purchase-analysis-body']//div[@class='clearfix action-icon-container']//span[@class='product-list-actions']//a[@class='action-icon icon-mail' and text()='Email']");
	By download=By.xpath("//a[@class='action-icon icon-download' and text()='Download']");
	By EAddressField=By.xpath("//input[@type='text' and @name='email_addresses']");
	
	//By EAddressField=By.xpath("//input[@id='email_addresses']");
	By pdf=By.xpath("//label[contains(text(),'PDF Attachment')]");
	
	//input[@id='email_addresses']
	By SendBtn=By.xpath("//button[@id='send_btn']");
	
	By EmailDialog=By.xpath("(//div[@class='modal-content'])[4]");
	
	By Jan2018Cricle=By.xpath("//div[@id='savingsByMfg']/div/div/div[1]/*[name()='svg']/*[name()='g'][2]/*[name()='g'][2]/*[name()='circle'][1]");
	By Jan2018Circle1=By.xpath("//div[@id='savingsByMfg']/div/div/div[1]/*[name()='svg']/*[name()='g'][2]/*[name()='g'][2]/*[name()='circle'][3]");

	By SavingDropdown=By.xpath("//select[@id='savingsByMfg-selectBox']");
	public WebElement getSavingDropdown()
	{
		return driver.findElement(SavingDropdown);
	}
	
	public WebElement getJan2018Cricle()
	{
		return driver.findElement(Jan2018Cricle);
	}
	
	public List<WebElement> getEmailDialogCount()
	{
		return driver.findElements(EmailDialog);
	}
	
	public WebElement getEmailDialog()
	{
		return driver.findElement(EmailDialog);
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(Email);
		//return driver.findElement(By.linkText("Email"));
	}
	public WebElement getlabel()
	{
		//return driver.findElement(Email);
		return driver.findElement(pdf);
	}

	
	//label[contains(text(),'PDF Attachment')]
	public WebElement getdownload()
	{
		return driver.findElement(download);
	}
	
	public WebElement getEAddressField()
	{
		return driver.findElement(EAddressField);
	}
	
	public WebElement getSendBtn()
	{
		return driver.findElement(SendBtn);
	}
	
	
	
	
}
