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

class PièceTest {

        @Test
        void testCoupLegal(){
            PieceFactory pf = new PieceFactory();
            IPièce p = pf.getRoi(1,1,Couleur.BLANC);
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
            IPièce t = pf.getTour(5,5, Couleur.NOIR);
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
        void testAnnulerCoup(){
           PieceFactory pf = new PieceFactory();
           Partie partie = new Partie();
           Plateau p = new Plateau();
           IPièce r = pf.getRoi(1,1,Couleur.BLANC);
           IPièce r2 = pf.getRoi(2,5, Couleur.NOIR);
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
            PieceFactory pf = new PieceFactory();
            IPièce r = pf.getRoi(2,2, Couleur.NOIR);
            IPièce t = pf.getTour(3,3, Couleur.NOIR);
            assertTrue(r.craintEchec());
            assertFalse(t.craintEchec());
        }

        @Test
        void TestEnEchec(){
            PieceFactory pf = new PieceFactory();
            Plateau plateau = new Plateau();
            IPièce roi =  pf.getRoi(6,5,Couleur.NOIR);
            IPièce tour = pf.getTour(3,5,Couleur.BLANC);
            plateau.put(roi);
            plateau.put(tour);
            assertTrue(roi.enEchec(plateau));
            plateau.put(roi,new Coordonnées(6,3));
            assertFalse(roi.enEchec(plateau));
        }

        @Test
        void TestEnEchecEtMat(){
            Partie partie = new Partie();
            Plateau plateau = new Plateau();
            PieceFactory pf = new PieceFactory();
            IPièce roi = pf.getRoi(1,1,Couleur.NOIR);
            IPièce roi2 = pf.getRoi(6,5,Couleur.BLANC);
            IPièce tour = pf.getTour(4,4,Couleur.BLANC);
            plateau.put(roi);
            plateau.put(roi2);
            plateau.put(tour);
            System.out.println(plateau);
            plateau.jouer(new Coup(tour.getCoordonnées(),new Coordonnées(4,5)),partie);
            System.out.println(plateau);
            assertFalse(roi.enEchecEtMat(plateau,partie));

            plateau.removePièce(roi);
            plateau.removePièce(roi2);
            plateau.removePièce(tour);

            pf.defaut(plateau);
            System.out.println(plateau);
            plateau.jouer(new Coup(new Coordonnées(1,6),new Coordonnées(1,7)),partie);
            assertTrue(plateau.getPièce(4,7).enEchecEtMat(plateau,partie));
        }
}