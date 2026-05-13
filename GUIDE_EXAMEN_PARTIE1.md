# 📘 GUIDE COMPLET — EXAMEN PRATIQUE JAVA WEB
# Projet Banque : Struts 1 + Hibernate 4 + MySQL
### ⚠️ Document de révision — À imprimer avant l'examen

---

# TABLE DES MATIÈRES

1. Environnement requis
2. Création du projet pas à pas
3. Tous les fichiers avec code complet
4. Pièges classiques d'examen (voir PARTIE 2)
5. Questions probables du professeur (voir PARTIE 2)

---

# ⚙️ 1. ENVIRONNEMENT REQUIS

| Élément | Version exacte |
|---|---|
| Java | JDK 8 (1.8) |
| IDE | NetBeans 8.2 |
| Framework Web | Struts 1.3 |
| ORM | Hibernate 4.3.11.Final |
| Base de données | MySQL (XAMPP) |
| Serveur | Apache Tomcat 8.x / 9.x |

> ⛔ **NE PAS utiliser** : Java 17, Struts 2, Spring Boot, Jakarta EE

---

# 🔨 2. CRÉATION DU PROJET PAS À PAS

## ÉTAPE 1 — Préparer l'environnement

### 1.1 Démarrer XAMPP
- Ouvrir XAMPP Control Panel
- Cliquer **Start** sur **Apache** ✅
- Cliquer **Start** sur **MySQL** ✅
- ⚠️ **NE PAS démarrer Tomcat dans XAMPP** (conflit port 8080)

### 1.2 Créer la base de données
- Ouvrir `http://localhost/phpmyadmin`
- Cliquer **Nouvelle base de données**
- Nom : `banque_db`
- Interclassement : `utf8mb4_general_ci`
- Cliquer **Créer**
- OU importer le fichier `banque_db.sql`

### 1.3 Vérifier Java 8
```
java -version → doit afficher 1.8.x
```
Si Java 17 s'affiche → modifier JAVA_HOME vers le dossier JDK 8.

---

## ÉTAPE 2 — Créer le projet dans NetBeans

> 🟢 **AUTOMATIQUE** = NetBeans le fait pour vous
> 🔴 **MANUEL** = Vous devez écrire/faire vous-même

### 2.1 Nouveau projet
1. Menu : `File` → `New Project`
2. Catégorie : **Java Web**
3. Type : **Web Application**
4. Cliquer **Next**

### 2.2 Nom et emplacement
1. Nom du projet : `ProjetBanque`
2. Cliquer **Next**

### 2.3 Serveur
1. Server : **Apache Tomcat**
2. Java EE Version : **Java EE 6 Web**
3. Cliquer **Next**

### 2.4 Frameworks
1. **Ne rien cocher** (on ajoute Struts manuellement)
2. Cliquer **Finish**

> 🟢 **AUTOMATIQUE** : NetBeans crée `web.xml`, `index.jsp`, `META-INF/context.xml`, la structure de dossiers.

---

## ÉTAPE 3 — Ajouter Tomcat (si pas déjà fait)

1. Onglet **Services** → **Servers**
2. Clic droit → **Add Server**
3. Choisir **Apache Tomcat**
4. Indiquer le chemin du dossier Tomcat
5. Username : `admin` / Password : `admin123`

### Correction Tomcat Manager (si erreur login) :
🔴 **MANUEL** — Éditer `conf/tomcat-users.xml` dans le dossier Tomcat :
```xml
<role rolename="manager-gui"/>
<role rolename="manager-script"/>
<user username="admin" password="admin123" roles="manager-gui,manager-script"/>
```

---

## ÉTAPE 4 — Ajouter les librairies

### 4.1 Struts 1.3
🔴 **MANUEL** :
1. Clic droit sur **Libraries** → **Add JAR/Folder**
2. Ajouter ces fichiers .jar :
   - `struts-core-1.3.x.jar`
   - `struts-taglib-1.3.x.jar`
   - `struts-extras-1.3.x.jar`
   - `commons-beanutils-1.x.jar`
   - `commons-digester-x.jar`
   - `commons-logging-1.x.jar`
   - `commons-validator-1.x.jar`
   - `commons-collections-3.x.jar`

### 4.2 Hibernate 4.3.11
🔴 **MANUEL** :
1. Clic droit sur **Libraries** → **Add JAR/Folder**
2. Ajouter :
   - `hibernate-core-4.3.11.Final.jar`
   - `hibernate-commons-annotations-x.jar`
   - `hibernate-entitymanager-4.3.11.Final.jar`
   - `hibernate-jpa-2.1-api-x.jar`
   - `jboss-logging-x.jar`
   - `jboss-transaction-api-x.jar`
   - `dom4j-x.jar`
   - `javassist-x.jar`
   - `antlr-x.jar`

### 4.3 MySQL Connector
🔴 **MANUEL** :
1. Clic droit sur **Libraries** → **Add JAR/Folder**
2. Ajouter : `mysql-connector-java-5.x.jar`

---

## ÉTAPE 5 — Créer les packages

🔴 **MANUEL** :
1. Clic droit sur **Source Packages** → `New` → `Java Package`
2. Créer ces 5 packages :

| Package | Rôle |
|---|---|
| `model` | Entités Hibernate (POJO) |
| `dao` | Accès base de données |
| `action` | Contrôleurs Struts |
| `form` | ActionForm Struts |
| `util` | HibernateUtil |

---

## ÉTAPE 6 — Créer les fichiers

### Comment créer chaque type :

| Type | Comment dans NetBeans |
|---|---|
| Java Class | Clic droit sur le package → `New` → `Java Class` |
| XML | Clic droit sur le package → `New` → `XML Document` |
| JSP | Clic droit sur `Web Pages` → `New` → `JSP` |

