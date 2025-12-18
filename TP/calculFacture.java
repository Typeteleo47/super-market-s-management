package TP;

import java.util.ArrayList;

public class calculFacture {
    private client client;
    private ArrayList<article> articles;

    public String getClient() {
        return "Nom du client : " + client.getNom() +
                "\nTéléphone : " + client.getTelephone();
    }

    public ArrayList<article> getArticles() {
        return this.articles;
    }
    public String afficherArticles() {
        String texte = "";
        for (article a : this.articles) {
            texte += a.getNom() +
                    " (" + a.getQuantite() +
                    " x " + a.getPrixUnitaire() + ")\n";
        }
        return texte;
    }


    public calculFacture(client client) {
        this.client = client;
        this.articles = new ArrayList<>();
    }
    public void ajouterUnArticle(article article) {
        this.articles.add(article);
    }
    public double getTotal() {
        double total = 0;
        for (article article : this.articles) {
            total += article.getPrixUnitaire()*article.getQuantite();
        }
        return total;
    }
    public double getNetAPayer(double prixTotal){
        double netAPayer = prixTotal;
        if(prixTotal>100){
            netAPayer=netAPayer-(netAPayer*0.3);
        }
        return netAPayer;
    }
    public double getTva(double prixTotal){
        return prixTotal*0.16;
    }
    public double getPrixTTC(double netAPayer) {
          return  netAPayer * 1.16;
    }
}
