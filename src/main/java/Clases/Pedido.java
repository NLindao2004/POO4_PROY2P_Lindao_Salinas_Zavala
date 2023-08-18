/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author PC.1
 */
public class Pedido {
    private String idPedido;
    private String nombreCliente;
    private double precio;
    
    public Pedido(String idPedido,String nombreCliente,double precio){
        this.idPedido=idPedido;
        this.nombreCliente=nombreCliente;
        this.precio=precio;
    }
    
    public void guardarPedido(Pedido pedido){
        
    }
    
    public String generarTransaccion(){
        return "nada";
    }
    
    public String getIdPedido(){
        return this.idPedido;
    }
    
    public String getNombreCliente(){
        return this.nombreCliente;
    }
    
    public double getPrecio(){
        return this.precio;
    }
    
    public void setIdPedido(String idPedido){
        this.idPedido=idPedido;
    }
    
    public void setNombreCliente(String nombreCliente){
        this.nombreCliente=nombreCliente;
    }
    
    public void setPrecio(double precio){
        this.precio=precio;
    }
    
    public String toString(){
        return "Pedido"+"{idPedido="+this.idPedido+", nombreCliente="+this.nombreCliente+", precio="+this.precio+"}";
    }
}