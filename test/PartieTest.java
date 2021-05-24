package test;

import org.junit.jupiter.api.Test;
import partie.Coup;
import partie.Partie;
import table.Couleur;
import table.Plateau;
import static org.junit.jupiter.api.Assertions.*;

public class PartieTest {

    @Test
    void testChangerJoueur(){
        Partie partie = new Partie();
       assertEquals(partie.getJoueurCourant(),Couleur.BLANC );
       partie.changerJoueur();
       assertEquals(partie.getJoueurCourant(),Couleur.NOIR);
    }

}
