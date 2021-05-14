package table;


import partie.Coordonnées;
import partie.Coup;
import java.util.ArrayList;

public class Plateau {

    public static final int lignes = 8;
    public static final int colonnes = 8;



    private IPièce[][] plateau;

    //private ArrayList<Pièce> pièceNoir; //a enlever t mettre dans joueur
    //private ArrayList<Pièce> pièceBlanc;

    /**
     * Constructeur de la classe Plateau
     */
    public Plateau() {
        plateau = new IPièce[lignes][colonnes];
    }

    /*private void jouer(Pièce p, Coordonnées coordonnées)
    {
        System.out.println(p.getCoordonnées().getX() + " " + p.getCoordonnées().getY());

        if (p.coupLegal(coordonnées, this) == false)
            return;

        removePièce(p);
        put(p, coordonnées);

    }*/

    public void jouer(Coup coup){
        IPièce p = getPièce(coup.getDépart().getX(),coup.getDépart().getY());
        System.out.println(p.type());

        if(p.coupLegal(coup.getArrivée(),this) == false)
            return;

        removePièce(p);
        put(p, coup.getArrivée());
    }
    public IPièce getPièce(Coordonnées coordonnées){
        return plateau[coordonnées.getX()][coordonnées.getY()];
    }

    public IPièce getPièce(int x, int y){
        return plateau[x][y];
    }

    /*public void jouer(Coup coup){
        jouer(coup.getDépart(),coup.getArrivée());
    }*/


    /**
     * Place une pièce dans le plateau
     * @param p la pièce à mettre
     * @param coordonnées la coordonnée de la case désirée
     */
    public void put(IPièce p, Coordonnées coordonnées)
    {
        p.setCoordonnées(coordonnées);
        plateau[p.getCoordonnées().getX()][p.getCoordonnées().getY()] = p;
    }

    public void removePièce(IPièce p) { plateau[p.getCoordonnées().getX()][p.getCoordonnées().getY()] = null; }


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