    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import Clases.IncompleteStageException;
import Clases.Sabor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import com.pooespol.proyecto2_heladeria.ArmaTuHelado1Controller;
/**
 * FXML Controller class
 *
 * @author PC.1
 */
public class ArmaTuHelado2Controller implements Initializable {

    private boolean cbx1Select = false;
    private boolean cbx2Select = false;
    private static double valorcb1 = 0;
    private static double valorcb2 = 0;
    public static double valor2 = 0;
    private String sabor_1 = null;
    private String sabor_2 = null;
    
    @FXML
    private ImageView imgArmaTuHelado2;
    @FXML
    private Label valorTotal;
    @FXML
    private ComboBox<Sabor> cb1;
    @FXML
    private ComboBox<Sabor> cb2;
    @FXML
    private Button btnContinuar;
    @FXML
    private Label message;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();
        cargarCB();
    }    
    
    public void mostrarImg(){        
            try(FileInputStream  input = new FileInputStream (Principal.path+"escena5.jpg")){
                Image image = new Image(input,730,530,false,false);
                imgArmaTuHelado2.setImage(image);             
            }catch(FileNotFoundException fn){

            }catch (Exception ex) {

            }
    }

    @FXML
    private void sabor1() {
        cbx1Select = true ;
        message.setText("");
        Sabor selectedItem = cb1.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            sabor_1 = "Sabor: "+selectedItem.getTipoSabor()+"-"+selectedItem.getPrecio();
            String precio = selectedItem.getPrecio();
            valorcb1 = Double.parseDouble(precio);
            Double total = ArmaTuHelado1Controller.valor+valorcb1+valorcb2;
            String formatted = String.format("%.2f", total);
            valor2= total;
            valorTotal.setText("Valor a pagar: "+formatted);
        }
    }

    @FXML
    private void sabor2() {
        cbx2Select = true;
        message.setText("");
        Sabor selectedItem = cb2.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            sabor_2 = "Sabor: "+selectedItem.getTipoSabor()+"-"+selectedItem.getPrecio();
            String precio = selectedItem.getPrecio();
            valorcb2 = Double.parseDouble(precio);
            Double total = ArmaTuHelado1Controller.valor+valorcb2+valorcb1;
            String formatted = String.format("%.2f", total);
            valor2= total;
            valorTotal.setText("Valor a pagar: "+formatted);
            }
    }

    @FXML
    private void continuar(ActionEvent event) throws IOException {
        saborSelect();
        try {
            if (cbx1Select || cbx2Select ) {
                FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("ArmaTuHelado3.fxml"));
                    Parent root = fxmlloader.load();
                    Scene scene = new Scene(root, 730, 530);
                    Stage s = (Stage) btnContinuar.getScene().getWindow();
                    s.setScene(scene);
                    s.setTitle("ArmaTuHelado3");         
                    s.show();
            } else {
                throw new IncompleteStageException(); 
            }
        } catch (IncompleteStageException e) {
            message.setText(e.getMessage()); 
        } 
    }
    
    public void cargarCB(){
        ArrayList<Sabor> lista= Sabor.cargarSabores();
        cb1.getItems().addAll(lista);
        cb2.getItems().addAll(lista);
        
    }
    
    public void saborSelect(){
        if (sabor_1 != null && sabor_2!= null) {
            ArmaTuHelado1Controller.orden.add(sabor_1);
            ArmaTuHelado1Controller.orden.add(sabor_2);
        }else if(sabor_2!= null){
            ArmaTuHelado1Controller.orden.add(sabor_2);
        }else if(sabor_1!= null){
            ArmaTuHelado1Controller.orden.add(sabor_1);
        }
    }
}
