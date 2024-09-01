package com.mibanco.model;

/**
 * Representa un certificado de depósito (CD) que es un tipo de producto financiero con un plazo fijo y una tasa de interés anual.
 * Este producto permite al cliente invertir su dinero por un período determinado con una tasa de interés garantizada.
 */
public class CertificadoDeposito extends ProductoFinanciero {
    private int plazoMeses;
    private double tasaInteres;

    /**
     * Construye un nuevo certificado de depósito.
     *
     * @param numeroCuenta Número de cuenta asociado al certificado.
     * @param saldo Saldo inicial depositado en el certificado.
     * @param cliente Cliente titular del certificado.
     * @param plazoMeses Duración del certificado en meses.
     * @param tasaInteres Tasa de interés anual aplicada al certificado.
     * @throws IllegalArgumentException Si el plazo o la tasa de interés son negativos.
     */
    public CertificadoDeposito(String numeroCuenta, double saldo, Cliente cliente, int plazoMeses, double tasaInteres) {
        super(numeroCuenta, saldo, cliente);
        if (plazoMeses <= 0 || tasaInteres < 0) {
            throw new IllegalArgumentException("El plazo debe ser mayor que cero y la tasa de interés no puede ser negativa.");
        }
        this.plazoMeses = plazoMeses;
        this.tasaInteres = tasaInteres;
    }

    @Override
    public void calcularInteresMensual() {
        double interes = (saldo * (tasaInteres / 100)) / 12;
        saldo += interes;
        System.out.println("Intereses acumulados para este mes: " + interes + ". Saldo actual: " + saldo);
    }

    /**
     * Calcula el total a pagar al cliente al final del plazo del certificado, incluyendo el principal y los intereses acumulados.
     *
     * @return El total de pago al final del plazo.
     */
    public double calcularPagoFinal() {
        double interesTotal = (saldo * (tasaInteres / 100) * (plazoMeses / 12.0));
        return saldo + interesTotal;
    }

    // Getters y Setters con validaciones para asegurar que los datos sean razonables.

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(int plazoMeses) {
        if (plazoMeses <= 0) {
            throw new IllegalArgumentException("El plazo debe ser mayor que cero.");
        }
        this.plazoMeses = plazoMeses;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
        }
        this.tasaInteres = tasaInteres;
    }
}

