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
import java.util.Locale;

public class Base {
    public static double v = 0;
    
    private String tipoBase;
    private String precio;
    public Base(String tipoBase,String precio ){
        this.tipoBase=tipoBase;
        this.precio=precio;
    }
    
    public static ArrayList<Base> cargarBase(){
        ArrayList<Base> bases= new ArrayList();
        try(BufferedReader br= new BufferedReader(new FileReader("bases.txt"))){
            String linea;
            while((linea= br.readLine())!= null){
                String[] lista= linea.split(",");
                String tipoBase=lista[0];
                double precio=Double.parseDouble(lista[1]);
                String formatted = String.format(Locale.US,"%.2f", precio);               
                Base base= new Base(tipoBase,formatted);
                bases.add(base);
                
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
    public String getPrecio(){
        return this.precio;
    }
    
    public void setTipoBase(String tipoBase){
        this.tipoBase=tipoBase;
    }
    public void setPrecio(double String){
        this.precio=precio;
    }
    
    public String toString(){
        return "Base"+"{tipoBase="+this.tipoBase+", precio="+this.precio+"}";
    }
    public static void main(String[] args) {
        System.out.println(cargarBase());
    }
    
}//FinClase