package co.com.sofka.question;

import co.com.sofka.exceptions.ElementoException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.NoSuchElementException;

public class VerificacionMensaje implements Question<Boolean> {

    private String mensajeEsperado;
    private Target elemento = null;

    public VerificacionMensaje verElemento(Target elemento) {
        this.elemento = elemento;
        return this;
    }

    public VerificacionMensaje verMensajeEsperado(String mensajeEsperado) {
        this.mensajeEsperado = mensajeEsperado;
        return this;
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        try {
            return (elemento.resolveFor(actor).containsOnlyText(mensajeEsperado));
        } catch (NoSuchElementException e) {
            throw new ElementoException(ElementoException.MENSAJE_FALLO, e);
        }
    }

    public static VerificacionMensaje verificacionMensaje() {
        return new VerificacionMensaje();
    }
}
