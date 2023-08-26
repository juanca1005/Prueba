package co.com.opitech.certification.stepdefinitions;



import co.com.opitech.certification.models.User;
import co.com.opitech.certification.questions.MensajeAlert;
import co.com.opitech.certification.questions.NameBook;
import co.com.opitech.certification.questions.TheUserName;
import co.com.opitech.certification.tasks.AbrirNavegador;
import co.com.opitech.certification.tasks.AgregarLibro;
import co.com.opitech.certification.tasks.IrAlaOpcion;
import co.com.opitech.certification.tasks.Loguearse;
import co.com.opitech.certification.tasks.EliminarLibro;
import co.com.opitech.certification.tasks.CerrarSesion;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.core.annotations.events.AfterScenario;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;


import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class ModuloBookStepDefinition {

    public final String URL = "https://demoqa.com/books";

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario se logue en la pagina")
    public void queElUsuarioSeLogueEnLaPagina(DataTable dataTable) {
        List<String> usuario = dataTable.row(0);
        theActorCalled("juan carlos").attemptsTo(AbrirNavegador.conUrl(URL));
        OnStage.theActorInTheSpotlight().attemptsTo(Loguearse.con(new User(usuario.get(0).trim(),usuario.get(1).trim())));
    }
    @Cuando("el usuario agregue un libro con nombre {string}")
    public void elUsuarioAgregueUnLibroConNombre(String string) {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarLibro.conNombre(string));


    }
    @Entonces("se validara que se muestre el siguiente mensaje {string}")
    public void seValidaraQueSeMuestreElSiguienteMensaje(String mensaje) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(MensajeAlert.is(), Matchers.is(mensaje)));
    }

    @Cuando("el usuario ingrese a la opcion profile")
    public void elUsuarioIngreseALaOpcionProfile() {
        OnStage.theActorInTheSpotlight().attemptsTo(IrAlaOpcion.profile());
    }
    @Entonces("se validara que el libro {string} se agrego a la coleccion")
    public void seValidaraQueElLibroSeAgregoALaColeccion(String nameBook) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat("Se verifica si el nombre del libreo esta en la lista "+ nameBook+": ", NameBook.is(nameBook), Matchers.is(true)));
    }
    @Entonces("se valida que el nombre del usuario sea {string}")
    public void seValidaQueElNombreDelUsuarioSea(String nameUser) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheUserName.is(), Matchers.is(nameUser)));
    }

    @Cuando("el usuario elimine un libro con nombre {string}")
    public void elUsuarioElimineUnLibroConNombre(String nombreBook) {
        OnStage.theActorInTheSpotlight().attemptsTo(EliminarLibro.conNombre(nombreBook));
    }
    @Entonces("se validar que se muestre mensaje {string} que confirma el borrado")
    public void seValidarQueSeMuestreMensajeQueConfirmaElBorrado(String mensaje) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(MensajeAlert.is(), Matchers.is(mensaje)));
    }
    @Entonces("se debe confirmar que el libro {string} no se muestre en la tabla coleccion")
    public void seDebeConfirmarQueElLibroNoSeMuestreEnLaTablaColeccion(String nameBook) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat("Se verifica si el nombre del libreo esta en la lista "+ nameBook+": ", NameBook.is(nameBook), Matchers.is(false)));

    }

}