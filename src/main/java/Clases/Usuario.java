/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author PC.1
 */
public class Usuario {
    private String usuario;
    private String contrasenia;
    private String nombre;
    
    public Usuario(String usuario,String contrasenia,String nombre ){
        this.usuario=usuario;
        this.contrasenia=contrasenia;
        this.nombre=nombre;
    }
    
    public static ArrayList<Usuario> cargarUsuarios(){
        ArrayList<Usuario> usuarios= new ArrayList();
        try(BufferedReader br= new BufferedReader(new FileReader("usuarios.txt"))){
            String linea;
            while((linea=br.readLine())!= null){
                String[] lista= linea.split(",");
                String us= lista[0];
                String contra= lista[1];
                String nom= lista[2];
                Usuario u= new Usuario(us,contra,nom);
                usuarios.add(u);
                
            }
        }catch(FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }catch(IOException io){
            System.out.println(io.getMessage());
        }
        
        return usuarios;
    }
    
    
    public String getUsuario(){
        return this.usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String toString(){
        return "Usuario"+"{usuario="+this.usuario+"}";
    }
    
//    public static void main(String[] args) {
//        ArrayList<Usuario> lst = cargarUsuarios();
//        for (Usuario usuario : lst) {
//            System.out.println(usuario.getContrasenia());
//            System.out.println(usuario.getUsuario());
//        }
//
//          
//    }
        
}
