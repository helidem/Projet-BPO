package piece;

import partie.Coordonnées;
import table.Couleur;
import table.Plateau;

public class Tour extends Pièce
{


    public Tour(Coordonnées coordonnées, Couleur c) {
        super(c,coordonnées,"t");
    }

    public boolean coupLegal(Coordonnées coord,Plateau p){

        boolean ok = (getCoordonnées().getX() == coord.getX() && getCoordonnées().getY() != coord.getY()) || (getCoordonnées().getY() == coord.getY() && getCoordonnées().getX() != coord.getX());

        if(!(coord.getX() > 0 && coord.getY() > 0 && coord.getX() < 7 && coord.getY() <7)){
            System.out.println("dehors");
            return false;
        }

        if(p.getPièce(coord) !=null && p.getPièce(coord).getCouleur() == this.getCouleur()){
            System.out.println("tu peux pas manger tes pions");
            return false;
        }

        if(ok)
        {
            if(getCoordonnées().getX() == coord.getX() && getCoordonnées().getY() !=coord.getY()){ //on bouge sur la mm colonne
                if(coord.getY() > getCoordonnées().getY()){ //on monte
                    System.out.println("on monte");
                    for(int i = getCoordonnées().getY();i<coord.getY();i++){
                        if(p.getPièce(coord.getX(),i) != null){
                            System.out.println("ostacle");
                            return false;
                        }
                    }
                }
                else if (coord.getY() < getCoordonnées().getY()){ //on descends
                    System.out.println("on descends");
                    for(int i = getCoordonnées().getY();i>coord.getY();i--){
                        if(p.getPièce(coord.getX(),i) != null){
                            System.out.println("ostacle");
                            return false;
                        }
                    }
                }
            }
            else  if(getCoordonnées().getX() != coord.getX() && getCoordonnées().getY() == coord.getY()){ //on bouge sur la mm ligne
                if(coord.getX() > getCoordonnées().getX()){ //on va vers la droite
                    System.out.println("on va vers la droite");
                    for(int i = getCoordonnées().getX();i<coord.getX();i++){
                        if(p.getPièce(i,coord.getY()) != null){
                            System.out.println("ostacle");
                            return false;
                        }
                    }
                }else if(coord.getX() < getCoordonnées().getX()){ //on va vers la gauche
                    System.out.println("on va vers la gauche");
                    for(int i = getCoordonnées().getX();i>coord.getX();i--){
                        if(p.getPièce(i,coord.getY()) != null){
                            System.out.println("ostacle");
                            return false;
                        }
                    }
                }
            }
        }else {
            System.out.println("erreur");
            return false;
        }
        return true;
    }
}