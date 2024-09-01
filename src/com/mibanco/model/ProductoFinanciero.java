package com.mibanco.model;

/**
 * Clase abstracta que representa un producto financiero básico en un sistema bancario.
 * Define operaciones comunes y requiere que se implementen detalles específicos para cada tipo de producto.
 */
public abstract class ProductoFinanciero {
    protected String numeroCuenta;
    protected double saldo;
    protected Cliente cliente;

    /**
     * Constructor que inicializa un producto financiero con detalles básicos.
     *
     * @param numeroCuenta Número de la cuenta asociada al producto financiero.
     * @param saldo Saldo inicial de la cuenta.
     * @param cliente Cliente titular del producto financiero.
     */
    public ProductoFinanciero(String numeroCuenta, double saldo, Cliente cliente) {
        if (numeroCuenta == null || numeroCuenta.isEmpty()) {
            throw new IllegalArgumentException("El número de cuenta no puede ser nulo o vacío.");
        }
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    /**
     * Método abstracto para calcular los intereses mensuales de cada tipo de producto financiero.
     */
    public abstract void calcularInteresMensual();

    /**
     * Deposita dinero en la cuenta, asegurándose de que el monto sea positivo.
     *
     * @param monto Cantidad de dinero a depositar.
     */
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
        saldo += monto;
        System.out.println("Depósito realizado. Nuevo saldo: " + saldo);
    }

    /**
     * Intenta retirar una cantidad de dinero de la cuenta.
     *
     * @param monto Cantidad de dinero a retirar.
     * @return true si el retiro es exitoso, false si no hay fondos suficientes.
     */
    public boolean retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }
        if (monto > saldo) {
            throw new IllegalStateException("Fondos insuficientes para el retiro.");
        }
        saldo -= monto;
        System.out.println("Retiro realizado. Saldo restante: " + saldo);
        return true;
    }

    // Getters y Setters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

