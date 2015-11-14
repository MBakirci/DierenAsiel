/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dierenasiel.model;

/**
 *
 * @author Gebruiker
 */
public class IStorageException extends Exception {

    /**
     * Creates a new instance of <code>IStorageException</code> without detail
     * message.
     */
    public IStorageException() {
    }

    /**
     * Constructs an instance of <code>IStorageException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IStorageException(String msg) {
        super(msg);
    }
}
