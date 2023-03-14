import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSwitching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Set Chrome Web Driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\parag\\Downloads\\Softwares\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// maximize window
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
	    Set <String> windows = driver.getWindowHandles(); // [parentid,childid,subchildId]
	    Iterator <String> it = windows.iterator();
	    String parentId = it.next();
	    String childId =it.next();
	    driver.switchTo().window(childId);
	    driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
	    String emailId = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].split(" ")[0];
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailId);



	}

}
