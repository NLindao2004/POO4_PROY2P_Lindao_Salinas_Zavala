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
import com.pooespol.proyecto2_heladeria.ArmaTuHelado4Controller;

/**
 * FXML Controller class
 *
 * @author PC.1
 */
public class EliminarComponenteController implements Initializable {
    
    private ArmaTuHelado4Controller armaTuHelado4Controller;
    
    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private ImageView imgEliminar;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();
    }   
    
    @FXML
    void aceptar(ActionEvent event)  {
        if (armaTuHelado4Controller != null) {
            armaTuHelado4Controller.handleEliminacionConfirmada();
        }
        Stage stage = (Stage) btnAceptar.getScene().getWindow();
    stage.close();

    // Cargar y mostrar la escena ArmaTuHelado4.fxml nuevamente
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(Principal.class.getResource("ArmaTuHelado4.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 730, 530);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("ArmaTuHelado4");
        primaryStage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

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
    
    public void mostrarImg(){        
        try(FileInputStream  input = new FileInputStream (Principal.path+"escena5.jpg")){
            Image image = new Image(input,340,230,false,false);
            imgEliminar.setImage(image);             
        }catch(FileNotFoundException fn){

        }catch (Exception ex) {

        }
    }
    
    public void setArmaTuHelado4Controller(ArmaTuHelado4Controller controller) {
        this.armaTuHelado4Controller = controller;
    }
}
