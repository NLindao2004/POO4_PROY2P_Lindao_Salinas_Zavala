/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import Clases.IncompleteStageException;
import Clases.Pago;
import Clases.Pedido;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
//import com.pooespol.proyecto2_heladeria.ArmaTuHelado4Controller;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextFormatter;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


/**
 * Controlador para la vista ArmaTuHelado5.fxml.
 */
public class ArmaTuHelado5Controller implements Initializable {
    
    /**
     * Almacena el tipo de pago: "E" para efectivo, "T" para tarjeta.
     */
    private String tipo = null;
    
    /**
     * Campo para ingresar un valor adicional en caso de pago con tarjeta.
     */
    @FXML
    private TextField adicionalT;
    
    /**
     * Botón para cancelar la operación.
     */
    @FXML
    private Button btnCancelar;
    
    /**
     * Botón para confirmar el pago.
     */
    @FXML
    private Button btnConfirmar;
    /**
     * Imagen de fondo.
     */
    @FXML
    private ImageView imgArmaTuHelado5;
    /**
     * Campo para mostrar el valor del Impuesto al Valor Agregado (IVA).
     */
    @FXML
    private TextField iva;
    /**
     * Etiqueta para mostrar mensajes de validación.
     */
    @FXML
    private Label mensaje;
    /**
     * Opción de pago en efectivo.
     */
    @FXML
    private RadioButton op1;
    /**
     * Opción de pago con tarjeta.
     */
    @FXML
    private RadioButton op2;
    /**
     * Contenedor para campos de entrada relacionados con la tarjeta.
     */
    @FXML
    private VBox seccionField;
    /**
     * Contenedor para etiquetas relacionadas con la tarjeta.
     */
    @FXML
    private VBox seccionLabel;
    /**
     * Campo para mostrar el valor total a pagar.
     */
    @FXML
    private TextField total;
    /**
     * Campo para mostrar el valor del pedido.
     */
    @FXML
    private TextField valor;

      
    /**
     * Inicializa el controlador.
     * 
     * @param url Ubicación del archivo FXML.
     * @param rb  Recursos utilizados para la inicialización.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarImg();
        ToggleGroup tg= new ToggleGroup();
        op1.setToggleGroup(tg);
        op2.setToggleGroup(tg);
        efectivo();
        tarjeta();
        valor.setEditable(false);
        adicionalT.setEditable(false);
        iva.setEditable(false);
        total.setEditable(false);
        
    } 
    
     /**
     * Maneja el evento de cancelar y cierra la ventana actual.
     * @param event Evento de acción del botón Cancelar.
     */
    @FXML
    void cancelar(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow(); 
        stage.close(); 
    }
    
    /**
     * Maneja el evento de confirmar el pago y realiza validaciones antes de continuar.
     * @param event Evento de acción del botón Confirmar.
     */
    @FXML
    void confirmar(ActionEvent event) {
        try {
                if (!op1.isSelected() && !op2.isSelected()) {
                    throw new IncompleteStageException();
                }
            } catch (IncompleteStageException ex) {
                mensaje.setText(ex.getMessage()); 
            }     
    }  
    
