/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import Clases.Local;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.pooespol.proyecto2_heladeria.Principal;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Math.random;
import java.util.Random;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author PC.1
 */
public class UbicacionesController implements Initializable {

    @FXML
    private Pane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        iniciarTarea();
        
    }    
    
    public void iniciarTarea(){
        Thread inicio = new Thread(new Runnable(){
            public void run(){
                mostrarIcono();
            }
        });
        inicio.start();
    }
    
    public void mostrarIcono() {
    ArrayList<Local> lista = Local.cargarLocales();

        for (Local l : lista) {
            try (FileInputStream file = new FileInputStream(Principal.path + "icono.png")) {
                Image image = new Image(file, 45, 45, false, false);
                ImageView smallImageView = new ImageView(image);
                
                Platform.runLater(() -> {
                root.getChildren().add(smallImageView);
                smallImageView.setLayoutX(l.getCoordenadaX());
                smallImageView.setLayoutY(l.getCoordenadaY());
                smallImageView.setOnMouseClicked(event -> {
                    mostrarEscena(); 
                });
                
                });

                Random random = new Random();
                int randomNumber = random.nextInt(10) + 1;

                try {
                    Thread.sleep(1000 * randomNumber);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void mostrarEscena() {
    try {
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("DetalleUbicacion.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
}
