/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.fornecedor.exception;

import br.edu.ifms.loja.app.exception.ApplicationException;

/**
 *
 * @author Gustavo
 */
public class CNPJException extends ApplicationException{
    @Override
    public String getMessage() {
        return "CNPJ inválido";
    }
}
