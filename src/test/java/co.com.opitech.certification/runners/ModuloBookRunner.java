package co.com.opitech.certification.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/modulo_book.feature",
        glue = {"co.com.opitech.certification.stepdefinitions"},
       // tags = "@prueba",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class ModuloBookRunner {

}
