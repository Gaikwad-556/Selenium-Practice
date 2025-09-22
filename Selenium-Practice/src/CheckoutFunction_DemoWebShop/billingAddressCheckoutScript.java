package CheckoutFunction_DemoWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class billingAddressCheckoutScript {
	WebDriver driver;
	BillingAddressCheckoutPOM checkpom;

	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		checkpom = new BillingAddressCheckoutPOM(driver);
		checkpom.login();
		checkpom.clickAddtoCartButton();
		checkpom.cartLinkClick();
		checkpom.checkoutButtonClick();
	}
	
	@BeforeMethod
	public void fieldClear() {
		checkpom.fieldClear();
	}
	
	@Test
	public void firstNameEmpty() {
//		field values
		String firstName = "";
		String lastName = "ssg";
		String email = "gaik@gamil.com";
		String company = "";
		String countryValue = "India";
		String city = "Mumbai";
		String address1 = "Navi Mumbai";
		String address2 = "";
		String zipCode = "215200";
		String phone = "7458932105";
		String fax = "";
//	Assert value
		String firstNameAssertCheck = "First name is required.";
//		Interaction
		checkpom.firstNameInteraction(firstName);
		checkpom.lastNameInteraction(lastName);
		checkpom.emailInteraction(email);
		checkpom.companyFieldInteraction(company);
		checkpom.countryDropDownInteraction(countryValue);
		checkpom.cityInteraction(city);
		checkpom.Address1Interaction(address1);
		checkpom.Address2Interaction(address2);
		checkpom.zipCodeInteraction(zipCode);
		checkpom.phoneNumberInteraction(phone);
		checkpom.faxNumberInteraction(fax);
//		button click
		checkpom.continueClick();
//		assert check
		checkpom.firstNameAssertCheck(firstNameAssertCheck);
	}
	
	@AfterTest
	public void close() {
		checkpom.quite();
	}
}
