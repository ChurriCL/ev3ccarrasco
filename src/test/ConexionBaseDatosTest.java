package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.platinum.repository.PersonaRepository;
import com.platinum.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ConexionBaseDatosTest {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void pruebaConexionBaseDatos() {
        assertTrue(personaRepository.count() >= 0);
        assertTrue(usuarioRepository.count() >= 0);
    }
}
