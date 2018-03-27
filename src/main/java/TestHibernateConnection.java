import com.antonfifindik.discographies.models.*;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;
import java.util.List;


/**
 * Created by Антон on 26.03.2018.
 */
public class TestHibernateConnection {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        List<Songs> songsList = null;
        List<Albums> albumsList = null;
        List<Authors> authorsList = null;
        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }

            session.beginTransaction();

    //        songsList = session.createQuery("FROM Songs").list();
           albumsList = session.createQuery("FROM Albums").list();
           authorsList = session.createQuery("FROM Authors").list();
            session.getTransaction().commit();

        } finally {
            session.close();
            ourSessionFactory.close();
        }

//        for(Songs song : songsList)
//            System.out.println(song);

        for(Albums album : albumsList) {
            System.out.println(album);
            for(Producers producer : album.getProducers())
                System.out.println("Продюсер: " + producer.getFirstName() + " " + producer.getLastName());
            for(Genres genre : album.getGenres())
                System.out.println(genre);
            for(Songs song : album.getSongs())
                System.out.println(song);
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for(Authors author : authorsList)
            for(Musicians musician : author.getMusicians())
                System.out.println(musician);

    }
}