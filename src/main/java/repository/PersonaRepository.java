package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    
}
