package co.com.sofka.task.yourlogo;

import co.com.sofka.exceptions.ElementoException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.NoSuchElementException;

import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormCreateAcount.EMAIL_CREATE;
import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormCreateAcount.SUBMIT_CREATE;

public class ValidarEmailCreateAccount implements Task {

    private String correo;

    public ValidarEmailCreateAccount obtenerDatos(String correo) {
        this.correo = correo;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Scroll.to(EMAIL_CREATE),
                    Enter.theValue(correo).into(EMAIL_CREATE),
                    Scroll.to(SUBMIT_CREATE),
                    Click.on(SUBMIT_CREATE)
            );
        }catch (NoSuchElementException e){
            throw new ElementoException(ElementoException.MENSAJE_FALLO, e);
        }

    }

    public static ValidarEmailCreateAccount validarEmailCreateAccount() {
        return new ValidarEmailCreateAccount();
    }
}
