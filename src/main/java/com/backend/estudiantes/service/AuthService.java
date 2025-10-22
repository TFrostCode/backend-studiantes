package com.backend.estudiantes.service;

import com.backend.estudiantes.models.Usuario;
import com.backend.estudiantes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario authenticate(String email, String password){
        Usuario usuario = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("El usuario no se ha encontrado"));

        if(!passwordEncoder.matches(password, usuario.getPassword())){
            throw new RuntimeException("Contraseña incorrecta");
        }

        return usuario;
    }
}
