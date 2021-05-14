package partie;

import joueur.Humain;
import joueur.Joueur;
import piece.Couleur;

public class Partie {
    private IJoueur[] joueurs;
    private Couleur courant;

public Partie(){
    joueurs = new Humain[Couleur.values().length];
    joueurs[Couleur.BLANC.ordinal()] = new Humain();
    joueurs[Couleur.NOIR.ordinal()] = new Humain();

    courant = Couleur.BLANC;
}

    public Couleur getJoueurCourant(){
    return courant;
    }

    public Couleur getJoueurAdverse(){
        return Couleur.values()[Math.abs(1 - courant.ordinal())];
    }

    public void changerJoueur(){
        courant = getJoueurAdverse();
    }

    public String toString(){
        return courant.name();
    }

}
