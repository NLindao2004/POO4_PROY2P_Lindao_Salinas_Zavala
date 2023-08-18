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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC.1
 */
public class InicioController implements Initializable {

    @FXML
    private ImageView imgInicio;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField user;
    @FXML
    private TextField password;
    @FXML
    private Label message;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();
    }    
    
    public void mostrarImg(){
        try(FileInputStream  input = new FileInputStream (Principal.path+"inicio3.jpg")){
            Image image = new Image(input,730,530,false,false);
            imgInicio.setImage(image);
        }catch(FileNotFoundException fn){
            
        }catch (Exception ex) {
            
        }
    }

    @FXML
    private void login(){
        Platform.runLater(new Runnable(){
        public void run(){
                ArrayList<Usuario> lista = Usuario.cargarUsuarios();
            if (("".equals(user.getText())) || ("".equals(password.getText()))) {
                message.setText("LLene los campos vacios");
            }else {
                for (Usuario u : lista) {
                    if (u.getUsuario().equals(user.getText()) && u.getContrasenia().equals(password.getText())) {
                        try {
                            Bienvenida();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                message.setText("usuario o contrseña incorrecto");
            }
            }
        });
    }
    

    public void Bienvenida() throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("Escena1.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root,730,530);
        Stage s = (Stage)btnLogin.getScene().getWindow();
        s.setScene(scene);
        s.setTitle("Bienvenida");
        s.setResizable(false);
        s.show();
    }
}
