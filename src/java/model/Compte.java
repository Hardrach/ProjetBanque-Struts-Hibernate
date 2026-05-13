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