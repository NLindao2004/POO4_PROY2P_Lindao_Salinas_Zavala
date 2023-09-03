/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.pooespol.proyecto2_heladeria.Principal;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * La clase Pedido representa un pedido realizado por un cliente.
 * Implementa la interfaz Pagable y es Serializable.
 */
public class Pedido implements Pagable, Serializable {
    // Atributos de la clase Pedido.

    /**
     * Variables de instancia para almacenar el id del pedido, el nombre del cliente y el precio del pedido.
     */
    private String idPedido;


    private String nombreCliente;

   
    private double precio;

  
    public Pedido() {

    }

    /**
     * Constructor para inicializar un objeto Pedido.
     * @param idPedido El identificador único del pedido.
     * @param nombreCliente El nombre del cliente que realizó el pedido.
     * @param precio El precio total del pedido.
     */
    public Pedido(String idPedido, String nombreCliente, double precio) {
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.precio = precio;
    }

    /**
     * Guarda un pedido en un archivo de texto.
     * @param p El pedido a guardar.
     */
    public static void guardarPedido(Pedido p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Principal.pathFiles+"pedidos.txt", true))) {
            bw.write(p.idPedido + "," + p.nombreCliente + "," + String.valueOf(p.precio) + "\n");
            System.out.println("Pedido guardado con éxito");
            bw.close();
        } catch (IOException e) {
            // Manejar excepción de E/S.
        }
    }

    /**
     * Serializa un pedido y lo guarda en un archivo binario.
     * @param p El pedido a serializar.
     */
    public static void serealizarPedido(Pedido p) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(Principal.pathFiles+"pedido" + p.idPedido + ".bin"))) {
            output.writeObject(p);
            System.out.println("Pedido serializado con éxito");
            output.close();
        } catch (IOException ex) {
            // Manejar excepción de E/S.
        }
    }

    /**
     * Obtiene el identificador único del pedido.
     * @return El identificador del pedido.
     */
    public String getIdPedido() {
        return this.idPedido;
    }

    /**
     * Obtiene el nombre del cliente que realizó el pedido.
     * @return El nombre del cliente.
     */
    public String getNombreCliente() {
        return this.nombreCliente;
    }

    /**
     * Obtiene el precio total del pedido.
     * @return El precio total del pedido.
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Establece el identificador único del pedido.
     * @param idPedido El nuevo identificador del pedido.
     */
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * Establece el nombre del cliente que realizó el pedido.
     * @param nombreCliente El nuevo nombre del cliente.
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * Establece el precio total del pedido.
     * @param precio El nuevo precio total del pedido.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene una representación en cadena del objeto Pedido.
     * @return Una cadena que representa el objeto Pedido en el formato "Pedido {idPedido=..., nombreCliente=..., precio=...}".
     */
    @Override
    public String toString() {
        return "Pedido {idPedido=" + this.idPedido + ", nombreCliente=" + this.nombreCliente + ", precio=" + this.precio + "}";
    }

    /**
     * Implementación del método de la interfaz Pagable para generar una transacción de pago.
     * @param p El objeto Pago que contiene la información del pago.
     */
    @Override
    public void generarTransacción(Pago p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Principal.pathFiles+"pagos.txt", true))) {
            bw.write(p.getIdPago() + "," + p.getIdPedido() + "," + p.getNombreCliente() + "," + String.valueOf(p.getTotalPagar()) + "," + p.getFecha() + "," + p.getTipo() + "\n");
            System.out.println("Transacción de pago generada con éxito");
            bw.close();
        } catch (IOException e) {
            // Manejar excepción de E/S.
        }
    }
}