package co.com.sofka.stepdefinition;

import co.com.sofka.util.LecturaArchivo;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import yourlogo.SetUp;

import java.util.ArrayList;
import java.util.List;

import static co.com.sofka.question.VerificacionMensaje.verificacionMensaje;
import static co.com.sofka.task.iniciopaginaweb.AbrirPaginaWeb.abrirPaginaWeb;
import static co.com.sofka.task.yourlogo.LlenarCreateAccount.*;
import static co.com.sofka.task.yourlogo.Logout.logout;
import static co.com.sofka.task.yourlogo.SignIn.signIn;
import static co.com.sofka.task.yourlogo.ValidarEmailCreateAccount.validarEmailCreateAccount;
import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormCreateAcount.CREATE_ERROR;
import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormCreateAcount.MY_ACCOUNT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateAccountStepDefinition extends SetUp {

    private final String NOMBRE_ACTOR = "Adriana Rojas";
    private final String MENSAJE_REGISTRO_OK = "MY ACCOUNT";
    private final String MENSAJE_EMAIL_REGISTRADO = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
    private final String RUTA_ARCHIVO_DATOS = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\data.txt";
    private List<String> datos = LecturaArchivo.leerArchivo(RUTA_ARCHIVO_DATOS);
    private final String CORREO = nextInt(0, 10000) + "angelina@hot.com";

    @Dado("que se ingreso a la pagina web de Your Logo")
    public void ingresarPaginaWebYourLogo() {
        configurarNavegadorActor(NOMBRE_ACTOR);
        theActorInTheSpotlight().wasAbleTo(
                abrirPaginaWeb());
    }

    @Cuando("me registro con los datos solicitados")
    public void registrarDatosSolicitados() {
        theActorInTheSpotlight()
                .attemptsTo(
                        signIn(),
                        validarEmailCreateAccount().obtenerDatos(CORREO),
                        llenarCreateAccount().obtenerDatos(datos)
                );
    }

    @Entonces("puedo ingresar a la cuenta")
    public void ingresarCuenta() {
        theActorInTheSpotlight().should(
                seeThat(
                        verificacionMensaje()
                                .verElemento(MY_ACCOUNT)
                                .verMensajeEsperado(MENSAJE_REGISTRO_OK),
                        equalTo(true)
                )
        );
    }

    @Dado("que ya tenia un registro con el correo")
    public void registrarCorreo() {
        configurarNavegadorActor(NOMBRE_ACTOR);
        theActorInTheSpotlight().wasAbleTo(
                abrirPaginaWeb(),
                signIn(),
                validarEmailCreateAccount().obtenerDatos(CORREO),
                llenarCreateAccount().obtenerDatos(datos),
                logout()
        );
    }

    @Cuando("intento registrarme con el mismo correo")
    public void registrarMismoCorreo() {
        theActorInTheSpotlight()
                .attemptsTo(
                        signIn(),
                        validarEmailCreateAccount().obtenerDatos(CORREO)
                );

    }

    @Entonces("no permitirá crear la cuenta")
    public void validarCreacionCuenta() {
        theActorInTheSpotlight().should(
                seeThat(
                        verificacionMensaje()
                                .verElemento(CREATE_ERROR)
                                .verMensajeEsperado(MENSAJE_EMAIL_REGISTRADO),
                        equalTo(true)
                )
        );

    }
}