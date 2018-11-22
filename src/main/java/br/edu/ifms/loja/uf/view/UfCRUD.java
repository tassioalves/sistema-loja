/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.uf.view;

import br.edu.ifms.loja.app.layouts.GenericCRUD;
import br.edu.ifms.loja.uf.bo.UfBO;
import br.edu.ifms.loja.uf.datamodel.Uf;
import java.awt.Frame;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Tássio
 */
public class UfCRUD extends GenericCRUD<Uf> {

    private Uf uf;
    private UfBO ufBo;
    private UfFormulario formularioUF;

    public UfCRUD(Frame parent, boolean modal) {
        super(parent, modal, Uf.class, new String[]{"id", "icms", "sigla", "nome"});

        ufBo = new UfBO();
        carregarTabela();

    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(800, 600);
    }

    @Override
    protected JPanel criarFormulario() {
        formularioUF = new UfFormulario();
        return formularioUF = new UfFormulario();
    }

    @Override
    protected void camposParaObjeto() {
        uf.setIcms(formularioUF.getCampoIcms().getText());
        uf.setSigla(formularioUF.getCampoSigla().getText());
        uf.setNome(formularioUF.getCampoNome().getText());

    }

    @Override
    protected void objetoParaCampos() {
        formularioUF.getCampoIcms().setText(uf.getIcms());
        formularioUF.getCampoSigla().setText(uf.getSigla());
        formularioUF.getCampoNome().setText(uf.getNome());
    }

    @Override
    protected void salvar() {
        ufBo.inserir(uf);
    }

    @Override
    protected void editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void novo() {
        uf = new Uf();
    }

    @Override
    protected void cancelar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void excluir() {
        ufBo.remover(uf);
    }

    @Override
    protected List buscar(String param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Uf> carregarListaParaTabela() {
        return ufBo.listarTodos();
    }

    @Override
    protected void obterItemSelecionadoNaTabela(Uf itemSelecionado) {
        this.uf = itemSelecionado;
    }

}
