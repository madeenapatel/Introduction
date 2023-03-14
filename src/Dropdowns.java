import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdowns {

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

		// get URL
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Static dropdown
		WebElement statDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(statDropdown);

		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());

		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		// static looping dropdown
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// dynamic dropdowns
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		// Autosuggestive dropdowns
		driver.findElement(By.id("autosuggest")).sendKeys("IND");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("li [class='ui-menu-item'] a"));

		for (WebElement option : options) {

			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}

		}

		// Find no of checkboxes on the page
		System.out.println(driver.findElements(By.cssSelector("input[type ='checkbox']")).size());

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		// Assert.assertFalse(true);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		driver.close();

	}
}
