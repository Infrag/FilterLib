package org.filter.task.filterlib;

import java.sql.DriverManager;
import java.sql.SQLNonTransientConnectionException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class PersistenceTest extends TestCase {

    private static final Logger log = LoggerFactory.getLogger(PersistenceTest.class);
    private EntityManagerFactory emFactory;
    private EntityManager em;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PersistenceTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        try {
            log.info("Starting in-memory database for unit tests");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            DriverManager.getConnection("jdbc:derby:memory:unit-testing-jpa;create=true").close();
        } catch (Exception ex) {
            log.error("Error preparing in-memory DB for test.", ex);
            fail("Exception during database startup.");
        }
        try {
            log.info("Building JPA EntityManager for unit tests");
            emFactory = Persistence.createEntityManagerFactory("testPU");
            em = emFactory.createEntityManager();
        } catch (Exception ex) {
            log.error("Error Building JPA EntityManager for unit tests.", ex);
            fail("Exception during JPA EntityManager instanciation.");
        }
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        log.info("Shuting down Hibernate JPA layer.");
        if (em != null) {
            em.close();
        }
        if (emFactory != null) {
            emFactory.close();
        }
        log.info("Stopping in-memory database.");
        try {
            DriverManager.getConnection("jdbc:derby:memory:unit-testing-jpa;shutdown=true").close();
        } catch (SQLNonTransientConnectionException ex) {
            if (ex.getErrorCode() != 45000) {
                throw ex;
            }
            // Shutdown success
        }
//        VFMemoryStorageFactory.purgeDatabase(new File("unit-testing-jpa").getCanonicalPath());
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(PersistenceTest.class);
    }

    public void testPersistence() {
        try {
            log.info("Startingfirst basic test");
            em.getTransaction().begin();

            TestEntity u = new TestEntity();
            u.setStringColumn("some test string");

            em.persist(u);
            assertTrue(em.contains(u));
            em.remove(u);
            assertFalse(em.contains(u));

            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
            fail("Exception during testPersistence");
        }
    }
}
