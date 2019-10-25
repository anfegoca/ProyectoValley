import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.lang.Math;
import javax.swing.JOptionPane;
/**
 * Write a description of class Radical here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Radical extends Trap
{
    /**
     * Constructor for objects of class Radical
     */
    public Radical(int p1,int p2,int q1,int q2)
    {
        super(p1,p2,q1,q2);
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
                this.makeInvisible();
            }
        }
    }
    public void quitarHueco(int pos)
    {
    }

}
