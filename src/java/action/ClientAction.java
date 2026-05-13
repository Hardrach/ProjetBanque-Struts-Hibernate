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

        // SUPPRIMER
        if ("supprimer".equals(action)) {

            dao.supprimerClient(codeClient);
            request.setAttribute("message", "Client supprimé avec succès !");

        }

        // MODIFIER
        else if ("modifier".equals(action)) {

            Client client = new Client(
                    codeClient,
                    nomClient,
                    adresseClient
            );

            dao.modifierClient(client);
            request.setAttribute("message", "Client modifié avec succès !");
        }

        // RECHERCHER
        else if ("rechercher".equals(action)) {

            Client client = dao.chercherClient(codeClient);

            if (client != null) {
                request.setAttribute("clientTrouve", client);
                request.setAttribute("message", "Client trouvé !");
            } else {
                request.setAttribute("message", "Client introuvable !");
            }
        }

        // LISTE CLIENTS
        else if ("liste".equals(action)) {

            List<Client> listeClients = dao.listeClients();
            request.setAttribute("listeClients", listeClients);
            request.setAttribute("message", "Liste des clients affichée !");
        }

        // AJOUTER
        else {

            Client client = new Client(
                    codeClient,
                    nomClient,
                    adresseClient
            );

            dao.ajouterClient(client);
            request.setAttribute("message", "Client ajouté avec succès !");
        }

        return mapping.findForward("success");
    }
}