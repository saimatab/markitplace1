package tests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import Contact_Us.ContactUs;
import Home.CommonFunctions;
import Home.Header;
import Home.HomePage;
import Home.LoginPage;
import Home.MyProfilePage;
import Shop_AllProducts.AllProducts;
import Shop_Brands.Brands;
import Shop_Cart.CartPage;
import Shop_Cart.CheckoutPage;
import Shop_MainPage.SearchResultPage;
import Shop_ProductDetail.PDP;
import Shop_Resources.Resources;
import Track_Calenders.Calendar;
import Track_Orders.Orders;
import Track_Quotes.QuoteDetail;
import Track_Reports.AssetPage;
import Track_Reports.PAR;
import resources.base;
import java.util.logging.Level;

public class SmokeTestsSuite3 extends base {
	
	public static Logger Log = LogManager.getLogger(base.class.getName());
	public Brands BD;
	public HomePage hp;
	public AllProducts AP;
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
	public QuoteDetail QD;
	public Resources rr;
	public Orders OD;
	public ContactUs CU;
	public Calendar CC;
	public AssetPage AAP;
	public PAR PRR;
	String mfg;
	String mfg1;
	public Shop_StandardsCatalog.StandardsCatalog sc;
	String globalbundlename;
	
	

	////
	public SmokeTestsSuite3() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver = getdriver();
		Srp = new SearchResultPage(driver);
		PRR = new PAR(driver);
		rr = new Resources (driver);
		AP = new AllProducts(driver);
		CO = new CheckoutPage(driver);
		lp = new LoginPage(driver);
		hdr = new Header(driver);
		mpp = new MyProfilePage(driver);
		hp = new HomePage(driver);
		cf = new CommonFunctions(driver);
		pp = new PDP(driver);
		CP = new CartPage(driver);
		QD = new QuoteDetail(driver);
		OD = new Orders(driver);
		CU = new ContactUs(driver);
		BD = new Brands(driver);
		prop = new Properties();
		AAP= new AssetPage(driver);
		fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		
	}
	
	@Test(priority = 1)
	public void nofound()
	{
		System.out.println("nothing found");
	}

	@Parameters({ "username3", "pswd3", "url" })
	@Test(priority = 1, description = "Request Quote", enabled = false)
	public void Request_quote(String username3, String pswd3, String url) throws IOException, InterruptedException {

		System.out.println("Scenario 1 :Request Quote From Quote page");

		try {
			driver = getdriver();
			AP = new AllProducts(driver);
			Srp = new SearchResultPage(driver);
			CO = new CheckoutPage(driver);
			rr = new Resources (driver);
			lp = new LoginPage(driver);
			hdr = new Header(driver);
			mpp = new MyProfilePage(driver);
			hp = new HomePage(driver);
			cf = new CommonFunctions(driver);
			pp = new PDP(driver);
			CP = new CartPage(driver);
			QD = new QuoteDetail(driver);
			prop = new Properties();
			CC= new Calendar(driver);
			fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
			lp.getusername().sendKeys(username3);
			lp.getpassword().sendKeys(pswd3);
			lp.getloginbtn().click();
			Thread.sleep(7000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
//
			driver.findElement(By.linkText("Quotes")).click();

			Thread.sleep(5000);
			String title6 = driver.getTitle();
			String exp6 = "Quotes - MarkITplace";
			Assert.assertEquals(title6, exp6);


			WebElement element2 = driver.findElement(By.xpath("//a[contains(text(),'Request a Quote')]"));

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(element2));

			Actions actions2 = new Actions(driver);
			actions2.moveToElement(element2).click().build().perform();

			Thread.sleep(5000);

			WebElement Reqquotedesc = driver.findElement(By.xpath("//textarea[@id='_requestDetail']"));
			WebElement Reqquoteemail = driver.findElement(By.xpath("//input[@id='_email']"));
			Thread.sleep(3000);
			Reqquotedesc.sendKeys("Test");
			Thread.sleep(3000);
			Reqquoteemail.sendKeys("ayer.shuja@arpatech.com");

			WebElement Phone = driver.findElement(By.xpath("//input[@id='_phone']"));
			Phone.clear();
			Phone.sendKeys("8004444444");
			Thread.sleep(3000);

			WebElement clickreqquote = driver.findElement(By.xpath("//button[@id='submit-return-btn']"));

			clickreqquote.click();
			Thread.sleep(10000);

		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "url" })
	@Test(priority = 2, description = "Create Quote From ProductListing", enabled = false)
	public void Create_quote_FromProductListing(String url) throws InterruptedException, IOException {
		System.out.println("Scenario 2 :"
				+ "Verify create quote directly after clicking add to cart button from product listing page");

		try {
			driver.get(url);
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.elementToBeClickable(hp.getsearchbox()));

			hp.getsearchbox().sendKeys("hp printers" + Keys.ENTER);
			Thread.sleep(10000);
			String title3 = driver.getTitle();

			By pop1 = By.xpath("//div[@class='alert alert-info permission-boxalert alert-info permission-box']");

			if (CO.isElementPresent(pop1)) {

			} else if (title3.contentEquals("Hp Printers - MarkITplace"))

			{

				By getnow3;

				String id = "18264785";
				String Drop[] = { "16809533", "16964739", "16971360", "1424013", "16890753" };

				for (int j = 1; j < 10; j++) {

					String xp = "//div[@class='product-list-grid clearfix print-product-list pro-list grid']//div[@data-id='"
							+ Drop[j]
							+ "']//div[@class='product-grid-item-content clearfix']//div[@class='list-item-right']//div[@class='cart-container clearfix']//a[@class='add_to_cart btn btn-primary']";

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
					By pop2 = By.xpath(
							"//div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog mfp-show cart-modal ad-t-crt-mdl-only']");

					Thread.sleep(10000);
					wait.until(ExpectedConditions.elementToBeClickable(CP.getdrop()));
					CP.getdrop().click();
					Thread.sleep(5000);
					QD.getQuoteBtn().click();
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

						Select se1 = new Select(QD.GetReplacementSystem());
						se1.selectByValue("No");
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
						wait.until(ExpectedConditions.elementToBeClickable(QD.GetQuoteApprovalBtn()));
						Thread.sleep(10000);
						QD.GetQuoteApprovalBtn().click();
						Thread.sleep(20000);
						System.out.println(QD.GetMessage().getText());
						System.out.println("PO Number is :" + QD.GetPONum().getText());
						Thread.sleep(10000);

					}

					catch (org.openqa.selenium.NoSuchElementException e) {

						e.printStackTrace();
						// driver.navigate().back();

						Thread.sleep(5000);

						Assert.assertTrue(false, "Failed" + e.getMessage());

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

	@Test(priority = 3, description = "PONum clickable", enabled = false)
	public void PONum_clickable() throws InterruptedException, IOException {

		System.out.println("Scenario 3 :" + "Validate if the 'po number' link is clickable after creating quote");

		try {

			WebDriverWait wait = new WebDriverWait(driver, 100);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(QD.GetPONum()));
			QD.GetPONum().click();
			Thread.sleep(10000);
			System.out.println(QD.GetQuoteConfirmation().getText());

		}

		catch (org.openqa.selenium.ElementClickInterceptedException e) {
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

	@Test(priority = 4, description = "create PAR after Quote is created", enabled = false)
	public void CreatePARAfterQUOTE() throws InterruptedException, IOException {

		System.out.println("Scenario 4 :" + "Verify create PAR after Quote is created"); // done

		try {

			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.elementToBeClickable(QD.GetCreateParAftQuote()));
			QD.GetCreateParAftQuote().click();
			Thread.sleep(10000);
			CO.getEmailConfirm().clear();
			CO.getEmailConfirm().sendKeys("ayer.shuja@arpatech.com");
			Thread.sleep(10000);
			Select se2 = new Select(QD.GetApprovalGroupValue());
			se2.selectByValue("100");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(CO.getPurchaseApproval()));
			CO.getPurchaseApproval().click();
			Thread.sleep(10000);
			System.out.println(CO.getMessage().getText());

		}

		catch (org.openqa.selenium.ElementClickInterceptedException e) {
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

	@Parameters({ "url" })
	@Test(priority = 5, description = "create PAR after Quote is created", enabled = false)
	public void VerifyEditQuote() throws InterruptedException, IOException {

		System.out.println(
				"Scenario 5 :" + "Verify edit quote and add some new changes(increase Quantity) and save the quote"); // done

		try {

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 300);
			Thread.sleep(5000);
			// wait.until(ExpectedConditions.elementToBeClickable(QD.GetPONum()));
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Quotes")).click();

			Thread.sleep(5000);
			String title6 = driver.getTitle();
			String exp6 = "Quotes - MarkITplace";
			Assert.assertEquals(title6, exp6);

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(QD.GetViewQuote()));
			QD.GetViewQuote().click();

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(OD.ClickEditQuote()));
			OD.ClickEditQuote().click();

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(QD.clickQuoteEdit()));
			QD.clickQuoteEdit().click();

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,200)");
			Thread.sleep(3000);

			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(QD.clickAddQty()));
			QD.clickAddQty().click();
			QD.clickAddQty().clear();
			Thread.sleep(5000);

			Thread.sleep(5000);
			QD.clickAddQty().sendKeys("0");
			Thread.sleep(5000);

			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(QD.clickSaveQTYy()));
			QD.clickSaveQTYy().click();

			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(QD.clickQuoteSaveChanges()));
			QD.clickQuoteSaveChanges().click();

			Thread.sleep(10000);
			System.out.println(QD.GetQuoteConfirmation().getText());

		}

		catch (org.openqa.selenium.ElementClickInterceptedException e) {
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

	@Parameters({ "url" })
	@Test(priority = 6, description = "Verify multiple products in Quote", enabled = false)
	public void VerifymultipleproductsinQuote() throws InterruptedException, IOException {

		System.out.println("Scenario 6 :"
				+ "Verify if product is present in cart then we can add multiple products from add item from cart button after creating quote"); // done

		try {

			// WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 300);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);
			String title3 = driver.getTitle();
			title3.contentEquals("HP Laptop - MarkITplace");

			String a = driver.findElement(By.xpath("//*[@id=\"top-header\"]/section/div[3]/div[2]/a/span")).getText();
			if (a.contentEquals("0")) {

				driver.get(url);
				Thread.sleep(5000);
				WebDriverWait wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.elementToBeClickable(hp.getsearchbox()));

				hp.getsearchbox().sendKeys("hp printers" + Keys.ENTER);
				Thread.sleep(10000);
				String title4 = driver.getTitle();

				By pop1 = By.xpath("//div[@class='alert alert-info permission-boxalert alert-info permission-box']");

				if (CO.isElementPresent(pop1)) {

				} else if (title3.contentEquals("Hp Printers - MarkITplace"))

				{

					By getnow3;

					String id = "18264785";
					String Drop[] = { "16809533", "16964739", "16971360", "1424013", "16890753" };

					for (int j = 1; j < 10; j++) {

						String xp = "//div[@class='product-list-grid clearfix print-product-list pro-list grid']//div[@data-id='"
								+ Drop[j]
								+ "']//div[@class='product-grid-item-content clearfix']//div[@class='list-item-right']//div[@class='cart-container clearfix']//a[@class='add_to_cart btn btn-primary']";

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
						By pop2 = By.xpath(
								"//div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog mfp-show cart-modal ad-t-crt-mdl-only']");

						Thread.sleep(10000);
						wait.until(ExpectedConditions.elementToBeClickable(CP.getcartclose()));
						CP.getcartclose().click();

					}

				}

			}

			else {
				Thread.sleep(10000);
			}

			Thread.sleep(5000);
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Quotes")).click();

			Thread.sleep(5000);
			String title6 = driver.getTitle();
			String exp6 = "Quotes - MarkITplace";
			Assert.assertEquals(title6, exp6);

			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(QD.GetViewQuote()));
			QD.GetViewQuote().click();

			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(QD.clickAddItemFromCart()));
			QD.clickAddItemFromCart().click();

			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(QD.clickAddToQuote()));
			QD.clickAddToQuote().click();

			Thread.sleep(10000);
			System.out.println(QD.GetQuoteConfirmation().getText());
			Thread.sleep(10000);
		}

		catch (org.openqa.selenium.ElementClickInterceptedException e) {
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

	@Parameters({ "url" })
	@Test(priority = 7, description = "Verify create order after quote is created", enabled = false)
	public void VerifyCreateOrderAfterQUOTE(String url) throws InterruptedException, IOException {

		System.out.println("Scenario 7 :" + "Verify create order after quote is created"); // done

		try {

			WebDriverWait wait = new WebDriverWait(driver, 100);
			Thread.sleep(5000);
			// wait.until(ExpectedConditions.elementToBeClickable(QD.GetPONum()));
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Quotes")).click();

			Thread.sleep(5000);
			String title6 = driver.getTitle();
			String exp6 = "Quotes - MarkITplace";
			Assert.assertEquals(title6, exp6);

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(QD.GetViewQuote()));
			QD.GetViewQuote().click();

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(OD.getOrder()));
			OD.getOrder().click();

			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(CO.getparPO()));
			CO.getparPO().clear();

			Random random = new Random();
			int x = random.nextInt(90000) + 100;
			try {

				Thread.sleep(10000);
				wait.until(ExpectedConditions.elementToBeClickable(CO.getPO()));
				CO.getparPO().sendKeys((String.valueOf(x)));
				Thread.sleep(5000);

				Select se1 = new Select(QD.GetReplacementSystem());
				se1.selectByValue("Yes");
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
				wait.until(ExpectedConditions.elementToBeClickable(OD.ClickPlaceOrder()));
				Thread.sleep(10000);
				OD.ClickPlaceOrder().click();
				Thread.sleep(20000);
				System.out.println(QD.GetMessage().getText());
				System.out.println("PO Number is :" + QD.GetPONum().getText());
				Thread.sleep(10000);

			}

			catch (org.openqa.selenium.NoSuchElementException e) {

				e.printStackTrace();
				// driver.navigate().back();

				Thread.sleep(5000);

				Assert.assertTrue(false, "Failed" + e.getMessage());

			}

		}

		catch (org.openqa.selenium.ElementClickInterceptedException e) {
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

	@Parameters({ "url" })
	@Test(priority = 8, description = "Verify create order and delete quote", enabled = false)
	public void VerifyCreateOrderandDeleteQuoteButton(String url) throws InterruptedException, IOException {
		System.out.println("Scenario 8 :" + "Verify create order and delete quote from button inside View Quote");

		try {
			driver.get(url);
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.elementToBeClickable(hp.getsearchbox()));

			hp.getsearchbox().sendKeys("hp printers" + Keys.ENTER);
			Thread.sleep(10000);
			String title3 = driver.getTitle();

			By pop1 = By.xpath("//div[@class='alert alert-info permission-boxalert alert-info permission-box']");

			if (CO.isElementPresent(pop1)) {

			} else if (title3.contentEquals("hp printers - MarkITplace"))

			{

				By getnow3;

				String id = "18264785";
				String Drop[] = { "16809533", "16964739", "16971360", "1424013", "16890753" };

				for (int j = 1; j < 10; j++) {

					String xp = "//div[@class='product-list-grid clearfix print-product-list pro-list grid']//div[@data-id='"
							+ Drop[j]
							+ "']//div[@class='product-grid-item-content clearfix']//div[@class='list-item-right']//div[@class='cart-container clearfix']//a[@class='add_to_cart btn btn-primary']";

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
					By pop2 = By.xpath("//*[@id=\"cart-dialog\"]/div[1]/div[1]/div/div/div/div/div[5]/div/div/div/div");

					Thread.sleep(10000);
					wait.until(ExpectedConditions.elementToBeClickable(CP.getdrop()));
					CP.getdrop().click();
					Thread.sleep(5000);
					QD.getQuoteBtn().click();
					Thread.sleep(10000);
					Random random = new Random(System.currentTimeMillis());
					int x = random.nextInt(20000);
					try {

						wait.until(ExpectedConditions.elementToBeClickable(CO.getPO()));
						CO.getparPO().sendKeys((String.valueOf(x)));
						Thread.sleep(5000);
						CO.getref().sendKeys("PO_" + String.valueOf(x));
						Thread.sleep(5000);
						CO.getCC().sendKeys("costcenter");
						Thread.sleep(5000);

						Select se1 = new Select(QD.GetReplacementSystem());
						se1.selectByValue("No");
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
						wait.until(ExpectedConditions.elementToBeClickable(QD.GetQuoteApprovalBtn()));
						Thread.sleep(10000);
						QD.GetQuoteApprovalBtn().click();
						Thread.sleep(20000);
						System.out.println(QD.GetMessage().getText());
						System.out.println("PO Number is :" + QD.GetPONum().getText());
						Thread.sleep(10000);

						Thread.sleep(5000);

						hdr.getTrackBtn().click();
						Thread.sleep(5000);

						driver.findElement(By.linkText("Quotes")).click();

						Thread.sleep(5000);
						String title6 = driver.getTitle();
						String exp6 = "Quotes - MarkITplace";
						Assert.assertEquals(title6, exp6);

						Thread.sleep(5000);

						String PlacedQuote = driver.findElement(By.xpath(
								"//*[@class='order-container container clearfix']/ul/li[1]//span[contains(text(),'Quote #')]"))
								.getText();

						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(QD.GetViewQuote()));
						QD.GetViewQuote().click();

						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(QD.clickOrderDeleteQuote()));
						QD.clickOrderDeleteQuote().click();

						Select se2 = new Select(QD.GetReplacementSystem());
						se2.selectByValue("No");
						Thread.sleep(5000);
						By usediffshipAddress1 = By.xpath("//a[@class='use-different-s-address']");

						if (CO.isElementPresent(usediffshipAddress1)) {

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
						wait.until(ExpectedConditions.elementToBeClickable(OD.ClickPlaceOrder()));
						Thread.sleep(10000);
						OD.ClickPlaceOrder().click();
						Thread.sleep(20000);
						System.out.println(QD.GetMessage().getText());
//						System.out.println("PO Number is :" + QD.GetPONum().getText());
						Thread.sleep(10000);

						hdr.getTrackBtn().click();
						Thread.sleep(5000);

						driver.findElement(By.linkText("Quotes")).click();

						Thread.sleep(5000);

						String DeleteQuote = driver.findElement(By.xpath(
								"//*[@class='order-container container clearfix']/ul/li[1]//span[contains(text(),'Quote #')]"))
								.getText();

						if (PlacedQuote.contentEquals(DeleteQuote)) {
							System.out.println(PlacedQuote + "Not Deleted");
						} else {
							System.out.println(
									PlacedQuote + " Not Found , its deleted successfully after Order is created");
						}

					}

					catch (org.openqa.selenium.NoSuchElementException e) {

						e.printStackTrace();
						// driver.navigate().back();

						Thread.sleep(5000);

						Assert.assertTrue(false, "Failed" + e.getMessage());

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

	@Parameters({ "url" })
	@Test(priority = 9, description = "Validate download button after creating quote", enabled = false)
	public void Validate_download_button(String url) throws InterruptedException, IOException {
		System.out.println("Scenario 9 :" + "Validate download button after creating quote");

		try {
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.elementToBeClickable(hp.getsearchbox()));

			hp.getsearchbox().sendKeys("hp printers" + Keys.ENTER);
			Thread.sleep(10000);
			String title3 = driver.getTitle();

			By pop1 = By.xpath("//div[@class='alert alert-info permission-boxalert alert-info permission-box']");

			if (CO.isElementPresent(pop1)) {

			} else if (title3.contentEquals("Hp Printers - MarkITplace"))

			{

				By getnow3;

				String id = "18264785";
				String Drop[] = { "16809533", "16964739", "16971360", "1424013", "16890753" };

				for (int j = 1; j < 10; j++) {

					String xp = "//div[@class='product-list-grid clearfix print-product-list pro-list grid']//div[@data-id='"
							+ Drop[j]
							+ "']//div[@class='product-grid-item-content clearfix']//div[@class='list-item-right']//div[@class='cart-container clearfix']//a[@class='add_to_cart btn btn-primary']";

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
					By pop2 = By.xpath(
							"//div[@id='cart-dialog']//div[@class='modal-mask']//div[@class='zoom-anim-dialog mfp-show cart-modal ad-t-crt-mdl-only']");

					Thread.sleep(10000);
					wait.until(ExpectedConditions.elementToBeClickable(CP.getdrop()));
					CP.getdrop().click();
					Thread.sleep(5000);
					QD.getQuoteBtn().click();
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

						Select se1 = new Select(QD.GetReplacementSystem());
						se1.selectByValue("No");
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
						wait.until(ExpectedConditions.elementToBeClickable(QD.GetQuoteApprovalBtn()));
						Thread.sleep(10000);
						QD.GetQuoteApprovalBtn().click();
						Thread.sleep(20000);
						System.out.println(QD.GetMessage().getText());
						System.out.println("PO Number is :" + QD.GetPONum().getText());
						Thread.sleep(10000);

						wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
						hdr.getTrackBtn().click();
						Thread.sleep(5000);

						driver.findElement(By.linkText("Quotes")).click();

						Thread.sleep(5000);
						String title6 = driver.getTitle();
						String exp6 = "Quotes - MarkITplace";
						Assert.assertEquals(title6, exp6);

						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(QD.GetViewQuote()));
						QD.GetViewQuote().click();

						Thread.sleep(5000);
						wait.until(ExpectedConditions.elementToBeClickable(QD.clickDownload()));
						QD.clickDownload().click();
						Thread.sleep(5000);

					}

					catch (org.openqa.selenium.NoSuchElementException e) {

						e.printStackTrace();
						// driver.navigate().back();

						Thread.sleep(5000);

						Assert.assertTrue(false, "Failed" + e.getMessage());

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

	@Test(priority = 10, description = "Validate email button after creating quote", enabled = false)
	public void Validate_Email_button() throws IOException, InterruptedException {

		System.out.println("Scenario 10 :Validate email button after creating quote");

		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);

			Thread.sleep(5000);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(QD.clickemail()));
			QD.clickemail().click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(QD.clickemailPDFAttachment()));
			QD.clickemailPDFAttachment().clear();
			wait.until(ExpectedConditions.elementToBeClickable(QD.clickemailPDFAttachment()));
			QD.clickemailPDFAttachment().sendKeys("ayer.shuja@arpatech.com");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(QD.clickemailPDFAttachmentSave()));
			QD.clickemailPDFAttachmentSave().click();
			Thread.sleep(10000);
//			wait.until(ExpectedConditions.elementToBeClickable(QD.clickprint()));
//			QD.clickprint().click();
//			Thread.sleep(5000);
			System.out.println("1");
			// driver.navigate().back();

		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "url" })
	@Test(priority = 11, description = "Validate delete button after creating quote", enabled = false)
	public void Validate_Delete_button(String url) throws IOException, InterruptedException {

		System.out.println("Scenario 11 :Validate delete button after creating quote");

		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);

			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Quotes")).click();

			Thread.sleep(5000);
			String title6 = driver.getTitle();
			String exp6 = "Quotes - MarkITplace";
			Assert.assertEquals(title6, exp6);

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(QD.GetViewQuote()));
			QD.GetViewQuote().click();

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(QD.clickQuoteDelete()));
			QD.clickQuoteDelete().click();

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(QD.clickDeleteConfirmation()));
			QD.clickDeleteConfirmation().click();

		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "url" })
	@Test(priority = 12, description = "Contact Us", enabled = false)
	public void Contact_us(String url) throws IOException, InterruptedException {

		System.out.println("Scenario 12 :Contact Us");

		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Contact Us")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Contact Us - MarkITplace";
			Assert.assertEquals(title7, exp6);

			// -------------

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(CU.getSubmite()));
			CU.getSubmite().click();
			Thread.sleep(10000);
			String mess1 = driver.findElement(By.xpath("//*[@class='alert alert-danger']//li[1]")).getText();
			String exp2 = "The fname field is required.";
			Assert.assertEquals(mess1, exp2);

			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(CU.getFname()));
			CU.getFname().sendKeys("Ayer");

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(CU.getLname()));
			CU.getLname().sendKeys("Shuja");

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(CU.getEmailAddress()));
			CU.getEmailAddress().sendKeys("ayer.shuja@arpatech.com");

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(CU.getMessage()));
			CU.getMessage().sendKeys("Hello Its Automated message");

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(CU.getSubmite()));
			CU.getSubmite().click();
			Thread.sleep(10000);

			String mess3 = driver.findElement(By.xpath("//*[@class='alert alert-success']")).getText();
			String exp3 = "Message received, thank you for contacting us.";
			Assert.assertEquals(mess3, exp3);
			Thread.sleep(10000);
			//driver.quit();

		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "url" })
	@Test(priority = 13, description = "click on category then click sub catergory and then select product and add to cart", enabled = false)
	public void AllProductScenario1(String url) throws IOException, InterruptedException {

		System.out.println(
				"Scenario 13 :click on category then click sub catergory and then select product and add to cart");

		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			hdr.getShopBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("All Products")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Shop - MarkITplace";
			Assert.assertEquals(title7, exp6);

			List<WebElement> listings = driver.findElements(By.xpath("//*[@class='submenu-left']/ul/li"));

			// //*[@class='submenu-left']/ul
			// //*[@class='submenu-left']/ul
			Random r = new Random();
			int randomValue = r.nextInt(listings.size()); // Getting a random value that is between 0 and (list's
															// size)-1
			listings.get(randomValue).click();

			wait.until(ExpectedConditions.elementToBeClickable(CP.getSecondPositionData()));
			CP.getSecondPositionData().click();
			Thread.sleep(5000);

			wait.until(ExpectedConditions.elementToBeClickable(CP.getProductPurchaseAddToCart()));
			CP.getProductPurchaseAddToCart().click();
			Thread.sleep(5000);

			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(CP.getCartDialogBoxAddToCart()));
			CP.getCartDialogBoxAddToCart().click();
			Thread.sleep(5000);

			String title2 = driver.getTitle();
			String exp2 = "Order Checkout - MarkITplace";
			Assert.assertEquals(title2, exp2);
			Thread.sleep(5000);

			Random random = new Random();
			int x = random.nextInt(90000) + 100;
			try {

				Thread.sleep(10000);
				wait.until(ExpectedConditions.elementToBeClickable(CO.getPO()));
				CO.getparPO().sendKeys((String.valueOf(x)));
				Thread.sleep(5000);

				Select se1 = new Select(QD.GetReplacementSystem());
				se1.selectByValue("Yes");
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
				wait.until(ExpectedConditions.elementToBeClickable(OD.ClickPlaceOrder()));
				Thread.sleep(10000);
				OD.ClickPlaceOrder().click();
				Thread.sleep(20000);
				System.out.println(QD.GetMessage().getText());
				System.out.println("PO Number is :" + QD.GetPONum().getText());
				Thread.sleep(10000);

			}

			catch (org.openqa.selenium.NoSuchElementException e) {

				e.printStackTrace();
				// driver.navigate().back();

				Thread.sleep(5000);

				Assert.assertTrue(false, "Failed" + e.getMessage());

			}

		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "url" })
	@Test(priority = 14, description = "AllProduct SubCategory Random Click", enabled = false)
	public void AllProductSubCategory(String url) throws IOException, InterruptedException {

		System.out.println(
				"Scenario 14 :Randomly select the category from all product sections and then select product and add to cart");

		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			hdr.getShopBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("All Products")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Shop - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);

			WebElement ele = driver
					.findElement(By.xpath("//*[@class='submenu-left']/ul//a[contains(text(),'Cables')]"));

			wait1.until(ExpectedConditions.elementToBeClickable(ele));
			Actions actions = new Actions(driver);
			actions.moveToElement(ele);
			actions.perform();
			Thread.sleep(10000);

