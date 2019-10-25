
/**
 * Write a description of class Puncture here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Puncture extends Rectangle
{
    private int px;
    private int tam;
    /**
     * Constructor for objects of class Puncture
     */
    public Puncture()
    {
        super();
        tam = 10;
        super.changeSize(10,10);
        super.changeColor("white");
    }
    /**
     * Mueve x pixeles en el eje x e y pixeles en el y
     * @param x pixeles en x
     * @param y pixeles en y
     */
    public void move(int x ,int y)
    {   
        super.moveHorizontal(x);
        super.moveVertical(y);
    }
    public void changeSize(int x){
        super.changeSize(x,x);
    }
    /**
     * Da la posicion del hueco
     * @return Posicion del hueco
     */    
    public int getPx(){
        return px;
    }
    public int getx(){
        return xPosition;
    }
    public int gety(){
        return yPosition;
    }
    public String getColor(){
        return color;
    }
    public void setPx(int pos){
        px=pos;
    }
}
