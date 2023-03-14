import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Ecommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Set Chrome Web Driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\parag\\Downloads\\Softwares\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximize window
		driver.manage().window().maximize();

		// Implicit wait as it waits for dynamically loaded Ajax elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		

		// get URL
		driver.get("https://rahulshettyacademy.com/seleniumPractise");

		Thread.sleep(2000);  // wait for products to load

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Tomato" };
		addItems(driver, itemsNeeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		 //explicit wait
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
       
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
      
        Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(), "Code applied ..!");
        
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) throws InterruptedException

	{

		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++)

		{

			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName))

			{

				j++;
				// click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
				}

			}

		}

		// driver.close();

	}

}
