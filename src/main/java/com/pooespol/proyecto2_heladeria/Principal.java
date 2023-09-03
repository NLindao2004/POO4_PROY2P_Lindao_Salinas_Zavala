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
 * La clase Principal es la entrada principal de la aplicación JavaFX.
 * Extiende la clase Application y configura la ventana principal de la aplicación.
 */

public class Principal extends Application{
    private static Scene scene;
    /**
     * La ruta base para los recursos de la aplicación.
     */
    public static String path = "src/main/resources/com/pooespol/proyecto2_heladeria/";

    /**
     * El método start es el punto de inicio de la aplicación JavaFX.
     *
     * @param stage El escenario principal de la aplicación.
     * @throws IOException Si ocurre un error durante la carga de la interfaz gráfica.
     */
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
    
     /**
     * El método principal que inicia la aplicación.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        launch();
    }
    
}
