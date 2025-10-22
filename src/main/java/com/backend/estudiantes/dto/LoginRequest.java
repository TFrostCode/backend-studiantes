package com.backend.estudiantes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "El email es obligatorio!")
    @Email(message = "Ingresa el email correctamente")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
}
