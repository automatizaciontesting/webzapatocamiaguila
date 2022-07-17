# encoding: iso-8859-1
Feature: Realizar registro en la plataforma
  Que como usuario deseo registrarme en la plataforma

  @registroExitoso
  Scenario: Registro exitoso en la plantaforma zapatoca-miaguila
    Given como "usuario sin registro" ingreso al formulario
    When ingreso los datos de registro
    |Nombre|Apellido|SegundoApellido|Documento|NumeroDocumento|CorreoElectronico|TelContacto|Clave|Ciudad|Ubicacion|Dato1Ubicacion|Dato2Ubicacion|Dato3Ubicacion|
    |Manuel|Morales|Zolano|  Cédula de ciudadanía  |541881004|pubeuwacrivi-8730@yopmail.com|3002365804|Zapatoca*2022*|Bogotá|Carrera|104|152a|55         |
    Then se realiza el registro de forma exitosa