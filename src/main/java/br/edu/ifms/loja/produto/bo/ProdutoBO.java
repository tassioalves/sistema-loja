/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.produto.bo;

import br.edu.ifms.loja.app.bo.GenericBO;
import br.edu.ifms.loja.cliente.datamodel.Cliente;
import br.edu.ifms.loja.produto.dao.ProdutoDAO;
import br.edu.ifms.loja.produto.datamodel.Produto;
import java.util.List;

/**
 *
 * @author Tássio
 */
public class ProdutoBO extends GenericBO<Produto> {

    private ProdutoDAO daoProduto;

    public ProdutoBO() {
        super(Produto.class);
        daoProduto = new ProdutoDAO();
    }


    public List<Cliente> buscarProdutoPorDescricao(String descricao) {
        return null;
    }

    public List<Produto> listarTodosOsProdutos() {
        return null;
    }

}
