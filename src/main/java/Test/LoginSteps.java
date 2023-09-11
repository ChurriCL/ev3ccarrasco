package Test;


import org.springframework.beans.factory.annotation.Autowired;
import Controller.SitioController;
import model.Persona;
import repository.PersonaRepository;
import repository.UsuarioRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    @Autowired
    private SitioController sitioController;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private String username;
    private String password;
    private String resultado;

    @Given("que estoy en la página de inicio de sesión")
    public void estoy_en_pagina_inicio_sesion() {
        // Puedes agregar código de configuración si es necesario
    }

    @When("ingreso el nombre de usuario {string} y la contraseña {string}")
    public void ingreso_credenciales(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @And("presiono el botón {string}")
    public void presiono_boton(String boton) {
        if (boton.equals("Ingresar")) {
            resultado = sitioController.autenticarUsuario(username, password, null);
        }
    }

    @Then("debería ver la información básica de la persona")
    public void verificar_info_persona() {
        Persona persona = personaRepository.findByUsernameAndPassword(username, password);
        assertEquals(persona.getRut(), resultado);
    }

    @Then("debería ver un mensaje de error")
    public void verificar_mensaje_error() {
        assertEquals("error", resultado);
    }
}
