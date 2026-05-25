package com.techpark.model;

public class Administrador extends Empleado {
    private static final long serialVersionUID = 1L;

    private double bonoGestion;

    public Administrador(String documento, String nombre, int edad, double estatura,
                         String idEmpleado, double salarioBase, double bonoGestion) {
        super(documento, nombre, edad, estatura, idEmpleado, salarioBase);
        this.bonoGestion = bonoGestion;
    }

    // El administrador recibe su salario base más el bono por su gestión
    @Override
    public double calcularSalarioNeto() {
        return getSalarioBase() + bonoGestion;
    }


    public double getBonoGestion() {
        return bonoGestion;
    }

    public void setBonoGestion(double bonoGestion) {
        this.bonoGestion = bonoGestion;
    }
}
