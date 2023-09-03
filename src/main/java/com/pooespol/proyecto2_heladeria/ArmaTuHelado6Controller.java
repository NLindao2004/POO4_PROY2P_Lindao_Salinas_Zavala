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
 * FXML Controller class
 *
 * @author PC.1
 */
public class ArmaTuHelado6Controller implements Initializable {
    
    @FXML
    private ImageView img;
    
    @FXML
    private ImageView imgArmaTuHelado6;

    @FXML
    private Label lblCierre;

    @FXML
    private Label lblPedido;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();
        mostrarImg2();
        hilo();
        lblPedido.setText("Tu pedido es el #"+ArmaTuHelado4Controller.idPd+". Te llamaremos cuando este listo");
    }    
    
    public void mostrarImg(){        
        try(FileInputStream  input = new FileInputStream (Principal.path+"escena5.jpg")){
            Image image = new Image(input,730,530,false,false);
            imgArmaTuHelado6.setImage(image);             
        }catch(FileNotFoundException fn){

        }catch (Exception ex) {

        }
        
    }
    
    public void mostrarImg2(){        
        try(FileInputStream  input = new FileInputStream (Principal.path+"Carrito_Helados.gif")){
            Image image = new Image(input);
            img.setImage(image);             
        }catch(FileNotFoundException fn){

        }catch (Exception ex) {

        }
        
    }
    
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

    
    
    public void orden(){
        lblPedido.setText("");
    }
    
     
     
        
        
}
