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
                 System.out.println("Quelle quantité de(') "+nomArticle+"avez-vous?");
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
        System.out.print(facture.afficherArticles());

    }


}
