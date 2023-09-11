Feature: Inicio de Sesión en el Sitio Web

  Scenario: Iniciar sesión con credenciales válidas
    Given que estoy en la página de inicio de sesión
    When ingreso el nombre de usuario "usuario" y la contraseña "contraseña"
    And presiono el botón "Ingresar"
    Then debería ver la información básica de la persona

  Scenario: Iniciar sesión con credenciales incorrectas
    Given que estoy en la página de inicio de sesión
    When ingreso el nombre de usuario "usuario_incorrecto" y la contraseña "contraseña_incorrecta"
    And presiono el botón "Ingresar"
    Then debería ver un mensaje de error

  Scenario: Iniciar sesión con campos vacíos
    Given que estoy en la página de inicio de sesión
    When dejo los campos de nombre de usuario y contraseña vacíos
    And presiono el botón "Ingresar"
    Then debería ver un mensaje de error
