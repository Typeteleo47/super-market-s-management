package TP;

public class client {
    private String nom;
    private String telephone;
    public client  (String nom, String telephone) {
        this.nom = nom;
        this.telephone = telephone;
    }
    public String getNom() {
        return nom;
    }

    public String getTelephone() {
        return telephone;
    }
}
