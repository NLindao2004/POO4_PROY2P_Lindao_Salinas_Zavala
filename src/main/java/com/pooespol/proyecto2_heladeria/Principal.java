/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author PC.1
 */
public class Principal extends Application{
    private static Scene scene;
    
    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("FXML.fxml"));
        Parent root = fxmlloader.load();
        scene = new Scene(root,600,740);
        stage.setScene(scene);
        stage.setTitle("");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
