package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
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
import Shop_StandardsCatalog.StandardsCatalog;
import resources.base;

public class SmokeTestsSuite2 extends base {
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
	String mfg;
	String mfg1;
	public StandardsCatalog sc;
	String globalbundlename;

	////
	public SmokeTestsSuite2() throws IOException, InterruptedException {
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
		sc = new StandardsCatalog(driver);
		fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
	}

	@Parameters({ "username5", "pswd5", "url" })
	@Test(priority = 42, description = "Create Standard Bundle", enabled = true)
	public void Create_Standard_Catalog(String username1, String pswd1, String url)
			throws IOException, InterruptedException {
		try {
			
			System.out.println("Scenario 1 :Create_Standard_Catalog");

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

			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 100);

			driver.get(url);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
			lp.getusername().sendKeys(username1);
			lp.getpassword().sendKeys(pswd1);
			Thread.sleep(7000);
			lp.getloginbtn().click();
			Thread.sleep(7000);
			String TitleHome = driver.getTitle();

			hp.getsearchbox().clear();
			Thread.sleep(3000);
			hp.getsearchbox().sendKeys("HP laptop" + Keys.ENTER);
			Thread.sleep(10000);
			String title3 = driver.getTitle();
			System.out.println(title3);
			By pop1 = By.xpath("//div[@class='alert alert-info permission-boxalert alert-info permission-box']");
			Thread.sleep(7000);
			if (!title3.contentEquals("HP Laptop - MarkITplace")) {
				Assert.assertEquals(title3, "HP Laptop - MarkITplace");

			}

			if (CO.isElementPresent(pop1)) {

			} else if (title3.contentEquals("HP Laptop - MarkITplace"))

			{

				System.out.print("****");

				if (Srp.getAdd2Cart().isDisplayed()) {

					// Srp.getAdd2Cart().click();

					System.out.print("****####");

					String now = "(//a[@class='add_to_cart btn btn-primary'])[2]";

					By getnow1 = By.xpath(now);

					if (CO.isElementPresent(getnow1)) {
						Thread.sleep(4000);
						driver.findElement(getnow1).click();
						Thread.sleep(8000);
					}

					By continueshop = By.xpath(
							"//div[@class='sub-col-right cart-modal-btns']//a[contains(text(),'Continue Shopping')]");
					if (CO.isElementPresent(continueshop)) {
						CP.getcontshopping().click();

					}
					Thread.sleep(5000);
					String now1 = "(//a[@class='add_to_cart btn btn-primary'])[3]";

					By getnow2 = By.xpath(now1);

					if (CO.isElementPresent(getnow2)) {
						Thread.sleep(4000);
						driver.findElement(getnow2).click();
						Thread.sleep(10000);
					}

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

				Random rm = new Random();
				int i = rm.nextInt(1000) + 1;

				By createbundle = By.xpath(
						"//span[@class='pull-left']//a[@class='btn secondary'][contains(text(),'Create Standards Bundle')]");

				if (CO.isElementPresent(createbundle)) {
					CP.getcreatebundle().click();
					Thread.sleep(10000);

					globalbundlename = "StandrdCat" + i;
					CP.getbundlename().sendKeys(globalbundlename);
					Thread.sleep(5000);
					CP.getbundlecat().click();
					Thread.sleep(5000);
					WebElement options = driver.findElement(By.xpath(
							"//div[@class='predictive-quickfind-container active']//li[@class='ep-parent'][contains(text(),'Enterprise Desktops & Monitors')]"));

					options.click();
					Thread.sleep(10000);
					CP.getcreatestandardbundleorder().click();
					Thread.sleep(10000);
//					WebElement w = driver.findElement(By.id("loadingMask"));
//					wait.until(ExpectedConditions.invisibilityOf(w));

					WebElement options1 = driver.findElement(By.xpath(" //span[@class='alert-sc-title']"));
					Thread.sleep(5000);
					String text = options1.getText();
					System.out.println(text);
					Thread.sleep(10000);
					Assert.assertEquals(text, "Bundle created successfully. Thankyou!");

//					cf.logout();
				}
			}
		} catch (org.openqa.selenium.NoSuchElementException e) { //// System.out.println("Error message: " +
																	//// e.toString());
			System.out.println("catchcalled55");
			e.printStackTrace();
			driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.ElementClickInterceptedException e) { //// System.out.println("Error message: " +
																			//// e.toString());
			System.out.println("catchcalled56");
			e.printStackTrace();
			driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		} catch (org.openqa.selenium.TimeoutException e) { //// System.out.println("Error message: " + e.toString());
			System.out.println("catchcalled57");

			e.printStackTrace();
			driver.navigate().back();
			Thread.sleep(5000);
			Assert.assertTrue(false, "Failed" + e.getMessage());
		}
	}

