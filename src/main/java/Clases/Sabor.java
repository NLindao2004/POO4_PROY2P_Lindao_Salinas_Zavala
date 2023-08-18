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


public class Sabor {
    private String tipoSabor;
    private double precio;
    public Sabor(String tipoSabor,double precio ){
        this.tipoSabor=tipoSabor;
        this.precio=precio;
    }
    
    public static ArrayList<Sabor> cargarSabores(){
        ArrayList<Sabor> sabores= new ArrayList();
        try(BufferedReader br= new BufferedReader(new FileReader("sabores.txt"));){
            String linea= br.readLine();
            while(linea!= null){
                String[] lista= linea.split(",");
                String tipoSabor=lista[0];
                double precio=Double.parseDouble(lista[1]);
                Sabor sabor= new Sabor(tipoSabor,precio);
                sabores.add(sabor);
                linea= br.readLine();
            }
        }catch(FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }catch(IOException io){
            System.out.println(io);
        }
        
        return sabores;
    }
    
    public String getTipoSabor(){
        return this.tipoSabor;
    }
    public double getPrecio(){
        return this.precio;
    }
    
    public void setTipoBase(String tipoSabor){
        this.tipoSabor=tipoSabor;
    }
    public void setPrecio(double precio){
        this.precio=precio;
    }
    
    public String toString(){
        return "Sabor"+"{tipoSabor="+this.tipoSabor+", precio="+this.precio+"}";
    }
    
    
}
