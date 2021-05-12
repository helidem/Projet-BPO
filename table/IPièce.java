package table;

public interface IPièce {
    public boolean coupLegal(int x, int y, Plateau p);
    public void manger(int x, int y, Plateau p);
}