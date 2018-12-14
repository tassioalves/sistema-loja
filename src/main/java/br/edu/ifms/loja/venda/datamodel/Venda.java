/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.venda.datamodel;

import br.edu.ifms.loja.cliente.datamodel.Cliente;
import br.edu.ifms.loja.usuario.datamodel.Usuario;
import com.towel.el.annotation.Resolvable;
import java.util.Date;
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
public class Venda {

    @Id
    @Resolvable(colName = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @Resolvable(colName = "Cliente")
    private Cliente cliente;
    @ManyToOne
    @Resolvable(colName = "Usuario")
    private Usuario usuario;
    @Resolvable(colName = "Data")
    private Date dataVenda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

}
