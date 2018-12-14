/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.usuario.datamodel;

import br.edu.ifms.loja.cidade.datamodel.Cidade;
import com.towel.el.annotation.Resolvable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Tássio
 */
@Entity
public class Usuario {

    @Id
    @Resolvable(colName = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Resolvable(colName = "E_mail")
    private String email;
    @Resolvable(colName = "Senha")
    private String senha;
    @Resolvable(colName = "Papel")
    private String papel;
    @Resolvable(colName = "Nome")
    private String nome;
    @Resolvable(colName = "Endereco")
    private String endereco;
    @Resolvable(colName = "Numero")
    private String numero;
    @Resolvable(colName="CEP")
    private String cep;
    @ManyToOne
    @Resolvable(colName="Cidade_id")
    private Cidade cidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
