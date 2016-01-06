package jpa.javacodegeeks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by tk3sy on 11.11.2015.
 * http://www.javacodegeeks.com/2015/02/jpa-tutorial.html
 */
public class Main {

  private static final Logger LOGGER = Logger.getLogger("JPA");

  public static void main(String[] args) {
    Main main = new Main();
    main.run();
  }

  public void run() {
    EntityManagerFactory factory = null;
    EntityManager entityManager = null;
    try {
      factory = Persistence.createEntityManagerFactory("PersistenceUnit");
      entityManager = factory.createEntityManager();
      persistPerson(entityManager);
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, e.getMessage(), e);
      e.printStackTrace();
    } finally {
      if (entityManager != null) {
        entityManager.close();
      }
      if (factory != null) {
        factory.close();
      }
    }
  }

  private void persistPerson(EntityManager entityManager) {
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin();
      Person person = new Person();
      person.setFirstName("Homer");
      person.setLastName("Simpson");
      entityManager.persist(person);
      transaction.commit();
    } catch (Exception e) {
      if (transaction.isActive()) {
        transaction.rollback();
      }
    }
  }
}
