/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import Clases.Sabor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC.1
 */
public class ArmaTuHelado2Controller implements Initializable {

    @FXML
    private ImageView imgArmaTuHelado2;
    @FXML
    private Label valorTotal;
    @FXML
    private ComboBox<Sabor> cb1;
    @FXML
    private ComboBox<Sabor> cb2;
    @FXML
    private Button btnContinuar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();
        cargarCB();
    }    
    
    public void mostrarImg(){        
            try(FileInputStream  input = new FileInputStream (Principal.path+"escena5.jpg")){
                Image image = new Image(input,730,530,false,false);
                imgArmaTuHelado2.setImage(image);             
            }catch(FileNotFoundException fn){

            }catch (Exception ex) {

            }
    }

    @FXML
    private void sabor1() {
        Sabor selectedItem = cb1.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void sabor2() {
        Sabor selectedItem = cb2.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void continuar(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("ArmaTuHelado3.fxml"));
            Parent root = fxmlloader.load();
            Scene scene = new Scene(root, 730, 530);
            Stage s = (Stage) btnContinuar.getScene().getWindow();
            s.setScene(scene);
            s.setTitle("ArmaTuHelado1");         
            s.show();
    }
    
    public void cargarCB(){
        ArrayList<Sabor> lista= Sabor.cargarSabores();
        cb1.getItems().addAll(lista);
        cb2.getItems().addAll(lista);
        
    }
}
