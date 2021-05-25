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

    /**
     * Permet de jouer un coup
     * @param coup coup à jouer
     * @param partie la partie en cours
     * @return true si le coup peut être joué, sinon false
     */
    public boolean jouer(Coup coup, Partie partie) {
        if(!(coup.getDépart().getX() <8 && coup.getDépart().getX() >=0 && coup.getDépart().getY()<8 &&
                coup.getDépart().getY()>=0 && coup.getArrivée().getX() <8 && coup.getArrivée().getX() >=0 && coup.getArrivée().getY() <8 && coup.getArrivée().getY()>=0)){
            return false;
        }
        IPièce p = getPièce(coup.getDépart().getX(), coup.getDépart().getY());
        if(p ==null){
            return false;
        }

        p.memoriser();

        if (caseOccupée(p.getCoordonnées()))
            System.out.println(p.type());
        else {
            System.out.println(" ");
            return false;
        }

        if (!p.coupLegal(coup.getArrivée(), this))
            return false;

        if(p.craintEchec()){
            removePièce(p);
            put(p, coup.getArrivée());
            if(getRoi(partie.getJoueurCourant()).enEchec(this)){
                annulerCoup(p);
                return false;
            }
        }

        if(getRoi(partie.getJoueurCourant()).enEchec(this)){
            return false;
        }

        removePièce(p);
        put(p, coup.getArrivée());
        if(getRoi(partie.getJoueurAdverse()).enEchecEtMat(this,partie)){
            System.out.println("mat");
        }
        return true;
    }

    /**
     * Permet à la méthode enEchecEtMat de la classe Roi de jouer sans tester l'echec
     * @param coup à jouer
     * @param partie en cours
     * @return true si le coup peut être joué
     */
    public boolean jouerEchec(Coup coup, Partie partie) {
        if(!(coup.getDépart().getX() <8 && coup.getDépart().getX() >=0 && coup.getDépart().getY()<8 &&
                coup.getDépart().getY()>=0 && coup.getArrivée().getX() <8 && coup.getArrivée().getX() >=0 && coup.getArrivée().getY() <8 && coup.getArrivée().getY()>=0)){
            return false;
        }
        IPièce p = getPièce(coup.getDépart().getX(), coup.getDépart().getY());

        if(p ==null){
            return false;
        }
        p.memoriser();

        if (caseOccupée(p.getCoordonnées()))
            System.out.println(p.type());
        else {
            System.out.println(" ");
            return false;
        }

        removePièce(p);
        put(p, coup.getArrivée());
        return true;
    }

    /**
     * Annuler un coup, replace une pièce sur ses anciennes coorodonnées
     * @param p pièce
     */
    public void annulerCoup(IPièce p){
        removePièce(p);
        p.annulerCoup();
        put(p);
    }

    public IPièce getPièce(Coordonnées coordonnées) {
        return plateau[coordonnées.getX()][coordonnées.getY()];
    }

    public IPièce getPièce(int x, int y) {
        return plateau[x][y];
    }

    /**
     * Place une pièce dans le plateau dans les coordonnées données
     * @param p la pièce à mettre
     * @param coordonnées la coordonnée de la case désirée
     */
    public void put(IPièce p, Coordonnées coordonnées) {
        p.setCoordonnées(coordonnées);
        plateau[p.getCoordonnées().getX()][p.getCoordonnées().getY()] = p;
    }

    /**
     * Permet de placer la pièce dans ses propres coordonnées
     * @param p la pièce
     */
    public void put(IPièce p) {
        p.setCoordonnées(p.getCoordonnées());
        plateau[p.getCoordonnées().getX()][p.getCoordonnées().getY()] = p;
    }

    /**
     * Retite la pièce du plateau
     * @param p la pièce
     */
    public void removePièce(IPièce p) {
        plateau[p.getCoordonnées().getX()][p.getCoordonnées().getY()] = null;
    }

    /**
     * Permet d'afficher le plateau
     * @return le plateau
     */
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

    /**
     * Savoir si une case est occupée par une pièce
     * @param coordonnées à vérifier
     * @return true si la case est occupée
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

    /**
     * Permet de récuperer toutes les pièces du plateau
     * @return la liste des pièces du plateau
     */
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

    /**
     * Permet de récuperer toutes le pièces du plateau d'une couleur donnée
     * @param couleur la couleur souhaitée
     * @return la liste des pièces de la couleur
     */
    public ArrayList<IPièce> pièces(Couleur couleur){
        ArrayList<IPièce> pièces = new ArrayList<>();
        for(int l = 0;l<lignes;l++){
            for(int c = 0;c<colonnes;c++){
                if(caseOccupée(l,c) && plateau[l][c].getCouleur().equals(couleur)){
                    pièces.add(this.getPièce(l,c));
                }
            }
        }
        return pièces;
    }

    /**
     * Permet de récuperer le roi d'une couleur donnée
     * @param couleur la couleur du roi souhaitée
     * @return le roi
     */
    private IPièce getRoi(Couleur couleur){
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