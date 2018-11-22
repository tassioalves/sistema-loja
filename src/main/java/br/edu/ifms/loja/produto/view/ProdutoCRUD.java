/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.produto.view;

import br.edu.ifms.loja.app.layouts.GenericCRUD;
import br.edu.ifms.loja.fornecedor.bo.FornecedorBO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import br.edu.ifms.loja.produto.bo.ProdutoBO;
import br.edu.ifms.loja.produto.datamodel.Produto;
import java.awt.Frame;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Tássio
 */
public class ProdutoCRUD extends GenericCRUD<Produto> {

    private Produto produto;
    private ProdutoBO produtoBO;
    private ProdutoFormulario formularioProduto;
    private FornecedorBO fornecedorBO;

    public ProdutoCRUD(Frame parent, boolean modal) {
        super(parent, modal, Produto.class, new String[]{"id", "descricao", "marca", "modelo"});
        produtoBO = new ProdutoBO();
        fornecedorBO = new FornecedorBO();
        carregarTabela();
        carregarComboBoxFornecedro();
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(800, 600);
    }

    public void carregarComboBoxFornecedro() {
        List<Fornecedor> fornecedores = fornecedorBO.listarTodos();
        formularioProduto.carregarFornecedor(fornecedores);
    }

    @Override
    protected JPanel criarFormulario() {
        formularioProduto = new ProdutoFormulario();
        formularioProduto.setVisible(true);
        return formularioProduto;
    }

    @Override
    protected void camposParaObjeto() {
        produto.setDescricao(formularioProduto.getCampoDescricao().getText());
        produto.setMarca(formularioProduto.getCampoMarca().getText());
        produto.setModelo(formularioProduto.getCampoModelo().getText());
        produto.setQtde(new BigInteger(formularioProduto.getCampoQuantidade().getText()));
        produto.setValor(new Double(formularioProduto.getCampoQuantidade().getText()));
        produto.setFornecedor(formularioProduto.getFornecedor());
    }

    @Override
    protected void objetoParaCampos() {
        formularioProduto.getCampoDescricao().setText(produto.getDescricao());
        formularioProduto.getCampoMarca().setText(produto.getMarca());
        formularioProduto.getCampoModelo().setText(produto.getModelo());
        formularioProduto.setSelectedFornecedor(produto.getFornecedor());
        if (produto.getValor() != null) {
            formularioProduto.getCampoValor().setText(produto.getValor().toString());
        } else {
            formularioProduto.getCampoValor().setText("");
        }
        if (produto.getQtde() != null) {
            formularioProduto.getCampoQuantidade().setText(produto.getQtde().toString());
        } else {
            formularioProduto.getCampoQuantidade().setText("");
        }
    }

    @Override
    protected void salvar() {
        produtoBO.inserir(produto);
    }

    @Override
    protected void editar() {

    }

    @Override
    protected void novo() {
        produto = new Produto();
    }

    @Override
    protected void cancelar() {

    }

    @Override
    protected void excluir() {
        produtoBO.remover(produto);
    }

    @Override
    protected List buscar(String param) {
        return produtoBO.buscarProdutoPorDescricao(param);
    }

    @Override
    protected List<Produto> carregarListaParaTabela() {
        carregarComboBoxFornecedro();
        return produtoBO.listarTodos();
    }

    @Override
    protected void obterItemSelecionadoNaTabela(Produto itemSelecionado) {
        this.produto = itemSelecionado;
    }

}
