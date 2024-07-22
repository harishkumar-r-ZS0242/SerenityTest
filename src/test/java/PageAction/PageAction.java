package PageAction;
import org.openqa.selenium.By;

import JavaScriptHelper.WaitPage;
import ObjectRepository.LocatorRepo;
import Utilities.AppConfigPropertiesLoader;
import net.thucydides.core.pages.PageObject;

public class PageAction extends PageObject{
	WaitPage waitPage;
	public  void launchApplication() {
		waitPage.forcibleWait(3000);	
		getDriver().get(AppConfigPropertiesLoader.getInstance().applicationURL);
	}
	//add id method
	public void enterUserName(String value) {
		element(LocatorRepo.TXT_Id_Username).sendKeys(value);
	}
	
	public void enterPassword(String value) {
		element(LocatorRepo.TXT_Id_Password).sendKeys(value);
	}
	
	public void clickButton(String button,String elementName) {
		element(By.xpath(String.format(button, elementName))).click();
	}
	
	public String getText(String elementName) {
		waitPage.forcibleWait(2000);
		return element(By.xpath(String.format(LocatorRepo.TXT_title, elementName))).getText();
	}
}
