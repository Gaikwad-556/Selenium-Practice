package CheckoutFunction_DemoWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class checkoutScript {
	WebDriver driver;
	checkoutPOM checkpom;

	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		checkpom = new checkoutPOM(driver);
		checkpom.login();
		checkpom.clickAddtoCartButton();
		checkpom.cartLinkClick();
		checkpom.checkoutButtonClick();
	}
}
