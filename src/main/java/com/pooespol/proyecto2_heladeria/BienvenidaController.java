/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Controlador para la vista Bienvenida.fxml.
 */
public class BienvenidaController implements Initializable {

    /**
     * ImageView para mostrar una imagen de bienvenida.
     */
    @FXML
    private ImageView imgWelcome;
    /**
     * Etiqueta para mostrar un mensaje de bienvenida personalizado.
     */
    @FXML
    private Label lblWelcome;
    /**
     * Botón para acceder a la vista de ubicaciones de locales.
     */
    @FXML
    private Button btnLocales;
    /**
     * Botón para acceder a la vista de armar un helado.
     */
    @FXML
    private Button btnPedido;
    
    
    /**
     * Inicializa el controlador.
     *
     * @param url Ubicación del archivo FXML.
     * @param rb  Recursos utilizados para la inicialización.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();
        msjWelcome();
        mostarPopUp();
    }

    /**
     * Muestra una imagen en el ImageView `imgWelcome`.
     */
    public void mostrarImg(){        
            try(FileInputStream  input = new FileInputStream (Principal.path+"heladoRosa.jpg")){
                Image image = new Image(input,730,530,false,false);
                imgWelcome.setImage(image);
                imgWelcome.setOpacity(0.8);
            }catch(FileNotFoundException fn){

            }catch (Exception ex) {

            }
    }
    
     /**
     * Abre una ventana para encontrar locales.
     *
     * @throws IOException Si hay un error al cargar la vista.
     */
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
    
    /**
     * Abre una ventana para armar un pedido de helado.
     *
     * @throws IOException Si hay un error al cargar la vista.
     */
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
    
    
    /**
     * Muestra un mensaje de bienvenida personalizado.
     */
    public void msjWelcome(){
        
        lblWelcome.setText("Bienvenido "+InicioController.name);
    }

    
    /**
     * Muestra un ListView en una ventana emergente que se actualiza periódicamente.
     */
    public void mostarPopUp(){
        Stage stage = new Stage();
        HBox hb = new HBox();
        Scene scene = new Scene(hb, 250, 150);
        ListView<String> listView = new ListView<>();
        hb.getChildren().addAll(listView);

        ObservableList<String> items = FXCollections.observableArrayList();
        listView.setItems(items);

        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

        Thread actualizarThread = new Thread(() -> {
            while (true) {
                try {
                    ArrayList<String> lista = new ArrayList<>();
                    try (BufferedReader br = new BufferedReader(new FileReader("pagos.txt"))) {
                        String linea;
                        while ((linea = br.readLine()) != null) {
                            String[] cadena = linea.split(",");
                            String pedido = cadena[2] + "," + cadena[1];
                            lista.add(pedido);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(() -> {
                        items.setAll(lista);
                    });

                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        actualizarThread.setDaemon(true); 
        actualizarThread.start();
    }
    
}
