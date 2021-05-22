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
        IPièce r1 = new Roi(new Coordonnées(2,2),Couleur.BLANC);
        IPièce t = new Tour(new Coordonnées(5,5),Couleur.NOIR);
        IPièce t1 = new Tour(new Coordonnées(1,1),Couleur.BLANC);


        p.put(r,r.getCoordonnées());
        p.put(t,t.getCoordonnées());
        p.put(t1);
        p.put(r1);

        partie.commencer(p);

        //TODO : pour detecter si le roi est en danger : pour chaque mouvement, regarder dans sa trajectoire le type de la piece si c'est un roi adverse
    }
}