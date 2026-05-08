package co.edu.sena.project_properties.repository;

import co.edu.sena.project_properties.domain.Usuario;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest;
import org.springframework.core.annotation.Order;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository; //esto esta inicializando el repositorio (new)

    @Test
    @Order(1)
    void insert() {
        Usuario usuario = new Usuario(null,"Juan","Perez","Perez","Perez");
        Usuario usuarioguardado = usuarioRepository.save(usuario);
        assertNotNull(usuarioguardado.getId());
        Usuario usuarioTest = usuarioRepository.findById(usuarioguardado.getId()).orElse(null);
        assertNotNull(usuarioTest);
        assertEquals(usuarioguardado.getId(), usuarioTest.getId());
        assertEquals("Juan", usuarioTest.getPrimerNombre());
        assertEquals("Perez", usuarioTest.getPrimerApellido());
        assertEquals("Perez", usuarioTest.getSegundoApellido());
        assertEquals("Perez", usuarioTest.getSegundoNombre());
    }

    @Test
    @Order(2)
    void update(){
        Usuario usuario = new Usuario(null,"Juan","Perez","Perez","Perez");
        Usuario usuarioguardado = usuarioRepository.save(usuario);
        assertNotNull(usuarioguardado.getId());
        Usuario usuarioTest = usuarioRepository.findById(usuarioguardado.getId()).orElse(null);

        usuarioTest.setPrimerNombre("Jose");
        usuarioRepository.save(usuarioTest);
        Usuario usuariomodificado = usuarioRepository.findById(usuarioTest.getId()).orElse(null);
        assertNotNull(usuariomodificado);
        assertEquals("Jose", usuariomodificado.getPrimerNombre());
        assertEquals(usuarioTest.getId(), usuariomodificado.getId());
    }

    @Test
    @Order(3)
    void delete(){
        Usuario usuario = new Usuario(null,"Juan","Perez","Perez","Perez");
        Usuario usuarioguardado = usuarioRepository.save(usuario);
        assertNotNull(usuarioguardado.getId());
        usuarioRepository.deleteById(usuarioguardado.getId());
        Usuario usuarioeliminado = usuarioRepository.findById(usuarioguardado.getId()).orElse(null);
        assertNull(usuarioeliminado);


    }



}