	@Parameters({ "username5", "pswd5", "url" })
	@Test(priority = 43, description = "Edit Standard Bundle", enabled = true)
	public void Edit_Standard_Catalog(String username1, String pswd1, String url)
			throws IOException, InterruptedException {
		
		System.out.println("Scenario 2 :Edit_Standard_Catalog");

		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 100);

		driver.get(url);
		Thread.sleep(5000);
//		wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
//		lp.getusername().sendKeys(username1);
//		lp.getpassword().sendKeys(pswd1);
//		Thread.sleep(7000);
//		lp.getloginbtn().click();

		wait.until(ExpectedConditions.elementToBeClickable(hdr.getStanCatalogLink()));
		hdr.getStanCatalogLink().click();
		Thread.sleep(5000);
		Log.info("User has clicked on the Standard Catalog Navigation button from header");
		String title4 = driver.getTitle();
		Thread.sleep(5000);
		System.out.println(title4);
		String expectedTitle = "Standard Products - MarkITplace";

		System.out.println("done");

		Assert.assertEquals(title4, expectedTitle);
		Thread.sleep(5000);
		sc = new Shop_StandardsCatalog.StandardsCatalog(driver);
		Thread.sleep(5000);
		sc.getcatarrow().click();
		System.out.println("done1");
		Thread.sleep(5000);
		sc.getcatselect().click();
		System.out.println("done2");
		Thread.sleep(5000);

		Iterator();

		//System.out.println("done1");

		Thread.sleep(5000);

		CP.getbundleEdit().click();
		Thread.sleep(10000);
		CP.getbundleOptional().click();

		Thread.sleep(7000);
		WebElement bundlesoptionaltem1 = driver
				.findElement(By.xpath("//div[@class='cart-items']//div[@class='cart-item-col-item']//span[1]"));

		mfg = bundlesoptionaltem1.getText();
		System.out.print(mfg);

		Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		js1.executeScript("window.scrollBy(0,250)");
		Actions action = new Actions(driver);

		System.out.println("done2");

		CP.getbundleOQty().sendKeys(Keys.CONTROL, "a");
		Thread.sleep(3000);
		CP.getbundleOQty().sendKeys(Keys.DELETE);

		Thread.sleep(10000);
		CP.getbundleOQty1().sendKeys("2");
		Thread.sleep(10000);
		CP.getbundlesave().click();

		Thread.sleep(10000);
		String a = "//div[@class='collapsible-section-content no-padding']//span[contains(text(),'" + mfg + "')]";

		By bundlesoptionaltem = By.xpath(a);

		if (CO.isElementPresent(bundlesoptionaltem))
			
		{
			WebElement bundlesoptionaltem2 = driver.findElement(By.xpath(a));
			System.out.print(bundlesoptionaltem2.getText());
			Thread.sleep(10000);

			Assert.assertEquals(bundlesoptionaltem2.getText(), mfg);

		}
		Thread.sleep(10000);

		WebElement bundleQTY = driver.findElement(By.xpath("(//div[@class='qty']//span)[1]"));

		Thread.sleep(5000);
		String bq = bundleQTY.getText();
		Thread.sleep(5000);

