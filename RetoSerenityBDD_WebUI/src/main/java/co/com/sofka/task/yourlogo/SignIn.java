package co.com.sofka.task.yourlogo;

import co.com.sofka.exceptions.ElementoException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormHome.SIGN_IN;

public class SignIn implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Scroll.to(SIGN_IN),
                    Click.on(SIGN_IN)
            );
        } catch (NoSuchElementException e) {
            throw new ElementoException(ElementoException.MENSAJE_FALLO, e);
        }
    }

    public static SignIn signIn() {
        return new SignIn();

    }
}
