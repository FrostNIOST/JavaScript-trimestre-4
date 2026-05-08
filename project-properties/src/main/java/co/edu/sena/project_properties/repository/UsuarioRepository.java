package co.edu.sena.project_properties.repository;

import co.edu.sena.project_properties.domain.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
