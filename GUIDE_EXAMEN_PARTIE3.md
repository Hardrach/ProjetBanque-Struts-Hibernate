# 📘 GUIDE EXAMEN — PARTIE 3
# JSP + Pièges d'examen + Questions du professeur

---

## 🟢🔴 3.20 — index.jsp (Gestion Clients)

> 🟢 Le fichier existe déjà — 🔴 REMPLACER tout le contenu

```jsp
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Client" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Clients</title>
</head>
<body>

    <h1>Gestion des Clients</h1>

    <html:form action="/client.do">

        <table border="1" cellpadding="5">
            <tr>
                <td>Code Client :</td>
                <td><html:text property="codeClient"/></td>
            </tr>
            <tr>
                <td>Nom Client :</td>
                <td><html:text property="nomClient"/></td>
            </tr>
            <tr>
                <td>Adresse Client :</td>
                <td><html:text property="adresseClient"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <html:submit property="action" value="Ajouter"/>
                    <html:submit property="action" value="modifier"/>
                    <html:submit property="action" value="supprimer"/>
                    <html:submit property="action" value="rechercher"/>
                    <html:submit property="action" value="liste"/>
                </td>
            </tr>
        </table>

    </html:form>

    <br>

    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <h3><%= message %></h3>
    <%
        }
    %>

    <br>

    <%
        Client clientTrouve = (Client) request.getAttribute("clientTrouve");
        if (clientTrouve != null) {
    %>
        <h2>Client Trouvé</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>Code</th><th>Nom</th><th>Adresse</th>
            </tr>
            <tr>
                <td><%= clientTrouve.getCodeClient() %></td>
                <td><%= clientTrouve.getNomClient() %></td>
                <td><%= clientTrouve.getAdresseClient() %></td>
            </tr>
        </table>
    <%
        }
    %>

    <br>

    <%
        List<Client> listeClients =
                (List<Client>) request.getAttribute("listeClients");
        if (listeClients != null && !listeClients.isEmpty()) {
    %>
        <h2>Liste des Clients</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>Code Client</th><th>Nom Client</th><th>Adresse Client</th>
            </tr>
            <% for (Client c : listeClients) { %>
            <tr>
                <td><%= c.getCodeClient() %></td>
                <td><%= c.getNomClient() %></td>
                <td><%= c.getAdresseClient() %></td>
            </tr>
            <% } %>
        </table>
    <%
        }
    %>

</body>
</html>
```

---

## 🔴 3.21 — compte.jsp (Gestion Comptes)

```jsp
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Compte" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Comptes</title>
</head>
<body>

    <h1>Gestion des Comptes Bancaires</h1>

    <html:form action="/compte.do">

        <table border="1" cellpadding="5">
            <tr>
                <td>Numéro Compte :</td>
                <td><html:text property="numCompte"/></td>
            </tr>
            <tr>
                <td>Type Compte :</td>
                <td><html:text property="typeCompte"/></td>
            </tr>
            <tr>
                <td>Solde :</td>
                <td><html:text property="solde"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <html:submit property="action" value="ajouter"/>
                    <html:submit property="action" value="modifier"/>
                    <html:submit property="action" value="supprimer"/>
                    <html:submit property="action" value="rechercher"/>
                    <html:submit property="action" value="liste"/>
                </td>
            </tr>
        </table>

    </html:form>

    <br>

    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <h3><%= message %></h3>
    <%
        }
    %>

    <br>

    <%
        Compte compteTrouve =
                (Compte) request.getAttribute("compteTrouve");
        if (compteTrouve != null) {
    %>
        <h2>Compte Trouvé</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>Numéro</th><th>Type</th><th>Solde</th>
            </tr>
            <tr>
                <td><%= compteTrouve.getNumCompte() %></td>
                <td><%= compteTrouve.getTypeCompte() %></td>
                <td><%= compteTrouve.getSolde() %></td>
            </tr>
        </table>
    <%
        }
    %>

    <br>

    <%
        List<Compte> listeComptes =
                (List<Compte>) request.getAttribute("listeComptes");
        if (listeComptes != null && !listeComptes.isEmpty()) {
    %>
        <h2>Liste des Comptes</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>Numéro</th><th>Type</th><th>Solde</th>
            </tr>
            <% for (Compte c : listeComptes) { %>
            <tr>
                <td><%= c.getNumCompte() %></td>
                <td><%= c.getTypeCompte() %></td>
                <td><%= c.getSolde() %></td>
            </tr>
            <% } %>
        </table>
    <%
        }
    %>

</body>
</html>
```

