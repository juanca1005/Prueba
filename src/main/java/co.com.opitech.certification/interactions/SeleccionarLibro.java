package co.com.opitech.certification.interactions;

import co.com.opitech.certification.exceptions.LibroConsultadoNoExiste;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;

public class SeleccionarLibro implements Interaction {

    private String nombreLibro;
    private Target listSpanBooks;

    public SeleccionarLibro(String nombreLibro, Target listSpanBooks) {
        this.nombreLibro = nombreLibro;
        this.listSpanBooks = listSpanBooks;
    }


    public static SeleccionarLibro conNombre(String nombreLibro, Target listSpanBooks) throws LibroConsultadoNoExiste {
        return Tasks.instrumented(SeleccionarLibro.class, nombreLibro, listSpanBooks);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        boolean encontrado = false;
        ListOfWebElementFacades listBooks =listSpanBooks.resolveAllFor(actor);
        if(listBooks.isEmpty()){
            throw  new LibroConsultadoNoExiste(nombreLibro);
        }
        System.out.println("Inicia el procedimiento robo");

        for (WebElementFacade book:listBooks) {
            if(book.getText().toLowerCase().contains(nombreLibro.toLowerCase())){
                book.click();
                encontrado = true;
            }
        }
        if (!encontrado){

            throw  new LibroConsultadoNoExiste(nombreLibro);
        }
    }


}
