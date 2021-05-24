package Application;


import partie.Coordonnées;

import partie.Partie;
import table.Couleur;
import table.IPièce;
import table.Plateau;



public class appli {
    public static void main(String[] args) {
        Partie partie = new Partie();
        Plateau p = new Plateau();
        PieceFactory pf = new PieceFactory();

        /*--------------PLACER ICI LES PIECES--------------


        exemple : pf.getRoi(1,1,Couleur.BLANC);





         */

        pf.defaut(p);

        partie.commencer(p);

        //TODO : pour detecter si le roi est en danger : pour chaque mouvement, regarder dans sa trajectoire le type de la piece si c'est un roi adverse
    }
}