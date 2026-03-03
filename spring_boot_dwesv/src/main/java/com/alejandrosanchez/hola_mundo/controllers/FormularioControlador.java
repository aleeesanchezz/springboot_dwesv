package com.alejandrosanchez.hola_mundo.controllers;

import com.alejandrosanchez.hola_mundo.models.PersonaFormulario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class FormularioControlador implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/resultado").setViewName("resultado");
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(PersonaFormulario personaFormulario) {
        return "formulario";
    }

    @PostMapping("/formulario")
    public String comprobarDatos(@Valid PersonaFormulario personaFormulario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formulario";
        }
        return "redirect:/resultado";
    }
}
