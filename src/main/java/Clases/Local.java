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


/**
 * La clase Local representa información sobre locales con coordenadas, nombre y horario.
 */
public class Local {
    /**
     * Variables de instancia para almacenar la ubicacion del local, su nombre y el horario.
     */
    private double coordenadaX;
    private double coordenadaY;
    private String nombre;
    private String horario;
    
    /**
     * Constructor para inicializar las propiedades del local.
     * @param coordenadaX La coordenada X del local.
     * @param coordenadaY La coordenada Y del local.
     * @param nombre El nombre del local.
     * @param horario El horario del local.
     */
    public Local(double coordenadaX, double coordenadaY, String nombre, String horario){
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.nombre = nombre;
        this.horario = horario;
    }
    
    /**
     * Método estático para cargar información de locales desde un archivo y devolver una lista de objetos Local.
     * @return Una lista de objetos Local cargados desde el archivo "locales.txt".
     */
    public static ArrayList<Local> cargarLocales(){
        // Lista para almacenar los locales cargados desde el archivo.
        ArrayList<Local> locales = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("locales.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes utilizando la coma como separador.
                String[] lista = linea.split(",");
                double coordenadaX = Double.parseDouble(lista[0]);
                double coordenadaY = Double.parseDouble(lista[1]);
                String nombre = lista[2];
                String horario = lista[3];
      
                // Crear un objeto Local y agregarlo a la lista de locales.
                Local local = new Local(coordenadaX, coordenadaY, nombre, horario);
                locales.add(local);
            }
        } catch (FileNotFoundException fnf) {
            // Manejar excepción de archivo no encontrado.
            System.out.println(fnf.getMessage());
        } catch (IOException io) {
            // Manejar excepción de entrada/salida.
            System.out.println(io);
        }
        
        // Devolver la lista de locales cargados desde el archivo.
        return locales;
    }
    
    /**
     * Método de acceso para obtener la coordenada X del local.
     * @return La coordenada X del local.
     */
    public double getCoordenadaX(){
        return this.coordenadaX;
    }
    
    /**
     * Método de acceso para obtener la coordenada Y del local.
     * @return La coordenada Y del local.
     */
    public double getCoordenadaY(){
        return this.coordenadaY;
    }
    
    /**
     * Método de acceso para obtener el nombre del local.
     * @return El nombre del local.
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Método de acceso para obtener el horario del local.
     * @return El horario del local.
     */
    public String getHorario(){
        return this.horario;
    }
    
    /**
     * Método mutador para modificar la coordenada X del local.
     * @param coordenadaX La nueva coordenada X del local.
     */
    public void setCoordenadaX(double coordenadaX){
        this.coordenadaX = coordenadaX;
    }
    
    /**
     * Método mutador para modificar la coordenada Y del local.
     * @param coordenadaY La nueva coordenada Y del local.
     */
    public void setCoordenadaY(double coordenadaY){
        this.coordenadaY = coordenadaY;
    }
    
    /**
     * Método mutador para modificar el nombre del local.
     * @param nombre El nuevo nombre del local.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     * Método mutador para modificar el horario del local.
     * @param horario El nuevo horario del local.
     */
    public void setHorario(String horario){
        this.horario = horario;
    }
    
    /**
     * Método para obtener una representación en cadena de un objeto Local.
     * @return Una cadena que representa el objeto Local en el formato "Local {coordenadaX=..., coordenadaY=..., nombre=..., horario=...}".
     */
    @Override
    public String toString(){
        return "Local {coordenadaX=" + this.coordenadaX + ", coordenadaY=" + this.coordenadaY + ", nombre=" + this.nombre + ", horario=" + this.horario +"}";
    }
    
    public static void main(String[] args) {
        System.out.println(cargarLocales());
    }
}
