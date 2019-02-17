/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import model.util.Loader;
import gui.util.Grafico;

/**
 *
 * @author Herbert
 */
public class ViewHistoric extends javax.swing.JFrame {

    /**
     * Creates new form Historic
     */
    public ViewHistoric() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);

        /////////////////////////////////
        // Carrega as pasta dos meses comboBox
        for (File folder : Loader.folder()) {
            cboMes.addItem(folder.getName());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        cboMes = new javax.swing.JComboBox<>();
        cboDia = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        pnlGrafico = new javax.swing.JPanel();
        spaneInfo = new javax.swing.JScrollPane();
        lblInfo = new javax.swing.JLabel();
        optTabela = new javax.swing.JRadioButton();
        optGrafico = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(600, 400));

        cboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês e ano" }));
        cboMes.setToolTipText("\"Selecione Mes e ano\"");
        cboMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMesActionPerformed(evt);
            }
        });

        cboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia" }));
        cboDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDiaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Selecione a data da busca:");

        btnBuscar.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscar.setText("Carregar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        pnlGrafico.setBackground(new java.awt.Color(255, 255, 255));
        pnlGrafico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        spaneInfo.setBackground(new java.awt.Color(255, 255, 255));

        lblInfo.setBackground(new java.awt.Color(255, 255, 255));
        lblInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        spaneInfo.setViewportView(lblInfo);

        javax.swing.GroupLayout pnlGraficoLayout = new javax.swing.GroupLayout(pnlGrafico);
        pnlGrafico.setLayout(pnlGraficoLayout);
        pnlGraficoLayout.setHorizontalGroup(
            pnlGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spaneInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );
        pnlGraficoLayout.setVerticalGroup(
            pnlGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spaneInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );

        buttonGroup1.add(optTabela);
        optTabela.setText("Tabela");

        buttonGroup1.add(optGrafico);
        optGrafico.setSelected(true);
        optGrafico.setText("Grafico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(optGrafico)
                        .addGap(18, 18, 18)
                        .addComponent(optTabela)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(266, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optGrafico)
                    .addComponent(optTabela)
                    .addComponent(btnBuscar))
                .addContainerGap(448, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addComponent(pnlGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMesActionPerformed
        // Limpa o ComboBox dos dados anteriores, caso selecio outro mes
        cboDia.removeAllItems();
        cboDia.addItem("Dia");

        /////////////////////////////////
        // Carrega os aruivos  da pasta selecionada  
        if (!"Mês e ano".equals(cboMes.getSelectedItem().toString())) {
            for (File file : Loader.file(cboMes.getSelectedItem().toString())) {
                String[] newFile = file.getName().split("_");
                if (newFile.length >= 3) {
                    cboDia.addItem(newFile[0]);
                }
            }
        }
    }//GEN-LAST:event_cboMesActionPerformed

    private void cboDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDiaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        /////////////////////////////////
        // Carrega o grafico ou a tabela do arquivo 
        if (!cboMes.getSelectedItem().equals("Mês e ano") && !cboDia.getSelectedItem().equals("Dia")) {
            if (optGrafico.isSelected()) {
                spaneInfo.add(lblInfo);
                Grafico.carregaGrafico(cboDia.getSelectedItem().toString() + "_" + cboMes.getSelectedItem().toString(),
                        spaneInfo, "GraficoHistorico", 4000, 600, 1000);
            } else if (optTabela.isSelected()) {
                Loader.fileContent(spaneInfo, cboDia.getSelectedItem().toString(), cboMes.getSelectedItem().toString());

            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ViewHistoric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHistoric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHistoric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHistoric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewHistoric().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboDia;
    private javax.swing.JComboBox<String> cboMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JRadioButton optGrafico;
    private javax.swing.JRadioButton optTabela;
    private javax.swing.JPanel pnlGrafico;
    private javax.swing.JScrollPane spaneInfo;
    // End of variables declaration//GEN-END:variables
}
