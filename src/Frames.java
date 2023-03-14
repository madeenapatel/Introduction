import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\parag\\Downloads\\Softwares\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// maximize window
		driver.manage().window().maximize();

		//// Implicit wait as it waits for dynamically loaded Ajax elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://www.amazon.com");

	}

}
