package TP;

import java.util.ArrayList;

public class calculFacture {
    private client client;
    private ArrayList<article> articles;

    //Récuperer les informations du client
    public String getClient() {
        return "Nom du client : " + client.getNom() +
                "\nTéléphone : " + client.getTelephone();
    }

    //Récuperer l'adresse mémoire de la liste d'articles
    public ArrayList<article> getArticles() {
        return this.articles;
    }

    //Transfomer l'adresse en texte pour aafficher les articles
    public String afficherArticles() {
        String texte = "";
        for (article a : this.articles) {
            texte += a.getNom() +
                    " (" + a.getQuantite() +
                    " x " + a.getPrixUnitaire() + ")\n";
        }
        return texte;
    }

    //Instance de la classe
    public calculFacture(client client) {
        this.client = client;
        this.articles = new ArrayList<>();
    }

    //Ajout d'un article à la liste des courses
    public void ajouterUnArticle(article article) {
        this.articles.add(article);
    }

    //Calcul du prix total des articles
    public double getprixHT() {
        double prixHT = 0;
        for (article article : this.articles) {
            prixHT += article.getPrixUnitaire()*article.getQuantite();
        }
        return prixHT;
    }

    //Calcul de la remise(30%) selon que le prix total hors taxe dépasse 100
    public double getRemise(double prixHT) {
        double remise = 0;
        if (prixHT>100){
            remise=prixHT*0.3;
        }
        return remise;
    }

    //Calcul de la TVA sur le prix total(16%)
    public double getTva(double prixTotal){
        return prixTotal*0.16;
    }

    //Calcul du prix toute taxe comprise
    public double getPrixTTC(double prixTTC) {
          return  prixTTC * 1.16;
    }

    //Calcul du net à payer= prix TTC- Remise
    public double getNetAPayer(double prixTTC, double remise){
        double netAPayer = prixTTC;
        if(prixTTC>100){
            netAPayer=netAPayer-remise;
        }
        return netAPayer;
    }
}
