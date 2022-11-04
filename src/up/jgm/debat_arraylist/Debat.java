package up.jgm.debat_arraylist;

import java.util.ArrayList;

//Classe modélisant le graphe de probléme

public class Debat {
	   private ArrayList<Relation>[] adj;
	   private final int V;
	   
	   public Debat(int N) {
			this.V = N;
			adj = (ArrayList<Relation>[]) new ArrayList[N];
			for (int v= 0; v < N; v++)
			  adj[v] = new ArrayList<Relation>();
	   }
	   
	   public void addContradiction(Relation e) {
			int v = e.from;
			int w = e.to;
			adj[v].add(e);
			adj[w].add(e);
	   }
	   
	   
}
