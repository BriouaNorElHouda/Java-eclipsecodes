package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;

import model.Address;
import model.Client;

public class mainn{
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Transaction transaction = session.beginTransaction();

            Address address = new Address(1, "123 Rue de l'Exemple", "Ville-Exemple", "12345", "Pays-Exemple", 0.0, 0.0);
            Client client = new Client(11, "firstname", "lastname", "email@g.com", "password", "05504", "ppp.jpeg");

            session.persist(address);
            session.persist(client);

            transaction.commit();

            // Query after the transaction is committed
            Query q = session.createQuery("FROM Client");
            List<Client> result = (List<Client>) q.list();

            for (Client c : result) {
                System.out.println( "Email: " + c.getEmail());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
