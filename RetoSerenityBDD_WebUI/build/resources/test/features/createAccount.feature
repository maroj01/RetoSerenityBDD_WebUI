# language: es

Característica: Crear una cuenta en el sitio web
  Yo como nuevo usuario de Your Logo
  Quiero registrarme en el sitio web
  Para acceder a los descuentos de la tienda

#@test
  Escenario: Registro exitoso en el sitio web
    Dado que se ingreso a la pagina web de Your Logo
    Cuando me registro con los datos solicitados
    Entonces puedo ingresar a la cuenta

#@test
  Escenario: Registro a la plataforma con correo ya registrado
    Dado que ya tenia un registro con el correo
    Cuando intento registrarme con el mismo correo
    Entonces no permitirá crear la cuenta