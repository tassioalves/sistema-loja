/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.venda.view;

import br.edu.ifms.loja.app.layouts.GenericCRUD;
import br.edu.ifms.loja.venda.bo.VendaBO;
import br.edu.ifms.loja.venda.datamodel.Venda;
import java.awt.Frame;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Tássio
 */
public class VendaCRUD extends GenericCRUD<Venda> {

    private VendaBO vendaBO;
    private VendaFormulario vendaFormulario;

    public VendaCRUD(Frame parent, boolean modal) {
        super(parent, modal, Venda.class, new String[]{"id", "cliente", "usuario", "dataVenda"});
        vendaBO = new VendaBO();
    }

    @Override
    protected JPanel criarFormulario() {
        vendaFormulario = new VendaFormulario();
        return vendaFormulario;
    }

    @Override
    protected void camposParaObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void objetoParaCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void salvar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void novo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void cancelar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List buscar(String param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Venda> carregarListaParaTabela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void obterItemSelecionadoNaTabela(Venda itemSelecionado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
