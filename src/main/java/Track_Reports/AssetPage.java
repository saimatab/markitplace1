package Track_Reports;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssetPage {
	
	public WebDriver driver;
	
	public AssetPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By Pagination2 = By.xpath("(//a[@class='page-link'])[1]");
	//By VwDropDown=By.id("reportViewSelect");
	By VwDropDown=By.id("view");
	By Column1stDropdown=By.xpath("(//div[@class='filter-search-drop-arrow'])[1]");
	//By APCRow=By.xpath("(//span[@class='control__indicator'])[1]");
	By APCRow=By.xpath("//label[contains(text(),'APPLE')]");

	By ApplyBtn=By.xpath("(//a[text()='Apply'])[1]");
	By RowRecord1st=By.xpath("//td[@label-data='Mfg']");
	By SaveBtn=By.id("save");
	By NameTextBox=By.id("report_name");
	By SaveDefaultCheck=By.id("save_default_view");
	By SaveRpt=By.xpath("//button[text()='Save']");
	By EditScheduleReport=By.xpath("//*[@id='schedule']");
	By SaveRpt1=By.xpath("//button[@class='btn btn-primary'][contains(text(),'Save')]");
	By ScheduleReportButton=By.xpath("//button[@class='btn btn-primary'][contains(text(),'Schedule Report')]");
	By ExportReport=By.xpath("//button[@class='btn btn-primary'][contains(text(),'Export Report')]");
	By ExportButton=By.xpath("//*[@class='action-btn-container']//a[contains(text(),'Export')]");
	By ExportButtonCurrentPage=By.xpath("//*[@class='modal-row clearfix']//input[@id='current_page']");
	By EditAssetReport=By.xpath("//*[@id='save']");
	By EditReportSaveButton = By.xpath("//*[@id=\"reportForm\"]/div[20]/div/div/div/div/form/div/button[1]");
	By EditReportDefaultView = By.xpath("//*[@class='white-popup popup-small zoom-anim-dialog mfp-show save-modal']//label/input");
	By EmailAddress = By.xpath("//*[@id='schedule_email']");
	By SelectionOfRow =By.xpath("//*[@class='mobile-table']//tr[2]//span[@class='control__indicator']");
	By EmailSelectedBtn = By.xpath("//*[@class='report-header clearfix']//*[@class='container']//*[@class='action-btn-container']//a[contains(text(),'Email Selected')]");
	By OrderNumberReport= By.xpath("//*[@class='mobile-table']//tr[8]/td[@label-data='Order #']/a");
	By SubTotalReport = By.xpath("//*[@class='mobile-table']//tr[8]/td[@label-data='Subtotal']");
	By SubTotalOrderDetail = By.xpath("//*[@class='row subtotal']//span");
	By SelectFields = By.xpath("//*[@id='selectFields']");
	By ApplySelectionFields = By.xpath("//*[@class='white-popup popup-small zoom-anim-dialog mfp-show schedule-report-modal select-fields clearfix']//button[contains(text(),'Apply')]");
	By ViewButton = By.xpath("//*[@class='order-container container clearfix']//li[1]//a[contains(text(),'View order')]");
	
	
	
	
	public WebElement getViewButton()
	{
		return driver.findElement(ViewButton);
	}
	
	public WebElement getApplySelectionFields()
	{
		return driver.findElement(ApplySelectionFields);
	}
	
	public WebElement getSelectFields()
	{
		return driver.findElement(SelectFields);
	}
	
	public WebElement getSubTotalOrderDetail()
	{
		return driver.findElement(SubTotalOrderDetail);
	}
	
	
	public WebElement getSubTotalReport()
	{
		return driver.findElement(SubTotalReport);
	}
	
	public WebElement getOrderNumberReport()
	{
		return driver.findElement(OrderNumberReport);
	}
	
	public WebElement getEmailSelectedBtn()
	{
		return driver.findElement(EmailSelectedBtn);
	}
	
	
	public WebElement getSelectionOfRow()
	{
		return driver.findElement(SelectionOfRow);
	}
	
	public WebElement getEmailAddress()
	{
		return driver.findElement(EmailAddress);
	}
	
	public WebElement getExportButtonCurrentPage()
	{
		return driver.findElement(ExportButtonCurrentPage);
	}
	
	public WebElement getExportReport()
	{
		return driver.findElement(ExportReport);
	}
	
	public WebElement getExportButton()
	{
		return driver.findElement(ExportButton);
	}
	
	
	public WebElement getScheduleReportButton()
	{
		return driver.findElement(ScheduleReportButton);
	}
	
	
	public WebElement getEditScheduleReport()
	{
		return driver.findElement(EditScheduleReport);
	}
	
	public WebElement getEditReportDefaultView()
	{
		return driver.findElement(EditReportDefaultView);
	}
	
	public WebElement getEditReportSaveButton()
	{
		return driver.findElement(EditReportSaveButton);
	}
	
	public WebElement getEditAssetReport()
	{
		return driver.findElement(EditAssetReport);
	}
	
	
	public WebElement getSaveRpt()
	{
		return driver.findElement(SaveRpt);
	}
	
	public WebElement getSaveRpt1()
	{
		return driver.findElement(SaveRpt1);
	}
	
	public WebElement getSaveDefaultCheck()
	{
		return driver.findElement(SaveDefaultCheck);
	}
	
	public WebElement getNameTextBox()
	{
		return driver.findElement(NameTextBox);
	}
	
	public WebElement getSaveBtn()
	{
		return driver.findElement(SaveBtn);
	}
	
	public WebElement getRowRecord1st()
	{
		return driver.findElement(RowRecord1st);
	}
	
	public WebElement getApplyBtn()
	{
		return driver.findElement(ApplyBtn);
	}
	
	
	public WebElement getAPCRow()
	{
		return driver.findElement(APCRow);
	}
	
	public WebElement getColumn1stDropdown()
	{
		return driver.findElement(Column1stDropdown);
	}
	
	public WebElement getVwDropDown()
	{
		return driver.findElement(VwDropDown);
	}
	
	public WebElement get2ndPagination()
	{
		return driver.findElement(Pagination2);
	}
	

}
