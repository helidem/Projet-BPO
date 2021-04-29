package Application;


import piece.Pièce;
import table.Plateau;
import table.Type;


public class appli {
    public static void main(String[] args) {
        Plateau p = new Plateau();


        p.ajouterPièce(4,1, Pièce.Couleur.BLANC, Type.r);
        p.ajouterPièce(4,2, Pièce.Couleur.NOIR, Type.r);

        //Piece r = new Roi(3,5,b);



        //p.jouerPièce(4,1,5,2);
        // p.jouerPièce();


        //jouer(x,y)




        //plateau.jouer(piece, coordX, coordY)





        //System.out.println("old X "+r.getOldCoordX());System.out.println("old Y "+r.getOldCoordY());
        //System.out.println("X "+r.getCoordX());System.out.println("Y "+r.getCoordY());
        System.out.println(p.toString());
    }
}
