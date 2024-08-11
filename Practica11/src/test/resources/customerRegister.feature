Feature: Customer Register
  Scenario: Crear una cuenta de usuario
    Given En el menu dar click en el link de registro
    When El formulario se cargue y llene los datos
    And Click en el boton enviar
    Then Se creara el usuario y se debe mostrar la pagina de la cuenta