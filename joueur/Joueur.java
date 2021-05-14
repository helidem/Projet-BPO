package joueur;

import partie.Coup;
import partie.IJoueur;
import table.Couleur;
import piece.Pièce;

import java.util.ArrayList;

public abstract class Joueur implements IJoueur {
    private Couleur camp;
    private ArrayList<Pièce> joueurPièces = new ArrayList<Pièce>();

    public Joueur(){

    }

    public abstract Coup demanderCoup();
    //TODO : faire ne sorte que le programme demande un coup au joueur et retourne un coup. -> new Coup() à l'interieur?
    //TODO : convertir les chiffres en coups et creer une classe coordonnées

}
