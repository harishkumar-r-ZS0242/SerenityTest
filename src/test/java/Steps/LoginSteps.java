package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.serenitybdd.annotations.Step;
import net.thucydides.core.webdriver.WebdriverManager;

public class LoginSteps {
	
	@Step
	public static void login() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\harishkumar.r\\eclipse-workspace\\SerenityExtentReport\\SerenityReport\\src\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.toolsqa.com/selenium-training/");
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
	}
}
