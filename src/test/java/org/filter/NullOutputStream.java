/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.filter;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Writes nowhere
 *
 * @author infragile
 */
public class NullOutputStream extends OutputStream {

    @Override
    public void write(int b) throws IOException {
    }
}
