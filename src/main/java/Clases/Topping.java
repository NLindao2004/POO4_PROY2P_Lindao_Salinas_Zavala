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
 * La clase Topping representa los toppings disponibles para un producto.
 */
public class Topping {
    // Atributos de la clase Topping.

    /**
     * Variables de instancia para almacenar el tipo de topping y el precio del mismo.
     */
    private String tipoTopping;
    private double precio;

    /**
     * Constructor para inicializar un objeto Topping.
     * @param tipoTopping El tipo de topping.
     * @param precio El precio del topping.
     */
    public Topping(String tipoTopping, double precio) {
        this.tipoTopping = tipoTopping;
        this.precio = precio;
    }

    /**
     * Método estático para cargar toppings desde un archivo de texto.
     * @return Una lista de objetos Topping cargados desde el archivo "toppings.txt".
     */
    public static ArrayList<Topping> cargarSabores() {
        ArrayList<Topping> toppings = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(Principal.pathFiles+"toppings.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] lista = linea.split(",");
                String tipoTopping = lista[0];
                double precio = Double.parseDouble(lista[1]);
                Topping topping = new Topping(tipoTopping, precio);
                toppings.add(topping);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        } catch (IOException io) {
            System.out.println(io);
        }

        return toppings;
    }

    /**
     * Obtiene el tipo de topping.
     * @return El tipo de topping.
     */
    public String getTipoTopping() {
        return this.tipoTopping;
    }

    /**
     * Obtiene el precio del topping.
     * @return El precio del topping.
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Establece el tipo de topping.
     * @param tipoTopping El nuevo tipo de topping.
     */
    public void setTipoTopping(String tipoTopping) {
        this.tipoTopping = tipoTopping;
    }

    /**
     * Establece el precio del topping.
     * @param precio El nuevo precio del topping.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene una representación en cadena del objeto Topping.
     * @return Una cadena que representa el topping en el formato "Topping {tipoTopping=..., precio=...}".
     */
    @Override
    public String toString() {
        return "Topping {tipoTopping=" + this.tipoTopping + ", precio=" + this.precio + "}";
    }
}