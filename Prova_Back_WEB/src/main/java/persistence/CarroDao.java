package persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Carro;

public class CarroDao extends DaoGenerico{
    
    public static void excluir( long id ){
        EntityManagerFactory emf =
                javax.persistence.Persistence.createEntityManagerFactory(NOME_PU);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Carro c WHERE c.id = " + id ).executeUpdate();
    }
    
    public static List<Carro> listar(){
        EntityManagerFactory emf =
                javax.persistence.Persistence.createEntityManagerFactory(NOME_PU);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return em.createQuery("SELECT c FROM Carro c").getResultList();
    }
    
    public static List<Carro> listar( String modelo){
        EntityManagerFactory emf =
                javax.persistence.Persistence.createEntityManagerFactory(NOME_PU);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return em.createQuery("SELECT c FROM Carro c WHERE c.modelo = \"" + modelo + "\"" ).getResultList();
    }
    
    
}
