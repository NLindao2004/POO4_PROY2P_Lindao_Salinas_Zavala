/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import Clases.Sabor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
import javafx.stage.Stage;
import com.pooespol.proyecto2_heladeria.ArmaTuHelado3Controller;
import com.pooespol.proyecto2_heladeria.ArmaTuHelado1Controller;
import java.util.ArrayList;
import Clases.Topping;
import com.pooespol.proyecto2_heladeria.EliminarComponenteController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author PC.1
 */
public class ArmaTuHelado4Controller implements Initializable {

    ArrayList<String> lista = ArmaTuHelado1Controller.orden ;
    private  String cadenaTopping = null;
    private  String cadenaSabor = null;
    private  int selectedIndex = 0;
    String elementoSeleccionado = null;
    private ObservableList<String> items;
    
    
    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnEliminar;

    @FXML
    private ListView<String> pedido;

    @FXML
    private Label valorPagar;
    
    @FXML 
    private ImageView imgArmaTuHelado4;
    
    @FXML
    private Label message;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();
        valorFinal();
        cargarList();
        items = FXCollections.observableArrayList(cargarList());
        pedido.setItems(items);
        //modificarTopping(EliminarComponenteController.verification);
        
       
    }    
    
    
    public void mostrarImg(){        
        try(FileInputStream  input = new FileInputStream (Principal.path+"escena5.jpg")){
            Image image = new Image(input,730,530,false,false);
            imgArmaTuHelado4.setImage(image);             
        }catch(FileNotFoundException fn){

        }catch (Exception ex) {

        }
    }
    
    @FXML
    void confirmar(ActionEvent event) throws IOException {
        
    }

    @FXML
    void eliminar(ActionEvent event) throws IOException {
                
        String selectedItem = pedido.getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            String [] c = selectedItem.split(":"); 
            if(c[0].equals("Base")){
                message.setText("No puede eliminar una base");
            }else if(c[0].equals("Topping")){
                cadenaTopping = selectedItem;
                //selectedIndex = pedido.getSelectionModel().getSelectedIndex();
                
                elementoSeleccionado = pedido.getSelectionModel().getSelectedItem();
                
                FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("EliminarComponente.fxml"));
                try {
                    Parent root = fxmlloader.load();
                    Scene scene = new Scene(root, 340, 230);
                    Stage s = (Stage) btnEliminar.getScene().getWindow();
                    s.setScene(scene);
                    s.setTitle("EliminarComponente");
                    s.show();

                    // Obtener el controlador del cargador
                    EliminarComponenteController eliminarComponenteController = fxmlloader.getController();

                    // Pasar la referencia de este controlador a EliminarComponenteController
                    eliminarComponenteController.setArmaTuHelado4Controller(this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(c[0].equals("Sabor")){
                cadenaSabor = selectedItem;
                selectedIndex = pedido.getSelectionModel().getSelectedIndex();
                
//                  
            }
        }else{
            message.setText("Seleccione un elemento para eliminar");
        }    
    }
    
    @FXML
    void cancelar(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("CancelarCompra.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root, 340, 230);
        Stage s = (Stage) btnCancelar.getScene().getWindow();
        s.setScene(scene);
        s.setTitle("CancelarCompra");         
        s.show();
    }
    
    public void valorFinal(){
        Double valorF = ArmaTuHelado3Controller.valor3;
        String formatted = String.format("%.2f", valorF);
        valorPagar.setText("Valor a pagar: "+formatted);
    }

    public ArrayList<String> cargarList(){
        ArrayList<String> l = new ArrayList();
        for (String cadena : lista) {
            if (cadena.startsWith("Sabor:")) {
               String [] c = cadena.split("-");
               l.add(c[0]);
            }else if(cadena.startsWith("Base:")){
                l.add(cadena);
            }else if(cadena.startsWith("Topping:")){
                String [] c = cadena.split("-"); 
                l.add(c[0]);
                
            }
                     
        }
        return l;
    }
    
   
    
    public void handleEliminacionConfirmada() {
        
        // Coloca aquí la lógica que deseas ejecutar en ArmaTuHelado4Controller
        // después de que se confirme la eliminación en EliminarComponente.fxml
        if(cadenaTopping != null){
            ArrayList<Topping> lst = Topping.cargarSabores();
            String [] cadena = cadenaTopping.trim().split(":");
            String tp = cadena[1].trim();
            for (Topping t : lst) {
                if (tp.equals(t.getTipoTopping())) {
                    Double valorF = ArmaTuHelado3Controller.valor3 - t.getPrecio();
                    
                    String formatted = String.format("%.2f", valorF);
                    valorPagar.setText("Valor a pagar: "+formatted);
                    items.remove(elementoSeleccionado );
                }
            }
        }else if(cadenaSabor != null){
            ArrayList<Sabor> lst = Sabor.cargarSabores();
            String [] cadena = cadenaTopping.trim().split(":");
            for (Sabor s : lst) {
            if (cadena[1].equals(s.getTipoSabor())) {
                Double valorF = ArmaTuHelado3Controller.valor3 - Double.parseDouble(s.getPrecio());
                String formatted = String.format("%.2f", valorF);
                valorPagar.setText("Valor a pagar: "+formatted);
                pedido.getItems().remove(selectedIndex);
                }
            }
        }
    }
}
