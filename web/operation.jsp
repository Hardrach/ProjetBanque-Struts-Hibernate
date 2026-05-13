<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Operation" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion Bancaire - Opérations</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <nav>
        <a href="index.jsp">Clients</a>
        <a href="compte.jsp">Comptes</a>
        <a href="operation.jsp" class="active">Opérations</a>
    </nav>

    <div class="container">
        <h1>Gestion des Opérations</h1>
        <h2>Portail d'administration bancaire</h2>

        <div class="card">
            <html:form action="/operation.do">
                <table>
                    <tr>
                        <td>ID Opération</td>
                        <td>
                            <html:text property="idOperation"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Type Opération</td>
                        <td>
                            <html:text property="typeOperation"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Montant</td>
                        <td>
                            <html:text property="montant"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Date (yyyy-MM-dd)</td>
                        <td>
                            <html:text property="dateOperation"/>
                        </td>
                    </tr>
                </table>

                <div class="button-group">
                    <html:submit property="action" value="ajouter"/>
                    <html:submit property="action" value="rechercher"/>
                    <html:submit property="action" value="supprimer"/>
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
            Operation op = (Operation) request.getAttribute("operationTrouvee");
            if (op != null) {
        %>
            <div class="card">
                <h2>Opération Trouvée</h2>
                <div class="data-table-container">
                    <table class="data-table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Type</th>
                                <th>Montant</th>
                                <th>Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><%= op.getIdOperation() %></td>
                                <td><%= op.getTypeOperation() %></td>
                                <td><%= op.getMontant() %></td>
                                <td><%= op.getDateOperation() %></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        <%
            }
        %>

        <%
            List<Operation> listeOperations = (List<Operation>) request.getAttribute("listeOperations");
            if (listeOperations != null && !listeOperations.isEmpty()) {
        %>
            <div class="card">
                <h2>Liste des Opérations</h2>
                <div class="data-table-container">
                    <table class="data-table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Type</th>
                                <th>Montant</th>
                                <th>Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Operation o : listeOperations) { %>
                            <tr>
                                <td><%= o.getIdOperation() %></td>
                                <td><%= o.getTypeOperation() %></td>
                                <td><%= o.getMontant() %></td>
                                <td><%= o.getDateOperation() %></td>
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