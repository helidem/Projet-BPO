package Application;


import table.Pièces;

import table.Plateau;
import table.Roi;
import table.Tour;




public class appli {
    public static void main(String[] args) {
        Plateau p = new Plateau();

        p.ajouterPièce(5,1);

        //p.jouerPièce();




        //plateau.jouer(piece, coordX, coordY)





        //System.out.println("old X "+r.getOldCoordX());System.out.println("old Y "+r.getOldCoordY());
        //System.out.println("X "+r.getCoordX());System.out.println("Y "+r.getCoordY());
        System.out.println(p.toString());
    }
}
