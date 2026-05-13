<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Compte" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion Bancaire - Comptes</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <nav>
        <a href="index.jsp">Clients</a>
        <a href="compte.jsp" class="active">Comptes</a>
        <a href="operation.jsp">Opérations</a>
    </nav>

    <div class="container">
        <h1>Gestion des Comptes</h1>
        <h2>Portail d'administration bancaire</h2>

        <div class="card">
            <html:form action="/compte.do">
                <table>
                    <tr>
                        <td>Numéro Compte</td>
                        <td>
                            <html:text property="numCompte"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Type Compte</td>
                        <td>
                            <html:text property="typeCompte"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Solde Initial</td>
                        <td>
                            <html:text property="solde"/>
                        </td>
                    </tr>
                </table>

                <div class="button-group">
                    <html:submit property="action" value="ajouter"/>
                    <html:submit property="action" value="modifier"/>
                    <html:submit property="action" value="supprimer"/>
                    <html:submit property="action" value="rechercher"/>
                    <html:submit property="action" value="liste"/>
                </div>
            </html:form>
        </div>

        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
            <div class="message">
                <h3><%= message %></h3>
            </div>
        <%
            }
        %>

        <%
            Compte compteTrouve = (Compte) request.getAttribute("compteTrouve");
            if (compteTrouve != null) {
        %>
            <div class="card">
                <h2>Compte Trouvé</h2>
                <div class="data-table-container">
                    <table class="data-table">
                        <thead>
                            <tr>
                                <th>Numéro</th>
                                <th>Type</th>
                                <th>Solde</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><%= compteTrouve.getNumCompte() %></td>
                                <td><%= compteTrouve.getTypeCompte() %></td>
                                <td><%= compteTrouve.getSolde() %></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        <%
            }
        %>

        <%
            List<Compte> listeComptes = (List<Compte>) request.getAttribute("listeComptes");
            if (listeComptes != null && !listeComptes.isEmpty()) {
        %>
            <div class="card">
                <h2>Liste des Comptes</h2>
                <div class="data-table-container">
                    <table class="data-table">
                        <thead>
                            <tr>
                                <th>Numéro</th>
                                <th>Type</th>
                                <th>Solde</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Compte c : listeComptes) { %>
                            <tr>
                                <td><%= c.getNumCompte() %></td>
                                <td><%= c.getTypeCompte() %></td>
                                <td><%= c.getSolde() %></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        <%
            }
        %>
    </div>

</body>
</html>