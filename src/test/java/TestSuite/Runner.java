package TestSuite;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
//include tags configs
@RunWith(CucumberWithSerenity.class)
	@CucumberOptions(

			   features = {"src/test/resources/Feature/Test.feature"},
		        glue = "StepDefinitions",
//		        name = Sanity;
		        plugin = {"pretty"}
			    )

public class Runner {

	}
