/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.produto.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.produto.datamodel.Produto;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Tássio
 */
public class ProdutoDAO extends GenericDAO<Produto>{
    
    public ProdutoDAO() {
        super(Produto.class);
    }
    
    public List<Produto> buscarProdutoPorDescricao(String desc){
        EntityManager em = getEntityManager();

        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT p ");
        consulta.append("FROM Produto p ");
        consulta.append("WHERE p.descricao LIKE :desc ");

        return em.createQuery(consulta.toString())
                .setParameter("desc", desc + "%")
                .getResultList();
    }
    
}
