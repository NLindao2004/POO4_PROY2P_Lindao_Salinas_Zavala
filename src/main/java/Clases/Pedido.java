/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author PC.1
 */
public class Pedido implements Pagable,Serializable{
    private String idPedido;
    private String nombreCliente;
    private double precio;
    
    public Pedido(){
        
    }
    
    public Pedido(String idPedido,String nombreCliente,double precio){
        this.idPedido=idPedido;
        this.nombreCliente=nombreCliente;
        this.precio=precio;
    }
    
    public static void guardarPedido(Pedido p){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("pedidos.txt",true))){
            bw.write(p.idPedido+","+p.nombreCliente+","+String.valueOf(p.precio)+"\n");
            System.out.println("Pedido guardado con exito");
            bw.close();
        }catch(IOException e){
            
        }
    }
    
    public static void serealizarPedido(Pedido p){
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("pedido"+p.idPedido+".bin"))){
            output.writeObject(p);
            System.out.println("Pedido serealizado con exito");
            output.close();
        }catch(IOException ex){
            
        }
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

    @Override
    public void generarTransacción(Pago p) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("pagos.txt",true))){
            bw.write(p.getIdPago()+","+p.getIdpedido()+","+p.getNombreCLiente()+","+String.valueOf(p.getTotalPagar())+","+p.getFecha()+","+p.getTipo()+"\n");
            System.out.println("Pedido guardado con exito");
            bw.close();
        }catch(IOException e){
            
        }
    }
}