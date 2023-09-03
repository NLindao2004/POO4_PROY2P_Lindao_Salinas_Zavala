/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import Clases.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 * Controlador para la vista Inicio.fxml.
 */
public class InicioController implements Initializable {
    
    /**
     * Almacena el nombre del usuario autenticado.
     */
    public static String name;
    /**
     * ImageView para mostrar una imagen.
     */
    @FXML
    private ImageView imgInicio;
    /**
     * Botón para iniciar sesión.
     */
    @FXML
    private Button btnLogin;
    /**
     * Campo de texto para el nombre de usuario.
     */
    @FXML
    private TextField user;
    /**
     *Campo de texto para la contraseña.
     */
    @FXML
    private PasswordField password;
    /**
     * Etiqueta para mostrar mensaje de confirmacion al usuario.
     */
    @FXML
    private Label message;

    /**
     * Inicializa el controlador.
     *
     * @param url Ubicación del archivo FXML.
     * @param rb  Recursos utilizados para la inicialización.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();
    }    
    
    /**
     * Muestra una imagen en el ImageView.
     */
    public void mostrarImg(){        
            try(FileInputStream  input = new FileInputStream (Principal.pathImages+"inicio3.jpg")){
                Image image = new Image(input,730,530,false,false);
                imgInicio.setImage(image);
            }catch(FileNotFoundException fn){

            }catch (Exception ex) {

            }
    }
    
    /**
     * Maneja el evento de inicio de sesión.
     */
    @FXML
    private void login(){
        if (user.getText().isEmpty() || password.getText().isEmpty()) {
            message.setText("Llene los campos vacíos");
        } else if(validation()){
            Bienvenida();
        }else{
            message.setText("Contrseña o usuario incorrecta");
        }
    }
    
    /**
     * Valida las credenciales del usuario.
     *
     * @return true si las credenciales son válidas, false de lo contrario.
     */
    public boolean validation() {
        ArrayList<Usuario> lista = Usuario.cargarUsuarios();
        for (Usuario u : lista) {
            if ((user.getText().equals(u.getUsuario())) && (password.getText().equals(u.getContrasenia()))) {
                name = u.getNombre();
                return true;
                
            }
        }
        return false;
    }
    
     /**
     * Redirige a la vista de bienvenida después de iniciar sesión con éxito.
     */
    public void Bienvenida() {
        try {
            FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("Bienvenida.fxml"));
            Parent root = fxmlloader.load();
            Scene scene = new Scene(root, 730, 530);
            Stage s = (Stage) btnLogin.getScene().getWindow();
            s.setScene(scene);
            s.setTitle("Bienvenida");         
            s.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    


}