    /**
     * Cambia la escena actual a la vista ArmaTuHelado6.fxml.
     * @throws IOException Si ocurre un error al cargar la nueva vista.
     */
    public void cambiarEscena() throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(Principal.class.getResource("ArmaTuHelado6.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root, 730, 530);
        Stage s = (Stage) btnConfirmar.getScene().getWindow();
        s.setScene(scene);
        s.setTitle("ArmaTuHelado6");         
        s.show();
    }
    
    
    /**
     * Muestra una imagen de fondo en la interfaz.
     */
    public void mostrarImg(){        
        try(FileInputStream  input = new FileInputStream (Principal.pathImages+"escena5.jpg")){
            Image image = new Image(input,730,530,false,false);
            imgArmaTuHelado5.setImage(image);             
        }catch(FileNotFoundException fn){

        }catch (Exception ex) {

        }
        
    }
     /**
     * Configura la lógica relacionada con el pago en efectivo.
     */
    
    private void efectivo(){
            tipo = "E";
            double v = ArmaTuHelado4Controller.ValorPagar;
            String formatted = String.format(Locale.US,"%.2f", v);
            valor.setText(String.valueOf(formatted));
            adicionalT.setText("0.00");
            double IVA = v*0.12;
            String formatted1 = String.format(Locale.US,"%.2f", IVA);
            iva.setText(String.valueOf(formatted1));
            double t = IVA+v;
            String formatted2 = String.format(Locale.US,"%.2f", t);
            total.setText(formatted2);
            
        
        op1.setOnAction(e->{
            double v1 = ArmaTuHelado4Controller.ValorPagar;
            String formatted3 = String.format(Locale.US,"%.2f", v);
            valor.setText(String.valueOf(formatted3));
            adicionalT.setText("0.00");
            double IVA1 = v*0.12;
            String formatted4 = String.format(Locale.US,"%.2f", IVA1);
            iva.setText(String.valueOf(formatted4));
            double t1 = IVA1+v1;
            String formatted5 = String.format(Locale.US,"%.2f", t1);
            total.setText(formatted5);
            mensaje.setText("");
            mensaje.setText("Acércate a caja para pagar tu pedido");
            seccionField.getChildren().clear(); 
            seccionLabel.getChildren().clear(); 
            adicionalT.setText("0.00");
            btnConfirmar.setOnAction(event -> {
                Random random = new Random();
                    int id = random.nextInt(1000) + 1;
                    LocalDate fechaActual = LocalDate.now();
                    Pago p = new Pago(String.valueOf(id),ArmaTuHelado4Controller.idPd,InicioController.name,Double.parseDouble(total.getText()),String.valueOf(fechaActual),tipo);
                    Pedido pd = new Pedido();
                    pd.generarTransacción(p);
                try {
                cambiarEscena();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
});
        });
    }
    
    /**
     * Configura la lógica relacionada con el pago con tarjeta.
     */
    private void tarjeta(){
        op2.setOnAction(e->{
            tipo = "T";
            mensaje.setText("");
            double adicional = Double.parseDouble(valor.getText())*0.10;
            String formatted1 = String.format(Locale.US,"%.2f", adicional);
            adicionalT.setText(String.valueOf(formatted1));
            double t = Double.parseDouble(valor.getText())+adicional+Double.parseDouble(iva.getText());
            String formatted = String.format(Locale.US,"%.2f", t);
            total.setText(String.valueOf(formatted));
            Font font = Font.font("Candara", FontWeight.BOLD, 14);  
            Font font2 = Font.font("Candara", FontWeight.NORMAL, 14);  
            Label lb1 = new Label("Inserte los datos de su tarjeta:");
            TextFlow textFlow = new TextFlow(lb1);
            Label lb2 = new Label("Nombre:");
            Label lb3 = new Label("Número:");
            Label lb4 = new Label("Fecha de caducidad");
            Label lb5 = new Label("CVV:");
            lb1.setFont(font);
            lb2.setFont(font2);
            lb3.setFont(font2);
            lb4.setFont(font2);
            lb5.setFont(font2);
            seccionLabel.getChildren().addAll(textFlow  ,lb2,lb3,lb4,lb5);
            seccionLabel.setSpacing(30);
            TextField tf1 = new TextField();
            TextField tf2 = new TextField();
            DatePicker fecha = new DatePicker();
            TextField tf4 = new TextField();
            VBox.setMargin(tf1, new javafx.geometry.Insets(40, 0, 0, 0));
            seccionField.getChildren().addAll(tf1,tf2,fecha,tf4);
            seccionField.setSpacing(20);
            
            // Crear un filtro para permitir solo cadenas de caracteres
            UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
                if (newText.matches("^[\\p{L} \\s]*$")) {
                    return change;
                }
                return null; // Rechazar el cambio si no es una cadena de caracteres válida
            };
            TextFormatter<String> textFormatter = new TextFormatter<>(filter);
            tf1.setTextFormatter(textFormatter);
            
            // Crear un filtro para permitir solo números enteros
            UnaryOperator<TextFormatter.Change> filter1 = change -> {
                String newText = change.getControlNewText();
                if (Pattern.matches("^\\d*$", newText)) {
                    return change;
                }
                return null; // Rechazar el cambio si no es un número entero
            };

            TextFormatter<String> textFormatter1 = new TextFormatter<>(filter1);
            tf2.setTextFormatter(textFormatter1);
            
            
            UnaryOperator<TextFormatter.Change> filter2 = change -> {
                String newText = change.getControlNewText();
                if (Pattern.matches("^\\d*$", newText)) {
                    return change;
                }
                return null; // Rechazar el cambio si no es un número entero
            };

            TextFormatter<String> textFormatter2 = new TextFormatter<>(filter2);
            tf4.setTextFormatter(textFormatter2);
            
            btnConfirmar.setOnAction(event -> {
                if (tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf4.getText().isEmpty() || fecha.getValue() == null) {
                    mensaje.setText("Por favor, completa todos los campos.");
                } else {
                    Random random = new Random();
                    int id = random.nextInt(1000) + 1;
                    LocalDate fechaActual = LocalDate.now();
                    Pago p = new Pago(String.valueOf(id),ArmaTuHelado4Controller.idPd,tf1.getText(),Double.parseDouble(total.getText()),String.valueOf(fechaActual),tipo);
                    Pedido pd = new Pedido();
                    pd.generarTransacción(p);
                    try {
                        cambiarEscena();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        });
    }
    
    
        
}
