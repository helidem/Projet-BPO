package piece;

import table.Plateau;

public class Tour extends Pièce
{


    public Tour(int coordX, int coordY, Couleur c) {
        super(coordX, coordY, c, "t");
    }

    public boolean coupLegal(int x, int y, Plateau p){

        boolean ok = (getCoordX() == x && getCoordY() != y) || (getCoordY() == y && getCoordX() != x);

        if(!(x > 0 && y > 0 && x < 7 && y <7)){
            System.out.println("wow tu vas où là ??");
            return false;
        }


        if(p.getPièce(x,y) !=null && p.getPièce(x,y).getCouleur() == this.getCouleur()){
            System.out.println("tu peux pas manger tes pions wsh");
            return false;
        }


        if(ok)
        {
            if(getCoordX() == x && getCoordY() != y){ //on bouge sur la mm colonne
                if(y > getCoordY()){ //on monte
                    System.out.println("on monte");
                    for(int i = getCoordY();i<y;i++){
                        if(p.getPièce(x,i) != null){
                            System.out.println("doucement abruti ya un ostacle");
                            return false;
                        }
                    }
                }
                else if (y < getCoordY()){ //on descends
                    System.out.println("on descends");
                    for(int i = getCoordY();i>y;i--){
                        if(p.getPièce(x,i) != null){
                            System.out.println("doucement abruti ya un ostacle");
                            return false;
                        }
                    }
                }
            }
            else  if(getCoordX() != x && getCoordY() == y){ //on bouge sur la mm ligne
                if(x > getCoordX()){ //on va vers la droite
                    System.out.println("on va vers la droite");
                    for(int i = getCoordX();i<x;i++){
                        if(p.getPièce(i,y) != null){
                            System.out.println("doucement abruti ya un ostacle");
                            return false;
                        }
                    }
                }else if(x < getCoordX()){ //on va vers la gauche
                    System.out.println("on va vers la gauche");
                    for(int i = getCoordX();i>x;i--){
                        if(p.getPièce(i,y) != null){
                            System.out.println("doucement abruti ya un ostacle");
                            return false;
                        }
                    }
                }
            }
        }else {
            System.out.println("t'es con tu peux pas");
            return false;
        }

        return true;
    }

}
