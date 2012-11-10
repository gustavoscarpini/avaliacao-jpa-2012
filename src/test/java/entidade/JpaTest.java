package entidade;

import com.mysema.query.jpa.impl.JPAQuery;
import java.util.List;
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
    }
}
