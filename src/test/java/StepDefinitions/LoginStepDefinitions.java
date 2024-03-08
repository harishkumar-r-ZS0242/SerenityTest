package StepDefinitions;

import Steps.LoginSteps;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;


public class LoginStepDefinitions {
@Steps
LoginSteps loginSteps ;
	@Given("User is on Home page")
	public void user_login( ){
		LoginSteps.login();
//		abcd
	}
}
