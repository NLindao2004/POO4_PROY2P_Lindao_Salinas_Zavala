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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Controlador para la tercera etapa de armar tu helado.
 */
public class ArmaTuHelado3Controller implements Initializable {
    
    /**
     * Variable para almacenar el costo del primer topping seleccionado.
     */
    private double ck1 = 0;

    /**
     * Variable para almacenar el costo del segundo topping seleccionado.
     */
    private double ck2 = 0;

    /**
     * Variable para almacenar el costo del tercer topping seleccionado.
     */
    private double ck3 = 0;

    /**
     * Variable para almacenar el costo del cuarto topping seleccionado.
     */
    private double ck4 = 0;

    /**
     * Variable para almacenar el costo del quinto topping seleccionado.
     */
    private double ck5 = 0;

    /**
     * Variable para almacenar el costo del sexto topping seleccionado.
     */
    private double ck6 = 0;
    
    /**
     * Almacena el valor total de la orden del helado en esta etapa.
     */
    
    /**
     * Almacena el costo total de los toppings seleccionados por el usuario.
     */
    
    private  double totalTopping = 0 ;

    /**
     * Almacena el valor total de la orden del helado en esta etapa.
     */
    public static double valor3 = 0;

    /**
     * Almacena el nombre del primer topping seleccionado.
     */
    private String c1 = "";

    /**
     * Almacena el nombre del segundo topping seleccionado.
     */
    private String c2 = "";

    /**
     * Almacena el nombre del tercer topping seleccionado.
     */
    private String c3 = "";

    /**
     * Almacena el nombre del cuarto topping seleccionado.
     */
    private String c4 = "";

    /**
     * Almacena el nombre del quinto topping seleccionado.
     */
    private String c5 = "";

    /**
     * Almacena el nombre del sexto topping seleccionado.
     */
    private String c6 = "";
    
    
    /**
     * Boton para continuar a la siguiente escena.
     */
    @FXML
    private Button btnContinuar;

    /**
     * CheckBox para seleccionar el primer topping.
     */
    @FXML
    private CheckBox chk1;

    /**
     * CheckBox para seleccionar el segundo topping.
     */
    @FXML
    private CheckBox chk2;

    /**
     * CheckBox para seleccionar el tercer topping.
     */
    @FXML
    private CheckBox chk3;

    /**
     * CheckBox para seleccionar el cuarto topping.
     */
    @FXML
    private CheckBox chk4;

    /**
     * CheckBox para seleccionar el quinto topping.
     */
    @FXML
    private CheckBox chk5;

    /**
     * CheckBox para seleccionar el sexto topping.
     */
    @FXML
    private CheckBox chk6;

    /**
     * ImageView para mostrar una imagen relacionada con la elección del helado.
     */
    @FXML
    private ImageView imgArmaTuHelado3;

    /**
     * Etiqueta para mostrar el valor a pagar por el helado personalizado.
     */
    @FXML
    private Label valorPagar;
    
