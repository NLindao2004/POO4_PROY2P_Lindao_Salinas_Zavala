/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author PC.1
 */
public class Pago {
    private String idPago;
    private String idPedido;
    private String nombreCLiente;
    private double totalPagar;
    private String fecha;
    private String tipo;

    public Pago(String idPago, String idpedido, String nombreCLiente, double totalPagar, String fecha, String tipo) {
        this.idPago = idPago;
        this.idPedido = idpedido;
        this.nombreCLiente = nombreCLiente;
        this.totalPagar = totalPagar;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public String getIdpedido() {
        return idPedido;
    }

    public void setIdpedido(String idpedido) {
        this.idPedido = idpedido;
    }

    public String getNombreCLiente() {
        return nombreCLiente;
    }

    public void setNombreCLiente(String nombreCLiente) {
        this.nombreCLiente = nombreCLiente;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   
    
    
    
}
