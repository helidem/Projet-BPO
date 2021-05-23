package table;

import partie.Coordonnées;
import partie.Coup;

import java.util.ArrayList;

public interface IPièce {
     boolean coupLegal(Coordonnées coordonnées, Plateau p);

    void setCoordonnées(Coordonnées coordonnées);

    Coordonnées getCoordonnées();

    String type();

    Couleur getCouleur();

    boolean craintEchec();

    boolean enEchec(Plateau p);

    void setAncienneCoord(Coordonnées ancienneCoord);
    Coordonnées getAncienneCoord();

    String afficherCoups(Plateau p);
    ArrayList<Coup> coupsPossibles(Plateau p);

}