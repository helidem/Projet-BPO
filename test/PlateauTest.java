package test;

import org.junit.jupiter.api.Test;
import partie.Coordonnées;
import partie.Coup;
import partie.Partie;
import piece.Roi;
import piece.Tour;
import table.Couleur;
import table.IPièce;
import table.Plateau;

import static org.junit.jupiter.api.Assertions.*;

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
    void testAnnulerCoup(){
        Partie partie = new Partie();
        Plateau p = new Plateau();
        IPièce r = new Roi(new Coordonnées(1,1),Couleur.BLANC);
        IPièce r2 = new Roi(new Coordonnées(2,5), Couleur.NOIR);
        p.put(r);
        p.put(r2);
        assertTrue(p.jouer(new Coup(r.getCoordonnées(),new Coordonnées(1,2)),partie));
        p.annulerCoup(r);
        assertTrue(r.getCoordonnées().getY () == new Coordonnées(1,1).getY());
        assertTrue(p.caseOccupée(new Coordonnées(1,1)));
        assertTrue(r.getCoordonnées().getX() == new Coordonnées(1,1).getX());
        assertTrue(r.getCoordonnées().getY() == new Coordonnées(1,1).getY());
    }

    @Test
    void testJouer(){
        Partie partie = new Partie();
        Plateau p = new Plateau();
        IPièce r = new Roi(new Coordonnées(6 ,7),Couleur.NOIR);
        IPièce r1 = new Roi(new Coordonnées(6,3),Couleur.BLANC);
        p.put(r);
        p.put(r1);
        assertTrue(p.jouer(new Coup(new Coordonnées(6,7), new Coordonnées(6,6)),partie));
        assertTrue(p.caseOccupée(new Coordonnées(6,6)));
        assertFalse(p.caseOccupée(new Coordonnées(6,7)));
        assertEquals(r.getCoordonnées().getX(), new Coordonnées(6,6).getX());

        assertFalse(p.jouer(new Coup(new Coordonnées(6,3), new Coordonnées(6,9)),partie));
        assertFalse(p.caseOccupée(new Coordonnées(6,7)));
        assertTrue(p.caseOccupée(new Coordonnées(6,3)));
        assertEquals(r1.getCoordonnées().getX(), new Coordonnées(6,3).getX());
    }

    @Test
    void testToString(){
        Plateau p = new Plateau();
        String s = new String("    a   b   c   d   e   f   g   h    \n" +
                "   --- --- --- --- --- --- --- ---\n" +
                "8 |   |   |   |   |   |   |   |   | 8\n" +
                "   --- --- --- --- --- --- --- ---\n" +
                "7 |   |   |   |   |   |   |   |   | 7\n" +
                "   --- --- --- --- --- --- --- ---\n" +
                "6 |   |   |   |   |   |   |   |   | 6\n" +
                "   --- --- --- --- --- --- --- ---\n" +
                "5 |   |   |   |   |   |   |   |   | 5\n" +
                "   --- --- --- --- --- --- --- ---\n" +
                "4 |   |   |   |   |   |   |   |   | 4\n" +
                "   --- --- --- --- --- --- --- ---\n" +
                "3 |   |   |   |   |   |   |   |   | 3\n" +
                "   --- --- --- --- --- --- --- ---\n" +
                "2 |   |   |   |   |   |   |   |   | 2\n" +
                "   --- --- --- --- --- --- --- ---\n" +
                "1 |   |   |   |   |   |   |   |   | 1\n" +
                "   --- --- --- --- --- --- --- ---\n" +
                "    a   b   c   d   e   f   g   h    ");
        assertEquals(p.toString(),s);


    }
}
