import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "Madeena";
		// Set Chrome Web Driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\parag\\Downloads\\Softwares\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// maximize window
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		System.out.print(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("confirmbtn")).click();
		System.out.print(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

	}

}
