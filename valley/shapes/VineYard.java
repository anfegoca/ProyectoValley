
/**
 * Write a description of class VineYard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VineYard extends Rectangle implements Controlador
{
    private int xi,xf;
    private String nombre;
    private int tam;
    /**
     * Constructor for objects of class VineYard
     */
    public VineYard()
    {
        super();
        
        super.changeSize(10,1);
        
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
        super.moveHorizontal(x);
        super.moveVertical(y);
    }
    public void changeSize(int x){
        super.changeSize(10,x);
    }
    public int[] getPos(){
        int pos [] = {xi,xf};
        return pos;
    }
    public int getTam(){
        return width;
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
