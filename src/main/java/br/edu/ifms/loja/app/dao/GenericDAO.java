/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.app.dao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Gustavo
 */
public class GenericDAO <T>{
    private EntityManager em;
    private Class<T> clazz;
    
    public GenericDAO(Class<T> clazz) {
        em = FabricaDeGerenciadorDeEntidades.getEntityManager();
        this.clazz = clazz;
    }
    
    public void abrirTransacao(){
        em.getTransaction().begin();
    }
    
    public void commit(){
        em.getTransaction().commit();
    }
    
    public void rollback(){
        em.getTransaction().rollback();
    }
    
    public void inserir(T t){
        abrirTransacao();
        em.persist(t);
        commit();
    }
    
    public void atualizar(T t){
        abrirTransacao();
        em.merge(t);
        commit();
    }
    
    public void remover(Long id){
        abrirTransacao();
        T t = buscarPorId(id);
        em.remove(t);
        commit();
    }
    
    public void remover(T t){
        abrirTransacao();
        em.remove(t);
        commit();
    }
    
    public T buscarPorId(Long id){
        return em.find(clazz, id);
    }
    
    public List<T> listarTodos(){
        return em.createQuery("SELECT t FROM "+clazz.getSimpleName()+" t")         
                .getResultList();
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
