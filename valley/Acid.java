package valley;


/**
 * Write a description of class Acid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Acid extends Lluvia
{
  
    /**
     * Constructor for objects of class Acid
     */
    public Acid(Valley valle)
    {   
        super(valle);
        color="green";
    }
    public void llover(int x, int y){
        int ini=0;
        this.x=x;
        xf=x;
        while(ini<y-10){
            Gota gota = new Gota();
            gota.changeColor(color);
            int[] pos = valle.next(xf,ini,true);
            gota.move(pos[0],pos[1]);
            gotas.add(gota);
            ini=pos[1];
            xf=pos[0];
        }
    }
}
