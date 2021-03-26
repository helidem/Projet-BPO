package table;

import java.util.ArrayList;
import java.util.Locale;

public class Plateau {
   //private enum {}
    public static final int lignes = 8;
    public static final int colonnes = 8;

    private final Pièce[][] plateau;

    private ArrayList<Pièce> pièceNoir;
    private ArrayList<Pièce> pièceBlanc;

    /**
     * Constructeur de la classe Plateau
     */
    public Plateau() {
        plateau = new Pièce[lignes+1][colonnes+1];
        for (int l=lignes ; l>0 ; --l ){
            for(int c=1 ; c<=colonnes ; ++c){
                plateau[l][c] = new Pièce();
            }
        }
        this.pièceNoir = new ArrayList<>();
        this.pièceBlanc =new ArrayList<>();
    }

    public void ajouterPièce(int coordX , int coordY, Pièce.Couleur c , Type t){
        Pièce p = new Pièce(coordX,coordY, c, t);
        put(p, coordX, coordY);

        if(c == Pièce.Couleur.NOIR){
            pièceNoir.add(p);
        }
        else {
            pièceBlanc.add(p);
        }
    }

    /*public void ajouterRoi(int coordX , int coordY){
        Pièces p = new Roi(coordX,coordY,);
        put(p, coordX, coordY);
    }
    public void ajouterTour(int coordX , int coordY){
        Pièces p = new Tour('T',coordX,coordY);
        put(p, coordX, coordY);
    }*/

    public void jouerPièce(int actuelCoordX, int actuelCoordY, int coordX ,int coordY){
        assert coordX > 0 && coordY > 0 && actuelCoordX > 0 && actuelCoordY > 0;
        assert coordX < 9 && coordY < 9 && actuelCoordX < 9 && actuelCoordY < 9;
        for (Pièce p : pièceNoir){
            if(p.getCoordX() == actuelCoordX && p.getCoordY() == actuelCoordY ){

                jouer(p,coordX,coordY);
            }
        }
        // Une exception si on trouve pas la pièce
     }


    public void jouer(Pièce p, int coordX, int coordY)
    {
        //faire les tests
        memorise(p);
        removePièce(p);
        put(p, coordX, coordY);
    }

    public void memorise(Pièce p)
    {
        p.setOldCoordX(p.getCoordX());
        p.setOldCoordY(p.getCoordY());
    }

    /**
     * Place une pièce dans le plateau
     * @param p la pièce à mettre
     * @param coordX la coordonnée X de la case désirée
     * @param coordY la coordonnée Y de la case désirée
     */
    public void put(Pièce p, int coordX, int coordY)
    {
        p.setCoordX(coordX);
        p.setCoordY(coordY);
        plateau[p.getCoordX()][p.getCoordY()] = p;
    }

    public void removePièce(Pièce p) { plateau[p.getCoordX()][p.getCoordY()] = new Pièce(); }

    public String toString(){

        StringBuilder s = new StringBuilder();
        s.append("    a   b   c   d   e   f   g   h    \n");
        s.append("   --- --- --- --- --- --- --- ---\n");

        for (int l=lignes ; l>0 ; --l ){
            s.append(l + " | ");
            for(int c=1 ; c<=colonnes ; ++c){
                s.append(plateau[c][l].getType(c,l));
                s.append(" | ");
            }

            s.append(l).append("\n");
            s.append("   --- --- --- --- --- --- --- ---\n");
        }
        //s.append("   --- --- --- --- --- --- --- ---      \n");
        s.append("    a   b   c   d   e   f   g   h    \n");

        return s.toString();
    }


}
