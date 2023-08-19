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
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author PC.1
 */
public class BienvenidaController implements Initializable {


    @FXML
    private ImageView imgWelcome;
    @FXML
    private Label lblWelcome;
    @FXML
    private Button btnLocales;
    @FXML
    private Button btnPedido;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();
        msjWelcome();
    }    
    public void mostrarImg(){        
            try(FileInputStream  input = new FileInputStream (Principal.path+"heladoRosa.jpg")){
                Image image = new Image(input,730,530,false,false);
                imgWelcome.setImage(image);
                imgWelcome.setOpacity(0.8);
            }catch(FileNotFoundException fn){

            }catch (Exception ex) {

            }
    }

    @FXML
    private void encuentraLocales() throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("Ubicaciones.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root,730,495);   
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Locales");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void pedido() throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("ArmaTuHelado1.fxml"));
            Parent root = fxmlloader.load();
            Scene scene = new Scene(root, 730, 530);
            Stage s = (Stage) btnPedido.getScene().getWindow();
            s.setScene(scene);
            s.setTitle("ArmaTuHelado1");         
            s.show();
    }
    
    
    
    public void msjWelcome(){
        
        lblWelcome.setText("Bienvenido "+InicioController.name);
    }
}
