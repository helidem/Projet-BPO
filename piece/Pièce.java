package piece;

import partie.Coordonnées;
import partie.Coup;
import partie.Partie;
import table.Couleur;
import table.IPièce;
import table.Plateau;

import java.util.ArrayList;

public abstract class  Pièce implements IPièce {

    private Couleur couleur;
    private Coordonnées coordonnées;
    private String type;

    public Pièce(Couleur couleur, Coordonnées coordonnées, String type) {
        this.couleur = couleur;
        this.coordonnées = coordonnées;
        this.type = type;
    }

    public Coordonnées getCoordonnées() {
        return coordonnées;
    }

    public void setCoordonnées(Coordonnées coordonnées) {
        this.coordonnées = coordonnées;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public abstract boolean coupLegal(Coordonnées coordonnées, Plateau p);

    public abstract boolean craintEchec();

    public boolean verifierEchec(){
        return false;
    }

    public String type(){
        return (couleur == Couleur.BLANC) ? type.toUpperCase() : type;
    }
    public abstract boolean enEchec(Plateau p);

    public ArrayList<Coup> coupsPossibles(Plateau p){ //coups possibles des pieces du joueur courant
       for(IPièce pièce : p.pièces()){

       }
    }


}