/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.usuario.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.usuario.datamodel.Usuario;

/**
 *
 * @author Tássio
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

}
