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

public class Base {
    private String tipoBase;
    private double precio;
    public Base(String tipoBase,double precio ){
        this.tipoBase=tipoBase;
        this.precio=precio;
    }
    
    public static ArrayList<Base> cargarBase(){
        ArrayList<Base> bases= new ArrayList();
        try(BufferedReader br= new BufferedReader(new FileReader("bases.txt"))){
            String linea= br.readLine();
            while(linea!= null){
                String[] lista= linea.split(",");
                String tipoBase=lista[0];
                double precio=Double.parseDouble(lista[1]);
                Base base= new Base(tipoBase,precio);
                bases.add(base);
                linea= br.readLine();
            }
        }catch(FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }catch(IOException io){
            System.out.println(io);
        }
        
        return bases;
    }
    
    public String getTipoBase(){
        return this.tipoBase;
    }
    public double getPrecio(){
        return this.precio;
    }
    
    public void setTipoBase(String tipoBase){
        this.tipoBase=tipoBase;
    }
    public void setPrecio(double precio){
        this.precio=precio;
    }
    
    public String toString(){
        return "Base"+"{tipoBase="+this.tipoBase+", precio="+this.precio+"}";
    }
    
    
}//FinClase