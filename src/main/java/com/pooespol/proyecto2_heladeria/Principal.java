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
    public static String path = "src/main/resources/com/pooespol/proyecto2_heladeria/";
    @Override
    public void start(Stage stage) throws IOException{
        
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("Inicio.fxml"));
        Parent root = fxmlloader.load();
        scene = new Scene(root,730,530);
        stage.setScene(scene);
        stage.setTitle("Inicio");
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
    
}
