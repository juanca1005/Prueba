package co.com.opitech.certification.tasks;

import co.com.opitech.certification.exceptions.LibroConsultadoNoExiste;
import co.com.opitech.certification.interactions.SeleccionarLibro;
import co.com.opitech.certification.userinterface.BookStorePageUI;
import co.com.opitech.certification.userinterface.ProfilePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class AgregarLibro implements Task {

    private String nombreLibro;

    public AgregarLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public static AgregarLibro conNombre(String  nombreLibro) {
        return Tasks.instrumented(AgregarLibro.class, nombreLibro);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(nombreLibro).into(BookStorePageUI.INPUT_SEARCH_BOX));
        actor.attemptsTo(SeleccionarLibro.conNombre(nombreLibro, BookStorePageUI.LIST_SPAN_BOOKS));
        actor.attemptsTo(Scroll.to(BookStorePageUI.BTN_ADD_TO_YOU_COLLECTION).andAlignToTop());
        actor.attemptsTo(Click.on(BookStorePageUI.BTN_ADD_TO_YOU_COLLECTION));
    }
}
