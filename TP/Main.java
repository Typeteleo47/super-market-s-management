package TP;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Informations du client.
        System.out.print("Entrez votre nom : ");
        String nomClient = sc.nextLine();
        System.out.print("Entrez votre numero de téléphone : ");
        String telClient = sc.nextLine();
        // Instance de l'objet client
        client infoClient= new client(nomClient,telClient);

        //Informations des produits.
        System.out.print("Entrez le nombre d'articles : ");
        int nombreArticles= sc.nextInt();
        article infoArticle;
        calculFacture facture= new calculFacture(infoClient);
        sc.nextLine();
        for (int i=0;i<nombreArticles;i++) {
             System.out.print("Entrez votre article n°"+ (i+1) +" : ");
             String nomArticle = sc.nextLine();
            int quantiteArticle=0;
            double prixUnitaire=0;
             do{
                 System.out.println("Quelle quantité de(') "+nomArticle+" avez-vous acheté?");
                 quantiteArticle = sc.nextInt();
                 sc.nextLine();
                 System.out.println("Quel est le prix d'un "+nomArticle+"?");
                 prixUnitaire = sc.nextDouble();
                 sc.nextLine();
                 if(prixUnitaire<=0 || quantiteArticle<=0) {
                     System.out.println("Ni la quantité d'un article, ni le prix d'un article ne peuvent être" +
                             " inférieur ou égal à 0.\n" +
                             "Veuillez entrer une valeur valide SVP!");
                 }

             }while(quantiteArticle<=0 || prixUnitaire<=0);
             infoArticle = new article(nomArticle,quantiteArticle,prixUnitaire);
             facture.ajouterUnArticle(infoArticle);

        }

        //Affichage de la facture.
        System.out.println(
                "\n|=============================================|\n" +
                        "|==========         FACTURE         ==========|\n" +
                        "|=============================================|\n" +
                        "\n|=============================================|\n" +
                        "|==========   INFORMATIONS CLIENT   ==========|\n" +
                        "|=============================================|\n"
        );
        System.out.printf("| Nom du client : %-20s \n", infoClient.getNom());
        System.out.printf("| Numero de telephone : %-15s \n", infoClient.getTelephone());
        System.out.println("|=============================================|");
        System.out.println(
                "\n|=============================================|\n" +
                        "|==========   INFORMATIONS ARTICLES  =========|\n" +
                        "|=============================================|\n"
        );
        System.out.printf("| %-14s | %-10s | %-10s |\n", "Article", "Quantité", "Prix Unitaire");
        System.out.println("|=============================================|");
        for(article a : facture.getArticles()){
            System.out.printf("| %-14s | %-10d | %-10.2f |\n", a.getNom(), a.getQuantite(), a.getPrixUnitaire());
        }
        System.out.println("|=============================================|");
        double prixHT = facture.getprixHT();
        double tva = facture.getTva(prixHT);
        double prixTTC = facture.getPrixTTC(prixHT);
        double remise= facture.getRemise(prixHT);
        double netAPayer = facture.getNetAPayer(prixTTC,remise);

        System.out.printf("\n| %-30s : %.2f |\n", "Total HT", prixHT);
        System.out.printf("| %-30s : %.2f |\n", "TVA (16%)", tva);
        System.out.printf("| %-30s : %.2f |\n", "Prix TTC", prixTTC);
        System.out.printf("| %-30s : %.2f |\n", "Rémise", remise);
        System.out.printf("| %-30s : %.2f |\n", "Net à Payer", netAPayer);
        System.out.println("\n|=============================================|");
    }

}
