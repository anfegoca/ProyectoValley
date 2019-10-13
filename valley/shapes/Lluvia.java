import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
/**
 * Write a description of class Lluvia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lluvia
{
    // instance variables - replace the example below with your own
    private int x;
    private ArrayList<Gota> gotas = new ArrayList<Gota>();
    private int xf;
    private int tam;
    private Valley valle;
    /**
     * Constructor for objects of class Lluvia
     */
    public Lluvia(int x,int y,Valley valle)
    {   
        this.valle=valle;
        this.x=x;
        xf=x;
        tam=10;
        int ini=0;
        while(ini<y-10){
            int[] pos = valle.next(xf,ini);
            Gota gota = new Gota();
            gota.move(pos[0],pos[1]);
            gotas.add(gota);
            ini=pos[1];
            xf=pos[0];
        }
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
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void makeInvisible()
    {
        for(Gota g: gotas){
            g.makeInvisible();
        }
       
    }
    public int getTam(){
        return tam;
    }
    
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
