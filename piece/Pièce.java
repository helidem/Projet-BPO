package piece;

import table.Type;

public class  Pièce implements IPIece {
    public enum Couleur {BLANC,NOIR}

    private int coordX;
    private int coordY;

    private int oldCoordX;
    private int oldCoordY;

    public Pièce(int coordX, int coordY){
        assert coordX > 0 && coordY > 0;
        assert coordX < 9 && coordY < 9;


        this.coordX = coordX;
        this.coordY = coordY;
    }

    public Pièce(){

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

    /*public void jouer( int coordX , int coordY){
        assert coordX > 0 && coordY > 0;
        assert coordX < 9 && coordY < 9;
        this.oldCoordX = this.coordX; //save old coordX and Y
        this.oldCoordY = this.coordY;
        this.coordX = coordX;
        this.coordY = coordY;

    }*/

    /*public char getSymbol(int coordX , int coordY){
        if(this.coordX == coordX || this.coordY == coordY) return this.pièceNom;
        return ' ';
    }*/

   /* public String getType(int coordX , int coordY){
        if((this.coordX == coordX || this.coordY == coordY)){
            if(this.couleur == Couleur.NOIR)
                return this.type.name();
            else
                return this.type.name().toUpperCase();
        }
        return " ";

    }*/


    public String type(){
        return null;
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

    /*
    *simuler : move() dans un clone du plateau, si c'est correct alors la modification s'apporte dans le vrai plaeau
    *
    *
    *
    * */
}
