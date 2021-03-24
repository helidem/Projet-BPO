package table;

public class Plateau {
    public static final int lignes = 8;
    public static final int colonnes = 8;

    private final Pièces[][] plateau;

    /**
     * Constructeur de la classe Plateau
     */
    public Plateau() {
        plateau = new Pièces[lignes+1][colonnes+1];
        for (int l=lignes ; l>0 ; --l ){
            for(int c=1 ; c<=colonnes ; ++c){
                plateau[l][c] = new Pièces();
            }
        }
    }


    public void putPièce(Pièces p){
        plateau[p.getCoordX()][p.getCoordY()] = p;
    }

    public void removePièce(Pièces p) { plateau[p.getCoordX()][p.getCoordY()] = new Pièces(); }

    public String toString(){

        StringBuilder s = new StringBuilder();
        s.append("    a   b   c   d   e   f   g   h    \n");
        s.append("   --- --- --- --- --- --- --- ---\n");

        for (int l=lignes ; l>0 ; --l ){
            s.append(l + " | ");
            for(int c=1 ; c<=colonnes ; ++c){
                s.append(plateau[c][l].getSympole(c,l));
                s.append(" | ");
            }

            s.append(l).append("\n");
            s.append("   --- --- --- --- --- --- --- ---\n");
        }
        //s.append("   --- --- --- --- --- --- --- ---      \n");
        s.append("    a   b   c   d   e   f   g   h    \n");

        return s.toString();
    }


}
