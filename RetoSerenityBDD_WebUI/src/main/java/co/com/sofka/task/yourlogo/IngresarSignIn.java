package co.com.sofka.task.yourlogo;

import co.com.sofka.exceptions.ElementoException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormCreateAcount.CUSTOMER_FIRST_NAME;
import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormCreateAcount.REGISTER;
import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormLoginIn.*;
import static co.com.sofka.util.EnumArreglo.PASSWORD;

public class IngresarSignIn implements Task {

    private String correo;
    private List<String> datos;

    public IngresarSignIn diligenciarCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public IngresarSignIn diligenciarPassword(List<String> datos){
        this.datos = datos;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try{
            actor.attemptsTo(
                    Scroll.to(EMAIL_LOGIN),
                    Enter.theValue(correo).into(EMAIL_LOGIN),

                    Scroll.to(PASSWORD_LOGIN),
                    Enter.theValue(datos.get(PASSWORD.getValue())).into(PASSWORD_LOGIN),

                    Scroll.to(LOGIN),
                    Click.on(LOGIN)

            );
        }catch (NoSuchElementException e){
            throw new ElementoException(ElementoException.MENSAJE_FALLO, e);
        }

    }

    public static IngresarSignIn ingresarSignIn() {
        return new IngresarSignIn();
    }
}
