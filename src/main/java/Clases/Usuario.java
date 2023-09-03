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
 * La clase Usuario representa un usuario del sistema.
 */
public class Usuario {
    // Atributos de la clase Usuario.

    /**
     * Variables de instancia para almacenar el usuario, la contrasenia y el nombre del usuario.
     */
    private String usuario;


    private String contrasenia;

    private String nombre;

    /**
     * Constructor para inicializar un objeto Usuario.
     * @param usuario El nombre de usuario.
     * @param contrasenia La contraseña del usuario.
     * @param nombre El nombre del usuario.
     */
    public Usuario(String usuario, String contrasenia, String nombre) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
    }

    /**
     * Método estático para cargar usuarios desde un archivo de texto.
     * @return Una lista de objetos Usuario cargados desde el archivo "usuarios.txt".
     */
    public static ArrayList<Usuario> cargarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] lista = linea.split(",");
                String us = lista[0];
                String contra = lista[1];
                String nom = lista[2];
                Usuario u = new Usuario(us, contra, nom);
                usuarios.add(u);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        return usuarios;
    }

    /**
     * Obtiene el nombre de usuario.
     * @return El nombre de usuario.
     */
    public String getUsuario() {
        return this.usuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene una representación en cadena del objeto Usuario.
     * @return Una cadena que representa el usuario en el formato "Usuario {usuario=...}".
     */
    @Override
    public String toString() {
        return "Usuario {usuario=" + this.usuario + "}";
    }
}