---

## 🔴 3.22 — operation.jsp (Gestion Opérations)

```jsp
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Operation" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Opérations</title>
</head>
<body>

    <h1>Gestion des Opérations Bancaires</h1>

    <html:form action="/operation.do">

        <table border="1" cellpadding="5">
            <tr>
                <td>ID Opération :</td>
                <td><html:text property="idOperation"/></td>
            </tr>
            <tr>
                <td>Type Opération :</td>
                <td><html:text property="typeOperation"/></td>
            </tr>
            <tr>
                <td>Montant :</td>
                <td><html:text property="montant"/></td>
            </tr>
            <tr>
                <td>Date (yyyy-MM-dd) :</td>
                <td><html:text property="dateOperation"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <html:submit property="action" value="ajouter"/>
                    <html:submit property="action" value="rechercher"/>
                    <html:submit property="action" value="supprimer"/>
                    <html:submit property="action" value="liste"/>
                </td>
            </tr>
        </table>

    </html:form>

    <br>

    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <h3><%= message %></h3>
    <%
        }
    %>

    <br>

    <%
        Operation op =
                (Operation) request.getAttribute("operationTrouvee");
        if (op != null) {
    %>
        <h2>Opération Trouvée</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th><th>Type</th><th>Montant</th><th>Date</th>
            </tr>
            <tr>
                <td><%= op.getIdOperation() %></td>
                <td><%= op.getTypeOperation() %></td>
                <td><%= op.getMontant() %></td>
                <td><%= op.getDateOperation() %></td>
            </tr>
        </table>
    <%
        }
    %>

    <br>

    <%
        List<Operation> listeOperations =
                (List<Operation>) request.getAttribute("listeOperations");
        if (listeOperations != null && !listeOperations.isEmpty()) {
    %>
        <h2>Liste des Opérations</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th><th>Type</th><th>Montant</th><th>Date</th>
            </tr>
            <% for (Operation o : listeOperations) { %>
            <tr>
                <td><%= o.getIdOperation() %></td>
                <td><%= o.getTypeOperation() %></td>
                <td><%= o.getMontant() %></td>
                <td><%= o.getDateOperation() %></td>
            </tr>
            <% } %>
        </table>
    <%
        }
    %>

</body>
</html>
```

> ⚠️ **IMPORTANT JSP** : Ne pas utiliser `placeholder` dans `<html:text>` — Struts 1 ne le supporte pas !

---

## 🔴 3.23 — banque_db.sql (Script Base de Données)

