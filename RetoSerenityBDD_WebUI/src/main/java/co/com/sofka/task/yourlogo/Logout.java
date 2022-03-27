package co.com.sofka.task.yourlogo;

import co.com.sofka.exceptions.ElementoException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.NoSuchElementException;

import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormCreateAcount.LOGOUT;

public class Logout implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(
                    Scroll.to(LOGOUT),
                    Click.on(LOGOUT)
            );
        }catch (NoSuchElementException e) {
            throw new ElementoException(ElementoException.MENSAJE_FALLO, e);
        }
    }

    public static Logout logout() {
        return new Logout();

    }
}
