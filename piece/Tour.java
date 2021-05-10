package piece;

import table.Plateau;

public class Tour extends Pièce
{


    public Tour(int coordX, int coordY, Couleur c) {
        super(coordX, coordY, c, "t");
    }

    public boolean coupLegal(int x, int y, Plateau p){

        boolean ok = (getCoordX() == x && getCoordY() != y) || (getCoordY() == y && getCoordX() != x);

        //si x > getCoordX() alors il va vers la droite blabla



        if(p.getPièce(x,y) !=null && p.getPièce(x,y).getCouleur() == this.getCouleur()){
            System.out.println("meme couleur");
            return false;
        }


        if(ok)
        {
            if(getCoordX() == x && getCoordY() != y){ //on bouge sur la mm colonne
                if(y > getCoordY()){ //on descend
                    for(int i = getCoordY();i<y;i++){
                        if(p.getPièce(x,i) != null){
                            System.out.println("obstacle triggered");
                            return false;
                        }
                    }
                }
            }
        }else {
            System.out.println("pas ok, va savoir pk");
            return false;
        }

        return true;
    }

}
