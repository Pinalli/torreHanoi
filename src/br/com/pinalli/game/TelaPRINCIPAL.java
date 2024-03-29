package br.com.pinalli.game;


import java.awt.HeadlessException;
import javax.swing.JOptionPane;
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
    double numMinMov = 0;
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
	contaMov = 0;
	numMinMov = 0;
	cbNumDisco.setSelectedItem(String.valueOf(objetivo));
    }

    private void QuantidaDeMovimento() {
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
	    System.out.println("Error: " + e.getMessage());
	}

    }

    private void iniciar() {
	try {
	    Torre_A = new Stack();
	    Torre_B = new Stack();
	    Torre_C = new Stack();

	    //quantidade de discos
	    objetivo = Integer.parseInt(cbNumDisco.getSelectedItem().toString());
	    numMinMov = Math.pow(2, objetivo) - 1;
	    lblNumMovimentos.setText(String.valueOf(contaMov));
	    lblMimMovimentos.setText(String.valueOf(String.format("%.0f", numMinMov)));

	    for (int i = objetivo; i >= 1; i--) {
		Nodo GuardaDiscos = new Nodo();
		String disco = "";

		for (int j = i; j > 0; j--) {
		    disco += "#";
		}
		GuardaDiscos.setDados(disco);
		Torre_A.Push(GuardaDiscos);
	    }

	    mostraTorreA();
	    mostraTorreB();
	    mostraTorreC();

	} catch (NumberFormatException e) {
	    System.out.println("Error: " + e.getMessage());
	}
    }

    private void mostraTorreA() {
	((DefaultTableModel) tb_torreA.getModel()).setRowCount(0);
	ModelTorreA.setRowCount(10);
	Nodo x;

	int rowDiscos = (7 - Torre_A.getCont());
	if (Torre_A.getCont() > 0) {
	    for (x = Torre_A.getHead(); x.getEmbaixo() != null; x = x.getEmbaixo()) {
		String[] vetorN = {x.getDados()};
		ModelTorreA.insertRow(rowDiscos, vetorN);
		rowDiscos++;
	    }

	    if (x.getEmbaixo() == null) {
		String[] vetorN = {x.getDados()};
		ModelTorreA.insertRow(rowDiscos, vetorN);
	    }
	}
	tb_torreA.setModel(ModelTorreA);
	ModelTorreA.setRowCount(10);
    }

    private void mostraTorreB() {
	((DefaultTableModel) tb_torreB.getModel()).setRowCount(0);
	ModelTorreB.setRowCount(10);
	Nodo x;

	int rowDiscos = (7 - Torre_B.getCont());
	if (Torre_B.getCont() > 0) {
	    for (x = Torre_B.getHead(); x.getEmbaixo() != null; x = x.getEmbaixo()) {
		String[] vetorN = {x.getDados()};
		ModelTorreB.insertRow(rowDiscos, vetorN);
		rowDiscos++;
	    }

	    if (x.getEmbaixo() == null) {
		String[] vetorN = {x.getDados()};
		ModelTorreB.insertRow(rowDiscos, vetorN);
	    }
	}
	tb_torreB.setModel(ModelTorreB);
	ModelTorreB.setRowCount(10);
    }

    private void mostraTorreC() {
	((DefaultTableModel) tb_torreC.getModel()).setRowCount(0);
	ModelTorreC.setRowCount(10);
	Nodo x;

	int rowDiscos = (7 - Torre_C.getCont());
	if (Torre_C.getCont() > 0) {
	    for (x = Torre_C.getHead(); x.getEmbaixo() != null; x = x.getEmbaixo()) {
		String[] vetorN = {x.getDados()};
		ModelTorreC.insertRow(rowDiscos, vetorN);
		rowDiscos++;
	    }

	    if (x.getEmbaixo() == null) {
		String[] vetorN = {x.getDados()};
		ModelTorreC.insertRow(rowDiscos, vetorN);
	    }
	}
	tb_torreC.setModel(ModelTorreC);
	ModelTorreC.setRowCount(10);
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
        btnReiniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        setBackground(new java.awt.Color(0, 102, 102));
        setPreferredSize(new java.awt.Dimension(631, 571));

        tb_torreA.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tb_torreA.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 16)); // NOI18N
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

        tb_torreB.setFont(new java.awt.Font("Tempus Sans ITC", 0, 16)); // NOI18N
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
        btnA_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA_BActionPerformed(evt);
            }
        });

        btnA_C.setText("C");
        btnA_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA_CActionPerformed(evt);
            }
        });

        btnB_A.setText("A");
        btnB_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB_AActionPerformed(evt);
            }
        });

        btnB_C.setText("C");
        btnB_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB_CActionPerformed(evt);
            }
        });

        btnC_A.setText("A");
        btnC_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC_AActionPerformed(evt);
            }
        });

        btnC_B.setText("B");
        btnC_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC_BActionPerformed(evt);
            }
        });

        cbNumDisco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", " " }));

        lblNumMovimentos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblNumMovimentos.setForeground(new java.awt.Color(255, 0, 0));
        lblNumMovimentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumMovimentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMimMovimentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMimMovimentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        jLabel3.setText("Nº máximo de movimentos");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        jLabel4.setText("Número de Discos");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        jLabel5.setText("Nº de movimentos");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnIniciar.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnReiniciar.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("TORRE DE HANÓI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(211, 211, 211))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnIniciar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnReiniciar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblMimMovimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblNumMovimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbNumDisco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(163, 163, 163))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(btnA_B)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnA_C)
                                .addGap(105, 105, 105)
                                .addComponent(btnB_A)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnB_C)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                .addComponent(btnC_A)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnC_B)
                                .addGap(66, 66, 66)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnA_C, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnA_B)
                    .addComponent(btnB_C)
                    .addComponent(btnB_A)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnC_A)
                        .addComponent(btnC_B)))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbNumDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMimMovimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNumMovimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReiniciar)
                    .addComponent(btnIniciar))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
	reiniciar();
    }//GEN-LAST:event_btnReiniciarActionPerformed
    private void moveDeA_B() {
	try {
	    if (Torre_A.getCont() > 0) {
		Nodo GuardaDiscos = new Nodo();
		GuardaDiscos.setDados(Torre_A.Peek());

		if (Torre_B.getCont() > 0) {
		    if (GuardaDiscos.getDados().compareTo(Torre_B.Peek()) > 0) {
			return;
		    }
		}

		Torre_A.PoP();
		Torre_B.Push(GuardaDiscos);

		mostraTorreA();
		mostraTorreB();
		QuantidaDeMovimento();
                if (Torre_B.getCont() == objetivo && contaMov == numMinMov) {
		    JOptionPane.showMessageDialog(null, "Parabéns, você alcançou o objetivo de minimos movimentos!\n\n Tenta outro nível de dificuldade", "Parabéns", JOptionPane.WARNING_MESSAGE);

		} else if (Torre_B.getCont() == objetivo && contaMov != numMinMov) {
		    JOptionPane.showMessageDialog(null, "Oh não!!!,você ultrapassou o mínimo de movimentos\n\nTenta superar o objetivo! ", "\nBoa sorte!", JOptionPane.INFORMATION_MESSAGE);
		}
	    }
	} catch (HeadlessException e) {
	}
    }
    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
         contaMov = 0;	 
	iniciar();

    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnA_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA_BActionPerformed
	moveDeA_B();
    }//GEN-LAST:event_btnA_BActionPerformed
    private void moveDeA_C() {
	try {
	    if (Torre_A.getCont() > 0) {
		Nodo GuardaDiscos = new Nodo();
		GuardaDiscos.setDados(Torre_A.Peek());

		if (Torre_C.getCont() > 0) {
		    if (GuardaDiscos.getDados().compareTo(Torre_C.Peek()) > 0) {
			return;
		    }
		}

		Torre_A.PoP();
		Torre_C.Push(GuardaDiscos);

		mostraTorreA();
		mostraTorreC();
		QuantidaDeMovimento();

		if (Torre_C.getCont() == objetivo && contaMov == numMinMov) {
		    JOptionPane.showMessageDialog(null, "Parabéns!,\n Você alcançou o objetivo de minimos movimentos!\n\n Tenta outro nível de dificuldade", "Parabéns!!", JOptionPane.WARNING_MESSAGE);

		} else if (Torre_C.getCont() == objetivo && contaMov != numMinMov) {
		    JOptionPane.showMessageDialog(null, "Oh não!!!,\n Você ultrapassou o mínimo de movimentos\n\nTenta superar o objetivo ", "\nBoa sorte!", JOptionPane.INFORMATION_MESSAGE);
		}

	    }
	} catch (HeadlessException e) {
	}
    }


    private void btnA_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA_CActionPerformed
	moveDeA_C();
    }//GEN-LAST:event_btnA_CActionPerformed
    private void moveDeB_A() {
	try {
	    if (Torre_B.getCont() > 0) {
		Nodo GuardaDiscos = new Nodo();
		GuardaDiscos.setDados(Torre_B.Peek());

		if (Torre_A.getCont() > 0) {
		    if (GuardaDiscos.getDados().compareTo(Torre_A.Peek()) > 0) {
			return;
		    }
		}

		Torre_B.PoP();
		Torre_A.Push(GuardaDiscos);

		mostraTorreA();
		mostraTorreB();
		QuantidaDeMovimento();
                if (Torre_A.getCont() == objetivo && contaMov == numMinMov) {
		    JOptionPane.showMessageDialog(null, "Parabéns!!!,\nVocê alcançou o objetivo de minimos movimentos\n\n Tente outro nível de dificuldade", "Parabéns!", JOptionPane.WARNING_MESSAGE);

		} else if (Torre_A.getCont() == objetivo && contaMov != numMinMov) {
		    JOptionPane.showMessageDialog(null, "Oh não!!!,\nVocê ultrapassou o mínimo de movimentos\n\nTente superar o objetivo ", "\nBoa sorte!", JOptionPane.INFORMATION_MESSAGE);
		}
	    }
	} catch (HeadlessException e) {
	}

    }
    private void btnB_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB_AActionPerformed
	moveDeB_A();
    }//GEN-LAST:event_btnB_AActionPerformed
    
    private void moveDeB_C(){
	try {
	    if (Torre_B.getCont() > 0) {
		Nodo GuardaDiscos = new Nodo();
		GuardaDiscos.setDados(Torre_B.Peek());

		if (Torre_C.getCont() > 0) {
		    if (GuardaDiscos.getDados().compareTo(Torre_C.Peek()) > 0) {
			return;
		    }
		}

		Torre_B.PoP();
		Torre_C.Push(GuardaDiscos);

		mostraTorreB();
		mostraTorreC();
		QuantidaDeMovimento();

		if (Torre_C.getCont() == objetivo && contaMov == numMinMov) {
		    JOptionPane.showMessageDialog(null, "Parabéns!,\n Você alcançou o objetivo de minimos movimentos!\n\n Tente outro nível de dificuldade", "Parabéns!", JOptionPane.WARNING_MESSAGE);

		} else if (Torre_C.getCont() == objetivo && contaMov != numMinMov) {
		    JOptionPane.showMessageDialog(null, "Parabéns!,\nvocê atingiu o resultado\n\nTenta superar o objtivo ", "Parabéns!", JOptionPane.INFORMATION_MESSAGE);
		}

	    }
	} catch (HeadlessException e) {
	}
    }
    private void btnB_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB_CActionPerformed
          moveDeB_C();
    }//GEN-LAST:event_btnB_CActionPerformed
    private void  moveDeC_A(){
	
	try {
	    if (Torre_C.getCont() > 0) {
		Nodo GuardaDiscos = new Nodo();
		GuardaDiscos.setDados(Torre_C.Peek());

		if (Torre_A.getCont() > 0) {
		    if (GuardaDiscos.getDados().compareTo(Torre_A.Peek()) > 0) {
			return;
		    }
		}

		Torre_C.PoP();
		Torre_A.Push(GuardaDiscos);

		mostraTorreA();
		mostraTorreC();
		QuantidaDeMovimento();

	    }
	} catch (Exception e) {
	}
    }
    private void btnC_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC_AActionPerformed
        moveDeC_A();
    }//GEN-LAST:event_btnC_AActionPerformed
    
    private void  moveDeC_B(){
	try {
	    if (Torre_C.getCont() > 0) {
		Nodo GuardaDiscos = new Nodo();
		GuardaDiscos.setDados(Torre_C.Peek());

		if (Torre_B.getCont() > 0) {
		    if (GuardaDiscos.getDados().compareTo(Torre_B.Peek()) > 0) {
			return;
		    }
		}

		Torre_C.PoP();
		Torre_B.Push(GuardaDiscos);

		mostraTorreB();
		mostraTorreC();
		QuantidaDeMovimento();

		
	    }
	} catch (Exception e) {
	}
	
    }
    public static void main(String[] args) {
      
	java.awt.EventQueue.invokeLater(() -> {
            new TelaPRINCIPAL().setVisible(true);
        });
        try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(TelaPRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
    }
    private void btnC_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC_BActionPerformed
        moveDeC_B();
    }//GEN-LAST:event_btnC_BActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA_B;
    private javax.swing.JButton btnA_C;
    private javax.swing.JButton btnB_A;
    private javax.swing.JButton btnB_C;
    private javax.swing.JButton btnC_A;
    private javax.swing.JButton btnC_B;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JComboBox<String> cbNumDisco;
    private javax.swing.JLabel jLabel1;
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
