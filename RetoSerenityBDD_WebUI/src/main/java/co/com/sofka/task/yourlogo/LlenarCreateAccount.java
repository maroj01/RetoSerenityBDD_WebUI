package co.com.sofka.task.yourlogo;

import co.com.sofka.exceptions.ElementoException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import static co.com.sofka.userinterface.practiceformyourlogo.PracticeFormCreateAcount.*;
import static co.com.sofka.util.EnumArreglo.ADICIONAL;
import static co.com.sofka.util.EnumArreglo.ALIAS_DIRECION;
import static co.com.sofka.util.EnumArreglo.ANIO_NACIMIENTO;
import static co.com.sofka.util.EnumArreglo.APELLIDO;
import static co.com.sofka.util.EnumArreglo.CIUDAD;
import static co.com.sofka.util.EnumArreglo.CODIGO_POSTAL;
import static co.com.sofka.util.EnumArreglo.DIA_NACIMIENTO;
import static co.com.sofka.util.EnumArreglo.DIRECCION_P;
import static co.com.sofka.util.EnumArreglo.DIRECCION_S;
import static co.com.sofka.util.EnumArreglo.EMPRESA;
import static co.com.sofka.util.EnumArreglo.ESTADO;
import static co.com.sofka.util.EnumArreglo.MES_NACIMIENTO;
import static co.com.sofka.util.EnumArreglo.NOMBRE;
import static co.com.sofka.util.EnumArreglo.PAIS;
import static co.com.sofka.util.EnumArreglo.PASSWORD;
import static co.com.sofka.util.EnumArreglo.TELEFONO_CASA;
import static co.com.sofka.util.EnumArreglo.TELEFONO_MOVIL;

public class LlenarCreateAccount implements Task {

    private List<String> datos;

    public LlenarCreateAccount obtenerDatos(List<String> datos) {
        this.datos = datos;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Scroll.to(MRS),
                    Click.on(MRS),

                    Scroll.to(CUSTOMER_FIRST_NAME),
                    Enter.theValue(datos.get(NOMBRE.getValue())).into(CUSTOMER_FIRST_NAME),

                    Scroll.to(CUSTOMER_LAST_NAME),
                    Enter.theValue(datos.get(APELLIDO.getValue())).into(CUSTOMER_LAST_NAME),

                    Scroll.to(PASSWD),
                    Enter.theValue(datos.get(PASSWORD.getValue())).into(PASSWD),

                    Scroll.to(DAYS),
                    SelectFromOptions.byValue(datos.get(DIA_NACIMIENTO.getValue())).from(DAYS),

                    Scroll.to(MONTHS),
                    SelectFromOptions.byVisibleText(datos.get(MES_NACIMIENTO.getValue()) + " ").from(MONTHS),

                    Scroll.to(YEARS),
                    SelectFromOptions.byValue(datos.get(ANIO_NACIMIENTO.getValue())).from(YEARS),

                    Scroll.to(OFFERS),
                    Click.on(OFFERS),

                    Scroll.to(COMPANY),
                    Enter.theValue(datos.get(EMPRESA.getValue())).into(COMPANY),

                    Scroll.to(ADDRESS_UNO),
                    Enter.theValue(datos.get(DIRECCION_P.getValue())).into(ADDRESS_UNO),

                    Scroll.to(ADDRESS_DOS),
                    Enter.theValue(datos.get(DIRECCION_S.getValue())).into(ADDRESS_DOS),

                    Scroll.to(CITY),
                    Enter.theValue(datos.get(CIUDAD.getValue())).into(CITY),

                    Scroll.to(ID_STATE),
                    SelectFromOptions.byVisibleText(datos.get(ESTADO.getValue())).from(ID_STATE),

                    Scroll.to(POST_CODE),
                    Enter.theValue(datos.get(CODIGO_POSTAL.getValue())).into(POST_CODE),

                    Scroll.to(COUNTRY),
                    SelectFromOptions.byVisibleText(datos.get(PAIS.getValue())).from(COUNTRY),

                    Scroll.to(ADD_INFORMATION),
                    Enter.theValue(datos.get(ADICIONAL.getValue())).into(ADD_INFORMATION),

                    Scroll.to(PHONE),
                    Enter.theValue(datos.get(TELEFONO_CASA.getValue())).into(PHONE),

                    Scroll.to(PHONE_MOBILE),
                    Enter.theValue(datos.get(TELEFONO_MOVIL.getValue())).into(PHONE_MOBILE),

                    Scroll.to(ALIAS),
                    Enter.theValue(datos.get(ALIAS_DIRECION.getValue())).into(ALIAS),

                    Scroll.to(REGISTER),
                    Click.on(REGISTER)
            );

        } catch (NoSuchElementException e) {
            throw new ElementoException(ElementoException.MENSAJE_FALLO, e);
        }

    }

    public static LlenarCreateAccount llenarCreateAccount() {
        return new LlenarCreateAccount();
    }
}
