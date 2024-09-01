package com.mibanco.interfaces;
import com.mibanco.model.ProductoFinanciero;
import java.math.BigDecimal;

/**
 * Interfaz para definir operaciones financieras básicas que pueden ser realizadas en productos financieros.
 */
public interface OperacionesFinancieras {

    /**
     * Deposita una cantidad de dinero en un producto financiero.
     *
     * @param monto La cantidad de dinero a depositar.
     */
    void depositar(BigDecimal monto);

    /**
     * Intenta retirar una cantidad de dinero de un producto financiero.
     *
     * @param monto La cantidad de dinero a retirar.
     * @return true si el retiro fue exitoso, false de lo contrario.
     */
    boolean retirar(BigDecimal monto);

    /**
     * Transfiere una cantidad específica de dinero de un producto financiero a otro.
     *
     * @param monto La cantidad de dinero a transferir.
     * @param destino El producto financiero destino de la transferencia.
     * @throws IllegalArgumentException Si la transferencia no es posible debido a fondos insuficientes o restricciones de política.
     */
    void transferir(BigDecimal monto, ProductoFinanciero destino);
}

