import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
	@CucumberOptions(

			   features = {"src/test/resources/Feature/Test.feature"},
		        glue = "StepDefinitions",
		        plugin = {"pretty"}
			    )

public class Runner {

	}
