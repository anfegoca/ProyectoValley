import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.lang.Math;
import javax.swing.JOptionPane;
/**
 * Write a description of class Flexible here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flexible extends Trap
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Flexible
     */
    public Flexible(int p1,int p2,int q1,int q2)
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
                this.quitarHueco(1);
            }
        }
    }

}
