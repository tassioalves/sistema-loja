package br.edu.ifms.loja.fornecedor.bo;

import br.edu.ifms.loja.app.bo.GenericBO;
import br.edu.ifms.loja.fornecedor.dao.FornecedorDAO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import java.sql.SQLException;

public class FornecedorBO extends GenericBO<Fornecedor>{

    private FornecedorDAO daoFornecedor;

    public FornecedorBO(){
        super(Fornecedor.class);
        daoFornecedor = new FornecedorDAO();
    }
}
