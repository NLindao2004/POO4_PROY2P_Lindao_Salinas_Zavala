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
 * FXML Controller class
 *
 * @author PC.1
 */
public class ArmaTuHelado3Controller implements Initializable {
    
    private  double ck1 = 0 ;
    private  double ck2 = 0 ;
    private  double ck3 = 0 ;
    private  double ck4 = 0 ;
    private  double ck5 = 0 ;
    private  double ck6 = 0 ;
    private  double totalTopping = 0 ;
    public static double valor3 = 0;
    private String c1= "";
    private String c2= "";
    private String c3= "";
    private String c4= "";
    private String c5= "";
    private String c6= "";
    
    @FXML
    private Button btnContinuar;

    @FXML
    private CheckBox chk1;

    @FXML
    private CheckBox chk2;

    @FXML
    private CheckBox chk3;

    @FXML
    private CheckBox chk4;

    @FXML
    private CheckBox chk5;

    @FXML
    private CheckBox chk6;

    @FXML
    private ImageView imgArmaTuHelado3;
    
    @FXML
    private Label valorPagar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();
        Double valorTuHelado3 = ArmaTuHelado2Controller.valor2;
        String formatted = String.format(Locale.US,"%.2f", valorTuHelado3);
        valorPagar.setText("Valor a pagar: "+formatted);
    }   

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
    
    public void mostrarImg(){        
            try(FileInputStream  input = new FileInputStream (Principal.path+"escena5.jpg")){
                Image image = new Image(input,730,530,false,false);
                imgArmaTuHelado3.setImage(image);             
            }catch(FileNotFoundException fn){

            }catch (Exception ex) {

            }
    }
     
    @FXML
    void checkBox1(ActionEvent event) {
        String cadena =  chk1.getText();
        String [] lista = cadena.trim().split("-");
        Double precioTopping = Double.parseDouble(lista[1]); 
        if (chk1.isSelected()) {
            c1= "Topping: "+cadena;
            ck1 = precioTopping;
            totalTopping =ck1+ck2+ck3+ck4+ck5+ck6;
            Double ValorTotal= totalTopping+ArmaTuHelado2Controller.valor2;
            String formatted = String.format(Locale.US,"%.2f", ValorTotal);
            valorPagar.setText("Valor a pagar: "+formatted);
            valor3 = ValorTotal;
        }else{
           ck1 = 0;
           c1= null;
           totalTopping =ck1+ck2+ck3+ck4+ck5+ck6;
           Double ValorTotal= totalTopping+ArmaTuHelado2Controller.valor2;
           String formatted = String.format(Locale.US,"%.2f", ValorTotal);
           valorPagar.setText("Valor a pagar: "+formatted);
           valor3 = ValorTotal;
       }
    }
    
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