//			List<WebElement> listings = driver.findElements(
//					By.xpath("//*[@class='submenu-right']/div[@data-tertiary-nav-id='cables']//ul[1]/li"));
//			wait1.until(ExpectedConditions.elementToBeClickable((By) listings));
//			Random r = new Random();
//			int randomValue = r.nextInt(listings.size()); // Getting a random value that is between 0 and (list's
//															// size)-1
//			listings.get(randomValue).click();

			WebElement ele2 = driver.findElement(
					By.xpath("//*[@class='submenu-right']/div[@data-tertiary-nav-id='cables']//ul[1]/li[1]/a"));

			wait1.until(ExpectedConditions.elementToBeClickable(ele2));
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(ele2);
			actions1.click().perform();
			Thread.sleep(10000);

			wait.until(ExpectedConditions.elementToBeClickable(CP.getSecondPositionData()));
			CP.getSecondPositionData().click();
			Thread.sleep(5000);

			wait.until(ExpectedConditions.elementToBeClickable(CP.getProductPurchaseAddToCart()));
			CP.getProductPurchaseAddToCart().click();
			Thread.sleep(5000);

			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(CP.getCartDialogBoxAddToCart()));
			CP.getCartDialogBoxAddToCart().click();
			Thread.sleep(5000);

			String title2 = driver.getTitle();
			String exp2 = "Order Checkout - MarkITplace";
			Assert.assertEquals(title2, exp2);
			Thread.sleep(5000);

			Random random = new Random();
			int x = random.nextInt(90000) + 100;
			try {

				Thread.sleep(10000);
				wait.until(ExpectedConditions.elementToBeClickable(CO.getPO()));
				CO.getparPO().sendKeys((String.valueOf(x)));
				Thread.sleep(5000);

				Select se1 = new Select(QD.GetReplacementSystem());
				se1.selectByValue("Yes");
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
				wait.until(ExpectedConditions.elementToBeClickable(OD.ClickPlaceOrder()));
				Thread.sleep(10000);
				OD.ClickPlaceOrder().click();
				Thread.sleep(20000);
				System.out.println(QD.GetMessage().getText());
				System.out.println("PO Number is :" + QD.GetPONum().getText());
				Thread.sleep(10000);

			}

			catch (org.openqa.selenium.NoSuchElementException e) {

				e.printStackTrace();
				// driver.navigate().back();

				Thread.sleep(5000);

				Assert.assertTrue(false, "Failed" + e.getMessage());

			}

		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "url" })
	@Test(priority = 15, description = "AllProduct View All Categories", enabled = false)
	public void AllProductViewAllCategories(String url) throws IOException, InterruptedException {

		System.out.println("Scenario 15 :click on view all categories and select randomly one product and add to cart");

		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			hdr.getShopBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("All Products")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Shop - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);

			WebElement ele = driver
					.findElement(By.xpath("//*[@class='submenu-left']/a[contains(text(),'View All Categories')]"));

			wait1.until(ExpectedConditions.elementToBeClickable(ele));
			Actions actions = new Actions(driver);
			actions.moveToElement(ele);
			actions.click().perform();
			Thread.sleep(10000);

			WebElement Cablelistings = driver.findElement(
					By.xpath("//*[@class='all-products-grid clearfix']//li[2]/a[contains(text(),'Audio Cables')]"));
			wait.until(ExpectedConditions.elementToBeClickable(Cablelistings));
			Cablelistings.click();
			Thread.sleep(10000);

			wait.until(ExpectedConditions.elementToBeClickable(CP.getSecondPositionData()));
			CP.getSecondPositionData().click();
			Thread.sleep(5000);

			wait.until(ExpectedConditions.elementToBeClickable(CP.getProductPurchaseAddToCart()));
			CP.getProductPurchaseAddToCart().click();
			Thread.sleep(5000);

			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(CP.getCartDialogBoxAddToCart()));
			CP.getCartDialogBoxAddToCart().click();
			Thread.sleep(5000);

			String title2 = driver.getTitle();
			String exp2 = "Order Checkout - MarkITplace";
			Assert.assertEquals(title2, exp2);
			Thread.sleep(5000);

			Random random = new Random();
			int x = random.nextInt(90000) + 100;
			try {

				Thread.sleep(10000);
				wait.until(ExpectedConditions.elementToBeClickable(CO.getPO()));
				CO.getparPO().sendKeys((String.valueOf(x)));
				Thread.sleep(5000);

				Select se1 = new Select(QD.GetReplacementSystem());
				se1.selectByValue("Yes");
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
				wait.until(ExpectedConditions.elementToBeClickable(OD.ClickPlaceOrder()));
				Thread.sleep(10000);
				OD.ClickPlaceOrder().click();
				Thread.sleep(20000);
				System.out.println(QD.GetMessage().getText());
				System.out.println("PO Number is :" + QD.GetPONum().getText());
				Thread.sleep(10000);

			}

			catch (org.openqa.selenium.NoSuchElementException e) {

				e.printStackTrace();
				// driver.navigate().back();

				Thread.sleep(5000);

				Assert.assertTrue(false, "Failed" + e.getMessage());

			}

		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "url" })
	@Test(priority = 16, description = "select feature brand and then select product", enabled = false)
	public void Brand_FeatureBrands(String url) throws IOException, InterruptedException {

		System.out.println("Scenario 16 :select feature brand and then select product ");

		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getShopBtn()));
			hdr.getShopBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Brands")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "All Brands - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);

			List<WebElement> listings = driver
					.findElements(By.xpath("//*[@class='feature-section cms-bbrands no-lower-divider']//article"));

			Random r = new Random();
			int randomValue = r.nextInt(listings.size()); // Getting a random value that is between 0 and (list's
															// size)-1
			listings.get(randomValue).click();

			Thread.sleep(10000);
			String title2 = driver.getTitle();
			// wait.until(ExpectedConditions.visibilityOfAllElements(driver.getTitle()));
			if (title2.contentEquals("Apple - MarkITplace")) {

				System.out.print("Apple");
				wait.until(ExpectedConditions.elementToBeClickable(BD.getAppleSellerSecondProduct()));
				BD.getAppleSellerSecondProduct().click();
				Thread.sleep(5000);
			} else if (title2.contentEquals("Dell - MarkITplace")) {

				System.out.print("Dell");
				wait.until(ExpectedConditions.elementToBeClickable(BD.getSecondSellerSecondProduct()));
				BD.getSecondSellerSecondProduct().click();
				Thread.sleep(5000);
			} else if (title2.contentEquals("HP - MarkITplace")) {
				System.out.print("HP");
				wait.until(ExpectedConditions.elementToBeClickable(BD.getSecondSellerSecondProduct()));
				BD.getSecondSellerSecondProduct().click();
				Thread.sleep(5000);
			}

			else if (title2.contentEquals("HPE - MarkITplace")) {
				System.out.print("HPE");
				wait.until(ExpectedConditions.elementToBeClickable(BD.getSecondSellerSecondProduct()));
				BD.getSecondSellerSecondProduct().click();
				Thread.sleep(5000);
			} else if (title2.contentEquals("Lenovo - MarkITplace")) {
				System.out.print("Lenovo");
				wait.until(ExpectedConditions.elementToBeClickable(BD.getSecondSellerSecondProduct()));
				BD.getSecondSellerSecondProduct().click();
				Thread.sleep(5000);
			} else {

				System.out.print("Microsoft");
				wait.until(ExpectedConditions.elementToBeClickable(BD.getTopSellingSurfaceSecondProduct()));
				BD.getTopSellingSurfaceSecondProduct().click();
				Thread.sleep(5000);
			}

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(CP.getProductPurchaseAddToCart()));
			CP.getProductPurchaseAddToCart().click();
			Thread.sleep(5000);

			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(CP.getCartDialogBoxAddToCart()));
			CP.getCartDialogBoxAddToCart().click();
			Thread.sleep(5000);

			String title3 = driver.getTitle();
			String exp2 = "Order Checkout - MarkITplace";
			Assert.assertEquals(title3, exp2);
			Thread.sleep(5000);

			Random random = new Random();
			int x = random.nextInt(90000) + 100;
			try {

				Thread.sleep(10000);
				wait.until(ExpectedConditions.elementToBeClickable(CO.getPO()));
				CO.getparPO().sendKeys((String.valueOf(x)));
				Thread.sleep(5000);

				Select se1 = new Select(QD.GetReplacementSystem());
				se1.selectByValue("Yes");
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
				wait.until(ExpectedConditions.elementToBeClickable(OD.ClickPlaceOrder()));
				Thread.sleep(10000);
				OD.ClickPlaceOrder().click();
				Thread.sleep(20000);
				System.out.println(QD.GetMessage().getText());
				System.out.println("PO Number is :" + QD.GetPONum().getText());
				Thread.sleep(10000);

			}

			catch (org.openqa.selenium.NoSuchElementException e) {

				e.printStackTrace();
				// driver.navigate().back();

				Thread.sleep(5000);

				Assert.assertTrue(false, "Failed" + e.getMessage());

			}

		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "url" })
	@Test(priority = 17, description = "Randomly Select the Brand", enabled = false)
	public void Brand_RandomlySelectBrand(String url) throws IOException, InterruptedException {

		System.out.println(
				"Scenario 17 :select all brands and then randomly select one brand in alphabetically order and add to cart ");

		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getShopBtn()));
			hdr.getShopBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Brands")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "All Brands - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);

			List<WebElement> listings = driver.findElements(By.xpath(
					"//*[@class='feature-section cms-bbrands container ']//section//*[@class='col-md-3 b-name-item']/a"));
			Random r = new Random();
			int randomValue = r.nextInt(listings.size()); // Getting a random value that is between 0 and (list's
															// size)-1

			listings.get(randomValue).click();
			Thread.sleep(10000);
			String title2 = driver.getTitle();
			System.out.print(title2);
			
			if ((title2.contentEquals("Dell - MarkITplace")) || (title2.contentEquals("HP - MarkITplace")) || (title2.contentEquals("HPE - MarkITplace")) || (title2.contentEquals("Lenovo - MarkITplace")) || (title2.contentEquals("Apple - MarkITplace")) || (title2.contentEquals("Microsoft - MarkITplace")))
			{
//			// wait.until(ExpectedConditions.visibilityOfAllElements(driver.getTitle()));
			if ((title2.contentEquals("Dell - MarkITplace")) || (title2.contentEquals("HP - MarkITplace")) || (title2.contentEquals("HPE - MarkITplace")) || (title2.contentEquals("Lenovo - MarkITplace"))) {
				System.out.print("Dell");
				wait.until(ExpectedConditions.elementToBeClickable(BD.getSecondSellerSecondProduct()));
				BD.getSecondSellerSecondProduct().click();
				Thread.sleep(5000);
			}
			else if (title2.contentEquals("Apple - MarkITplace")) {
				System.out.print("Apple");
				wait.until(ExpectedConditions.elementToBeClickable(BD.getAppleSellerSecondProduct()));
				BD.getAppleSellerSecondProduct().click();
				Thread.sleep(5000);
			}
			else if (title2.contentEquals("Microsoft - MarkITplace"))
			{
				System.out.print("Microsoft");
				wait.until(ExpectedConditions.elementToBeClickable(BD.getTopSellingSurfaceSecondProduct()));
				BD.getTopSellingSurfaceSecondProduct().click();
				Thread.sleep(5000);
			}
			

		
//
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(CP.getProductPurchaseAddToCart()));
			CP.getProductPurchaseAddToCart().click();
			Thread.sleep(5000);

			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(CP.getCartDialogBoxAddToCart()));
			CP.getCartDialogBoxAddToCart().click();
			Thread.sleep(5000);

			String title3 = driver.getTitle();
			String exp2 = "Order Checkout - MarkITplace";
			Assert.assertEquals(title3, exp2);
			Thread.sleep(5000);

			Random random = new Random();
			int x = random.nextInt(90000) + 100;
			try {

				Thread.sleep(10000);
				wait.until(ExpectedConditions.elementToBeClickable(CO.getPO()));
				CO.getparPO().sendKeys((String.valueOf(x)));
				Thread.sleep(5000);

				Select se1 = new Select(QD.GetReplacementSystem());
				se1.selectByValue("Yes");
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
				wait.until(ExpectedConditions.elementToBeClickable(OD.ClickPlaceOrder()));
				Thread.sleep(10000);
				OD.ClickPlaceOrder().click();
				Thread.sleep(20000);
				System.out.println(QD.GetMessage().getText());
				System.out.println("PO Number is :" + QD.GetPONum().getText());
				Thread.sleep(10000);

			}

			catch (org.openqa.selenium.NoSuchElementException e) {

				e.printStackTrace();
				// driver.navigate().back();

				Thread.sleep(5000);

				Assert.assertTrue(false, "Failed" + e.getMessage());

			}
			}
			else {
				
				System.out.print(" Product Not Listed");
			}

		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "url" })
	@Test(priority = 18, description = "Resource_Fresource and scroll down and select", enabled = false)
	public void Resource_ResourceAndScrollDownAndSelect(String url) throws IOException, InterruptedException {

		System.out.println("Scenario 18 :click on resource and scroll down and select \"see more\" buttonn ");

		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getShopBtn()));
			hdr.getShopBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Resources")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Resources - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);



			

		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}
	
	@Parameters({ "url" })
	@Test(priority = 19, description = "select special offer and successfully page will open", enabled = false)
	public void SpecialOffer_PageToBeOpen(String url) throws IOException, InterruptedException {

		System.out.println("Scenario 19 :select special offer and successfully page will open ");

		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getShopBtn()));
			hdr.getShopBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Special Offers")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Special Offers - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			

		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}
	
	@Parameters({ "url" })
	@Test(priority = 20, description = "Verify the Calendar Monthly View", enabled = false)
	public void Calendar_Monthly_ViewManufacturer_Warranties_Expiring(String url) throws IOException, InterruptedException {

		System.out.println("Scenario 20 :Verify the Calendar Monthly View and count the number of total Manufacturer Warranties Expiring ");

		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Calendar")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Calendar Monthly View - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			int total = 0;
			List<WebElement> totalDivs = driver.findElements(By.xpath("//*[@class='currentMonths']//li[@class='accordion-list-item'][1]//div[@class='dot warranty']"));
			for(WebElement we : totalDivs){
			    total += Integer.parseInt(we.getText());
			}
			System.out.println(total);
			
			wait1.until(ExpectedConditions.elementToBeClickable(CC.getManufacturerWarrantiesExpiring()));
			CC.getManufacturerWarrantiesExpiring().click();
			
			List<WebElement> rows = driver.findElements(By.xpath("//table[@class='mobile-table']//tbody/tr"));
			
			int count = rows.size();
			System.out.println(count);
			
			Assert.assertEquals(total, count);
			


		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "url" })
	@Test(priority = 21, description = "Verify the Calendar Monthly View", enabled = false)
	public void Calendar_Monthly_count_one_Manufacturer(String url) throws IOException, InterruptedException {

		System.out.println("Scenario 21 :Verify the Calendar Monthly View and count one Manufacturer that is apple and compare the result with inner page of expiration (Reports) ");

		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Calendar")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Calendar Monthly View - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
//			int total = 0;
//			List<WebElement> totalDivs = driver.findElements(By.xpath("//*[@class='currentMonths']//li[@class='accordion-list-item'][1]//div[@class='small-12 medium-4 large-2 columns box manufacturer']//a[contains(text(),'APPLE')]"));
//			//System.out.println(totalDivs.size());
//			
//			for(WebElement we : totalDivs){
//			    total += Integer.parseInt(we.getText());
//			}
//			System.out.println(total);
			
			 String OSNAMES= driver.findElement(By.xpath("//*[@class='currentMonths']//li[@class='accordion-list-item'][1]//div[@class='small-12 medium-4 large-2 columns box manufacturer']//a[contains(text(),'APPLE')]")).getText();
			 //System.out.println(OSNAMES);
			 int quantity = Integer.parseInt(OSNAMES);
			System.out.println(quantity);
			 Integer qty = Integer.valueOf(OSNAMES);
			 System.out.println(qty);
//			for(WebElement we : totalDivs){
//			    total += Integer.parseInt(we.getText());
//			}
//			System.out.println(total);
//			
//			wait1.until(ExpectedConditions.elementToBeClickable(CC.getManufacturerWarrantiesExpiring()));
//			CC.getManufacturerWarrantiesExpiring().click();
//			
//			List<WebElement> rows = driver.findElements(By.xpath("//table[@class='mobile-table']//tbody/tr"));
//			
//			int count = rows.size();
//			System.out.println(count);
//			
//			Assert.assertEquals(total, count);
			


		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}
	
	@Parameters({ "url" })
	@Test(priority = 22, description = "Verify the Calendar Monthly View and count the number of total End of life", enabled = false)
	public void Calendar_Monthly_count_andCountNumberoftotalEndoflife(String url) throws IOException, InterruptedException {

		//not done as calandar page taking too much time to load
		System.out.println("Scenario 22 :Verify the Calendar Monthly View and count the number of total End of life");

		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Calendar")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Calendar Monthly View - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			

			


		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "url" })
	@Test(priority = 23, description = "Verify the Calendar Monthly View and count the number of total End of life and compare the result with inner page of assets(Reports)", enabled = false)
	public void Calendar_Monthly_count_andCountNumberoftotalEndoflifeAndCompare(String url) throws IOException, InterruptedException {
		//not done as calandar page taking too much time to load
		System.out.println("Scenario 23 : Verify the Calendar Monthly View and count the number of total End of life and compare the result with inner page of assets(Reports)");

		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Calendar")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Calendar Monthly View - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			

			


		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "url" })
	@Test(priority = 23, description = "verify the Subscribe to Calandars", enabled = false)
	public void VerifTheSubscribeToCalandars(String url) throws IOException, InterruptedException {
		//not done as calandar page taking too much time to load
		System.out.println("Scenario 24 : verify the Subscribe to Calandars");
		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Calendar")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Calendar Monthly View - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			

			


		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}

	@Parameters({ "url" })
	@Test(priority = 25, description = "Click on assest Report", enabled = false)
	public void VerifClickOnAssestReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 25 : Click on assest Report");
		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			wait1.until(ExpectedConditions.elementToBeClickable(By.linkText("Assets")));
			driver.findElement(By.linkText("Assets")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Assets Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			
			
			
			
			

		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}

	}
	
	@Parameters({ "url" })
	@Test(priority = 26, description = "Click on Edit button", enabled = false)
	public void VerifClickOnEditButton (String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 26 : Click on Edit button");
		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Assets")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Assets Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEditAssetReport()));
			AAP.getEditAssetReport().click();
			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEditReportDefaultView()));
			AAP.getEditReportDefaultView().click();
			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getSaveRpt1()));
			AAP.getSaveRpt1().click();
			Thread.sleep(5000);
			
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url" })
	@Test(priority = 26, description = "Click on Edit button", enabled = false)
	public void VerifClickOnEditButtonAndfrequencytomonthly (String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 26 : Click on Edit button");
		try {

			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Assets")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Assets Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEditScheduleReport()));
			AAP.getEditScheduleReport().click();
			Thread.sleep(5000);
			
			
		
			Select objSelect =new Select(driver.findElement(By.xpath("//*[@id='frequency_Assets']")));
			objSelect.selectByVisibleText("Monthly");
			Thread.sleep(5000);
			
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getScheduleReportButton()));
			AAP.getScheduleReportButton().click();
			Thread.sleep(5000);
			
		
			
			
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url" })
	@Test(priority = 26, description = "Click on Edit button", enabled = false)
	public void VerifyexportoptionandSelect(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 26 : Verify the Export option and and select all options and click on export report");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Assets")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Assets Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getExportButton()));
			AAP.getExportButton().click();
			Thread.sleep(5000);
			
			Select objSelect =new Select(driver.findElement(By.xpath("//*[@id='types']")));
			objSelect.selectByVisibleText("Excel");
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getExportButtonCurrentPage()));
			AAP.getExportButtonCurrentPage().click();
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getExportReport()));
			AAP.getExportReport().click();
			
			
			String exp7 = "Assets Report - MarkITplace";
			Assert.assertEquals(title7, exp7);
		
			
			
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url" })
	@Test(priority = 26, description = "Click on Invoices Reports", enabled = false)
	public void VerifyInvoicesReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 26 : Click on Invoices Reports.");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Invoices")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Invoices Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			 
		
			
			
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url" })
	@Test(priority = 27, description = "Click on Invoices Reports", enabled = false)
	public void VerifyInvoicesReportEdit(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 27 : Click on Edit button .");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Invoices")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Invoices Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEditAssetReport()));
			AAP.getEditAssetReport().click();
			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEditReportDefaultView()));
			AAP.getEditReportDefaultView().click();
			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getSaveRpt1()));
			AAP.getSaveRpt1().click();
			Thread.sleep(5000);
			 
		
			
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url" })
	@Test(priority = 28, description = "Click on Invoices Reports", enabled = false)
	public void VerifyInvoicesScheduleReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 28 : Click on edit schedule Report and select the frequency to monthly & Yearly and select the respective fields and then schedule Report");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Invoices")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Invoices Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEditScheduleReport()));
			AAP.getEditScheduleReport().click();
			Thread.sleep(5000);
			
			
			Select objSelect =new Select(driver.findElement(By.xpath("//*[@id='frequency_Invoices']")));
			objSelect.selectByVisibleText("Monthly");
			Thread.sleep(5000);
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEmailAddress()));
			AAP.getEmailAddress().sendKeys("ayer.shuja@arpatech.com");
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getScheduleReportButton()));
			AAP.getScheduleReportButton().click();
			Thread.sleep(5000);
			
			
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url" })
	@Test(priority = 29, description = "Click on Invoices Reports", enabled = false)
	public void VerifyInvoicesRandomSelection(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 29 : Verify the random selection of 5 rows and email selected invoices");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Invoices")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Invoices Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getSelectionOfRow()));
			AAP.getSelectionOfRow().click();
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEmailSelectedBtn()));
			AAP.getEmailSelectedBtn().click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[@id=\"email_addresses\"]")).sendKeys("ayer.shuja@arpatech.com");
			
			driver.findElement(By.xpath("//*[@id=\"reportForm\"]/div[23]/div/div/div/div/div/div/button[1]")).click();
			
			
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url" })
	@Test(priority = 30, description = "Click on Invoices Reports", enabled = false)
	public void VerifyInvoicesReportMactchesRecord(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 30 : Verify the search module that input the order number in the order # in header and verify that search result returing that order # specifically");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Invoices")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Invoices Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			String Actual =AAP.getSubTotalReport().getText();
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getOrderNumberReport()));
			AAP.getOrderNumberReport().click();
			Thread.sleep(5000);
			
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.scrollTo(0,1000)");
			
			wait1.until(ExpectedConditions.visibilityOf(AAP.getSubTotalOrderDetail()));
			String Expected =  AAP.getSubTotalOrderDetail().getText();
			Assert.assertEquals(Actual, Expected);
			
			driver.navigate().back();
			
			
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url" })
	@Test(priority = 31, description = "Click on Invoices Reports", enabled = false)
	public void VerifyRandomLySelect5Fields(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 31 : Verify the select Field option and select randomly 5 fields and click on apply and cancel button and view that 5 fields are appearing or not");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Invoices")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Invoices Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getSelectFields()));
			AAP.getSelectFields().click();
			Thread.sleep(5000);
			
			for(int i=0; i<=5 ;i++) {
		    List<WebElement> allProducts = driver.findElements(By.xpath("//*[@class='white-popup popup-small zoom-anim-dialog mfp-show schedule-report-modal select-fields clearfix']//div[@class='refine-section-content']/ul"));
		   
		    Random rand = new Random();
		    int randomProduct = rand.nextInt(allProducts.size());
		    allProducts.get(randomProduct).click();
		    
			}
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getApplySelectionFields()));
			AAP.getApplySelectionFields().click();
			Thread.sleep(5000);
			
			
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url" })
	@Test(priority = 32, description = "Click on Invoices Reports", enabled = false)
	public void VerifyOrdersReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 32 : Click on orders Report");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(hdr.getTrackBtn()));
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@data-submenu-id='reports']//a[contains(text(),'Orders')]")).click();
//
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Orders Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			cf.logout();
			wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
