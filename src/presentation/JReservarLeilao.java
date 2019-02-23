/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author ricardopetronilho
 */
public class JReservarLeilao extends javax.swing.JFrame {
    
    private String servidorId;
    private PrintWriter pw;
    private BufferedReader br;

    /**
     * Creates new form ReservarLeilao
     */
    public JReservarLeilao(String servidorId, PrintWriter pw, BufferedReader br) {
        initComponents();
        
        this.setResizable(false);
        this.servidorId = servidorId;
        this.pw = pw;
        this.br = br;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLicitar = new javax.swing.JButton();
        jTextFieldLicitar = new javax.swing.JTextField();

        jButtonLicitar.setText("licitar");
        jButtonLicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLicitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButtonLicitar)
                .addGap(33, 33, 33)
                .addComponent(jTextFieldLicitar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLicitar)
                    .addComponent(jTextFieldLicitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLicitarActionPerformed
        
        String licitacao = this.jTextFieldLicitar.getText();
        
        this.pw.println("b_" + this.servidorId + "_" + licitacao);
        this.pw.flush();
        
        try {
          String msg = br.readLine();
          if(msg.equals("true")) JOptionPane.showMessageDialog(this, "licitação feita com sucesso!","Informação", JOptionPane.INFORMATION_MESSAGE);
          else if(msg.equals("false")) JOptionPane.showMessageDialog(this, "Licitação abaixo do valor atual!","ERRO", JOptionPane.ERROR_MESSAGE);
        
        } catch (IOException e) {
          e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonLicitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLicitar;
    private javax.swing.JTextField jTextFieldLicitar;
    // End of variables declaration//GEN-END:variables
}
