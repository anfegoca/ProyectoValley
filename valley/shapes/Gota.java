import java.util.ArrayList;
/**
 * Write a description of class Gota here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gota extends Circle
{
    private int tam;
    /**
     * Constructor for objects of class Gota
     */
    public Gota()
    {
        super();
        tam=10;
        super.changeSize(tam);
        super.changeColor("cyan");
    }
    public void move(int x, int y){
        super.moveHorizontal(x);
        super.moveVertical(y);
    }
    /**
     * Da la posicion de la gota
     * @return posicion de la gota
     */    
    public ArrayList getPos(){
        ArrayList pos = new ArrayList();
        pos.add(xPosition);
        pos.add(yPosition);
        return pos;
    }
}
