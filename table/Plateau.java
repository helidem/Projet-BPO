package table;


import piece.Pièce;
import java.util.ArrayList;

public class Plateau {

    public static final int lignes = 8;
    public static final int colonnes = 8;



    private Pièce[][] plateau;

    private ArrayList<Pièce> pièceNoir; //a enlever t mettre dans joueur
    private ArrayList<Pièce> pièceBlanc;

    /**
     * Constructeur de la classe Plateau
     */
    public Plateau() {
        plateau = new Pièce[lignes][colonnes];
    }

    public void jouerPièce(int actuelCoordX, int actuelCoordY, int coordX ,int coordY){ //interessant
        assert coordX > 0 && coordY > 0 && actuelCoordX > 0 && actuelCoordY > 0;
        assert coordX < 9 && coordY < 9 && actuelCoordX < 9 && actuelCoordY < 9;
        for (Pièce p : pièceNoir){
            if(p.getCoordX() == actuelCoordX && p.getCoordY() == actuelCoordY ){

                jouer(p,coordX,coordY);
            }
        }
        // Une exception si on trouve pas la pièce
     }

    public void jouer(Pièce p, int coordX, int coordY)
    {
        //faire les tests
        //memorise(p);


        System.out.println(p.getCoordX() + " " + p.getCoordY());

        if (p.coupLegal(coordX, coordY, this) == false)
            return;

        put(p, coordX, coordY);
        removePièce(p);
    }

    public Pièce getPièce(int x,int y){
        return plateau[x][y];
    }


    private void memorise(Pièce p)
    {
        p.setOldCoordX(p.getCoordX());
        p.setOldCoordY(p.getCoordY());
    }

    /**
     * Place une pièce dans le plateau
     * @param p la pièce à mettre
     * @param coordX la coordonnée X de la case désirée
     * @param coordY la coordonnée Y de la case désirée
     */
    public void put(Pièce p, int coordX, int coordY)
    {
        p.setCoordX(coordX);
        p.setCoordY(coordY);
        plateau[p.getCoordX()][p.getCoordY()] = p;
    }

    private void removePièce(Pièce p) { plateau[p.getCoordX()][p.getCoordY()] = null; }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("    a   b   c   d   e   f   g   h    \n");
        s.append("   --- --- --- --- --- --- --- ---\n");

        for (int l=lignes-1 ; l>=0 ; --l ){
            s.append(l+1 + " | ");
            for(int c=0 ; c<colonnes ; ++c){
                if (plateau[c][l] != null)
                    s.append(plateau[c][l].type());
                else s.append(" ");
                s.append(" | ");
            }
            s.append(l+1).append("\n");
            s.append("   --- --- --- --- --- --- --- ---\n");
        }
        s.append("    a   b   c   d   e   f   g   h    \n");
        return s.toString();
    }
}