/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Controlador para la vista CancelarCompra.fxml.
 */
public class CancelarCompraController implements Initializable {
    
    /**
     * Botón para cancelar la compra.
     */
    @FXML
    private Button btnCancelar;
    /**
     * Botón para aceptar la cancelación.
     */
    @FXML
    private Button btnAceptar;
    /**
     * ImageView para mostrar una imagen de cancelación.
     */
    @FXML 
    private ImageView imgCancelar;    
    
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
     * Maneja el evento de cancelación y vuelve a la vista ArmaTuHelado4.fxml.
     *
     * @param event Evento de acción.
     * @throws IOException Si hay un error al cargar la vista.
     */
    @FXML
    void cancelar(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("ArmaTuHelado4.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root, 730, 530);
        Stage s = (Stage) btnCancelar.getScene().getWindow();
        s.setScene(scene);
        s.setTitle("ArmaTuHelado4");         
        s.show();
    }
    
    /**
     * Maneja el evento de aceptar y sale de la aplicación.
     *
     * @param event Evento de acción.
     */
    @FXML
    void aceptar(ActionEvent event) {
        Platform.exit();
    }
 
    /**
     * Muestra una imagen en el ImageView `imgCancelar`.
     */
    public void mostrarImg(){        
        try(FileInputStream  input = new FileInputStream (Principal.path+"escena5.jpg")){
            Image image = new Image(input,340,230,false,false);
            imgCancelar.setImage(image);             
        }catch(FileNotFoundException fn){

        }catch (Exception ex) {

        }
    }
}
