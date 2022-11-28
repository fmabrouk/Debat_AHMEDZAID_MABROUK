package up.mi.jgm.projet.phase1;

import java.util.ArrayList;

import up.mi.jgm.projet.phase2.Argument;

public class Solution {

  /**
   * ArrayList répresentant la solution contenant les arguments à choisir*/
  private ArrayList<Argument> ensembleSolution;


  public  ArrayList<Argument> getEnsembleSolution() {
    return ensembleSolution;
  }

  public  void setEnsembleSolution(ArrayList<Argument> e) {
    ensembleSolution = e;
  }

  /**
   * Cpnstructeur de la classe solution*/
  public Solution() {
    ensembleSolution = new ArrayList<Argument>();
  }

  /**
   * fonction permet d'ajouter un argument à la solution
   * @param arg l'argument à ajouter*/
  public void ajouteArgument(Argument arg) {
    if (!ensembleSolution.contains(arg))
      ensembleSolution.add(arg);

     
  }

  /**
   * fonction permet de retirer un argument de la solution
   * @param arg l'argument à retirer*/
  public void retireArgument(Argument arg) {
    if (ensembleSolution.contains(arg))
      ensembleSolution.remove(arg);
  }

  /**
   * fonction permet de vérifier si la solution est admissible
   * @param g la graphe modélisant le débat
   * @param n le nombre d'argument
   * @return renvoie true si la solution est admissible et faux sinon*/
  public boolean solutionAdmissible(Debat g, int n) {
    if (ensembleSolution.isEmpty()) {
      // System.out.println("La solution est vide");
      return true;
    }
    if (condition1(g) && condition2(g, n)) {
      return true;
    }
    return false;
  }

  

  /**
   * fonction qui permet de vérifier la condition 2 de la solution admissible
   * @param g la graphe modélisant le débat
   * @param n le nombre d'argument
   * @return renvoie true si c'est vrai et faux sinon*/
<<<<<<< HEAD
//  private boolean condition2(Debat g, int n) {
//    if (ensembleSolution.size() == 1) {
//      for (int i = 0; i < n; i++) {
//        for (int j = 0; j < ensembleSolution.size(); j++) {
//          if (verif2(i, ensembleSolution.get(j), g)) {
//            if (!verif3(ensembleSolution.get(j), i, g)) {
//              // System.out.println("l'argument " +ensembleSolution.get(j) +" ne se defend pas contre A" +(i + 1));
//              return false;
//            }
//          }
//        }
//      }
//    } else {
//      for (int i = 0; i < n; i++) {
//        for (int j = 0; j < ensembleSolution.size(); j++) {
//          if (verif2(i, ensembleSolution.get(j), g)) {
//            if (!verif4(n, i, g)) {
//              // System.out.println("l'argument " +ensembleSolution.get(j) +" ne se defend pas contre A" +(i + 1));
//              return false;
//            }
//          }
//        }
//      }
//    }
//    return true;
//  }

  private boolean condition2(Debat g, int n) {
	  if(ensembleSolution.size() ==1) {
		  
	  } else {
		  for(int j=0;j < n;j++) {
			  
			  for(int i = 0;i<ensembleSolution.size();i++) {
				  boolean seDefendPas=true;
				  int k=0;
				  if(verif2(j,ensembleSolution.get(i),g)) {
					  while(k<ensembleSolution.size() && seDefendPas) {
						  if(verif3(ensembleSolution.get(k),j,g))
							  seDefendPas=false;
						  else	
							  k++;
					  }
				  }
			  }  
		  }
		  return true;
	  }
	 return false;
	  
  }
=======
  private boolean condition2(Debat g, int n) {
    if (ensembleSolution.size() == 1) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < ensembleSolution.size(); j++) {
          if (verif2(i, ensembleSolution.get(j), g)) {
            if (!verif3(ensembleSolution.get(j), i, g)) {
              // System.out.println("l'argument " +ensembleSolution.get(j) +" ne se defend pas contre A" +(i + 1));
              return false;
            }
          }
        }
      }
    } else {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < ensembleSolution.size(); j++) {
          if (verif2(i, ensembleSolution.get(j), g)) {
            if (!verif4(n, i, g)) {
              // System.out.println("l'argument " +ensembleSolution.get(j) +" ne se defend pas contre A" +(i + 1));
              return false;
            }
          }
        }
      }
    }
    return true;
  }

