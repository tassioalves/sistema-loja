/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.usuario.view;

import br.edu.ifms.loja.app.layouts.GenericCRUD;
import br.edu.ifms.loja.usuario.bo.UsuarioBO;
import br.edu.ifms.loja.usuario.datamodel.Usuario;
import java.awt.Frame;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Tássio
 */
public class UsuarioCRUD extends GenericCRUD<Usuario> {

    private Usuario usuario;
    private UsuarioBO usuarioBO;
    private UsuarioFormulario formularioUsuario;

    public UsuarioCRUD(Frame parent, boolean modal) {
        super(parent, modal, Usuario.class, new String[]{"id","nome","email","papel"});
        usuarioBO = new UsuarioBO();
        carregarTabela();
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(800, 600);
    }

    @Override
    protected JPanel criarFormulario() {
        formularioUsuario = new UsuarioFormulario();
        return formularioUsuario;
    }

    @Override
    protected void camposParaObjeto() {
        usuario.setCep(formularioUsuario.getCampoCep().getText());
        usuario.setEmail(formularioUsuario.getCampoEmail().getText());
        usuario.setEndereco(formularioUsuario.getCampoEndereco().getText());
        usuario.setNome(formularioUsuario.getCampoNome().getText());
        usuario.setNumero(formularioUsuario.getCampoNumero().getText());
        usuario.setPapel(formularioUsuario.getCampoPapel().getText());
        usuario.setSenha(formularioUsuario.getCampoSenha().getText());
        usuario.setCidade(formularioUsuario.getComboBoxUfCidade().getSelectedCidade());
    }

    @Override
    protected void objetoParaCampos() {
        formularioUsuario.getCampoEmail().setText(usuario.getEmail());
        formularioUsuario.getCampoSenha().setText(usuario.getSenha());
        formularioUsuario.getCampoPapel().setText(usuario.getPapel());
        formularioUsuario.getCampoNome().setText(usuario.getNome());
        formularioUsuario.getCampoEndereco().setText(usuario.getEndereco());
        formularioUsuario.getCampoCep().setText(usuario.getCep());
        formularioUsuario.getCampoNumero().setText(usuario.getNumero());

        formularioUsuario.getComboBoxUfCidade().setSelectedCidade(usuario.getCidade());
    }

    @Override
    protected void salvar() {
        usuarioBO.inserir(usuario);
    }

    @Override
    protected void editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void novo() {
        usuario = new Usuario();
    }

    @Override
    protected void cancelar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void excluir() {
        usuarioBO.remover(usuario);
    }

    @Override
    protected List buscar(String param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Usuario> carregarListaParaTabela() {
        return usuarioBO.listarTodos();
    }

    @Override
    protected void obterItemSelecionadoNaTabela(Usuario itemSelecionado) {
        usuario = itemSelecionado;
    }

}
