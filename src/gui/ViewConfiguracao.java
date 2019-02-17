/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.util.Alerts;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import model.util.Path;
import model.enums.PathList;
import model.enums.TypePane;
import gui.util.CheckTextField;
import gui.util.Constraints;
import model.util.FormatLocalPath;
import java.io.File;

/**
 *
 * @author Herbert
 */
public class ViewConfiguracao extends javax.swing.JDialog {

    /**
     * Creates new form ViewConfiguracao
     */
    public ViewConfiguracao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        /*
        // Carrega os dados  no ConboBox ***** Windows ************
        String[] lstCom = new String[]{"COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9"};
        for (String lst : lstCom) {
            cboCom.addItem(lst);
        }*/
       
        // Carrega os dados  no ConboBox  ***** RaspBerry Pi *****************
        String[] lstCom = new String[]{"/dev/ttyACM0", "/dev/ttyAMA0", "/dev/ttyS0"};
        for (String lst : lstCom) {
            cboCom.addItem(lst);
        }
     
        
        ///////////////
        //// Carrega os valores que estão salvos no arquivo 

        cboCom.setSelectedItem(Path.loadPath(PathList.ARDUINOCOM));

        String tempo = "";
        switch (Path.loadPath(PathList.TEMPOGRAVACAO)) {
            case ("60"):
                tempo = "1 min";
                break;
            case ("120"):
                tempo = "2 min";
                break;
            case ("180"):
                tempo = "3 min";
                break;
            case ("240"):
                tempo = "4 min";
                break;
            case ("300"):
                tempo = "5 min";
                break;
        }

        cboTempo.setSelectedItem(tempo);
        txtLocal.setText(Path.loadPath(PathList.LOCALFOLDER));
        txtRemoto.setText(Path.loadPath(PathList.CLOUDFOLDER));
        txtSetTemp1.setText(Path.loadPath(PathList.TEMPERATURA_SET_1));
        txtSetTemp2.setText(Path.loadPath(PathList.TEMPERATURA_SET_2));
        txtRangeSec1.setText(Path.loadPath(PathList.RANGETEMPERATURA_1));
        txtRangeVul1.setText(Path.loadPath(PathList.RANGETEMPERATURA_2));

        /////////////
        // Limitações do textFields
        Constraints.setTextFieldInteger(txtSetTemp1);
        Constraints.setTextFieldInteger(txtSetTemp2);
        Constraints.setTextFieldInteger(txtRangeSec1);
        Constraints.setTextFieldInteger(txtRangeVul1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboCom = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRemoto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLocal = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboTempo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSetTemp1 = new javax.swing.JTextField();
        txtSetTemp2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRangeSec1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtRangeVul1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações");
        setAlwaysOnTop(true);
        setResizable(false);

        cboCom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboCom.setName("cboCom"); // NOI18N
        cboCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboComActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Porta de Comunicação do Arduino:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Caminho da pasta do repositório local:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Caminho do repositório Remoto:");

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tempo entre gravações");

        cboTempo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboTempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 min", "2 min", "3 min", "4 min", "5 min" }));
        cboTempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTempoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Temperatura Secagem Ideal");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Tolerância Temp. Secagem");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Temperatura Vulcanização Ideal");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Tolerância Temp. Vulcanização");

        txtRangeVul1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRangeVul1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("+/-");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("+/-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(txtSetTemp1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSetTemp2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtRangeSec1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRangeVul1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(108, 108, 108)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(94, 94, 94))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cboCom, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRemoto, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                            .addComponent(txtLocal))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtRemoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSetTemp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSetTemp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRangeSec1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRangeVul1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboComActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboComActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        /////////////////////////////////////////////////////////
        //Lista que valida os campo do textfield não estão vazios 
        List<JTextField> lst = new ArrayList<>();
        lst.add(txtLocal);
        lst.add(txtRemoto);
        lst.add(txtSetTemp1);
        lst.add(txtSetTemp2);
        lst.add(txtRangeSec1);
        lst.add(txtRangeVul1);
        int setTemp = 240;

        if (CheckTextField.emptyList(lst) == true) {
            Alerts.showAlert("Campos não preenchidos", "Preencher todos os campos solicitados", "", TypePane.ERRO);
        } else {
            //Testa para ver se o diretorio selecionado é valido
            boolean sucess = new File(txtLocal.getText() + "/check").mkdir();

            if (sucess == true) {
                Path.setPath(new Path(PathList.LOCALFOLDER, txtLocal.getText()));
                // Exclui o diretorio que testou
                File check = new File(txtLocal.getText() + "/check");
                check.delete();
                try {
                    Path.setPath(new Path(PathList.ARDUINOCOM, cboCom.getSelectedItem().toString()));

                    // pega a String com o valor em minutos e transforma em segundos
                    switch (cboTempo.getSelectedItem().toString()) {
                        case ("1 min"):
                            setTemp = 60;
                            break;
                        case ("2 min"):
                            setTemp = 120;
                            break;
                        case ("3 min"):
                            setTemp = 180;
                            break;
                        case ("4 min"):
                            setTemp = 240;
                            break;
                        case ("5 min"):
                            setTemp = 300;
                            break;
                    }

                    // Carrega as configurações no arquivo
                    Path.setPath(new Path(PathList.TEMPOGRAVACAO, Integer.toString(setTemp)));
                    Path.setPath(new Path(PathList.CLOUDFOLDER, txtRemoto.getText()));
                    Path.setPath(new Path(PathList.TEMPERATURA_SET_1, txtSetTemp1.getText()));
                    Path.setPath(new Path(PathList.TEMPERATURA_SET_2, txtSetTemp2.getText()));
                    Path.setPath(new Path(PathList.RANGETEMPERATURA_1, txtRangeSec1.getText()));
                    Path.setPath(new Path(PathList.RANGETEMPERATURA_2, txtRangeVul1.getText()));

                    Alerts.showAlert("Diretorios Salvos", "Os configurações foram alteradas com sucesso", "", TypePane.INFORMATION);
                    this.dispose();
                } catch (Exception e) {
                    System.out.println("Alguma configuração não existe no arquivo config.txt: " + e.getMessage());
                }
            } else {
                Alerts.showAlert("Diretorio Inválido", "O caminho informado: " + txtLocal.getText() + " não existe.", "", TypePane.ERRO);
            }

        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtRangeVul1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRangeVul1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRangeVul1ActionPerformed

    private void cboTempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTempoActionPerformed

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
            java.util.logging.Logger.getLogger(ViewConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewConfiguracao dialog = new ViewConfiguracao(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cboCom;
    private javax.swing.JComboBox<String> cboTempo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtRangeSec1;
    private javax.swing.JTextField txtRangeVul1;
    private javax.swing.JTextField txtRemoto;
    private javax.swing.JTextField txtSetTemp1;
    private javax.swing.JTextField txtSetTemp2;
    // End of variables declaration//GEN-END:variables
}
