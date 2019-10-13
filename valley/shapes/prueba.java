import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class prueba.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class prueba
{
    @Test
    public void segunIRLluviaLLegaAVieñedoGreen(){
        Valley valley1 = new Valley(500, 300);
        valley1.makeVisible();
        valley1.openVineyard("green", 60, 120);
        int[] coorInicialTrapA = {40,200};
        int[] coorFinalTrapA = {120,180};
        valley1.addTrap(coorInicialTrapA , coorFinalTrapA);
        int[] coorInicialTrapB = {65,140};
        int[] coorFinalTrapB = {160,160};
        valley1.addTrap(coorInicialTrapB , coorFinalTrapB);
        int[] coorInicialTrapC = {40,80};
        int[] coorFinalTrapC = {100,120};
        valley1.addTrap(coorInicialTrapC , coorFinalTrapC);
        int[] coorInicialTrapD = {60,60};
        int[] coorFinalTrapD = {140,40};
        valley1.addTrap(coorInicialTrapD , coorFinalTrapD);
        valley1.makePuncture(1, 60);
        valley1.makePuncture(2, 50);
        valley1.startRain(60);
        String[] resp = {"green"};
        assertEquals(resp, valley1.rainFalls());
    }
}
