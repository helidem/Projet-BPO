package test;

import Application.PieceFactory;
import org.junit.jupiter.api.Test;
import partie.Coordonnées;
import partie.Coup;
import partie.Partie;
import table.Couleur;
import table.IPièce;
import table.Plateau;

import static org.junit.jupiter.api.Assertions.*;

public class PlateauTest {

    @Test
    void testPut() {
        PieceFactory pf = new PieceFactory();
        Plateau plateau = new Plateau();
        IPièce r = pf.getRoi(3, 4, Couleur.NOIR);
        IPièce t = pf.getTour(5, 5, Couleur.NOIR);
        IPièce t1 = pf.getTour(1, 1, Couleur.BLANC);
        plateau.put(r);
        plateau.put(t);
        plateau.put(t1);
        //Coup coup = new Coup(new Coordonnées(3,4),new Coordonnées(4,4)));
        assertTrue(plateau.caseOccupée(new Coordonnées(3, 4)));
        assertTrue(plateau.caseOccupée(new Coordonnées(5, 5)));
        assertTrue(plateau.caseOccupée(new Coordonnées(1, 1)));
        assertFalse(plateau.caseOccupée(new Coordonnées(1, 2)));
        assertFalse(plateau.caseOccupée(new Coordonnées(1, 7)));
        //plateau.jouer(new Coup(new Coordonnées(3,4),new Coordonnées(1,1)));
    }

    @Test
    void testRemove() {
        PieceFactory pf = new PieceFactory();
        Plateau plateau = new Plateau();
        IPièce r = pf.getRoi(3, 4, Couleur.NOIR);
        plateau.put(r);
        assertTrue(plateau.caseOccupée(new Coordonnées(3, 4)));
        plateau.removePièce(r);
        assertFalse(plateau.caseOccupée(new Coordonnées(3, 4)));
    }

    @Test
    void testAnnulerCoup() {

        Partie partie = new Partie();
        Plateau p = new Plateau();
        PieceFactory pf = new PieceFactory();
        IPièce r = pf.getRoi(1, 1, Couleur.BLANC);
        IPièce r2 = pf.getRoi(2, 5, Couleur.NOIR);
        p.put(r);
        p.put(r2);
        assertTrue(p.jouer(new Coup(r.getCoordonnées(), new Coordonnées(1, 2)), partie));
        p.annulerCoup(r);
        assertTrue(r.getCoordonnées().getY() == new Coordonnées(1, 1).getY());
        assertTrue(p.caseOccupée(new Coordonnées(1, 1)));
        assertTrue(r.getCoordonnées().getX() == new Coordonnées(1, 1).getX());
        assertTrue(r.getCoordonnées().getY() == new Coordonnées(1, 1).getY());
    }

    @Test
    void testJouer() {
        Partie partie = new Partie();
        Plateau p = new Plateau();
        PieceFactory pf = new PieceFactory();
        IPièce r = pf.getRoi(6, 7, Couleur.NOIR);
        IPièce r1 = pf.getRoi(6, 3, Couleur.BLANC);
        p.put(r);
        p.put(r1);
        assertTrue(p.jouer(new Coup(r.getCoordonnées(), new Coordonnées(6, 6)), partie));
        assertTrue(p.caseOccupée(new Coordonnées(6, 6)));
        assertFalse(p.caseOccupée(new Coordonnées(6, 7)));
        assertEquals(r.getCoordonnées().getX(), new Coordonnées(6, 6).getX());

        assertFalse(p.jouer(new Coup(r1.getCoordonnées(), new Coordonnées(6, 9)), partie));
        assertFalse(p.caseOccupée(new Coordonnées(6, 7)));
        assertTrue(p.caseOccupée(new Coordonnées(6, 3)));
        assertEquals(r1.getCoordonnées().getX(), new Coordonnées(6, 3).getX());
    }

    @Test
    void testToString() {
        Plateau p = new Plateau();
        String s = "    a   b   c   d   e   f   g   h    \n" +
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
                "    a   b   c   d   e   f   g   h    \n";
        assertEquals(p.toString(), s);

        PieceFactory pf = new PieceFactory();
        pf.defaut(p);

        String s2 = "    a   b   c   d   e   f   g   h    \n" +
                "   --- --- --- --- --- --- --- ---\n" +
                "8 |   |   |   |   | r |   |   |   | 8\n" +
                "   --- --- --- --- --- --- --- ---\n" +
                "7 |   | T |   |   |   |   |   |   | 7\n" +
                "   --- --- --- --- --- --- --- ---\n" +
                "6 |   |   |   |   | R |   |   |   | 6\n" +
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
                "    a   b   c   d   e   f   g   h    \n";
        assertEquals(s2, p.toString());
    }
}