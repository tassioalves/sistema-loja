/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cidade.view;

import br.edu.ifms.loja.app.layouts.GenericCRUD;
import br.edu.ifms.loja.cidade.bo.CidadeBO;
import br.edu.ifms.loja.cidade.datamodel.Cidade;
import java.awt.Frame;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Tássio
 */
public class CidadeCRUD extends GenericCRUD<Cidade> {

    private Cidade cidade;
    private CidadeBO cidadeBO;
    private CidadeFormulario formularioCidade;

    public CidadeCRUD(Frame parent, boolean modal) {
        super(parent, modal, Cidade.class, new String[]{"id:ID", "nome:NOME","uf.sigla:Uf"});
        cidadeBO = new CidadeBO();
        carregarTabela();

    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(800, 600);
    }

    @Override
    protected JPanel criarFormulario() {
        return formularioCidade = new CidadeFormulario();
    }

    @Override
    protected void camposParaObjeto() {
        cidade.setNome(formularioCidade.getCampoNome().getText());
        cidade.setUf(formularioCidade.getUf());
    }

    @Override
    protected void objetoParaCampos() {
        formularioCidade.getCampoNome().setText(cidade.getNome());
        formularioCidade.setSelectedUf(cidade.getUf());
    }

    @Override
    protected void salvar() {
        cidadeBO.inserir(cidade);
        
    }

    @Override
    protected void editar() {
     
    }

    @Override
    protected void novo() {
        cidade = new Cidade();
        
    }

    @Override
    protected void cancelar() {
     
    }

    @Override
    protected void excluir() {
        cidadeBO.remover(cidade);
    }

    @Override
    protected List buscar(String param) {
        return null;
    }

    @Override
    protected List<Cidade> carregarListaParaTabela() {
        return cidadeBO.listarTodos();
    }

    @Override
    protected void obterItemSelecionadoNaTabela(Cidade itemSelecionado) {
        this.cidade = itemSelecionado;
    }

}
