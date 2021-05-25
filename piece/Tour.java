package piece;

import partie.Coordonnées;
import partie.Coup;
import partie.Partie;
import table.Couleur;
import table.Plateau;

import java.util.ArrayList;

public class Tour extends Pièce {
    public Tour(Coordonnées coordonnées, Couleur c) {
        super(c, coordonnées, "t");
    }

    /**
     * Savoir si un coup est légal
     * @param coord coordonnée de la pièce
     * @param p plateau
     * @return true si le coup est juste
     */
    public boolean coupLegal(Coordonnées coord, Plateau p) {

        boolean ok = (getCoordonnées().getX() == coord.getX() && getCoordonnées().getY() != coord.getY()) || (getCoordonnées().getY() == coord.getY() && getCoordonnées().getX() != coord.getX());

        if (!(coord.getX() >= 0 && coord.getY() >= 0 && coord.getX() <= 7 && coord.getY() <= 7)) {
            //System.out.println("dehors");
            return false;
        }

        if (p.getPièce(coord) != null && p.getPièce(coord).getCouleur() == this.getCouleur()) {
            //System.out.println("tu peux pas manger tes pions");
            return false;
        }

;        if (ok) {
            if (getCoordonnées().getX() == coord.getX() && getCoordonnées().getY() != coord.getY()) { //on bouge sur la mm colonne
                if (coord.getY() > getCoordonnées().getY()) { //on monte
                    //System.out.println("on monte");
                    for (int i = getCoordonnées().getY() + 1; i < coord.getY(); i++) {
                        if (p.caseOccupée(coord.getX(), i)){
                           // System.out.println("obstacle");
                            return false;
                        }
                    }
                } else if (coord.getY() < getCoordonnées().getY()) { //on descends
                    //System.out.println("on descends");
                    for (int i = getCoordonnées().getY() - 1; i > coord.getY(); i--) {
                        if (p.caseOccupée(coord.getX(), i)) {
                            //System.out.println("obstacle");
                            return false;
                        }
                    }
                }
            } else if (getCoordonnées().getX() != coord.getX() && getCoordonnées().getY() == coord.getY()) { //on bouge sur la mm ligne
                if (coord.getX() > getCoordonnées().getX()) { //on va vers la droite
                    //System.out.println("on va vers la droite");
                    for (int i = getCoordonnées().getX() + 1; i < coord.getX(); i++) {
                        if (p.caseOccupée(i, coord.getY())) {
                            //System.out.println("obstacle");
                            return false;
                        }
                    }
                } else if (coord.getX() < getCoordonnées().getX()) { //on va vers la gauche
                    //System.out.println("on va vers la gauche");
                    for (int i = getCoordonnées().getX() - 1; i > coord.getX(); i--) {
                        if (p.caseOccupée(i, coord.getY())) {
                            //System.out.println("obstacle");
                            return false;
                        }
                    }
                }
            }
        } else {
            //System.out.println("erreur");
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public boolean craintEchec() {
        return false;
    }

    @Override
    public boolean enEchec(Plateau p) {
        return false;
    }

    @Override
    public boolean enEchecEtMat(Plateau p, Partie partie) {
        return false;
    }

    @Override
    public Coordonnées getAncienneCoord() {
        return null;
    }

    public ArrayList<Coup> coupsPossibles(Plateau p){
        Coup coup = new Coup();
        ArrayList<Coup> coups = new ArrayList<>();

        Coordonnées coord = new Coordonnées(getCoordonnées().getX()+1,getCoordonnées().getY());//vers la droite

        coup.setCoord(getCoordonnées(),coord);
        while(coord.getX() <8&& coord.getX() >=0&&coord.getY()<8&&coord.getY()>=0 && coupLegal(coord,p)){
            coups.add(new Coup(getCoordonnées(),new Coordonnées(coord.getX(), coord.getY())));
            coord.setX(coord.getX()+1);
        }


        coord.setX(getCoordonnées().getX()-1);//vers la gauche
        coup.setCoord(getCoordonnées(),coord);
        while(coord.getX() <8&& coord.getX() >=0&&coord.getY()<8&&coord.getY()>=0 && coupLegal(coord,p)){
            coups.add(new Coup(getCoordonnées(),new Coordonnées(coord.getX(), coord.getY())));
            coord.setX(coord.getX()-1);
        }

        coord.setX(getCoordonnées().getX());//on reste sur la meme ligne
        coord.setY(getCoordonnées().getY()+1);//mais on va vers le haut
        coup.setCoord(getCoordonnées(),coord);
        while(coord.getX() <8&& coord.getX() >=0&&coord.getY()<8&&coord.getY()>=0 && coupLegal(coord,p)){
            coups.add(new Coup(getCoordonnées(),new Coordonnées(coord.getX(), coord.getY())));
            coord.setY(coord.getY()+1);
        }

        coord.setY(getCoordonnées().getY()-1);//vers le bas
        coup.setCoord(getCoordonnées(),coord);
        while(coord.getX() <8&& coord.getX() >=0&&coord.getY()<8&&coord.getY()>=0 && coupLegal(coord,p)){
            coups.add(new Coup(getCoordonnées(),new Coordonnées(coord.getX(), coord.getY())));
            coord.setY(coord.getY()-1);
        }

        return coups;

    }

}