    /**
     * Inicializa el controlador y muestra la imagen y el valor a pagar inicial.
     *
     * @param url La ubicación relativa del archivo FXML.
     * @param rb ResourceBundle que se puede utilizar para localizar
     * objetos de IU.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarImg();
        Double valorTuHelado3 = ArmaTuHelado2Controller.valor2;
        String formatted = String.format(Locale.US, "%.2f", valorTuHelado3);
        valorPagar.setText("Valor a pagar: " + formatted);
    }   

    /**
     * Maneja el evento "Continuar" para avanzar a la siguiente etapa y registra
     * los toppings seleccionados en la lista de la orden.
     *
     * @param event El evento de acción del botón.
     * @throws IOException Si ocurre un error de E/S al cargar la siguiente vista.
     */
    @FXML
    void continuar(ActionEvent event) throws IOException {
        topicSelect();
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("ArmaTuHelado4.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root, 730, 530);
        Stage s = (Stage) btnContinuar.getScene().getWindow();
        s.setScene(scene);
        s.setTitle("ArmaTuHelado4");         
        s.show();
    }
    
    /**
     * Muestra una imagen en la interfaz gráfica.
     */
    public void mostrarImg() {        
        try (FileInputStream input = new FileInputStream(Principal.path + "escena5.jpg")) {
            Image image = new Image(input, 730, 530, false, false);
            imgArmaTuHelado3.setImage(image);             
        } catch (FileNotFoundException fn) {
            // Manejar excepción si la imagen no se encuentra
        } catch (Exception ex) {
            // Manejar otras excepciones posibles
        }
    }
     
    /**
     * Maneja la selección del CheckBox 1 para los toppings.
     *
     * @param event El evento de acción del CheckBox 1.
     */
    @FXML
    void checkBox1(ActionEvent event) {
        String cadena = chk1.getText();
        String[] lista = cadena.trim().split("-");
        Double precioTopping = Double.parseDouble(lista[1]); 
        if (chk1.isSelected()) {
            c1 = "Topping: " + cadena;
            ck1 = precioTopping;
            totalTopping = ck1 + ck2 + ck3 + ck4 + ck5 + ck6;
            Double ValorTotal = totalTopping + ArmaTuHelado2Controller.valor2;
            String formatted = String.format(Locale.US, "%.2f", ValorTotal);
            valorPagar.setText("Valor a pagar: " + formatted);
            valor3 = ValorTotal;
        } else {
            ck1 = 0;
            c1 = null;
            totalTopping = ck1 + ck2 + ck3 + ck4 + ck5 + ck6;
            Double ValorTotal = totalTopping + ArmaTuHelado2Controller.valor2;
            String formatted = String.format(Locale.US, "%.2f", ValorTotal);
            valorPagar.setText("Valor a pagar: " + formatted);
            valor3 = ValorTotal;
        }
    }
    /**
     * Maneja la selección del CheckBox 2 para los toppings.
     *
     * @param event El evento de acción del CheckBox 2.
     */
    
     @FXML
    void checkBox2(ActionEvent event) {
        String cadena =  chk2.getText();
        String [] lista = cadena.trim().split("-");
        Double precioTopping = Double.parseDouble(lista[1]);
        if (chk2.isSelected()) {
            ck2 = precioTopping;
            c2= "Topping: "+cadena;
            totalTopping =ck1+ck2+ck3+ck4+ck5+ck6;
            Double ValorTotal= totalTopping+ArmaTuHelado2Controller.valor2;
            String formatted = String.format(Locale.US,"%.2f", ValorTotal);
            valorPagar.setText("Valor a pagar: "+formatted);
            valor3 = ValorTotal;
        }else{
           ck2 = 0;
           c2 = null;
           totalTopping =ck1+ck2+ck3+ck4+ck5+ck6;
           Double ValorTotal= totalTopping+ArmaTuHelado2Controller.valor2;
           String formatted = String.format(Locale.US,"%.2f", ValorTotal);
           valorPagar.setText("Valor a pagar: "+formatted);
           valor3 = ValorTotal;
       }
    }
    
    /**
     * Maneja la selección del CheckBox 3 para los toppings.
     *
     * @param event El evento de acción del CheckBox 3.
     */
    

    @FXML
    void checkBox3(ActionEvent event) {
        String cadena =  chk3.getText();
        String [] lista = cadena.trim().split("-");
        Double precioTopping = Double.parseDouble(lista[1]);
        if (chk3.isSelected()) {
            c3= "Topping: "+cadena;
            ck3 = precioTopping;
            totalTopping =ck1+ck2+ck3+ck4+ck5+ck6;
            Double ValorTotal= totalTopping+ArmaTuHelado2Controller.valor2;
            String formatted = String.format(Locale.US,"%.2f", ValorTotal);
            valorPagar.setText("Valor a pagar: "+formatted);
            valor3 = ValorTotal;
        }else{
           ck3 = 0;
           c3 = null;
           totalTopping =ck1+ck2+ck3+ck4+ck5+ck6;
           Double ValorTotal= totalTopping+ArmaTuHelado2Controller.valor2;
           String formatted = String.format(Locale.US,"%.2f", ValorTotal);
           valorPagar.setText("Valor a pagar: "+formatted);
           valor3 = ValorTotal;
       }
    }
    
    /**
     * Maneja la selección del CheckBox 4 para los toppings.
     *
     * @param event El evento de acción del CheckBox 4.
     */

    @FXML
    void checkBox4(ActionEvent event) {
        String cadena =  chk4.getText();
        String [] lista = cadena.trim().split("-");
        Double precioTopping = Double.parseDouble(lista[1]);
        if (chk4.isSelected()) {
            c4= "Topping: "+cadena;
            ck4 = precioTopping;
            totalTopping =ck1+ck2+ck3+ck4+ck5+ck6;
            Double ValorTotal= totalTopping+ArmaTuHelado2Controller.valor2;
            String formatted = String.format(Locale.US,"%.2f", ValorTotal);
            valorPagar.setText("Valor a pagar: "+formatted);
            valor3 = ValorTotal;
        }else{
           ck4 = 0;
           c4 = null;
           totalTopping =ck1+ck2+ck3+ck4+ck5+ck6;
           Double ValorTotal= totalTopping+ArmaTuHelado2Controller.valor2;
           String formatted = String.format(Locale.US,"%.2f", ValorTotal);
           valorPagar.setText("Valor a pagar: "+formatted);
           valor3 = ValorTotal;
       }
    }
    /**
     * Maneja la selección del CheckBox 5 para los toppings.
     *
     * @param event El evento de acción del CheckBox 5.
     */
    

    @FXML
    void checkBox5(ActionEvent event) {
        String cadena =  chk5.getText();
        String [] lista = cadena.trim().split("-");
        Double precioTopping = Double.parseDouble(lista[1]);
        if (chk5.isSelected()) {
            c5= "Topping: "+cadena;
            ck5 = precioTopping;
            totalTopping =ck1+ck2+ck3+ck4+ck5+ck6;
            Double ValorTotal= totalTopping+ArmaTuHelado2Controller.valor2;
            String formatted = String.format(Locale.US,"%.2f", ValorTotal);
            valorPagar.setText("Valor a pagar: "+formatted);
            valor3 = ValorTotal;
        }else{
           ck5 = 0;
           c5 = null;
           totalTopping =ck1+ck2+ck3+ck4+ck5+ck6;
           Double ValorTotal= totalTopping+ArmaTuHelado2Controller.valor2;
           String formatted = String.format(Locale.US,"%.2f", ValorTotal);
           valorPagar.setText("Valor a pagar: "+formatted);
           valor3 = ValorTotal;
       }
    }
    
    /**
     * Maneja la selección del CheckBox 6 para los toppings.
     *
     * @param event El evento de acción del CheckBox 6.
     */

    @FXML
    void checkBox6(ActionEvent event) {
        String cadena =  chk6.getText();
        String [] lista = cadena.trim().split("-");
        Double precioTopping = Double.parseDouble(lista[1]);
        if (chk6.isSelected()) {
            ck6 = precioTopping;
            c6= "Topping: "+cadena;
            totalTopping =ck1+ck2+ck3+ck4+ck5+ck6;
            Double ValorTotal= totalTopping+ArmaTuHelado2Controller.valor2;
            String formatted = String.format(Locale.US,"%.2f", ValorTotal);
            valorPagar.setText("Valor a pagar: "+formatted);
            valor3 = ValorTotal;
        }else{
           ck6 = 0;
           c6=null;
           totalTopping =ck1+ck2+ck3+ck4+ck5+ck6;
           Double ValorTotal= totalTopping+ArmaTuHelado2Controller.valor2;
           String formatted = String.format(Locale.US,"%.2f", ValorTotal);
           valorPagar.setText("Valor a pagar: "+formatted);
           valor3 = ValorTotal;
       }
    }
    
     /**
     * Registra los toppings seleccionados en la lista de la orden.
     */
    public void topicSelect(){
        ArrayList<String> toppings = new ArrayList();
        toppings.add(c1);
        toppings.add(c2);
        toppings.add(c3);
        toppings.add(c4);
        toppings.add(c5);
        toppings.add(c6);
        for (String t : toppings) {
            if (t != null) {
                ArmaTuHelado1Controller.orden.add(t);
            }
        }
    }
}
