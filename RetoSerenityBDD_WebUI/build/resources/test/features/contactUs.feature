# language: es

Característica: Solicitar información por medio del sitio web
  Yo como usuario de Your Logo
  Quiero asesoria
  Para adquirir los productos del sitio web

  @test
  Escenario: Realizar consulta con todos los datos
    Dado que deseo obtener informacion de los productos
    Cuando me contacto ingresando toda la informacion solicitada
    Entonces se mostrará mensaje de confirmacion

  Escenario: Realizar consulta con correo inválido
    Dado que requiero solicitar atencion de servicio al cliente
    Cuando hago la solicitud con un correo inválido
    Entonces se mostrará el mensaje de error

