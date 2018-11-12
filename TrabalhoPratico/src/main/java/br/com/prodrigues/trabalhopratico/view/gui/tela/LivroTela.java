/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.view.gui.tela;

import br.com.prodrigues.trabalhopratico.modelcombo.ClassificacoesComboModel;
import br.com.prodrigues.trabalhopratico.modelcombo.AutoresComboModel;
import br.com.prodrigues.trabalhopratico.model.Autor;
import br.com.prodrigues.trabalhopratico.model.Classificacao;
import br.com.prodrigues.trabalhopratico.model.Editora;
import br.com.prodrigues.trabalhopratico.model.Exemplar;
import br.com.prodrigues.trabalhopratico.model.Livro;
import br.com.prodrigues.trabalhopratico.modelcombo.AutoresCellRenderer;
import br.com.prodrigues.trabalhopratico.modelcombo.ClassificacoesCellRenderer;
import br.com.prodrigues.trabalhopratico.modelcombo.EditorasCellRenderer;
import br.com.prodrigues.trabalhopratico.modelcombo.EditorasComboModel;
import br.com.prodrigues.trabalhopratico.view.IViewCrud;
import br.com.prodrigues.trabalhopratico.view.gui.ViewGuiSimples;
import java.awt.Frame;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author prorodrigues
 */
public class LivroTela extends ViewGuiSimples implements IViewCrud<Livro> {

    public static LivroTela getTela() {
        return tela;
    }

    public static void setTela(LivroTela tela) {
        LivroTela.tela = tela;
    }

    /**
     * Creates new form LivroTE
     *
     * @param parent
     * @param modal
     */
    public LivroTela(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.cmbAutores.setRenderer(new AutoresCellRenderer());
        this.cmbClassificacoes.setRenderer(new ClassificacoesCellRenderer());
        this.cmbEditoras.setRenderer(new EditorasCellRenderer());
    }

