/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cliente.exception;

import br.edu.ifms.loja.app.exception.ApplicationException;

/**
 *
 * @author PC
 */
public class CPFException extends ApplicationException{

    @Override
    public String getMessage() {
        return "CPF inválido";
    }
    
}
