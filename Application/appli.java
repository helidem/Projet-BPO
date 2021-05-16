package Application;


import partie.Coordonnées;
import partie.Coup;
import partie.Partie;
import table.Couleur;

import piece.Roi;
import piece.Tour;
import table.IPièce;
import table.Plateau;

import java.util.Scanner;


public class appli {
    public static void main(String[] args) {
        Partie partie = new Partie();
        Plateau p = new Plateau();

        IPièce r = new Roi(new Coordonnées(3,4),Couleur.NOIR);
        IPièce t = new Tour(new Coordonnées(5,5),Couleur.NOIR);
        IPièce t1 = new Tour(new Coordonnées(1,1),Couleur.BLANC);

        p.put(r,r.getCoordonnées());
        p.put(t,t.getCoordonnées());
        p.put(t1);

        System.out.println(p);

        Scanner scanner = new Scanner(System.in);
        System.out.println(partie);
        System.out.print("> ");
        String ligne = scanner.nextLine();
        while (!ligne.equals("fin")) // Tant qu'entrée n'est pas "fin"
        {
            Coup coup = new Coup();

            if(!décomposer(ligne, coup)){
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

    /**
     *
     * @param ligne
     * @param coup
     * @return
     */
    private static boolean décomposer(String ligne, Coup coup){
        Scanner scanner = new Scanner(ligne);

        ligne.toLowerCase();

        // On vérifie si l'entrée est de taille 7
        if(ligne.length() != 4)
        {
            return false;
        }

        int var = 0,var1 = 0,var2 = 0,var3 = 0;

        if(Character.isLetter(ligne.charAt(0)) && (int)ligne.charAt(0) - (int)'a' >=0 && (int)ligne.charAt(0) - (int)'a' <= 7){
             var = (int)ligne.charAt(0) - (int)'a';
        }else{
            return false;
        }
        if(Character.isDigit(ligne.charAt(1)) && Integer.parseInt(ligne.substring(1,2)) <9 && Integer.parseInt(ligne.substring(1,2))>0){
             var1 = ligne.charAt(1) -'0'- 1;
        }else{
            return false;
        }
        if(Character.isLetter(ligne.charAt(2))&& (int)ligne.charAt(2) - (int)'a' >=0 && (int)ligne.charAt(2) - (int)'a' <= 7){
            var2 = (int)ligne.charAt(2) - (int)'a';
        }else{
            return false;
        }
        if(Character.isDigit(ligne.charAt(3))&& Integer.parseInt(ligne.substring(3)) <9 && Integer.parseInt(ligne.substring(3))>0){
            var3 = ligne.charAt(3) -'0'- 1;
        }else{
            return false;
        }

        Coordonnées départ = new Coordonnées(var,var1);
        Coordonnées arrivée = new Coordonnées(var2,var3);

        coup.setCoord(départ,arrivée);
        return true;
    }
}