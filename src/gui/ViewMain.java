/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import model.util.Writer;
import model.util.Path;
import model.enums.PathList;
import model.util.Utils;
import arduino.util.ArduinoSerial;
import gui.util.Alerts;
import gui.util.Grafico;
import gui.util.CountHour;
import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import model.entities.LeituraMaquina;
import model.enums.TypePane;
import model.exceptions.ArduinoException;

/**
 *
 * @author Herbert
 */
public class ViewMain extends javax.swing.JFrame {

    /**
     * Creates new form ViewTemperaura
     */
    public ViewMain() {
        initComponents();
        Locale.setDefault(Locale.US);
        Path.InitialConfig();
        String log = "Inicializando o Sistema";
        geraLog(log);
        Grafico.carregaGrafico(Utils.getDataFormated_(), sclGrafico, "Grafico", 980, 500, 1);
        this.setExtendedState(MAXIMIZED_BOTH);

        Thread tr1 = new Thread() {
            @Override
            public void run() {
                // Este while se precisar recomeçar a comunicação, se a porta estiver errada 
                while(true){
                String currentCOM = Path.loadPath(PathList.ARDUINOCOM);
                String lastLog = "";
                
                try {
                    String sendedData = null;
                    int contNew = 0;
                    // Variaveis para o horimetro
                    boolean addHour = false;
                    Calendar cal1 = Calendar.getInstance();
                    Date d1 = new Date(System.currentTimeMillis());
                    lblHorimetro.setText(CountHour.formatHour(Path.loadPath(PathList.HORIMETRO)));
                    
                    ArduinoSerial arduino = new ArduinoSerial(Path.loadPath(PathList.ARDUINOCOM));
                    arduino.initialize();
                    arduino.sleep(3000);
                  
                    while (true) {
                        
                        //Força recriar uma nova comunicação com o arduino
                        if (!currentCOM.equals(Path.loadPath(PathList.ARDUINOCOM))){
                        break;
                        }

                        try {
                            //Logica para envio de dados
                            String sendData = "{" + Path.loadPath(PathList.TEMPOGRAVACAO) + ", " + Path.loadPath(PathList.TEMPERATURA_SET_1) + ", " + Path.loadPath(PathList.TEMPERATURA_SET_2)
                                    + ", " + Path.loadPath(PathList.RANGETEMPERATURA_1) + ", " + Path.loadPath(PathList.RANGETEMPERATURA_2) + ", " + Path.loadPath(PathList.OFFSETSECAGEM_1)
                                    + ", " + Path.loadPath(PathList.OFFSETVULCANICACAO_1) + "}";
                           
                            //Compara o ultimo arquivo enviado com o do arquivo config.txt
                            if (!(sendData).equals(sendedData)) {
                                arduino.send(sendData);
                                sendedData = sendData;
                                if (contNew != 0) {
                                    Alerts.showAlert("Atualização", "Uma nova configuração foi detectada", "", TypePane.INFORMATION);
                                }
                                contNew++;
                                arduino.sleep(1000);
                            }
                        } catch (ArduinoException e) {
                            System.out.println("Erro ao escrever as configurações no arduino" + e.getMessage());
                        }

                        arduino.send(" ");
                        arduino.sleep(1000);

                        //Recebimento de dados do arduino
                        if (arduino.read() != null) {
                            // System.out.println(arduino.read());

                            try {
                                //Recebe String da leitura do arduino
                                String dadosArduino = arduino.read();

                                //Verifica se os dados estão no formato correto///////////
                                if (dadosArduino.indexOf("{") == 0 && dadosArduino.indexOf("}") == dadosArduino.length() - 1) {
                                    String parameter = dadosArduino.substring(1, dadosArduino.length() - 1);
                                    String[] dados = parameter.split(", ");
                                    String z1 = dados[0];
                                    String z2 = dados[1];
                                    String estado = dados[2];
                                    String cmdSalvar = dados[3];

                                    Double tempSec1 = Double.parseDouble(z1);
                                    Double tempVul1 = Double.parseDouble(z2);

                                    lblZ1.setText(tempSec1.toString());
                                    lblZ2.setText(tempVul1.toString());
                                    lblEstado.setText(estado);

                                    Date d2 = new Date(System.currentTimeMillis());

                                    if (("Ligada".equals(estado) || "Ligando...".equals(estado)
                                            || "Alarme Temperatura".equals(estado)) && addHour == false) {
                                        addHour = true;
                                        cal1.setTime(d2);
                                        cal1.add(Calendar.SECOND, 10);
                                        d1 = cal1.getTime();
                                    }

                                    if (addHour == true && (d2).after(d1)) {
                                        CountHour.homerimetro(d1, -10);
                                        cal1.setTime(d2);
                                        cal1.add(Calendar.SECOND, 10);
                                        d1 = cal1.getTime();
                                        lblHorimetro.setText(CountHour.formatHour(Path.loadPath(PathList.HORIMETRO)));

                                    }

                                    if (("Desligada".equals(estado) || "Desligando...".equals(estado)) && addHour == true) {
                                        CountHour.homerimetro(d1, 0);
                                        lblHorimetro.setText(CountHour.formatHour(Path.loadPath(PathList.HORIMETRO)));
                                        addHour = false;
                                    }

                                    if (!"Comunicação estabelecida".equals(lastLog)) {
                                        geraLog("Comunicação estabelecida");
                                        lastLog = "Comunicação estabelecida";
                                    }

                                    LeituraMaquina leitura = new LeituraMaquina(tempSec1, tempVul1, estado);

                                    if ("salvar".equals(cmdSalvar)) {
                                        System.out.println("Registro " + Utils.getDataSistema());
                                        Writer.write(leitura);
                                        Grafico.carregaGrafico(Utils.getDataFormated_(), sclGrafico, "Grafico", 980, 500, 1);
                                    }
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Erro ao carregar valores:" + e.getMessage());
                                if (!"Erro ao carregar os valores".equals(lastLog)) {
                                    erroLog("Erro ao carregar os valores");
                                    lastLog = "Erro ao carregar os valores";
                                }
                            }

                        } else if (!"Carregando os dados do arduino...".equals(lastLog)) {
                            erroLog("Carregando os dados do arduino...");
                            lastLog = "Carregando os dados do arduino...";
                        }

                    }
                } catch (UnsatisfiedLinkError e) {
                    erroLog("Erro ao acessar o Arduino");
                }
            }
            }
        };

        tr1.start();

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
        jPanel2 = new javax.swing.JPanel();
        lblZ2 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblZ1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblHorimetro = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        sPnl1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        pnlGrafico = new javax.swing.JPanel();
        sclGrafico = new javax.swing.JScrollPane();
        lblGrafico = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemOffSet = new javax.swing.JMenuItem();
        ItemConfig = new javax.swing.JMenuItem();
        itemHistorico = new javax.swing.JMenuItem();
        itemRegistro = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Temperatura");
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblZ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblZ2.setText("Aberto");
        lblZ2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblZ2.setName("lblZ2"); // NOI18N

        lblEstado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEstado.setText("No Feedback");
        lblEstado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblEstado.setName("lblZ1"); // NOI18N

        lblZ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblZ1.setText("Aberto");
        lblZ1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblZ1.setName("lblZ1"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Temperatura Vulcanização");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Estado:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Temperatura Secagem");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel1.setText("Maquina 1");

        lblHorimetro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHorimetro.setText("null");

        lbl3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl3.setText("Horimetro:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblZ2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblZ1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHorimetro, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblZ1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblZ2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblEstado))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHorimetro)
                    .addComponent(lbl3))
                .addContainerGap())
        );

