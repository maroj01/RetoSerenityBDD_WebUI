package co.com.sofka.task.yourlogo;

import co.com.sofka.exceptions.ElementoException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.NoSuchElementException;

import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormHome.CONTACT_US;

public class IngresarContactUs implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Scroll.to(CONTACT_US),
                    Click.on(CONTACT_US)
            );
        } catch (NoSuchElementException e) {
            throw new ElementoException(ElementoException.MENSAJE_FALLO, e);
        }
    }

    public static IngresarContactUs contactUs() {
        return new IngresarContactUs();
    }
}
