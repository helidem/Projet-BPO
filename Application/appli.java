package Application;

import partie.Partie;
import table.Plateau;

public class appli {
    public static void main(String[] args) {
        Partie partie = new Partie();
        Plateau p = new Plateau();
        PieceFactory pf = new PieceFactory();

        /*--------------PLACER ICI LES PIECES--------------

        exemple : pf.getRoi(1,1,Couleur.BLANC);


         --------------PLACER ICI LES PIECES--------------*/
        pf.defaut(p);
        partie.commencer(p);
    }
}