package Application;


import table.Pièces;

import table.Plateau;
import table.Roi;
import table.Tour;

public class appli {
    public static void main(String[] args) {
        Plateau p = new Plateau();

        Pièces p1 = new Pièces('P', 1,1);

        p.putPièce(p1);

        //System.out.println(p1.toString());
        p.removePièce(p1);
        p1.jouer(1,2);
        p.putPièce(p1);
        //System.out.println(p1.toString());
        //p.putPièce(p1);
        p.removePièce(p1);
        p1.jouer(5,2);
        p.putPièce(p1);
       // p.putPièce('R', 1,1);


        Roi r = new Roi('R',1,1);
        p.putPièce(r);

        p.removePièce(r);
        r.jouerRoi(1,2);
        p.putPièce(r);

        p.removePièce(r);
        r.jouerRoi(2,2);
        p.putPièce(r);

        Tour t = new Tour('T',3,3);
        p.putPièce(t);

        p.removePièce(t);
        t.jouerTour(8,3);
        p.putPièce(t);

        //System.out.println("old X "+r.getOldCoordX());System.out.println("old Y "+r.getOldCoordY());
        //System.out.println("X "+r.getCoordX());System.out.println("Y "+r.getCoordY());
        System.out.println(p.toString());
    }
}
