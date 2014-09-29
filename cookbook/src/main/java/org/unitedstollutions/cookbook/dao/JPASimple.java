package org.unitedstollutions.cookbook.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by ruben on 05/08/14.
 */
public class JPASimple {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        System.out.println("JPASimple.main()");

        EntityManagerFactory entityMgrFactory = null;
        EntityManager entityManager = null;
        try {
            entityMgrFactory = Persistence.createEntityManagerFactory("jpademo");
            entityManager = entityMgrFactory.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            // Create an entity in the database.
            PersonOld np = new PersonOld("Tom", "Boots");
            System.out.println(np);
            entityManager.persist(np);
            transaction.commit();

            int id = np.getId();
            System.out.println("Created Person with Id " + id);

            transaction = entityManager.getTransaction();
            transaction.begin();

            javax.persistence.Query query = entityManager.createQuery("select p from PersonOld p order by p.lastName");

            List<PersonOld> list = query.getResultList();
            System.out.println("There are " + list.size() + " persons:");
            list.forEach(p ->
                            System.out.println(
                                    p.getFirstName() + ' ' + p.getLastName())
            );
        } finally {
            if (entityManager != null)

                entityManager.close();
            if (entityMgrFactory != null)
                entityMgrFactory.close();
        }
    }
}

