
/**
 * Write a description of class Straight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Straight extends Lluvia
{
   
    /**
     * Constructor for objects of class Straight
     */
    public Straight(Valley valle)
    {
        super(valle);
    }
    /**
     * Si la lluvia no cae sobre un vineyard esta para
     */
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
        int[][] mat = valle.vineyards();
        boolean f = true;
        for(int i=0; i<mat.length;i++){
            System.out.println(mat[i][0]);
            System.out.println(mat[i][1]);
            System.out.println(xf);
            if(xf>mat[i][0] && xf<mat[i][1]){
                System.out.println("hola");
                f=false;
                break;
            }
        }
        if(f){
            System.out.println("chao");
            this.parar();
        }
    }
}
    
