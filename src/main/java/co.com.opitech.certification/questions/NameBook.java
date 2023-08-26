package co.com.opitech.certification.questions;

import co.com.opitech.certification.userinterface.ProfilePageUI;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class NameBook  implements Question<Boolean> {

    private String nombreLibro;

    public NameBook(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public static Question<Boolean> is(String nombreLibro) {
        return new NameBook(nombreLibro);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ListOfWebElementFacades listBooks = ProfilePageUI.LIST_SPAN_BOOKS.resolveAllFor(actor);
        for (WebElementFacade book : listBooks) {
            if (book.getText().toLowerCase().contains(nombreLibro.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
