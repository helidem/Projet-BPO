package table;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    public static final int lignes = 8;
    public static final int colonnes = 8;

    private final Pièces[][] plateau;

    private ArrayList<Pièces> piècesPlateau;

    /**
     * Constructeur de la classe Plateau
     */
    public Plateau() {
        plateau = new Pièces[lignes+1][colonnes+1];
        for (int l=lignes ; l>0 ; --l ){
            for(int c=1 ; c<=colonnes ; ++c){
                plateau[l][c] = new Pièces();
            }
        }
        this.piècesPlateau = new ArrayList<Pièces>();
    }

    public void ajouterPièce(int coordX , int coordY){
        Pièces p = new Pièces('P',coordX,coordY);
        putPièce(p);
        piècesPlateau.add(p);
    }
    public void ajouterRoi(int coordX , int coordY){
        Pièces p = new Roi('R',coordX,coordY);
        putPièce(p);
    }
    public void ajouterTour(int coordX , int coordY){
        Pièces p = new Tour('T',coordX,coordY);
        putPièce(p);
    }
    public void jouerPièce(int oldCoordX, int oldCoordY, int coordX ,int coordY){
        for (Pièces p : piècesPlateau){
            if(p.getCoordX == )
        }
     }


    public void jouer(Pièces p, int coordX, int coordY)
    {
        //faire les tests

        removePièce(p);
        putPièce(p, coordX, coordY);
    }


    public void putPièce(Pièces p){
        plateau[p.getCoordX()][p.getCoordY()] = p;
    }

    public void removePièce(Pièces p) { plateau[p.getCoordX()][p.getCoordY()] = new Pièces(); }

    public String toString(){

        StringBuilder s = new StringBuilder();
        s.append("    a   b   c   d   e   f   g   h    \n");
        s.append("   --- --- --- --- --- --- --- ---\n");

        for (int l=lignes ; l>0 ; --l ){
            s.append(l + " | ");
            for(int c=1 ; c<=colonnes ; ++c){
                s.append(plateau[c][l].getSympole(c,l));
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
