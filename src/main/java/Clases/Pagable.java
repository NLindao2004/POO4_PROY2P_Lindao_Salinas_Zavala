/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * La interfaz Pagable define un contrato para clases que pueden generar transacciones de pago.
 */
public interface Pagable {
    /**
     * Método para calcular el total a pagar y generar una transacción de pago.
     * @param p El objeto Pago que contiene la información del pago.
     */
    void generarTransacción(Pago p);
}

