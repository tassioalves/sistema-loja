/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.app.bd;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Gustavo
 */
public class GenericDAO <T>{
    private EntityManager em;

    public GenericDAO() {
        
    }
    
    public void inserir(T t){
        
    }
    
    public void atualizar(T t){
        
    }
    
    public void remover(Long id){
        
    }
    
    public void remover(T t){
     
    }
    
    public T buscarPorId(Long id){
        return null;
    }
    
    public List<T> listarTodos(Class clazz){
        return new ArrayList<>();
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
