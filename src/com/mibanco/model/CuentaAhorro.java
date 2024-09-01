package com.mibanco.model;

/**
 * Clase CuentaAhorro que extiende ProductoFinanciero para representar una cuenta de ahorros específica en un sistema bancario.
 * Esta clase maneja el cálculo de intereses basados en la tasa de interés establecida para la cuenta.
 *
 * @author Luis Fernando Millan Rivera
 */
public class CuentaAhorro extends ProductoFinanciero {
    private double tasaInteres;

    /**
     * Constructor para crear una nueva cuenta de ahorro con un cliente específico, saldo inicial y tasa de interés.
     *
     * @param numeroCuenta El número de la cuenta de ahorros.
     * @param saldo El saldo inicial de la cuenta.
     * @param cliente El cliente al que pertenece esta cuenta.
     * @param tasaInteres La tasa de interés anual expresada como un porcentaje (e.g., 5 para 5%).
     * @throws IllegalArgumentException Si la tasa de interés es negativa.
     */
    public CuentaAhorro(String numeroCuenta, double saldo, Cliente cliente, double tasaInteres) {
        super(numeroCuenta, saldo, cliente);
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
        }
        this.tasaInteres = tasaInteres;
    }

    /**
     * Calcula y aplica el interés mensual al saldo de la cuenta.
     * El interés se añade directamente al saldo de la cuenta y se imprime el monto del interés añadido.
     */
    @Override
    public void calcularInteresMensual() {
        double interes = saldo * tasaInteres / 100;
        saldo += interes;
        System.out.println("Intereses añadidos: " + interes);
    }

    /**
     * Obtiene la tasa de interés actual de la cuenta.
     *
     * @return La tasa de interés actual.
     */
    public double getTasaInteres() {
        return tasaInteres;
    }

    /**
     * Establece una nueva tasa de interés para la cuenta.
     *
     * @param tasaInteres La nueva tasa de interés como un porcentaje (e.g., 5 para 5%).
     * @throws IllegalArgumentException Si la tasa de interés es negativa.
     */
    public void setTasaInteres(double tasaInteres) {
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
        }
        this.tasaInteres = tasaInteres;
    }
}


