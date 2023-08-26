package co.com.opitech.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MensajeAlert implements Question<String> {
    public static Question<String> is() {
        return new MensajeAlert();
    }

    @Override
    public String answeredBy(Actor actor) {
        String mensaje =BrowseTheWeb.as(actor).getAlert().getText();
        BrowseTheWeb.as(actor).getAlert().accept();
        System.out.println("el mensajee es"+mensaje);
        return mensaje;
    }
}
