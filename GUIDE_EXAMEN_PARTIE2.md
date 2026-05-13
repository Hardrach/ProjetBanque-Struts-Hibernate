# 📘 GUIDE EXAMEN — PARTIE 2
# DAO + Action + Configuration + JSP + Pièges + Questions

---

## 🔴 3.11 — dao/ClientDAO.java

```java
package dao;

import java.util.List;
import model.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import util.HibernateUtil;

public class ClientDAO {

    public void ajouterClient(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(client);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }

    public void modifierClient(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(client);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }

    public void supprimerClient(String codeClient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Client client = (Client) session.get(Client.class, codeClient);
            if (client != null) {
                session.delete(client);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }

    public Client chercherClient(String codeClient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Client client = null;
        try {
            client = (Client) session.get(Client.class, codeClient);
        } catch (Exception e) {
            System.out.println("Erreur recherche : " + e.getMessage());
        } finally {
            session.close();
        }
        return client;
    }

    public List<Client> listeClients() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Client> liste = null;
        try {
            Query query = session.createQuery("from Client");
            liste = query.list();
        } catch (Exception e) {
            System.out.println("Erreur liste : " + e.getMessage());
        } finally {
            session.close();
        }
        return liste;
    }
}
```

---

## 🔴 3.12 — dao/CompteDAO.java

```java
package dao;

import java.util.List;
import model.Compte;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import util.HibernateUtil;

public class CompteDAO {

    public void ajouterCompte(Compte compte) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(compte);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }

    public void modifierCompte(Compte compte) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(compte);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }

    public void supprimerCompte(int numCompte) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Compte compte = (Compte) session.get(Compte.class, numCompte);
            if (compte != null) {
                session.delete(compte);
                tx.commit();
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }

    public Compte rechercherCompte(int numCompte) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Compte compte = null;
        try {
            compte = (Compte) session.get(Compte.class, numCompte);
        } catch (Exception e) {
            System.out.println("Erreur recherche : " + e.getMessage());
        } finally {
            session.close();
        }
        return compte;
    }

    public List<Compte> listeComptes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Compte> liste = null;
        try {
            Query query = session.createQuery("from Compte");
            liste = query.list();
        } catch (Exception e) {
            System.out.println("Erreur liste : " + e.getMessage());
        } finally {
            session.close();
        }
        return liste;
    }
}
```

---

## 🔴 3.13 — dao/OperationDAO.java

```java
package dao;

import java.util.List;
import model.Operation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import util.HibernateUtil;

public class OperationDAO {

    public void ajouterOperation(Operation operation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(operation);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }

    public List<Operation> listeOperations() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Operation> liste = null;
        try {
            Query query = session.createQuery("from Operation");
            liste = query.list();
        } catch (Exception e) {
            System.out.println("Erreur liste : " + e.getMessage());
        } finally {
            session.close();
        }
        return liste;
    }

    public Operation rechercherOperation(int idOperation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Operation operation = null;
        try {
            operation = (Operation) session.get(Operation.class, idOperation);
        } catch (Exception e) {
            System.out.println("Erreur recherche : " + e.getMessage());
        } finally {
            session.close();
        }
        return operation;
    }

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
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }
}
```

> **PATTERN DAO À RETENIR** : Toujours `openSession()` → `beginTransaction()` → opération → `commit()` → `close()` avec `try/catch/finally` et `rollback()` en cas d'erreur.

---

## 🔴 3.14 — action/ClientAction.java

