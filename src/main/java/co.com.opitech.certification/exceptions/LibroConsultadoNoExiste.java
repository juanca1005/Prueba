package co.com.opitech.certification.exceptions;

public class LibroConsultadoNoExiste extends AssertionError {

    private static final String MESSAGE_BOOK_NOT_EXITS = "El libro %s no existe entre los libros disponibles";


    public LibroConsultadoNoExiste(String message) {
        super(message);
    }


}
