package br.com.sistemaCantinaICIL.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aricelio de Souza - 15/12/2015
 */
public class JPAUtil {

    private static final String PERSISTENCE = "CantinaPU";        
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE);

    // Retorna o EntityManager
    public static EntityManager getEntityManager() {        
        return emf.createEntityManager();
    }
    
    // Fecha a conexão
    public static void closeEntityManager() {
        emf.close();
    }
}
