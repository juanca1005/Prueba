package co.com.opitech.certification.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BookStorePageUI {
    public static final Target INPUT_SEARCH_BOX = Target.the("Input search box").located(By.id("searchBox"));
    public static final Target BTN_ADD_TO_YOU_COLLECTION = Target.the("Botón anadir a tu colección").locatedBy("//button[@id='addNewRecordButton' and contains(text(), 'Add')]");
    public static final Target LIST_SPAN_BOOKS = Target.the("Resultado de búsqueda de Libros").locatedBy("//span[starts-with(@id,'see-book')]/a");

}
