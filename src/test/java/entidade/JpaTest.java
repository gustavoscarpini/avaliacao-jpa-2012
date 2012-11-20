package entidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.BeforeClass;
import org.junit.Test;

public class JpaTest {

    private static EntityManagerFactory emf;

    @BeforeClass
    public static void init() {
        emf = Persistence.createEntityManagerFactory("jpaPU");
    }

    @Test
    public void test() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        ProdutoComposto produtoComposto = new ProdutoComposto();
        produtoComposto.setNome("Grupo 001");
        em.persist(produtoComposto);

        ProdutoSimples produto = new ProdutoSimples();
        produto.setNome("Mesa Urucubaca");
        produto.setDescricao("Mesa em madeira maciça com pés em aço");
        produto.setProdutoComposto(produtoComposto);
        em.persist(produto);

        Pedido pedido = new Pedido();
        pedido.getProdutos().add(produtoComposto);
        em.persist(pedido);
        em.getTransaction().commit();
    }
}
