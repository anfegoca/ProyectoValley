package valley;
import shapes.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
/**
 * Write a description of class Lluvia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lluvia implements Controlador
{
    // instance variables - replace the example below with your own
    protected int x;
    protected ArrayList<Gota> gotas = new ArrayList<Gota>();
    protected int xf;
    protected int tam;
    protected Valley valle;
    protected String color;
    /**
     * Constructor for objects of class Lluvia
     */
    public Lluvia(Valley valle)
    {   
        this.valle=valle;
        tam=10;
        color="cyan";
    }
    public void llover(int x,int y){
        int ini=0;
        this.x=x;
        xf=x;
        while(ini<y-10){
            Gota gota = new Gota();
            gota.changeColor(color);
            int[] pos = valle.next(xf,ini,false);
            gota.move(pos[0],pos[1]);
            gotas.add(gota);
            ini=pos[1];
            xf=pos[0];
        }
    }
    public void parar(){
        this.makeInvisible();
    }
    /**
     * Hace visible la lluvia
     */
    public void makeVisible(){
        for(int i=0;i<gotas.size();i++){
            if(i%10==0){
                gotas.get(i).makeVisible();
            }
        }
    }
    /**
     * Cambia el tamaño de la lluvia
     */
    public void changeSize(int x){
        tam=x;
        for(Gota g: gotas){
            g.changeSize(x);
        }
    }
    /**
     * Hace invisible la Lluvia
     *  
     */
    public void makeInvisible()
    {
        for(Gota g: gotas){
            g.makeInvisible();
        }
    }
    /**
     * Retorna el tamaño de la lluvia
     * @return tam tamaño de la lluvia
     */
    public int getTam(){
        return tam;
    }
    /**
     * Retorna la posicion de inicio y fin de la lluvia
     * @return pos Array con xi y xf
     */
    public int[] getPosL(){
        int [] pos = {x,xf};
        return pos;
    }
    public ArrayList posLluvia(){
        ArrayList <ArrayList>dir = new ArrayList<ArrayList>();
        for (Gota g:gotas){
            dir.add(g.getPos());
        }
        return dir;
    }
    
}
