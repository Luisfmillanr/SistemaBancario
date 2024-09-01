package com.mibanco.main;
import java.util.Scanner;
import com.mibanco.model.Cliente;
import com.mibanco.model.CuentaAhorro;

/**
 * Aplicación principal para la interfaz del sistema bancario que permite la interacción con el usuario
 * para crear y manejar productos financieros como cuentas de ahorro.
 */
public class SistemaBancarioApp {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Punto de entrada principal del programa.
     * Gestiona la creación de un cliente y una cuenta asociada, y permite realizar operaciones financieras básicas.
     */
    public static void main(String[] args) {
        try {
            Cliente cliente = solicitarDatosCliente();
            CuentaAhorro cuentaAhorro = crearCuentaAhorro(cliente);
            realizarOperaciones(cuentaAhorro);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * Solicita al usuario ingresar los datos del cliente y crea un nuevo objeto Cliente.
     * @return Cliente creado con los datos ingresados.
     */
    private static Cliente solicitarDatosCliente() {
        System.out.println("Ingrese el documento de identidad del cliente:");
        String documento = scanner.nextLine();

        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el correo electrónico del cliente:");
        String correo = scanner.nextLine();

        System.out.println("Ingrese el número de celular del cliente:");
        String celular = scanner.nextLine();

        System.out.println("Ingrese la dirección del cliente:");
        String direccion = scanner.nextLine();

        return new Cliente(documento, nombre, correo, celular, direccion);
    }

    /**
     * Solicita datos para crear una cuenta de ahorro y la crea usando los datos ingresados.
     * @param cliente Cliente al que se asociará la cuenta de ahorro.
     * @return CuentaAhorro creada con los datos proporcionados.
     */
    private static CuentaAhorro crearCuentaAhorro(Cliente cliente) {
        System.out.println("Ingrese el número de cuenta de ahorro:");
        String numeroCuenta = scanner.nextLine();

        System.out.println("Ingrese el saldo inicial de la cuenta de ahorro:");
        double saldoInicial = Double.parseDouble(scanner.nextLine());

        System.out.println("Ingrese la tasa de interés de la cuenta de ahorro:");
        double tasaInteres = Double.parseDouble(scanner.nextLine());

        return new CuentaAhorro(numeroCuenta, saldoInicial, cliente, tasaInteres);
    }

    /**
     * Permite realizar operaciones financieras como depósitos y calcula los intereses mensuales.
     * @param cuentaAhorro Cuenta de ahorro sobre la que se realizarán las operaciones.
     */
    private static void realizarOperaciones(CuentaAhorro cuentaAhorro) {
        System.out.println("Ingrese el monto a depositar en la cuenta de ahorro:");
        double montoDeposito = Double.parseDouble(scanner.nextLine());

        cuentaAhorro.depositar(montoDeposito);
        cuentaAhorro.calcularInteresMensual();

        System.out.println("Saldo final en la cuenta de ahorro: " + cuentaAhorro.getSaldo());
    }
}



