package testes;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Cliente;

public class ClienteTeste {
    
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyPU");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    public static void main(String[] args) {
        //Select
        String jpql = "select c from Cliente c";
        TypedQuery<Cliente> tipedQuery = entityManager.createQuery(jpql, Cliente.class);
        List<Cliente> listaCliente = tipedQuery.getResultList();
        
        for(Cliente cliente: listaCliente){
            System.out.println(cliente.getNome());
        }
        
        //select com where
        String jpql1 = "select c from Cliente c where id = :idCliente";
        Integer idCliente = 5;
        TypedQuery<Cliente> tipedQuery1 = entityManager.createQuery(jpql1, Cliente.class).setParameter("idCliente", idCliente);
        List<Cliente> listaCliente1 = tipedQuery1.getResultList();
        
        for(Cliente cliente: listaCliente1){
            System.out.println(cliente.getNome());
        }
        
        entityManager.close();
        entityManagerFactory.close();
        
    }
}
