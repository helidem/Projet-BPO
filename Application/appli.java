package Application;


import partie.Coup;
import piece.Couleur;
import piece.Pièce;
import piece.Roi;
import piece.Tour;
import table.Plateau;

import java.util.Scanner;


public class appli {
    public static void main(String[] args) {
        Plateau p = new Plateau();


        //saisie -> analyse de la saisie -> transformer la saisie en coup/coord -> jouer(.....) t'as capté => si erreur : aie

        Pièce r = new Roi(3,5,Couleur.BLANC); //ça commence a partir de 0 donc 0 = 1 ou a etc... et 7 = 8 ou h donc (4,5) =>e6
        Pièce t = new Tour(5,5,Couleur.NOIR);
        Pièce t1 = new Tour(4,3,Couleur.NOIR);

        p.put(r,r.getCoordX(), r.getCoordY()); //changer ça pour avoir une methode surchargée
        p.put(t,t.getCoordX(),t.getCoordY());
        p.put(t1,t1.getCoordX(),t1.getCoordY());
        System.out.println(p);
        p.jouer(3,5,2,5);
        System.out.println(p);
        System.out.println(r.getCoordX() + " " + r.getCoordY());

    Scanner scanner = new Scanner(System.in);
       System.out.print("> ");
        String ligne = scanner.nextLine();
       while (!ligne.equals("fin")) // Tant qu'entrée n'est pas "fin"
        {
            Coup coup = new Coup();

            boolean isOk = décomposer(ligne, coup);
            if(!isOk){
                System.out.println("Erreur");
            }
            p.jouer(coup);
            System.out.println(p);
            System.out.print("> ");
            ligne = scanner.nextLine();
        }

scanner.close();



    }


    private static boolean décomposer(String ligne, Coup coup){
        Scanner scanner = new Scanner(ligne);
        // On décompose la ligne
        while(scanner.hasNext())
        {
            String mot = scanner.next();

            // On analyse chaque mot de la ligne entrée
            if(!analyser(mot, coup))
            {
                return false; // Retourne faux si un pas valide
            }
        }

        return true;
    }

    private static boolean analyser(String mot, Coup coup){
        // On vérifie si l'entrée est de taille 7
        if(mot.length() != 7)
        {
            return false;
        }
            int xd = Integer.parseInt(mot.substring(0, 1));
            int yd = Integer.parseInt(mot.substring(2, 3));//3,5:5,6
            int xa = Integer.parseInt(mot.substring(4, 5));//0123456
            int ya = Integer.parseInt(mot.substring(6));

            coup.setCoord(xd,yd,xa,ya);
            return true;
    }
}
