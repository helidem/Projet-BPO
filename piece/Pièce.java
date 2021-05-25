package piece;

import partie.Coordonnées;
import partie.Coup;
import table.Couleur;
import table.IPièce;
import table.Plateau;
import java.util.ArrayList;

public abstract class  Pièce implements IPièce {

    private Couleur couleur;
    private Coordonnées coordonnées;
    private Coordonnées ancienneCoord;
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

    public String type(){
        return (couleur == Couleur.BLANC) ? type.toUpperCase() : type;
    }

    public abstract boolean enEchec(Plateau p);

    /**
     * Permet d'afficher la liste des coups possibles de la pièce
     * @param p el plateau
     * @return la chaine de caractère représentant la liste des coups
     */
   public String afficherCoups(Plateau p){
       StringBuilder sb = new StringBuilder();
       System.out.println(coupsPossibles(p).size());
       ArrayList<Coup> coups = coupsPossibles(p);
       for(Coup coup : coups){
           sb.append(coup.toString()).append("\n");
       }
       return sb.toString();
   }

    public Coordonnées getAncienneCoord() {
        return ancienneCoord;
    }

    public void memoriser() {
        this.ancienneCoord = coordonnées;
    }

    public void annulerCoup(){
       setCoordonnées(getAncienneCoord());
    }

    public abstract ArrayList<Coup> coupsPossibles(Plateau p);
}