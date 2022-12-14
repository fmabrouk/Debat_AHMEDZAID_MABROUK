package up.mi.jgm.projet.phase2;

//Classe representant la matrice de notre graphe en utilisant les tableaux

public class Debat {
	/*
	 * tableau de deux dimensions pour réprsenter la matrice d'adjacence
	*/
	  protected  boolean adjMatrice[][];
	  
	  public boolean[][] getAdjMatrice() {
		return adjMatrice;
	}
	public void setAdjMatrice(boolean[][] adjMatrice) {
		this.adjMatrice = adjMatrice;
	}

	/*
	   * nombre de sommets(arguments)
	  */
	  private int numNoeud;

	  /*
	   * Constructeur de la classe graphe
	  */
	  public Debat() {
	    
	  }
	 
	  /**
	   * fonction permet d'ajouter une contardiction
	   * @param i l'argument qui contredit
	   * @param j l'argument qui reçoit la contradiction
	  */
	  public  void addContradiction(int i, int j) {
	    adjMatrice[i][j] = true;
	  }
	  
	  /**
	   * fonction permet de vérifier s'il existe une contradiction entre i et j
	   * @param i l'argument qui contredit
	   * @param j l'argument qui subit la contradiction
	   * @return renvoie true s'il y avait une contardiction et false sinon*/
	  public boolean isContradiction(int i,int j) {
		  return adjMatrice[i][j];
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