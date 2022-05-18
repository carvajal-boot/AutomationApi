package Runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/AutomationApi.feature",
        glue = "StepDefinitions",
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class AutomationApiRunner {
}
