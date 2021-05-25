package Application;

import partie.Coordonnées;
import piece.Roi;
import piece.Tour;
import table.Couleur;
import table.IPièce;
import table.Plateau;

public class PieceFactory {
    public PieceFactory() {
    }

    /**
     * Crée un Roi aux coornonnées et couleur donnée
     * @param x la coordonnée x
     * @param y la coordonnée y
     * @param couleur la couleur souhaitée
     * @return la pièce souhaitée
     */
    public IPièce getRoi(int x, int y, Couleur couleur) {
        return new Roi(new Coordonnées(x, y), couleur);
    }

    /**
     * Crée une Tour aux coornonnées et couleur donnée
     * @param x la coordonnée x
     * @param y la coordonnée y
     * @param couleur la couleur souhaitée
     * @return la pièce souhaitée
     */
    public IPièce getTour(int x, int y, Couleur couleur) {
        return new Tour(new Coordonnées(x, y), couleur);
    }

    /**
     * Crée le plateau de la consigne
     * @param p le plateau
     */
    public void defaut(Plateau p) {
        p.put(this.getRoi(4, 7, Couleur.NOIR));
        p.put(this.getTour(1, 6, Couleur.BLANC));
        p.put(this.getRoi(4, 5, Couleur.BLANC));
    }
}