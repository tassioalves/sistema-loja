package br.edu.ifms.loja.cliente.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.cliente.datamodel.Cliente;
import java.util.List;
import javax.persistence.EntityManager;

public class ClienteDAO extends GenericDAO<Cliente> {

    public ClienteDAO() {
        super(Cliente.class);
    }

    public List<Cliente> buscarPorCpf(String cpf) {
        EntityManager em = getEntityManager();

        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT c From Cliente c ");
        consulta.append("FROM Cliente c ");
        consulta.append("WHERE c.cpf LIKE %:cpf% ");

        return em.createQuery(consulta.toString())
                .setParameter("cpf", cpf)
                .getResultList();
    }

    public List<Cliente> buscarClientePorNome(String nome) {
        EntityManager em = getEntityManager();

        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT c ");
        consulta.append("FROM Cliente c ");
        consulta.append("WHERE c.nome LIKE :nome ");

        return em.createQuery(consulta.toString())
                .setParameter("nome", nome + "%")
                .getResultList();
    }

    public List<Cliente> buscarClientePorNomeOuCPF(String cpf, String nome) {
        EntityManager em = getEntityManager();

        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT c ");
        consulta.append("FROM Cliente c ");
        consulta.append("WHERE c.cpf LIKE :cpf ");
        consulta.append("OR c.nome LIKE :nome ");

        return em.createQuery(consulta.toString())
                .setParameter("cpf", cpf + "%")
                .setParameter("nome", nome + "%")
                .getResultList();
    }
}
