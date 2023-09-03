/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
 * FXML Controller class
 *
 * @author PC.1
 */
public class DetalleUbicacionController implements Initializable {


    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lblTiempo;
    @FXML
    private Button btnSalir;
    @FXML
    private Pane rootPopUp;
 
    
    private Thread t1;
    private boolean bandera=true;
    public static String nombre;
    public static String horario;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarTarea();
          
    
    }    
    
    @FXML
    private void salir(ActionEvent event) {
        Stage s = (Stage)btnSalir.getScene().getWindow();
        s.close();
    }
    
    public void iniciarTarea(){
        t1= new Thread(()->{
            tiempo();
        });
        t1.start();
    }
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
