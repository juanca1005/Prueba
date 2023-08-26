package co.com.opitech.certification.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProfilePageUI {
    public static final Target OPCION_PROFILE = Target.the("Opción profile").locatedBy("//*[@id='item-3']/span[contains(text(),'Profile')]");

    public static final Target LIST_SPAN_BOOKS = Target.the("Resultado de búsqueda de Libros").locatedBy("//span[starts-with(@id,'see-book')]/a");

    public static final Target DELETE_BOOK = Target.the("Boton Eliminar").locatedBy("//span[contains(@id,'{0}')]/ancestor::div[4]//span[@id='delete-record-undefined']");

    public static final Target BTN_MODAL_OK = Target.the("Botón modal OK").located(By.id("closeSmallModal-ok"));

}
