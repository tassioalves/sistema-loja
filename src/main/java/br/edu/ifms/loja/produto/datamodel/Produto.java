/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.produto.datamodel;

import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import com.towel.el.annotation.Resolvable;
import java.math.BigInteger;
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
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Resolvable(colName = "ID")
    private long id;
    @Resolvable(colName = "Descricao")
    private String descricao;
    @Resolvable(colName = "Marca")
    private String marca;
    @Resolvable(colName = "Modelo")
    private String modelo;
    @Resolvable(colName = "Qtde")
    private BigInteger qtde;
    @Resolvable(colName = "Valor")
    private Double valor;
    @Resolvable(colName = "Fornecedor_cod")
    @ManyToOne
    private Fornecedor fornecedor;

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigInteger getQtde() {
        return qtde;
    }

    public void setQtde(BigInteger qtde) {
        this.qtde = qtde;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    
    
}
