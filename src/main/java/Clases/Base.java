/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * La clase Base representa información sobre bases.
 */
package Clases;

import com.pooespol.proyecto2_heladeria.Principal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Base {
    /**
     * Variable estática.
     */
    public static double v = 0;
    
    /**
     * Variables de instancia para almacenar el tipo de base y su precio.
     */
    private String tipoBase;
    private String precio;
    
    /**
     * Constructor para inicializar las variables de instancia.
     * @param tipoBase El tipo de la base.
     * @param precio El precio de la base.
     */
    public Base(String tipoBase, String precio){
        this.tipoBase = tipoBase;
        this.precio = precio;
    }
    
    /**
     * Método estático para cargar información de bases desde un archivo y devolver una lista de objetos Base.
     * @return Una lista de objetos Base cargados desde el archivo "bases.txt".
     */
    public static ArrayList<Base> cargarBase(){
        ArrayList<Base> bases = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(Principal.pathFiles+"bases.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en tipoBase y precio utilizando la coma como separador.
                String[] lista = linea.split(",");
                String tipoBase = lista[0];
                double precio = Double.parseDouble(lista[1]);
                
                // Formatear el precio con dos decimales y crear un objeto Base.
                String formatted = String.format(Locale.US, "%.2f", precio);
                Base base = new Base(tipoBase, formatted);
                
                // Agregar el objeto Base a la lista.
                bases.add(base);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        } catch (IOException io) {
            System.out.println(io);
        }
        
        // Devolver la lista de bases cargadas desde el archivo.
        return bases;
    }
    
    /**
     * Método de acceso para obtener el tipo de base.
     * @return El tipo de la base.
     */
    public String getTipoBase(){
        return this.tipoBase;
    }
    
    /**
     * Método de acceso para obtener el precio de la base.
     * @return El precio de la base.
     */
    public String getPrecio(){
        return this.precio;
    }
    
    /**
     * Método mutador para modificar el tipo de base.
     * @param tipoBase El nuevo tipo de la base.
     */
    public void setTipoBase(String tipoBase){
        this.tipoBase = tipoBase;
    }
    
    /**
     * Método mutador para modificar el precio de la base.
     * @param precio El nuevo precio de la base.
     */
    public void setPrecio(String precio){
        this.precio = precio;
    }
    
    /**
     * Método para obtener una representación en cadena de un objeto Base.
     * @return Una cadena que representa el objeto Base en el formato "Base {tipoBase=..., precio=...}".
     */
    public String toString(){
        return "Base {tipoBase=" + this.tipoBase + ", precio=" + this.precio + "}";
    }
    
    public static void main(String[] args) {
        System.out.println(cargarBase());
    }
}