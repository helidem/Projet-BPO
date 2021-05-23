package piece;


import partie.Coordonnées;
import partie.Coup;
import partie.Partie;
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
        if(!(coord.getX() >= 0 && coord.getY() >= 0 && coord.getX() <= 7 && coord.getY() <=7)){
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

    public boolean enEchecEtMat(Plateau p, Partie partie){
        ArrayList<IPièce> pièces = p.pièces(getCouleur());
        for(int pièce = 0; pièce< pièces.size();pièce++){
            ArrayList<Coup> coups = pièces.get(pièce).coupsPossibles(p);

            for(Coup coup : coups){
                if(p.jouer(coup,partie)){
                    if(!this.enEchec(p))
                }
            }
        }


    }

    public ArrayList<Coup> coupsPossibles(Plateau p){
        Coup coup = new Coup();
        ArrayList<Coup> coups = new ArrayList<>();

        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX()-1,getCoordonnées().getY()+1));
        System.out.println(coup);
        if(coupLegal(coup.getArrivée(),p)){
            System.out.println("added");
            coups.add(coups.size(), coup);
        }
        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX(),getCoordonnées().getY()+1));
        System.out.println(coup);
        if(coupLegal(coup.getArrivée(),p)){
            System.out.println("added");
            coups.add(new Coup(coup.getDépart(),coup.getArrivée()));

        }
        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX()+1,getCoordonnées().getY()+1));
        System.out.println(coup);
        if(coupLegal(coup.getArrivée(),p)){
            coups.add(new Coup(coup.getDépart(),coup.getArrivée()));
            System.out.println("added");
        }
        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX()+1,getCoordonnées().getY()));
        System.out.println(coup);
        if(coupLegal(coup.getArrivée(),p)){
            coups.add(new Coup(coup.getDépart(),coup.getArrivée()));
            System.out.println("added");
        }
        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX()+1,getCoordonnées().getY()-1));
        System.out.println(coup);
        if(coupLegal(coup.getArrivée(),p)){
            coups.add(new Coup(coup.getDépart(),coup.getArrivée()));
            System.out.println("added");
        }
        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX(),getCoordonnées().getY()-1));
        System.out.println(coup);
        if(coupLegal(coup.getArrivée(),p)){
            coups.add(new Coup(coup.getDépart(),coup.getArrivée()));
            System.out.println("added");
        }
        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX()-1,getCoordonnées().getY()-1));
        System.out.println(coup);
        if(coupLegal(coup.getArrivée(),p)){
            coups.add(new Coup(coup.getDépart(),coup.getArrivée()));
            System.out.println("added");
        }
        coup.setCoord(getCoordonnées(),new Coordonnées(getCoordonnées().getX()-1,getCoordonnées().getY()));
        System.out.println(coup);
        if(coupLegal(coup.getArrivée(),p)){
            coups.add(new Coup(coup.getDépart(),coup.getArrivée()));
            System.out.println("added");
        }
        return coups;
    }


}