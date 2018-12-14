/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.usuario.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.usuario.datamodel.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Tássio
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public List<Usuario> buscarUsuarioPorNomeOuCPF(String nome) {
        EntityManager em = getEntityManager();

        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT u ");
        consulta.append("FROM Usuario u ");
        consulta.append("WHERE u.nome LIKE :nome ");

        return em.createQuery(consulta.toString())
                .setParameter("nome", nome + "%")
                .getResultList();
    }

}
