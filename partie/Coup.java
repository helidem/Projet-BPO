package partie;

public class Coup {
    private int xd,yd,xa,ya;

    public Coup(int xd, int yd, int xa, int ya) {
        this.xd = xd;
        this.yd = yd;
        this.xa = xa;
        this.ya = ya;
    }

    public Coup(){
        this(0,0,0,0);
    }

    public int getXd() {
        return xd;
    }

    public int getYd() {
        return yd;
    }

    public int getXa() {
        return xa;
    }

    public int getYa() {
        return ya;
    }

    public void setCoord(int xd, int yd, int xa, int ya){
        this.xd = xd;
        this.yd = ya;
        this.xa = xa;
        this.ya = ya;
    }
}
