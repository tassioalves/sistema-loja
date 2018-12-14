package br.edu.ifms.loja.cliente.datamodel;

import br.edu.ifms.loja.cidade.datamodel.Cidade;
import com.towel.el.annotation.Resolvable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Resolvable(colName = "ID")
    private Long id;
    @Resolvable(colName = "Nome")
    private String nome;
    @Resolvable(colName = "CPF")
    private String cpf;
    @Resolvable(colName = "E-mail")
    private String email;
    @Resolvable(colName = "Telefone")
    private String telefone;
    @Resolvable(colName = "Endereço")
    private String endereco;
    @Resolvable(colName = "Numero")
    private String numero;
    @Resolvable(colName = "Cidade_id")
    @ManyToOne
    private Cidade cidade;
    
    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return this.nome;
    }


}

