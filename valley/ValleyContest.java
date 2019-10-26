package valley;


/**
 * Write a description of class ValleyContest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ValleyContest
{

    public ValleyContest()
    {
        
    }

    public int solve(int[] vineyard,int[][]traps){
        Solucion sol = new Solucion();
        int res=sol.solu(vineyard,traps);
        return res;
    }
    public boolean simulate(int[] vineyard,int[] traps, boolean slow){
        Valley valle = new Valley(500,500);
        return true;
    }   
}
