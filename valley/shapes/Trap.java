import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.lang.Math;
import javax.swing.JOptionPane;

public  class Trap{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private double m,b;
    private ArrayList<Puncture> huecos = new ArrayList<Puncture>();
    private ArrayList<Puncture> punctures = new ArrayList<Puncture>();
    private String color;
    private int tam;
    /**
     * Constructor Trap
     */
    public Trap(int p1,int p2,int q1,int q2){
        x1=p1;
        y1=p2;
        x2=q1;
        y2=q2;
        tam=10;


        m = ((double)y2-(double)y1)/((double)x2-(double)x1);;
        b = -m*x1+y1;;
        color="black";
        for(int i=x1; i<=x2;i++){
            double y = m * i + b;
            Puncture hueco = new Puncture();
            hueco.move(i,(int)y);
            hueco.changeColor("black");
            //hueco.makeVisible();
            huecos.add(hueco);
        }
    }
    /**
     * Cambia de color la lona
     * @param newColor nuevo color de la lona
     */
    public void changeColor(String newColor){
        color=newColor;
        for(Puncture p: huecos){
            if (p.getColor()!="white"){
                p.changeColor(newColor);
            }
        }
    }
    /**
     * Make visible trap
     */
    public void makeVisible(){ 
        
        for(Puncture p: huecos){
            if(p.getColor()!="white"){
                p.makeVisible();
            }
        }
        for (Puncture p : punctures){
            p.makeVisible();
        }
    }
    public void changeSize(int x)
    {
        tam=x;
        for(Puncture p: huecos){
            if(p.getColor()!="white"){
                p.changeSize(x);
            }
        }
        for(Puncture p: punctures){
            p.changeSize(x);
        }
    }
    /**
     * Make invisible trap
     */
    public void makeInvisible(){
        for(Puncture p: huecos){
            p.makeInvisible();
        }
    }
    public void hacerHueco(int pos, boolean isVisible)
    {
        double h = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));//Se calcula la distancia entre los puntos
        double yp = (pos/h)*(y2-y1);
        double xp = Math.pow(pos,2)-Math.pow(yp,2);
        xp = Math.sqrt(xp);
        Puncture hue=huecos.get((int)xp);
        if(hue.getColor() == "white"){
            JOptionPane.showMessageDialog(null, "Ya hay un hueco en esta posición","ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            hue.changeColor("white");
            hue.setPx(pos);
            punctures.add(hue);
            if(isVisible){
                hue.makeVisible();
            }
        }
    }
        
    
    public void quitarHueco(int pos)
    {
        double h = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));//Se calcula la distancia entre los puntos
        double yp = (pos/h)*(y2-y1);
        double xp = Math.pow(pos,2)-Math.pow(yp,2);
        xp = Math.sqrt(xp);
        Puncture hue = huecos.get((int)xp);
        if(hue.getColor()!= "white"){
            JOptionPane.showMessageDialog(null, "No hay un hueco es esta posición","ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            hue.changeColor(this.color);
            punctures.remove(hue);
        }
    }
    public int getTam(){
        return tam;
    }
    
    public int[][] getPos(){
        int [][] pos = {{x1,y1},{x2,y2}};
        return pos;
    }
    public String getColor(){
        return color;
    }
    public double Long(){
      double dd = Math.sqrt((Math.pow((x2-x1),2)+Math.pow((y2-y1),2)));
      double d = (int)dd;
      return d;
    }
    /**
     * Consulta la posicion de sus respectivos huecos
     * @return pos posiciones de los huecos
     */    
    public ArrayList posHuec(){
            ArrayList pos = new ArrayList();
            for (Puncture p: punctures){
                pos.add(p.getPx());
            }
            return pos;
    }
    public double [] getEcu(){
        double [] ecu = {m,b};
        return ecu;
    }
    public int[] next(int x, int y){
        int [] pos;
        pos = new int[2];
        if (((int)(m*x+b) == y) && (x>x1 && x<x2)){
            boolean fhueco=true;
            for(Puncture p: punctures){
                if(p.getx()==x){
                    fhueco=false;
                    break;
                }
            }
            if(m>0 && fhueco){
                x++;
                y=(int)(m*x+b);
                pos[0]=x;
                pos[1]=y;
            }
            else if(m<0 && fhueco){
                x--;
                y=(int)(m*x+b);
                pos[0]=x;
                pos[1]=y;
            }
        }else{
            pos[0]=0;
            pos[1]=0;
        }
        return pos;
    }    
    public boolean comprobar(int i,String color){
        boolean t= true;
        if (huecos.get(i).getColor()!="white"){
            t = false;
        }
        return t;
       
    }
    public int[] getHuecos(){
        int [] res;
        res = new int[punctures.size()];
        for(int i=0; i<punctures.size();i++){
            res[i]=punctures.get(i).getx();
        }
        return res;
    }
}