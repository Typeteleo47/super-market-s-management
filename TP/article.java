package TP;

public class article {
    private String nom;
    private int quantite;
    private double prixUnitaire;

    public article(String nom, int quantite, double prixUnitaire) {
        this.nom = nom;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }
    public String getNom() {
        return nom;
    }
    public int getQuantite() {
        return quantite;
    }
    public double  getPrixUnitaire() {
        return prixUnitaire;
    }
}
