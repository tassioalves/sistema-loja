/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.venda.bo;

import br.edu.ifms.loja.app.bo.GenericBO;
import br.edu.ifms.loja.venda.dao.ItemVendaDAO;
import br.edu.ifms.loja.venda.dao.VendaDAO;
import br.edu.ifms.loja.venda.datamodel.Venda;

/**
 *
 * @author Tássio
 */
public class VendaBO extends GenericBO<Venda> {

    private VendaDAO daoVenda;

    public VendaBO() {
        super(Venda.class);
        daoVenda = new VendaDAO();
    }
}
