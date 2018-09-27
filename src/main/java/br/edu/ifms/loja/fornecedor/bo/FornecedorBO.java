package br.edu.ifms.loja.fornecedor.bo;

import br.edu.ifms.loja.fornecedor.dao.FornecedorDAO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import java.sql.SQLException;

public class FornecedorBO {

    private FornecedorDAO dao;

    public FornecedorBO() throws SQLException {
        dao = new FornecedorDAO();
    }

    public Fornecedor buscarFornecedorPorCod(Long cod) {
        return dao.buscarFornecedorPorCod(cod);
    }
}
