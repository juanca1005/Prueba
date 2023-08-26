package co.com.opitech.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class AbrirNavegador implements Task {

    public String url;

    public AbrirNavegador(String url) {
        this.url = url;
    }

    @Override
    @Step("{0} Abrir url")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static AbrirNavegador conUrl(String url){
        return Tasks.instrumented(AbrirNavegador.class, url);
    }

}
