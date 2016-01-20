/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sistemaCantinaICIL.presentation;

import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 * 
 * @author Aricelio
 */
public class frmGenerico {
    
    public static void showMessage(String msg, JRootPane rootPane) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }

}
