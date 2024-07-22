package JavaScriptHelper;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;

public class WaitPage extends PageObject{

	public WaitPage(WebDriver driver) {
		super(driver);
	}

	public void forcibleWait(int duration){
		try{
			
			waitABit(duration);
		} catch(RuntimeException re){
			re.printStackTrace();
			waitABit(duration);
		}
	}
}
