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

    public IPièce getRoi(int x, int y, Couleur couleur) {
        return new Roi(new Coordonnées(x, y), couleur);
    }

    public IPièce getTour(int x, int y, Couleur couleur) {
        return new Tour(new Coordonnées(x, y), couleur);
    }

    public void defaut(Plateau p) {
        p.put(this.getRoi(4, 7, Couleur.NOIR));
        p.put(this.getTour(1, 6, Couleur.BLANC));
        p.put(this.getRoi(4, 5, Couleur.BLANC));
    }
}