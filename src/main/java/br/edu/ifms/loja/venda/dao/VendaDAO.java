/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.venda.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.venda.datamodel.Venda;

/**
 *
 * @author Tássio
 */
public class VendaDAO extends GenericDAO<Venda>{
    
    public VendaDAO() {
        super(Venda.class);
    }
    
}
