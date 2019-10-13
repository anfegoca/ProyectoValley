
/**
 * Write a description of class Puncture here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Puncture
{
    // instance variables - replace the example below with your own
    private int px;
    private Rectangle hueco;
    private int x;
    private int y;
    private String color;
    private int tam;

    /**
     * Constructor for objects of class Puncture
     */
    public Puncture()
    {
        hueco = new Rectangle();
        tam = 10;
        hueco.changeSize(10,10);
        color="white";
        hueco.changeColor(color);
    }
    /**
     * Mueve x pixeles en el eje x e y pixeles en el y
     * @param x pixeles en x
     * @param y pixeles en y
     */
    public void move(int x ,int y)
    {   
        this.x=x;
        this.y=y;
        hueco.moveHorizontal(x);
        hueco.moveVertical(y);
        
    }
    /**
     * Make visible Puncture 
     */
    public void makeVisible()
    {
        hueco.makeVisible();   
    }
    /**
     * Make Invisible Puncture 
     */
    public void makeInvisible()
    {
        hueco.makeInvisible();   
    }
    /**
     * Change color Puncture
     */
    public void changeColor(String newColor){
        color=newColor;
        hueco.changeColor(newColor);
    }
    /**
     * Change size Puncture
     */
    public void changeSize(int x){
        hueco.changeSize(x,x);
    }
    /**
     * Da la posicion del hueco
     * @return Posicion del hueco
     */    
    public int getPx(){
        return px;
    }
    public int getx(){
        return x;
    }
    public String getColor(){
        return color;
    }
    public void setPx(int pos){
        px=pos;
    }
}
