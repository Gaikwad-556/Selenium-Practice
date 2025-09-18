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
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkoutPOM {
	private WebDriver driver;

	public checkoutPOM(WebDriver d) {
		super();
		this.driver = d;
		PageFactory.initElements(driver, this);
	}
	
//	locators
//	login
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement login;
	
	@FindBy(id = "Email")
	private WebElement email;
	
	@FindBy(id = "Password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;
	
	private By books = By.xpath("//a[@href='/books']");
	

	@FindBy(css = "input.product-box-add-to-cart-button")
	private List<WebElement> cartButtons;
	

	@FindBy(css = ".ajax-loading-block-window")
	private WebElement loder;
	

	@FindBy(xpath = "//a[@href='/cart' and @class='ico-cart']")
	private WebElement shoppingCartLink;
	

	@FindBy(id = "termsofservice")
	private WebElement dialogBox;

	@FindBy(id = "checkout")
	private WebElement checkoutButton;

//	user login
	public void login() {
		login.click();		
		email.sendKeys("gaik@gamil.com");
		password.sendKeys("Gaikwad@27");
		loginButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		bookClick();
	}
	
	private void bookClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement book = wait.until(ExpectedConditions.elementToBeClickable(books));
		book.click();
	}
	

//	cart button
	public void clickAddtoCartButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOf(cartButtons.get(0)));
		for (WebElement button : cartButtons) {
			wait.until(ExpectedConditions.invisibilityOf(loder));
			button.click();
		}
	}
	

//	shopping cart link
	public void cartLinkClick() {
		Actions action = new Actions(driver);
		action.moveToElement(shoppingCartLink).click().perform();;
	}
	
	public void checkoutButtonClick() {
		dialogBox.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(checkoutButton)).click();
	}
	
}
