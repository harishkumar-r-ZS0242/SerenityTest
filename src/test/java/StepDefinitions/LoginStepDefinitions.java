package StepDefinitions;

import Steps.LoginSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class LoginStepDefinitions {
	@Steps
	LoginSteps loginSteps;

	@Given("Login to the Application")
	public void login_to_the_application() {
		loginSteps.login();
	}

	@Given("Open the Application in chrome")
	public void open_the_application_in_chrome() {
	}

	@Given("Enter login credentials")
	public void enter_login_credentials() {
	}

	@Given("Click Login button")
	public void click_login_button() {
	}

	@Then("Verify the user is logged in")
	public void verify_the_user_is_logged_in() {
	}

}
