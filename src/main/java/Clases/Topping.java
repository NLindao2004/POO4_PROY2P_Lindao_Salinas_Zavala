/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Topping {
    private String tipoTopping;
    private double precio;
    public Topping(String tipoTopping,double precio ){
        this.tipoTopping=tipoTopping;
        this.precio=precio;
    }
    
    public static ArrayList<Topping> cargarSabores(){
        ArrayList<Topping> toppings= new ArrayList();
        try(BufferedReader br= new BufferedReader(new FileReader("toppings.txt"))){
            String linea;
            while((linea= br.readLine()) != null){
                String[] lista= linea.split(",");
                String tipoTopping=lista[0];
                double precio=Double.parseDouble(lista[1]);
                Topping topping= new Topping(tipoTopping,precio);
                toppings.add(topping);
                
            }
        }catch(FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }catch(IOException io){
            System.out.println(io);
        }
        
        return toppings;
    }
    
    public String getTipoTopping(){
        return this.tipoTopping;
    }
    public double getPrecio(){
        return this.precio;
    }
    
    public void setTipoTopping(String tipoTopping){
        this.tipoTopping=tipoTopping;
    }
    public void setPrecio(double precio){
        this.precio=precio;
    }
    
    public String toString(){
        return "Topping"+"{tipoTopping="+this.tipoTopping+", precio="+this.precio+"}";
    }
}