package Application;


import table.Pièce;
import table.Plateau;
import table.Type;


public class appli {
    public static void main(String[] args) {
        Plateau p = new Plateau();


        p.ajouterPièce(5,1, Pièce.Couleur.NOIR, Type.r);

        p.jouerPièce(5,1,1,1);
        //p.jouerPièce();

        p.jouerPièce(1,1,8,1);
        //jouer(x,y)




        //plateau.jouer(piece, coordX, coordY)





        //System.out.println("old X "+r.getOldCoordX());System.out.println("old Y "+r.getOldCoordY());
        //System.out.println("X "+r.getCoordX());System.out.println("Y "+r.getCoordY());
        System.out.println(p.toString());
    }
}