```java
package action;

import dao.ClientDAO;
import form.ClientForm;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Client;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ClientAction extends Action {

    @Override
    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ClientForm clientForm = (ClientForm) form;

        String codeClient = clientForm.getCodeClient();
        String nomClient = clientForm.getNomClient();
        String adresseClient = clientForm.getAdresseClient();

        String action = request.getParameter("action");

        ClientDAO dao = new ClientDAO();

        if ("supprimer".equals(action)) {
            dao.supprimerClient(codeClient);
            request.setAttribute("message", "Client supprimé avec succès !");
        }
        else if ("modifier".equals(action)) {
            Client client = new Client(codeClient, nomClient, adresseClient);
            dao.modifierClient(client);
            request.setAttribute("message", "Client modifié avec succès !");
        }
        else if ("rechercher".equals(action)) {
            Client client = dao.chercherClient(codeClient);
            if (client != null) {
                request.setAttribute("clientTrouve", client);
                request.setAttribute("message", "Client trouvé !");
            } else {
                request.setAttribute("message", "Client introuvable !");
            }
        }
        else if ("liste".equals(action)) {
            List<Client> listeClients = dao.listeClients();
            request.setAttribute("listeClients", listeClients);
            request.setAttribute("message", "Liste des clients affichée !");
        }
        else {
            Client client = new Client(codeClient, nomClient, adresseClient);
            dao.ajouterClient(client);
            request.setAttribute("message", "Client ajouté avec succès !");
        }

        return mapping.findForward("success");
    }
}
```

---

## 🔴 3.15 — action/CompteAction.java

```java
package action;

import dao.CompteDAO;
import form.CompteForm;
import model.Compte;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CompteAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        CompteForm compteForm = (CompteForm) form;
        CompteDAO dao = new CompteDAO();

        int numCompte = compteForm.getNumCompte();
        String typeCompte = compteForm.getTypeCompte();
        double solde = compteForm.getSolde();
        String action = compteForm.getAction();

        Compte compte = new Compte(numCompte, typeCompte, solde);

        if (action.equals("ajouter")) {
            dao.ajouterCompte(compte);
            request.setAttribute("message", "Compte ajouté avec succès !");
        }
        else if (action.equals("modifier")) {
            dao.modifierCompte(compte);
            request.setAttribute("message", "Compte modifié avec succès !");
        }
        else if (action.equals("supprimer")) {
            dao.supprimerCompte(numCompte);
            request.setAttribute("message", "Compte supprimé avec succès !");
        }
        else if (action.equals("rechercher")) {
            Compte c = dao.rechercherCompte(numCompte);
            if (c != null) {
                request.setAttribute("compteTrouve", c);
                request.setAttribute("message", "Compte trouvé !");
            } else {
                request.setAttribute("message", "Compte introuvable !");
            }
        }
        else if (action.equals("liste")) {
            List<Compte> liste = dao.listeComptes();
            request.setAttribute("listeComptes", liste);
            request.setAttribute("message", "Liste des comptes affichée !");
        }

        return mapping.findForward("success");
    }
}
```

---

## 🔴 3.16 — action/OperationAction.java

```java
package action;

import dao.OperationDAO;
import form.OperationForm;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Operation;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class OperationAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        OperationForm operationForm = (OperationForm) form;
        OperationDAO dao = new OperationDAO();

        int idOperation = operationForm.getIdOperation();
        String typeOperation = operationForm.getTypeOperation();
        double montant = operationForm.getMontant();
        String dateStr = operationForm.getDateOperation();
        String action = operationForm.getAction();

        Date dateOperation = null;

        if (dateStr != null && !dateStr.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dateOperation = sdf.parse(dateStr);
        }

        if ("ajouter".equals(action)) {
            Operation operation = new Operation(
                    idOperation, typeOperation, montant, dateOperation);
            dao.ajouterOperation(operation);
            request.setAttribute("message", "Opération ajoutée avec succès !");
        }
        else if ("rechercher".equals(action)) {
            Operation op = dao.rechercherOperation(idOperation);
            if (op != null) {
                request.setAttribute("operationTrouvee", op);
                request.setAttribute("message", "Opération trouvée !");
            } else {
                request.setAttribute("message", "Opération introuvable !");
            }
        }
        else if ("supprimer".equals(action)) {
            dao.supprimerOperation(idOperation);
            request.setAttribute("message", "Opération supprimée avec succès !");
        }
        else if ("liste".equals(action)) {
            List<Operation> liste = dao.listeOperations();
            request.setAttribute("listeOperations", liste);
            request.setAttribute("message", "Liste des opérations affichée !");
        }

        return mapping.findForward("success");
    }
}
```

---

