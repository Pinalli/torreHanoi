
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author AlbertoRochaPinalli
 */
public class TelaPRINCIPAL extends javax.swing.JFrame {

    int contaMov = 0;

    Stack Torre_A;
    Stack Torre_B;
    Stack Torre_C;

    DefaultTableModel ModelTorreA, ModelTorreB, ModelTorreC;

    int objetivo = 0;
    double numMovMin = 0;
    boolean parar = false;

    public TelaPRINCIPAL() {
	initComponents();
	ModelTorreA = (DefaultTableModel) tb_torreA.getModel();
	ModelTorreA.setRowCount(10);

	ModelTorreB = (DefaultTableModel) tb_torreB.getModel();
	ModelTorreB.setRowCount(10);

	ModelTorreC = (DefaultTableModel) tb_torreC.getModel();
	ModelTorreC.setRowCount(10);
	//Centraliza a torre A
	DefaultTableCellRenderer rendeA = new DefaultTableCellRenderer();
	rendeA.setHorizontalAlignment(SwingConstants.CENTER);
	tb_torreA.getColumnModel().getColumn(0).setCellRenderer(rendeA);
	//Centraliza a torre B
	DefaultTableCellRenderer rendeB = new DefaultTableCellRenderer();
	rendeB.setHorizontalAlignment(SwingConstants.CENTER);
	tb_torreB.getColumnModel().getColumn(0).setCellRenderer(rendeB);
	//Centraliza a torre C
	DefaultTableCellRenderer rendeC = new DefaultTableCellRenderer();
	rendeC.setHorizontalAlignment(SwingConstants.CENTER);
	tb_torreC.getColumnModel().getColumn(0).setCellRenderer(rendeC);
    }

    private void clear() {
	numMovMin = 0;
	contaMov = 0;
	cbNumDisco.setSelectedItem(String.valueOf(objetivo));
    }

    private void QuantidadeMovimento() {
	contaMov++;
	lblNumMovimentos.setText(String.valueOf(contaMov));

    }

    private void reiniciar() {

	try {

	    if (!lblMimMovimentos.getText().equals("")) {

		clear();
		iniciar();
	    }
	} catch (Exception e) {
	}

    }

    private void iniciar() {
	try {
	    Torre_A = new Stack();
	    Torre_B = new Stack();
	    Torre_C = new Stack();

	    objetivo = Integer.parseInt(cbNumDisco.getSelectedItem().toString());

	    numMovMin = Math.pow(2, objetivo) - 1;
	    lblNumMovimentos.setText(String.valueOf(contaMov));
	    lblMimMovimentos.setText(String.valueOf(String.format("%.0f", numMovMin)));

	    for (int i = objetivo; i >= 1; i--) {
		Nodo Guarda = new Nodo();
		String disco = "";

		for (int j = i; j > 0; j--) {
		    disco += "#";
		}
		Guarda.setDados(disco);
		Torre_A.Push(Guarda);
	    }

	    mostraTorreA();
	  //  mostraTorreB();
	  //  mostraTorreC();

	} catch (Exception e) {
	    System.out.println("Error: " + e.getMessage());
	}
    }

	 private void mostraTorreA() {
	   ((DefaultTableModel)tb_torreA.getModel()).setRowCount(0);
	   Nodo x;
	   int rowDisco = (10 - Torre_A.getCont());
	   if(Torre_A.getCont() > 0){
	       for(x = Torre_A.getHead();x.getEmbaixo() != null; x = x.getEmbaixo()){
		   String [] vetor = {x.getDados()};
		   ModelTorreA.insertRow(rowDisco , vetor);
		   rowDisco ++;
	       }
	       
	       if(x.getEmbaixo() == null){
		  String [] vetor = {x.getDados()};
		   ModelTorreA.insertRow(rowDisco , vetor);
	       }
	   }
	   tb_torreA.setModel(ModelTorreA);
	   ModelTorreA.setRowCount(10);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_torreA = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_torreC = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_torreB = new javax.swing.JTable();
        btnA_B = new javax.swing.JButton();
        btnA_C = new javax.swing.JButton();
        btnB_A = new javax.swing.JButton();
        btnB_C = new javax.swing.JButton();
        btnC_A = new javax.swing.JButton();
        btnC_B = new javax.swing.JButton();
        cbNumDisco = new javax.swing.JComboBox<>();
        lblNumMovimentos = new javax.swing.JLabel();
        lblMimMovimentos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnResolver = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb_torreA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre A"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_torreA.setAutoscrolls(false);
        tb_torreA.setFocusable(false);
        tb_torreA.setRowSelectionAllowed(false);
        tb_torreA.setShowHorizontalLines(false);
        tb_torreA.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tb_torreA);
        if (tb_torreA.getColumnModel().getColumnCount() > 0) {
            tb_torreA.getColumnModel().getColumn(0).setResizable(false);
        }

