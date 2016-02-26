package br.com.sistemaCantinaICIL.presentation;

import br.com.sistemaCantinaICIL.dao.RendimentoDAO;
import br.com.sistemaCantinaICIL.extras.ChangeColorRendimento;
import br.com.sistemaCantinaICIL.interfaces.CentralizeJInternalFrame;
import br.com.sistemaCantinaICIL.model.Rendimento;
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

public class frmRendimentoListar extends JInternalFrame
        implements InternalFrameListener, CentralizeJInternalFrame {

    //Variaveis
    private final Dimension SIZE_JFRAME;
    private final SimpleDateFormat format2 = new SimpleDateFormat("dd/MMM/yyyy");
    private RendimentoDAO rendimentoDAO;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();
        cmbMeses = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        btnBuscarTodasDespesas = new javax.swing.JButton();
        lblTipoBusca2 = new javax.swing.JLabel();
        cmbOrdenação = new javax.swing.JComboBox();
        btnAddRendimento = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Lista de Rendimentos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_parcela.png"))); // NOI18N
        setName(""); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        lblMes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblMes.setText("Rendimentos do Mês de:");

        tblListagem.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        tblListagem.setForeground(java.awt.Color.black);
        tblListagem.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListagem.setGridColor(java.awt.Color.black);
        tblListagem.setName("Tabela"); // NOI18N
        tblListagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListagemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListagem);
        tblListagem.getAccessibleContext().setAccessibleName("Tabela");

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

        btnBuscarTodasDespesas.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnBuscarTodasDespesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_files.png"))); // NOI18N
        btnBuscarTodasDespesas.setText("Ver todos os Rendimentos");
        btnBuscarTodasDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTodasDespesasActionPerformed(evt);
            }
        });

        lblTipoBusca2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTipoBusca2.setText("Ordernar por: ");

        cmbOrdenação.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        cmbOrdenação.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome do Rendimento", "Data" }));

        btnAddRendimento.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnAddRendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_add.png"))); // NOI18N
        btnAddRendimento.setText("Adicionar Rendimento");
        btnAddRendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRendimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTipoBusca2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbOrdenação, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscarTodasDespesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddRendimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoBusca2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbOrdenação, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddRendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarTodasDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Construtor..........................................................................................................................................
    public frmRendimentoListar(Dimension sizeJFrame) {

        // Inicializa os componentes
        initComponents();
        this.SIZE_JFRAME = sizeJFrame;
        this.rendimentoDAO = new RendimentoDAO();

        setFrame();
    }

    // Método que seta as configurações do frame........................................................................................
    private void setFrame() {

        // Configuração da Interface InternalFramListener
        this.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
        this.addInternalFrameListener(this);

        // Altera as cores da tabela
        ChangeColorRendimento changeColor = new ChangeColorRendimento();
        tblListagem.setDefaultRenderer(Object.class, changeColor);

        // Chama o método pra preencher a lista de Despesas
        try {
            fillTabel(rendimentoDAO.Listar());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    // Método que preenche a Tabela com os dados......................................................................................
    private void fillTabel(List<Rendimento> list) throws Exception {

        Date dataAtual = new Date();
        Calendar calAtual = Calendar.getInstance();
        calAtual.setTime(dataAtual);

        try {
            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("Código");
            model.addColumn("Nome");
            model.addColumn("Descrição");
            model.addColumn("Valor");
            model.addColumn("Data");

            for (Rendimento rend : list) {

                Vector values = new Vector();
                String strData = format2.format(rend.getData().getTime());

                values.add(0, rend.getId());
                values.add(1, rend.getNome());
                values.add(2, rend.getDescricao());
                values.add(3, "R$ " + rend.getValor());
                values.add(4, strData);

                model.addRow(values);
            }

            tblListagem.setModel(model);
            tblListagem.repaint();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Não foi possivel Listar os Rendimentos");
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
            mes = cmbMeses.getSelectedIndex();

            // Ordenacao
            if (cmbOrdenação.getSelectedIndex() == 0) {
                ordenacao = 1; // Nome do Rendimento
            } else {
                ordenacao = 2; // Data de Recebimento
            }

            // Chama o metodo de Busca
            List<Rendimento> list = rendimentoDAO.Buscar(mes, ordenacao);

            // Chama o metodo para preencher a tabela
            fillTabel(list);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao tentar busca as despesas");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    // Metodo para o clique em um dos registros da tabela.......................
    private void tblListagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListagemMouseClicked

        try {

            // Pega o ID do Rendimento clicado
            Object objID = tblListagem.getValueAt(tblListagem.getSelectedRow(), 0);

            // Abre o Rendimento
            Rendimento rendimento = rendimentoDAO.Abrir((Long) objID);

            // Abre o Frame de Edição de Rendimentos
            frmRendimentoEditar window = new frmRendimentoEditar(SIZE_JFRAME, rendimento);
            this.getParent().add(window);
            centralizaForm(window);
            window.setVisible(true);

            // Fecha o Frame atual
            this.setVisible(false);
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um problema ao tentar abrir o Rendimento!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblListagemMouseClicked

    // Botão TODAS OS RENDIMENTOS...........................................................................................................
    private void btnBuscarTodasDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTodasDespesasActionPerformed
        try {

            // Chama o método de Listar
            List<Rendimento> list = rendimentoDAO.Listar();

            // Chama o método para preencher a tabela
            fillTabel(list);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao tentar busca os Rendimentos");
        }
    }//GEN-LAST:event_btnBuscarTodasDespesasActionPerformed

    // Método para o Botão ADD RENDIMENTO..............................................................................................
    private void btnAddRendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRendimentoActionPerformed
        try {
            // Add o frame
            frmRendimentoEditar window = new frmRendimentoEditar(SIZE_JFRAME, null);
            centralizaForm(window);
            this.getParent().add(window);
            window.setVisible(true);

            // Fecha o frame atual
            this.setVisible(false);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um problema ao tentar a Tela de Rendimentos");
        }
    }//GEN-LAST:event_btnAddRendimentoActionPerformed

    // Método que centraliza o JInternalFrame...............................................................................................
    @Override
    public void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = SIZE_JFRAME;
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRendimento;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarTodasDespesas;
    private javax.swing.JComboBox cmbMeses;
    private javax.swing.JComboBox cmbOrdenação;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblTipoBusca2;
    private javax.swing.JTable tblListagem;
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
