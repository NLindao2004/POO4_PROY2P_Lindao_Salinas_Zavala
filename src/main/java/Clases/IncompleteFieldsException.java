/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * La clase IncompleteFieldsException representa una excepción que se lanza cuando se detectan campos incompletos o faltantes.
 */
public class IncompleteFieldsException extends RuntimeException {

    /**
     * Constructor predeterminado de IncompleteFieldsException.
     */
    public IncompleteFieldsException() {
    }

    /**
     * Constructor de IncompleteFieldsException con un mensaje de error personalizado.
     * @param message El mensaje de error personalizado.
     */
    public IncompleteFieldsException(String message) {
        super(message);
    }
}