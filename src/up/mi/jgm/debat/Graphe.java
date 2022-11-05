package up.mi.jgm.debat;

public class Graphe {
	
	/*
	 * tableau de deux dimensions pour réprsenter la matrice d'adjacence
	*/
	  private  boolean adjMatrice[][];
	  
	  /*
	   * nombre de sommets(arguments)
	  */
	  private int numNoeud;

	  /*
	   * Constructeur de la classe graphe
	  */
	  public Graphe(int numNoeud) {
	    this.numNoeud = numNoeud;
	    adjMatrice = new boolean[numNoeud][numNoeud];
	  }

	  /**
	   * fonction permet d'ajouter une contardiction
	   * @param i l'argument qui contredit
	   * @param j l'argument qui reçoit la contradiction
	  */
	  public  void addContradiction(int i, int j) {
	    adjMatrice[i][j] = true;
	    System.out.println("contradiction ajoutés entre A"+(i+1)+" et A"+(j+1));
	  }
	  
	  public boolean verifContradiction(int i,int j) {
		 // System.out.println("i : "+i+" j : "+j);
		  if(adjMatrice[i][j] == true) {
			  return true;
		  }
		  return false;
			  
	  }

	  /**
	   * fonction permet d'afficher la matrice d'adjacence
	   * @return renvoie la matrice d'adajecence de la graphe
	   */
	  public String toString() {
	    StringBuilder s = new StringBuilder();
	    for (int i = 0; i < numNoeud; i++) {
	      s.append(i + ": ");
	      for (boolean j : adjMatrice[i]) {
	        s.append((j ? 1 : 0) + " ");
	      }
	      s.append("\n");
	    }
	    return s.toString();
	  }

	
	
	
}
