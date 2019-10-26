package valley;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;
import java.lang.Math;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

public class sdsdas {
	static HashSet<int[]> visitados = new HashSet<int[]>();
	static Hashtable<Integer,Integer> V = new Hashtable<Integer ,Integer>();
	static Hashtable<int [],ArrayList<int[]>> grafo = new Hashtable<int [],ArrayList<int []>>();
	static ArrayList<int []> ordenado = new ArrayList<int []>();
	public static void main(String[] args){
		Scanner myObj = new Scanner(System.in);

		Hashtable<Integer,int []> lonas=new Hashtable<Integer ,int []>();
		
		int [] vinedo= new int[3];
		for (int i=0;i<3;i++){
			int cordenadavin = myObj.nextInt();
			vinedo[i]=cordenadavin;
		}
		
		int l = vinedo[0];
		int r = vinedo[1];
		int nlonas = vinedo[2];
		if (nlonas==0){System.out.println(0);}
		else{
			int [] deltax = new int[nlonas*2];
			PriorityQueue<Integer> Q = new PriorityQueue<Integer>();
			
			int cont = 0;
			
			for (int i=0;i<nlonas;i++){
				int [] lona = new int[4];
				for (int j=0;j<4;j++){
					int cordenada = myObj.nextInt();
					lona[j]=cordenada;	
				}
				int x1 =(int)Math.min(lona[0], lona[2]);
				int x2 =(int)Math.max(lona[0], lona[2]);
				deltax[cont]=x1;
				deltax[cont+1]=x2;
				cont+=2;
				if (x1 == lona[2]){
					int zz=lona[0];
					int zz1=lona[1];
					lona[0]=lona[2];
					lona[1]=lona[3];
					lona[2]=zz;
					lona[3]=zz1;
					}
					
					
					
				
				grafo.put(lona,new ArrayList<int[]>());
				lonas.put(x1, lona);
				Q.add(x2);
				
				
			}
			Arrays.sort(deltax);
			
			//System.out.println(Arrays.toString(deltax));
			
			
			

			
		
			int cont2=0;

			HashSet<Integer> T = new HashSet<Integer>();
			

			Hashtable<Integer,Integer> Z=new Hashtable<Integer ,Integer>();
			while (!Q.isEmpty()){
				int xi= deltax[cont2];
				if (Q.element()==xi){
					Q.remove();
					T.remove(Z.get(xi));
					Z.remove(xi);
				}
				else{

					int [] lona = lonas.get(xi);
					Z.put(lona[2], lona[0]);
					for (Integer i : T){
						int [] lona2 = lonas.get(i);
						double m = ((double)lona2[3]-(double)lona2[1])/((double)lona2[2]-(double)lona2[0]);
						double b = (-m*(double)lona2[0])+(double)lona2[1];
						if (lona[1]<((xi*m)+b)){
							//System.out.println(Arrays.toString(lona)+" "+((xi*m)+b+" "+" "+Arrays.toString(lona2)));
							grafo.get(lona).add(lona2);
						}
						else{grafo.get(lona2).add(lona);}
						
					}
					T.add(deltax[cont2]);
				}
				
				cont2+=1;
				//System.out.println(lonas.size());
				
			}
			

			
			Set<int[]> keys = grafo.keySet();
			//for(int[] key: keys){System.out.println(Arrays.toString(key)+"Padre");for (int [] lona:grafo.get(key)){System.out.println(Arrays.toString(lona)+"Hijo");}}
			for(int[] key: keys){
				if (!visitados.contains(key)) {
					topologicoVisitar(key);
				}
			
			}
			int l1 = Math.min(deltax[0], l);
			int l2 = Math.max(deltax[(nlonas*2)-1], r);
			for (int i=l1;i<=l2;i++){
				
				V.put(i,0);
			
			}
			
			//for (int [] i: ordenado) {
				//System.out.println(Arrays.toString(i));
				
			//}
			
			int [] primera = ordenado.get(0);
			double pendientepri = ((double)primera[3]-(double)primera[1])/((double)primera[2]-(double)primera[0]);
			int cambio;
			int [] anterior = new int [2];
			if (pendientepri>0){cambio=1;}
			else{cambio=-1;}
			
			for (int [] lona :ordenado){
				int xx1 = lona[0];
				int yy1 = lona[1];
				int xx2 = lona[2];
				int yy2 = lona[3];
				double m = ((double)yy2-(double)yy1)/((double)xx2-(double)xx1); 
				if (m<0){
					if (cambio==-1){
						anterior[0]=xx1;
						anterior[1]=xx2;
						for (int i=xx1;i<xx2;i++){
							V.replace(i,V.get(i)+1);
						}
					}
					else{
						int bandera =-1;
						for (int i=xx1;i<xx2;i++){
							if (i>=anterior[0] && i<=anterior[1]){
								if (bandera==-1){bandera=V.get(i);V.replace(i,bandera+1);}
								else{V.replace(i,bandera+1);}
							}
							else{V.replace(i,V.get(i)+1);}
						}
						V.replace(xx2,bandera);
						cambio = -1;
					}

					
				}
				else{
					
					if (cambio==1){
						anterior[0]=xx1;
						anterior[1]=xx2;
						for (int i=xx2;i>xx1;i--){
							
							V.replace(i,V.get(i)+1);
						}
					}
					else{
						int bandera=-1;
						for (int i=xx2;i>xx1;i--){
							if (i>=anterior[0] && i<=anterior[1]){
								if(bandera==-1){bandera=V.get(i);V.replace(i,bandera+1);}
								else{V.replace(i, bandera+1);}
							}
							else{V.replace(i, V.get(i)+1);}
						}
						V.replace(xx1, bandera);
						cambio=1;
					}

				}
			
			}
			//Set<Integer> keys2 = V.keySet();
			//for(int key: keys2){
				//System.out.println(key+" "+V.get(key));
			//}
			
			int min = V.get(l); 
			for (int i=l+1;i<=r;i++){
				
				if(min>V.get(i)){min=V.get(i);}
			}
			
			System.out.println(min);
		}
		
		
	}
	
	public static void topologicoVisitar(int[] nodo) {
		visitados.add(nodo);
		for (int[] i:grafo.get(nodo)) {
			if (!visitados.contains(i)) {
				topologicoVisitar(i);
			}
			
		}
		ordenado.add(nodo);
			
	}
	


}

