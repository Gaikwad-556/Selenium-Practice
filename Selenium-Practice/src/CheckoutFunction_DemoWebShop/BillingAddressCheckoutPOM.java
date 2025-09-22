package CheckoutFunction_DemoWebShop;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BillingAddressCheckoutPOM {
	private WebDriver driver;

	public BillingAddressCheckoutPOM(WebDriver d) {
		super();
		this.driver = d;
		PageFactory.initElements(driver, this);
	}
	
//	locators
//	login
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement login;
	
	@FindBy(id = "Email")
	private WebElement loginEmail;
	
	@FindBy(id = "Password")
	private WebElement loginPassword;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;
	
	private By loginBooks = By.xpath("//a[@href='/books']");
	

	@FindBy(css = "input.product-box-add-to-cart-button")
	private List<WebElement> loginCartButtons;
	

	@FindBy(css = ".ajax-loading-block-window")
	private WebElement loginLoder;
	

	@FindBy(xpath = "//a[@href='/cart' and @class='ico-cart']")
	private WebElement loginShoppingCartLink;
	

	@FindBy(id = "termsofservice")
	private WebElement loginDialogBox;

	@FindBy(id = "checkout")
	private WebElement loginCheckoutButton;
	
	
	
//	Billing addresss locator
	@FindBy(id = "BillingNewAddress_FirstName")
	private WebElement firstNameField;
	
	@FindBy(id = "BillingNewAddress_LastName")
	private WebElement lastNameField;
	
	@FindBy(id = "BillingNewAddress_Email")
	private WebElement emailField;
	
	@FindBy(id = "BillingNewAddress_Company")
	private WebElement companyField;
	
	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement countryDropDown;
	
	@FindBy(id = "BillingNewAddress_City")
	private WebElement cityField;
	
	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement address1Field;
	
	@FindBy(id = "BillingNewAddress_Address2")
	private WebElement address2Field;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement zipCode;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneNumber;
	
	@FindBy(id = "BillingNewAddress_FaxNumber")
	private WebElement faxNumber;
	
	@FindBy(css = "#billing-buttons-container>input")
	private WebElement continueButton;
	
//	Assert loctors
	@FindBy(xpath = "//span[@data-valmsg-for='BillingNewAddress.FirstName']")
	private WebElement firstNameAssert;

//	user login
	public void login() {
		login.click();		
		loginEmail.sendKeys("gaik@gamil.com");
		loginPassword.sendKeys("Gaikwad@27");
		loginButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		bookClick();
	}
	
	private void bookClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement book = wait.until(ExpectedConditions.elementToBeClickable(loginBooks));
		book.click();
	}
	

//	cart button
	public void clickAddtoCartButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOf(loginCartButtons.get(0)));
		for (WebElement button : loginCartButtons) {
			wait.until(ExpectedConditions.invisibilityOf(loginLoder));
			button.click();
		}
	}
	

//	shopping cart link
	public void cartLinkClick() {
		Actions action = new Actions(driver);
		action.moveToElement(loginShoppingCartLink).click().perform();;
	}
	
	public void checkoutButtonClick() {
		loginDialogBox.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(loginCheckoutButton)).click();
	}
	
	
//	Billing Address interaction methods
	public void firstNameInteraction(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	
	public void lastNameInteraction(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void emailInteraction(String email) {
		emailField.sendKeys(email);
	}
	
	public void companyFieldInteraction(String company) {
		companyField.sendKeys(company);
	}
	
	public void countryDropDownInteraction(String countryName) {
		Select country = new Select(countryDropDown);
		country.selectByVisibleText(countryName);;
	}
	
	public void cityInteraction(String cityName) {
		cityField.sendKeys(cityName);
	}
	
	public void Address1Interaction(String addressOne) {
		address1Field.sendKeys(addressOne);
	}
	
	public void Address2Interaction(String addressTwo) {
		address2Field.sendKeys(addressTwo);
	}
	
	public void zipCodeInteraction(String zip) {
		zipCode.sendKeys(zip);
	}
	
	public void phoneNumberInteraction(String phone) {
		phoneNumber.sendKeys(phone);
	}
	
	public void faxNumberInteraction(String fax) {
		faxNumber.sendKeys(fax);
	}
	
	public void continueClick() {
		continueButton.click();
	}
	
	public void fieldClear() {
		firstNameField.clear();
		lastNameField.clear();
		emailField.clear();
		companyField.clear();
		cityField.clear();
		address1Field.clear();
		address2Field.clear();
		zipCode.clear();
		phoneNumber.clear();
		faxNumber.clear();
	}
	
	
//	Assert Check
	public void firstNameAssertCheck(String firstName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement first = wait.until(ExpectedConditions.visibilityOf(firstNameAssert));
		Assert.assertEquals(first.getText(), firstName);
	}
	
//	quite webdriver
	public void quite() {
		driver.quit();
	}
}
