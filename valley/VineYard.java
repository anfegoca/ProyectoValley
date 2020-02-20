package valley;
import shapes.*;

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
    private Valley valle;
    /**
     * Constructor for objects of class VineYard
     */
    public VineYard(Valley valle)
    {
        super();
        this.valle=valle;
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
    /**
     * cambia el tama�o del vi�edo
     * @param x numero de pixeles que se aumentan
     */
    public void changeSize(int x){
        super.changeSize(10,x);
    }
    /**
     * Retorna informaci�n de las posiciones del vi�edo
     * @return pos arreglo con la posicion inicial y final del vi�edo
     */
    public int[] getPos(){
        int pos [] = {xi,xf};
        return pos;
    }
    /**
     * Retorna informacion del tama�o del vi�edo
     * @return width tama�o del vi�edo
     */
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
    public void elimineme(){
        valle.closeVineyard(nombre);
        
    }
    public void agregueme(){
        valle.openVineyard(nombre,xi,xf);
    }
}
