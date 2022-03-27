package co.com.sofka.stepdefinition;

import co.com.sofka.util.LecturaArchivo;
import yourlogo.SetUp;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.ArrayList;
import java.util.List;

import static co.com.sofka.question.VerificacionMensaje.verificacionMensaje;
import static co.com.sofka.task.iniciopaginaweb.AbrirPaginaWeb.abrirPaginaWeb;
import static co.com.sofka.task.yourlogo.IngresarSignIn.ingresarSignIn;
import static co.com.sofka.task.yourlogo.LlenarCreateAccount.llenarCreateAccount;
import static co.com.sofka.task.yourlogo.Logout.logout;
import static co.com.sofka.task.yourlogo.SignIn.signIn;
import static co.com.sofka.task.yourlogo.ValidarEmailCreateAccount.validarEmailCreateAccount;
import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormLoginIn.ERROR;
import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormLoginIn.SIGN_IN_LOGIN;
import static co.com.sofka.util.EnumArreglo.PASSWORD;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.hamcrest.CoreMatchers.equalTo;

public class SignInStepDefinition extends SetUp {

    private final String NOMBRE_ACTOR = "Adriana Rojas";
    private final String CONFIRMACION_LOGIN = "MY ACCOUNT";
    private final String MENSAJE_VALIDACION = "Authentication failed.";
    private final String CORREO_NO_REGISTRADO = "lindagia@live.com";
    private final String CORREO_REGISTRADO = nextInt(0, 10000) + "adri.rojas@99gmail.com";
    private final String RUTA_ARCHIVO_DATOS = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\data.txt";
    private List<String> datos = LecturaArchivo.leerArchivo(RUTA_ARCHIVO_DATOS);


    @Dado("que me encuentro registrada en el sitio web")
    public void registrarSitioWeb() {
        configurarNavegadorActor(NOMBRE_ACTOR);
        theActorInTheSpotlight().wasAbleTo(
                abrirPaginaWeb(), signIn(),
                validarEmailCreateAccount().obtenerDatos(CORREO_REGISTRADO),
                llenarCreateAccount().obtenerDatos(datos),
                logout());
    }

    @Cuando("me autentico con Email address y password")
    public void autenticarEmailAddressPassword() {
        theActorInTheSpotlight()
                .attemptsTo(
                        signIn(),
                        ingresarSignIn().
                                diligenciarCorreo(CORREO_REGISTRADO).
                                diligenciarPassword(datos)
                );
    }

    @Entonces("puedo acceder a mi cuenta")
    public void accederCuenta() {
        theActorInTheSpotlight().should(
                seeThat(
                        verificacionMensaje()
                                .verElemento(SIGN_IN_LOGIN)
                                .verMensajeEsperado(CONFIRMACION_LOGIN),
                        equalTo(true)
                )
        );

    }

    @Dado("que me encuentro en la sección de autenticación")
    public void irSeccion() {
        configurarNavegadorActor(NOMBRE_ACTOR);
        theActorInTheSpotlight().wasAbleTo(
                abrirPaginaWeb());

    }

    @Cuando("intento ingresar con datos sin registro previo")
    public void ingresarDatosSinRegistroPrevio() {
        theActorInTheSpotlight()
                .attemptsTo(
                        signIn(),
                        ingresarSignIn().
                                diligenciarCorreo(CORREO_NO_REGISTRADO).
                                diligenciarPassword(datos)
                );

    }

    @Entonces("se mostrara el mensaje de advertencia")
    public void mostraraMensajeAdvertencia() {
        theActorInTheSpotlight().should(
                seeThat(
                        verificacionMensaje()
                                .verElemento(ERROR)
                                .verMensajeEsperado(MENSAJE_VALIDACION),
                        equalTo(true)
                )
        );
    }

}

