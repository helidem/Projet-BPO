package table;

public class Tour extends Pièces
{


    public Tour(char pièceNom, int coordX, int coordY) {
        super(pièceNom, coordX, coordY);
    }

    public void jouerTour(int x ,int y){
        assert ((getCoordX() == x && getCoordY() != y) || (getCoordY() == y && getCoordX() != x));
        jouer(x,y);
    }

}
