    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import Clases.Pedido;
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
import java.util.ArrayList;
import Clases.Topping;
import java.util.Locale;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.StageStyle;


/**
 * Controlador para la vista ArmaTuHelado4.fxml.
 */
public class ArmaTuHelado4Controller implements Initializable {

     /**
     * Lista de elementos seleccionados en la orden del usuario.
     */
    ArrayList<String> lista = ArmaTuHelado1Controller.orden ;
    /**
     * Índice seleccionado en la lista de elementos.
     */
    private  int selectedIndex = 0;
     /**
     * Lista observable para mostrar los elementos seleccionados en la vista.
     */
    private ObservableList<String> items;
    /**
     * Valor total a pagar por la orden.
     */
    public static double ValorPagar =ArmaTuHelado3Controller.valor3;
    /**
     * ID único del pedido.
     */
    public static String idPd = null;       
 
    /**
     * Botón para cancelar el proceso.
     */
    @FXML
    private Button btnCancelar;
    
    
    /**
     * Botón para confirmar el pedido.
     */
    @FXML
    private Button btnConfirmar;

    /**
     * Botón para eliminar elementos de la orden.
     */
    @FXML
    private Button btnEliminar;
    
    /**
     * Lista de elementos seleccionados.
     */
    @FXML
    private ListView<String> pedido; 
    
    /**
     * Etiqueta que muestra el valor total a pagar.
     */
    @FXML
    private Label valorPagar; 
    
    /**
     * Imagen de fondo.
     */
    @FXML 
    private ImageView imgArmaTuHelado4; 
    
    /**
     * Etiqueta para mostrar mensajes de validación.
     */
    @FXML 
    private Label message;  
    
    /**
     * Inicializa el controlador y configura la vista.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();
        valorFinal();
        cargarList();
        items = FXCollections.observableArrayList(cargarList());
        pedido.setItems(items);
        btnEliminar.setOnAction(e->{
            validation();
        });
    
        
       
    }    
    
    /**
     * Muestra una imagen en la vista.
     */
    public void mostrarImg(){        
        try(FileInputStream  input = new FileInputStream (Principal.pathImages+"escena5.jpg")){
            Image image = new Image(input,730,530,false,false);
            imgArmaTuHelado4.setImage(image);             
        }catch(FileNotFoundException fn){

        }catch (Exception ex) {

        }
    }
    
    /**
     * Maneja el evento de confirmación de la orden.
     */
    @FXML
    void confirmar(ActionEvent event) throws IOException{
        guardarPedido();
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("ArmaTuHelado5.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root, 730, 530);
        Stage s = (Stage) btnConfirmar.getScene().getWindow();
        s.setScene(scene);
        s.setTitle("ArmaTuHelado5");         
        s.show();

    }

    
    /**
     * Maneja el evento de cancelación de la orden.
     */
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
    
    /**
     * Calcula el valor total a pagar y lo muestra en la vista.
     */
    public void valorFinal(){
        Double valorF = ArmaTuHelado3Controller.valor3;
        String formatted = String.format(Locale.US,"%.2f", valorF);
        valorPagar.setText("Valor a pagar: "+formatted);
    }
    
    /**
     * Carga la lista de elementos de la orden.
     * @return ArrayList con los elementos de la orden.
     */
    
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
    
    /**
     * Muestra un cuadro de diálogo de confirmación antes de eliminar un elemento de la orden.
     * @param valor El valor total después de eliminar el elemento.
     */
    private void mostrarPopUp(String valor) {
        Stage popUp = new Stage();
        popUp.initModality(Modality.APPLICATION_MODAL);
        popUp.initStyle(StageStyle.UTILITY);
        popUp.setTitle("Confirmar Eliminación");

        Label label = new Label("¿Está seguro de cancelar su compra?");
        Button botonConfirmar = new Button("Confirmar");
        Button botonCancelar = new Button("Cancelar");

        botonConfirmar.setOnAction(e -> {
            message.setText("");
            items.remove(selectedIndex);
            valorPagar.setText("Valor a pagar: "+valor);
            popUp.close();
        });
        botonCancelar.setOnAction(e -> {
            popUp.close();
        });
        VBox vbox = new VBox(10);
        HBox hb = new HBox(10);
        hb.getChildren().addAll(botonConfirmar,botonCancelar);
        vbox.getChildren().addAll(label, hb);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        hb.setAlignment(javafx.geometry.Pos.CENTER);
        Scene popUpScene = new Scene(vbox, 300, 150);
        popUp.setScene(popUpScene);
        popUp.showAndWait();
    }
   
    
    /**
     * Valida y maneja la eliminación de elementos de la orden.
     */
    private void validation(){
        String selectedItem = pedido.getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            String [] c = selectedItem.split(":"); 
            switch (c[0]) {
                case "Base":
                    message.setText("No puede eliminar una base");
                    break;
                case "Topping":
                    selectedIndex = pedido.getSelectionModel().getSelectedIndex();
                    ObservableList<String> lst = pedido.getItems();
                    String [] cadena = lst.get(selectedIndex).split(":");
                    String tp = cadena[1].trim();                   
                    ArrayList<Topping> lstTp = Topping.cargarSabores();
                    String resta = null;
                    for (Topping t : lstTp) {
                        if (tp.equals(t.getTipoTopping())) {
                        ValorPagar = ValorPagar - t.getPrecio();   
                        resta = String.format(Locale.US,"%.2f", ValorPagar);                      
                        }
                    }
                    mostrarPopUp(resta);
                    break;
                case "Sabor":
                    selectedIndex = pedido.getSelectionModel().getSelectedIndex();                  
                    ObservableList<String> lst1 = pedido.getItems();
                    String [] cadena1 = lst1.get(selectedIndex).split(":");
                    String sabor = cadena1[1].trim();
                    int contador = 0;
                    for (String string : lst1) {
                        String [] sb = string.split(":"); 
                        if (sb[0].equals("Sabor")) {
                            contador++;
                        }
                    }
                    if (contador==2) {
                        ArrayList<Sabor> lstSb = Sabor.cargarSabores();
                        String resta1 = null;
                        for (Sabor S : lstSb) {
                            if (sabor.equals(S.getTipoSabor())) {
                                ValorPagar = ValorPagar - Double.parseDouble(S.getPrecio());
                                resta1 = String.format(Locale.US,"%.2f", ValorPagar);                      
                            }
                        }
                        mostrarPopUp(resta1);  
                    }else{message.setText("No se puede eliminar");}
                    
                    

                    break;
                default:
                    break;
            }
        }else{
            message.setText("Seleccione un elemento para eliminar");
        }  
    } 
    
    /**
     * Guarda el pedido actual.
     */
    private void guardarPedido(){
        Random random = new Random();
        int id = random.nextInt(1000) + 1;
        idPd = String.valueOf(id);
        Pedido p = new Pedido(String.valueOf(id),InicioController.name,ValorPagar);
        Pedido.guardarPedido(p);
        Pedido.serealizarPedido(p);
    }
    
}//Fin
