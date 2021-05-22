package piece;


import partie.Coordonnées;
import partie.Coup;
import table.Couleur;
import table.IPièce;
import table.Plateau;

import java.util.ArrayList;

public class Roi extends Pièce { //un roi est une pièce

    private boolean enDanger;
    private Coordonnées ancienneCoord;

    public Roi(Coordonnées coordonnées, Couleur c) { //Pièce p = new Roi(1,1,Couleur.BLANC);
        super( c, coordonnées,"r");
        this.enDanger = false;
    }

    public boolean coupLegal(Coordonnées coord, Plateau p) {

    boolean ok = ((getCoordonnées().getX() - coord.getX() <= 1 && getCoordonnées().getY() - coord.getY() <= 1) && (getCoordonnées().getY() - coord.getX() >= -1 && getCoordonnées().getY() - coord.getY() >= -1)) &&
            ( (coord.getX() - getCoordonnées().getX() <= 1 && coord.getY() - getCoordonnées().getY() <= 1) && (coord.getX() - getCoordonnées().getX() >= -1 && coord.getY() - getCoordonnées().getY() >= -1));
        if(!(coord.getX() > 0 && coord.getY() > 0 && coord.getX() < 7 && coord.getY() <7)){
            System.out.println("dehors");
            return false;
        }

        if(p.caseOccupée(coord) && p.getPièce(coord).getCouleur() == this.getCouleur()){
            System.out.println("tu peux pas manger tes pions");
            return false;
        }else if(p.caseOccupée(coord) && p.getPièce(coord).getCouleur() != this.getCouleur()){
            System.out.println("tu vas manger une pièce");

        }

        if(ok){
            return true;
        }else{
            System.out.println("Mouvement impossible");
                    return false;
        }

        }

    public boolean craintEchec(){
        return true;

    }

    public Coordonnées getAncienneCoord() {
        return ancienneCoord;
    }

    public void setAncienneCoord(Coordonnées ancienneCoord) {
        this.ancienneCoord = ancienneCoord;
    }

    /**
     * Regarde si le roi est en échec
     * @param p le plateau
     * @return true si le Roi est en echec
     */
    public boolean enEchec(Plateau p){
        ArrayList<IPièce> pièces = p.pièces();
        for(IPièce pièce : pièces){
            if(pièce.coupLegal(this.getCoordonnées(),p)){
                if(!this.getCouleur().equals(pièce.getCouleur())){
                    System.out.println("en echec");
                    return true;
                }
            }
        }
        System.out.println("pas en echec");
        return false;
    }

    public ArrayList<Coup> coupsPossibles(Plateau p){
        Coup coup = new Coup();
        ArrayList<Coup> coups = new ArrayList<>();

        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX()-1,getCoordonnées().getY()+1));
        if(coupLegal(coup.getArrivée(),p)){
            coups.add(coup);
        }
        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX(),getCoordonnées().getY()+1));
        if(coupLegal(coup.getArrivée(),p)){
            coups.add(coup);
        }
        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX()+1,getCoordonnées().getY()+1));
        if(coupLegal(coup.getArrivée(),p)){
            coups.add(coup);
        }
        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX()+1,getCoordonnées().getY()));
        if(coupLegal(coup.getArrivée(),p)){
            coups.add(coup);
        }
        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX()+1,getCoordonnées().getY()-1));
        if(coupLegal(coup.getArrivée(),p)){
            coups.add(coup);
        }
        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX(),getCoordonnées().getY()-1));
        if(coupLegal(coup.getArrivée(),p)){
            coups.add(coup);
        }
        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX()-1,getCoordonnées().getY()-1));
        if(coupLegal(coup.getArrivée(),p)){
            coups.add(coup);
        }
        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX()-1,getCoordonnées().getY()));
        if(coupLegal(coup.getArrivée(),p)){
            coups.add(coup);
        }
        return coups;
    }
    public String afficherCoups(Plateau p){
        StringBuilder sb = new StringBuilder();
        for(Coup coup : coupsPossibles(p)){
            sb.append(coup.getArrivée().getX()).append(";").append(coup.getArrivée().getY()).append("\n");
        }
    }
}