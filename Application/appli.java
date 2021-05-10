package Application;


import piece.Couleur;
import piece.Pièce;
import piece.Roi;
import piece.Tour;
import table.Plateau;


public class appli {
    public static void main(String[] args) {
        Plateau p = new Plateau();


        //saisie -> analyse de la saisie -> transformer la saisie en coup/coord -> jouer(.....) t'as capté => si erreur : aie

        Pièce r = new Roi(4,5,Couleur.BLANC);
        Pièce t = new Tour(4,1,Couleur.NOIR);
        Pièce t1 = new Tour(4,3,Couleur.NOIR);

        p.put(r,r.getCoordX(), r.getCoordY());
        p.put(t,t.getCoordX(),t.getCoordY());
        p.put(t1,t1.getCoordX(),t1.getCoordY());

        System.out.println(p);


        p.jouer(t,4,3);

        System.out.println(p);



    }
}
