package com.techpark.model;


public abstract class Empleado extends Persona {
    private static final long serialVersionUID = 1L;

    private String idEmpleado;
    private double salarioBase;

    public Empleado(String documento, String nombre, int edad, double estatura, String idEmpleado, double salarioBase) {
        super(nombre, documento, edad, estatura);
        this.idEmpleado = idEmpleado;
        this.salarioBase = salarioBase;
    }

    // Método abstracto: cada tipo de empleado calculará sus bonificaciones o salario neto de forma diferente
    public abstract double calcularSalarioNeto();


    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
}