### Liste des fichiers à créer 🔴 MANUELLEMENT :

**Package `model`** :
- `Client.java` (New → Java Class)
- `Client.hbm.xml` (New → XML Document)
- `Compte.java` (New → Java Class)
- `Compte.hbm.xml` (New → XML Document)
- `Operation.java` (New → Java Class)
- `Operation.hbm.xml` (New → XML Document)

**Package `form`** :
- `ClientForm.java`
- `CompteForm.java`
- `OperationForm.java`

**Package `dao`** :
- `ClientDAO.java`
- `CompteDAO.java`
- `OperationDAO.java`

**Package `action`** :
- `ClientAction.java`
- `CompteAction.java`
- `OperationAction.java`

**Package `util`** :
- `HibernateUtil.java`

**Source Packages (racine)** :
- `hibernate.cfg.xml` (Clic droit sur Source Packages → New → XML)

**WEB-INF** :
- `struts-config.xml` (Clic droit sur WEB-INF → New → XML)
- `web.xml` (🟢 existe déjà, à MODIFIER)

**Web Pages** :
- `index.jsp` (🟢 existe déjà, à MODIFIER)
- `compte.jsp` (New → JSP)
- `operation.jsp` (New → JSP)

---

# 📝 3. TOUS LES FICHIERS — CODE COMPLET

> 🟢 = Fichier généré par NetBeans (à MODIFIER)
> 🔴 = Fichier à créer et écrire SOI-MÊME

---

## 🔴 3.1 — model/Client.java

```java
package model;

import java.io.Serializable;

public class Client implements Serializable {

    private String codeClient;
    private String nomClient;
    private String adresseClient;

    public Client() {
    }

    public Client(String codeClient, String nomClient, String adresseClient) {
        this.codeClient = codeClient;
        this.nomClient = nomClient;
        this.adresseClient = adresseClient;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }
}
```

---

## 🔴 3.2 — model/Client.hbm.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC
"-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">

<hibernate-mapping>
    <class name="model.Client" table="client">

        <id name="codeClient" column="codeClient" type="string">
            <generator class="assigned"/>
        </id>

        <property name="nomClient" column="nomClient" type="string"/>

        <property name="adresseClient" column="adresseClient" type="string"/>

    </class>
</hibernate-mapping>
```

---

## 🔴 3.3 — model/Compte.java

```java
package model;

import java.io.Serializable;

public class Compte implements Serializable {

    private int numCompte;
    private String typeCompte;
    private double solde;

    public Compte() {
    }

    public Compte(int numCompte, String typeCompte, double solde) {
        this.numCompte = numCompte;
        this.typeCompte = typeCompte;
        this.solde = solde;
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}
```

---

## 🔴 3.4 — model/Compte.hbm.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE hibernate-mapping PUBLIC
"-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">

<hibernate-mapping>

    <class name="model.Compte" table="compte">

        <id name="numCompte" column="numCompte" type="int">
            <generator class="assigned"/>
        </id>

        <property name="typeCompte" column="typeCompte" type="string"/>

        <property name="solde" column="solde" type="double"/>

    </class>

</hibernate-mapping>
```

---

## 🔴 3.5 — model/Operation.java

```java
package model;

import java.io.Serializable;
import java.util.Date;

public class Operation implements Serializable {

    private int idOperation;
    private String typeOperation;
    private double montant;
    private Date dateOperation;

    public Operation() {
    }

    public Operation(int idOperation, String typeOperation,
                     double montant, Date dateOperation) {
        this.idOperation = idOperation;
        this.typeOperation = typeOperation;
        this.montant = montant;
        this.dateOperation = dateOperation;
    }

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }
}
```

---

## 🔴 3.6 — model/Operation.hbm.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE hibernate-mapping PUBLIC
"-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">

<hibernate-mapping>

    <class name="model.Operation" table="operation">

        <id name="idOperation" column="idOperation" type="int">
            <generator class="assigned"/>
        </id>

        <property name="typeOperation"
                  column="typeOperation"
                  type="string"/>

        <property name="montant"
                  column="montant"
                  type="double"/>

        <property name="dateOperation"
                  column="dateOperation"
                  type="date"/>

    </class>

</hibernate-mapping>
```

---

## 🔴 3.7 — form/ClientForm.java

```java
package form;

import org.apache.struts.action.ActionForm;

public class ClientForm extends ActionForm {

    private String codeClient;
    private String nomClient;
    private String adresseClient;

    public ClientForm() {
    }

    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }
}
```

---

## 🔴 3.8 — form/CompteForm.java

```java
package form;

import org.apache.struts.action.ActionForm;

public class CompteForm extends ActionForm {

    private int numCompte;
    private String typeCompte;
    private double solde;
    private String action;

    public CompteForm() {
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
```

---

## 🔴 3.9 — form/OperationForm.java

```java
package form;

import org.apache.struts.action.ActionForm;

public class OperationForm extends ActionForm {

    private int idOperation;
    private String typeOperation;
    private double montant;
    private String dateOperation;
    private String action;

    public OperationForm() {
    }

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
```

> ⚠️ **ATTENTION** : Dans OperationForm, `dateOperation` est un **String** (pas Date).
> La conversion en Date se fait dans OperationAction avec SimpleDateFormat.

---

## 🔴 3.10 — util/HibernateUtil.java

```java
package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Erreur SessionFactory : " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
```

> ⚠️ Ce fichier est **CRITIQUE**. Sans lui, rien ne fonctionne.
> Il lit `hibernate.cfg.xml` et crée la SessionFactory une seule fois.

---

**➡️ Suite dans GUIDE_EXAMEN_PARTIE2.md**