>>>>>>> a3c2ea1b9e7f3e25be6ca6ea3612f593a738a6e2
  

  /**
   * fonction qui permet de vérifier la condition 1 de la solution admissible
   * @param g la garphe modélisant le débat
   * @return renvoie true si c'est vrai et faux sinon*/
  private boolean condition1(Debat g) {
    for (int i = 0; i < ensembleSolution.size(); i++) {
      for (int j = 0; j < ensembleSolution.size(); j++) {
        if (verif1(ensembleSolution.get(i), ensembleSolution.get(j), g)) {
          // System.out.println( "Il existe une contradiction entre " + ensembleSolution.get(i) + " et " + ensembleSolution.get(j));
          return false;
        }
        if (verif1(ensembleSolution.get(j), ensembleSolution.get(i), g)) {
          // System.out.println("Il existe une contradiction entre " + ensembleSolution.get(j) + " et " + ensembleSolution.get(i));
          return false;
        }
      }
    }
    return true;
  }

 

  /**
   * fonction qui permet de vérifier s'il existe une contardiction entre arg1 et arg2
   * @param arg1 l'argument qui contredit
   * @param arg2 l'argument qui subit la contradiction
   * @return renvoie true si arg1 contredit arg2 et false sinon*/
  private boolean verif1(Argument arg1, Argument arg2, Debat g) {
    int indiceUn = arg1.getIndice();
    int indiceDeux = arg2.getIndice();
    if (
<<<<<<< HEAD
      g.isContradiction(indiceUn - 1, indiceDeux - 1 )
=======
      g.isContradiction(indiceUn, indiceDeux)
>>>>>>> a3c2ea1b9e7f3e25be6ca6ea3612f593a738a6e2
    ) {
      return true;
    }
    return false;
  }

  /**
   * fonction permet de vérifier s'il existe une contradiction entre n et arg
   * @param n l'indice d'argument dans la matrice d'adjacence qui contredit
   * @param arg l'argument qui subit la contradiction
   * @return renvoie true si n contredit arg et faux sinon*/
  private boolean verif2(int n, Argument arg, Debat g) {
    int indice = arg.getIndice();
<<<<<<< HEAD
    if (g.isContradiction(n , indice - 1)) {
=======
    if (g.isContradiction(n, indice)) {
>>>>>>> a3c2ea1b9e7f3e25be6ca6ea3612f593a738a6e2
      return true;
    }
    return false;
  }

  /**
   * fonction permet de vérifier s'il existe une contradiction entre arg et n
   * @param arg l'argument qui contredit
   * @param n l'indice d'argument dans la matrice d'adjacence qui subit la contradiction
   * @return renvoie true si arg contredit n et faux sinon*/
  private boolean verif3(Argument arg, int n, Debat g) {
    int indice = arg.getIndice();
<<<<<<< HEAD
    if (g.isContradiction(indice - 1, n)) {
=======
    if (g.isContradiction(indice, n)) {
>>>>>>> a3c2ea1b9e7f3e25be6ca6ea3612f593a738a6e2
      return true;
    }
    return false;
  }

  /**
   * fonction permet de vérifier s'il existe une contradiction entre arg et n
   * @param tailleGraphe taille du graphe
   * @param n l'indice d'argument dans la matrice d'adjacence qui subit la contradiction
   * @param g la matrice d'adjacence qui represente le debat
   * @return renvoie true si arg contredit n et faux sinon*/
<<<<<<< HEAD
//  private boolean verif4(int tailleGraphe, int n, Debat g) {
//    
//    for (int i = 0; i < tailleGraphe; i++) {
////    	System.out.println(" i = "+ i);
////    	System.out.println("n = "+ n);
//      if (g.isContradiction(i, n)) {
//        return true;
//      }
//    }
//    return false;
//  }
=======
  private boolean verif4(int tailleGraphe, int n, Debat g) {
    
    for (int i = 0; i < tailleGraphe; i++) {
      if (g.isContradiction(i, n)) {
        return true;
      }
    }
    return false;
  }

  
>>>>>>> a3c2ea1b9e7f3e25be6ca6ea3612f593a738a6e2

  
  /**
   * Méthode qui affiche l'ensemble de solution admissible
   */
  public void affichageEnsembleSolution() {
    System.out.println("Solution Admissible = " + ensembleSolution);
  }


   
  /**
   * Méthode qui convertit l'ensemble de solution en String
   * @return l'ensemble de solution en chaine de caractère
   */
  public String ensembleSoltoString(){

    String tempStr = ensembleSolution.toString().substring(1,ensembleSolution.toString().length()-1);
    String[] chaineTemp = tempStr.split(", ");
    StringBuilder sb = new StringBuilder();
    for(int i=0 ; i<chaineTemp.length;i++){
      sb.append(chaineTemp[i]);
    }

    return sb.toString();
  }

  
  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();

    for(int i=0 ; i<ensembleSolution.size() ; i++){
      sb.append(ensembleSolution.get(i).toString());

    }

    return sb.toString();
  }
  
<<<<<<< HEAD
}
=======
}
>>>>>>> a3c2ea1b9e7f3e25be6ca6ea3612f593a738a6e2
