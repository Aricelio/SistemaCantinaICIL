package br.com.sistemaCantinaICIL.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Aricelio de Souza - 15/12/2015
 */
public abstract class DAOGenerico<T> extends JPAUtil {

    private Class tipo;

    // Construtor
    public DAOGenerico(Class t) {
        this.tipo = t;
    }

    // Salvar
    public void Salvar(T object) throws Exception {
        EntityManager manager = getEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(object);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            manager.getTransaction().rollback();
            throw new Exception("Não foi possivel Salvar!");
        } finally {
            manager.close();
        }
    }

    // Atualizar
    public void Atualizar(T object) throws Exception {
        EntityManager manager = getEntityManager();

        try {
            manager.getTransaction().begin();
            manager.merge(object);
            manager.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            manager.getTransaction().rollback();
            throw new Exception("Não foi possivel Atualizar!");
        } finally{
            manager.close();
        }
    }

    // Abrir
    public T Abrir(Long id) throws Exception {
        T obj;
        EntityManager manager = getEntityManager();

        try {
            obj = (T) manager.find(tipo, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Atenção! Não foi possivel Abrir o registro!");
        }
        return obj;
    }

    // Buscar
    public abstract List<T> Buscar(T object) throws Exception ;
    
    // Apagar
    public void Apagar(T object) throws Exception {
        EntityManager manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.remove(manager.merge(object));
            manager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            manager.getTransaction().rollback();
            throw new Exception("Não foi possivel Apagar!");
        } finally {
            manager.close();
        }
    }
    
}
