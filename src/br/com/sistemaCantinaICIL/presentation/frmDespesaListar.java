package br.com.sistemaCantinaICIL.presentation;

import br.com.sistemaCantinaICIL.dao.DespesaDAO;
import br.com.sistemaCantinaICIL.extras.ChangeColorDespesa;
import br.com.sistemaCantinaICIL.interfaces.CentralizeJInternalFrame;
import br.com.sistemaCantinaICIL.model.Despesa;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

public class frmDespesaListar extends JInternalFrame
        implements InternalFrameListener, CentralizeJInternalFrame {

    //Variaveis
    private final Dimension SIZE_JFRAME;
    private final SimpleDateFormat format2 = new SimpleDateFormat("dd/MMM/yyyy");
    private DespesaDAO despesaDAO;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagemDespesas = new javax.swing.JTable();
        cmbMeses = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        lblTipoBusca = new javax.swing.JLabel();
        cmbSituacaoVenda = new javax.swing.JComboBox();
        lblTipoBusca1 = new javax.swing.JLabel();
        cmbTipoBusca = new javax.swing.JComboBox();
        btnBuscarTodasDespesas = new javax.swing.JButton();
        lblTipoBusca2 = new javax.swing.JLabel();
        cmbOrdenação = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Lista de Despesas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_parcela.png"))); // NOI18N
        setName(""); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        lblMes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblMes.setText("Despesas do Mês de:");

        tblListagemDespesas.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        tblListagemDespesas.setForeground(java.awt.Color.black);
        tblListagemDespesas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListagemDespesas.setGridColor(java.awt.Color.black);
        tblListagemDespesas.setName("Tabela"); // NOI18N
        tblListagemDespesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListagemDespesasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListagemDespesas);
        tblListagemDespesas.getAccessibleContext().setAccessibleName("Tabela");

        cmbMeses.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        cmbMeses.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos os Meses", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        btnBuscar.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_lupa.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblTipoBusca.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTipoBusca.setText("Ver:");

        cmbSituacaoVenda.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        cmbSituacaoVenda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Despesas Abertas", "Despesas Pagas" }));

        lblTipoBusca1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTipoBusca1.setText("Ver:");

        cmbTipoBusca.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        cmbTipoBusca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas as Despesas", "Despesas Atrasadas" }));

        btnBuscarTodasDespesas.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnBuscarTodasDespesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_files.png"))); // NOI18N
        btnBuscarTodasDespesas.setText("Ver todas as Despesas");
        btnBuscarTodasDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTodasDespesasActionPerformed(evt);
            }
        });

        lblTipoBusca2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTipoBusca2.setText("Ordernar por: ");

        cmbOrdenação.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        cmbOrdenação.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome da Despesa", "Data de Vencimento" }));
        cmbOrdenação.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrdenaçãoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTipoBusca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSituacaoVenda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTipoBusca1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTipoBusca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTipoBusca2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbOrdenação, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnBuscarTodasDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTipoBusca2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbOrdenação, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTipoBusca1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbTipoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTipoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbSituacaoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarTodasDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Construtor..........................................................................................................................................
    public frmDespesaListar(Dimension sizeJFrame) {

        // Inicializa os componentes
        initComponents();
        this.SIZE_JFRAME = sizeJFrame;
        this.despesaDAO = new DespesaDAO();

        setFrame();
    }

    // Método que seta as configurações do frame........................................................................................
    private void setFrame() {

        // Configuração da Interface InternalFramListener
        this.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
        this.addInternalFrameListener(this);

        // Altera as cores da tabela
        ChangeColorDespesa changeColor = new ChangeColorDespesa();
        tblListagemDespesas.setDefaultRenderer(Object.class, changeColor);

        // Chama o metodo para atualizar a situaçao das Despesas
        despesaDAO.updateExpenseSituation();

        // Chama o método pra preencher a lista de Despesas
        try {
            fillTabel(despesaDAO.Listar());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    // Método que preenche a Tabela com os dados......................................................................................
    private void fillTabel(List<Despesa> list) throws Exception {

        Date dataAtual = new Date();
        Calendar calAtual = Calendar.getInstance();
        calAtual.setTime(dataAtual);

        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Situaçao");
            model.addColumn("Código");
            model.addColumn("Nome");
            model.addColumn("Descrição");
            model.addColumn("Valor");
            model.addColumn("Vencimento");
            model.addColumn("Pagamento");

            for (Despesa d : list) {

                Vector values = new Vector();
                String strPagamento = "";
                String strVencimento = format2.format(d.getDataVencimento().getTime());
                String strSituacao = null;

                // Data de Pagamento
                if (d.getDataPagamento() != null) {
                    strPagamento = format2.format(d.getDataPagamento().getTime());
                }
                
                // Situacao
                if(d.getDataVencimento().before(calAtual) && d.getDataPagamento() == null){
                    strSituacao = "ATRASADA";
                }
                else{
                    strSituacao = d.getSituacao().toString();
                }

                values.add(0, strSituacao);
                values.add(1, d.getId());
                values.add(2, d.getNome());
                values.add(3, d.getDescricao());
                values.add(4, "R$ " + d.getValor());
                values.add(5, strVencimento);
                values.add(6, strPagamento);

                model.addRow(values);
            }

            tblListagemDespesas.setModel(model);
            tblListagemDespesas.repaint();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Não foi possivel Listar as Despesas");
        }
    }

    // Método para o Botão BUSCAR.............................................................................................................
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {

            int mes = 0;
            int ordenacao = 0;
            String situacao = null;
            String tipo = null;

            // Mes            
            switch (cmbMeses.getSelectedIndex()) {
                case 0:
                    mes = 0;
                    break;
                case 1:
                    mes = 1;
                    break;
                case 2:
                    mes = 2;
                    break;
                case 3:
                    mes = 3;
                    break;
                case 4:
                    mes = 4;
                    break;
                case 5:
                    mes = 5;
                    break;
                case 6:
                    mes = 6;
                    break;
                case 7:
                    mes = 7;
                    break;
                case 8:
                    mes = 8;
                    break;
                case 9:
                    mes = 9;
                    break;
                case 10:
                    mes = 10;
                    break;
                case 11:
                    mes = 11;
                    break;
                case 12:
                    mes = 12;
                    break;
            }

            // Situacao
            if (cmbSituacaoVenda.getSelectedIndex() == 0) {
                situacao = "ABERTA";
            } else {
                situacao = "PAGA";
            }

            // Tipo
            if (cmbTipoBusca.getSelectedIndex() == 0) {
                tipo = null;
            } else {
                tipo = "Atrasadas";
            }
            
            // Ordenacao
            if(cmbOrdenação.getSelectedIndex() == 0){
                ordenacao = 1; // Nome da Despesa
            }
            else{
                ordenacao = 2; // Data de Vencimento
            }

            // Chama o metodo de Busca
            List<Despesa> list = despesaDAO.Buscar(mes, situacao, tipo, ordenacao);

            // Chama o metodo para preencher a tabela
            fillTabel(list);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao tentar busca as despesas");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    // Metodo para o clique em um dos registros da tabela............................................................................
    private void tblListagemDespesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListagemDespesasMouseClicked

        try {

            // Pega o ID da despesa clicada
            Object objID = tblListagemDespesas.getValueAt(tblListagemDespesas.getSelectedRow(), 1);

            // Abre a Despesa
            Despesa despesa = despesaDAO.Abrir((Long) objID);

            // Abre o Frame de Edição de Despesas
            frmDespesaEditar window = new frmDespesaEditar(SIZE_JFRAME, despesa);
            this.getParent().add(window);
            centralizaForm(window);
            window.setVisible(true);

            // Fecha o Frame atual
            this.setVisible(false);
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um problema ao tentar abrir a Despesa!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblListagemDespesasMouseClicked

    // Botão TODAS AS DESPESAS................................................................................................................
    private void btnBuscarTodasDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTodasDespesasActionPerformed
        try {

            // Chama o método de Listar
            List<Despesa> list = despesaDAO.Listar();

            // Chama o método para preencher a tabela
            fillTabel(list);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao tentar busca as despesas");
        }
    }//GEN-LAST:event_btnBuscarTodasDespesasActionPerformed

    private void cmbOrdenaçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrdenaçãoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOrdenaçãoActionPerformed

    // Método que centraliza o JInternalFrame...............................................................................................
    @Override
    public void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = SIZE_JFRAME;
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarTodasDespesas;
    private javax.swing.JComboBox cmbMeses;
    private javax.swing.JComboBox cmbOrdenação;
    private javax.swing.JComboBox cmbSituacaoVenda;
    private javax.swing.JComboBox cmbTipoBusca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblTipoBusca;
    private javax.swing.JLabel lblTipoBusca1;
    private javax.swing.JLabel lblTipoBusca2;
    private javax.swing.JTable tblListagemDespesas;
    // End of variables declaration//GEN-END:variables

    // Método chamado quando se fecha o JInternalFrame pelo botão fechar...................................................
    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        this.setVisible(false);
        this.dispose();
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
    }
}
