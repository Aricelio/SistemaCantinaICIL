package br.com.sistemaCantinaICIL.presentation;

import br.com.sistemaCantinaICIL.dao.DespesaDAO;
import br.com.sistemaCantinaICIL.dao.RendimentoDAO;
import br.com.sistemaCantinaICIL.interfaces.CentralizeJInternalFrame;
import br.com.sistemaCantinaICIL.model.Despesa;
import br.com.sistemaCantinaICIL.model.EnumSituacao;
import br.com.sistemaCantinaICIL.model.Rendimento;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class frmRendimentoEditar extends JInternalFrame
        implements InternalFrameListener, CentralizeJInternalFrame {

    //Variaveis
    private final Dimension SIZE_JFRAME;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Rendimento rendimento;

    //Construtor..........................................................................................................................................
    public frmRendimentoEditar(Dimension sizeJFrame, Rendimento rend){

        // Inicializa os componentes
        initComponents();
        this.SIZE_JFRAME = sizeJFrame;
        this.rendimento = rend;    
        
        setFrame();
    }    
    
    // Seta  as configurações do Frame........................................................................................................
    private void setFrame(){
    
        // Configuração da Interface InternalFramListener
        this.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
        this.addInternalFrameListener(this);                 
        
        if(this.rendimento != null){
            fillFields();
            btnSalvar.setText("Atualizar");
        }
        else{
            btnApagar.setEnabled(false);            
        }
    }
    
    // Prenche os campos do frame com os dados do Rendimento..................................................................
    private void fillFields(){
        txtNome.setText(rendimento.getNome());
        txtValor.setText( rendimento.getValor().toString());        
        txtDescricao.setText( rendimento.getDescricao());    
        txtDataRecebimento.setValue( simpleDateFormat.format( rendimento.getData().getTime()));                
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        lblObservacao = new javax.swing.JLabel();
        txtDataRecebimento = new javax.swing.JFormattedTextField();
        lblDataVencimento = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnApagar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Adicionar Rendimento");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_parcela.png"))); // NOI18N
        setName(""); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        txtDescricao.setRows(5);
        jScrollPane4.setViewportView(txtDescricao);

        lblObservacao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblObservacao.setText("Descrição:");

        try {
            txtDataRecebimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblDataVencimento.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDataVencimento.setText("Data de Recebimento:");

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblNome.setText("Nome do Rendimento:");

        txtNome.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N

        lblValor.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblValor.setText("Valor do Rendimento:");

        txtValor.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N

        btnApagar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_close.png"))); // NOI18N
        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblDataVencimento, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNome)
                                            .addComponent(txtDataRecebimento, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblValor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblObservacao)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDataRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Botão Salvar.......................................................................................................................................
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja Realmente Salvar?") == 0) {
            
            try{
                Rendimento rend = new Rendimento();
                RendimentoDAO dao = new RendimentoDAO();
                
                // Seta os atriburos do objeto
                rend.setNome( txtNome.getText());
                rend.setDescricao( txtDescricao.getText());
                rend.setValor( txtValor.getText());
                rend.setData((String) txtDataRecebimento.getValue());                                
                
                if(this.rendimento == null){
                    // Salva o Objeto
                    dao.Salvar(rend);
                }
                else{
                    // Atualiz o Objeto
                    rend.setId( rendimento.getId());
                    dao.Atualizar(rend);
                }                
                
                // Exibe Mensagem de confirmação
                JOptionPane.showMessageDialog(rootPane, "Rendimento Salvo com Sucesso!");                
                
                // Fecha o Frame
                closeFrame();
            }
            catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, e.getMessage());                
            }                
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    //Botão Cancelar....................................................................................................................................
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realmente cancelar a operação?") == 0) {
            try {
                closeFrame();
            } catch (Exception ex) {
                Logger.getLogger(frmRendimentoEditar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Botão Apagar.....................................................................................................................................
    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realmente apagar o Rendimento?") == 0) {
            try {
                
                // Apaga o registro
                RendimentoDAO reDAO = new RendimentoDAO();
                reDAO.Apagar(this.rendimento);
                
                // Mostra a mensagem de confirmação
                JOptionPane.showMessageDialog(rootPane, "Rendimento apagado com sucesso!");
                
                // Fecha o frame
                closeFrame();
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao tentar apagar o Rendimento!");
            }
        }
    }//GEN-LAST:event_btnApagarActionPerformed
    
    // Método que Fecha o Frame.................................................................................................................
    private void closeFrame() throws Exception {

        // Abre o frame 'FrmClienteBuscar'
        /*FrmClienteBuscar janela = new FrmClienteBuscar(Constantes.FORM_CLIENTE_EDITAR, SIZE_JFRAME);
         this.getParent().add(janela);
         centralizaForm(janela);
         janela.setVisible(true);*/
        
        // Fecha o frame 'FrmClienteEditar'
        this.setVisible(false);
        this.dispose();
    }
    
    // Método que centraliza o JInternalFrame...............................................................................................
    @Override
    public void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = SIZE_JFRAME;
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDataVencimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblObservacao;
    private javax.swing.JLabel lblValor;
    private javax.swing.JFormattedTextField txtDataRecebimento;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
   
    // Método chamado quando se fecha o JInternalFrame pelo botão fechar...................................................
    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        int option = JOptionPane.showConfirmDialog(null, 
                "Tem certeza que deseja fechar?", "Fechar", JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            try {
                closeFrame();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
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
