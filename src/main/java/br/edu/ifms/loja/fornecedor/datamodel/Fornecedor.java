package br.edu.ifms.loja.fornecedor.datamodel;

import br.edu.ifms.loja.cidade.datamodel.Cidade;
import com.towel.el.annotation.Resolvable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Resolvable(colName = "id")
    private Long id;
    @Resolvable(colName = "Nome")
    private String nome;
    @Resolvable(colName = "Razão_Social")
    private String razaoSocial;
    @Resolvable(colName = "CNPJ")
    private String cnpj;
    @Resolvable(colName = "Telefone")
    private String telefone;
    @Resolvable(colName = "E-Mail")
    private String email;
    @Resolvable(colName = "CEP")
    private String cep;
    @Resolvable(colName = "Endereço")
    private String endereco;
    @Resolvable(colName = "Numero")
    private String numero;
    @Resolvable(colName = "Cidade_Cod")
    @ManyToOne
    private Cidade cidade;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fornecedor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String toString() {
        return nome;
    }

}
