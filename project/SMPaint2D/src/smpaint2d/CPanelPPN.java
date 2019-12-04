/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smpaint2d;

import java.awt.Color;

/**
 *
 * @author Pedro Parrilla
 */
public class CPanelPPN extends javax.swing.JDialog {

    /**
     * Constructor de la ventana de Color
     * @param parent
     * @param modal
     */
    public CPanelPPN(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        color = Color.BLACK;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jPanel1 = new javax.swing.JPanel();
        jBSelect = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().add(jColorChooser1, java.awt.BorderLayout.CENTER);

        jBSelect.setText("Seleccionar");
        jBSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelectActionPerformed(evt);
            }
        });
        jPanel1.add(jBSelect);

        jBCancel.setText("Cancelar");
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jBCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para cerrar la ventana
     * @param evt 
     */
    
    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCancelActionPerformed

    /**
     * Método para guardar el color seleccionado y cerrar la ventana
     * @param evt 
     */
    
    private void jBSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSelectActionPerformed
        color = jColorChooser1.getColor();
        this.dispose();
    }//GEN-LAST:event_jBSelectActionPerformed


    
    public Color getColor(){
        return color;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBSelect;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    private Color color;
}
