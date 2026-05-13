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