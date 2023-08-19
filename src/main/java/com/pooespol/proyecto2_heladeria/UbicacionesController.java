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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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
        mostrarIcono();
        
    }    
    
    public void mostrarIcono() {
        Random random = new Random();
        ArrayList<Local> lista = Local.cargarLocales();
        Image image;
        try(FileInputStream file = new FileInputStream(Principal.path + "icono.png")) {
            image = new Image(file, 40, 40, false, false);
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }

        Thread thread = new Thread(() -> {
            for (Local local : lista) {
                ImageView img = new ImageView(image);
                

                Platform.runLater(() -> {
                    Button button = new Button("", img);
                    root.getChildren().add(button);
                    button.setLayoutX(local.getCoordenadaX());
                    button.setLayoutY(local.getCoordenadaY());
                });

                try {
                    Thread.sleep((random.nextInt(10) + 1) * 1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        thread.start();
    }
    
    
    
}
