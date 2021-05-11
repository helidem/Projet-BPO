package piece;

import table.IPièce;
import table.Plateau;

public abstract class  Pièce implements IPièce {


    private Couleur couleur;
    private int coordX;
    private int coordY;

    private int oldCoordX;
    private int oldCoordY;

    private String type;

    public Pièce(int coordX, int coordY, Couleur couleur, String t){
        assert coordX > 0 && coordY > 0;
        assert coordX < 9 && coordY < 9;


        this.coordX = coordX;
        this.coordY = coordY;
        this.couleur = couleur;
        this.type = t;
    }


    public int getCoordX(){
        return this.coordX;
    }

    public int getCoordY(){
        return this.coordY;
    }

    public int getOldCoordX(){
        return this.oldCoordX;
    }

    public int getOldCoordY(){
        return this.oldCoordY;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public void setOldCoordX(int oldCoordX) {
        this.oldCoordX = oldCoordX;
    }

    public void setOldCoordY(int oldCoordY) {
        this.oldCoordY = oldCoordY;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public abstract boolean coupLegal(int x, int y, Plateau p);

    public String type(){
        return (couleur == Couleur.BLANC) ? type.toUpperCase() : type;
    }

    private void manger(int x, int y, Plateau p){

    }
}
