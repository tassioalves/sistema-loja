package br.edu.ifms.loja.app.layouts;

import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public abstract class GenericCRUD<T> extends javax.swing.JDialog {

    private ObjectTableModel<T> objectTableModel;
    private AnnotationResolver resolver;
    private Class clazz;
    private String[] cabecalhoTabela;

    /**
     * @param parent Determina quem é a janela pai
     * @param modal Determina se a janela irá ser moral
     * @param clazz Classe de modelo de dados(datamodel) no qual a janela irá se
     * moldar
     * @param cabecalhoTabela Campos a serem mostrados na tabela
     */
    public GenericCRUD(java.awt.Frame parent, boolean modal, Class clazz, String[] cabecalhoTabela) {
        super(parent, modal);

        this.clazz = clazz;
        this.cabecalhoTabela = cabecalhoTabela;

        initComponents();
        aoInicializar();
    }

    /**
     * Método que define o formulario do CRUD
     */
    protected abstract JPanel criarFormulario();

    /**
     * Método para tranferir os valores dos campos de um fomulário para os
     * campos do objeto
     */
    protected abstract void camposParaObjeto();

    /**
     * Método para tranferir os valores dos campos de um objeto para os campos
     * do formulário
     */
    protected abstract void objetoParaCampos();

    /**
     * Método para salvar um objeto
     */
    protected abstract void salvar();

    /**
     * Método para editar um objeto
     */
    protected abstract void editar();

    /**
     * Método para criar um objeto
     */
    protected abstract void novo();

    /**
     * Método para cancelar a criação ou edição de um objeto novo
     */
    protected abstract void cancelar();

    /**
     * Método para excluir um objeto
     */
    protected abstract void excluir();

    /**
     * Método para buscar um objeto
     */
    protected abstract List buscar(String param);

    /**
     * Método para carregar dados na tabela
     */
    protected abstract List<T> carregarListaParaTabela();

    /**
     * Método deve ser chamado quando se quer obter o objeto selecionado na
     * tabela
     */
    protected abstract void obterItemSelecionadoNaTabela(T itemSelecionado);

    /**
     * Método invocado ao construir a janela
     */
    private void aoInicializar() {
        //Titulo da janela
        this.setTitle("Cadastro de " + clazz.getSimpleName());

        //Titulo do formulario
        TitledBorder bordaSuperior = (TitledBorder) this.painelSuperior.getBorder();
        bordaSuperior.setTitle("Detalhes - " + clazz.getSimpleName());

        //Titulo do formulario
        TitledBorder bordaInterior = (TitledBorder) this.painelInferior.getBorder();
        bordaInterior.setTitle("Busca e Listagem - " + clazz.getSimpleName());

        painelFormulario.add(criarFormulario(), BorderLayout.CENTER);

        inicializarObjectTableModel(cabecalhoTabela);
        desabilitarCampos();

        botaoNovo.setEnabled(true);
        botaoSalvar.setEnabled(false);
        botaoCancelar.setEnabled(false);
        botaoExcluir.setEnabled(false);
        botaoEditar.setEnabled(false);
    }

    /**
     * Método invocado ao clicar no botao Novo
     */
    private void aoClicarEmNovo() {
        novo();
        objetoParaCampos();
        habilitarCampos();
        botaoNovo.setEnabled(false);
        botaoSalvar.setEnabled(true);
        botaoCancelar.setEnabled(true);
        botaoExcluir.setEnabled(false);
        botaoEditar.setEnabled(false);
    }

    /**
     * Método invocado ao clicar no botao Salvar
     */
    private void aoClicarEmSalvar() {
        camposParaObjeto();
        salvar();
        desabilitarCampos();
        carregarTabela();
        botaoNovo.setEnabled(true);
        botaoSalvar.setEnabled(false);
        botaoCancelar.setEnabled(false);
        botaoExcluir.setEnabled(true);
        botaoEditar.setEnabled(true);
    }

    /**
     * Método invocado ao clicar no botao Editar
     */
    private void aoClicarEmEditar() {
        objetoParaCampos();
        editar();
        habilitarCampos();
        botaoNovo.setEnabled(false);
        botaoSalvar.setEnabled(true);
        botaoCancelar.setEnabled(true);
        botaoExcluir.setEnabled(false);
        botaoEditar.setEnabled(false);
    }

    /**
     * Método invocado ao clicar no botao Excluir
     */
    private void aoClicarEmExcluir() {
        int op = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este registro?", "Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (op == JOptionPane.NO_OPTION) {
            return;
        }

        excluir();
        carregarTabela();
        botaoNovo.setEnabled(true);
        botaoSalvar.setEnabled(false);
        botaoCancelar.setEnabled(false);
        botaoExcluir.setEnabled(false);
        botaoEditar.setEnabled(false);
    }

    /**
     * Método invocado ao clicar no botao Cancelar
     */
    private void aoClicarEmCancelar() {
        objetoParaCampos();
        cancelar();
        desabilitarCampos();
        carregarTabela();
        botaoNovo.setEnabled(true);
        botaoSalvar.setEnabled(false);
        botaoCancelar.setEnabled(false);
        botaoExcluir.setEnabled(false);
        botaoEditar.setEnabled(false);
    }

    /**
     * Método invocado ao clicar ao apertar enter no campo de busca
     */
    private void aoApertarEnterNoCampoDeBusca() {
        List<T> lista = buscar(campoBuscar.getText());
        objectTableModel.setData(lista);
    }

    /**
     * Método invocado ao selecionar algum item na tabela
     */
    private void aoSelecionarItemNaTabela() {
        int index = tabela.getSelectedRow();

        if (index < 0) {
            return;
        }

        T obj = objectTableModel.getValue(index);

        desabilitarCampos();
        obterItemSelecionadoNaTabela(obj);
        objetoParaCampos();

        botaoNovo.setEnabled(true);
        botaoSalvar.setEnabled(false);
        botaoCancelar.setEnabled(false);
        botaoExcluir.setEnabled(true);
        botaoEditar.setEnabled(true);
    }

    /**
     * Método que coloca uma lista advinda da implementacao do metodo
     * carregarListaParaTabela() e coloca na tabela
     */
    public void carregarTabela() {
        List<T> dados = carregarListaParaTabela();
        objectTableModel.setData(dados);
    }

    /**
     * Método que inicializa o ObjectTableModel
     */
    private void inicializarObjectTableModel(String[] cabecalhoTabela) {
        StringBuilder campos = new StringBuilder();
        for (String campo : cabecalhoTabela) {
            campos.append(campo);
            campos.append(",");
        }
        campos.deleteCharAt(campos.length() - 1);
        resolver = new AnnotationResolver(clazz);
        objectTableModel = new ObjectTableModel<T>(resolver, campos.toString());
        tabela.setModel(objectTableModel);
    }

    private void habilitarCampos() {
        ControleDeFormulario.habilitarCampos(painelFormulario);
    }

    private void desabilitarCampos() {
        ControleDeFormulario.desabilitarCampos(painelFormulario);
    }

    /**
     * Método invocado ao construir a janela, responsável por carregar os icones
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelSuperior = new javax.swing.JPanel();
        painelFormulario = new javax.swing.JPanel();
        painelBotoes = new javax.swing.JPanel();
        botaoSalvar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        painelInferior = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        labelBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        linhaSeparadora = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelSuperior.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        painelFormulario.setLayout(new java.awt.BorderLayout());

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoEditar.setText("Editar");
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        botaoNovo.setText("Novo");
        botaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoActionPerformed(evt);
            }
        });

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
        painelBotoes.setLayout(painelBotoesLayout);
        painelBotoesLayout.setHorizontalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelBotoesLayout.setVerticalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(botaoSalvar)
                .addComponent(botaoEditar)
                .addComponent(botaoNovo)
                .addComponent(botaoExcluir)
                .addComponent(botaoCancelar))
        );

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addComponent(painelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSuperiorLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(painelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        tabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabelaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        labelBuscar.setText("Buscar:");

        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout painelInferiorLayout = new javax.swing.GroupLayout(painelInferior);
        painelInferior.setLayout(painelInferiorLayout);
        painelInferiorLayout.setHorizontalGroup(
            painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelInferiorLayout.createSequentialGroup()
                        .addComponent(labelBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBuscar)))
                .addContainerGap())
        );
        painelInferiorLayout.setVerticalGroup(
            painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelInferior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(linhaSeparadora, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linhaSeparadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(617, 255));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        aoClicarEmSalvar();
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        aoClicarEmEditar();
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed
        aoClicarEmNovo();
    }//GEN-LAST:event_botaoNovoActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        aoClicarEmExcluir();
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        aoClicarEmCancelar();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        aoSelecionarItemNaTabela();
    }//GEN-LAST:event_tabelaMouseClicked

    private void tabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyPressed
        aoSelecionarItemNaTabela();
    }//GEN-LAST:event_tabelaKeyPressed

    private void tabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyReleased
        aoSelecionarItemNaTabela();
    }//GEN-LAST:event_tabelaKeyReleased

    private void tabelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyTyped

    }//GEN-LAST:event_tabelaKeyTyped

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            aoApertarEnterNoCampoDeBusca();
        }
    }//GEN-LAST:event_campoBuscarKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JSeparator linhaSeparadora;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelFormulario;
    private javax.swing.JPanel painelInferior;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
