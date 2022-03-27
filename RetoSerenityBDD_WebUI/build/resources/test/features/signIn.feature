# language: es

Característica: Realizar autenticación en el sitio web
  Yo como usuario de Your Logo
  Quiero autenticarme en el sitio web
  Para comprar productos

#@Test
  Escenario: Login a la plataforma con datos válidos
    Dado que me encuentro registrada en el sitio web
    Cuando me autentico con Email address y password
    Entonces puedo acceder a mi cuenta

 #@Test
  Escenario: Login a la plataforma con datos no registrados
    Dado que me encuentro en la sección de autenticación
    Cuando intento ingresar con datos sin registro previo
    Entonces se mostrara el mensaje de advertencia



