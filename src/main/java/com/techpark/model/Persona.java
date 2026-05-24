package com.techpark.model;
import java.io.Serializable;

public abstract class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    // Atributos privados encapsulados
    private String nombre;
    private String documento;
    private int edad;
    private double estatura;

    // Constructor completo
    public Persona(String nombre, String documento, int edad, double estatura) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.estatura = estatura;
    }

    // Métodos Getter y Setter (Encapsulamiento)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }
}
