package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Home.CommonFunctions;
import Home.Header;
import Home.HomePage;
import Home.LoginPage;
import Home.MyProfilePage;
import Shop_Cart.CartPage;
import Shop_Cart.CheckoutPage;
import Shop_MainPage.SearchResultPage;
import Shop_ProductDetail.PDP;
import Track_PurchaseAnalysis.PurchaseAnalysis;
import resources.base;

public class SmokeTestsSuite extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	public HomePage hp;
	public MyProfilePage mpp;
	public SearchResultPage Srp;
	public CheckoutPage CO;
	public static WebDriver driver;
	public Properties prop;
	public Header hdr;
	public CommonFunctions cf;
	public FileInputStream fis;
	public LoginPage lp;
	public WebDriverWait wait;
	public PDP pp;
	public CartPage CP;

	////
	public SmokeTestsSuite() throws IOException, InterruptedException {// jjjjhhh
		driver = getdriver();
		driver = initializeDriver();
		driver = getdriver();
		Srp = new SearchResultPage(driver);
		CO = new CheckoutPage(driver);
		lp = new LoginPage(driver);
		hdr = new Header(driver);
		mpp = new MyProfilePage(driver);
		hp = new HomePage(driver);
		cf = new CommonFunctions(driver);
		pp = new PDP(driver);
		CP = new CartPage(driver);
		prop = new Properties();
		fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
	}

	@Parameters({ "username3", "pswd3", "url" })
	@Test(priority = 30, description = "PAR Creation", enabled = true)
	public void Validate_Checkout_PAR(String username3, String pswd3, String url)
			throws IOException, InterruptedException {

		try {
			driver = getdriver();

			// driver=initializeDriver();
			Srp = new SearchResultPage(driver);
			CO = new CheckoutPage(driver);
			lp = new LoginPage(driver);
			hdr = new Header(driver);
			mpp = new MyProfilePage(driver);
			hp = new HomePage(driver);
			cf = new CommonFunctions(driver);
			pp = new PDP(driver);
			CP = new CartPage(driver);
			prop = new Properties();
			fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);

			WebDriverWait wait = new WebDriverWait(driver, 120);
			driver.get(url);

			wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
			lp.getusername().sendKeys(username3);
			lp.getpassword().sendKeys(pswd3);
			Thread.sleep(7000);
			lp.getloginbtn().click();
			Thread.sleep(7000);
			String TitleHome = driver.getTitle();

			hp.getsearchbox().sendKeys("HP laptop" + Keys.ENTER);
			Thread.sleep(10000);
			String title3 = driver.getTitle();

			By pop1 = By.xpath("//div[@class='alert alert-info permission-boxalert alert-info permission-box']");

			if (CO.isElementPresent(pop1)) {

			} else if (title3.contentEquals("HP Laptop - MarkITplace"))

			{

				By getnow3;

				String id = "18264785";
				String Drop[] = { "18264785", "18264782", "16992247", "17594265", "17244138" };

				// String DropdownOptionsExp[] = {"saima tab saima tab, a6721574@jj67j74.com,
				// Administrator" };
				for (int j = 1; j < 10; j++) {

					String xp = "//div[@class='product-list-grid clearfix print-product-list pro-list grid']//div[@data-id='"
							+ Drop[j]
							+ "']//div[@class='product-grid-item-content clearfix']//div[@class='list-item-right']//div[@class='cart-container clearfix']//a[@class='add_to_cart btn btn-primary']";
					// System.out.println(xp);

					getnow3 = By.xpath(xp);

					if (CO.isElementPresent(getnow3)) {

						driver.findElement(getnow3).click();
						break;
					}

				}

				By pop = By.xpath("//span[contains(text(),'Oops something went wrong. Please try again.')]");

				if (CO.isElementPresent(pop)) {

					driver.navigate().back();
					Thread.sleep(5000);
					Assert.assertTrue(false, "Failed" + "Oops something went wrong. Please try again.");
				}

				else {
					// Thread.sleep(30000);
					By pop2 = By.xpath(
							"//div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog mfp-show cart-modal ad-t-crt-mdl-only']");

					// WebElement
					// pop2=driver.findElement(By.xpath("/div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog
					// mfp-show cart-modal ad-t-crt-mdl-only']"));
					WebDriverWait wait2 = new WebDriverWait(driver, 120);
					wait2.until(ExpectedConditions.visibilityOfElementLocated(pop2));

					CP.getdrop().click();
					Thread.sleep(5000);
					CP.getPARBtn().click();
					Thread.sleep(10000);
					Random random = new Random();
					int x = random.nextInt(90000) + 100;
					try {

						wait.until(ExpectedConditions.elementToBeClickable(CO.getPO()));
						CO.getparPO().sendKeys((String.valueOf(x)));
						Thread.sleep(5000);
						CO.getref().sendKeys("PO_" + String.valueOf(x));
						Thread.sleep(5000);
						CO.getCC().sendKeys("costcenter");
						Thread.sleep(5000);

						Select se1 = new Select(CO.getApprovalGroupDropDown());
						se1.selectByValue("100");
						Thread.sleep(5000);
						By usediffshipAddress = By.xpath("//a[@class='use-different-s-address']");

						if (CO.isElementPresent(usediffshipAddress)) {

							CO.getuseDiffShipAddress().click();
							Thread.sleep(5000);
							wait.until(ExpectedConditions.elementToBeClickable(CO.getshipadd()));
							Thread.sleep(5000);
							CO.getshipadd().click();
							Thread.sleep(5000);
							CO.getUseThisAddress().click();

						} else {
							wait.until(ExpectedConditions.elementToBeClickable(CO.getshipadd()));
							Thread.sleep(6000);
							CO.getshipadd().click();
							Thread.sleep(5000);
							CO.getUseThisAddress().click();

						}

						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(CO.getinst()));
						CO.getinst().sendKeys("PARTest1");

						wait.until(ExpectedConditions.elementToBeClickable(CO.getAttention()));
						CO.getAttention().sendKeys("PARTest1");

						wait.until(ExpectedConditions.elementToBeClickable(CO.getEmailConfirm()));
						CO.getEmailConfirm().clear();
						CO.getEmailConfirm().sendKeys("ayer.shuja@arpatech.com");
						Thread.sleep(10000);
						wait.until(ExpectedConditions.elementToBeClickable(CO.getPurchaseApproval()));
						Thread.sleep(10000);
						CO.getPurchaseApproval().click();
						Thread.sleep(20000);
						System.out.println(CO.getMessage().getText());
						System.out.println(CO.getMessage1().getText());
						Thread.sleep(10000);
						cf.logout();
						Thread.sleep(10000);

					}

					catch (org.openqa.selenium.NoSuchElementException e) {

						e.printStackTrace();
						driver.navigate().back();

						Thread.sleep(5000);

						Assert.assertTrue(false, "Failed" + e.getMessage());

					}
					By creditlimitval = By.xpath(
							"//div[@class='modal-dialog']//div[@class='modal-body']//span[contains(text(),'Credit limit reached. Please contact your account')]");

					if ((CO.isElementPresent(creditlimitval))) {
						CO.getcreditLimitValid().getText();
						Thread.sleep(5000);

						CO.getclose1().click();
						Thread.sleep(5000);

						Assert.assertTrue(false, "Credit limit reached");
					}

					By PARcannotProcess = By.xpath(
							"//div[@class='modal-dialog']//div[@class='modal-body']//span[contains(text(),'Oops! Your PAR could not be processed at this time. Your Account Team is ready to help or try again')]");

					if ((CO.isElementPresent(PARcannotProcess))) {
						CO.PARCannotProcess().getText();
						Thread.sleep(5000);

						CO.getclose1().click();
						Thread.sleep(5000);
						Assert.assertTrue(false, "Failed PAR cannot Process");

					}
				}

			}
		}

		catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();

			Thread.sleep(5000);

			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			String title6 = driver.getTitle();
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) {
			String title6 = driver.getTitle();
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "username1", "pswd1", "url" })
	@Test(priority = 31, description = "PAR Creation", enabled = true)
	public void Validate_Checkout_PAR_FromPARCredential(String username1, String pswd1, String url)
			throws IOException, InterruptedException {

		try {
			driver = getdriver();

			// driver=initializeDriver();
			Srp = new SearchResultPage(driver);
			CO = new CheckoutPage(driver);
			lp = new LoginPage(driver);
			hdr = new Header(driver);
			mpp = new MyProfilePage(driver);
			hp = new HomePage(driver);
			cf = new CommonFunctions(driver);
			pp = new PDP(driver);
			CP = new CartPage(driver);
			prop = new Properties();
			fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);

			WebDriverWait wait = new WebDriverWait(driver, 120);
			driver.get(url);

			wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
			lp.getusername().sendKeys(username1);
			lp.getpassword().sendKeys(pswd1);
			Thread.sleep(7000);
			lp.getloginbtn().click();
			Thread.sleep(7000);
			String TitleHome = driver.getTitle();

			hp.getsearchbox().sendKeys("HP laptop" + Keys.ENTER);
			Thread.sleep(10000);
			String title3 = driver.getTitle();

			By pop1 = By.xpath("//div[@class='alert alert-info permission-boxalert alert-info permission-box']");

			if (CO.isElementPresent(pop1)) {

			} else if (title3.contentEquals("HP Laptop - MarkITplace"))

			{

				By getnow3;

				String id = "18264785";
				String Drop[] = { "18264785", "18264782", "16992247", "17594265", "17244138" };

				// String DropdownOptionsExp[] = {"saima tab saima tab, a6721574@jj67j74.com,
				// Administrator" };
				for (int j = 0; j < 5; j++) {

					String xp = "//div[@class='product-list-grid clearfix print-product-list pro-list grid']//div[@data-id='"
							+ Drop[j]
							+ "']//div[@class='product-grid-item-content clearfix']//div[@class='list-item-right']//div[@class='cart-container clearfix']//a[@class='add_to_cart btn btn-primary']";
					// System.out.println(xp);

					getnow3 = By.xpath(xp);

					if (CO.isElementPresent(getnow3)) {

						driver.findElement(getnow3).click();
						break;
					}

				}

				By pop = By.xpath("//span[contains(text(),'Oops something went wrong. Please try again.')]");

				if (CO.isElementPresent(pop)) {

					driver.navigate().back();
					Thread.sleep(5000);
					Assert.assertTrue(false, "Failed" + "Oops something went wrong. Please try again.");
				}

				else {
					// Thread.sleep(30000);
					By pop2 = By.xpath(
							"//div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog mfp-show cart-modal ad-t-crt-mdl-only']");

					// WebElement
					// pop2=driver.findElement(By.xpath("/div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog
					// mfp-show cart-modal ad-t-crt-mdl-only']"));
					WebDriverWait wait2 = new WebDriverWait(driver, 120);
					wait2.until(ExpectedConditions.visibilityOfElementLocated(pop2));

					CP.PARSelect().click();
//					Thread.sleep(5000);
//					CP.getPARBtn().click();
					Thread.sleep(10000);
					Random random = new Random();
					int x = random.nextInt(90000) + 100;
					try {

						wait.until(ExpectedConditions.elementToBeClickable(CO.getPO()));
//						CO.getparPO().sendKeys((String.valueOf(x)));
//						Thread.sleep(5000);
//						CO.getref().sendKeys("PO_" + String.valueOf(x));
//						Thread.sleep(5000);
//						CO.getCC().sendKeys("costcenter");
//						Thread.sleep(5000);

						Select se1 = new Select(CO.getApprovalGroupDropDown());
						se1.selectByValue("700");
						Thread.sleep(5000);
						By usediffshipAddress = By.xpath("//a[@class='use-different-s-address']");

						if (CO.isElementPresent(usediffshipAddress)) {

							CO.getuseDiffShipAddress().click();
							Thread.sleep(5000);
							wait.until(ExpectedConditions.elementToBeClickable(CO.getshipadd()));
							Thread.sleep(5000);
							CO.getshipadd().click();
							Thread.sleep(5000);
							CO.getUseThisAddress().click();

						} else {
							wait.until(ExpectedConditions.elementToBeClickable(CO.getshipadd()));
							Thread.sleep(6000);
							CO.getshipadd().click();
							Thread.sleep(5000);
							CO.getUseThisAddress().click();

						}

						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(CO.getinst()));
						CO.getinst().sendKeys("PARTest1");

						wait.until(ExpectedConditions.elementToBeClickable(CO.getAttention()));
						CO.getAttention().sendKeys("PARTest1");

						wait.until(ExpectedConditions.elementToBeClickable(CO.getEmailConfirm()));
						CO.getEmailConfirm().clear();
						CO.getEmailConfirm().sendKeys("ayer.shuja@arpatech.com");
						Thread.sleep(10000);
						wait.until(ExpectedConditions.elementToBeClickable(CO.getPurchaseApproval()));
						Thread.sleep(10000);
						CO.getPurchaseApproval().click();
						Thread.sleep(20000);
						Thread.sleep(20000);
						System.out.println(CO.getMessage().getText());
						System.out.println(CO.getMessage1().getText());

					}

					catch (org.openqa.selenium.NoSuchElementException e) {

						e.printStackTrace();
						driver.navigate().back();

						Thread.sleep(5000);

						Assert.assertTrue(false, "Failed" + e.getMessage());

					}
					By creditlimitval = By.xpath(
							"//div[@class='modal-dialog']//div[@class='modal-body']//span[contains(text(),'Credit limit reached. Please contact your account')]");

					if ((CO.isElementPresent(creditlimitval))) {
						CO.getcreditLimitValid().getText();
						Thread.sleep(5000);

						CO.getclose1().click();
						Thread.sleep(5000);

						Assert.assertTrue(false, "Credit limit reached");
					}

					By PARcannotProcess = By.xpath(
							"//div[@class='modal-dialog']//div[@class='modal-body']//span[contains(text(),'Oops! Your PAR could not be processed at this time. Your Account Team is ready to help or try again')]");

					if ((CO.isElementPresent(PARcannotProcess))) {
						CO.PARCannotProcess().getText();
						Thread.sleep(5000);

						CO.getclose1().click();
						Thread.sleep(5000);
						Assert.assertTrue(false, "Failed PAR cannot Process");

					}
				}

			}
		}

		catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();

			Thread.sleep(5000);

			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			String title6 = driver.getTitle();
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) {
			String title6 = driver.getTitle();
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Test(priority = 32, description = "PAR listing Page", enabled = true)
	public void Validate_PAR_listingPage() throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 120);
		try {

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			Thread.sleep(5000);
			hdr.getTrackBtn().click();
			Thread.sleep(7000);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getPARBtn()));
			hdr.getPARBtn().click();
			Thread.sleep(10000);
			// System.out.println("All Good");
			// wait.until(ExpectedConditions.titleContains("PARs - MarkITplace"));
			// cf.logout();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			e.printStackTrace();
			driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();

			driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Test(priority = 33, description = "Validate_PAR_Approval_FromAGPurchaser", enabled = true)
	public void Validate_PAR_Approval_FromAGPurchaser() throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 240);
		try {
			Thread.sleep(20000);
			String PONum = hdr.getPONumber().getText();
			String status = hdr.ParStatus().getText();
			System.out.println("The status of PO Number :" + PONum + " is " + status);
			Thread.sleep(5000);
			hdr.getApproveBtn().click();
			Thread.sleep(7000);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.PARAfterCreationClose()));
			hdr.PARAfterCreationClose().click();
			Thread.sleep(7000);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.GetpurchaseRequestStatus()));
			hdr.GetpurchaseRequestStatus().click();
			Thread.sleep(10000);
			String status1 = hdr.GetPARstatus().getText();
			String status2 = hdr.GetParDate().getText();
			System.out.println("The status of PO Number :" + PONum + " is " + status1 + " Dated on " + status2
					+ " by arpatech ag_puchaser and Pending by arpatech ag_approver");
			Thread.sleep(7000);
			cf.logout();

			Thread.sleep(10000);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			// driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			e.printStackTrace();
			// driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();

			// driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "username7", "pswd7", "url" })
	@Test(priority = 34, enabled = true)
	public void Validate_PAR_Approval_FromAGApproval(String username7, String pswd7, String url)
			throws InterruptedException {
		wait = new WebDriverWait(driver, 120);
		try {

			Thread.sleep(7000);
			System.out.println("PAR_Approval_FromAGApproval");

//			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
//
//			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(tabs.get(1)); // switches to new tab
			driver.navigate().to(url);
			Thread.sleep(7000);

			wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
			lp.getusername().sendKeys(username7);
			lp.getpassword().sendKeys(pswd7);
			Thread.sleep(7000);
			lp.getloginbtn().click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			Thread.sleep(5000);
			hdr.getTrackBtn().click();
			Thread.sleep(7000);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getPARBtn()));
			hdr.getPARBtn().click();

			Thread.sleep(20000);
			String PONum = hdr.getPONumber().getText();
			String status = hdr.ParStatus().getText();
			System.out.println("The status of PO Number :" + PONum + " is " + status);
			Thread.sleep(5000);
			hdr.getApproveBtn().click();
			Thread.sleep(7000);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.PARAfterCreationClose()));
			hdr.PARAfterCreationClose().click();
			Thread.sleep(7000);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.GetpurchaseRequestStatus()));
			hdr.GetpurchaseRequestStatus().click();
			Thread.sleep(10000);
			String status3 = hdr.PARApprovalOrderDetail().getText();
			System.out.println("The status of PO Number :" + status3
					+ "is Approved by ag_puchaser and also approved by ag_approver");
			Thread.sleep(10000);
			driver.quit();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			e.printStackTrace();
			// driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			e.printStackTrace();
			// driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) {

			e.printStackTrace();

			// driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "username7", "pswd7", "url" })
	@Test(priority = 35, enabled = true)
	public void Validate_PAR_Approval_Scenario2(String username7, String pswd7, String url)
			throws IOException, InterruptedException {

		System.out.println("Test scenario :"
				+ "Verify PAR Approval Created from AG purchaser and firstly approved by AG approval then approved by ag_purchaser");
		try {
			//driver = getdriver();

			// driver=initializeDriver();
			Srp = new SearchResultPage(driver);
			CO = new CheckoutPage(driver);
			lp = new LoginPage(driver);
			hdr = new Header(driver);
			mpp = new MyProfilePage(driver);
			hp = new HomePage(driver);
			cf = new CommonFunctions(driver);
			pp = new PDP(driver);
			CP = new CartPage(driver);
			prop = new Properties();
			fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);

			WebDriverWait wait = new WebDriverWait(driver, 120);
			driver.get(url);

			wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
			lp.getusername().sendKeys(username7);
			lp.getpassword().sendKeys(pswd7);
			Thread.sleep(7000);
			lp.getloginbtn().click();
			Thread.sleep(7000);
			String TitleHome = driver.getTitle();

			hp.getsearchbox().sendKeys("HP laptop" + Keys.ENTER);
			Thread.sleep(10000);
			String title3 = driver.getTitle();

			By pop1 = By.xpath("//div[@class='alert alert-info permission-boxalert alert-info permission-box']");

			if (CO.isElementPresent(pop1)) {

			} else if (title3.contentEquals("HP Laptop - MarkITplace"))

			{

				By getnow3;

				String id = "18264785";
				String Drop[] = { "18264785", "18264782", "16992247", "17594265", "17244138" };

				// String DropdownOptionsExp[] = {"saima tab saima tab, a6721574@jj67j74.com,
				// Administrator" };
				for (int j = 1; j < 10; j++) {

					String xp = "//div[@class='product-list-grid clearfix print-product-list pro-list grid']//div[@data-id='"
							+ Drop[j]
							+ "']//div[@class='product-grid-item-content clearfix']//div[@class='list-item-right']//div[@class='cart-container clearfix']//a[@class='add_to_cart btn btn-primary']";
					// System.out.println(xp);

					getnow3 = By.xpath(xp);

					if (CO.isElementPresent(getnow3)) {

						driver.findElement(getnow3).click();
						break;
					}

				}

				By pop = By.xpath("//span[contains(text(),'Oops something went wrong. Please try again.')]");

				if (CO.isElementPresent(pop)) {

					driver.navigate().back();
					Thread.sleep(5000);
					Assert.assertTrue(false, "Failed" + "Oops something went wrong. Please try again.");
				}

				else {
					// Thread.sleep(30000);
					By pop2 = By.xpath(
							"//div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog mfp-show cart-modal ad-t-crt-mdl-only']");

					// WebElement
					// pop2=driver.findElement(By.xpath("/div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog
					// mfp-show cart-modal ad-t-crt-mdl-only']"));
					WebDriverWait wait2 = new WebDriverWait(driver, 120);
					wait2.until(ExpectedConditions.visibilityOfElementLocated(pop2));

					CP.getdrop().click();
					Thread.sleep(5000);
					CP.getPARBtn().click();
					Thread.sleep(10000);
					Random random = new Random();
					int x = random.nextInt(90000) + 100;
					try {



						Select se1 = new Select(CO.getApprovalGroupDropDown());
						se1.selectByValue("700");
						Thread.sleep(5000);
						By usediffshipAddress = By.xpath("//a[@class='use-different-s-address']");

						if (CO.isElementPresent(usediffshipAddress)) {

							CO.getuseDiffShipAddress().click();
							Thread.sleep(5000);
							wait.until(ExpectedConditions.elementToBeClickable(CO.getshipadd()));
							Thread.sleep(5000);
							CO.getshipadd().click();
							Thread.sleep(5000);
							CO.getUseThisAddress().click();

						} else {
							wait.until(ExpectedConditions.elementToBeClickable(CO.getshipadd()));
							Thread.sleep(6000);
							CO.getshipadd().click();
							Thread.sleep(5000);
							CO.getUseThisAddress().click();

						}

						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(CO.getinst()));
						CO.getinst().sendKeys("PARTest1");

						wait.until(ExpectedConditions.elementToBeClickable(CO.getAttention()));
						CO.getAttention().sendKeys("PARTest1");

						wait.until(ExpectedConditions.elementToBeClickable(CO.getEmailConfirm()));
						CO.getEmailConfirm().clear();
						CO.getEmailConfirm().sendKeys("ayer.shuja@arpatech.com");
						Thread.sleep(10000);
						wait.until(ExpectedConditions.elementToBeClickable(CO.getPurchaseApproval()));
						Thread.sleep(10000);
						CO.getPurchaseApproval().click();
						Thread.sleep(20000);
						System.out.println(CO.getMessage().getText());
						Thread.sleep(10000);

						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
						Thread.sleep(5000);
						hdr.getTrackBtn().click();
						Thread.sleep(7000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.getPARBtn()));
						hdr.getPARBtn().click();
						Thread.sleep(10000);

						String PONum = hdr.getPONumber().getText();
						String status = hdr.ParStatus().getText();
						System.out.println("The status of PO Number :" + PONum + " is " + status);
						Thread.sleep(5000);
						hdr.getApproveBtn().click();
						Thread.sleep(7000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.PARAfterCreationClose()));
						hdr.PARAfterCreationClose().click();
						Thread.sleep(7000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.GetpurchaseRequestStatus()));
						hdr.GetpurchaseRequestStatus().click();
						Thread.sleep(10000);
						String status1 = hdr.GetPARstatus().getText();
						String status2 = hdr.GetParDate().getText();
						System.out.println("The status of PO Number :" + PONum + " is " + status1 + " Dated on "
								+ status2 + " by arpatech ag_approver and Pending by arpatech ag_puchaser");

						cf.logout();

						Thread.sleep(20000);

						driver.navigate().to(url);
						Thread.sleep(10000);

						lp.getusername().sendKeys("arpatech_ag_puchaser@connection.com");
						lp.getpassword().sendKeys("[6D.,58Nq%4{rSu");
						Thread.sleep(7000);
						lp.getloginbtn().click();

						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
						Thread.sleep(5000);
						hdr.getTrackBtn().click();
						Thread.sleep(7000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.getPARBtn()));
						hdr.getPARBtn().click();
						Thread.sleep(10000);

						String PONum1 = hdr.getPONumber().getText();
						String status3 = hdr.ParStatus().getText();
						System.out.println("The status of PO Number :" + PONum1 + " is " + status3);
						Thread.sleep(5000);
						hdr.getApproveBtn().click();
						Thread.sleep(7000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.PARAfterCreationClose()));
						hdr.PARAfterCreationClose().click();
						Thread.sleep(7000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.GetpurchaseRequestStatus()));
						hdr.GetpurchaseRequestStatus().click();
						Thread.sleep(10000);
						String status31 = hdr.PARApprovalOrderDetail().getText();
						System.out.println("The status of PO Number :" + status31
								+ "is Approved by ag_puchaser and also approved by ag_approver");
						Thread.sleep(10000);

						cf.logout();
						//driver.quit();

					}

					catch (org.openqa.selenium.NoSuchElementException e) {

						e.printStackTrace();
						// driver.navigate().back();

						Thread.sleep(5000);

						Assert.assertTrue(false, "Failed" + e.getMessage());

					}
					By creditlimitval = By.xpath(
							"//div[@class='modal-dialog']//div[@class='modal-body']//span[contains(text(),'Credit limit reached. Please contact your account')]");

					if ((CO.isElementPresent(creditlimitval))) {
						CO.getcreditLimitValid().getText();
						Thread.sleep(5000);

						CO.getclose1().click();
						Thread.sleep(5000);

						Assert.assertTrue(false, "Credit limit reached");
					}

					By PARcannotProcess = By.xpath(
							"//div[@class='modal-dialog']//div[@class='modal-body']//span[contains(text(),'Oops! Your PAR could not be processed at this time. Your Account Team is ready to help or try again')]");

					if ((CO.isElementPresent(PARcannotProcess))) {
						CO.PARCannotProcess().getText();
						Thread.sleep(5000);

						CO.getclose1().click();
						Thread.sleep(5000);
						Assert.assertTrue(false, "Failed PAR cannot Process");

					}
				}

			}
		}

		catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();

			Thread.sleep(5000);

			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			String title6 = driver.getTitle();
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) {
			String title6 = driver.getTitle();
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "username1", "pswd1", "url" })
	@Test(priority = 36, enabled = true)
	public void Validate_PAR_Approval_Scenario3(String username1, String pswd1, String url)
			throws IOException, InterruptedException {

		System.out.println("Test scenario :"
				+ "Verify PAR Approval Created from AG purchaser and firstly approved by AG_approval then approved by ag_purchaser");
		try {
			//driver = getdriver();

			// driver=initializeDriver();
			Srp = new SearchResultPage(driver);
			CO = new CheckoutPage(driver);
			lp = new LoginPage(driver);
			hdr = new Header(driver);
			mpp = new MyProfilePage(driver);
			hp = new HomePage(driver);
			cf = new CommonFunctions(driver);
			pp = new PDP(driver);
			CP = new CartPage(driver);
			prop = new Properties();
			fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);

			WebDriverWait wait = new WebDriverWait(driver, 120);
			driver.get(url);

			wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
			lp.getusername().sendKeys(username1);
			lp.getpassword().sendKeys(pswd1);
			Thread.sleep(7000);
			lp.getloginbtn().click();
			Thread.sleep(7000);
			String TitleHome = driver.getTitle();

			hp.getsearchbox().sendKeys("HP laptop" + Keys.ENTER);
			Thread.sleep(10000);
			String title3 = driver.getTitle();

			By pop1 = By.xpath("//div[@class='alert alert-info permission-boxalert alert-info permission-box']");

			if (CO.isElementPresent(pop1)) {

			} else if (title3.contentEquals("HP Laptop - MarkITplace"))

			{

				By getnow3;

				String id = "18264785";
				String Drop[] = { "18264785", "18264782", "16992247", "17594265", "17244138" };

				// String DropdownOptionsExp[] = {"saima tab saima tab, a6721574@jj67j74.com,
				// Administrator" };
				for (int j = 0; j < 5; j++) {

					String xp = "//div[@class='product-list-grid clearfix print-product-list pro-list grid']//div[@data-id='"
							+ Drop[j]
							+ "']//div[@class='product-grid-item-content clearfix']//div[@class='list-item-right']//div[@class='cart-container clearfix']//a[@class='add_to_cart btn btn-primary']";
					// System.out.println(xp);

					getnow3 = By.xpath(xp);

					if (CO.isElementPresent(getnow3)) {

						driver.findElement(getnow3).click();
						break;
					}

				}

				By pop = By.xpath("//span[contains(text(),'Oops something went wrong. Please try again.')]");

				if (CO.isElementPresent(pop)) {

					driver.navigate().back();
					Thread.sleep(5000);
					Assert.assertTrue(false, "Failed" + "Oops something went wrong. Please try again.");
				}

				else {
					// Thread.sleep(30000);
					By pop2 = By.xpath(
							"//div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog mfp-show cart-modal ad-t-crt-mdl-only']");

					WebDriverWait wait2 = new WebDriverWait(driver, 120);
					wait2.until(ExpectedConditions.visibilityOfElementLocated(pop2));

					CP.PARSelect().click();
//					Thread.sleep(5000);
//					CP.getPARBtn().click();
					Thread.sleep(10000);
					Random random = new Random();
					int x = random.nextInt(90000) + 100;
					try {

						wait.until(ExpectedConditions.elementToBeClickable(CO.getPO()));
//						CO.getparPO().sendKeys((String.valueOf(x)));
//						Thread.sleep(5000);
//						CO.getref().sendKeys("PO_" + String.valueOf(x));
//						Thread.sleep(5000);
//						CO.getCC().sendKeys("costcenter");
//						Thread.sleep(5000);

						Select se1 = new Select(CO.getApprovalGroupDropDown());
						se1.selectByValue("700");
						Thread.sleep(5000);
						By usediffshipAddress = By.xpath("//a[@class='use-different-s-address']");

						if (CO.isElementPresent(usediffshipAddress)) {

							CO.getuseDiffShipAddress().click();
							Thread.sleep(5000);
							wait.until(ExpectedConditions.elementToBeClickable(CO.getshipadd()));
							Thread.sleep(5000);
							CO.getshipadd().click();
							Thread.sleep(5000);
							CO.getUseThisAddress().click();

						} else {
							wait.until(ExpectedConditions.elementToBeClickable(CO.getshipadd()));
							Thread.sleep(6000);
							CO.getshipadd().click();
							Thread.sleep(5000);
							CO.getUseThisAddress().click();

						}

						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(CO.getinst()));
						CO.getinst().sendKeys("PARTest1");

						wait.until(ExpectedConditions.elementToBeClickable(CO.getAttention()));
						CO.getAttention().sendKeys("PARTest1");

						wait.until(ExpectedConditions.elementToBeClickable(CO.getEmailConfirm()));
						CO.getEmailConfirm().clear();
						CO.getEmailConfirm().sendKeys("ayer.shuja@arpatech.com");
						Thread.sleep(10000);
						wait.until(ExpectedConditions.elementToBeClickable(CO.getPurchaseApproval()));
						Thread.sleep(10000);
						CO.getPurchaseApproval().click();
						Thread.sleep(20000);
						System.out.println(CO.getMessage().getText());
						// System.out.println(CO.getMessage1().getText());

						// ----new---

						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
						Thread.sleep(5000);
						hdr.getTrackBtn().click();
						Thread.sleep(7000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.getPARBtn()));
						hdr.getPARBtn().click();
						Thread.sleep(10000);

						String PONum = hdr.getPONumber().getText();
						String status = hdr.ParStatus().getText();
						System.out.println("The status of PO Number :" + PONum + " is " + status);
						Thread.sleep(5000);
//						hdr.getApproveBtn().click();
//						Thread.sleep(7000);
//						wait.until(ExpectedConditions.elementToBeClickable(hdr.PARAfterCreationClose()));
//						hdr.PARAfterCreationClose().click();
//						Thread.sleep(7000);
//						wait.until(ExpectedConditions.elementToBeClickable(hdr.GetpurchaseRequestStatus()));
//						hdr.GetpurchaseRequestStatus().click();
//						Thread.sleep(10000);
//						String status1 = hdr.GetPARstatus().getText();
//						String status2 = hdr.GetParDate().getText();
//						System.out.println("The status of PO Number :" + PONum + " is " + status1 + " Dated on "
//								+ status2 + " by arpatech ag_approver and Pending by arpatech ag_puchaser");

						cf.logout();

						Thread.sleep(20000);

						driver.navigate().to(url);
						Thread.sleep(10000);

						lp.getusername().sendKeys("arpatech_ag_approver@connection.com");
						lp.getpassword().sendKeys("Q7#[qK~7B.MNrru@");
						Thread.sleep(7000);
						lp.getloginbtn().click();

						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
						Thread.sleep(5000);
						hdr.getTrackBtn().click();
						Thread.sleep(7000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.getPARBtn()));
						hdr.getPARBtn().click();
						Thread.sleep(10000);

						String PONum1 = hdr.getPONumber().getText();
						String status3 = hdr.ParStatus().getText();
						System.out.println("The status of PO Number :" + PONum1 + " is " + status3);
						Thread.sleep(5000);
						hdr.getApproveBtn().click();
						Thread.sleep(7000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.PARAfterCreationClose()));
						hdr.PARAfterCreationClose().click();
						Thread.sleep(7000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.GetpurchaseRequestStatus()));
						hdr.GetpurchaseRequestStatus().click();
