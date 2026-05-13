package dao;

import java.util.List;
import model.Operation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import util.HibernateUtil;

public class OperationDAO {

    // Ajouter opération
    public void ajouterOperation(Operation operation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(operation);
            tx.commit();
            System.out.println("Opération ajoutée avec succès !");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Erreur ajout opération : " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // Liste des opérations
    public List<Operation> listeOperations() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Operation> liste = null;

        try {
            Query query = session.createQuery("from Operation");
            liste = query.list();
        } catch (Exception e) {
            System.out.println("Erreur liste opérations : " + e.getMessage());
        } finally {
            session.close();
        }

        return liste;
    }

    // Recherche
    public Operation rechercherOperation(int idOperation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Operation operation = null;

        try {
            operation = (Operation) session.get(Operation.class, idOperation);
        } catch (Exception e) {
            System.out.println("Erreur recherche opération : " + e.getMessage());
        } finally {
            session.close();
        }

        return operation;
    }

    // Supprimer
    public void supprimerOperation(int idOperation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Operation operation =
                    (Operation) session.get(Operation.class, idOperation);

            if (operation != null) {
                session.delete(operation);
                tx.commit();
                System.out.println("Opération supprimée !");
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Erreur suppression opération : " + e.getMessage());
        } finally {
            session.close();
        }
    }
}