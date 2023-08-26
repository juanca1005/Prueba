package co.com.opitech.certification.tasks;

import co.com.opitech.certification.userinterface.ProfilePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilAngularIsReady;
import net.serenitybdd.screenplay.waits.WaitUntilTargetIsReady;

public class EliminarLibro implements Task {


    private String nombreBook;

    public EliminarLibro(String nombreBook) {
        this.nombreBook = nombreBook;
    }

    public static EliminarLibro conNombre(String nombreBook) {
        return Tasks.instrumented(EliminarLibro.class, nombreBook);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.angularRequestsHaveFinished());
        actor.attemptsTo(WaitUntil.the(ProfilePageUI.OPCION_PROFILE, WebElementStateMatchers.isPresent()).forNoMoreThan(10).seconds());
        actor.attemptsTo(Scroll.to(ProfilePageUI.OPCION_PROFILE).andAlignToTop());
        actor.attemptsTo(Click.on(ProfilePageUI.OPCION_PROFILE));
        actor.attemptsTo(WaitUntil.angularRequestsHaveFinished());
        actor.attemptsTo(Click.on(ProfilePageUI.DELETE_BOOK.of(nombreBook)));
        actor.attemptsTo(Click.on(ProfilePageUI.BTN_MODAL_OK));
        //actor.attemptsTo(WaitUntil.the(ProfilePageUI.BTN_MODAL_OK, WebElementStateMatchers.no()).forNoMoreThan(10).seconds());
        //actor.attemptsTo(WaitUntil.angularRequestsHaveFinished());
    }
}
