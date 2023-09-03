/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Controlador para la vista DetalleUbicacion.fxml.
 */
public class DetalleUbicacionController implements Initializable {

    /**
     * Etiqueta para mostrar nombre ubicacion.
     */
    @FXML
    private Label lbl1;
    /**
     * Etiqueta para mostrar nombre horario.
     */
    @FXML
    private Label lbl2;
    /**
     * Etiqueta para mostrar tiempo restante antes de cerrarse la ventana.
     */
    @FXML
    private Label lblTiempo;
    /**
     * Botón para salir de la vista.
     */
    @FXML
    private Button btnSalir;
    /**
     * Panel principal de la ventana emergente.
     */
    @FXML
    private Pane rootPopUp;
    /**
     * Contenedor para establecer una imagen.
     */
    @FXML
    private ImageView imgviewFondo;
 
    /**
     * Hilo para la actualización del tiempo de cierre.
     */
    private Thread t1;
    /**
     * Bandera para interrumpir el proceso del hilo cuando se cierra la ventana.
     */
    private boolean bandera=true;
    /**
     * Nombre de la ubicación.
     */
    public static String nombre;
    /**
     * Horario de la ubicación.
     */
    public static String horario;
    
    
    /**
     * Inicializa el controlador.
     *
     * @param url Ubicación del archivo FXML.
     * @param rb  Recursos utilizados para la inicialización.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setImagenFondo();
        iniciarTarea();
          
    
    }    
    
    /**
     * Maneja el evento de salida de la vista.
     *
     * @param event Evento de acción.
     */
    @FXML
    private void salir(ActionEvent event) {
        Stage s = (Stage)btnSalir.getScene().getWindow();
        s.close();
    }
    
    /**
     * Obtiene una imagen para el ponerla de fondo.
     */
    public void setImagenFondo(){
        
        Image img=null;
        try (FileInputStream file = new FileInputStream(Principal.pathImages + "heladoRosa.jpg")) {
                img = new Image(file, 300, 250, false, false);
            }catch(IOException io){
                System.out.println(io.getMessage());
            } 
        imgviewFondo.setImage(img);
    }
    
     /**
     * Inicia la tarea de actualización del tiempo.
     */
    public void iniciarTarea(){
        t1= new Thread(()->{
            tiempo();
        });
        t1.start();
    }
    
    /**
     * Actualiza el tiempo de cierre y muestra la información en las etiquetas.
     */
    public void tiempo(){
        for (int i=5;i>=0;i--){
            String t= String.valueOf(i);
            Platform.runLater(()->{
                Stage s= (Stage)rootPopUp.getScene().getWindow();
                s.setOnCloseRequest((event)->{
                    bandera=false;
                    t1.interrupt();});
                if(t.equals("0")){
                    salir(new ActionEvent());
                }
                lbl1.setText(nombre);
                lbl2.setText(horario);
                lblTiempo.setText(t); 
            });
            if(bandera){
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException in){
                    System.out.println(in.getMessage());
                }
            }else{
                break;
            }
        }
      
       
        
        
    }//Fin Metodo tiempo
    
    
    
 
}//Fin clase
