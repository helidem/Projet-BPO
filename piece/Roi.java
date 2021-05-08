package piece;


import table.Type;

public class Roi extends Pièce { //un roi est une pièce

    Couleur c;

    public Roi(int coordX, int coordY, Couleur c) {
        super(coordX, coordY, c);
    }


    public boolean coupLegal(int x, int y) {
        return
                ((getCoordX() - x <= 1 && getCoordY() - y <= 1 && getCoordY() - x >= -1 && getCoordY() - y >= -1)) ||  // vérifier le mouvement basic de Roi
                        ((x - getCoordX() <= 1 && y - getCoordY() <= 1 && x - getCoordX() >= -1 && y - getCoordY() >= -1)) &&
                                (getCoordX() != x || getCoordY() != y); //imposible de rester surplace

    }
    public String type(){

        String s = "";
        return (c.name() == "BLANC") ? "R" : "r";
    }

   /* public Couleur getCouleur() {
        return c;
    }*/
}










//    public void jouerRoi(int x, int y){
//
//        assert ((getCoordX()-x <= 1 && getCoordY()-y <= 1 && getCoordY()-x >= -1 && getCoordY()-y >= -1)) ||  // vérifier le mouvement basic de Roi
//                ((x-getCoordX() <=1 && y-getCoordY()<=1 && x-getCoordX() >= -1 && y-getCoordY() >= -1));
//        assert (getCoordX()!=x || getCoordY()!=y); //imposible de rester surplace
        //jouer(x,y);


        //super.jouer(x,y);
        //simulation()
        //isLegal()
        //echec()?
        //mat()? -> fin de la partie + désigner le gagnant
        //peutJouer()





