import java.util.ArrayList;
/**
 * Write a description of class Gota here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gota
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private Circle gota;
    private String color;
    private int tam;
    /**
     * Constructor for objects of class Gota
     */
    public Gota()
    {
        gota = new Circle();
        tam=10;
        gota.changeSize(tam);
        gota.changeColor("cyan");
    }

    public void makeVisible(){
        gota.makeVisible();
    }
    public void makeInvisible(){
        gota.makeInvisible();
    }
    public void move(int x, int y){
        this.x=x;
        this.y=y;
        gota.moveHorizontal(x);
        gota.moveVertical(y);
    }
    public void changeColor(String newColor){
        gota.changeColor(newColor);
    }
    public void changeSize(int x){
        gota.changeSize(x);
    }
    /**
     * Da la posicion de la gota
     * @return posicion de la gota
     */    
    public ArrayList getPos(){
        ArrayList pos = new ArrayList();
        pos.add(x);
        pos.add(y);
        return pos;
    }
}
