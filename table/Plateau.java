package table;


import partie.Coordonnées;
import partie.Coup;
import piece.Pièce;
import java.util.ArrayList;
import java.util.Scanner;

public class Plateau {

    public static final int lignes = 8;
    public static final int colonnes = 8;



    private Pièce[][] plateau;

    private ArrayList<Pièce> pièceNoir; //a enlever t mettre dans joueur
    private ArrayList<Pièce> pièceBlanc;

    /**
     * Constructeur de la classe Plateau
     */
    public Plateau() {
        plateau = new Pièce[lignes][colonnes];
    }

    public void jouer(Pièce p, Coordonnées coordonnées)
    {
        System.out.println(p.getCoordX() + " " + p.getCoordY());

        if (p.coupLegal(coordonnées.getX(), coordonnées.getY(), this) == false)
            return;

        removePièce(p);
        put(p, coordonnées);

    }

    public void jouer(Coup coup){
        Pièce p = getPièce(coup.getDépart().getX(),coup.getDépart().getY());
        System.out.println(p.type());

       // if (p.coupLegal(arrivée.getX(), arrivée.getY(), this) == false)
       //     return;
        if()

        removePièce(p);
        put(p, arrivée.getX(), arrivée.getY());
    }
    public Pièce getPièce(Coordonnées coordonnées){
        return plateau[coordonnées.getX()][coordonnées.getY()];
    }

    public Pièce getPièce(int x, int y){
        return plateau[x][y];
    }

    public void jouer(Coup coup){
        jouer(coup.getDépart(),coup.getArrivée());
    }


    /**
     * Place une pièce dans le plateau
     * @param p la pièce à mettre
     * @param coordonnées la coordonnée de la case désirée
     */
    public void put(Pièce p, Coordonnées coordonnées)
    {
        p.setCoordonnées(coordonnées);
        plateau[p.getCoordonnées().getX()][p.getCoordonnées().getY()] = p;
    }

    public void removePièce(Pièce p) { plateau[p.getCoordonnées().getX()][p.getCoordonnées().getY()] = null; }





    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("    a   b   c   d   e   f   g   h    \n");
        s.append("   --- --- --- --- --- --- --- ---\n");

        for (int l=lignes-1 ; l>=0 ; --l ){
            s.append(l+1 + " | ");
            for(int c=0 ; c<colonnes ; ++c){
                if (plateau[c][l] != null)
                    s.append(plateau[c][l].type());
                else s.append(" ");
                s.append(" | ");
            }
            s.append(l+1).append("\n");
            s.append("   --- --- --- --- --- --- --- ---\n");
        }
        s.append("    a   b   c   d   e   f   g   h    \n");
        return s.toString();
    }
}