//			
			
			
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url","username1", "pswd1", })
	@Test(priority = 33, description = "Scenario 33 : Login with \"arpatech_ag_puchaser@connection.com\" to view the PAR Report", enabled = false)
	public void VerifyPARReport(String url,String username1,String pswd1 ) throws IOException, InterruptedException {
		
		System.out.println("Scenario 33 : Login with \"arpatech_ag_puchaser@connection.com\" to view the PAR Report");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
			lp.getusername().sendKeys(username1);
			lp.getpassword().sendKeys(pswd1);
			lp.getloginbtn().click();
			Thread.sleep(7000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.linkText("Purchase Approval Requests (PAR)")).click();

			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Purchase Approval Requests (PAR) Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			

			
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 34, description = "Verify View all \"Rejected\" and match with record that is appearing on report.", enabled = false)
	public void VerifyPARRejectedRecord(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 34 : Verify View all \"Rejected\" and match with record that is appearing on report.");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			driver.get(url);
			Thread.sleep(5000);


			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.linkText("Purchase Approval Requests (PAR)")).click();
			
			
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Purchase Approval Requests (PAR) Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			Select se1 = new Select(PRR.getRejectedView());
			se1.selectByValue("15");
			
			
			String Actual=PRR.getRejectedStatus().getText();
			Assert.assertEquals("Rejected", Actual);

				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 35, description = "Verify View all \"Approved\" and match with record that is appearing on report.", enabled = false)
	public void VerifyPARApprovedRecord(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 35 : Verify View all \"Approved\" and match with record that is appearing on report.");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			driver.get(url);
			Thread.sleep(5000);


			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.linkText("Purchase Approval Requests (PAR)")).click();
			
			
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Purchase Approval Requests (PAR) Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			Select se1 = new Select(PRR.getRejectedView());
			se1.selectByValue("28638");
			
			
			String Actual=PRR.getApprovedStatus().getText();
			Assert.assertEquals("Approved", Actual);

				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 36, description = "Click on Edit button on PAR Report.", enabled = false)
	public void VerifyPAREditRecord(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 36 : Click on Edit button on PAR Report.");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			driver.get(url);
			Thread.sleep(5000);


			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.linkText("Purchase Approval Requests (PAR)")).click();
			
			
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Purchase Approval Requests (PAR) Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEditAssetReport()));
			AAP.getEditAssetReport().click();
			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEditReportDefaultView()));
			AAP.getEditReportDefaultView().click();
			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getSaveRpt1()));
			AAP.getSaveRpt1().click();
			Thread.sleep(5000);

				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 37, description = "Click on edit schedule Report and select the frequency to monthly & Yearly and select the respective fields and then schedule Report", enabled = false)
	public void VerifyPAREditScheduleReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 37 : Click on edit schedule Report and select the frequency to monthly & Yearly and select the respective fields and then schedule Report");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			driver.get(url);
			Thread.sleep(5000);


			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.linkText("Purchase Approval Requests (PAR)")).click();
			
			
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Purchase Approval Requests (PAR) Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEditScheduleReport()));
			AAP.getEditScheduleReport().click();
			Thread.sleep(5000);
			
			
			Select objSelect =new Select(driver.findElement(By.xpath("//*[@id='frequency_Purchase Approval Requests (PAR)']")));
			objSelect.selectByVisibleText("Monthly");
			Thread.sleep(5000);
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEmailAddress()));
			AAP.getEmailAddress().sendKeys("ayer.shuja@arpatech.com");
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getScheduleReportButton()));
			AAP.getScheduleReportButton().click();
			Thread.sleep(5000);

				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 38, description = "Verify the select Field option and select randomly 5 fields and click on apply and cancel button and view that 5 fields are appearing or not", enabled = false)
	public void VerifyPARRandomly5FieldsReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 38 : Verify the select Field option and select randomly 5 fields and click on apply and cancel button and view that 5 fields are appearing or not");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			driver.get(url);
			Thread.sleep(5000);


			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.linkText("Purchase Approval Requests (PAR)")).click();
			
			
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Purchase Approval Requests (PAR) Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getSelectFields()));
			AAP.getSelectFields().click();
			Thread.sleep(5000);
			
			for(int i=0; i<=5 ;i++) {
		    List<WebElement> allProducts = driver.findElements(By.xpath("//*[@class='white-popup popup-small zoom-anim-dialog mfp-show schedule-report-modal select-fields clearfix']//div[@class='refine-section-content']/ul"));
		   
		    Random rand = new Random();
		    int randomProduct = rand.nextInt(allProducts.size());
		    allProducts.get(randomProduct).click();
		    
			}
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getApplySelectionFields()));
			AAP.getApplySelectionFields().click();
			Thread.sleep(5000);
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 39, description = "Verify the select Field option and select select all fields and click on apply and cancel button and view that all fields are appearing or not", enabled = false)
	public void VerifyPARAllFieldsReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 39 : Verify the select Field option and select select all fields and click on apply and cancel button and view that all fields are appearing or not");
		
		try {
			
			///((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			driver.get(url);
			Thread.sleep(5000);


			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.linkText("Purchase Approval Requests (PAR)")).click();
			
			
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Purchase Approval Requests (PAR) Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getSelectFields()));
			AAP.getSelectFields().click();
			Thread.sleep(5000);
			

			wait1.until(ExpectedConditions.elementToBeClickable(PRR.getSelectAllFields()));
			PRR.getSelectAllFields().click();
			Thread.sleep(5000);
			

			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getApplySelectionFields()));
			AAP.getApplySelectionFields().click();
			Thread.sleep(5000);
		    
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 40, description = "Verify the Export option and and select all options and click on export report", enabled = false)
	public void VerifyPARExportOptionReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 40 : Verify the Export option and and select all options and click on export report");
		
		try {
			
			///((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			driver.get(url);
			Thread.sleep(5000);


			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.linkText("Purchase Approval Requests (PAR)")).click();
			
			
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Purchase Approval Requests (PAR) Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			

			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getExportButton()));
			AAP.getExportButton().click();
			Thread.sleep(5000);
			
			Select objSelect =new Select(driver.findElement(By.xpath("//*[@id='types']")));
			objSelect.selectByVisibleText("Excel");
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getExportButtonCurrentPage()));
			AAP.getExportButtonCurrentPage().click();
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getExportReport()));
			AAP.getExportReport().click();
			
			
			String exp7 = "Purchase Approval Requests (PAR) Report - MarkITplace";
			Assert.assertEquals(title7, exp7);
		    
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 41, description = "Verify the random selection of 5 rows and email selected invoices. ", enabled = false)
	public void NotVerifyPARRandomSelectionReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 41 : Verify the random selection of 5 rows and email selected invoices. ");
		
		try {
			
			///((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			driver.get(url);
			Thread.sleep(5000);


			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.linkText("Purchase Approval Requests (PAR)")).click();
			
			
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Purchase Approval Requests (PAR) Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			

			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getSelectionOfRow()));
			AAP.getSelectionOfRow().click();
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEmailSelectedBtn()));
			AAP.getEmailSelectedBtn().click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[@id=\"email_addresses\"]")).sendKeys("ayer.shuja@arpatech.com");
			
			driver.findElement(By.xpath("//*[@id=\"reportForm\"]/div[23]/div/div/div/div/div/div/button[1]")).click();
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 41, description = "Click on email report and send to report. ", enabled = false)
	public void VerifyPAREmailReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 41 : Click on email report and send to report. ");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			driver.get(url);
			Thread.sleep(5000);


			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.linkText("Purchase Approval Requests (PAR)")).click();
			
			
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Purchase Approval Requests (PAR) Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			

			
			wait1.until(ExpectedConditions.elementToBeClickable(PRR.getEmailFields()));
			PRR.getEmailFields().click();
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(PRR.getSendEmail()));
			PRR.getSendEmail().click();
			Thread.sleep(5000);
			
			cf.logout();
			

				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
  
	
	@Parameters({ "url","username3", "pswd3"})
	@Test(priority = 42, description = "Click on Quote Report. ", enabled = false)
	public void VerifyQuoteReport(String url, String username3,String pswd3) throws IOException, InterruptedException {
		
		System.out.println("Scenario 42 : Click on Quote Report. ");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			driver.get(url);
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
			lp.getusername().sendKeys(username3);
			lp.getpassword().sendKeys(pswd3);
			lp.getloginbtn().click();
			Thread.sleep(7000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			hdr.getTrackBtn().click();
			Thread.sleep(5000);

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.xpath("//*[@data-submenu-id='reports']//li/a[contains(text(),'Quotes')]")).click();
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Quotes Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 43, description = "Click on Quote Edit button . ", enabled = false)
	public void VerifyQuoteEditButtonReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 43 : Click on Quote Edit button . ");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.xpath("//*[@data-submenu-id='reports']//li/a[contains(text(),'Quotes')]")).click();
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Quotes Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEditAssetReport()));
			AAP.getEditAssetReport().click();
			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEditReportDefaultView()));
			AAP.getEditReportDefaultView().click();
			Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getSaveRpt1()));
			AAP.getSaveRpt1().click();
			Thread.sleep(5000);
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 44, description = "Click on edit schedule Report and select the frequency to monthly & Yearly and select the respective fields and then schedule Report . ", enabled = false)
	public void VerifyQuoteScheduleReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 44 : Click on edit schedule Report and select the frequency to monthly & Yearly and select the respective fields and then schedule Report . ");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.xpath("//*[@data-submenu-id='reports']//li/a[contains(text(),'Quotes')]")).click();
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Quotes Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEditScheduleReport()));
			AAP.getEditScheduleReport().click();
			Thread.sleep(5000);
			
			
			Select objSelect =new Select(driver.findElement(By.xpath("//*[@id='frequency_Quotes']")));
			objSelect.selectByVisibleText("Monthly");
			Thread.sleep(5000);
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getEmailAddress()));
			AAP.getEmailAddress().sendKeys("ayer.shuja@arpatech.com");
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getScheduleReportButton()));
			AAP.getScheduleReportButton().click();
			Thread.sleep(5000);
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 45, description = "Verify the select Field option and select randomly 5 fields and click on apply and cancel button and view that 5 fields are appearing or not ", enabled = false)
	public void VerifyQuoteFieldOptionAndRandomlySelectReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 45 : Verify the select Field option and select randomly 5 fields and click on apply and cancel button and view that 5 fields are appearing or not ");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.xpath("//*[@data-submenu-id='reports']//li/a[contains(text(),'Quotes')]")).click();
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Quotes Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getSelectFields()));
			AAP.getSelectFields().click();
			Thread.sleep(5000);
			
			for(int i=0; i<=5 ;i++) {
		    List<WebElement> allProducts = driver.findElements(By.xpath("//*[@class='white-popup popup-small zoom-anim-dialog mfp-show schedule-report-modal select-fields clearfix']//div[@class='refine-section-content']/ul"));
		   
		    Random rand = new Random();
		    int randomProduct = rand.nextInt(allProducts.size());
		    allProducts.get(randomProduct).click();
		    
			}
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getApplySelectionFields()));
			AAP.getApplySelectionFields().click();
			Thread.sleep(5000);
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	
	@Parameters({ "url"})
	@Test(priority = 46, description = "Verify the select Field option and select select all fields and click on apply and cancel button and view that all fields are appearing or not ", enabled = false)
	public void VerifyQuoteFieldOptionAndSelectAllReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 46 : Verify the select Field option and select select all fields and click on apply and cancel button and view that all fields are appearing or not.");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.xpath("//*[@data-submenu-id='reports']//li/a[contains(text(),'Quotes')]")).click();
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Quotes Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getSelectFields()));
			AAP.getSelectFields().click();
			Thread.sleep(5000);
			

			wait1.until(ExpectedConditions.elementToBeClickable(PRR.getSelectAllFields()));
			PRR.getSelectAllFields().click();
			Thread.sleep(5000);
			

			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getApplySelectionFields()));
			AAP.getApplySelectionFields().click();
			Thread.sleep(5000);
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 47, description = "Verify the Export option and and select all options and click on export report ", enabled = false)
	public void VerifyQuoteExportOptionReport(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 47 : Verify the Export option and and select all options and click on export report");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			

			driver.findElement(By.linkText("Reports")).click();
			Thread.sleep(5000);		
			driver.findElement(By.xpath("//*[@data-submenu-id='reports']//li/a[contains(text(),'Quotes')]")).click();
			Thread.sleep(5000);
			String title7 = driver.getTitle();
			String exp6 = "Quotes Report - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getExportButton()));
			AAP.getExportButton().click();
			Thread.sleep(5000);
			
			Select objSelect =new Select(driver.findElement(By.xpath("//*[@id='types']")));
			objSelect.selectByVisibleText("Excel");
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getExportButtonCurrentPage()));
			AAP.getExportButtonCurrentPage().click();
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(AAP.getExportReport()));
			AAP.getExportReport().click();
			
			
			String exp7 = "Quotes Report - MarkITplace";
			Assert.assertEquals(title7, exp7);
			
			cf.logout();
			wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
			
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url","username3" , "pswd3"})
	@Test(priority = 48, description = "Click on Order page to view orders ", enabled = false)
	public void VerifyOrderPage(String url, String username3 , String pswd3 ) throws IOException, InterruptedException {
		
		System.out.println("Scenario 48 : Click on Order page to view orders");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);
			
			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
			lp.getusername().sendKeys(username3);
			lp.getpassword().sendKeys(pswd3);
			lp.getloginbtn().click();
			Thread.sleep(7000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			driver.findElement(By.linkText("Orders")).click();
			
			String title7 = driver.getTitle();
			String exp6 = "Orders - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 49, description = "Click on View Orders button for all orders. ", enabled = false)
	public void VerifyViewOrdersButtonOnOredrs(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 49 : Click on View Orders button for all orders.");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			driver.findElement(By.linkText("Orders")).click();
			
			String title7 = driver.getTitle();
			String exp6 = "Orders - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(OD.GetViewOrderBtn()));
			OD.GetViewOrderBtn().click();
			Thread.sleep(5000);
			

			String title8 = driver.getTitle();
			String exp7 = "Order Details - MarkITplace";
			Assert.assertEquals(title8, exp7);
			Thread.sleep(5000);

			
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 50, description = "Click on View orders button for Shipped orders and past orders. ", enabled = false)
	public void VerifyViewOrdersForShippedOrders(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 50 : 12Nov2021Click on View orders button for Shipped orders and past orders.");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			driver.findElement(By.linkText("Orders")).click();
			
			String title7 = driver.getTitle();
			String exp6 = "Orders - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Select Status']")));
			Select objSelect = new Select(driver.findElement(By.xpath("//*[@title='Select Status']")));
			objSelect.selectByVisibleText("Shipped");
			Thread.sleep(5000);

			driver.findElement(
					By.xpath("//*[@class='order-container container clearfix']//li[1]//a[@class='btn-expand-content']"))
					.click();
			
			Thread.sleep(5000);

			String Shippedvalue = OD.GetShippedOredrs().getText();
			Assert.assertEquals(Shippedvalue, "Shipped");
			Thread.sleep(5000);
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,-200)");
			Thread.sleep(3000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Select Time Period']")));
			Select objSelect1 = new Select(driver.findElement(By.xpath("//*[@title='Select Time Period']")));
			objSelect1.selectByVisibleText("Past 6 months");
			

			driver.findElement(
					By.xpath("//*[@class='order-container container clearfix']//li[3]//a[@class='btn-expand-content']"))
					.click();

			String Shippedvalue1 = OD.GetShippedOredrs().getText();
			Assert.assertEquals(Shippedvalue1, "Shipped");
			Thread.sleep(5000);
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 51, description = "Click on View orders button for Past 6 Months orders. ", enabled = false)
	public void VerifyViewOrdersForPast6MonthsOrders(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 51 : Click on View orders button for Past 6 Months orders.");
		
		try {
			
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			driver.findElement(By.linkText("Orders")).click();
			
			String title7 = driver.getTitle();
			String exp6 = "Orders - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Select Status']")));
			Select objSelect = new Select(driver.findElement(By.xpath("//*[@title='Select Status']")));
			objSelect.selectByVisibleText("Shipped");
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Select Time Period']")));
			Select objSelect1 = new Select(driver.findElement(By.xpath("//*[@title='Select Time Period']")));
			objSelect1.selectByVisibleText("Past 6 months");
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,200)");
			Thread.sleep(3000);
			

			driver.findElement(
					By.xpath("//*[@class='order-container container clearfix']//li[3]//a[@class='btn-expand-content']"))
					.click();
			//Thread.sleep(3000);

			WebElement Shippedvalue1 = driver.findElement(By.xpath("//*[@class='order-container container clearfix']//li[3]//span[contains(text(),'Shipped')]"));
			Assert.assertEquals(Shippedvalue1.getText(), "Shipped");
			Thread.sleep(5000);
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 52, description = "Click on View Orders and Verify that the orders is same as in Order Detail page(QTY,Product,PO No,Total) ", enabled = false)
	public void VerifyViewOrdersVerifyOrders(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 52 : Click on View Orders and Verify that the orders is same as in Order Detail page(QTY,Product,Invoice No,Total)");
		
		try {
			
			//((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			driver.findElement(By.linkText("Orders")).click();
			
			String title7 = driver.getTitle();
			String exp6 = "Orders - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			WebElement TrackTotal = driver.findElement(By.xpath("//*[@class='order-container container clearfix']//li[1]//div[@class='columns small-12 tablet-2'][3]/p"));
			String TT= TrackTotal.getText();
			
			WebElement TrackPONumber = driver.findElement(By.xpath("//*[@class='order-container container clearfix']//li[1]//div[@class='columns small-12 tablet-2'][1]/p"));
			String TPN =TrackPONumber.getText();
			
			WebElement TrackQty = driver.findElement(By.xpath("//*[@class='order-container container clearfix']//li[1]//p[contains(text(),'Qty:')]"));
			String TQ =TrackQty.getText();
			
			WebElement TrackItem = driver.findElement(By.xpath("//*[@class='order-container container clearfix']//li[1]//div[@class='small-8 large-5 columns']/p"));
			String TI =TrackItem.getText();
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(OD.GetViewOrderBtn()));
			OD.GetViewOrderBtn().click();
			Thread.sleep(5000);
			
			String title8 = driver.getTitle();
			String exp7 = "Order Details - MarkITplace";
			Assert.assertEquals(title8, exp7);
			Thread.sleep(5000);
			
			WebElement OrderDetailTotal = driver.findElement(By.xpath("//*[@class='top-space clearfix']//div[@id='trackSectionRedirect']//div[@class='row subtotal']//span"));
			String ODT= OrderDetailTotal.getText();
	
			WebElement OrderDetailItem = driver.findElement(By.xpath("//*[@class='top-space clearfix']//div[@id='trackSectionRedirect']//a"));
			String ODI =OrderDetailItem.getText();
			
			
			Assert.assertEquals(TT, ODT);
			Assert.assertEquals(TI, ODI);
			
			
			
	
				
				
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 53, description = "Click on View invoice and Verify it should be  navigate to Invoice Report. ", enabled = false)
	public void VerifyViewInvoiceAndVerify(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 53 : Click on View invoice and Verify it should be  navigate to Invoice Report.");
		
		try {
			
			//((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			driver.findElement(By.linkText("Orders")).click();
			
			String title7 = driver.getTitle();
			String exp6 = "Orders - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Select Status']")));
			Select objSelect = new Select(driver.findElement(By.xpath("//*[@title='Select Status']")));
			objSelect.selectByVisibleText("Shipped");
			Thread.sleep(5000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Select Time Period']")));
			Select objSelect1 = new Select(driver.findElement(By.xpath("//*[@title='Select Time Period']")));
			objSelect1.selectByVisibleText("Past 6 months");
			
			WebElement TrackTotal = driver.findElement(By.xpath("//*[@class='order-container container clearfix']//li[1]//div[@class='columns small-12 tablet-2'][3]/p"));
			String TT= TrackTotal.getText();
			
			driver.findElement(
					By.xpath("//*[@class='order-container container clearfix']//li[1]//a[contains(text(),'View Invoices')]"))
					.click();
			
			String title8 = driver.getTitle();
			String exp7 = "Invoice Report - MarkITplace";
			Assert.assertEquals(title8, exp7);
			Thread.sleep(5000);
			
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 54, description = "Verify when clicked on passed and shipped orders three button should appear ie Track Package ,Buy It again , Request Return. ", enabled = false)
	public void VerifyThreeButtonAppears(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 54 : Verify when clicked on passed and shipped orders three button should appear ie Track Package ,Buy It again , Request Return.");
		
		try {
			
			//((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			driver.findElement(By.linkText("Orders")).click();
			
			String title7 = driver.getTitle();
			String exp6 = "Orders - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Select Status']")));
			Select objSelect = new Select(driver.findElement(By.xpath("//*[@title='Select Status']")));
			objSelect.selectByVisibleText("Shipped");
			Thread.sleep(5000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Select Time Period']")));
			Select objSelect1 = new Select(driver.findElement(By.xpath("//*[@title='Select Time Period']")));
			objSelect1.selectByVisibleText("Past 6 months");
			
			Thread.sleep(10000);
			
			driver.findElement(
					By.xpath("//*[@class='order-container container clearfix']//li[1]//a[@class='btn-expand-content']"))
					.click();
			
			Thread.sleep(10000);
			
			WebElement TrackTrackPackage = driver.findElement(By.xpath("//*[@class='order-container container clearfix']//li[1]//div[@class='action-area clearfix']//a[@class='btn btn-primary']"));
			String TT= TrackTrackPackage.getText();
			WebElement BuyItAgain = driver.findElement(By.xpath("//*[@class='order-container container clearfix']//li[1]//div[@class='action-area clearfix']//a[@class='btn buy-again']"));
			String BIA= BuyItAgain.getText();
			WebElement RequestReturn = driver.findElement(By.xpath("//*[@class='order-container container clearfix']//li[1]//div[@class='action-area clearfix']//a[@class='btn rma-btn']"));
			String RR= RequestReturn.getText();
			
			
			Assert.assertEquals(TT, "Track package");
			Assert.assertEquals(BIA, "Buy Items Again");
			Assert.assertEquals(RR, "Request Return");
			

		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 55, description = "Verify Buy it again should be clickable. ", enabled = false)
	public void VerifyBuyAgainInOrders(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 55 : Verify Buy it again should be clickable.");
		
		try {
			
			//((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			driver.findElement(By.linkText("Orders")).click();
			
			String title7 = driver.getTitle();
			String exp6 = "Orders - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Select Status']")));
			Select objSelect = new Select(driver.findElement(By.xpath("//*[@title='Select Status']")));
			objSelect.selectByVisibleText("Shipped");
			Thread.sleep(5000);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Select Time Period']")));
			Select objSelect1 = new Select(driver.findElement(By.xpath("//*[@title='Select Time Period']")));
			objSelect1.selectByVisibleText("Past 6 months");
			
			Thread.sleep(10000);
			
			driver.findElement(
					By.xpath("//*[@class='order-container container clearfix']//li[1]//a[@class='btn-expand-content']"))
					.click();
			
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(OD.GetBuyAgains()));
			OD.GetBuyAgains().click();
			Thread.sleep(5000);
			
			
			

		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 56, description = "Verify when any order is pasted in Search order then , search mechanism should show inputted search. ", enabled = false)
	public void VerifyShippedOrdersAppeared(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 56 : Verify when any order is pasted in Search order then , search mechanism should show inputted search.");
		
		try {
			
			//((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			driver.findElement(By.linkText("Orders")).click();
			
			String title7 = driver.getTitle();
			String exp6 = "Orders - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			String OrderNumber= "Order #14839486";
			OD.SearchOrder().sendKeys(OrderNumber + Keys.ENTER);
			Thread.sleep(5000);
			
			String OrderNum = driver.findElement(By.xpath("//*[@class='accordion-list-item']//span[contains(text(),'Order #')]")).getText();
			
			
			Assert.assertEquals(OrderNumber, OrderNum);
			


		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
	
	@Parameters({ "url"})
	@Test(priority = 57, description = "Verify clicking on View full order history should show order report.", enabled = false)
	public void VerifyViewFullOrderHistory(String url) throws IOException, InterruptedException {
		
		System.out.println("Scenario 57 : Verify clicking on View full order history should show order report.");
		
		try {
			
			//((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			Thread.sleep(5000);
			driver.get(url);
			Thread.sleep(5000);

			hdr.getTrackBtn().click();
			Thread.sleep(5000);
			
			driver.findElement(By.linkText("Orders")).click();
			
			String title7 = driver.getTitle();
			String exp6 = "Orders - MarkITplace";
			Assert.assertEquals(title7, exp6);
			Thread.sleep(5000);
			
			wait1.until(ExpectedConditions.elementToBeClickable(OD.GetViewFullHistort()));
			OD.GetViewFullHistort().click();
			Thread.sleep(5000);
			
			String title8 = driver.getTitle();
			String exp7 = "Orders Report - MarkITplace";
			Assert.assertEquals(title8, exp7);
			
			


		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();

			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
		
		

	}
 @AfterSuite 
 public void quit() throws IOException, InterruptedException 
 {
 driver.quit(); 
 }
 
}
 
