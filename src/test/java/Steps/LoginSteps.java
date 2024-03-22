package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import net.thucydides.core.steps.ScenarioSteps;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.webdriver.WebdriverManager;
import utility.PageAction;

public class LoginSteps extends ScenarioSteps{

	PageAction pageAction;
	private static final long serialVersionUID = 1L;
	@Step
	public  void login() {
		getDriver().get("https://www.toolsqa.com/selenium-training/");
		getDriver().findElement(By.xpath("//a[contains(text(),'Home')]")).click();
	}
}
