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
                    idOperation,
                    typeOperation,
                    montant,
                    dateOperation
            );

            dao.ajouterOperation(operation);
            request.setAttribute("message",
                    "Opération ajoutée avec succès !");
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
            request.setAttribute("message",
                    "Opération supprimée avec succès !");
        }

        else if ("liste".equals(action)) {

            List<Operation> liste = dao.listeOperations();
            request.setAttribute("listeOperations", liste);
            request.setAttribute("message",
                    "Liste des opérations affichée !");
        }

        return mapping.findForward("success");
    }
}