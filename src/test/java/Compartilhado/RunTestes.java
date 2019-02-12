package Compartilhado;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "com.cucumber.StepDefinitions",
        plugin = { 
                    "pretty",
                    "html:target/cucumber",
                } 
	    )
public class RunTestes {

}
