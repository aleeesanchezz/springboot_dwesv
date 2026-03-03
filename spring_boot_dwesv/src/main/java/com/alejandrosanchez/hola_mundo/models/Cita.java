package com.alejandrosanchez.hola_mundo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Cita(String type, Valor value) { }
