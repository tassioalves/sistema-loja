package br.edu.ifms.loja.fornecedor.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;

public class FornecedorDAO extends GenericDAO<Fornecedor> {

    public FornecedorDAO() {
        super(Fornecedor.class);
    }
}
