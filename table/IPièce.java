package table;

import partie.Coordonnées;

public interface IPièce {
     boolean coupLegal(Coordonnées coordonnées, Plateau p);

    void setCoordonnées(Coordonnées coordonnées);

    Coordonnées getCoordonnées();

    String type();

    Couleur getCouleur();

    boolean craintEchec();

    boolean enEchec(Plateau p);

    void setAncienneCoord(Coordonnées ancienneCoord);
    public Coordonnées getAncienneCoord();

}