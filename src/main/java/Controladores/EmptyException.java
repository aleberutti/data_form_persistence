/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

/**
 *
 * @author Admin
 */
//Clase para manejar excepciones en caso de que el campo esté vacío
public class EmptyException extends Exception {
    public EmptyException (String message){
        super(message);
    }
}