		if (bq.contentEquals("2")) {
			Thread.sleep(5000);

			Assert.assertEquals("2", bq);
		}

	}

	@Parameters({ "username5", "pswd5", "url" })
	@Test(priority = 43, description = "Edit Standard Bundle", enabled = false)
	public void Edit_Standard_Catalog2(String username1, String pswd1, String url)
			throws IOException, InterruptedException {
		
		System.out.println("Scenario 3 :Edit_Standard_Catalog2");

		sc = new StandardsCatalog(driver);

		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 100);

		driver.get(url);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
		lp.getusername().sendKeys(username1);
		lp.getpassword().sendKeys(pswd1);
		Thread.sleep(7000);
		lp.getloginbtn().click();

		hdr.getStanCatalogLink().click();
		Thread.sleep(5000);
		Log.info("User has clicked on the Standard Catalog Navigation button from header");
		String title4 = driver.getTitle();
		Thread.sleep(5000);
		System.out.println(title4);
		String expectedTitle = "Standard Products - MarkITplace";

		System.out.println("done");

		// sc = new Shop_StandardsCatalog.StandardsCatalog(driver);
		Thread.sleep(20000);
		sc.getLeftPaneEnterpriseselect().click();
		Thread.sleep(20000);
		sc.getLeftpaneEnterpriseDesktopAndMonitorselect().click();

	}

	@Parameters({ "username5", "pswd5", "url" })
	@Test(priority = 44, description = "Add_Standard_Bundles_In_Category", enabled = false)
	public void Add_Standard_Bundles_In_Category(String username1, String pswd1, String url)
			throws IOException, InterruptedException {
		
		System.out.println("Scenario 1 :Add Standard Bundles In Category");

		Thread.sleep(5000);
		// WebDriverWait wait = new WebDriverWait(driver, 100);

		hdr.getStanCatalogLink().click();
		Thread.sleep(5000);

		String title4 = driver.getTitle();
		Thread.sleep(5000);
		String expectedTitle = "Standard Products - MarkITplace";

		Assert.assertEquals(title4, expectedTitle);
		Thread.sleep(5000);
		sc = new Shop_StandardsCatalog.StandardsCatalog(driver);
		Thread.sleep(5000);
		sc.getcatarrow().click();
		Thread.sleep(5000);
		sc.getcatselect().click();
		Thread.sleep(5000);

		Iterator();
		Thread.sleep(10000);

		CP.getstandlink().click();
		Thread.sleep(7000);
		CP.getstancategory().click();
		Thread.sleep(7000);
		CP.getcategorymodal().click();
		Thread.sleep(7000);
		CP.getcategorymodalsave().click();
		Thread.sleep(7000);
		CP.getcategorymodalsaveclose().click();
		///

		Thread.sleep(7000);

	}

	@Parameters({ "username5", "pswd5", "url" })
	@Test(priority = 45, description = "Edit Standard Bundle", enabled = false)
	public void Email_standard_bundles(String username1, String pswd1, String url)
			throws IOException, InterruptedException {

		Thread.sleep(5000);
		Actions ab = new Actions(driver);
		Thread.sleep(5000);
		ab.click(driver.findElement(By.xpath("//a[@class='action-icon icon-mail']"))).release().perform();

		Thread.sleep(5000);

		WebElement download = driver.findElement(By.xpath("//div[@class='modal-mask']"));
		Thread.sleep(5000);
		WebElement temp = download
				.findElement(By.xpath("//div[@class='modal-content']//input[@name='email_addresses']"));
		Thread.sleep(5000);

		Thread.sleep(10000);
		temp.sendKeys("ffhhffh@k.com");

		Thread.sleep(8000);
		WebElement temp1 = download
				.findElement(By.xpath("//div[@class='modal-content']//button[@class='btn btn-primary']"));
		temp1.click();
		Thread.sleep(5000);

	}

	@Parameters({ "username5", "pswd5", "url" })
	@Test(priority = 46, description = "Add_items_from_cart_in_standard_bundle", enabled = false)
	public void Add_items_from_cart_in_standard_bundle(String username1, String pswd1, String url)
			throws IOException, InterruptedException {
		try {

			hp.getsearchbox().clear();
			Thread.sleep(3000);

			hp.getsearchbox().sendKeys("HP laptop" + Keys.ENTER);
			Thread.sleep(10000);
			String title3 = driver.getTitle();
			By pop1 = By.xpath("//div[@class='alert alert-info permission-boxalert alert-info permission-box']");
			Thread.sleep(7000);
			if (!title3.contentEquals("HP Laptop - MarkITplace")) {
				Assert.assertEquals(title3, "HP Laptop - MarkITplace");

				Thread.sleep(5000);

			}

			if (CO.isElementPresent(pop1)) {

			} else if (title3.contentEquals("HP Laptop - MarkITplace"))

			{

				SearchResultPage Srp = new SearchResultPage(driver);
				WebDriverWait wait1 = new WebDriverWait(driver, 50);
				Thread.sleep(5000);
				wait1.until(ExpectedConditions.visibilityOf(Srp.getProduct5Cart()));
				Srp.getProduct5Cart().click();
				Thread.sleep(5000);

				WebElement partfromcart = driver.findElement(By.xpath(
						"//div[@class='list-item-left']//span[@class='part-number'][contains(text(),'Mfg. Part #: 7KK13UT#ABA')]"));
				Thread.sleep(5000);
				mfg1 = partfromcart.getText();
				Thread.sleep(5000);
				System.out.print(mfg1);

				Thread.sleep(10000);
				Srp.getCloseIcon().click();

				Thread.sleep(5000);

				hdr.getStanCatalogLink().click();
				Thread.sleep(5000);
				Log.info("User has clicked on the Standard Catalog Navigation button from header");
				String title4 = driver.getTitle();
				Thread.sleep(5000);
				String expectedTitle = "Standard Products - MarkITplace";

				Assert.assertEquals(title4, expectedTitle);
				Thread.sleep(5000);
				sc = new Shop_StandardsCatalog.StandardsCatalog(driver);
				Thread.sleep(10000);
				sc.getcatarrow().click();
				Thread.sleep(10000);
				sc.getcatselect().click();
				Thread.sleep(5000);

				Thread.sleep(5000);
				Iterator();
				Thread.sleep(5000);

				Thread.sleep(5000);
				CP.getbundleEdit().click();
				Thread.sleep(5000);
				CP.getaddfromcart().click();
				Thread.sleep(5000);
				CP.getaddfromcartbuttonmodal().click();
				Thread.sleep(5000);

				System.out.print("sfdfd");

				WebElement partfromcartexp = driver.findElement(By.xpath("(//span[@class='part-number'])[1]"));
				Thread.sleep(5000);
				String mfg2 = partfromcartexp.getText();
				System.out.print(mfg2);
				Thread.sleep(5000);

				Thread.sleep(5000);

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

	@Parameters({ "username5", "pswd5", "url" })
	@Test(priority = 47, description = "Add_items_from_cart_in_standard_bundle", enabled = false)
	public void Create_Your_Own_Standards_Bundle_Heading(String username1, String pswd1, String url)
			throws IOException, InterruptedException {

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,250)");
		Thread.sleep(5000);
		WebElement bundle = driver.findElement(By.xpath("//h3[contains(text(),'Create your own Standards Bundle')]"));
		Thread.sleep(5000);
		String bundle3 = bundle.getText();
		Thread.sleep(5000);
		System.out.print(bundle3);
		Assert.assertEquals(bundle3, "Create your own Standards Bundle");
	}

	@Parameters({ "username5", "pswd5", "url" })
	@Test(priority = 48, description = "Mapped_Standard_Bundle_Category_Listing_Page", enabled = false)
	public void Mapped_Standard_bundle_in_category_listing_page(String username1, String pswd1, String url)
			throws IOException, InterruptedException {

		hdr.getStanCatalogLink().click();
		Thread.sleep(5000);
		Log.info("User has clicked on the Standard Catalog Navigation button from header");
		String title4 = driver.getTitle();
		Thread.sleep(5000);
		String expectedTitle = "Standard Products - MarkITplace";
		Assert.assertEquals(title4, expectedTitle);
		Thread.sleep(5000);
		sc = new Shop_StandardsCatalog.StandardsCatalog(driver);
		Thread.sleep(10000);
		sc.getcatarrow().click();
		Thread.sleep(10000);
		sc.getcatselect().click();
		Thread.sleep(5000);

		Iterator();

		CP.getstandlink().click();
		Thread.sleep(7000);
		CP.getstancategory().click();
		Thread.sleep(7000);
		CP.getcategorymodal1().click();
		Thread.sleep(7000);
		CP.getcategorymodalsave().click();
		Thread.sleep(7000);
		CP.getcategorymodalsaveclose().click();

		hdr.getStanCatalogLink().click();
		Thread.sleep(5000);
		Log.info("User has clicked on the Standard Catalog Navigation button from header");
		String title41 = driver.getTitle();
		Thread.sleep(5000);
		String expectedTitle1 = "Standard Products - MarkITplace";
		Assert.assertEquals(title41, expectedTitle1);
		Thread.sleep(5000);
		sc = new Shop_StandardsCatalog.StandardsCatalog(driver);
		Thread.sleep(5000);
		sc.getcatarrow().click();
		Thread.sleep(10000);
		sc.getcatselect1().click();
		Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		WebElement element112 = driver.findElement(By.xpath("//button[@id='load-more-link']"));
		By loadmore = By.xpath("//button[@id='load-more-link']");
		Thread.sleep(5000);
		while (CO.isElementPresent(loadmore)) {
			Thread.sleep(10000);

			try {
				element112.click();
			} catch (org.openqa.selenium.ElementNotInteractableException e) {
				break;
			}

			Thread.sleep(10000);

		}
		Thread.sleep(30000);

		String path11 = "(//div[@class='product-list-grid clearfix grid standards print-standards']//div[@class='product-grid-item bundleitems'])";
		By kk = By.xpath(path11);
		System.out.println(kk);
		String a = "//h2[contains(text(),'" + globalbundlename + "')]";

		By kk1 = By.xpath(a);
		System.out.println(kk1);
		List<WebElement> webElementList = driver.findElements(kk);
		for (WebElement element4 : webElementList) {

			String jjjn = element4.findElement(kk1).getText();
			if (jjjn.contentEquals(globalbundlename)) {
				System.out.println("hi sima appear" + jjjn);
				break;
			}

		}

	}

	public void Iterator() throws IOException, InterruptedException {

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);

		By loadmore = By.xpath("//button[@id='load-more-link']");
		Thread.sleep(5000);

		while (CO.isElementPresent(loadmore)) {
			Thread.sleep(10000);

			try {
				WebElement element112 = driver.findElement(By.xpath("//button[@id='load-more-link']"));
				element112.click();
			} catch (org.openqa.selenium.ElementNotInteractableException e) {
				break;
			}

			Thread.sleep(10000);

		}
		Thread.sleep(30000);

		/// globalbundlename="saimabundle190";

		// String path11="(//div[@class='product-list-grid clearfix grid standards
		// print-standards']//div[@class='product-grid-item bundleitems'])";
		// By kk=By.xpath(path11);
		// System.out.println(kk);
		String a = "//h2[contains(text(),'" + globalbundlename + "')]";

		By kk1 = By.xpath(a);
		System.out.println(kk1);
		// List<WebElement> webElementList = driver.findElements(kk);
		// for (WebElement element4: webElementList){

		String jjjn = driver.findElement(kk1).getText();
		if (jjjn.contentEquals(globalbundlename)) {
			System.out.println("hi sima appear" + jjjn);
			driver.findElement(kk1).click();
		}
		// break; }

		// }

	}

	/*
	 * @AfterSuite public void quit() throws IOException, InterruptedException {
	 * driver.quit();
	 * 
	 * }
	 */
}
