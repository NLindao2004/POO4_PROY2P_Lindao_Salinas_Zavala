/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import Clases.Base;
import Clases.IncompleteStageException;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC.1
 */
public class ArmaTuHelado1Controller implements Initializable {
    public static double valor = 0;
    private boolean btnYogurtSelected = false;
    private boolean btnHeladoSelected = false;
    private boolean btnVeganoSelected = false;
    public static ArrayList<String> orden = new ArrayList<>();
    @FXML
    private Label lblValorPagar;
    @FXML
    private Button btnContinuar;
    @FXML
    private Label lblYogurt;
    @FXML
    private Label lblHelado;
    @FXML
    private Label lblVegano;
    @FXML
    private Button btnYogurt;
    @FXML
    private Button btnHelado;
    @FXML
    private Button btnVegano;
    @FXML
    private ImageView imgArmaTuHelado1;
    @FXML 
    private Label message;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();
        precios();
    }    

    @FXML
    private void continuar(ActionEvent event) throws IOException {
        if (btnYogurtSelected) {
            orden.add("Base: Yogurt");
        }else if(btnHeladoSelected){
            orden.add("Base: Helado");
        }else if(btnVeganoSelected){
            orden.add("Base: Vegano");
        }
        try {
            if (btnYogurtSelected || btnHeladoSelected || btnVeganoSelected) {
                FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("ArmaTuHelado2.fxml"));
                    Parent root = fxmlloader.load();
                    Scene scene = new Scene(root, 730, 530);
                    Stage s = (Stage) btnContinuar.getScene().getWindow();
                    s.setScene(scene);
                    s.setTitle("ArmaTuHelado2");         
                    s.show();
            } else {
                throw new IncompleteStageException(); 
            }
        } catch (IncompleteStageException e) {
            message.setText(e.getMessage()); 
        } 
    }

    @FXML
    private void yogurt(ActionEvent event) {
        message.setText("");
        lblValorPagar.setText("Valor a pagar: "+lblYogurt.getText());
        valor = Double.parseDouble(lblYogurt.getText());
        btnYogurtSelected = true;
        
    }

    @FXML
    private void helado(ActionEvent event) {
        message.setText("");
        lblValorPagar.setText("Valor a pagar: "+lblHelado.getText());
        valor = Double.parseDouble(lblHelado.getText());
        btnHeladoSelected = true;
    }

    @FXML
    private void vegano(ActionEvent event) {
        message.setText("");
        lblValorPagar.setText("Valor a pagar: "+lblVegano.getText());
        valor = Double.parseDouble(lblVegano.getText());
        btnVeganoSelected = true;
    }
    
    public void mostrarImg(){        
            try(FileInputStream  input = new FileInputStream (Principal.path+"escena5.jpg")){
                Image image = new Image(input,730,530,false,false);
                imgArmaTuHelado1.setImage(image);             
            }catch(FileNotFoundException fn){

            }catch (Exception ex) {

            }
    }
    
    public void precios(){
        ArrayList<Base> lista = Base.cargarBase();
        for (Base base : lista) {
            if (base.getTipoBase().equals("yogurt")) {

                lblYogurt.setText(base.getPrecio());
            }else if(base.getTipoBase().equals("helado")){

                lblHelado.setText(base.getPrecio());
            }else if(base.getTipoBase().equals("vegano")){
                lblVegano.setText(base.getPrecio());
            }
        }
    }
}
