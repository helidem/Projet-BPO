package partie;

public class Coup {

    private Coordonnées départ, arrivée;
    public Coup(Coordonnées départ, Coordonnées arrivée) {
        this.départ = départ;
        this.arrivée = arrivée;
    }

    public Coup(){

    }
    public Coordonnées getDépart() {
        return départ;
    }

    public Coordonnées getArrivée() {
        return arrivée;
    }

    public void setCoord(Coordonnées départ, Coordonnées arrivée){
        this.départ = départ;
        this.arrivée = arrivée;
    }

}
