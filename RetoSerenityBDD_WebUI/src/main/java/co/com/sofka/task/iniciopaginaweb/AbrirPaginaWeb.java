package co.com.sofka.task.iniciopaginaweb;

import co.com.sofka.userinterface.InicioPaginaWeb.InicioPaginaWeb;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirPaginaWeb implements Task {

    private InicioPaginaWeb inicioPaginaWeb;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Open.browserOn(inicioPaginaWeb)
        );
    }

    public static AbrirPaginaWeb abrirPaginaWeb() {
        return new AbrirPaginaWeb();
    }

}
