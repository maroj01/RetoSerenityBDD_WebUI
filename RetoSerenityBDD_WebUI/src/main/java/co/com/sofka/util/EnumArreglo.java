package co.com.sofka.util;

public enum EnumArreglo {
    NOMBRE(0),
    APELLIDO(1),
    PASSWORD(2),
    DIA_NACIMIENTO(3),
    MES_NACIMIENTO(4),
    ANIO_NACIMIENTO(5),
    EMPRESA(6),
    DIRECCION_P(7),
    DIRECCION_S(8),
    CIUDAD(9),
    ESTADO(10),
    CODIGO_POSTAL(11),
    PAIS(12),
    ADICIONAL(13),
    TELEFONO_CASA(14),
    TELEFONO_MOVIL(15),
    ALIAS_DIRECION(16);

    private final int value;

    EnumArreglo(int value) {
        this.value = value;
    }

    public int getValue() {

        return value;
    }
}
