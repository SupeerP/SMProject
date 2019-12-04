/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smpaint2d;

/**
 * Clase para asignar una nueva posición a la figura
 * @author Pedro Parrilla
 */
public class SizePanelPPN extends javax.swing.JDialog {

    /**
     * Creates new form SizePanelPPN
     * @param parent
     * @param modal
     */
    public SizePanelPPN(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jPanel1.setSize(150, 150);
        w = h = 0;
        setTitle("Tamaño Lienzo");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jBSelect = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(300, 10, null, 1));
        jPanel1.add(jSpinner1);

        jLabel2.setText("x");
        jPanel1.add(jLabel2);

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(300, 10, null, 1));
        jPanel1.add(jSpinner2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jBSelect.setText("Seleccionar");
        jBSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelectActionPerformed(evt);
            }
        });
        jPanel2.add(jBSelect);

        jBCancel.setText("Cancelar");
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });
        jPanel2.add(jBCancel);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSelectActionPerformed
        w = (int) jSpinner1.getValue();
        h = (int) jSpinner2.getValue();
        this.dispose();
    }//GEN-LAST:event_jBSelectActionPerformed

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCancelActionPerformed

    /**
     *Devolución del valor w seleccionado
     * @return 
     */
    
    public int getW(){
        return w;
    }
    
    public int getH(){
        return h;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBSelect;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    // End of variables declaration//GEN-END:variables
    int w, h;
}
