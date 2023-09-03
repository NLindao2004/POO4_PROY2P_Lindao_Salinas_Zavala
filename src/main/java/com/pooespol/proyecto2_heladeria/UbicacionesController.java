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
 * La clase UbicacionesController es el controlador de la vista de ubicaciones.
 * Se encarga de mostrar iconos en el mapa y gestionar la selección de ubicaciones.
 */
public class UbicacionesController implements Initializable {
    
    /**
     * Panel que contiene los iconos de ubicación en el mapa.
     */
    @FXML
    private Pane rootUbicaciones;
    /**
     * Contenedor para establecer una imagen.
     */
    @FXML
    private ImageView imgviewFondo;
    /**
     * Variable para saber cuando la ventana fue cerrada e interrumpir el proceso(hilo)
     */
    private boolean bandera=true;
    /**
     *Hilo para mostrar los iconos de ubicación.
     */
    private Thread inicio;
    
    
   
    /**
     * Inicializa el controlador de la vista de ubicaciones.
     *
     * @param url       La URL base para cargar la vista (no utilizado en este caso).
     * @param rb Los recursos (no utilizado en este caso).
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setImagenFondo();
        iniciarTarea();
        
    }    
    
    /**
     * Inicia la tarea para mostrar los iconos de ubicación.
     */
    public void iniciarTarea(){
        inicio = new Thread(()->{
            mostrarIcono();
        });
        inicio.start();
       
    }
    
    /**
     * Obtiene una imagen para los iconos de ubicación.
     *
     * @return La imagen del icono de ubicación.
     */
    public Image obtenerIcono(){
        Image img=null;
        try (FileInputStream file = new FileInputStream(Principal.pathImages + "icono.png")) {
                img = new Image(file, 45, 45, false, false);
            }catch(IOException io){
                System.out.println(io.getMessage());
            } 
        return img;
    }
    
    /**
     * Obtiene una imagen para el ponerla de fondo.
     */
    public void setImagenFondo(){
        
        Image img=null;
        try (FileInputStream file = new FileInputStream(Principal.pathImages + "mapa2.png")) {
                img = new Image(file, 730, 495, false, false);
            }catch(IOException io){
                System.out.println(io.getMessage());
            } 
        imgviewFondo.setImage(img);
    }
    /**
     * Muestra los iconos de ubicación en el mapa y gestiona su selección.
     */
    public void mostrarIcono() {
            ArrayList<Local> lista = Local.cargarLocales();
            Image img=obtenerIcono();

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
    
    /**
     * Muestra la escena de detalle de ubicación.
     */
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
        stage.setResizable(false);
        stage.show();
    
        
    }

}
