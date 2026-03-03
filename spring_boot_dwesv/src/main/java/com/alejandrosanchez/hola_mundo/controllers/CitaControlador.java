package com.alejandrosanchez.hola_mundo.controllers;

import com.alejandrosanchez.hola_mundo.models.Cita;
import com.alejandrosanchez.hola_mundo.models.Valor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitaControlador {

    @GetMapping("/api/cita")
    public Cita citaAleatoria() {
        return new Cita("exito", new Valor(1L, "Spring Boot facilita el desarrollo de aplicaciones web."));
    }
}
