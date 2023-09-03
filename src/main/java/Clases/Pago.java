/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La clase Pago representa la información de un pago realizado.
 */
public class Pago {
    /**
     * Variables de instancia para almacenar el id del pago, el id del pedido, nombre del cliente, total a pagar y tipo de pago.
     */

    private String idPago;

    private String idPedido;

    private String nombreCliente;

    private double totalPagar;
    
    private String fecha;

    private String tipo;

    /**
     * Constructor para inicializar un objeto Pago.
     * @param idPago El identificador del pago.
     * @param idPedido El identificador del pedido relacionado.
     * @param nombreCliente El nombre del cliente que realizó el pago.
     * @param totalPagar El monto total a pagar.
     * @param fecha La fecha en que se realizó el pago.
     * @param tipo El tipo de pago (por ejemplo, tarjeta, efectivo, etc.).
     */
    public Pago(String idPago, String idPedido, String nombreCliente, double totalPagar, String fecha, String tipo) {
        this.idPago = idPago;
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.totalPagar = totalPagar;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    /**
     * Obtiene el identificador único del pago.
     * @return El identificador del pago.
     */
    public String getIdPago() {
        return idPago;
    }

    /**
     * Establece el identificador único del pago.
     * @param idPago El nuevo identificador del pago.
     */
    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    /**
     * Obtiene el identificador único del pedido relacionado con este pago.
     * @return El identificador del pedido.
     */
    public String getIdPedido() {
        return idPedido;
    }

    /**
     * Establece el identificador único del pedido relacionado con este pago.
     * @param idPedido El nuevo identificador del pedido.
     */
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * Obtiene el nombre del cliente que realizó el pago.
     * @return El nombre del cliente.
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Establece el nombre del cliente que realizó el pago.
     * @param nombreCliente El nuevo nombre del cliente.
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * Obtiene el monto total a pagar en el pago.
     * @return El monto total a pagar.
     */
    public double getTotalPagar() {
        return totalPagar;
    }

    /**
     * Establece el monto total a pagar en el pago.
     * @param totalPagar El nuevo monto total a pagar.
     */
    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    /**
     * Obtiene la fecha en que se realizó el pago.
     * @return La fecha del pago.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en que se realizó el pago.
     * @param fecha La nueva fecha del pago.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el tipo de pago.
     * @return El tipo de pago.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de pago.
     * @param tipo El nuevo tipo de pago.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
   
}