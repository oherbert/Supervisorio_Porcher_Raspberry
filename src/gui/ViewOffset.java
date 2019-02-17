/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.util.Alerts;
import gui.util.CheckTextField;
import gui.util.Constraints;
import java.util.Locale;
import model.enums.PathList;
import model.enums.TypePane;
import model.util.Path;

/**
 *
 * @author Herbert
 */
public class ViewOffset extends javax.swing.JDialog {

    /**
     * Creates new form ViewOffset
     */
    public ViewOffset(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        Locale.setDefault(Locale.US);

        //////////////////////////////////////////
        // Carrega as Limitações dos campos
        Constraints.setTextFieldDouble(txtSecagem1);
        Constraints.setTextFieldMaxLength(txtSecagem1, 5);
        Constraints.setTextFieldDouble(txtSecagem2);
        Constraints.setTextFieldMaxLength(txtSecagem2, 5);
        Constraints.setTextFieldDouble(txtSecagem3);
        Constraints.setTextFieldMaxLength(txtSecagem3, 5);
        Constraints.setTextFieldDouble(txtSecagem3);
        Constraints.setTextFieldMaxLength(txtSecagem4, 5);
        Constraints.setTextFieldDouble(txtVulcanizacao1);
        Constraints.setTextFieldMaxLength(txtVulcanizacao1, 5);
        Constraints.setTextFieldDouble(txtVulcanizacao2);
        Constraints.setTextFieldMaxLength(txtVulcanizacao2, 5);
        Constraints.setTextFieldDouble(txtVulcanizacao3);
        Constraints.setTextFieldMaxLength(txtVulcanizacao3, 5);
        Constraints.setTextFieldDouble(txtVulcanizacao4);
        Constraints.setTextFieldMaxLength(txtVulcanizacao4, 5);

        /////////////////////////////////////////////////////
        //Carrega os valores do arquivo nos campos
        txtSecagem1.setText(Path.loadPath(PathList.OFFSETSECAGEM_1));
        txtSecagem2.setText(Path.loadPath(PathList.OFFSETSECAGEM_2));
        txtSecagem3.setText(Path.loadPath(PathList.OFFSETSECAGEM_3));
        txtSecagem4.setText(Path.loadPath(PathList.OFFSETSECAGEM_4));
        txtVulcanizacao1.setText(Path.loadPath(PathList.OFFSETVULCANICACAO_1));
        txtVulcanizacao2.setText(Path.loadPath(PathList.OFFSETVULCANICACAO_2));
        txtVulcanizacao3.setText(Path.loadPath(PathList.OFFSETVULCANICACAO_3));
        txtVulcanizacao4.setText(Path.loadPath(PathList.OFFSETVULCANICACAO_4));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtVulcanizacao1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSecagem1 = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtVulcanizacao2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSecagem2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtVulcanizacao3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSecagem3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtVulcanizacao4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSecagem4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("OffSet Maq. 1 Torre Secagem");

        txtVulcanizacao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVulcanizacao1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("OffSet Maq. 1 Torre Vulcanização");

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("OffSet Maq. 2 Torre Secagem");

        txtVulcanizacao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVulcanizacao2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("OffSet Maq. 2 Torre Vulcanização");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("OffSet Maq. 3 Torre Secagem");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("OffSet Maq. 3 Torre Vulcanização");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("OffSet Maq. 4 Torre Secagem");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("OffSet Maq. 4 Torre Vulcanização");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSecagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVulcanizacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSecagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVulcanizacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSecagem3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVulcanizacao3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSecagem4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVulcanizacao4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVulcanizacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSecagem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVulcanizacao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSecagem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVulcanizacao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSecagem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVulcanizacao4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSecagem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        if (CheckTextField.emptyField(txtSecagem1) == false) {
            Path.setPath(new Path(PathList.OFFSETSECAGEM_1,
                    String.format("%.1f", Double.parseDouble(txtSecagem1.getText()))));
        } else {
            Path.setPath(new Path(PathList.OFFSETSECAGEM_1, "00.0"));
        }

        if (CheckTextField.emptyField(txtSecagem2) == false) {
            Path.setPath(new Path(PathList.OFFSETSECAGEM_2,
                    String.format("%.1f", Double.parseDouble(txtSecagem2.getText()))));
        } else {
            Path.setPath(new Path(PathList.OFFSETSECAGEM_2, "00.0"));
        }

        if (CheckTextField.emptyField(txtSecagem3) == false) {
            Path.setPath(new Path(PathList.OFFSETSECAGEM_3,
                    String.format("%.1f", Double.parseDouble(txtSecagem3.getText()))));
        } else {
            Path.setPath(new Path(PathList.OFFSETSECAGEM_3, "00.0"));
        }

        if (CheckTextField.emptyField(txtSecagem4) == false) {
            Path.setPath(new Path(PathList.OFFSETSECAGEM_4,
                    String.format("%.1f", Double.parseDouble(txtSecagem4.getText()))));
        } else {
            Path.setPath(new Path(PathList.OFFSETSECAGEM_4, "00.0"));
        }

        if (CheckTextField.emptyField(txtVulcanizacao1) == false) {
            Path.setPath(new Path(PathList.OFFSETVULCANICACAO_1,
                    String.format("%.1f", Double.parseDouble(txtVulcanizacao1.getText()))));
        } else {
            Path.setPath(new Path(PathList.OFFSETVULCANICACAO_1, "00.0"));
        }

        if (CheckTextField.emptyField(txtVulcanizacao2) == false) {
            Path.setPath(new Path(PathList.OFFSETVULCANICACAO_2,
                    String.format("%.1f", Double.parseDouble(txtVulcanizacao2.getText()))));
        } else {
            Path.setPath(new Path(PathList.OFFSETVULCANICACAO_2, "00.0"));
        }

        if (CheckTextField.emptyField(txtVulcanizacao3) == false) {
            Path.setPath(new Path(PathList.OFFSETVULCANICACAO_3,
                    String.format("%.1f", Double.parseDouble(txtVulcanizacao3.getText()))));
        } else {
            Path.setPath(new Path(PathList.OFFSETVULCANICACAO_3, "00.0"));
        }

        if (CheckTextField.emptyField(txtVulcanizacao4) == false) {
            Path.setPath(new Path(PathList.OFFSETVULCANICACAO_4,
                    String.format("%.1f", Double.parseDouble(txtVulcanizacao4.getText()))));
        } else {
            Path.setPath(new Path(PathList.OFFSETVULCANICACAO_4, "00.0"));
        }

        Alerts.showAlert("Valores Salvos", "Os valores foram salvos com sucesso", "", TypePane.INFORMATION);
        this.dispose();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtVulcanizacao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVulcanizacao1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVulcanizacao1ActionPerformed

    private void txtVulcanizacao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVulcanizacao2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVulcanizacao2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewOffset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewOffset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewOffset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewOffset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewOffset dialog = new ViewOffset(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtSecagem1;
    private javax.swing.JTextField txtSecagem2;
    private javax.swing.JTextField txtSecagem3;
    private javax.swing.JTextField txtSecagem4;
    private javax.swing.JTextField txtVulcanizacao1;
    private javax.swing.JTextField txtVulcanizacao2;
    private javax.swing.JTextField txtVulcanizacao3;
    private javax.swing.JTextField txtVulcanizacao4;
    // End of variables declaration//GEN-END:variables
}