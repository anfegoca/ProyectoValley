
/**
 * Write a description of class VineYard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VineYard
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private int xi,xf;
    private Rectangle yard;
    private String color;
    private String nombre;
    private int w,h;
    /**
     * Constructor for objects of class VineYard
     */
    public VineYard()
    {
        // initialise instance variables
        yard = new Rectangle();
        h=10;
        

    }

    /**
     * Mueve el viñedo los pixeles dados
     *
     * @param  x  pixeles en el eje x
     * @param  y  pixeles en el eje y
     * 
     */
    public void move(int x, int y)
    {
        yard.moveHorizontal(x);
        yard.moveVertical(y);
    }
    /**
     * Make this yard visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        yard.makeVisible();
    
    }
    /**
     * Make this yard invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        yard.makeInvisible();
    }
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        color = newColor;
        yard.changeColor(color);
    }
    public void changeSize(int w, int h)
    {
        this.w=w;
        this.h=h;
        yard.changeSize(h,w);
    }
    public int[] getPos(){
        int pos [] = {xi,xf};
        return pos;
    }
    public int[] getDim(){
        int dim [] = {w,h};
        return dim;
    }
    
    public void setVin(int xi,int xf, String name){
        this.xi=xi;
        this.xf=xf;
        nombre = name;
    }
    public String getNombre(){
        return nombre;
    }
    public String getColor(){
        return color;
    }
}
