/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.uf.bo;

import br.edu.ifms.loja.app.bo.GenericBO;
import br.edu.ifms.loja.uf.dao.UfDAO;
import br.edu.ifms.loja.uf.datamodel.Uf;

/**
 *
 * @author Tássio
 */
public class UfBO extends GenericBO<Uf> {

    private UfDAO daoUf;

    public UfBO() {
        super(Uf.class);
        daoUf = new UfDAO();
    }

}
