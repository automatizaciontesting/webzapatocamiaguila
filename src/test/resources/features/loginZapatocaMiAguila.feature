Feature: Login Zapatoca - Mi Aguila
  Como usuario deseo loguearme en la aplicación mi aguila

  @loginExitoso
  Scenario: Ingreso exitoso al portal zapatoca mi aguila
    Given como "comprador" en la plataforma
    When ingreso datos de las credenciales
      |Usuario|Clave|
    |necagreissauca-2829@yopmail.com|Julio*2022*|
    Then pueda ingresar de forma exitosa

    @loginSinCredenciales
  Scenario: Seleccionar boton ingresar sin credenciales de usuario y clave
      Given como "comprador" en la plataforma
      When no se ingresan datos de usuario
      Then se muestra mensaje campos requeridos