package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Persona;
import model.Usuario;
import repository.PersonaRepository;
import repository.UsuarioRepository;


@Controller
public class SitioController {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public String mostrarPaginaLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String autenticarUsuario(@RequestParam String username, @RequestParam String password, Model model) {
        Usuario usuario = usuarioRepository.findByUsernameAndPassword(username, password);
        if (usuario != null) {
            Persona persona = personaRepository.findById(usuario.getRut()).orElse(null);
            model.addAttribute("persona", persona);
            return "informacion";
        } else {
            return "error";
        }
    }
}

