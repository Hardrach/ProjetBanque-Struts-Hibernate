package dao;

import java.util.List;
import model.Compte;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import util.HibernateUtil;

public class CompteDAO {

    // Ajouter
    public void ajouterCompte(Compte compte) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(compte);
            tx.commit();
            System.out.println("Compte ajouté avec succès !");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Erreur ajout compte : " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // Modifier
    public void modifierCompte(Compte compte) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(compte);
            tx.commit();
            System.out.println("Compte modifié avec succès !");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Erreur modification compte : " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // Supprimer
    public void supprimerCompte(int numCompte) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Compte compte = (Compte) session.get(Compte.class, numCompte);

            if (compte != null) {
                session.delete(compte);
                tx.commit();
                System.out.println("Compte supprimé !");
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Erreur suppression compte : " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // Rechercher
    public Compte rechercherCompte(int numCompte) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Compte compte = null;

        try {
            compte = (Compte) session.get(Compte.class, numCompte);
        } catch (Exception e) {
            System.out.println("Erreur recherche compte : " + e.getMessage());
        } finally {
            session.close();
        }

        return compte;
    }

    // Liste
    public List<Compte> listeComptes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Compte> liste = null;

        try {
            Query query = session.createQuery("from Compte");
            liste = query.list();
        } catch (Exception e) {
            System.out.println("Erreur liste comptes : " + e.getMessage());
        } finally {
            session.close();
        }

        return liste;
    }
}