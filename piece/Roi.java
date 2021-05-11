package piece;


import table.Plateau;

public class Roi extends Pièce { //un roi est une pièce


    public Roi(int coordX, int coordY, Couleur c) { //Pièce p = new Roi(1,1,Couleur.BLANC);
        super(coordX, coordY, c, "r");
    }


    public boolean coupLegal(int x, int y, Plateau p) {

    boolean ok = (getCoordX() - x <= 1 && getCoordY() - y <= 1 && getCoordY() - x >= -1 && getCoordY() - y >= -1) ||
            (x - getCoordX() <= 1 && y - getCoordY() <= 1 && x - getCoordX() >= -1 && y - getCoordY() >= -1);

        if(!(x > 0 && y > 0 && x < 7 && y <7)){
            System.out.println("wow tu vas où là ??");
            return false;
        }

        if(p.getPièce(x,y) !=null && p.getPièce(x,y).getCouleur() == this.getCouleur()){
            System.out.println("tu peux pas manger tes pions wsh");
            return false;
        }

        if(ok){
            return true;
        }else{
            System.out.println("Mouvement impossible");
                    return false;
        }


    }


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





