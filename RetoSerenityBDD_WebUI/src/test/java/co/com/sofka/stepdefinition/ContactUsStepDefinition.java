package co.com.sofka.stepdefinition;

import yourlogo.SetUp;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static co.com.sofka.question.VerificacionMensaje.verificacionMensaje;
import static co.com.sofka.task.iniciopaginaweb.AbrirPaginaWeb.abrirPaginaWeb;
import static co.com.sofka.task.yourlogo.IngresarContactUs.contactUs;
import static co.com.sofka.task.yourlogo.LlenarContactUs.llenarContactUs;
import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormContactUs.CONTACT_EXITOSO;
import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormContactUs.INVALID_EMAIL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactUsStepDefinition extends SetUp {

    private final String NOMBRE_ACTOR = "Adriana Rojas";
    private final String MENSAJE_CONFIRMACION = "Your message has been successfully sent to our team.";
    private final String MENSAJE_ERROR = "Invalid email address.";

    private final String CORREO_INVALIDO = "adri.rojas990@gmail";
    private final String CORREO_ELECTRONICO = "adri.rojas990@gmail.com";
    private final String REFERENCIA = "REF:01";
    private final String MENSAJE = "Esto es una prueba automatizada, el resultado será exitosa.";

    @Dado("que deseo obtener informacion de los productos")
    public void obtenerInformacionProductos() {
        configurarNavegadorActor(NOMBRE_ACTOR);
        theActorInTheSpotlight().wasAbleTo(
                abrirPaginaWeb());
    }

    @Cuando("me contacto ingresando toda la informacion solicitada")
    public void IngresarInformacionSolicitada() {
        theActorInTheSpotlight()
                .attemptsTo(
                        contactUs(),
                        llenarContactUs()
                                .ingresarEmailAddress(CORREO_ELECTRONICO)
                                .ingresarOrder(REFERENCIA)
                                .eIngresarMessage(MENSAJE)

                );
    }

    @Entonces("se mostrará mensaje de confirmacion")
    public void mostrarMensajeConfirmacion() {
        theActorInTheSpotlight().should(
                seeThat(
                        verificacionMensaje()
                                .verElemento(CONTACT_EXITOSO)
                                .verMensajeEsperado(MENSAJE_CONFIRMACION),
                        equalTo(true)
                )
        );

    }

    @Dado("que requiero solicitar atencion de servicio al cliente")
    public void solicitarAtencionServicioCliente() {
        configurarNavegadorActor(NOMBRE_ACTOR);
        theActorInTheSpotlight().wasAbleTo(
                abrirPaginaWeb());
    }

    @Cuando("hago la solicitud con un correo inválido")
    public void SolicitarCorreoInvalido() {
        theActorInTheSpotlight()
                .attemptsTo(
                        contactUs(),
                        llenarContactUs()
                                .ingresarEmailAddress(CORREO_INVALIDO)
                                .ingresarOrder(REFERENCIA)
                                .eIngresarMessage(MENSAJE)
                );

    }

    @Entonces("se mostrará el mensaje de error")
    public void mostrarMensajeError() {
        theActorInTheSpotlight().should(
                seeThat(
                        verificacionMensaje()
                                .verElemento(INVALID_EMAIL)
                                .verMensajeEsperado(MENSAJE_ERROR),
                        equalTo(true)
                )
        );
    }
}
