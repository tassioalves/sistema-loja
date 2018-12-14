/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.fornecedor.view;

import br.edu.ifms.loja.app.layouts.GenericCRUD;
import br.edu.ifms.loja.fornecedor.bo.FornecedorBO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import java.awt.Frame;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class FornecedorCRUD extends GenericCRUD<Fornecedor> {

    private Fornecedor fornecedor;
    private FornecedorBO fornecedorBO;
    private FornecedorFormulario formularioFornecedor;

    public FornecedorCRUD(Frame parent, boolean modal) {
        super(parent, modal, Fornecedor.class, new String[]{"id", "nome","razaoSocial","cnpj","telefone","email","endereco","numero","cidade.nome:Cidade"});

        fornecedorBO = new FornecedorBO();
        carregarTabela();
    }

    
    @Override
    public void setSize(int width, int height) {
        super.setSize(800, 600);
    }

    @Override
    protected JPanel criarFormulario() {
        formularioFornecedor = new FornecedorFormulario();
        return formularioFornecedor;
    }

    @Override
    protected void camposParaObjeto() {
        fornecedor.setNome(formularioFornecedor.getCampoNome().getText());
        fornecedor.setRazaoSocial(formularioFornecedor.getCampoRazaoSocial().getText());
        fornecedor.setCnpj(formularioFornecedor.getCampoCNPJ().getText());
        fornecedor.setTelefone(formularioFornecedor.getCampoTelefone().getText());
        fornecedor.setEmail(formularioFornecedor.getCampoEmail().getText());
        fornecedor.setCep(formularioFornecedor.getCampoCep().getText());
        fornecedor.setEndereco(formularioFornecedor.getCampoEndereco().getText());
        fornecedor.setNumero(formularioFornecedor.getCampoNumero().getText());
        fornecedor.setCidade(formularioFornecedor.getComboBoxUfCidade().getSelectedCidade());
       
    }

    @Override
    protected void objetoParaCampos() {
        formularioFornecedor.getCampoNome().setText(fornecedor.getNome());
        formularioFornecedor.getCampoRazaoSocial().setText(fornecedor.getRazaoSocial());
        formularioFornecedor.getCampoCNPJ().setText(fornecedor.getCnpj());
        formularioFornecedor.getCampoTelefone().setText(fornecedor.getTelefone());
        formularioFornecedor.getCampoEmail().setText(fornecedor.getEmail());
        formularioFornecedor.getCampoCep().setText(fornecedor.getCep());
        formularioFornecedor.getCampoEndereco().setText(fornecedor.getEndereco());
        formularioFornecedor.getCampoNumero().setText(fornecedor.getNumero());
        formularioFornecedor.getComboBoxUfCidade().setSelectedCidade(fornecedor.getCidade());

    }

    @Override
    protected void salvar() {
        fornecedorBO.inserir(fornecedor);
    }

    @Override
    protected void editar() {

    }

    @Override
    protected void novo() {
        fornecedor = new Fornecedor();
    }

    @Override
    protected void cancelar() {

    }

    @Override
    protected void excluir() {
        fornecedorBO.remover(fornecedor);
    }

    @Override
    protected List buscar(String param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Fornecedor> carregarListaParaTabela() {
        return fornecedorBO.listarTodos();
    }

    @Override
    protected void obterItemSelecionadoNaTabela(Fornecedor itemSelecionado) {
        fornecedor = itemSelecionado;
    }

}
