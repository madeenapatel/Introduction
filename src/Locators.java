import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Set Chrome Web Driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\parag\\Downloads\\Softwares\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximize window
		driver.manage().window().maximize();

		// Implicit wait as it waits for dynamically loaded Ajax elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String username = "rahul";
		String password = "hello123";
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		// Try login without entering details
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("p.error")).getText(),
				"* Incorrect username or password");

		// Login with incorrect credentials with basic locators
		driver.findElement(By.id("inputUsername")).sendKeys(username);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.className("signInBtn")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("p.error")).getText(),
				"* Incorrect username or password");

		// Forgot password
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).sendKeys(username);
		driver.findElement(By.cssSelector("input[placeholder=\"Email\"]")).sendKeys("incorrect@gmail.com");
		driver.findElement(By.xpath(" //input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);

		// login with correct credentials and different types of locators
		String tempPassword = getPassword(driver);
		driver.findElement(By.xpath("//button[@class ='go-to-login-btn']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(username);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(tempPassword);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='rmbrUsername']")).click();
		driver.findElement(By.xpath("//span/input[@value='agreeTerms']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

		// Verify login success
		Thread.sleep(2000); // wait until message appears
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + username + ",");

		// Logout
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();

		// Navigate to another URL
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice");

		// Parent to Child Locator
		System.out.println(
				driver.findElement(By.xpath("//header/div//button[1]/following-sibling :: button[1]")).getText());

		// Child to Parent Locator
		System.out.println(driver.findElement(By.xpath("//header/div//button[1]/parent::div/button[2]")).getText());

		// navigation practice
		driver.navigate().back();
		driver.navigate().forward();

		// close the browser
		driver.close();

	}

	public static String getPassword(WebDriver driver) throws InterruptedException {

		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText(); // Please use temporary password
																						// 'rahulshettyacademy' to
																						// Login.
		String[] passwordArray = passwordText.split("'");
		String tempPassword = passwordArray[1].split("'")[0];
		return tempPassword;

	}

}
