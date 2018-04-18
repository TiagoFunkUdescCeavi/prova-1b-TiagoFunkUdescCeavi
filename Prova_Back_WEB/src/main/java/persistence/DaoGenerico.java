package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DaoGenerico {

    protected final static String NOME_PU = "Prova_Back_PU";
    
    public static void salvar( Object o ) {
        EntityManagerFactory emf =
                javax.persistence.Persistence.createEntityManagerFactory(NOME_PU);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public static void edit( Object o ) {
        EntityManagerFactory emf =
                javax.persistence.Persistence.createEntityManagerFactory(NOME_PU);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public static Object find( Class classe, Long id ) {
        Object o = null;
        EntityManagerFactory emf =
                javax.persistence.Persistence.createEntityManagerFactory(NOME_PU);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            o = em.find(classe, id);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return o;
    }
}
