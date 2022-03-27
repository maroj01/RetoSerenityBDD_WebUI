package co.com.sofka.task.yourlogo;

import co.com.sofka.exceptions.ElementoException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.NoSuchElementException;

import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormContactUs.*;

public class LlenarContactUs implements Task {
    private String emailAddress;
    private String order;
    private String message;

    public LlenarContactUs ingresarEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public LlenarContactUs ingresarOrder(String order) {
        this.order = order;
        return this;
    }

    public LlenarContactUs eIngresarMessage(String message) {
        this.message = message;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        try{
            actor.attemptsTo(
                    Scroll.to(SUBJECT_HEADING),
                    SelectFromOptions.byVisibleText("Customer service").from(SUBJECT_HEADING),

                    Scroll.to(EMAIL_ADDRESS),
                    Enter.theValue(emailAddress).into(EMAIL_ADDRESS),

                    Scroll.to(ORDER_REFERENCE),
                    Enter.theValue(order).into(ORDER_REFERENCE),

                    Scroll.to(MESSAGE),
                    Enter.theValue(message).into(MESSAGE),

                    Scroll.to(SEND),
                    Click.on(SEND)
            );

        }catch (NoSuchElementException e){
            throw new ElementoException(ElementoException.MENSAJE_FALLO, e);
        }
    }

    public static LlenarContactUs llenarContactUs() {
        return new LlenarContactUs();
    }
}
