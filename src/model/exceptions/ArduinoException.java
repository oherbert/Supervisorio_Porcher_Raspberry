/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.exceptions;

/**
 *
 * @author Herbert
 */
public class ArduinoException extends RuntimeException {

    public ArduinoException(String exception) {
        super(exception);
    }

}
