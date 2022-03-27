package co.com.sofka.exceptions;

import org.openqa.selenium.NoSuchElementException;

public class ElementoException extends NoSuchElementException {

    public static final String MENSAJE_FALLO = "No se encontró el elemento";

    public ElementoException(String reason, Throwable cause) {
        super(reason, cause);
    }
}