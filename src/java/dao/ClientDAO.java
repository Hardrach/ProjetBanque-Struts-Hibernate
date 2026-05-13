package dao;

import java.util.List;
import model.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import util.HibernateUtil;

public class ClientDAO {

    // Ajouter un client
    public void ajouterClient(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(client);
            tx.commit();
            System.out.println("Client ajouté avec succès !");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Erreur ajout client : " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // Modifier un client
    public void modifierClient(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(client);
            tx.commit();
            System.out.println("Client modifié avec succès !");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Erreur modification client : " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // Supprimer un client
    public void supprimerClient(String codeClient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Client client = (Client) session.get(Client.class, codeClient);

            if (client != null) {
                session.delete(client);
                System.out.println("Client supprimé avec succès !");
            } else {
                System.out.println("Client introuvable !");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Erreur suppression client : " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // Rechercher un client
    public Client chercherClient(String codeClient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Client client = null;

        try {
            client = (Client) session.get(Client.class, codeClient);
        } catch (Exception e) {
            System.out.println("Erreur recherche client : " + e.getMessage());
        } finally {
            session.close();
        }

        return client;
    }

    // Lister tous les clients
    public List<Client> listeClients() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Client> liste = null;

        try {
            Query query = session.createQuery("from Client");
            liste = query.list();
        } catch (Exception e) {
            System.out.println("Erreur liste clients : " + e.getMessage());
        } finally {
            session.close();
        }

        return liste;
    }
}