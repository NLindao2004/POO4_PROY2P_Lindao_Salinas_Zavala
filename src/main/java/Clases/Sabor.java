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
    private String precio;
    public Sabor(String tipoSabor,String precio ){
        this.tipoSabor=tipoSabor;
        this.precio=precio;
    }
    
    public static ArrayList<Sabor> cargarSabores(){
        ArrayList<Sabor> sabores= new ArrayList();
        try(BufferedReader br= new BufferedReader(new FileReader("sabores.txt"));){
            String linea;
            while((linea= br.readLine())!= null){
                String[] lista= linea.split(",");
                String tipoSabor=lista[0];
                String precio=lista[1];
                Sabor sabor= new Sabor(tipoSabor,precio);
                sabores.add(sabor);
                
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
    public String getPrecio(){
        return this.precio;
    }
    
    public void setTipoBase(String tipoSabor){
        this.tipoSabor=tipoSabor;
    }
    public void setPrecio(String precio){
        this.precio=precio;
    }
    
    public String toString(){
        return this.tipoSabor+" - "+this.precio;
    }
    public static void main(String[] args) {
        System.out.println(cargarSabores());
    }
    
}
