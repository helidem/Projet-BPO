package table;

import partie.Coordonnées;

public interface IPièce {
    public boolean coupLegal(Coordonnées coordonnées, Plateau p);
    public void manger(int x, int y, Plateau p);
}