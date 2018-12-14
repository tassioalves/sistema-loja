package br.edu.ifms.loja.cliente.bo;

import br.edu.ifms.loja.app.bo.GenericBO;
import br.edu.ifms.loja.cliente.dao.ClienteDAO;
import br.edu.ifms.loja.cliente.datamodel.Cliente;
import java.util.Date;
import java.util.List;

public class ClienteBO extends GenericBO<Cliente> {

    private ClienteDAO daoCliente;

    public ClienteBO(){
        super(Cliente.class);
        daoCliente = new ClienteDAO();
    }

    public List<Cliente> buscarClientePorCpf(String cpf) {
        return daoCliente.buscarPorCpf(cpf);
    }

    public List<Cliente> buscarClientePorNome(String nome) {
        return daoCliente.buscarClientePorNome(nome);
    }

    public List<Cliente> buscarClientePorNomeOuCPF(String param) {
        return daoCliente.buscarClientePorNomeOuCPF(param, param);
    }

    private void validarCliente(Cliente cliente) {

    }

    public List<Cliente> listarTodosOsClientes() {
        return null;
    }

    public int calculaIdade(Date dataNasc) {
        return 0;
    }
}
