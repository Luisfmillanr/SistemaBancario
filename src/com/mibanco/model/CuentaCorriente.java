package com.mibanco.model;

/**
 * Clase que representa una cuenta corriente en un sistema bancario.
 * Permite operaciones como el cálculo de intereses y el retiro de fondos,
 * incluyendo la capacidad de sobregirar hasta un límite establecido.
 *
 * @author Luis Fernando Millan Rivera
 */
public class CuentaCorriente extends ProductoFinanciero {
    private double tasaInteres;  // Tasa de interés aplicada al saldo
    private double limiteSobregiro;  // Límite máximo de sobregiro permitido

    /**
     * Constructor para la cuenta corriente.
     *
     * @param numeroCuenta Número de la cuenta.
     * @param saldo Saldo inicial de la cuenta.
     * @param cliente Cliente titular de la cuenta.
     * @param tasaInteres Tasa de interés mensual aplicada.
     * @param limiteSobregiro Máximo permitido para sobregiro.
     * @throws IllegalArgumentException si la tasa de interés o el límite de sobregiro son negativos.
     */
    public CuentaCorriente(String numeroCuenta, double saldo, Cliente cliente, double tasaInteres, double limiteSobregiro) {
        super(numeroCuenta, saldo, cliente);
        if (tasaInteres < 0 || limiteSobregiro < 0) {
            throw new IllegalArgumentException("La tasa de interés y el límite de sobregiro no pueden ser negativos.");
        }
        this.tasaInteres = tasaInteres;
        this.limiteSobregiro = limiteSobregiro;
    }

    /**
     * Calcula y aplica el interés mensual al saldo de la cuenta.
     */
    @Override
    public void calcularInteresMensual() {
        double interes = saldo * (tasaInteres / 100);
        saldo += interes;
        System.out.println("Intereses añadidos: " + interes + ". Nuevo saldo: " + saldo);
    }

    /**
     * Intenta retirar una cantidad de dinero de la cuenta. Si el monto excede el saldo más el límite de sobregiro,
     * el retiro no se realiza y se retorna false.
     *
     * @param monto Monto a retirar.
     * @return true si el retiro es exitoso, false si no hay fondos suficientes.
     */
    public boolean retirar(double monto) {
        if (monto <= saldo + limiteSobregiro) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
            return true;
        } else {
            System.out.println("Fondos insuficientes, incluyendo sobregiro.");
            return false;
        }
    }

    // Getters y Setters con validaciones

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
        }
        this.tasaInteres = tasaInteres;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public void setLimiteSobregiro(double limiteSobregiro) {
        if (limiteSobregiro < 0) {
            throw new IllegalArgumentException("El límite de sobregiro no puede ser negativo.");
        }
        this.limiteSobregiro = limiteSobregiro;
    }
}

