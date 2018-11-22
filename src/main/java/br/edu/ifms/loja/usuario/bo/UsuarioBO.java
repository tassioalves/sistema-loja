/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.usuario.bo;

import br.edu.ifms.loja.app.bo.GenericBO;
import br.edu.ifms.loja.usuario.dao.UsuarioDAO;
import br.edu.ifms.loja.usuario.datamodel.Usuario;

/**
 *
 * @author Tássio
 */
public class UsuarioBO extends GenericBO<Usuario> {

    private UsuarioDAO usuarioDAO;

    public UsuarioBO() {
        super(Usuario.class);
        usuarioDAO = new UsuarioDAO();
    }

}
