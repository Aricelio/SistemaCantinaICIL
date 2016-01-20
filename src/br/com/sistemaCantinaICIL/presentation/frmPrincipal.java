package br.com.sistemaCantinaICIL.presentation;

import br.com.sistemaCantinaICIL.dao.DespesaDAO;
import br.com.sistemaCantinaICIL.dao.JPAUtil;
import br.com.sistemaCantinaICIL.dao.RendimentoDAO;
import br.com.sistemaCantinaICIL.model.Despesa;
import br.com.sistemaCantinaICIL.model.FactoryRelatorioBalanceteMensal;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class frmPrincipal extends javax.swing.JFrame {

    // Constantes
    public final String REPORT_MENSAL_DESPESAS = "/Arquivos/Relatorios/RelatorioMensalDespesas.jasper";
    public final String REPORT_BALANCENTE = "/Arquivos/Relatorios/RelatorioBalanceteMensal.jasper";

    //Construtor..........................................................................................................................................
    public frmPrincipal() throws Exception {
        try {

            // Inicializa as variaveis
            initComponents();

            //Chama o método para setar as configurações do Frame
            setInitialSettings();

        } catch (Exception e) {
            frmGenerico.showMessage("Atenção! Não foi possível abrir o Sistema!", rootPane);
        }
    }

    // Método que realiza as configurações iniciais no FRAME.........................................................................
    private void setInitialSettings() {

        // Evento de fechar o frame
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                try {
                    close();
                } catch (Exception ex) {
                    Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Seta o Icone do Frame
        String caminhoIcon = System.getProperty("user.dir") + "/Arquivos/Imagens/logo.png";
        ImageIcon img = new ImageIcon(caminhoIcon);
        this.setIconImage(img.getImage());

        // Deixa o JFrame Maximizado
        this.pack();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jdpPainel = new javax.swing.JDesktopPane(){
            String caminhoImage = System.getProperty("user.dir") + "/Arquivos/Imagens/background.jpg";
            ImageIcon icon = new ImageIcon(caminhoImage);
            Image image = icon.getImage();

            Image newimage = image.getScaledInstance(1600, 1000, Image.SCALE_SMOOTH);

            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                graphics.drawImage(newimage, 0, 0, this);
            }
        };
        lblVersao = new javax.swing.JLabel();
        mbBarraPrincipal = new javax.swing.JMenuBar();
        mnuInicio = new javax.swing.JMenu();
        mniSair = new javax.swing.JMenuItem();
        mnuDespesas = new javax.swing.JMenu();
        mniAddDespesa = new javax.swing.JMenuItem();
        mniListarDespesas = new javax.swing.JMenuItem();
        mnuRendimentos = new javax.swing.JMenu();
        mniAddRendimento = new javax.swing.JMenuItem();
        mniListarRendimentos = new javax.swing.JMenuItem();
        mnuRelatorios = new javax.swing.JMenu();
        mniRelatorioMensalDespesas = new javax.swing.JMenuItem();
        mniRelatorioBalanceteMensal = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        jMenu6.setText("jMenu6");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu7.setText("Edit");
        jMenuBar3.add(jMenu7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Cantina ICIL");
        setBackground(new java.awt.Color(255, 255, 255));
        setName("JFPrincipal"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Sistema de Gerenciamento de Finanças");

        jdpPainel.setBackground(java.awt.Color.white);

        lblVersao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblVersao.setText("Versão: 1.0");

        mnuInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_home.png"))); // NOI18N
        mnuInicio.setText("Inicio");

        mniSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        mniSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_logoff.png"))); // NOI18N
        mniSair.setText("Sair");
        mniSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSairActionPerformed(evt);
            }
        });
        mnuInicio.add(mniSair);

        mbBarraPrincipal.add(mnuInicio);

        mnuDespesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_parcela.png"))); // NOI18N
        mnuDespesas.setText("Despesas");

        mniAddDespesa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mniAddDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_add.png"))); // NOI18N
        mniAddDespesa.setText("Adicionar Despesa");
        mniAddDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAddDespesaActionPerformed(evt);
            }
        });
        mnuDespesas.add(mniAddDespesa);

        mniListarDespesas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        mniListarDespesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_lupa.png"))); // NOI18N
        mniListarDespesas.setText("Listar Despesas");
        mniListarDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniListarDespesasActionPerformed(evt);
            }
        });
        mnuDespesas.add(mniListarDespesas);

        mbBarraPrincipal.add(mnuDespesas);

        mnuRendimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_files.png"))); // NOI18N
        mnuRendimentos.setText("Rendimentos");

        mniAddRendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_add.png"))); // NOI18N
        mniAddRendimento.setText("Adicionar Rendimento");
        mniAddRendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAddRendimentoActionPerformed(evt);
            }
        });
        mnuRendimentos.add(mniAddRendimento);

        mniListarRendimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_lupa.png"))); // NOI18N
        mniListarRendimentos.setText("Listar Redimentos");
        mniListarRendimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniListarRendimentosActionPerformed(evt);
            }
        });
        mnuRendimentos.add(mniListarRendimentos);

        mbBarraPrincipal.add(mnuRendimentos);

        mnuRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_relatorio.png"))); // NOI18N
        mnuRelatorios.setText("Relatórios");

        mniRelatorioMensalDespesas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mniRelatorioMensalDespesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_relattorio_2.png"))); // NOI18N
        mniRelatorioMensalDespesas.setText("Relatorio Mensal de Despesas");
        mniRelatorioMensalDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRelatorioMensalDespesasActionPerformed(evt);
            }
        });
        mnuRelatorios.add(mniRelatorioMensalDespesas);

        mniRelatorioBalanceteMensal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaCantinaICIL/icon/ic_relatorio_3.png"))); // NOI18N
        mniRelatorioBalanceteMensal.setText("Balancete Mensal");
        mniRelatorioBalanceteMensal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRelatorioBalanceteMensalActionPerformed(evt);
            }
        });
        mnuRelatorios.add(mniRelatorioBalanceteMensal);

        mbBarraPrincipal.add(mnuRelatorios);

        setJMenuBar(mbBarraPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 855, Short.MAX_VALUE)
                .addComponent(lblVersao)
                .addContainerGap())
            .addComponent(jdpPainel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jdpPainel, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblVersao))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("SignusSystem");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Método para o Item SAIR.....................................................................................................................
    private void mniSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSairActionPerformed
        try {
            close();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_mniSairActionPerformed

    // Método para o Item ADICIONAR DESPESA.............................................................................................
    private void mniAddDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAddDespesaActionPerformed
        try {
            frmDespesaEditar janela = new frmDespesaEditar(this.getSize(), null);
            addInternalFrame(janela);
        } catch (Exception e) {
            e.printStackTrace();
            frmGenerico.showMessage("Não foi possível abrir a Tela de Inserção de Despesas", rootPane);
        }
    }//GEN-LAST:event_mniAddDespesaActionPerformed

    // Método para o item LISTAR DESPESAS.................................................................................................
    private void mniListarDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniListarDespesasActionPerformed
        try {
            frmDespesaListar janela = new frmDespesaListar(this.getSize());
            addInternalFrame(janela);
        } catch (Exception e) {
            e.printStackTrace();
            frmGenerico.showMessage("Não foi possível abrir a Tela de Listagem de Despesas", rootPane);
        }
    }//GEN-LAST:event_mniListarDespesasActionPerformed

    // Método para o item RELATÓRIO MENSAL..............................................................................................
    private void mniRelatorioMensalDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRelatorioMensalDespesasActionPerformed
        try {

            // Obtém o diretório da aplicação
            String arquivo = System.getProperty("user.dir") + REPORT_MENSAL_DESPESAS;

            // Cria a lista de Despesas
            DespesaDAO dao = new DespesaDAO();
            List<Despesa> list = dao.BuscarDespesasMesAtual();

            // Chama o método para gerar o relatório
            if (!list.isEmpty()) {
                printReport(arquivo, list);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Atenção! Sem registros para gerar o relatório!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_mniRelatorioMensalDespesasActionPerformed

    // Método para o item ADD RENDIMENTO................................................................................................
    private void mniAddRendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAddRendimentoActionPerformed
        try {
            frmRendimentoEditar window = new frmRendimentoEditar(this.getSize(), null);
            addInternalFrame(window);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um problema ao tentar a Tela de Rendimentos");
        }
    }//GEN-LAST:event_mniAddRendimentoActionPerformed

    // Método para o item LISTAR RENDIMENTOS...........................................................................................
    private void mniListarRendimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniListarRendimentosActionPerformed
        try {
            frmRendimentoListar window = new frmRendimentoListar(this.getSize());
            addInternalFrame(window);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Não foi possível abrir a Tela de Listagem de Rendimentos");
        }
    }//GEN-LAST:event_mniListarRendimentosActionPerformed

    // Método para gerar o Relatório BALANCETE MENSAL..............................................................................
    private void mniRelatorioBalanceteMensalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRelatorioBalanceteMensalActionPerformed
        try {

            // Obtém o diretório da aplicação
            String arquivo = System.getProperty("user.dir") + REPORT_BALANCENTE;

            DespesaDAO daoDespesa = new DespesaDAO();
            RendimentoDAO daoRendimento = new RendimentoDAO();
            List<FactoryRelatorioBalanceteMensal> list = new ArrayList<>();
            FactoryRelatorioBalanceteMensal fac = new FactoryRelatorioBalanceteMensal();
            
            // Seta os dados na lista
            fac.setTotalRendimento(daoRendimento.getTotalRendimentoMesAtual());
            fac.setTotalDespesa(daoDespesa.getTotalDespesaMesAtual());
            fac.setLucro(fac.getTotalRendimento().subtract(fac.getTotalDespesa()));
            list.add(fac);            

            // Chama o método para gerar o relatório
            if (!list.isEmpty()) {
                printReport(arquivo, list);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Atenção! Sem registros para gerar o relatório!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possivel gerar o Relatório!");
        }
    }//GEN-LAST:event_mniRelatorioBalanceteMensalActionPerformed

    // Adiciona um JInternalFrame ao JDesktopPainel......................................................................................
    public void addInternalFrame(JInternalFrame frame) {

        // Deixa o frame visivel
        frame.setVisible(true);

        // Centraliza o Frame
        Dimension desktopSize = this.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);

        // Add o frame na tela principal
        jdpPainel.add(frame);
    }

    // Método MAIN......................................................................................................................................
    public static void main(String args[]) {

        // Método para o tema do frame
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        // Método RUN
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmPrincipal().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    // Imprime o Relatorio............................................................................................................................
    private void printReport(String arquivo, List<?> list) throws Exception {
        try {
            // Fonte de Dados do Jasper Reports
            JRBeanCollectionDataSource dados = new JRBeanCollectionDataSource(list);

            // Gera o relatório
            JasperPrint report = JasperFillManager.fillReport(arquivo, null, dados);

            // Exibe o Relatório
            JasperViewer jasperViewer = new JasperViewer(report, false);
            jasperViewer.setVisible(true);

        } catch (JRException ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }

    // Sair do Sistema..................................................................................................................................
    protected void close() throws Exception {

        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realmente Sair?") == 0) {

            // Fecha a conexão com o banco
            JPAUtil.closeEntityManager();

            System.exit(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JDesktopPane jdpPainel;
    private javax.swing.JLabel lblVersao;
    private javax.swing.JMenuBar mbBarraPrincipal;
    private javax.swing.JMenuItem mniAddDespesa;
    private javax.swing.JMenuItem mniAddRendimento;
    private javax.swing.JMenuItem mniListarDespesas;
    private javax.swing.JMenuItem mniListarRendimentos;
    private javax.swing.JMenuItem mniRelatorioBalanceteMensal;
    private javax.swing.JMenuItem mniRelatorioMensalDespesas;
    private javax.swing.JMenuItem mniSair;
    private javax.swing.JMenu mnuDespesas;
    private javax.swing.JMenu mnuInicio;
    private javax.swing.JMenu mnuRelatorios;
    private javax.swing.JMenu mnuRendimentos;
    // End of variables declaration//GEN-END:variables

}
