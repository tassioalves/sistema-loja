package br.edu.ifms.loja.cliente.bo;

import br.edu.ifms.loja.cliente.dao.ClienteDAO;
import br.edu.ifms.loja.cliente.datamodel.Cliente;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ClienteBO {

    private ClienteDAO daoCliente;

    public ClienteBO() throws SQLException {
        daoCliente = new ClienteDAO();
    }

    public void inserirCiente(Cliente cliente){
      
    }

    public void atualizarCliente(Cliente cliente){
       
    }

    public void excluirCliente(Integer cod){

    }

    public List<Cliente> buscarClientePorCpf(String cpf){
        return daoCliente.buscarPorCpf(cpf);
    }
    
    public List<Cliente>buscarClientePorNome(String nome){
        return daoCliente.buscarClientePorNome(nome);
    }

    private void validarCliente(Cliente cliente){
      
    }

    public List<Cliente> listarTodosOsClientes(){
        return null;
    }

    public int calculaIdade(Date dataNasc) {
        return 0;
    }    
}
