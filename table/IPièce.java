package table;

import partie.Coordonnées;
import partie.Coup;
import partie.Partie;

import java.util.ArrayList;

public interface IPièce {
    boolean coupLegal(Coordonnées coordonnées, Plateau p);
    void setCoordonnées(Coordonnées coordonnées);
    Coordonnées getCoordonnées();
    String type();
    Couleur getCouleur();
    boolean craintEchec();
    boolean enEchec(Plateau p);
    boolean enEchecEtMat(Plateau p, Partie partie);
    void memoriser();
    Coordonnées getAncienneCoord();
    void annulerCoup();
    ArrayList<Coup> coupsPossibles(Plateau p);
}