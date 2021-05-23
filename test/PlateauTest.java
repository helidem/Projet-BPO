package test;

import org.junit.jupiter.api.Test;
import partie.Coordonnées;
import piece.Roi;
import piece.Tour;
import table.Couleur;
import table.IPièce;
import table.Plateau;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlateauTest {

    @Test
    void testPut(){
        Plateau plateau = new Plateau();
        IPièce r = new Roi(new Coordonnées(3,4), Couleur.NOIR);
        IPièce t = new Tour(new Coordonnées(5,5),Couleur.NOIR);
        IPièce t1 = new Tour(new Coordonnées(1,1),Couleur.BLANC);
        plateau.put(r);
        plateau.put(t);
        plateau.put(t1);
        //Coup coup = new Coup(new Coordonnées(3,4),new Coordonnées(4,4)));
        assertTrue(plateau.caseOccupée(new Coordonnées(3,4)));
        assertTrue(plateau.caseOccupée(new Coordonnées(5,5)));
        assertTrue(plateau.caseOccupée(new Coordonnées(1,1)));
        assertFalse(plateau.caseOccupée(new Coordonnées(1,2)));
        assertFalse(plateau.caseOccupée(new Coordonnées(1,7)));
        //plateau.jouer(new Coup(new Coordonnées(3,4),new Coordonnées(1,1)));
    }

    @Test
    void testRemove(){
        Plateau plateau = new Plateau();
        IPièce r = new Roi(new Coordonnées(3,4), Couleur.NOIR);
        plateau.put(r);
        assertTrue(plateau.caseOccupée(new Coordonnées(3,4)));
        plateau.removePièce(r);
        assertFalse(plateau.caseOccupée(new Coordonnées(3,4)));
    }

    @Test
    void testJouer(){
        Plateau plateau = new Plateau();
        IPièce r = new Roi(new Coordonnées(3,4), Couleur.NOIR);

        plateau.put(r);

    }
}
