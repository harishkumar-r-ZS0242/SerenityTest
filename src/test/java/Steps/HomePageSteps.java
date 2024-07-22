package Steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import JavaScriptHelper.WaitPage;
import ObjectRepository.LocatorRepo;
import PageAction.PageAction;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.steps.ScenarioSteps;
import net.serenitybdd.annotations.Step;

public class HomePageSteps extends ScenarioSteps{

	PageAction pageAction;
	WaitPage waitPage;
	private static final long serialVersionUID = 1L;
	@Step
	public  void launchApplication() {
		pageAction.launchApplication();
	}
	
	@Step
	public void enterLoginCredentials(DataTable credentials) {
		waitPage.forcibleWait(2000);
		getDriver().manage().window().maximize();
		List<Map<String, String>>  creds = credentials.asMaps();
		pageAction.enterUserName( creds.get(0).get("username"));
		pageAction.enterPassword(creds.get(0).get("password"));
	}
	
	@Step
	public void clickSubmit() {
		pageAction.clickButton(LocatorRepo.BTN_Field,"submit");
	}
	
	@Step
	public void verifyTitle(DataTable title) {
		List<Map<String, String>>  titlePage = title.asMaps();
		Assert.assertEquals("Title is not matching",titlePage.get(0).get("title") , pageAction.getText(titlePage.get(0).get("title")));
	}
	
	@Step
	public void clickButton(String button) {
		pageAction.clickButton(LocatorRepo.BTN_Navigate,button);
	}
}
