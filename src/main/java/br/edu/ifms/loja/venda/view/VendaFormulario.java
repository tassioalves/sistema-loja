/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.venda.view;

import br.edu.ifms.loja.cliente.datamodel.Cliente;
import br.edu.ifms.loja.produto.bo.ProdutoBO;
import br.edu.ifms.loja.produto.datamodel.Produto;
import br.edu.ifms.loja.usuario.bo.UsuarioBO;
import br.edu.ifms.loja.usuario.datamodel.Usuario;
import br.edu.ifms.loja.venda.bo.ItemVendaBO;
import br.edu.ifms.loja.venda.bo.VendaBO;
import br.edu.ifms.loja.venda.datamodel.ItemVenda;
import br.edu.ifms.loja.venda.datamodel.Venda;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Tássio
 */
public class VendaFormulario extends javax.swing.JPanel {

    public Venda venda;
    public ItemVenda itemVenda;
    private Produto produtoParaCarrinho;
    private BigDecimal totalfinal;
    private ArrayList<ItemVenda> listaDoCarrinho;

    private TableCliente tableCliente;
    private TabelaUsuario tableUsuario;

    private ObjectTableModel<Produto> tableModelProduto;
    private ObjectTableModel<ItemVenda> tableModelCarrinho;

    private AnnotationResolver resolver;
    private AnnotationResolver resolver2;

    private UsuarioBO usuarioBO;
    private ProdutoBO produtoBO;
    private VendaBO vendaBO;
    private ItemVendaBO itemVendaBO;

    public VendaFormulario() {
        initComponents();

        listaDoCarrinho = new ArrayList<ItemVenda>();
        totalfinal = new BigDecimal(BigInteger.ZERO);
        venda = new Venda();

        produtoBO = new ProdutoBO();
        usuarioBO = new UsuarioBO();
        vendaBO = new VendaBO();
        itemVendaBO = new ItemVendaBO();

        tableCliente = new TableCliente(null, true, this);
        tableUsuario = new TabelaUsuario(null, true, this);

        inicializarObjectTableModel();
    }

    private void novaVenda() {
        venda = new Venda();
        listaDoCarrinho = new ArrayList<ItemVenda>();
        tableModelCarrinho.setData(listaDoCarrinho);
        campoCliente.setText("");
        campoUsuario.setText("");
        campoTotalFinal.setText("0,00");
    }

    private void inicializarObjectTableModel() {
        resolver = new AnnotationResolver(Produto.class);
        resolver2 = new AnnotationResolver(ItemVenda.class);
        tableModelProduto = new ObjectTableModel<Produto>(resolver, "id,descricao,marca,valor,qtde");
        tableModelCarrinho = new ObjectTableModel<ItemVenda>(resolver2, "produto.descricao:Descricao,qtdeVenda,valorVenda,total");
        tabelaProdutos.setModel(tableModelProduto);
        tabelaCarrinho.setModel(tableModelCarrinho);
        tableModelProduto.setData(produtoBO.listarTodos());
    }

    private void preencherTabelaCarrinho() {
        if (null == listaDoCarrinho) {
            return;
        }
        tableModelCarrinho.setData(listaDoCarrinho);
    }

    public void preencherCampoUsuario(Usuario usuario) {
        campoUsuario.setText(usuario.getNome());
        venda.setUsuario(usuario);
    }

    public void preencherCampoCliente(Cliente cliente) {
        campoCliente.setText(cliente.getNome());
        venda.setCliente(cliente);
    }

    private void limparCamposItemVenda() {
        campoDescricao.setText("");
        campoPreco.setText("");
        campoQtde.setText("");
        campoSubTotal.setText("");
        campoDescricaoProduto.setText("");
        tabelaProdutos.clearSelection();

        BigDecimal subTotal = itemVenda.getTotal();
        totalfinal = totalfinal.add(subTotal);
        campoTotalFinal.setText(totalfinal.toString());
        campoQtde.setEditable(false);
    }

    private void novoItemVenda() {
        itemVenda = new ItemVenda();
        itemVenda.setProduto(produtoParaCarrinho);
        itemVenda.setQtdeVenda(Integer.parseInt(campoQtde.getText()));
        itemVenda.setValorVenda(produtoParaCarrinho.getValor());
        BigDecimal qtde = new BigDecimal(itemVenda.getQtdeVenda());
        BigDecimal valor = new BigDecimal(itemVenda.getValorVenda());
        BigDecimal total = qtde.multiply(valor);
        itemVenda.setTotal(total);
        listaDoCarrinho.add(itemVenda);

        preencherTabelaCarrinho();
        limparCamposItemVenda();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCarrinho = new javax.swing.JTable();
        botaoFinalizar = new javax.swing.JButton();
        campoTotalFinal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoDescricaoProduto = new javax.swing.JTextField();
        botaoAddCarrinho = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoDescricao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoPreco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        campoQtde = new javax.swing.JTextField();
        campoCliente = new javax.swing.JTextField();
        botaoBuscarCliente = new javax.swing.JButton();
        botaoBuscarUsuario = new javax.swing.JButton();
        campoUsuario = new javax.swing.JTextField();
        campoSubTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProdutos);

        tabelaCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabelaCarrinho);

        botaoFinalizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botaoFinalizar.setText("FINALIZAR");
        botaoFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFinalizarActionPerformed(evt);
            }
        });

        campoTotalFinal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        campoTotalFinal.setText("0,00");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Total:");

        campoDescricaoProduto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        campoDescricaoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoDescricaoProdutoKeyReleased(evt);
            }
        });

        botaoAddCarrinho.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        botaoAddCarrinho.setText("Adicionar");
        botaoAddCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAddCarrinhoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Buscar:");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Cliente");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Usuario");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Descrição:");

        campoDescricao.setEditable(false);
        campoDescricao.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Preço Unitário");

        campoPreco.setEditable(false);
        campoPreco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Quantidade");

        campoQtde.setEditable(false);
        campoQtde.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        campoQtde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoQtdeKeyReleased(evt);
            }
        });

        campoCliente.setEditable(false);
        campoCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        botaoBuscarCliente.setText("Buscar");
        botaoBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarClienteActionPerformed(evt);
            }
        });

        botaoBuscarUsuario.setText("Buscar");
        botaoBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarUsuarioActionPerformed(evt);
            }
        });

        campoUsuario.setEditable(false);
        campoUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        campoSubTotal.setEditable(false);
        campoSubTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("SubTotal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(botaoAddCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botaoBuscarCliente)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoBuscarUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(campoUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(campoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(campoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                    .addGap(73, 73, 73)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(campoQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoTotalFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(108, 108, 108))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(botaoBuscarCliente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(botaoBuscarUsuario)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoAddCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(campoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoQtde)
                    .addComponent(campoSubTotal))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTotalFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarClienteActionPerformed
        tableCliente.setVisible(true);
    }//GEN-LAST:event_botaoBuscarClienteActionPerformed

    private void tabelaProdutosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseReleased
        produtoParaCarrinho = new Produto();
        int linha = tabelaProdutos.getSelectedRow();
        produtoParaCarrinho = tableModelProduto.getValue(linha);
        campoDescricao.setText(produtoParaCarrinho.getDescricao());
        campoPreco.setText(produtoParaCarrinho.getValor().toString());
        campoQtde.setEditable(true);
        campoQtde.setText("1");
        campoSubTotal.setText(produtoParaCarrinho.getValor().toString());
    }//GEN-LAST:event_tabelaProdutosMouseReleased

    private void botaoBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarUsuarioActionPerformed
        tableUsuario.setVisible(true);
    }//GEN-LAST:event_botaoBuscarUsuarioActionPerformed

    private void botaoAddCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAddCarrinhoActionPerformed

        if (listaDoCarrinho.isEmpty()) {
            novoItemVenda();
        } else {
            for (int i = 0; i < listaDoCarrinho.size(); i++) {
                if (listaDoCarrinho.get(i).getProduto().getDescricao().equals(produtoParaCarrinho.getDescricao())) {
                    Integer campoqtde = Integer.parseInt(campoQtde.getText());
                    listaDoCarrinho.get(i).setQtdeVenda(listaDoCarrinho.get(i).getQtdeVenda() + campoqtde);
                    BigDecimal precoUni = new BigDecimal(campoPreco.getText());
                    listaDoCarrinho.get(i).setTotal(precoUni.multiply(new BigDecimal(listaDoCarrinho.get(i).getQtdeVenda())));
                    preencherTabelaCarrinho();
                    limparCamposItemVenda();
                    return;
                }
            }
            novoItemVenda();
        }
    }//GEN-LAST:event_botaoAddCarrinhoActionPerformed

    private void campoDescricaoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDescricaoProdutoKeyReleased
        List<Produto> l = produtoBO.buscarProdutoPorDescricao(campoDescricaoProduto.getText());
        tableModelProduto.setData(l);
    }//GEN-LAST:event_campoDescricaoProdutoKeyReleased

    private void campoQtdeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoQtdeKeyReleased
        if ("".equals(campoQtde.getText().trim())) {
            campoSubTotal.setText("");
        }
        Double preco = Double.parseDouble(campoPreco.getText());
        Integer qtde = Integer.parseInt(campoQtde.getText());
        Double sub = preco * qtde;
        campoSubTotal.setText(sub.toString());
    }//GEN-LAST:event_campoQtdeKeyReleased

    private void botaoFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFinalizarActionPerformed
        if ("".equals(campoCliente.getText()) || "".equals(campoUsuario.getText()) || listaDoCarrinho.isEmpty()) {
            return;
        }

        venda.setDataVenda(new Date(WIDTH));
        vendaBO.inserir(venda);

        for (ItemVenda itemVenda1 : listaDoCarrinho) {
            itemVenda1.setVenda(venda);
            itemVendaBO.inserir(itemVenda1);
        }
        JOptionPane.showMessageDialog(null, "Venda Realizada");
        novaVenda();

    }//GEN-LAST:event_botaoFinalizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAddCarrinho;
    private javax.swing.JButton botaoBuscarCliente;
    private javax.swing.JButton botaoBuscarUsuario;
    private javax.swing.JButton botaoFinalizar;
    private javax.swing.JTextField campoCliente;
    private javax.swing.JTextField campoDescricao;
    private javax.swing.JTextField campoDescricaoProduto;
    private javax.swing.JTextField campoPreco;
    private javax.swing.JTextField campoQtde;
    private javax.swing.JTextField campoSubTotal;
    private javax.swing.JLabel campoTotalFinal;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaCarrinho;
    private javax.swing.JTable tabelaProdutos;
    // End of variables declaration//GEN-END:variables
}
