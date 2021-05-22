package table;


import partie.Coordonnées;
import partie.Coup;
import partie.Partie;

import java.util.ArrayList;

public class Plateau {

    public static final int lignes = 8;
    public static final int colonnes = 8;

    private IPièce[][] plateau;

    /**
     * Constructeur de la classe Plateau
     */
    public Plateau() {
        plateau = new IPièce[lignes][colonnes];
    }

    public boolean jouer(Coup coup, Partie partie) {
        IPièce p = getPièce(coup.getDépart().getX(), coup.getDépart().getY());
        if (caseOccupée(p.getCoordonnées()))
            System.out.println(p.type());
        else {
            System.out.println(" ");
            return false;
        }

        if (!p.coupLegal(coup.getArrivée(), this))
            return false;

        if(p.craintEchec()){
            p.setAncienneCoord(p.getCoordonnées());
            removePièce(p);
            put(p, coup.getArrivée());
            if(getRoi(partie.getJoueurCourant()).enEchec(this)){
                p.setAncienneCoord(p.getAncienneCoord());
                return false;
            }
        }

        if(getRoi(partie.getJoueurCourant()).enEchec(this)){
            return false;
        }
        removePièce(p);
        put(p, coup.getArrivée());
        return true;
    }

    public IPièce getPièce(Coordonnées coordonnées) {
        return plateau[coordonnées.getX()][coordonnées.getY()];
    }

    public IPièce getPièce(int x, int y) {
        return plateau[x][y];
    }

    /**
     * Place une pièce dans le plateau
     * @param p la pièce à mettre
     * @param coordonnées la coordonnée de la case désirée
     */
    public void put(IPièce p, Coordonnées coordonnées) {
        p.setCoordonnées(coordonnées);
        plateau[p.getCoordonnées().getX()][p.getCoordonnées().getY()] = p;
    }

    public void removePièce(IPièce p) {
        plateau[p.getCoordonnées().getX()][p.getCoordonnées().getY()] = null;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("    a   b   c   d   e   f   g   h    \n");
        s.append("   --- --- --- --- --- --- --- ---\n");

        for (int l = lignes - 1; l >= 0; --l) {
            s.append(l + 1 + " | ");
            for (int c = 0; c < colonnes; ++c) {
                if (plateau[c][l] != null)
                    s.append(plateau[c][l].type());
                else s.append(" ");
                s.append(" | ");
            }
            s.append(l + 1).append("\n");
            s.append("   --- --- --- --- --- --- --- ---\n");
        }
        s.append("    a   b   c   d   e   f   g   h    \n");
        return s.toString();
    }

    public void put(IPièce p) {
        plateau[p.getCoordonnées().getX()][p.getCoordonnées().getY()] = p;
    }

    /**
     * Savoir si une case est occupée par une pièce
     * @param coordonnées
     * @return
     */
    public boolean caseOccupée(Coordonnées coordonnées){
        IPièce p = getPièce(coordonnées.getX(), coordonnées.getY());
        if (p != null)
            return true;
        else {

            return false;
        }
    }

    public boolean caseOccupée( int x, int y){
        IPièce p = getPièce(x, y);
        if (p != null) //si la case n'est pas null -> elle est occupée
            return true;
        else {
            return false;
        }
    }

    public ArrayList<IPièce> pièces(){
        ArrayList<IPièce> pièces = new ArrayList<>();
        for(int l = 0;l<lignes;l++){
            for(int c = 0;c<colonnes;c++){
                if(caseOccupée(l,c)){
                    pièces.add(this.getPièce(l,c));
                }
            }
        }
        return pièces;
    }

    public IPièce getRoi(Couleur couleur){
        for(int l = 0;l<lignes;l++){
            for(int c = 0;c<colonnes;c++){
                if(caseOccupée(l,c)){
                    if(plateau[l][c].getCouleur().equals(couleur) && plateau[l][c].craintEchec()){
                        return plateau[l][c];
                    }
                }
            }
        }
        return null;
    }
}