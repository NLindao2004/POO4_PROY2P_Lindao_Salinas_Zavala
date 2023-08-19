/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author PC.1
 */
public class DetalleUbicacionController implements Initializable {


    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Button btnSalir;
    @FXML
    private Pane root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();    
    
    }    
    
    @FXML
    private void salir(ActionEvent event) {
        Stage s = (Stage)btnSalir.getScene().getWindow();
        s.close();
    }
    
    public void mostrarImg(){        
            try(FileInputStream  input = new FileInputStream (Principal.path+"heladoRosa.jpg")){
                Image image = new Image(input,730,530,false,false);
                ImageView ImageView = new ImageView(image);
                root.getChildren().add(ImageView);
            }catch(FileNotFoundException fn){

            }catch (Exception ex) {

            }
    }
}
