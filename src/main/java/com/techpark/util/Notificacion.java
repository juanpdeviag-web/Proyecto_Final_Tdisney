package com.techpark.util;
import java.io.Serializable;
import java.time.LocalDateTime;


public record Notificacion(String mensaje, LocalDateTime fecha) implements Serializable {
    private static final long serialVersionUID = 1L;

    public Notificacion(String mensaje) {
        this(mensaje, LocalDateTime.now());
    }
}