import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.swing.JOptionPane;
/**
 * Write a description of class Valley here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Valley
{
    // instance variables - replace the example below with your own
    private int w;
    private int h;
    private Rectangle rec;
    private Rectangle rec2;
    private ArrayList<VineYard> vinedos = new ArrayList<VineYard>();
    private ArrayList<Lluvia> lluvias = new ArrayList<Lluvia>();
    private ArrayList<Trap> lonas = new ArrayList<Trap>();
    private Trap lona;
    private String[] q ={"green","red","blue","yellow","cyan","magenta"
        ,"black","gray","pink","orange"};
    private ArrayList<String> colores = new ArrayList<String>(Arrays.asList(q));
    private Lluvia agua;
    private boolean isVisible;
    private ArrayList<Object> ultimocre = new ArrayList<Object>() ;
    private int ultpos;
    private ArrayList<Object> ultiel = new ArrayList<Object>();
    private int ultpos2;
    private String accion;
    /**
     * Constructor for objects of class Valley
     */
    public Valley(int width, int height)
    {   
        
        isVisible = false;
        w=width+10;
        h=height+10;
        rec = new Rectangle();
        rec2 = new Rectangle();
        rec.changeColor("black");
        rec2.changeColor("white");
        rec.changeSize(h,w);
        rec2.changeSize(h-10,w-10);
        rec2.moveVertical(5);
        rec2.moveHorizontal(5);
        
    }
    /**
     * Crea un viñedo
     * @param name nombre del viñedo
     * @param xi posición inicial en el eje x
     * @param xf posición final en el eje x
     */
    
    public void openVineyard(String name, int xi, int xf)
    {
        boolean t = true;
        accion="crear";
        
        for(VineYard v: vinedos){
            int pos []=v.getPos();

            if( (pos[0] <= xi && xi <=pos[1] )|| (xf >= pos[0] && xf<= pos[1]) ){
                t = false;
                break;
            }
        }
        if (t){
            VineYard vin = new VineYard();
            if (ultimocre.size()==0){
                ultimocre.add(vin);
                ultpos=vinedos.size();
            }
            else{
                ultimocre.remove(0);
                ultimocre.add(vin);
                ultpos=vinedos.size();
            }            
            vin.setVin(xi,xf,name);
            vinedos.add(vin);
            vin.move(xi+5,h-15);
            vin.changeSize(xf-xi,10);
            vin.changeColor(colores.get(0));
            colores.remove(colores.remove(0));
            actualizar(); 
            if(isVisible){
                vin.makeVisible(); 
            }
        }else{if(isVisible){JOptionPane.showMessageDialog(null, "Se interseca con otro viñedo","ERROR", JOptionPane.ERROR_MESSAGE);}}
    }

    /**
     * Make valley visible
     *
     */
    public void makeVisible()
    {
        isVisible=true;
        rec.makeVisible();
        rec2.makeVisible();
        makeVisibleVine();
        makeVisibleTraps();
        makeVisibleLluvias(); 
    }
    private void changeSizeTraps(int x){
        for(Trap t: lonas){
                int tam=t.getTam();
                t.changeSize(tam+x);
            }
    }
    private void changeSizeLluvia(int x){
        for(Lluvia l: lluvias){
                int tam=l.getTam();
                l.changeSize(tam+x);
            }
    }
    private void changeSizeVinedos(int x){
        for(VineYard v: vinedos){
                int [] dim = v.getDim();
                v.changeSize(dim[0],dim[1]);
            }
    }
    private void makeVisibleTraps(){
        for(Trap t: lonas){
                t.makeVisible();
            }
    }
    private void makeVisibleVine(){
        for(VineYard v: vinedos){
                v.makeVisible();
            }
    }
    private void makeVisibleLluvias(){
        for(Lluvia l: lluvias){
                l.makeVisible();
            }
    }
    private void makeInvisibleTraps(){
        for(Trap t: lonas){
                t.makeInvisible();
            }
    }
    private void makeInvisibleVine(){
        for(VineYard v: vinedos){
                v.makeInvisible();
            }
    }
    private void makeInvisibleLluvias(){
        for(Lluvia l: lluvias){
                l.makeInvisible();
            }
    }
    private void actualizar(){
        String newColor = "black";
        for(Trap t: lonas){
            int [][] posLon = t.getPos();
            int cont = 0;
            for(VineYard v: vinedos){
                int [] posVin = v.getPos();
                if(posLon[0][0]<posVin[0] && posLon[0][0]<posVin[1] && posLon[1][0]>posVin[0] && posLon[1][0]>posVin[1]){
                    newColor=v.getColor();
                    cont++;
                }
            
            }
            if(cont==1){
                if (isVisible){
                    t.changeColor(newColor);
                    t.makeVisible();
                }
            }else if(cont == 0 || cont>1){
                if (isVisible && (t.getColor()!="black")){
                    
                    t.changeColor("black");
                    t.makeVisible();
                }
            }
            }
    }
    /**
     * Hace zoom al valle
     * @param z "+" para acercar o "-" para alejar
     * 
     */
    public void zoom(char z){
        if (z=='+'){
            changeSizeTraps(10);
            changeSizeLluvia(10);
            changeSizeVinedos(10);
        }
        else if(z == '-'){
            changeSizeTraps(-10);
            changeSizeLluvia(-10);
            changeSizeVinedos(-10);
        }else{
            if(isVisible){
                JOptionPane.showMessageDialog(null, "Valor ingresado invalido","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    /**
     * Make valley invisible
     */    
    public void makeInvisible()
    {
        isVisible=false;
        rec.makeInvisible();
        rec2.makeInvisible();
        makeInvisibleVine();
        makeInvisibleTraps();
        makeInvisibleLluvias();
    }
    /**
     * Cierra un viñedo dado su nombre
     * @param name Nombre del viñedo
     */
    
    public void closeVineyard(String name)
    {
        accion ="eliminar";
        boolean f =false;
        for(VineYard c:vinedos){
            if (c.getNombre() == name){
                c.makeInvisible();
                if(ultiel.size()==0){
                    ultiel.add(c);
                }
                else{
                    ultiel.remove(0);
                    ultiel.add(c);
                }
                colores.add(c.getColor());
                vinedos.remove(c);
                actualizar();
                f=true;
                break;
            }
                
        }
        if(!f){
            if(isVisible){
                
                JOptionPane.showMessageDialog(null, "El viñedo ingresado no existe","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    /**
     * Agrega una lona dadas 2 coordenadas
     * @lowerEnd arreglo con la coordenada del primer punto
     * @higherEnd arreglo con la coordenada del segundo punto 
     */
    public void addTrap(int[] lowerEnd, int[] higherEnd){
        accion = "crear";
        if (lowerEnd[0]==higherEnd[0] || lowerEnd[1]==higherEnd[1] || lowerEnd[0]== 0 || higherEnd[0] == w || lowerEnd[1] == h || higherEnd[1] == h && isVisible){
            JOptionPane.showMessageDialog(null, "Lona invalida","ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else{
            
            String colorLona ="black";
            
            lona = new Trap(5+lowerEnd[0],lowerEnd[1],higherEnd[0],higherEnd[1]);
            if (ultimocre.size()==0){
                ultimocre.add(lona);
                ultpos = lonas.size();
             }
            else{
                ultimocre.remove(0);
                ultimocre.add(lona);
                ultpos = lonas.size();
            }
            lonas.add(lona);
            actualizar();
            if(isVisible){
                lona.makeVisible();
            }
        }
    }
    /**
     * Quita una lona dada la posición
     * @param position
     */
    public void removeTrap(int position){
        accion ="eliminar";
        if(position > lonas.size() || position<=0 && isVisible){
            JOptionPane.showMessageDialog(null, "La lona ingresada no existe","ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if (ultiel.size()==0){
                ultiel.add(lonas.get(position-1));
                ultpos2 = position-1;
            }
            else{
                ultiel.remove(0);
                ultiel.add(lonas.get(position-1));
                ultpos2 = position-1;
            }
            lonas.get(position-1).makeInvisible();
            lonas.remove(position-1);
        }
    }
    /**
     * Hace un hueco en la lona dada en la posicion dada
     * @param trap numero de la lona
     * @param x posición donde se realizará el hueco
     */
    public void makePuncture(int trap,int x)
    {
        if (trap > lonas.size() && isVisible){
            JOptionPane.showMessageDialog(null, "No existe lona","ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
        
            Trap l = lonas.get(trap-1);
            if (l.Long() < x && isVisible){
                JOptionPane.showMessageDialog(null, "El punto ingresado está fuera de la lona","ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
                l.hacerHueco(x,isVisible);
            }
        }
    }
    /**
     * Tapa un hueco en la lona dada en la posición dada
     * @param trap numero de la lona
     * @param x posición donde se tapará el hueco
     */
    public void patchPuncture(int trap, int position)
    {
        if (trap > lonas.size() && isVisible){
            JOptionPane.showMessageDialog(null, "El punto ingresado está fuera de la lona","ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            Trap l = lonas.get(trap-1);
            if (l.Long() < position && isVisible){
                JOptionPane.showMessageDialog(null, "El punto ingresado está fuera de la lona","ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
                lonas.get(trap-1).quitarHueco(position);
                if(isVisible){
                    lonas.get(trap-1).makeVisible();
                }
            }
        }
    }
    public int[] next(int x, int y){
        int [] pos;
        pos = new int[2];
        for(Trap t: lonas){
            int[] aux = t.next(x,y);
            if(aux[0]==0){
                pos[0] = x;
                pos[1] = y+1;
            }
            else{
                pos = aux;
                break;
            }
        }
        return pos;
    }
    /**
     * Hace caer lluvia en la posición x del valle
     * @param x posición desde donde saldrá la lluvia
     */
    public void startRain(int x){
        accion ="crear";
        if ( (x < 0 || x>h-5) && isVisible ){
            JOptionPane.showMessageDialog(null, "No puede llover fuera del valle","ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        else{
            boolean f=true;
            for (int i=0; i<lluvias.size(); i++){
                if(lluvias.get(i).getPosL()[0] == x){
                    f=false;
                    break;
                }
            }
            if(!f){
                if(isVisible){
                    JOptionPane.showMessageDialog(null, "Ya está lloviendo en esta posición","ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                Lluvia lluvia = new Lluvia(x, h, this);
                if (ultimocre.size()==0){
                    ultimocre.add(lluvia);
                    ultpos=lluvias.size();
                }
                else{
                    ultimocre.remove(0);
                    ultimocre.add(lluvia);
                    ultpos=lluvias.size();
                }
                lluvias.add(lluvia);
                if(isVisible){
                    lluvia.makeVisible();
                }
            }
        }
    }
    /**
     * Detiene la lluvia de la poición dada
     * @param x posición del valle de donde se va a detener la lluvia
     *  
     */
     public void stopRain(int x){
        accion ="eliminar"; 
        boolean f=false;
        int a=0;
        for(int i = 0; i<lluvias.size();i++){
            if(lluvias.get(i).getPosL()[0] == x){
                lluvias.get(i).makeInvisible();
                if (ultiel.size()==0){
                    ultiel.add(lluvias.get(i));
                }
                else{
                    ultiel.remove(0);
                    ultiel.add(lluvias.get(i));
                }
                a=i;
                f=true;
                break;
            }
        }
        if(f){
            lluvias.remove(a);
        }else{
            if(isVisible){
                JOptionPane.showMessageDialog(null, "No está lloviendo en esta posición","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    /**
     * Muestra los nombre de los viñedos que están recibiendo lluvia.
     * @return lista con los nombres de los viñedos que están recibiendo lluvia
     */
    public String[] rainFalls(){
        ArrayList<String> a = new ArrayList<String>();
        for(VineYard v: vinedos){
            int [] pos = v.getPos();
            for(Lluvia l: lluvias){
                int [] pos2 = l.getPosL();
                if( pos2[1]>= pos[0] && pos2[1] <= pos[1]){
                    
                    a.add(v.getNombre());
                }
            }
        }
        String[] mojados = a.toArray(new String[a.size()]);
        return mojados;
    }
    /**
     * Consulta las posiciones de los viñedos
     * @return posi matriz con las posiciones de los viñedos
     */
    public int[][] vineyards(){
        int posi[][] = new int[vinedos.size()][2];
        for(int i= 0; i< vinedos.size(); i++){
            int [] pos = vinedos.get(i).getPos();
            posi[i][0]=pos[0];
            posi[i][1]=pos[1];
        }
        
        return posi;
    }
    /**
     * Consulta las cordenadas de sus esquinas con las posiciones de sus agujeros
     * @return mm matriz con las cordenadas de sus esquinas con sus respectivos posiciones de agujeros
     */    
    public ArrayList traps(){
        ArrayList<ArrayList> mm = new ArrayList<ArrayList>();
        
        for (int h=0;h<lonas.size();h++){
            lona = lonas.get(h);
            ArrayList<ArrayList> nn = new ArrayList<ArrayList>();
            for (int i=0;i<3;i++){
                int [][] pos = lona.getPos();
                if (i==0){
                    ArrayList oo = new ArrayList();
                 
                    oo.add(pos[0][0]-5);
                    oo.add(pos[1][0]);
                    
                    nn.add(oo);
                    
                }
                else if(i==1){
                    ArrayList oo = new ArrayList();
                    oo.add(pos[0][1]);
                    oo.add(pos[1][1]);
                    
                    nn.add(oo);
                }
                else{
                    ArrayList oo = new ArrayList();
                    oo = lona.posHuec();
                    nn.add(oo);   
                    }
                
                }
            mm.add(nn);
            }
        
        return mm;
    }         
   /**
     * Devuelve información del recoorido de la lluvia
     * @param posi coordenadas del recorrido de la lluvia
     */
   public ArrayList rains(){
        ArrayList <ArrayList> posi = new ArrayList<ArrayList>();
        
        for (Lluvia l:lluvias){
            ArrayList posl = l.posLluvia();
            posi.add(posl);
        }
        System.out.println(posi);
        return posi;
        
   }
   
   public void undo(){
       if (accion=="crear"){ 
       if (ultimocre.get(0) instanceof VineYard){
           VineYard x = (VineYard)ultimocre.get(0);
           if(isVisible){
               x.makeInvisible();
            }
           vinedos.remove(ultpos);
           actualizar();
        }
       else if (ultimocre.get(0) instanceof Trap){
           Trap x = (Trap)ultimocre.get(0);
           if(isVisible){
               x.makeInvisible();
            }
           
           lonas.remove(ultpos);
       }
       else if(ultimocre.get(0) instanceof Lluvia){
           Lluvia l= (Lluvia)ultimocre.get(0);
           if(isVisible){
               l.makeInvisible();
            }
           
           lluvias.remove(ultpos);
           
        }
    }
    else{
       if (ultiel.get(0) instanceof Trap){
          Trap x = (Trap)ultiel.get(0);
          if(isVisible){
              x.makeVisible();
            }
          
          lonas.add(ultpos2,x);
          
        }
       else if (ultiel.get(0) instanceof VineYard){
           VineYard x = (VineYard)ultiel.get(0);
          if(isVisible){
              x.makeVisible();
            }           
          vinedos.add(x);
        }
       else{
           Lluvia x = (Lluvia)ultiel.get(0);
           if(isVisible){
              x.makeVisible();
           }
           lluvias.add(x);
           
        }
    }
   }
}













