/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author PC.1
 */
public class IncompleteStageException extends Exception {
    public IncompleteStageException() {
        super("Debe elegir al menos una opción para continuar.");
    }

    public IncompleteStageException(String message) {
        super(message);
    }
}