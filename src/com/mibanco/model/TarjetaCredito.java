package com.mibanco.model;

/**
 * Representa una tarjeta de crédito en el sistema bancario.
 * Permite a los clientes realizar compras a crédito hasta un límite especificado y manejar los pagos de su saldo utilizado.
 * Además, calcula los intereses sobre el saldo utilizado si no se paga completamente cada mes.
 *
 * @author Luis Fernando Millan Rivera
 */
public class TarjetaCredito extends ProductoFinanciero {
    private double limiteCredito;  // Máximo saldo que puede ser utilizado en la tarjeta.
    private double saldoUtilizado; // Saldo actualmente utilizado que aún no se ha pagado.
    private double tasaInteres;    // Tasa de interés aplicada al saldo utilizado.

    /**
     * Construye una nueva tarjeta de crédito asignada a un cliente.
     *
     * @param numeroCuenta Número identificador de la cuenta de la tarjeta.
     * @param saldo Saldo inicial de la cuenta (generalmente 0 para tarjetas de crédito).
     * @param cliente Cliente titular de la tarjeta de crédito.
     * @param limiteCredito Límite máximo de crédito permitido para el uso de la tarjeta.
     * @param tasaInteres Tasa de interés mensual aplicada al saldo utilizado.
     * @throws IllegalArgumentException Si el límite de crédito o la tasa de interés son negativos.
     */
    public TarjetaCredito(String numeroCuenta, double saldo, Cliente cliente, double limiteCredito, double tasaInteres) {
        super(numeroCuenta, saldo, cliente);
        if (limiteCredito < 0 || tasaInteres < 0) {
            throw new IllegalArgumentException("Ni el límite de crédito ni la tasa de interés pueden ser negativos.");
        }
        this.limiteCredito = limiteCredito;
        this.tasaInteres = tasaInteres;
        this.saldoUtilizado = 0;  // Inicialmente no se ha utilizado crédito.
    }

    /**
     * Calcula y aplica el interés mensual al saldo utilizado.
     * Este método debe ser llamado mensualmente para actualizar el saldo con los intereses acumulados.
     */
    @Override
    public void calcularInteresMensual() {
        double interes = saldoUtilizado * (tasaInteres / 100);
        saldoUtilizado += interes;
        System.out.println("Intereses de tarjeta de crédito añadidos: " + interes);
    }

    /**
     * Permite realizar una compra con la tarjeta de crédito si no se excede el límite de crédito.
     *
     * @param monto Monto de la compra a realizar.
     * @throws IllegalStateException Si la compra excede el límite de crédito disponible.
     */
    public void realizarCompra(double monto) {
        if (monto + saldoUtilizado <= limiteCredito) {
            saldoUtilizado += monto;
            System.out.println("Compra realizada exitosamente. Saldo utilizado: " + saldoUtilizado);
        } else {
            throw new IllegalStateException("Compra rechazada. Límite de crédito excedido.");
        }
    }

    /**
     * Realiza un pago hacia el saldo utilizado en la tarjeta de crédito.
     *
     * @param monto Monto del pago a aplicar.
     * @throws IllegalArgumentException Si el monto del pago excede el saldo utilizado.
     */
    public void realizarPago(double monto) {
        if (monto > saldoUtilizado) {
            throw new IllegalArgumentException("El monto del pago excede el saldo utilizado.");
        }
        saldoUtilizado -= monto;
        System.out.println("Pago realizado. Saldo actual: " + saldoUtilizado);
    }

    // Getters y Setters con validaciones y descripciones completas.

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        if (limiteCredito < 0) {
            throw new IllegalArgumentException("El límite de crédito no puede ser negativo.");
        }
        this.limiteCredito = limiteCredito;
    }

    public double getSaldoUtilizado() {
        return saldoUtilizado;
    }

    public void setSaldoUtilizado(double saldoUtilizado) {
        this.saldoUtilizado = saldoUtilizado;  // No hay restricciones adicionales mencionadas para este setter.
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


