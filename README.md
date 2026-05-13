# 🏦 Système de Gestion Bancaire Premium

[![Java Version](https://img.shields.io/badge/Java-8-orange.svg)](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
[![Struts Version](https://img.shields.io/badge/Struts-1.3-blue.svg)](https://struts.apache.org/)
[![Hibernate Version](https://img.shields.io/badge/Hibernate-4.3-green.svg)](https://hibernate.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

Une application web de gestion bancaire robuste et moderne, développée pour un environnement académique exigeant (compatible examen). Ce projet combine la puissance éprouvée du framework **Struts 1** et de l'ORM **Hibernate 4** avec une interface utilisateur de nouvelle génération.

---

## ✨ Points Forts

*   **🛠️ Architecture MVC Classique** : Séparation stricte des responsabilités (Action, Form, DAO, Model).
*   **🎨 Design UI Premium** : Interface en mode sombre avec effets de **Glassmorphism**, dégradés vibrants et typographie moderne (Outfit).
*   **💾 Persistance Hibernate** : Gestion automatisée de la base de données MySQL avec mappages XML.
*   **⚡ Navigation Intuitive** : Barre de navigation fluide pour basculer entre les clients, les comptes et les opérations.
*   **🎓 Compatible Examen** : Conçu pour s'exécuter parfaitement sur **NetBeans 8.2** avec **Java 8**.

---

## 🚀 Fonctionnalités

### 👤 Gestion des Clients
- Ajout, modification et suppression de clients.
- Recherche multicritère.
- Affichage dynamique de la liste des clients.

### 💳 Gestion des Comptes
- Création de comptes bancaires (Courant/Épargne).
- Suivi du solde en temps réel.
- Liaison transparente avec la base de données.

### 💸 Gestion des Opérations
- Enregistrement des versements et retraits.
- Historique complet des transactions avec dates et montants.

---

## 🛠️ Stack Technique

| Composant | Technologie |
| :--- | :--- |
| **Langage** | Java 8 (JDK 1.8) |
| **Framework Web** | Struts 1.3 |
| **ORM** | Hibernate 4.3.11.Final |
| **Base de données** | MySQL (via XAMPP / phpMyAdmin) |
| **Serveur d'App** | Apache Tomcat 8.x/9.x |
| **IDE** | NetBeans 8.2 |
| **Styling** | Vanilla CSS (Modern Glassmorphism) |

---

## 📸 Aperçu de l'Interface

![Interface Preview](banque_ui_preview.png)
*Capture d'écran réelle de l'interface d'administration : Gestion des clients avec design Glassmorphism et mode sombre.*

---

## 📥 Installation et Configuration

### 1. Prérequis
- Installateur **XAMPP** (MySQL & Apache).
- **NetBeans 8.2** (ou version compatible Java EE).
- **JDK 8** configuré comme plateforme par défaut.

### 2. Base de données
1. Démarrez MySQL via XAMPP.
2. Accédez à `http://localhost/phpmyadmin`.
3. Créez une base de données nommée `banque_db`.
4. Importez le fichier **[banque_db.sql](banque_db.sql)** situé à la racine du projet pour initialiser les tables et les données d'exemple.

### 3. Importation du Projet
1. Ouvrez NetBeans 8.2.
2. Allez dans `File -> Open Project`.
3. Sélectionnez le dossier `ProjetBanque`.
4. Vérifiez que les librairies (Struts 1.3, Hibernate 4.3, MySQL Connector) sont bien présentes dans le dossier `Libraries`.

### 4. Lancement
1. Faites un clic droit sur le projet.
2. Sélectionnez **Run**.
3. L'application s'ouvrira dans votre navigateur par défaut à l'adresse : `http://localhost:8080/ProjetBanque/`.

---

## 📁 Structure du Projet

```text
ProjetBanque/
├── src/java/
│   ├── action/      # Contrôleurs Struts
│   ├── form/        # ActionForms Struts
│   ├── model/       # Entités Hibernate & Fichiers .hbm.xml
│   ├── dao/         # Logique d'accès aux données
│   ├── util/        # HibernateUtil pour la session factory
│   └── hibernate.cfg.xml # Configuration Hibernate
├── web/
│   ├── css/         # Styles CSS modernes
│   ├── WEB-INF/     # struts-config.xml & web.xml
│   ├── index.jsp    # Gestion Clients
│   ├── compte.jsp   # Gestion Comptes
│   └── operation.jsp # Gestion Opérations
└── README.md
```

---

## 📄 Licence

Distribué sous la licence MIT. Voir `LICENSE` pour plus d'informations.

---

**Développé avec ❤️ pour la réussite académique.**
