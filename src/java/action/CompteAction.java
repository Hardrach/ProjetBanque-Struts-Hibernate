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