## 🔴 3.17 — hibernate.cfg.xml (dans Source Packages)

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE hibernate-configuration PUBLIC
"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

    <session-factory>

        <!-- Connexion MySQL -->

        <property name="hibernate.connection.driver_class">
            com.mysql.jdbc.Driver
        </property>

        <property name="hibernate.connection.url">
            jdbc:mysql://localhost:3306/banque_db
        </property>

        <property name="hibernate.connection.username">
            root
        </property>

        <property name="hibernate.connection.password">
        </property>

        <!-- Dialect Hibernate -->

        <property name="hibernate.dialect">
            org.hibernate.dialect.MySQLDialect
        </property>

        <!-- Affichage SQL -->

        <property name="hibernate.show_sql">
            true
        </property>

        <property name="hibernate.format_sql">
            true
        </property>

        <!-- Création automatique des tables -->

        <property name="hibernate.hbm2ddl.auto">
            update
        </property>

        <!-- Mapping Client -->
        <mapping resource="model/Client.hbm.xml"/>

        <!-- Mapping Compte -->
        <mapping resource="model/Compte.hbm.xml"/>

        <!-- Mapping Operation -->
        <mapping resource="model/Operation.hbm.xml"/>

    </session-factory>

</hibernate-configuration>
```

> ⚠️ **CRITIQUE** : Chaque entité DOIT avoir sa ligne `<mapping>` ici. Oubli = table non créée.

---

## 🔴 3.18 — WEB-INF/struts-config.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE struts-config PUBLIC
"-//Apache Software Foundation//DTD Struts Configuration 1.3//EN"
"http://struts.apache.org/dtds/struts-config_1_3.dtd">

<struts-config>

    <!-- FORM BEANS -->

    <form-beans>

        <form-bean
            name="clientForm"
            type="form.ClientForm"/>

        <form-bean
            name="compteForm"
            type="form.CompteForm"/>

        <form-bean
            name="operationForm"
            type="form.OperationForm"/>

    </form-beans>

    <!-- ACTION MAPPINGS -->

    <action-mappings>

        <!-- CLIENT -->
        <action
            path="/client"
            type="action.ClientAction"
            name="clientForm"
            scope="request"
            validate="false"
            input="/index.jsp">

            <forward
                name="success"
                path="/index.jsp"/>

        </action>

        <!-- COMPTE -->
        <action
            path="/compte"
            type="action.CompteAction"
            name="compteForm"
            scope="request"
            validate="false"
            input="/compte.jsp">

            <forward
                name="success"
                path="/compte.jsp"/>

        </action>

        <!-- OPERATION -->
        <action
            path="/operation"
            type="action.OperationAction"
            name="operationForm"
            scope="request"
            validate="false"
            input="/operation.jsp">

            <forward
                name="success"
                path="/operation.jsp"/>

        </action>

    </action-mappings>

</struts-config>
```

> ⚠️ Le `path` correspond à l'URL appelée par le JSP.
> Ex: `action="/client.do"` dans le JSP → `path="/client"` dans struts-config.

---

## 🟢🔴 3.19 — WEB-INF/web.xml (existe déjà, à MODIFIER)

```xml
<?xml version="1.0" encoding="UTF-8"?>

<web-app xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
         http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         version="2.5">

    <display-name>ProjetBanque</display-name>

    <!-- Servlet Struts -->

    <servlet>
        <servlet-name>action</servlet-name>

        <servlet-class>
            org.apache.struts.action.ActionServlet
        </servlet-class>

        <init-param>
            <param-name>config</param-name>
            <param-value>
                /WEB-INF/struts-config.xml
            </param-value>
        </init-param>

        <load-on-startup>2</load-on-startup>
    </servlet>

    <!-- Mapping -->

    <servlet-mapping>
        <servlet-name>action</servlet-name>
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>

    <!-- Page accueil -->

    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>

</web-app>
```

> ⚠️ Le `url-pattern` `*.do` est OBLIGATOIRE. C'est ce qui fait que les URL `/client.do` sont interceptées par Struts.

---

**➡️ Suite dans GUIDE_EXAMEN_PARTIE3.md (JSP + Pièges + Questions)**
