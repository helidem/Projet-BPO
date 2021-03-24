package table;


public class Roi extends Pièces { //un roi est une pièce


    public Roi(char pièceNom, int coordX, int coordY) {
        super(pièceNom, coordX, coordY);
    }


    public void jouerRoi(int x, int y){
        System.out.println(getCoordX());
        assert ((getCoordX()-x <= 1 && getCoordY()-y <= 1 && getCoordY()-x >= -1 && getCoordY()-y >= -1)) ||  // vérifier le mouvement basic de Roi
                ((x-getCoordX() <=1 && y-getCoordY()<=1 && x-getCoordX() >= -1 && y-getCoordY() >= -1));
        assert (getCoordX()!=x || getCoordY()!=y); //imposible de rester surplace
        jouer(x,y);


        //super.jouer(x,y);
        //simulation()
        //isLegal()
        //echec()?
        //mat()? -> fin de la partie + désigner le gagnant
        //peutJouer()

    }

}
