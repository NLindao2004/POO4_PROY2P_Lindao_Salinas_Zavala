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
 * El controlador para la escena "ArmaTuHelado1".
 */
public class ArmaTuHelado1Controller implements Initializable {
    // Atributos de la clase ArmaTuHelado1Controller.

    /**
     * Valor utilizado para almacenar el precio total.
     */
    public static double valor = 0;
    
    /**
     * Bandera para verificar si se seleccionó la opción de yogurt como base.
     */
    private boolean btnYogurtSelected = false;
    
    /**
     * Bandera para verificar si se seleccionó la opción de helado como base.
     */
    private boolean btnHeladoSelected = false;
    
    /**
     * Bandera para verificar si se seleccionó la opción vegano como base.
     */
    private boolean btnVeganoSelected = false;
    
    /**
     * Lista para almacenar la orden de productos seleccionados.
     */
    public static ArrayList<String> orden = new ArrayList<>();
    
    /**
 * Etiqueta para mostrar el valor a pagar.
 */
    @FXML
    private Label lblValorPagar;

    /**
     * Botón para continuar con la selección de productos.
     */
    @FXML
    private Button btnContinuar;

    /**
     * Etiqueta para mostrar el precio de la opción de yogurt como base.
     */
    @FXML
    private Label lblYogurt;

    /**
     * Etiqueta para mostrar el precio de la opción de helado como base.
     */
    @FXML
    private Label lblHelado;

    /**
     * Etiqueta para mostrar el precio de la opción vegano como base.
     */
    @FXML
    private Label lblVegano;

    /**
     * Botón para seleccionar la opción de yogurt como base.
     */
    @FXML
    private Button btnYogurt;

    /**
     * Botón para seleccionar la opción de helado como base.
     */
    @FXML
    private Button btnHelado;

    /**
     * Botón para seleccionar la opción vegano como base.
     */
    @FXML
    private Button btnVegano;

    /**
     * Imagen para mostrar en la interfaz gráfica.
     */
    @FXML
    private ImageView imgArmaTuHelado1;

    /**
     * Etiqueta para mostrar mensajes de error o información.
     */
    @FXML 
    private Label message;

    /**
     * Inicializa el controlador.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarImg();
        precios();
    }    

    /**
     * Método que se ejecuta al hacer clic en el botón "Continuar".
     * @param event El evento de acción.
     * @throws IOException Si ocurre un error al cargar la siguiente escena.
     */
    @FXML
    private void continuar(ActionEvent event) throws IOException {
        if (btnYogurtSelected) {
            orden.add("Base: Yogurt");
        } else if (btnHeladoSelected) {
            orden.add("Base: Helado");
        } else if (btnVeganoSelected) {
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

    /**
     * Método que se ejecuta al hacer clic en el botón "Yogurt".
     * @param event El evento de acción.
     */
    @FXML
    private void yogurt(ActionEvent event) {
        message.setText("");
        lblValorPagar.setText("Valor a pagar: " + lblYogurt.getText());
        valor = Double.parseDouble(lblYogurt.getText());
        btnYogurtSelected = true;
    }

    /**
     * Método que se ejecuta al hacer clic en el botón "Helado".
     * @param event El evento de acción.
     */
    @FXML
    private void helado(ActionEvent event) {
        message.setText("");
        lblValorPagar.setText("Valor a pagar: " + lblHelado.getText());
        valor = Double.parseDouble(lblHelado.getText());
        btnHeladoSelected = true;
    }

    /**
     * Método que se ejecuta al hacer clic en el botón "Vegano".
     * @param event El evento de acción.
     */
    @FXML
    private void vegano(ActionEvent event) {
        message.setText("");
        lblValorPagar.setText("Valor a pagar: " + lblVegano.getText());
        valor = Double.parseDouble(lblVegano.getText());
        btnVeganoSelected = true;
    }
    
    /**
     * Método para mostrar la imagen en la interfaz.
     */
    public void mostrarImg(){        
        try(FileInputStream  input = new FileInputStream (Principal.path+"escena5.jpg")){
            Image image = new Image(input, 730, 530, false, false);
            imgArmaTuHelado1.setImage(image);             
        } catch(FileNotFoundException fn) {

        } catch (Exception ex) {

        }
    }
    
    /**
     * Método para cargar los precios de las bases desde el archivo.
     */
    public void precios(){
        ArrayList<Base> lista = Base.cargarBase();
        for (Base base : lista) {
            if (base.getTipoBase().equals("yogurt")) {
                lblYogurt.setText(base.getPrecio());
            } else if (base.getTipoBase().equals("helado")) {
                lblHelado.setText(base.getPrecio());
            } else if (base.getTipoBase().equals("vegano")) {
                lblVegano.setText(base.getPrecio());
            }
        }
    }
}
