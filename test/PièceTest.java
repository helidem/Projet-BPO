package test;

import org.junit.jupiter.api.Test;
import partie.Coordonnées;
import partie.Coup;
import partie.Partie;
import piece.Pièce;
import piece.Roi;
import piece.Tour;
import table.Couleur;
import table.IPièce;
import table.Plateau;

import static org.junit.jupiter.api.Assertions.*;

class PièceTest {

        @Test
        void testCoupLegal(){

            Pièce p = new Roi(new Coordonnées(1,1),Couleur.BLANC);
            Plateau pla = new Plateau();
            pla.put(p);
            assertFalse(p.coupLegal(new Coordonnées(-1,-1),pla));
            assertTrue(p.coupLegal(new Coordonnées(2,1),pla));
            assertTrue(p.coupLegal(new Coordonnées(1,2),pla));
            assertTrue(p.coupLegal(new Coordonnées(2,2),pla));
            pla.put(p,new Coordonnées(5,5));
            assertFalse(p.coupLegal(new Coordonnées(5,5),pla));
            assertTrue(p.coupLegal(new Coordonnées(6,5),pla));
            assertTrue(p.coupLegal(new Coordonnées(4,5),pla));
            assertTrue(p.coupLegal(new Coordonnées(5,6),pla));
            assertTrue(p.coupLegal(new Coordonnées(6,6),pla));
            assertTrue(p.coupLegal(new Coordonnées(4,6),pla));
            assertTrue(p.coupLegal(new Coordonnées(5,4),pla));
            assertTrue(p.coupLegal(new Coordonnées(6,4),pla));
            assertTrue(p.coupLegal(new Coordonnées(4,4),pla));

            Plateau plateau = new Plateau();
            Pièce t = new Tour(new Coordonnées(5,5), Couleur.NOIR);
            plateau.put(t);
            assertFalse(t.coupLegal(new Coordonnées(10,10),plateau));
            assertTrue(t.coupLegal(new Coordonnées(1,5),plateau));
            assertTrue(t.coupLegal(new Coordonnées(2,5),plateau));
            assertTrue(t.coupLegal(new Coordonnées(3,5),plateau));
            assertTrue(t.coupLegal(new Coordonnées(4,5),plateau));
            assertFalse(t.coupLegal(new Coordonnées(5,5),plateau));
            assertTrue(t.coupLegal(new Coordonnées(6,5),plateau));
            assertTrue(t.coupLegal(new Coordonnées(7,5),plateau));
            assertFalse(t.coupLegal(new Coordonnées(8,5),plateau));
        }

       @Test
        void testGetCoordonnées(){
            IPièce r = new Roi(new Coordonnées(3,3),Couleur.NOIR);
            Coordonnées c = new Coordonnées(3,3);
            Coordonnées c1 = new Coordonnées(89,22);
            assertEquals(r.getCoordonnées().getX(), c.getX());
            assertEquals(r.getCoordonnées().getY(), c.getY());
            assertNotEquals(r.getCoordonnées().getX(), c1.getX());

        }

        @Test
        void testGetCouleur(){
            IPièce r = new Roi(new Coordonnées(3,3),Couleur.NOIR);
            assertEquals(Couleur.NOIR,r.getCouleur());
            assertNotEquals(Couleur.BLANC, r.getCouleur());
        }

        @Test
        void testSetCoordonnées(){
            IPièce r = new Roi(new Coordonnées(5,5),Couleur.NOIR);
            Coordonnées c = new Coordonnées(5,5);
            assertEquals(r.getCoordonnées().getX(), c.getX());
            assertEquals(r.getCoordonnées().getY(), c.getY());
            r.setCoordonnées(new Coordonnées(3,3));
            Coordonnées c1 = new Coordonnées(3,3);
            assertEquals(r.getCoordonnées().getX(), c1.getX());
            assertEquals(r.getCoordonnées().getY(), c1.getY());

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
           assertTrue(r.getCoordonnées().getX() == new Coordonnées(1,2).getX());
           assertTrue(r.getCoordonnées().getY() == new Coordonnées(1,2).getY());
           r.annulerCoup();
           assertTrue(r.getCoordonnées().getY () == new Coordonnées(1,1).getY());
           p.put(r, new Coordonnées(4,5));
           assertTrue(p.jouer(new Coup(r.getCoordonnées(),new Coordonnées(4,6)),partie));
           assertTrue(r.getCoordonnées().getX() == new Coordonnées(4,6).getX());
           assertTrue(r.getCoordonnées().getY() == new Coordonnées(4,6).getY());
            r.annulerCoup();
           assertTrue(r.getCoordonnées().getX() == new Coordonnées(4,5).getX());
           assertTrue(r.getCoordonnées().getY() == new Coordonnées(4,5).getY());


        }

        @Test
        void TestCraintEchec(){
            IPièce r = new Roi(new Coordonnées(2,2), Couleur.NOIR);
            assertTrue(r.craintEchec());

        }

        @Test
        void TestEnEchec(){
            Plateau plateau = new Plateau();
            IPièce roi = new Roi(new Coordonnées(6,5),Couleur.NOIR);
            IPièce tour = new Tour(new Coordonnées(3,5),Couleur.BLANC);
            plateau.put(roi);
            plateau.put(tour);
            assertTrue(roi.enEchec(plateau));

            plateau.jouer(new Coup(new Coordonnées(6,5), new Coordonnées(7,7)),new Partie());


        }
}