package com.techpark.model;

public class Operador extends Empleado {
    private static final long serialVersionUID = 1L;

    private String areaAsignada;

    public Operador(String documento, String nombre, int edad, double estatura,
                    String idEmpleado, double salarioBase, String areaAsignada) {
        super(documento, nombre, edad, estatura, idEmpleado, salarioBase);
        this.areaAsignada = areaAsignada;
    }

    // Calcula el salario básico (Se puede expandir con bonos operativos después)
    @Override
    public double calcularSalarioNeto() {
        return getSalarioBase();
    }

    // Getter y Setter
    public String getAreaAsignada() {
        return areaAsignada;
    }

    public void setAreaAsignada(String areaAsignada) {
        this.areaAsignada = areaAsignada;
    }

    public void realizarMantenimiento(Atraccion atraccion) {
    }
}
