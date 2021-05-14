package piece;


import partie.Coordonnées;
import table.Couleur;
import table.Plateau;

public class Roi extends Pièce { //un roi est une pièce


    public Roi(Coordonnées coordonnées, Couleur c) { //Pièce p = new Roi(1,1,Couleur.BLANC);
        super( c, coordonnées,"r");
    }

    public boolean coupLegal(Coordonnées coord, Plateau p) {

    boolean ok = ((getCoordonnées().getX() - coord.getX() <= 1 && getCoordonnées().getY() - coord.getY() <= 1) && (getCoordonnées().getY() - coord.getX() >= -1 && getCoordonnées().getY() - coord.getY() >= -1)) &&
            ( (coord.getX() - getCoordonnées().getX() <= 1 && coord.getY() - getCoordonnées().getY() <= 1) && (coord.getX() - getCoordonnées().getX() >= -1 && coord.getY() - getCoordonnées().getY() >= -1));
        if(!(coord.getX() > 0 && coord.getY() > 0 && coord.getX() < 7 && coord.getY() <7)){
            System.out.println("dehors");
            return false;
        }

        if(p.getPièce(coord) !=null && p.getPièce(coord).getCouleur() == this.getCouleur()){
            System.out.println("tu peux pas manger tes pions");
            return false;
        }else if(p.getPièce(coord) !=null && p.getPièce(coord).getCouleur() != this.getCouleur()){
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