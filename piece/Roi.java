package piece;


import table.Plateau;

public class Roi extends Pièce { //un roi est une pièce


    public Roi(int coordX, int coordY, Couleur c) { //Pièce p = new Roi(1,1,Couleur.BLANC);
        super(coordX, coordY, c, "r");
    }


    /**
     *
     * @param x coord x de la case cible
     * @param y coord y de la case cible
     * @param p le plateau
     * @return true si le coup est legal
     */
    public boolean coupLegal(int x, int y, Plateau p) {

    boolean ok = ((getCoordX() - x <= 1 && getCoordY() - y <= 1) && (getCoordY() - x >= -1 && getCoordY() - y >= -1)) &&
            ( (x - getCoordX() <= 1 && y - getCoordY() <= 1) && (x - getCoordX() >= -1 && y - getCoordY() >= -1));
        if(!(x > 0 && y > 0 && x < 7 && y <7)){
            System.out.println("wow tu vas où là ??");
            return false;
        }

        if(p.getPièce(x,y) !=null && p.getPièce(x,y).getCouleur() == this.getCouleur()){
            System.out.println("tu peux pas manger tes pions wsh");
            return false;
        }else if(p.getPièce(x,y) !=null && p.getPièce(x,y).getCouleur() != this.getCouleur()){
            System.out.println("tu vas manger une pièce");
            //manger(x,y,p);
        }

        if(ok){
            return true;
        }else{
            System.out.println("Mouvement impossible");
                    return false;
        }


    }

    //TODO : regarder si le roi est en echec



}