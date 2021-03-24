package table;

public class Tour extends Pièce
{


    public Tour(int coordX, int coordY, Couleur c , Type t) {
        super(coordX, coordY, c, Type.t);
    }

    public void jouerTour(int x ,int y){
        assert coupLegal(x,y);
        //jouer(x,y);
    }

    public boolean coupLegal(int x, int y){
        return ((getCoordX() == x && getCoordY() != y) || (getCoordY() == y && getCoordX() != x));
    }

}
