/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 * Controlador para la vista ArmaTuHelado6.fxml.
 */
public class ArmaTuHelado6Controller implements Initializable {
    
    /**
     * ImageView para mostrar una imagen.
     */
    @FXML
    private ImageView img;
    /**
     * ImageView para mostrar otra imagen.
     */
    @FXML
    private ImageView imgArmaTuHelado6;
    /**
     * Etiqueta para mostrar el mensaje de cierre de ventana.
     */
    @FXML
    private Label lblCierre;
    /**
     * Etiqueta para mostrar información sobre el pedido.
     */
    @FXML
    private Label lblPedido;
    
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
        mostrarImg2();
        hilo();
        lblPedido.setText("Tu pedido es el #"+ArmaTuHelado4Controller.idPd+". Te llamaremos cuando este listo");
    }    
    
     /**
     * Muestra una imagen en el ImageView `imgArmaTuHelado6`.
     */
    public void mostrarImg(){        
        try(FileInputStream  input = new FileInputStream (Principal.path+"escena5.jpg")){
            Image image = new Image(input,730,530,false,false);
            imgArmaTuHelado6.setImage(image);             
        }catch(FileNotFoundException fn){

        }catch (Exception ex) {

        }
        
    }
    
     /**
     * Muestra una imagen en el ImageView `img`.
     */
    public void mostrarImg2(){        
        try(FileInputStream  input = new FileInputStream (Principal.path+"Carrito_Helados.gif")){
            Image image = new Image(input);
            img.setImage(image);             
        }catch(FileNotFoundException fn){

        }catch (Exception ex) {

        }
        
    }
    
    /**
     * Ejecuta un hilo que cuenta hacia atrás y cierra la ventana después de cierto tiempo.
     */
    public void hilo() {
        Thread hilo = new Thread(() -> {
            for (int i = 5; i > 0; i--) { 
                final int finalI = i;

                Platform.runLater(() -> {
                    lblCierre.setText("Esta ventana se cerrará en " + finalI + " segundos");
                });

                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                   
                    e.printStackTrace();
                }
            }

            Platform.runLater(() -> {
                lblCierre.setText("Cerrando ventana...");
            });

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Platform.runLater(() -> {
                Stage stage = (Stage) lblCierre.getScene().getWindow();
                stage.close();
            });
        });

        hilo.start();
    }

    
    /**
     * Elimina el texto de la etiqueta `lblPedido`.
     */
    public void orden(){
        lblPedido.setText("");
    }
    
     
     
        
        
}
