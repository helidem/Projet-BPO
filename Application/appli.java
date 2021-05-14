package Application;


import partie.Coordonnées;
import partie.Coup;
import partie.Partie;
import table.Couleur;

import piece.Pièce;
import piece.Roi;
import piece.Tour;
import table.Plateau;

import java.util.Scanner;


public class appli {
    public static void main(String[] args) {
        Partie partie = new Partie();
        Plateau p = new Plateau();


        //saisie -> analyse de la saisie -> transformer la saisie en coup/coord -> jouer(.....) t'as capté => si erreur : aie

        Pièce r = new Roi(new Coordonnées(3,4),Couleur.NOIR); //ça commence a partir de 0 donc 0 = 1 ou a etc... et 7 = 8 ou h donc (4,5) =>e6

            Pièce t = new Tour(new Coordonnées(5,5),Couleur.NOIR);

        p.put(r,r.getCoordonnées());
        p.put(t,t.getCoordonnées());

        System.out.println(p);

        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String ligne = scanner.nextLine();
        while (!ligne.equals("fin")) // Tant qu'entrée n'est pas "fin"
        {
            Coup coup = new Coup();

            boolean isOk = décomposer(ligne, coup);

            if(!isOk){
                System.out.print("#");
            }else{
                p.jouer(coup);
                partie.changerJoueur();
                System.out.println(partie);
                System.out.println(p);
            }
            System.out.print("> ");
            ligne = scanner.nextLine();
        }
        scanner.close();
    }


    private static boolean décomposer(String ligne, Coup coup){
        Scanner scanner = new Scanner(ligne);

        ligne.toLowerCase();

        // On vérifie si l'entrée est de taille 7
        if(ligne.length() != 4)
        {
            return false;
        }

        int var = 0,var1 = 0,var2 = 0,var3 = 0;

        if(Character.isLetter(ligne.charAt(0))){
             var = (int)ligne.charAt(0) - (int)'a';
        }else{
            return false;
        }
        if(Character.isDigit(ligne.charAt(1)) && ligne.charAt(1) <9 && ligne.charAt(1)>0){
             var1 = ligne.charAt(1) -'0'- 1;
        }else{
            return false;
        }
        if(Character.isLetter(ligne.charAt(2))){
            var2 = (int)ligne.charAt(2) - (int)'a';
        }else{
            return false;
        }
        if(Character.isDigit(ligne.charAt(3))&& ligne.charAt(1) <9 && ligne.charAt(1)>0){
            var3 = ligne.charAt(3) -'0'- 1;
        }else{
            return false;
        }

        Coordonnées départ = new Coordonnées(var,var1);
        Coordonnées arrivée = new Coordonnées(var2,var3);

        coup.setCoord(départ,arrivée);
        return true;
    }

    private static void analyser(String mot, Coup coup){
           /* int xd = Integer.parseInt(mot.substring(0, 1));
            int yd = Integer.parseInt(mot.substring(2, 3));//3,5:5,6
            int xa = Integer.parseInt(mot.substring(4, 5));//0123456
            int ya = Integer.parseInt(mot.substring(6));*/
    }
}