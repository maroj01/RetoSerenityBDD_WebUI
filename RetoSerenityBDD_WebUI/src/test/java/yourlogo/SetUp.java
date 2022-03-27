package yourlogo;


import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class SetUp {

    @Managed()
    protected WebDriver browser;

    private void configurarNavegador(WebDriver browser){
        browser.manage().deleteAllCookies();
        browser.manage().window().maximize();
    }


    private void configurarUsuario(String name, WebDriver browser){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(name).can(BrowseTheWeb.with(browser));
    }

    protected void configurarNavegadorActor(String actorName){
        defineSO();
        configurarNavegador(browser);
        configurarUsuario(actorName, browser);
    }

    private void defineSO(){

    }
}