    public static LivroTela getInstance(Frame parent, boolean modal) {
        if (tela == null) {
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
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(LivroTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>
            return new LivroTela(parent, modal);
        } else {
            return tela;
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

        panRodape = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        labTitulo = new javax.swing.JLabel();
        panPrincipal = new javax.swing.JPanel();
        labNome = new javax.swing.JLabel();
        edtTitulo = new javax.swing.JTextField();
        labAutor = new javax.swing.JLabel();
        cmbAutores = new javax.swing.JComboBox<>();
        labEditora = new javax.swing.JLabel();
        cmbEditoras = new javax.swing.JComboBox<>();
        labClassificacoes = new javax.swing.JLabel();
        cmbClassificacoes = new javax.swing.JComboBox<>();
        btnSearchAutor = new javax.swing.JButton();
        btnSearchEditora = new javax.swing.JButton();
        btnSearchClassificacao = new javax.swing.JButton();
        edtData = new org.jdesktop.swingx.JXDatePicker();
        panSinopse = new javax.swing.JScrollPane();
        edtSinopse = new javax.swing.JTextArea();
        labDataDeLancamento = new javax.swing.JLabel();
        labSinopse = new javax.swing.JLabel();
        labExemplarQuantidade = new javax.swing.JLabel();
        edtQtd = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Livro Tela");

        panRodape.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnOk.setText("Ok");
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOkMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnOkMouseReleased(evt);
            }
        });
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panRodapeLayout = new javax.swing.GroupLayout(panRodape);
        panRodape.setLayout(panRodapeLayout);
        panRodapeLayout.setHorizontalGroup(
            panRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRodapeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panRodapeLayout.setVerticalGroup(
            panRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRodapeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnOk))
                .addGap(20, 20, 20))
        );

        labTitulo.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        labTitulo.setText("Titulo");
        labTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        panPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labNome.setText("Titulo:");

        labAutor.setText("Autores:");

        cmbAutores.setModel(this.modelAutores);

        labEditora.setText("Editoras:");

        cmbEditoras.setModel(this.modelEditoras);
        cmbEditoras.setSelectedItem(this.listaEditoras);

        labClassificacoes.setText("Classificação:");

        cmbClassificacoes.setModel(this.modelClassificacoes);

        btnSearchAutor.setText("Procurar");

        btnSearchEditora.setText("Procurar");

        btnSearchClassificacao.setText("Procurar");

        edtSinopse.setColumns(20);
        edtSinopse.setRows(5);
        panSinopse.setViewportView(edtSinopse);

        labDataDeLancamento.setText("Data De Lançamento:");

        labSinopse.setText("Sinopse:");

        labExemplarQuantidade.setText("Quantidade:");

        javax.swing.GroupLayout panPrincipalLayout = new javax.swing.GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labAutor)
                            .addComponent(labNome))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labClassificacoes)
                            .addComponent(labEditora)
                            .addComponent(labDataDeLancamento)
                            .addComponent(labExemplarQuantidade)
                            .addComponent(labSinopse))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panSinopse)
                            .addGroup(panPrincipalLayout.createSequentialGroup()
                                .addComponent(cmbClassificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearchClassificacao))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPrincipalLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbEditoras, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSearchAutor, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSearchEditora, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(panPrincipalLayout.createSequentialGroup()
                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edtData, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panPrincipalLayout.setVerticalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNome)
                    .addComponent(edtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labAutor)
                    .addComponent(btnSearchAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labEditora)
                        .addComponent(btnSearchEditora))
                    .addComponent(cmbEditoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labClassificacoes)
                    .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbClassificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearchClassificacao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtData, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labDataDeLancamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labExemplarQuantidade))
                    .addComponent(edtQtd, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(panSinopse, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labSinopse, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(labTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        confirmado = false;
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if (edtTitulo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falta o Nome");
        } else {
            confirmado = true;
            this.dispose();
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnOkMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMousePressed
        this.btnOk.setForeground(java.awt.Color.GREEN);
    }//GEN-LAST:event_btnOkMousePressed

    private void btnOkMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseReleased
        this.btnOk.setForeground(UIManager.getDefaults().getColor(this.btnOk.getForeground()));
    }//GEN-LAST:event_btnOkMouseReleased

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LivroTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            LivroTela dialog = new LivroTela(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSearchAutor;
    private javax.swing.JButton btnSearchClassificacao;
    private javax.swing.JButton btnSearchEditora;
    private javax.swing.JComboBox<Autor> cmbAutores;
    private javax.swing.JComboBox<Classificacao> cmbClassificacoes;
    private javax.swing.JComboBox<Editora> cmbEditoras;
    private org.jdesktop.swingx.JXDatePicker edtData;
    private javax.swing.JSpinner edtQtd;
    private javax.swing.JTextArea edtSinopse;
    private javax.swing.JTextField edtTitulo;
    private javax.swing.JLabel labAutor;
    private javax.swing.JLabel labClassificacoes;
    private javax.swing.JLabel labDataDeLancamento;
    private javax.swing.JLabel labEditora;
    private javax.swing.JLabel labExemplarQuantidade;
    private javax.swing.JLabel labNome;
    private javax.swing.JLabel labSinopse;
    private javax.swing.JLabel labTitulo;
    private javax.swing.JPanel panPrincipal;
    private javax.swing.JPanel panRodape;
    private javax.swing.JScrollPane panSinopse;
    // End of variables declaration//GEN-END:variables
    private static LivroTela tela;
    private boolean confirmado = false;

    private final AutoresComboModel modelAutores = new AutoresComboModel();
    private final EditorasComboModel modelEditoras = new EditorasComboModel();
    private final ClassificacoesComboModel modelClassificacoes = new ClassificacoesComboModel();
    private List<Autor> listaAutores;
    private List<Editora> listaEditoras;
    private List<Classificacao> classificacoes;

    public List<Autor> getListaAutores() {
        return listaAutores;
    }

    public void setListaEditoras(List<Editora> listaEditoras) {
        modelEditoras.clear();
        modelEditoras.addListEditora(listaEditoras);
    }

    public void setListaAutores(List<Autor> listaAutores) {
        modelAutores.clear();
        modelAutores.addListAutor(listaAutores);
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    @Override
    public Livro create(Livro object) {
        labTitulo.setText("Cadastro de Livro");

        edtTitulo.setText("");
        edtTitulo.setEditable(true);
        edtTitulo.setEnabled(true);

        edtData.setEditable(true);
        edtData.setEnabled(true);
        
        edtData.setDate(Date.from(Instant.now()));
        edtData.setEditable(true);
        edtData.setEnabled(true);
        
        edtSinopse.setText("");
        edtSinopse.setEditable(true);
        edtSinopse.setEnabled(true);

        this.setVisible(true);

        return this.getScreenObject();
    }

    @Override
    public void read(Livro object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livro update(Livro object) {
        if (confirmado) {
            object.setTitulo(edtTitulo.getText());
            object.setAutor((Autor) cmbAutores.getSelectedItem());
            object.setSinopse(edtSinopse.getText());
            Exemplar get = object.getExemplares().get(0);
            get.setQuantidade((int) edtQtd.getValue());
            Exemplar set = object.getExemplares().set(0, get);
            set.setLivro(object);
            object.setEditora((Editora) cmbEditoras.getSelectedItem());
            object.setClassificacao((Classificacao) cmbClassificacoes.getSelectedItem());

        } else if (!confirmado) {
            showMessage("CANCELADO PELO USUÁRIO!");
        } else if (object == null) {
            showMessage("NÃO ENCONTRADO!");
        } else {
            showMessage("ALTERADO COM SUCESSO!");
        }
        return object;
    }

    @Override
    public boolean delete(Livro object) {
        if (confirmado) {
            showMessage("Quer deletar?" + object.getTitulo());
            return true;
        } else {
            showMessage("NAO DELETADO," + object.getTitulo());
            return false;
        }
    }

    @Override
    public Livro getScreenObject() {
        Livro nova = new Livro();
        nova.setTitulo(edtTitulo.getText());
        nova.setAutor((Autor) cmbAutores.getSelectedItem());
        nova.setClassificacao((Classificacao) cmbClassificacoes.getSelectedItem());
        nova.setEditora((Editora) cmbEditoras.getSelectedItem());
        nova.setClassificacao((Classificacao) cmbClassificacoes.getSelectedItem());
        nova.setDataDeLancamento(edtData.getDate());
        nova.setSinopse(edtSinopse.getText());
        Exemplar exemplar = new Exemplar();
        exemplar.setQuantidade((int) edtQtd.getValue());
        nova.getExemplares().add(exemplar);
        exemplar.setLivro(nova);
        return nova;
    }

    @Override
    public void limpaTela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preparaUpdate(Livro object) {
        labTitulo.setText("Dados do Cliente");

        edtTitulo.setText(object.getTitulo());
        edtTitulo.setEditable(true);
        edtTitulo.setEnabled(true);
        cmbAutores.setSelectedItem(object.getAutor().getName());

        edtData.setDate(object.getDataDeLancamento());
        edtData.setEditable(true);
        edtData.setEnabled(true);

        edtQtd.setValue(object.getExemplares().get(0).getQuantidade());

        edtSinopse.setText(object.getSinopse());
        edtSinopse.setEditable(true);
        edtSinopse.setEnabled(true);

        cmbEditoras.setSelectedItem(object.getEditora().getNamepublisher());

        cmbClassificacoes.setSelectedItem(object.getClassificacao());

        this.setVisible(true);
    }

    public List<Classificacao> getClassificacoes() {
        return classificacoes;
    }

    public void setClassificacoes(List<Classificacao> classificacoes) {
        this.classificacoes = classificacoes;
    }
    
    public void setListaClassificacoes(List<Classificacao> classificacoes) {
        modelClassificacoes.clear();
        modelClassificacoes.addListClassificacao(classificacoes);
    }
}
