package StepDefinitions;

import Steps.HomePageSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class LoginStepDefinitions {
	@Steps
	HomePageSteps homePageSteps;

	@Given("Launch the Application")
	public void login_to_the_application() {
		homePageSteps.launchApplication();
	}

	@Given("Enter User credentials")
	public void enter_user_credentials(DataTable credentials) {
		homePageSteps.enterLoginCredentials(credentials);
	}
	@Given("Click Submit Button")
	public void Click_login_button(){
		homePageSteps.clickSubmit();
	}
	@Then("Verify page title")
	public void verify_page_title(DataTable title) {
		homePageSteps.verifyTitle(title);
	}
	
	@Given("Click {string} tab")
	public void click_tab(String tab) {
		homePageSteps.clickButton(tab);
	}
}