        tb_torreC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre C"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_torreC.setAutoscrolls(false);
        tb_torreC.setFocusable(false);
        tb_torreC.setRowSelectionAllowed(false);
        tb_torreC.setShowHorizontalLines(false);
        tb_torreC.setShowVerticalLines(false);
        jScrollPane3.setViewportView(tb_torreC);
        if (tb_torreC.getColumnModel().getColumnCount() > 0) {
            tb_torreC.getColumnModel().getColumn(0).setResizable(false);
        }

        tb_torreB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre B"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_torreB.setAutoscrolls(false);
        tb_torreB.setFocusable(false);
        tb_torreB.setRowSelectionAllowed(false);
        tb_torreB.setShowHorizontalLines(false);
        tb_torreB.setShowVerticalLines(false);
        jScrollPane4.setViewportView(tb_torreB);
        if (tb_torreB.getColumnModel().getColumnCount() > 0) {
            tb_torreB.getColumnModel().getColumn(0).setResizable(false);
        }

        btnA_B.setText("B");

        btnA_C.setText("C");

        btnB_A.setText("A");

        btnB_C.setText("C");

        btnC_A.setText("A");

        btnC_B.setText("B");

        cbNumDisco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8", "9", "10" }));

        lblNumMovimentos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblNumMovimentos.setForeground(new java.awt.Color(255, 0, 0));
        lblNumMovimentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumMovimentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMimMovimentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMimMovimentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setText("Numero Minimo de Mov");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setText("Numero de Discos");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setText("Numero de Movimentos");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnResolver.setText("Resolver");

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnA_B)
                        .addGap(18, 18, 18)
                        .addComponent(btnA_C)
                        .addGap(154, 154, 154)
                        .addComponent(btnB_A)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnB_C)
                        .addGap(152, 152, 152)
                        .addComponent(btnC_A)
                        .addGap(18, 18, 18)
                        .addComponent(btnC_B))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumMovimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblMimMovimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbNumDisco, 0, 291, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnIniciar)
                        .addGap(72, 72, 72)
                        .addComponent(btnReiniciar)
                        .addGap(87, 87, 87)
                        .addComponent(btnResolver)))
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnB_A)
                    .addComponent(btnB_C)
                    .addComponent(btnC_A)
                    .addComponent(btnC_B)
                    .addComponent(btnA_B)
                    .addComponent(btnA_C))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbNumDisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMimMovimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(lblNumMovimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(btnReiniciar)
                    .addComponent(btnResolver))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
	reiniciar();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
		iniciar();

    }//GEN-LAST:event_btnIniciarActionPerformed

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
	    java.util.logging.Logger.getLogger(TelaPRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(TelaPRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(TelaPRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(TelaPRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new TelaPRINCIPAL().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA_B;
    private javax.swing.JButton btnA_C;
    private javax.swing.JButton btnB_A;
    private javax.swing.JButton btnB_C;
    private javax.swing.JButton btnC_A;
    private javax.swing.JButton btnC_B;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnResolver;
    private javax.swing.JComboBox<String> cbNumDisco;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblMimMovimentos;
    private javax.swing.JLabel lblNumMovimentos;
    private javax.swing.JTable tb_torreA;
    private javax.swing.JTable tb_torreB;
    private javax.swing.JTable tb_torreC;
    // End of variables declaration//GEN-END:variables
}
