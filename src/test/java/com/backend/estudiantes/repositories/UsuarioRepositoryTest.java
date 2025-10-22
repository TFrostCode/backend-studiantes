package com.backend.estudiantes.repositories;
import com.backend.estudiantes.models.Role;
import com.backend.estudiantes.models.Usuario;
import com.backend.estudiantes.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UsuarioRepositoryTest {

    // Inyección de dependencia
    @Autowired
    private UsuarioRepository repository;

    // Crea un usuario de prueba
    @Test
    void findByEmail_UsuarioEncontrado_RetornarUsuario(){
        Usuario testUsuario = Usuario.builder()
                .nombre("Test")
                .apellido("User")
                .email("userTest@gmail.com")
                .password("123")
                .rol(Role.ESTUDIANTE)
                .build();

        // Guarda el usuario
        Usuario guardado = repository.save(testUsuario);

        // Lo busco por correo y devuelve un optional (puede o no devolver algo)
        Optional<Usuario> encontradoOptional = repository.findByEmail(guardado.getEmail());

        // Verifica si se encuentra el usuario
        assertTrue(encontradoOptional.isPresent(), "Usuario no encontrado");

        // Obtengo el objeto
        Usuario encontrado = encontradoOptional.get();

        // Comprueba que el email del usuario encontrado sea igual al esperado.
        assertEquals("userTest@gmail.com",encontrado.getEmail(), "El email debe coincidir");
    }
}
