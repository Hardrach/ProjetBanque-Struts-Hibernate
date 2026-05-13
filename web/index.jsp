<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Client" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion Bancaire - Clients</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <nav>
        <a href="index.jsp" class="active">Clients</a>
        <a href="compte.jsp">Comptes</a>
        <a href="operation.jsp">Opérations</a>
    </nav>

    <div class="container">
        <h1>Gestion des Clients</h1>
        <h2>Portail d'administration bancaire</h2>

        <div class="card">
            <html:form action="/client.do">
                <table>
                    <tr>
                        <td>Code Client</td>
                        <td>
                            <html:text property="codeClient"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Nom Complet</td>
                        <td>
                            <html:text property="nomClient"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Adresse</td>
                        <td>
                            <html:text property="adresseClient"/>
                        </td>
                    </tr>
                </table>

                <div class="button-group">
                    <html:submit property="action" value="Ajouter"/>
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
            Client clientTrouve = (Client) request.getAttribute("clientTrouve");
            if (clientTrouve != null) {
        %>
            <div class="card">
                <h2>Client Trouvé</h2>
                <div class="data-table-container">
                    <table class="data-table">
                        <thead>
                            <tr>
                                <th>Code</th>
                                <th>Nom</th>
                                <th>Adresse</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><%= clientTrouve.getCodeClient() %></td>
                                <td><%= clientTrouve.getNomClient() %></td>
                                <td><%= clientTrouve.getAdresseClient() %></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        <%
            }
        %>

        <%
            List<Client> listeClients = (List<Client>) request.getAttribute("listeClients");
            if (listeClients != null && !listeClients.isEmpty()) {
        %>
            <div class="card">
                <h2>Liste des Clients</h2>
                <div class="data-table-container">
                    <table class="data-table">
                        <thead>
                            <tr>
                                <th>Code Client</th>
                                <th>Nom Client</th>
                                <th>Adresse Client</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Client c : listeClients) { %>
                            <tr>
                                <td><%= c.getCodeClient() %></td>
                                <td><%= c.getNomClient() %></td>
                                <td><%= c.getAdresseClient() %></td>
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