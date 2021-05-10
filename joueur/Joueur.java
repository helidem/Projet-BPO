package joueur;

import partie.IJoueur;
import piece.Pièce;

import java.util.ArrayList;

public abstract class Joueur implements IJoueur {
    private ArrayList<Pièce> joueurPièces = new ArrayList<Pièce>();

    public Joueur(){

    }

    public abstract String demanderCoup();

}
