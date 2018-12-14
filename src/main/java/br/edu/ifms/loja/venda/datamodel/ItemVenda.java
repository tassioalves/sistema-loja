/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.venda.datamodel;

import br.edu.ifms.loja.produto.datamodel.Produto;
import com.towel.el.annotation.Resolvable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author Tássio
 */
@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Resolvable(colName = "id")
    private Long id;
    @Resolvable(colName = "Valor Uni")
    private Double valorVenda;
    @Resolvable(colName = "Qtde. Venda")
    private Integer qtdeVenda;
    @ManyToOne
    @Resolvable(colName = "produto")
    private Produto produto;
    @ManyToOne
    @Resolvable(colName = "venda")
    private Venda venda;
    @Resolvable(colName = "Total")
    @Transient
    private BigDecimal total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Integer getQtdeVenda() {
        return qtdeVenda;
    }

    public void setQtdeVenda(Integer qtdeVenda) {
        this.qtdeVenda = qtdeVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
