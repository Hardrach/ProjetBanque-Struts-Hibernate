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