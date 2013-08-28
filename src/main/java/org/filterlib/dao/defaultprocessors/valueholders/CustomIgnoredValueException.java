/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.filterlib.dao.defaultprocessors.valueholders;

/**
 *
 * @author infragile
 */
public class CustomIgnoredValueException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>CustomIgnoredValueException</code> without detail message.
     */
    public CustomIgnoredValueException() {
    }

    /**
     * Constructs an instance of
     * <code>CustomIgnoredValueException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public CustomIgnoredValueException(String msg) {
        super(msg);
    }

    public CustomIgnoredValueException(String msg, Throwable th) {
        super(msg, th);
    }
}
