package com.mibanco.model;

import java.util.Objects;

/**
 * Representa un cliente del banco, almacenando toda la información relevante del mismo.
 * Esta clase es utilizada para manejar las operaciones relacionadas con clientes,
 * incluyendo la gestión de sus datos personales y de contacto.
 *
 * @author Luis Fernando Millan Rivera y Juan José Mejía Sánchez
 */
public class Cliente {

    // Atributos de la clase
    private String documentoIdentidad;
    private String nombre;
    private String correoElectronico;
    private String numeroCelular;
    private String direccion;

    /**
     * Constructor para crear una nueva instancia de Cliente.
     *
     * @param documentoIdentidad Documento de identidad del cliente.
     * @param nombre Nombre completo del cliente.
     * @param correoElectronico Correo electrónico del cliente.
     * @param numeroCelular Número de teléfono celular del cliente.
     * @param direccion Dirección residencial del cliente.
     */
    public Cliente(String documentoIdentidad, String nombre, String correoElectronico, String numeroCelular, String direccion) {
        this.documentoIdentidad = Objects.requireNonNull(documentoIdentidad, "El documento de identidad no puede ser nulo.");
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo.");
        this.correoElectronico = validateEmail(correoElectronico);
        this.numeroCelular = validatePhoneNumber(numeroCelular);
        this.direccion = Objects.requireNonNull(direccion, "La dirección no puede ser nula.");
    }

    private String validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Correo electrónico inválido.");
        }
        return email;
    }

    private String validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Número de teléfono inválido. Debe contener solo números.");
        }
        return phoneNumber;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo.");
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = validateEmail(correoElectronico);
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = validatePhoneNumber(numeroCelular);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = Objects.requireNonNull(direccion, "La dirección no puede ser nula.");
    }
}



