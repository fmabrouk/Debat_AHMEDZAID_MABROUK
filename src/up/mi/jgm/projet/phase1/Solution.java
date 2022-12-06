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


private boolean condition2(Debat g, int n) {
  for(int i=0 ; i<ensembleSolution.size() ; i++){
    
    for(int j=0 ; j<n ; j++){
      int k=0; 
      boolean defense=false;
      if(verif2(j, ensembleSolution.get(i),g)){
        while(k<ensembleSolution.size() && !defense){
          if(verif3(ensembleSolution.get(k), j,g)){
            defense = true;
          }else{
            k++;
          }
        }
        if(!defense){
          return false;
        }
      }
    }
  }
  return true;
}
  

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
      g.isContradiction(indiceUn , indiceDeux )
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
    if (g.isContradiction(n , indice )) {
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
    if (g.isContradiction(indice , n)) {
      return true;
    }
    return false;
  }

  /**
   * Méthode qui affiche l'ensemble de solution admissible
   */
  public void affichageEnsembleSolution() {
	  for(int i =0;i< ensembleSolution.size();i++) {
		  if(i==0) {
			  System.out.print(ensembleSolution.get(i));  
		  } else {
			  System.out.print(","+ensembleSolution.get(i));
		  }
		  
	  }
	  if(ensembleSolution.isEmpty()){
		  System.out.print(" ");
	  }

	  System.out.println();
  }

 
  
  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();

    for(int i=0 ; i<ensembleSolution.size() ; i++){
      sb.append(ensembleSolution.get(i).toString()+" ");

    }

    return sb.toString();
  }
  
  public void affiche() {
	  System.out.println(ensembleSolution);
  }
}