package br.com.prodrigues.trabalhopratico.view.gui.tela;

import br.com.prodrigues.trabalhopratico.model.Autor;
import br.com.prodrigues.trabalhopratico.model.validações.LimiteDigitosLetras;
import br.com.prodrigues.trabalhopratico.view.IViewCrud;
import br.com.prodrigues.trabalhopratico.view.gui.ViewGuiSimples;
import java.awt.Frame;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author pedro
 */
public class AutorTela extends ViewGuiSimples implements IViewCrud<Autor>{
    
    private static AutorTela tela;
    private boolean confirmado = false;

    public static AutorTela getTela() {
        return tela;
    }

    public boolean isConfirmado() {
        return confirmado;
    }
      public static AutorTela getInstance(Frame parent, boolean modal) {
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
                java.util.logging.Logger.getLogger(AutorTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>
            return new AutorTela(parent, modal);
        } else {
            return tela;
        }
    }
    public AutorTela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        edtNome.setDocument(new LimiteDigitosLetras(20));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panRodape = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        panTitulo = new javax.swing.JPanel();
        labTitulo = new javax.swing.JLabel();
        panPrincipal = new javax.swing.JPanel();
        labNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        edtDataNascimento = new org.jdesktop.swingx.JXDatePicker();
        labData = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Autor");

        panRodape.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnOk.setText("Ok");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panRodapeLayout.setVerticalGroup(
            panRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRodapeLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnOk))
                .addGap(20, 20, 20))
        );

        labTitulo.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        labTitulo.setText("Titulo");

        javax.swing.GroupLayout panTituloLayout = new javax.swing.GroupLayout(panTitulo);
        panTitulo.setLayout(panTituloLayout);
        panTituloLayout.setHorizontalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panTituloLayout.setVerticalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labTitulo)
                .addContainerGap())
        );

        labNome.setText("Nome:");

        labData.setText("Data de aniversário:");

        javax.swing.GroupLayout panPrincipalLayout = new javax.swing.GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labNome)
                    .addComponent(labData))
                .addGap(23, 23, 23)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panPrincipalLayout.setVerticalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNome)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labData))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(panRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.checandoBtnCancel();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        this.checandoBtnOk();
    }//GEN-LAST:event_btnOkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private org.jdesktop.swingx.JXDatePicker edtDataNascimento;
    private javax.swing.JTextField edtNome;
    private javax.swing.JLabel labData;
    private javax.swing.JLabel labNome;
    private javax.swing.JLabel labTitulo;
    private javax.swing.JPanel panPrincipal;
    private javax.swing.JPanel panRodape;
    private javax.swing.JPanel panTitulo;
    // End of variables declaration//GEN-END:variables

    private void checandoBtnCancel() {
        this.confirmado = false;
        this.dispose();}

    private void checandoBtnOk() {
         if (edtNome.getText().trim().isEmpty()) {
            this.showErrorMessage("Falta o Nome");
        } 
        else if (edtNome.getText().length() < 3) {
            this.showErrorMessage("O Nome deve conter no mínimo 3 caracteres!");
        } 
         else {
            this.confirmado = true;
            this.dispose();
        }}

    @Override
    public Autor create(Autor autor) {
        autor = null;
        this.limpaTela();
        this.preparaCreate();
         this.setVisible(true);
        if(confirmado){
            autor = this.getScreenObject();
        }
        else{
            showMessage("CANCELADO PELO USUÁRIO!");
            
        }
        return autor;
    }

    @Override
    public void read(Autor object) {
       this.preparaMostrar(object);
        this.setVisible(true);
    }

    @Override
    public Autor update(Autor object) {
         this.preparaUpdate(object);
        this.setVisible(true);
        if (confirmado) {
            return this.alterarScreenObject(object);
        } else if (!confirmado) {
            showMessage("CANCELADO PELO USUÁRIO!");
        } else if (object == null) {
            showMessage("NÃO ENCONTRADO!");
        } else {
            showMessage("ALTERADO COM SUCESSO!");
        }
        return object;}

    @Override
    public boolean delete(Autor object) {
        this.preparaDelete(object);
        
        this.setVisible(true);

        if (!confirmado) {
            showMessage("CANCELADO PELO USUÁRIO!");
            return false;
        } else if (object == null) {
            showMessage("NÃO ENCONTRADO!");
            return false;
        }
        return true;
    }

    @Override
    public Autor getScreenObject() {
     Autor retorno = new Autor();
        retorno.setName(edtNome.getText());
        retorno.setNascimento(edtDataNascimento.getDate());
        return retorno;
    }

    @Override
    public void limpaTela() {
        edtNome.setText("");
    }

    @Override
    public void preparaUpdate(Autor object) {
         labTitulo.setText("Dados do Autor");
        edtNome.setText(object.getName());
        edtNome.setEditable(true);
        edtNome.setEnabled(true);
        edtDataNascimento.setDate(object.getNascimento());
        edtDataNascimento.setEditable(true);
        edtDataNascimento.setEnabled(true);
        
        btnOk.setText("Alterar");
        btnOk.setVisible(true);
        btnCancel.setText("Cancelar");
        btnCancel.setVisible(true);}

    private void preparaCreate() {
         labTitulo.setText("Cadastro de Ator");
        edtDataNascimento.setDate(Date.from(Instant.now()));
        edtDataNascimento.setEditable(true);
        edtDataNascimento.setEnabled(true);
        edtNome.setText("");
        edtNome.setEditable(true);
        edtNome.setEnabled(true);

        btnOk.setText("Salvar");
        btnOk.setVisible(true);
        btnCancel.setText("Cancelar");
        btnCancel.setVisible(true);}

    private void preparaMostrar(Autor object) {
        labTitulo.setText("Dados do Autor");
        
        edtDataNascimento.setDate(object.getNascimento());
        edtDataNascimento.setEditable(true);
        edtDataNascimento.setEnabled(false);
        edtNome.setText(object.getName());
        edtNome.setEditable(true);
        edtNome.setEnabled(false);

        this.btnOk.setText("Ok");
        this.btnOk.setVisible(true);
        this.btnCancel.setVisible(false);
    }

    private Autor alterarScreenObject(Autor object) {
        /*-----------------------------------*/
        object.setName(edtNome.getText());
        object.setNascimento(object.getNascimento());
        /*----------------------------------*/
        return object;}

    private void preparaDelete(Autor object) {
       labTitulo.setText("Dados do Autor");
        edtDataNascimento.setDate(object.getNascimento());
        edtDataNascimento.setEditable(false);
        edtDataNascimento.setEnabled(false);
        edtNome.setText(object.getName());
        edtNome.setEditable(false);
        edtNome.setEnabled(false);
      
        btnOk.setText("Deletar");
        btnOk.setVisible(true);
        btnCancel.setText("Cancelar");
        btnCancel.setVisible(true);
    
    }
}