        sPnl1.setBackground(java.awt.Color.white);
        sPnl1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sPnl1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPnl1.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Log de trabalho"));

        txtLog.setColumns(20);
        txtLog.setRows(5);
        txtLog.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLog.setEnabled(false);
        sPnl1.setViewportView(txtLog);

        pnlGrafico.setBackground(new java.awt.Color(255, 255, 255));
        pnlGrafico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sclGrafico.setBackground(new java.awt.Color(255, 255, 255));

        lblGrafico.setBackground(new java.awt.Color(255, 255, 255));
        lblGrafico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sclGrafico.setViewportView(lblGrafico);

        javax.swing.GroupLayout pnlGraficoLayout = new javax.swing.GroupLayout(pnlGrafico);
        pnlGrafico.setLayout(pnlGraficoLayout);
        pnlGraficoLayout.setHorizontalGroup(
            pnlGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sclGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );
        pnlGraficoLayout.setVerticalGroup(
            pnlGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sclGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );

        jMenu1.setText("Menu");

        itemOffSet.setText("Ajustes OffSet");
        itemOffSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOffSetActionPerformed(evt);
            }
        });
        jMenu1.add(itemOffSet);

        ItemConfig.setText("Configurações");
        ItemConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemConfigActionPerformed(evt);
            }
        });
        jMenu1.add(ItemConfig);

        itemHistorico.setText("Histórico");
        itemHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemHistoricoMouseClicked(evt);
            }
        });
        itemHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHistoricoActionPerformed(evt);
            }
        });
        jMenu1.add(itemHistorico);

        jMenuBar1.add(jMenu1);

        itemRegistro.setText("Ajuda");

        jMenuItem1.setText("Registros");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        itemRegistro.add(jMenuItem1);

        jMenuBar1.add(itemRegistro);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(sPnl1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(sPnl1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ViewRegistro viewRegistro = new ViewRegistro(this, rootPaneCheckingEnabled);
        viewRegistro.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void itemHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHistoricoActionPerformed
        ViewHistoric viewHistoric = new ViewHistoric();
        viewHistoric.setVisible(true);
    }//GEN-LAST:event_itemHistoricoActionPerformed

    private void itemHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemHistoricoMouseClicked

    }//GEN-LAST:event_itemHistoricoMouseClicked

    private void ItemConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemConfigActionPerformed
        ViewConfiguracao viewPathuracao = new ViewConfiguracao(this, rootPaneCheckingEnabled);
        viewPathuracao.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_ItemConfigActionPerformed

    private void itemOffSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOffSetActionPerformed
        ViewOffset viewOffset = new ViewOffset(this, rootPaneCheckingEnabled);
        viewOffset.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_itemOffSetActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ViewMain().setVisible(true);
        });
    }

    private void geraLog(String log) {
        txtLog.setDisabledTextColor(Color.black);
        txtLog.append("[" + Utils.getDataHoraSistema() + "] " + log + "\n");
    }

    private void erroLog(String msg) {
        System.err.println(msg);
        geraLog(msg);
        txtLog.setDisabledTextColor(Color.red);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemConfig;
    private javax.swing.JMenuItem itemHistorico;
    private javax.swing.JMenuItem itemOffSet;
    private javax.swing.JMenu itemRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblGrafico;
    private javax.swing.JLabel lblHorimetro;
    private javax.swing.JLabel lblZ1;
    private javax.swing.JLabel lblZ2;
    private javax.swing.JPanel pnlGrafico;
    private javax.swing.JScrollPane sPnl1;
    private javax.swing.JScrollPane sclGrafico;
    private javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables
}
