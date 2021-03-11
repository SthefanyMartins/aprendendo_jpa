package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Cliente;

public class ClienteTeste {
    
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyPU");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    public static void main(String[] args) {
        //find
        Cliente cliente = entityManager.find(Cliente.class, 1);
                
        //Insert
        Cliente cliente1 = new Cliente();
        cliente1.setNome("GOOGLE");
        entityManager.getTransaction().begin();
        entityManager.persist(cliente1);
        entityManager.getTransaction().commit();
        
        //delete
        Cliente cliente2 = entityManager.find(Cliente.class, 2);
        entityManager.getTransaction().begin();
        entityManager.remove(cliente2);
        entityManager.getTransaction().commit();
        
        //update
        Cliente cliente3 = new Cliente();
        cliente3.setId(1);
        cliente3.setNome("GOOGLE");
        entityManager.getTransaction().begin();
        entityManager.merge(cliente3);
        entityManager.getTransaction().commit();
        
        entityManager.close();
        entityManagerFactory.close();
        
    }
}
