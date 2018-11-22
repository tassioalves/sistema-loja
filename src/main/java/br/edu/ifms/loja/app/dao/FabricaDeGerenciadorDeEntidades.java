package br.edu.ifms.loja.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaDeGerenciadorDeEntidades {

    private static final String PERSISTENCE_UNIT = "sistema-loja-pu";
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public static void fecharConexoes() {
        if (entityManager != null) {
            entityManager.close();
            entityManager = null;
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
            entityManagerFactory = null;
        }
    }

    private FabricaDeGerenciadorDeEntidades() {

    }
}