```sql
CREATE DATABASE IF NOT EXISTS banque_db;
USE banque_db;

CREATE TABLE client (
  codeClient varchar(20) NOT NULL,
  nomClient varchar(100) DEFAULT NULL,
  adresseClient varchar(200) DEFAULT NULL,
  PRIMARY KEY (codeClient)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE compte (
  numCompte int(11) NOT NULL,
  typeCompte varchar(255) DEFAULT NULL,
  solde double DEFAULT NULL,
  PRIMARY KEY (numCompte)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE operation (
  idOperation int(11) NOT NULL,
  typeOperation varchar(255) DEFAULT NULL,
  montant double DEFAULT NULL,
  dateOperation date DEFAULT NULL,
  PRIMARY KEY (idOperation)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

> Ou bien laisser Hibernate créer les tables automatiquement via `hbm2ddl.auto=update`.

---

# 🚨 4. PIÈGES CLASSIQUES D'EXAMEN

## Piège 1 — Port 8080 déjà utilisé

| Symptôme | Cause | Solution |
|---|---|---|
| Tomcat ne démarre pas | XAMPP Tomcat tourne aussi | Éteindre Tomcat dans XAMPP |

## Piège 2 — Erreur Tomcat Manager Login

| Symptôme | Cause | Solution |
|---|---|---|
| 403 Access Denied | Pas de user configuré | Éditer `tomcat-users.xml` (voir PARTIE 1) |

## Piège 3 — Table non créée dans MySQL

| Symptôme | Cause | Solution |
|---|---|---|
| Unknown table | Mapping absent | Vérifier `<mapping resource="..."/>` dans `hibernate.cfg.xml` |
| | `hbm2ddl.auto` absent | Ajouter `<property name="hibernate.hbm2ddl.auto">update</property>` |

## Piège 4 — ClassNotFoundException pour le driver MySQL

| Symptôme | Cause | Solution |
|---|---|---|
| `com.mysql.jdbc.Driver` not found | JAR absent | Ajouter `mysql-connector-java-5.x.jar` dans Libraries |

## Piège 5 — Java 17 incompatible

| Symptôme | Cause | Solution |
|---|---|---|
| Erreurs compilation bizarres | Mauvaise version Java | Vérifier `java -version` → doit être 1.8 |
| NetBeans ne démarre pas | Java trop récent | Configurer JAVA_HOME vers JDK 8 |

## Piège 6 — Erreur 404 sur les .do

| Symptôme | Cause | Solution |
|---|---|---|
| Page introuvable `/client.do` | `web.xml` mal configuré | Vérifier `<url-pattern>*.do</url-pattern>` |
| | struts-config manquant | Vérifier `<param-value>/WEB-INF/struts-config.xml</param-value>` |

## Piège 7 — NullPointerException dans Action

| Symptôme | Cause | Solution |
|---|---|---|
| NPE sur `action` | Le form-bean n'est pas lié | Vérifier `name="clientForm"` dans struts-config.xml |

## Piège 8 — Erreur "No getter method for property"

| Symptôme | Cause | Solution |
|---|---|---|
| JSP ne compile pas | Le nom de propriété dans JSP ≠ nom dans Form | Vérifier que `property="codeClient"` correspond au getter `getCodeClient()` |

## Piège 9 — Hibernate ne se connecte pas

| Symptôme | Cause | Solution |
|---|---|---|
| Connection refused | MySQL éteint | Démarrer MySQL dans XAMPP |
| | Mauvais port | Vérifier `jdbc:mysql://localhost:3306/banque_db` |
| | Mauvais password | XAMPP : root sans password par défaut |

## Piège 10 — Le `placeholder` HTML ne marche pas

| Symptôme | Cause | Solution |
|---|---|---|
| Erreur 500 "invalid attribute for tag [text]" | Struts 1 ne supporte pas `placeholder` | Ne PAS mettre `placeholder` dans `<html:text>` |

---

# 🎓 5. QUESTIONS PROBABLES DU PROFESSEUR

---

### Q1 : Quelle est la différence entre Action, ActionForm et DAO ?

| Composant | Rôle |
|---|---|
| **ActionForm** | Transporte les données du formulaire JSP vers l'Action. C'est un JavaBean avec getters/setters. |
| **Action** | Contrôleur. Reçoit le formulaire, appelle le DAO, met les résultats dans la request, redirige. |
| **DAO** | Accès aux données. Contient les opérations CRUD avec Hibernate (save, update, delete, get). |

**Flux** : `JSP → ActionForm → Action → DAO → Base de données → Action → JSP`

---

### Q2 : À quoi sert HibernateUtil ?

> C'est une **classe utilitaire Singleton** qui crée la `SessionFactory` une seule fois au démarrage de l'application. La SessionFactory est lourde à créer, donc on la crée une seule fois et on la réutilise partout via `HibernateUtil.getSessionFactory()`.

---

### Q3 : À quoi sert hibernate.cfg.xml ?

> C'est le fichier de **configuration principal** de Hibernate. Il contient :
> - Les informations de connexion à la base (driver, URL, user, password)
> - Le dialecte SQL (MySQLDialect)
> - Le mode de création des tables (hbm2ddl.auto)
> - La liste des fichiers de mapping (.hbm.xml)

---

### Q4 : À quoi sert web.xml ?

> C'est le **descripteur de déploiement** de l'application web. Il :
> - Déclare la servlet Struts (`ActionServlet`)
> - Configure le mapping des URL `*.do` vers la servlet
> - Indique le fichier de configuration Struts
> - Définit la page d'accueil

---

### Q5 : À quoi sert struts-config.xml ?

> C'est le **cœur de la configuration Struts**. Il contient :
> - `<form-beans>` : déclare les formulaires (lien nom ↔ classe Java)
> - `<action-mappings>` : déclare les actions (lien URL ↔ classe Action ↔ formulaire ↔ page de redirection)

---

### Q6 : Pourquoi SessionFactory et pas Session directement ?

