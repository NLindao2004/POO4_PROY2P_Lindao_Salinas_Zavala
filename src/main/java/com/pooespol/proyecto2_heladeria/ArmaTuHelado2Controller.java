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
import java.util.Locale;
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
 * El controlador para la escena "ArmaTuHelado2".
 */
public class ArmaTuHelado2Controller implements Initializable {
    // Atributos de la clase ArmaTuHelado2Controller.

    /**
     * Bandera para verificar si se seleccionó el primer sabor.
     */
    private boolean cbx1Select = false;
    
    /**
     * Bandera para verificar si se seleccionó el segundo sabor.
     */
    private boolean cbx2Select = false;
    
    /**
     * Valor del primer sabor seleccionado.
     */
    private static double valorcb1 = 0;
    
    /**
     * Valor del segundo sabor seleccionado.
     */
    private static double valorcb2 = 0;
    
    /**
     * Valor total de la orden.
     */
    public static double valor2 = 0;
    
    /**
     * Nombre del primer sabor seleccionado.
     */
    private String sabor_1 = null;
    
    /**
     * Nombre del segundo sabor seleccionado.
     */
    private String sabor_2 = null;
    
    /**
     * ImagenView para mostrar una imagen en la interfaz gráfica.
     */
    @FXML
    private ImageView imgArmaTuHelado2;

    /**
     * Etiqueta para mostrar el valor total de la orden.
     */
    @FXML
    private Label valorTotal;

    /**
     * ComboBox para seleccionar el primer sabor.
     */
    @FXML
    private ComboBox<Sabor> cb1;

    /**
     * ComboBox para seleccionar el segundo sabor.
     */
    @FXML
    private ComboBox<Sabor> cb2;

    /**
     * Botón para continuar con la selección de sabores.
     */
    @FXML
    private Button btnContinuar;

    /**
     * Etiqueta para mostrar mensajes de error o información.
     */
    @FXML
    private Label message;

    /**
     * Inicializa el controlador.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarImg();
        cargarCB();
    }    
    
    /**
     * Método para mostrar la imagen en la interfaz.
     */
    public void mostrarImg(){        
        try(FileInputStream  input = new FileInputStream (Principal.pathImages+"escena5.jpg")){
            Image image = new Image(input, 730, 530, false, false);
            imgArmaTuHelado2.setImage(image);             
        } catch(FileNotFoundException fn) {

        } catch (Exception ex) {

        }
    }

    /**
     * Método que se ejecuta al seleccionar el primer sabor.
     */
    @FXML
    private void sabor1() {
        cbx1Select = true ;
        message.setText("");
        Sabor selectedItem = cb1.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            sabor_1 = "Sabor: "+selectedItem.getTipoSabor()+"-"+selectedItem.getPrecio();
            String precio = selectedItem.getPrecio();
            valorcb1 = Double.parseDouble(precio);
            Double total = ArmaTuHelado1Controller.valor + valorcb1 + valorcb2;
            String formatted = String.format(Locale.US,"%.2f", total);
            valor2 = total;
            valorTotal.setText("Valor a pagar: "+formatted);
        }
    }

    /**
     * Método que se ejecuta al seleccionar el segundo sabor.
     */
    @FXML
    private void sabor2() {
        cbx2Select = true;
        message.setText("");
        Sabor selectedItem = cb2.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            sabor_2 = "Sabor: "+selectedItem.getTipoSabor()+"-"+selectedItem.getPrecio();
            String precio = selectedItem.getPrecio();
            valorcb2 = Double.parseDouble(precio);
            Double total = ArmaTuHelado1Controller.valor + valorcb2 + valorcb1;
            String formatted = String.format(Locale.US,"%.2f", total);
            valor2 = total;
            valorTotal.setText("Valor a pagar: "+formatted);
        }
    }

    /**
     * Método que se ejecuta al hacer clic en el botón "Continuar".
     * @param event El evento de acción.
     * @throws IOException Si ocurre un error al cargar la siguiente escena.
     */
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
    
    /**
     * Método para cargar los sabores en los ComboBox.
     */
    public void cargarCB(){
        ArrayList<Sabor> lista= Sabor.cargarSabores();
        cb1.getItems().addAll(lista);
        cb2.getItems().addAll(lista);
    }
    
    /**
     * Método para agregar los sabores seleccionados a la orden.
     */
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