//						Thread.sleep(10000);
//						String status31 = hdr.PARApprovalOrderDetail().getText();
//						System.out.println("The status of PO Number :" + status31
//								+ "is Approved by ag_puchaser and also approved by ag_approver");
//						Thread.sleep(10000);

						// new

						cf.logout();

						Thread.sleep(20000);

						driver.navigate().to(url);
						Thread.sleep(10000);

						lp.getusername().sendKeys(username1);
						lp.getpassword().sendKeys(pswd1);
						Thread.sleep(7000);
						lp.getloginbtn().click();

						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
						Thread.sleep(5000);
						hdr.getTrackBtn().click();
						Thread.sleep(7000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.getPARBtn()));
						hdr.getPARBtn().click();
						Thread.sleep(10000);

						String PONum2 = hdr.getPONumber().getText();
						String status4 = hdr.ParStatus().getText();
						System.out.println("The status of PO Number :" + PONum2 + " is " + status4);
						Thread.sleep(5000);
						hdr.getApproveBtn().click();
						Thread.sleep(7000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.PARAfterCreationClose()));
						hdr.PARAfterCreationClose().click();
						Thread.sleep(7000);
						wait.until(ExpectedConditions.elementToBeClickable(hdr.GetpurchaseRequestStatus()));
						hdr.GetpurchaseRequestStatus().click();

						Thread.sleep(10000);
						String status31 = hdr.PARApprovalOrderDetail().getText();
						System.out.println("The status of PO Number :" + status31
								+ "is Approved by ag_puchaser and also approved by ag_approver");
						Thread.sleep(10000);

					}

					catch (org.openqa.selenium.NoSuchElementException e) {

						e.printStackTrace();
						driver.navigate().back();

						Thread.sleep(5000);

						Assert.assertTrue(false, "Failed" + e.getMessage());

					}
					By creditlimitval = By.xpath(
							"//div[@class='modal-dialog']//div[@class='modal-body']//span[contains(text(),'Credit limit reached. Please contact your account')]");

					if ((CO.isElementPresent(creditlimitval))) {
						CO.getcreditLimitValid().getText();
						Thread.sleep(5000);

						CO.getclose1().click();
						Thread.sleep(5000);

						Assert.assertTrue(false, "Credit limit reached");
					}

					By PARcannotProcess = By.xpath(
							"//div[@class='modal-dialog']//div[@class='modal-body']//span[contains(text(),'Oops! Your PAR could not be processed at this time. Your Account Team is ready to help or try again')]");

					if ((CO.isElementPresent(PARcannotProcess))) {
						CO.PARCannotProcess().getText();
						Thread.sleep(5000);

						CO.getclose1().click();
						Thread.sleep(5000);
						Assert.assertTrue(false, "Failed PAR cannot Process");

					}
				}

			}
		}

		catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();

			Thread.sleep(5000);

			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			String title6 = driver.getTitle();
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) {
			String title6 = driver.getTitle();
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "punchout" })
	@Test(priority = 37, description = "PunchOut_CheckoutPage", enabled = false)
	public void Validate_PunchOut_CheckoutProcess(String punchout) throws IOException, InterruptedException {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("return window.stop");
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			// String punchout = prop.getProperty("punchout");
			WebDriverWait wait = new WebDriverWait(driver, 120);
			driver.get(punchout);
			Thread.sleep(5000);
			// wait.until(ExpectedConditions.titleContains("Standard Products -
			// MarkITplace"));
			// Assert.assertEquals(driver.getTitle(), "Standard Products - MarkITplace",
			// "User is not being able to reach Home page");

			hp.getsearchbox().sendKeys("printers" + Keys.ENTER);
			Thread.sleep(7000);
			String title3 = driver.getTitle();

			if (!title3.contentEquals("Printers - MarkITplace")) {
				Assert.assertEquals(title3, "Printers - MarkITplace");

			}

			By pop = By.xpath("//strong[contains(text(),'No results found')]");
			// CO=new CheckoutPage(driver);

			if (CO.isElementPresent(pop)) {
				driver.navigate().back();
				wait.until(ExpectedConditions.elementToBeClickable(hp.getacctmgmt()));
				Actions actions = new Actions(driver);
				actions.moveToElement(hp.getacctmgmt());
				actions.perform();
				Thread.sleep(5000);
				WebElement s = driver.findElement(
						By.xpath("//div[@class='account-menu']//a[contains(text(),'Return to Buyer App')]"));

				wait.until(ExpectedConditions.elementToBeClickable(s));
				Thread.sleep(5000);

				s.click();
				Assert.assertTrue(false, "Failed" + "No results found");

			} else if (title3.contentEquals("Printers - MarkITplace")) {

				//
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				String a = null, dv = null, dv1 = null;
				WebElement product1;
				// js1.executeScript("window.scrollBy(0,350)");
				// Thread.sleep(5000);
				for (int i = 1; i <= 5; i++)
					// {

					pp = new PDP(driver);

				Thread.sleep(10000);

				// wait.until(ExpectedConditions.elementToBeClickable(pp.getCartbtn()));
				// Thread.sleep(10000);

				if (Srp.getaddcartfirst().isDisplayed()) {

					wait.until(ExpectedConditions.elementToBeClickable(Srp.getaddcartfirst()));
					Thread.sleep(5000);
					Srp.getaddcartfirst().click();

					Thread.sleep(40000);

					// By
					// pop4=By.xpath("//div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog
					// mfp-show cart-modal ad-t-crt-mdl-only']");

					By pop2 = By.xpath(
							"//div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog mfp-show cart-modal ad-t-crt-mdl-only']");

					// WebElement
					// pop2=driver.findElement(By.xpath("/div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog
					// mfp-show cart-modal ad-t-crt-mdl-only']"));
					WebDriverWait wait2 = new WebDriverWait(driver, 120);
					wait2.until(ExpectedConditions.visibilityOfElementLocated(pop2));

					wait.until(ExpectedConditions.elementToBeClickable(pp.getviewCart()));
					Thread.sleep(10000);
					wait.until(ExpectedConditions.elementToBeClickable(pp.getsubmitCart()));
					Thread.sleep(10000);
					pp.getsubmitCart().click();
					Thread.sleep(5000);
					String title4 = driver.getTitle();
					wait.until(ExpectedConditions.titleContains("Punchout - MarkITplace"));
					Assert.assertEquals(title4, "Punchout - MarkITplace");
					Thread.sleep(5000);
					wait.until(ExpectedConditions.elementToBeClickable(CO.getShippingAddValue1()));
					Thread.sleep(5000);
					CO.getShippingAddValue1().click();
					Thread.sleep(5000);
					wait.until(ExpectedConditions.elementToBeClickable(CO.getNewbtn()));
					CO.getNewbtn().click();
					Thread.sleep(5000);
					wait.until(ExpectedConditions.elementToBeClickable(CO.getPunchoutProcess()));
					CO.getPunchoutProcess().click();
					Thread.sleep(10000);

					driver.navigate().back();
					driver.navigate().back();
					wait.until(ExpectedConditions.elementToBeClickable(hp.getacctmgmt()));
					Actions actions = new Actions(driver);
					actions.moveToElement(hp.getacctmgmt());
					actions.perform();
					Thread.sleep(5000);
					WebElement s = driver.findElement(
							By.xpath("//div[@class='account-menu']//a[contains(text(),'Return to Buyer App')]"));

					wait.until(ExpectedConditions.elementToBeClickable(s));
					Thread.sleep(5000);

					s.click();

					// wait.until(ExpectedConditions.titleContains("https://www.moredirect.com/app/PunchoutOrder/test"));
					// if(driver.getPageSource().contains("cXML"))
					// {
					// System.out.println(driver.getPageSource());
					// Assert.assertEquals("cXML", "cXML");
					// Thread.sleep(5000);
					// driver.navigate().back();
					// Thread.sleep(3000);
					// driver.navigate().back();

					// }
				}
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			//// System.out.println("Error message: " + e.toString());
			// .gotoURL(url);
			Thread.sleep(3000);
			System.out.print("fffff");
			WebDriverWait wait = new WebDriverWait(driver, 120);
			driver.navigate().back();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(hp.getacctmgmt()));
			Actions actions = new Actions(driver);
			actions.moveToElement(hp.getacctmgmt());
			actions.perform();
			Thread.sleep(5000);
			WebElement s = driver
					.findElement(By.xpath("//div[@class='account-menu']//a[contains(text(),'Return to Buyer App')]"));

			wait.until(ExpectedConditions.elementToBeClickable(s));
			Thread.sleep(5000);

			s.click();
			System.out.println("catch called ");

			e.printStackTrace();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {
			//// System.out.println("Error message: " + e.toString());
			// cf.gotoURL(url);
			Thread.sleep(3000);
			driver.navigate().back();
			wait.until(ExpectedConditions.elementToBeClickable(hp.getacctmgmt()));
			Actions actions = new Actions(driver);
			actions.moveToElement(hp.getacctmgmt());
			actions.perform();
			Thread.sleep(5000);
			WebElement s = driver
					.findElement(By.xpath("//div[@class='account-menu']//a[contains(text(),'Return to Buyer App')]"));

			wait.until(ExpectedConditions.elementToBeClickable(s));
			Thread.sleep(5000);

			s.click();
			System.out.println("catch called ");
			// e.printStackTrace();
			e.printStackTrace();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
																			// cf.gotoURL(url);
			Thread.sleep(3000);
			driver.navigate().back();
			wait.until(ExpectedConditions.elementToBeClickable(hp.getacctmgmt()));
			Actions actions = new Actions(driver);
			actions.moveToElement(hp.getacctmgmt());
			actions.perform();
			Thread.sleep(5000);
			WebElement s = driver
					.findElement(By.xpath("//div[@class='account-menu']//a[contains(text(),'Return to Buyer App')]"));

			wait.until(ExpectedConditions.elementToBeClickable(s));
			Thread.sleep(5000);

			s.click();
			System.out.println("catch called ");
			// e.printStackTrace();
			e.printStackTrace();
			e.getMessage();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}
	}

	@Parameters({ "username3", "pswd3", "url" })
	@Test(priority = 33, description = "UserMgmt_ListingPage", enabled = false)
	public void Validate_UserMgmt_listingPage(String username3, String pswd3, String url)
			throws IOException, InterruptedException {

		try {

			wait = new WebDriverWait(driver, 180);
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("return window.stop");
			Thread.sleep(3000);
			cf.gotoURL(url);

			Thread.sleep(5000);
			// wait.until(ExpectedConditions.elementToBeClickable(mpp.getAccountDropdown()));
			// Thread.sleep(3000);
			// mpp.getAccountDropdown().click();
			Thread.sleep(3000);

			// WebElement
			// au=driver.findElement(By.xpath("//header/section[1]/div[3]/div[1]/div[2]/ul[1]/li[2]/a[1]"));

			// au.click();
			Thread.sleep(3000);
			cf.loginapp(username3, pswd3);
			Thread.sleep(9000);
			wait.until(ExpectedConditions.elementToBeClickable(mpp.getAccountDropdown()));
			Thread.sleep(6000);
			mpp.getAccountDropdown().click();
			Thread.sleep(7000);
			wait.until(ExpectedConditions.elementToBeClickable(mpp.getum()));
			Thread.sleep(6000);
			mpp.getum().click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.titleContains("User Management - MarkITplace"));

		} catch (org.openqa.selenium.NoSuchElementException e) {

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) {
			//// System.out.println("Error message: " + e.toString());

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

		catch (org.openqa.selenium.ElementClickInterceptedException e) {
			//// System.out.println("Error message: " + e.toString());

			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "username4", "pswd4", "url" })
	@Test(priority = 34, description = "PlaceOrder_CreditCard", enabled = false)
	public void Validate_PlaceOrder_CreditCard(String username4, String pswd4, String url)
			throws IOException, InterruptedException {

		// wait = new WebDriverWait(driver, 180);

		try {
			Thread.sleep(7000);
			cf.gotoURL(url);
			Thread.sleep(5000);
			cf.logout();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("return window.stop");

			wait = new WebDriverWait(driver, 300);

			cf.gotoURL(url);
			Thread.sleep(3000);
			cf.loginapp(username4, pswd4);
			// By
			// pop=By.xpath("//div[@class='modal-dialog']//div[@class='modal-body']//span[contains(text(),'Oops!
			// Your order could not be processed at this time. Your Account Team is ready to
			// help or try again.')]");
			Thread.sleep(7000);
			if (driver.getTitle().contentEquals("403 - Access Denied - MarkITplace")) {
				Thread.sleep(3000);
				By pop1 = By
						.xpath("//div[@class='shopping-cart checkout-cart-header']//i[@class='fa fa-chevron-left']");
				Thread.sleep(3000);
				driver.findElement(pop1).click();
				Thread.sleep(3000);

			}

			else {
				hp = new HomePage(driver);
				Thread.sleep(3000);
				hp.getsearchbox().sendKeys("HP laptop" + Keys.ENTER);
				Thread.sleep(5000);
				String title3 = driver.getTitle();
				if (!title3.contentEquals("HP Laptop - MarkITplace")) {
					// Assert.assertEquals(title3, "HP Laptop - MarkITplace");
					Assert.assertTrue(false, "Failed- Title not matched  HP  laptop place not opened");

				}

				By pop1 = By.xpath("//div[@class='alert alert-info permission-boxalert alert-info permission-box']");

				By getnow3;

				if (CO.isElementPresent(pop1)) {

				} else if (title3.contentEquals("HP Laptop - MarkITplace"))

				{

					for (int j = 1; j < 10; j++) {

						// String now="(//a[@class='add_to_cart btn btn-primary tt-wrapper'])["+j+"]";

						String now = "(//a[@class='add_to_cart btn btn-primary'])[" + j + "]";

						getnow3 = By.xpath(now);

						WebElement web = driver.findElement(By.xpath(now));

						System.out.print("j=" + j);
						if (CO.isElementPresent(getnow3)) {

							/*
							 * JavascriptExecutor js1 = (JavascriptExecutor)driver;
							 * 
							 * js1.executeScript("window.scrollBy(0,400)"); System.out.print("sdfdsfdsg");
							 * 
							 * Actions action = new Actions(driver); action.moveToElement(web).click();
							 */

							// wait.until(ExpectedConditions.elementToBeClickable(web));

							boolean bst = isClickable(web);
							if (bst == false) {
								System.out.print("false");
							} else if (bst == true) {
								System.out.print("bsttrue");
								driver.findElement(getnow3).click();
								break;
							}

						}

					}

					// }

					WebDriverWait wait = new WebDriverWait(driver, 300);
					// wait.until(ExpectedConditions.elementToBeClickable(Srp.getAdd2Cart()));
					Random random = new Random();
					int x = random.nextInt(90000) + 100;
					// Srp.getAdd2Cart().click();
					Thread.sleep(10000);
					By pop2 = By.xpath(
							"//div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog mfp-show cart-modal ad-t-crt-mdl-only']");

					// WebElement
					// pop2=driver.findElement(By.xpath("/div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog
					// mfp-show cart-modal ad-t-crt-mdl-only']"));
					WebDriverWait wait2 = new WebDriverWait(driver, 120);
					wait2.until(ExpectedConditions.visibilityOfElementLocated(pop2));

					By createorder = By.xpath(
							"//div[@class='sub-col-right cart-modal-btns']//div[@class='main-btn'][contains(text(),'Create Order')]");

					if (CO.isElementPresent(createorder)) {
						CP.getcreateorder().click();
						Thread.sleep(10000);

						// wait.until(ExpectedConditions.elementToBeClickable(CP.getcreateorder()));
						Thread.sleep(5000);
						// CP.getcreateorder().click();
						wait.until(ExpectedConditions.titleContains("Order Checkout - MarkITplace"));

						Thread.sleep(3000);
						wait.until(ExpectedConditions.elementToBeClickable(CO.getCCradiobox()));
						CO.getCCradiobox().click();
						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(CO.getCCid()));

						CO.getCCid().sendKeys("4111111111111111");
						Thread.sleep(3000);
						// wait.until(ExpectedConditions.elementToBeClickable(CO.getCCExpiryMonth()));
						// Select se2 = new Select(CO.getCCExpiryMonth());
						// se2.selectByValue("10");
						Thread.sleep(7000);

						wait.until(ExpectedConditions.elementToBeClickable(CO.getCCExpiryYear()));
						Select se21 = new Select(CO.getCCExpiryYear());
						se21.selectByValue("2022");
						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(CO.getCreditcardPO()));
						CO.getCreditcardPO().sendKeys((String.valueOf(x)));
						Thread.sleep(3000);

						wait.until(ExpectedConditions.elementToBeClickable(CO.getbillingaddressdrop()));
						CO.getbillingaddressdrop().click();

						wait.until(ExpectedConditions.elementToBeClickable(CO.getbillingaddress()));
						CO.getbillingaddress().click();

						Thread.sleep(5000);

						By usediffshipAddress = By.xpath("//a[@class='use-different-s-address']");
						if (CO.isElementPresent(usediffshipAddress)) {

						} else {
							wait.until(ExpectedConditions.elementToBeClickable(CO.getshipadd()));
							Thread.sleep(5000);
							CO.getshipadd().click();
							Thread.sleep(5000);
							CO.getUseThisAddress().click();

						}

						wait.until(ExpectedConditions.elementToBeClickable(CO.getEmailConfirm()));
						Thread.sleep(3000);
						CO.getEmailConfirm().sendKeys("saima.tabassum@arpatech.com");
						Thread.sleep(3000);

						CO.getrevieworder().click();
						wait.until(ExpectedConditions.elementToBeClickable(CO.getplaceorder()));
						Thread.sleep(10000);
						CO.getplaceorder().click();

						Thread.sleep(3000);
						WebElement w = driver.findElement(By.id("loadingMask"));
						try {

							WebDriverWait wait1 = new WebDriverWait(driver, 60);
							wait1.until(ExpectedConditions.invisibilityOf(w));
						} catch (org.openqa.selenium.TimeoutException e) {
							driver.navigate().back();
							Assert.assertTrue(false,
									"Payment processing failed , Do not click away from this page. Thsi process take up to 30 seconds");

						} catch (org.openqa.selenium.ElementClickInterceptedException e) {
							driver.navigate().back();
							Assert.assertTrue(false,
									"Payment processing failed , Do not click away from this page. Thsi process take up to 30 seconds");

						}

						Thread.sleep(10000);
						System.out.print("hi");
						By pop3 = By.xpath(
								"//div[@class='modal-dialog']//div[@class='modal-body']//span[contains(text(),'Oops! Your order could not be processed at this time. Your Account Team is ready to help or try again.')]");

						if (driver.getTitle().contains("Order Confirmation - MarkITplace")) {

						}

						else if (CO.isElementPresent(pop3)) {
							System.out.print("hi2");
							CO.getordererror().getText();
							Thread.sleep(5000);

							CO.getclose1().click();
							Thread.sleep(5000);
							System.out.print("order not successful");
							driver.navigate().back();

						}

						else if (CO.isElementPresent(pop2)) {
							System.out.print("hi3");
							CO.getordererror().getText();
							Thread.sleep(5000);

							CO.getclose1().click();
							Thread.sleep(5000);
							System.out.print("order not successful");
							driver.navigate().back();

						}
					}

				}
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {

			////// System.out.println("Error message: " + e.toString());

			// WebElement
			// pw=driver.findElement(By.xpath("//div[@class='modal-footer']//button[@class='btn
			// btn-default'][contains(text(),'Close')]"));
			// pw.click();
			// Thread.sleep(3000);
			// driver.navigate().back();
			// wait.until(ExpectedConditions.titleContains("Order Confirmation -
			// MarkITplace"));
			// Assert.assertEquals(driver.getTitle(), "Order Confirmation - MarkITplace");
			Thread.sleep(5000);
			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}

		catch (org.openqa.selenium.ElementClickInterceptedException e) {

			//// System.out.println("Error message: " + e.toString());

			// WebElement
			// pw=driver.findElement(By.xpath("//div[@class='modal-footer']//button[@class='btn
			// btn-default'][contains(text(),'Close')]"));
			// pw.click();
			// Thread.sleep(3000);
			// driver.navigate().back();
			// wait.until(ExpectedConditions.titleContains("Order Confirmation -
			// MarkITplace"));
			// Assert.assertEquals(driver.getTitle(), "Order Confirmation - MarkITplace");
			Thread.sleep(5000);
			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}

	}

	@Parameters({ "username3", "pswd3", "CA", "url" })
	@Test(priority = 35, description = "Validate_Comparative_analysis_page", enabled = false)
	public void Validate_Comparative_analysis_page(String username3, String pswd3, String CA, String url)
			throws IOException, InterruptedException {

		wait = new WebDriverWait(driver, 180);
		try {
			Thread.sleep(7000);
			cf.logout();
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("return window.stop");
			Thread.sleep(3000);
			cf.gotoURL(url);
			Thread.sleep(5000);
			cf.loginapp(username3, pswd3);
			Thread.sleep(5000);
			FileInputStream fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			// String CA = prop.getProperty("CA");

			cf.gotoURL(CA);
			Thread.sleep(7000);
			String title5 = driver.getTitle();
			Thread.sleep(7000);
			if (driver.getTitle().contentEquals("403 - Access Denied - MarkITplace")) {
				driver.navigate().back();
				Assert.assertTrue(false, "Failed Access Denied");

			}

			if (driver.getTitle().contentEquals("Comparative Analysis - MarkITplace")) {
				driver.navigate().back();

			}
			By a = By.xpath("//h1[@class='break-long-words exception-message']");
			// if(CO.isElementPresent(a))
			// driver.navigate().back();
			// Thread.sleep(5000);

		}

		catch (org.openqa.selenium.NoSuchElementException e) { ////// System.out.println("Error message: " +
																////// e.toString());

			System.out.println("catch called2 ");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { ////// System.out.println("Error message: " + e.toString());

			System.out.println("catch called2 ");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

		catch (org.openqa.selenium.ElementClickInterceptedException e) {// ////System.out.println("Error message: " +
																		// e.toString());

			System.out.println("catch called2 ");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Test(priority = 36, description = "Validate_Brands_page", enabled = false)
	public void Validate_brands_page() throws IOException, InterruptedException {

		wait = new WebDriverWait(driver, 180);
		try {
			Thread.sleep(7000);
			// driver.navigate().back();
			Thread.sleep(3000);
			Header head = new Header(driver);
			head.getShopBtn().click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.titleContains("Shop - MarkITplace"));
			String TitleHome = driver.getTitle();

			Thread.sleep(5000);

			head.getbrands().click();
			wait.until(ExpectedConditions.titleContains("All Brands - MarkITplace"));

			Thread.sleep(5000);
			cf.logout();
		} catch (org.openqa.selenium.NoSuchElementException e) { ////// System.out.println("Error message: " +
																	////// e.toString());

			System.out.println("catch called3 ");
			e.printStackTrace();
			driver.navigate().back();
			Thread.sleep(5000);
			cf.logout();
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.TimeoutException e) {
			////// System.out.println("Error message: " + e.toString());
			driver.navigate().back();
			System.out.println("catch called3 ");
			e.printStackTrace();
			Thread.sleep(5000);
			cf.logout();
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

		catch (org.openqa.selenium.ElementClickInterceptedException e) {
			// ////System.out.println("Error message: " + e.toString());
			driver.navigate().back();
			System.out.println("catch called3 ");
			e.printStackTrace();
			Thread.sleep(5000);
			cf.logout();
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
	}

	@Parameters({ "username5", "pswd5", "url" })
	@Test(priority = 37, description = "Validate_place_quotes", enabled = false)
	public void Validate_placing_Quotes(String username3, String pswd3, String url)
			throws IOException, InterruptedException {

		try {
			cf.gotoURL(url);
			// }
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 120);

			cf.loginapp(username3, pswd3);
			Thread.sleep(6000);
			hp = new HomePage(driver);
			hp.getsearchbox().clear();
			Thread.sleep(3000);

			hp.getsearchbox().sendKeys("HP laptop" + Keys.ENTER);
			Thread.sleep(10000);
			String title3 = driver.getTitle();

			Thread.sleep(6000);
			By pop1 = By.xpath("//div[@class='alert alert-info permission-boxalert alert-info permission-box']");

			if (!title3.contentEquals("HP Laptop - MarkITplace")) {
				Assert.assertEquals(title3, "HP Laptop - MarkITplace");

			}

			if (CO.isElementPresent(pop1)) {
				hp.getsearchbox().clear();

			} else {
				if (title3.contentEquals("HP Laptop - MarkITplace")) {

					By getnow3;

					String id = "18264785";
					String Drop[] = { "18264785", "18264782", "16992247", "17594265", "17244138" };

					// String DropdownOptionsExp[] = {"saima tab saima tab, a6721574@jj67j74.com,
					// Administrator" };
					for (int j = 1; j < 10; j++) {

						String xp = "//div[@class='product-list-grid clearfix print-product-list pro-list grid']//div[@data-id='"
								+ Drop[j]
								+ "']//div[@class='product-grid-item-content clearfix']//div[@class='list-item-right']//div[@class='cart-container clearfix']//a[@class='add_to_cart btn btn-primary']";
						System.out.println(xp);

						getnow3 = By.xpath(xp);

						if (CO.isElementPresent(getnow3)) {

							driver.findElement(getnow3).click();
							break;
						}

					}

					CartPage CP = new CartPage(driver);
					By pop = By.xpath("//span[contains(text(),'Oops something went wrong. Please try again.')]");

					if (CO.isElementPresent(pop)) {
						driver.navigate().back();

					} else {
						By Quote1 = By.xpath(
								"//div[@class='sub-col-right cart-modal-btns']//div[@class='main-btn'][contains(text(),'Create Quote')]");

						if (CO.isElementPresent(Quote1)) {
							CP.getQuoteBtn1().click();
							Thread.sleep(10000);
						}

						else {

							By pop2 = By.xpath(
									"//div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog mfp-show cart-modal ad-t-crt-mdl-only']");

							// WebElement
							// pop2=driver.findElement(By.xpath("/div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog
							// mfp-show cart-modal ad-t-crt-mdl-only']"));
							WebDriverWait wait2 = new WebDriverWait(driver, 120);
							wait2.until(ExpectedConditions.visibilityOfElementLocated(pop2));

							CP.getdrop().click();
							Thread.sleep(5000);

							CP.getQuoteBtn().click();
							Thread.sleep(10000);
						}

						String title4 = driver.getTitle();
						wait.until(ExpectedConditions.titleContains("Quote Checkout - MarkITplace"));

						Thread.sleep(5000);
						Random random = new Random();
						int x = random.nextInt(90000) + 100;
						Thread.sleep(5000);

						wait.until(ExpectedConditions.elementToBeClickable(CO.getquotePO()));
						CO.getquotePO().sendKeys((String.valueOf(x)));
						Thread.sleep(5000);
						CO.getCC().sendKeys("costcenter");

						// Thread.sleep(5000);

						By usediffshipAddress = By.xpath("//a[@class='use-different-s-address']");
						if (CO.isElementPresent(usediffshipAddress)) {
							driver.findElement(usediffshipAddress).click();

						} else {
							wait.until(ExpectedConditions.elementToBeClickable(CO.getshipadd()));
							Thread.sleep(5000);
							CO.getshipadd().click();
							Thread.sleep(5000);
							CO.getUseThisAddress().click();

						}

						wait.until(ExpectedConditions.elementToBeClickable(CO.getAttention()));
						CO.getAttention().sendKeys("abcTest");

						wait.until(ExpectedConditions.elementToBeClickable(CO.getEmailConfirm()));
						Thread.sleep(3000);
						CO.getEmailConfirm().sendKeys("saima.tabassum@arpatech.com");
						Thread.sleep(3000);

						// CO.getreviewlabel().click();
						wait.until(ExpectedConditions.elementToBeClickable(CO.getcreatequoetbtn()));
						Thread.sleep(10000);
						CO.getcreatequoetbtn().click();
						Thread.sleep(20000);
						Assert.assertEquals(driver.getTitle(), "Quote Confirmation - MarkITplace");
						Thread.sleep(5000);

					}
				}

			}
		}

		catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																//// e.toString());
			System.out.println("catch called4 ");
			e.printStackTrace();
			driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catch called4 ");
			e.printStackTrace();
			driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());

			driver.navigate().back();
			System.out.println("catch called4 ");
			e.printStackTrace();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());

		}

	}

	@Test(priority = 38, enabled = false)
	public void ValidateplaceOrder() throws IOException, InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			Random random = new Random();
			int x = random.nextInt(90000) + 100;

			hp = new HomePage(driver);
			hp.getsearchbox().clear();
			Thread.sleep(3000);
			hp.getsearchbox().sendKeys("HP laptop" + Keys.ENTER);
			Thread.sleep(10000);
			String title3 = driver.getTitle();
			By pop1 = By.xpath("//div[@class='alert alert-info permission-boxalert alert-info permission-box']");
			Thread.sleep(7000);
			if (!title3.contentEquals("HP Laptop - MarkITplace")) {
				Assert.assertEquals(title3, "HP Laptop - MarkITplace");

			}

			if (CO.isElementPresent(pop1)) {

			} else if (title3.contentEquals("HP Laptop - MarkITplace"))

			{

				By getnow3;

				String id = "18264785";
				String Drop[] = { "18264785", "18264782", "16992247", "17594265", "17244138" };

				// String DropdownOptionsExp[] = {"saima tab saima tab, a6721574@jj67j74.com,
				// Administrator" };
				for (int j = 1; j < 10; j++) {

					String xp = "//div[@class='product-list-grid clearfix print-product-list pro-list grid']//div[@data-id='"
							+ Drop[j]
							+ "']//div[@class='product-grid-item-content clearfix']//div[@class='list-item-right']//div[@class='cart-container clearfix']//a[@class='add_to_cart btn btn-primary']";
					System.out.println(xp);

					getnow3 = By.xpath(xp);

					if (CO.isElementPresent(getnow3)) {

						driver.findElement(getnow3).click();
						break;
					}

				}

				By pop = By.xpath("//span[contains(text(),'Oops something went wrong. Please try again.')]");

				if (CO.isElementPresent(pop)) {
					driver.navigate().back();

				} else {

					CP = new CartPage(driver);

					By pop2 = By.xpath(
							"//div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog mfp-show cart-modal ad-t-crt-mdl-only']");

					// WebElement
					// pop2=driver.findElement(By.xpath("/div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog
					// mfp-show cart-modal ad-t-crt-mdl-only']"));
					WebDriverWait wait2 = new WebDriverWait(driver, 120);
					wait2.until(ExpectedConditions.visibilityOfElementLocated(pop2));

					By createorder = By.xpath(
							"//div[@class='sub-col-right cart-modal-btns']//div[@class='main-btn'][contains(text(),'Create Order')]");

					if (CO.isElementPresent(createorder)) {
						CP.getcreateorder().click();
						Thread.sleep(10000);

						try {
							CO = new CheckoutPage(driver);
							Thread.sleep(10000);
							wait.until(ExpectedConditions.elementToBeClickable(CO.getPO()));
							CO.getPO().sendKeys((String.valueOf(x)));

							Thread.sleep(5000);
							CO.getCC().sendKeys("costcenter");
							Thread.sleep(5000);

							Thread.sleep(5000);

							By usediffshipAddress = By.xpath("//a[@class='use-different-s-address']");
							if (CO.isElementPresent(usediffshipAddress)) {

							} else {
								wait.until(ExpectedConditions.elementToBeClickable(CO.getshipadd()));
								Thread.sleep(5000);
								CO.getshipadd().click();
								Thread.sleep(5000);
								CO.getUseThisAddress().click();

							}

							wait.until(ExpectedConditions.elementToBeClickable(CO.getAttention()));
							CO.getAttention().sendKeys("abcTest");

							wait.until(ExpectedConditions.elementToBeClickable(CO.getEmailConfirm()));
							Thread.sleep(3000);
							CO.getEmailConfirm().sendKeys("saima.tabassum@arpatech.com");
							Thread.sleep(3000);

							// CO.getrevieworder().click();
							wait.until(ExpectedConditions.elementToBeClickable(CO.getplaceorder()));
							Thread.sleep(10000);
							CO.getplaceorder().click();
							Thread.sleep(10000);

						} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message:
																					//// " + e.toString());
							System.out.println("catchcalled5");
							e.printStackTrace();
							driver.navigate().back();
							Thread.sleep(5000);
							Assert.assertTrue(false, "Failed" + e.getMessage());
						}

						wait.until(ExpectedConditions.titleContains("Order Confirmation - MarkITplace"));

						Thread.sleep(5000);

					}
				}
			}
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled5");
			e.printStackTrace();
			driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled5");
			e.printStackTrace();
			driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled5");

			e.printStackTrace();
			driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
	}

	@Parameters({ "username3", "pswd3", "url" })
	@Test(priority = 39, enabled = false)
	public void ValidatePDP_email(String username3, String pswd3, String url) throws IOException, InterruptedException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			Random random = new Random();
			int x = random.nextInt(90000) + 100;

			PurchaseAnalysis PA = new PurchaseAnalysis(driver);

			hp = new HomePage(driver);
			hp.getsearchbox().clear();
			hp.getsearchbox().sendKeys("HP Printers" + Keys.ENTER);
			Thread.sleep(10000);

			WebElement a = driver.findElement(By.xpath("(//h2[contains(@id,'product-name-')])[1]"));
			if (a.isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(a));
				Thread.sleep(5000);
				a.click();
				Actions ab = new Actions(driver);
				Thread.sleep(5000);
				ab.click(driver.findElement(By.xpath("//a[@class='action-icon icon-mail']"))).release().perform();

				Thread.sleep(5000);

				WebElement download = driver.findElement(By.xpath("//div[@class='modal-mask']"));

				WebElement temp = download
						.findElement(By.xpath("//div[@class='modal-content']//input[@name='email_addresses']"));

				Thread.sleep(10000);
				temp.sendKeys("ffhhffh@k.com");

				Thread.sleep(8000);
				WebElement temp1 = download
						.findElement(By.xpath("//div[@class='modal-content']//button[@class='btn btn-primary']"));
				temp1.click();
				// Thread.sleep(30000);

				// WebElement element =
				// driver.findElement(By.xpath("//span[@class='back-link']"));

				WebDriverWait wait1 = new WebDriverWait(driver, 300);
				// wait1.until(ExpectedConditions.elementToBeClickable(element));
				// Thread.sleep(10000);

				WebElement w = driver.findElement(By.xpath(
						"//form[@id='emailForm']//button[@class='btn btn-secondary'][contains(text(),'Cancel')]"));
				wait1.until(ExpectedConditions.invisibilityOf(w));

			}
		}

		catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																//// e.toString());
			System.out.println("catchcalled6");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

			Thread.sleep(5000);
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled6");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

			Thread.sleep(5000);
		} catch (org.openqa.selenium.TimeoutException e) {
			//// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled6");
			e.printStackTrace();
			Assert.assertTrue(false, "Failed" + e.getMessage());

			Thread.sleep(5000);
		}

	}

	@Parameters({ "username3", "pswd3", "url" })
	@Test(priority = 40, enabled = false)
	public void ValidateOrderListingPage(String username3, String pswd3, String url)
			throws IOException, InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);

			Thread.sleep(5000);

			Header hd = new Header(driver);

			WebElement element = driver.findElement(By.xpath(
					"//div[contains(@class,'homepage-nav-item-container')]//a[contains(@class,'')][contains(text(),'Track')]"));

			WebDriverWait wait1 = new WebDriverWait(driver, 300);
			wait1.until(ExpectedConditions.elementToBeClickable(element));

			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			// hd.getTrackBtn().click();
			Thread.sleep(5000);

			WebElement element1 = driver.findElement(By.xpath("//a[@class='top-link'][contains(text(),'Orders')]"));

			wait1.until(ExpectedConditions.elementToBeClickable(element1));

			Actions actions1 = new Actions(driver);
			actions1.moveToElement(element1).click().build().perform();

			// hd.getOrderBtn().click();
			Thread.sleep(6000);
			String title5 = driver.getTitle();
			String exp5 = "Orders - MarkITplace";

			if (driver.getTitle().contentEquals("403 - Access Denied - MarkITplace")) {

				driver.navigate().back();

				WebElement element2 = driver.findElement(By.xpath(
						"//div[contains(@class,'homepage-nav-item-container')]//a[contains(@class,'')][contains(text(),'Track')]"));

				wait1.until(ExpectedConditions.elementToBeClickable(element2));

				Actions actions2 = new Actions(driver);
				actions2.moveToElement(element2).click().build().perform();

				Thread.sleep(5000);
				Assert.assertEquals(title5, exp5);

			}

			else if (driver.getTitle().contentEquals("Orders - MarkITplace")) {
				Assert.assertEquals(title5, exp5);
			}
			Thread.sleep(10000);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			//// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled7");
			e.printStackTrace();
			WebElement element = driver.findElement(By.xpath(
					"//div[contains(@class,'homepage-nav-item-container')]//a[contains(@class,'')][contains(text(),'Track')]"));

			WebDriverWait wait1 = new WebDriverWait(driver, 150);
			wait1.until(ExpectedConditions.elementToBeClickable(element));

			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			// hd.getTrackBtn().click();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());

		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			//// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled7");

			e.printStackTrace();
			WebElement element = driver.findElement(By.xpath(
					"//div[contains(@class,'homepage-nav-item-container')]//a[contains(@class,'')][contains(text(),'Track')]"));

			WebDriverWait wait1 = new WebDriverWait(driver, 150);
			wait1.until(ExpectedConditions.elementToBeClickable(element));

			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			// hd.getTrackBtn().click();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) {
			//// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled7");

			e.printStackTrace();
			WebElement element = driver.findElement(By.xpath(
					"//div[contains(@class,'homepage-nav-item-container')]//a[contains(@class,'')][contains(text(),'Track')]"));

			WebDriverWait wait1 = new WebDriverWait(driver, 150);
			wait1.until(ExpectedConditions.elementToBeClickable(element));

			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			// hd.getTrackBtn().click();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
	}

	@Parameters({ "username3", "pswd3", "url" })
	@Test(priority = 41, enabled = false)
	public void ValidateQuoteListingPage(String username3, String pswd3, String url)
			throws IOException, InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);

			Thread.sleep(5000);

			Header hd = new Header(driver);

			Thread.sleep(10000);
			WebElement element1 = driver.findElement(By.linkText("Quotes"));

			element1.click();

			// hd.getQuoteBtn().click();
			Thread.sleep(10000);
			String title6 = driver.getTitle();
			String exp6 = "Quotes - MarkITplace";
			Assert.assertEquals(title6, exp6);
			cf.logout();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			//// System.out.println("Error message: " + e.toString());

			e.printStackTrace();
			System.out.println("catchcalled8");
			Assert.assertTrue(false, "Failed" + e.getMessage());
			Thread.sleep(5000);
		}

		catch (org.openqa.selenium.TimeoutException e) {
			//// System.out.println("Error message: " + e.toString());

			e.printStackTrace();
			Thread.sleep(5000);
			System.out.println("catchcalled8");
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			//// System.out.println("Error message: " + e.toString());
			e.printStackTrace();
			Thread.sleep(5000);
			System.out.println("catchcalled8");
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
	}

	public static boolean isClickable(WebElement webe) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(webe));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