> La `SessionFactory` est un objet **thread-safe** et **coûteux** à créer (lecture de tous les mappings). On la crée une seule fois. La `Session` est **légère** et **non thread-safe**, on en crée une par opération et on la ferme après.

---

### Q7 : Pourquoi utiliser Transaction ?

> La `Transaction` garantit l'**intégrité des données**. Si une erreur survient pendant une opération (save, update, delete), on peut faire un `rollback()` pour annuler. Sans transaction, les données pourraient être dans un état incohérent.

---

### Q8 : Pourquoi le mapping XML (.hbm.xml) ?

> Le fichier `.hbm.xml` fait la **correspondance entre la classe Java et la table MySQL**. Il dit à Hibernate :
> - Quelle classe correspond à quelle table
> - Quel attribut correspond à quelle colonne
> - Quel est l'identifiant (clé primaire)
> - Comment l'identifiant est généré (`assigned` = l'utilisateur le fournit)

---

### Q9 : Que signifie `hbm2ddl.auto=update` ?

> Hibernate **vérifie** les tables au démarrage et les **crée ou met à jour** automatiquement si elles n'existent pas ou si la structure a changé. Très pratique en développement. En production, on utilise `validate` ou `none`.

---

### Q10 : Quel est le flux complet d'une requête ?

```
1. L'utilisateur clique sur "Ajouter" dans le JSP
2. Le formulaire envoie une requête POST à /client.do
3. web.xml intercepte *.do et envoie à ActionServlet
4. ActionServlet lit struts-config.xml
5. Il crée/remplit le ClientForm avec les données du formulaire
6. Il appelle ClientAction.execute()
7. ClientAction récupère les données du form
8. ClientAction appelle ClientDAO.ajouterClient()
9. Le DAO ouvre une Session Hibernate
10. Hibernate exécute INSERT INTO client ...
11. Le DAO ferme la session
12. L'Action met un message dans la request
13. L'Action retourne mapping.findForward("success")
14. Struts redirige vers index.jsp
15. Le JSP affiche le message
```

---

# ✅ 6. CHECKLIST FINALE AVANT L'EXAMEN

- [ ] XAMPP : Apache ON, MySQL ON, Tomcat OFF
- [ ] Base `banque_db` créée dans phpMyAdmin
- [ ] NetBeans 8.2 avec Java 8
- [ ] Tomcat ajouté dans NetBeans
- [ ] Librairies : Struts 1.3 + Hibernate 4.3 + mysql-connector
- [ ] 5 packages créés : model, form, dao, action, util
- [ ] hibernate.cfg.xml dans Source Packages
- [ ] struts-config.xml dans WEB-INF
- [ ] web.xml modifié avec ActionServlet
- [ ] Tous les fichiers .java et .hbm.xml créés
- [ ] 3 fichiers JSP fonctionnels
- [ ] Test : Ajouter un client → OK
- [ ] Test : Lister les clients → OK
- [ ] Test : Rechercher un client → OK
- [ ] Test : Modifier un client → OK
- [ ] Test : Supprimer un client → OK

---

# 📋 RÉSUMÉ : AUTO vs MANUEL

| Fichier | Auto/Manuel | Action |
|---|---|---|
| Structure projet | 🟢 Auto | NetBeans crée |
| web.xml | 🟢 Auto puis 🔴 Manuel | Existe mais à MODIFIER |
| index.jsp | 🟢 Auto puis 🔴 Manuel | Existe mais à RÉÉCRIRE |
| hibernate.cfg.xml | 🔴 Manuel | Créer dans Source Packages |
| struts-config.xml | 🔴 Manuel | Créer dans WEB-INF |
| Client.java | 🔴 Manuel | Créer dans model |
| Client.hbm.xml | 🔴 Manuel | Créer dans model |
| ClientForm.java | 🔴 Manuel | Créer dans form |
| ClientDAO.java | 🔴 Manuel | Créer dans dao |
| ClientAction.java | 🔴 Manuel | Créer dans action |
| HibernateUtil.java | 🔴 Manuel | Créer dans util |
| compte.jsp | 🔴 Manuel | Créer dans Web Pages |
| operation.jsp | 🔴 Manuel | Créer dans Web Pages |
| Tous les Compte*.* | 🔴 Manuel | Même pattern que Client |
| Tous les Operation*.* | 🔴 Manuel | Même pattern que Client |

---

**🏆 Bonne chance pour l'examen ! Tu as tous les outils pour réussir.**
