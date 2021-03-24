package table;

public class Pièces {

    private char pièceNom;
    private int coordX;
    private int coordY;

    private int oldCoordX;
    private int oldCoordY;

    public Pièces(char pièceNom , int coordX, int coordY){
        assert coordX > 0 && coordY > 0;
        assert coordX < 9 && coordY < 9;
        this.pièceNom = pièceNom;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public Pièces() {

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

    public void jouer( int placementX , int placementY){
        assert placementX > 0 && placementY > 0;
        assert placementX < 9 && placementY < 9;
        this.oldCoordX = this.coordX; //save old coordX and Y
        this.oldCoordY = this.coordY;
        this.coordX = placementX;
        this.coordY = placementY;

    }

    public char getSympole(int coordX , int coordY){
        if(this.coordX == coordX || this.coordY == coordY) return this.pièceNom;
        return ' ';
    }


    /*
    *simuler : move() dans un clone du plateau, si c'est correct alors la modification s'apporte dans le vrai plaeau
    *
    *
    *
    * */
}
