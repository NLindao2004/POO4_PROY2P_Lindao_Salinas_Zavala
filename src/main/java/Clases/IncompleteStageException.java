/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Clases;
/**
 * La clase IncompleteStageException representa una excepción que se lanza cuando una etapa o paso en un proceso está incompleto o faltante.
 */
public class IncompleteStageException extends Exception {

    /**
     * Constructor predeterminado de IncompleteStageException.
     * Crea una excepción con un mensaje predeterminado.
     */
    public IncompleteStageException() {
        super("Debe elegir al menos una opción para continuar.");
    }

    /**
     * Constructor de IncompleteStageException con un mensaje de error personalizado.
     * @param message El mensaje de error personalizado.
     */
    public IncompleteStageException(String message) {
        super(message);
    }
}