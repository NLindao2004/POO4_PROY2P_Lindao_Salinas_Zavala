/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.pooespol.proyecto2_heladeria.Principal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La clase Sabor representa los sabores disponibles para un producto.
 */
public class Sabor {
    /**
     * Valor constante para el precio de los sabores (por defecto, 15.00).
     */
    public static double PRECIO_CONSTANTE = 15.00;

    // Atributos de la clase Sabor.
    
    /**
     * Variables de instancia para almacenar el tipo de sabor y el precio de ese sabor.
     */
    private String tipoSabor;
    
    private String precio;
    
    /**
     * Constructor para inicializar un objeto Sabor.
     * @param tipoSabor El tipo de sabor.
     * @param precio El precio del sabor.
     */
    public Sabor(String tipoSabor, String precio){
        this.tipoSabor = tipoSabor;
        this.precio = precio;
    }
    
    /**
     * Método estático para cargar sabores desde un archivo de texto.
     * @return Una lista de objetos Sabor cargados desde el archivo "sabores.txt".
     */
    public static ArrayList<Sabor> cargarSabores(){
        ArrayList<Sabor> sabores = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(Principal.pathFiles+"sabores.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] lista = linea.split(",");
                String tipoSabor = lista[0];
                String precio = lista[1];
                Sabor sabor = new Sabor(tipoSabor, precio);
                sabores.add(sabor);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        } catch (IOException io) {
            System.out.println(io);
        }
        
        return sabores;
    }
    
    /**
     * Obtiene el tipo de sabor.
     * @return El tipo de sabor.
     */
    public String getTipoSabor(){
        return this.tipoSabor;
    }
    
    /**
     * Obtiene el precio del sabor.
     * @return El precio del sabor.
     */
    public String getPrecio(){
        return this.precio;
    }
    
    /**
     * Establece el tipo de sabor.
     * @param tipoSabor El nuevo tipo de sabor.
     */
    public void setTipoSabor(String tipoSabor){
        this.tipoSabor = tipoSabor;
    }
    
    /**
     * Establece el precio del sabor.
     * @param precio El nuevo precio del sabor.
     */
    public void setPrecio(String precio){
        this.precio = precio;
    }
    
    /**
     * Obtiene una representación en cadena del objeto Sabor.
     * @return Una cadena que representa el sabor en el formato "Tipo de Sabor - Precio".
     */
    @Override
    public String toString(){
        return this.tipoSabor + " - " + this.precio;
    }
    
    public static void main(String[] args) {
        double n = 2.00;
        String formatted = String.format("%.2f", n);
        System.out.println("cadena:" + formatted);
    }
}