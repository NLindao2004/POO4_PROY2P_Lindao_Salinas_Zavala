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
    private Pane rootUbicaciones;
    
    private boolean bandera=true;
    
    private Thread inicio;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        iniciarTarea();
        
    }    
    
    public void iniciarTarea(){
        inicio = new Thread(()->{
            mostrarIcono();
        });
        inicio.start();
       
    }
    
    public Image obtenerImagen(){
        Image img=null;
        try (FileInputStream file = new FileInputStream(Principal.path + "icono.png")) {
                img = new Image(file, 45, 45, false, false);
            }catch(IOException io){
                System.out.println(io.getMessage());
            } 
        return img;
    }
    
    public void mostrarIcono() {
            ArrayList<Local> lista = Local.cargarLocales();
            Image img=obtenerImagen();

            for (Local l : lista) {
                    ImageView smallImageView = new ImageView(img);
                    Platform.runLater(() -> {
                        Stage s= (Stage)rootUbicaciones.getScene().getWindow();
                        s.setOnCloseRequest((event)->{
                            bandera=false;
                            inicio.interrupt();});
                        rootUbicaciones.getChildren().add(smallImageView);
                        smallImageView.setLayoutX(l.getCoordenadaX());
                        smallImageView.setLayoutY(l.getCoordenadaY());

                        smallImageView.setOnMouseClicked(event -> {
                            DetalleUbicacionController.nombre=l.getNombre();
                            DetalleUbicacionController.horario=l.getHorario();
                            mostrarEscena(); 
                        });

                    });
                    if(bandera){  
                        Random random = new Random();
                        int randomNumber = random.nextInt(10) + 1;
                        try {
                            Thread.sleep(1000 * randomNumber);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }else{
                        break;
                    }         
            }
    }
    
    public void mostrarEscena() {
    
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("DetalleUbicacion.fxml"));
        Parent root=null;
        try{
            root = fxmlloader.load();
        }catch(IOException io){
            System.out.println(io.getMessage());
        }
        Scene scene = new Scene(root);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.setTitle("Detalle Ubicación");
        stage.show();
    
        
    }

}
