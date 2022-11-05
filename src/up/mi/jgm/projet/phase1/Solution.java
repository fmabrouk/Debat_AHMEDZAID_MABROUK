package up.mi.jgm.projet.phase1;

import java.util.ArrayList;


public class Solution {
	
	/**
	 * ArrayList répresentant la solution contenant les arguments à choisir*/
	private static  ArrayList<String> E;
	
	/**
	 * Cpnstructeur de la classe solution*/
	public  Solution() {
		E = new ArrayList<String>();
	}
	
	/**
	 * fonction permet d'ajouter un argument à la solution
	 * @param arg l'argument à ajouter*/
	public  void AjouteArgument(String arg) {
		if(E.contains(arg))
			System.out.println(" Argument "+arg +" déjà dans la solution");
		else {
			E.add(arg);
		}
	}
	
	/**
	 * fonction permet de retirer un argument de la solution
	 * @param arg l'argument à retirer*/
	public  void retireArgument(String arg) {
		if(!E.contains(arg))
			System.out.println(" Argument "+ arg +" n'est pas dans la solution");
		else {
			E.remove(arg);
		}
	}
	
	/**
	 * fonction permet de vérifier si la solution est admissible
	 * @param g la graphe modélisant le débat
	 * @param n le nombre d'argument
	 * @return renvoie true si la solution est admissible et faux sinon*/
	public boolean solutionAdmissible(Debat g,int n) {
		if(E.isEmpty()) {
			System.out.println("La solution est vide");
			return true;
		}
		if(condition1(g) && condition2(g,n)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * fonction permet de vérifier si la solution est admissible sans affocher l'erreur
	 * @param g la graphe modélisant le débat
	 * @param n le nombre d'argument
	 * @return renvoie true si la solution est admissible et faux sinon*/
	public boolean solutionAdmissibleSansErreur(Debat g,int n) {
		if(E.isEmpty()) {
			System.out.println("La solution est vide");
			return true;
		}
		if(condition1SansErreur(g) && condition2SansErreur(g,n)) {
			return true;
		}
		return false;
	}
	
	
	
	/**
	 * fonction qui permet de vérifier la condition 2 de la solution admissible
	 * @param g la graphe modélisant le débat
	 * @param n le nombre d'argument
	 * @return renvoie true si c'est vrai et faux sinon*/
	private boolean condition2(Debat g,int n) {
		for(int i=0;i< n;i++) {
			for(int j= 0;j<E.size();j++) {
				if(verif2(i,E.get(j),g)) {
					if(!verif3(E.get(j),i,g)) {
						System.out.println("l'argument "+E.get(j)+ " ne se defend pas contre A"+ (i+1));
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
	/**
	 * fonction qui permet de vérifier la condition 2 de la solution admissible sans affocher l'erreur
	 * @param g la graphe modélisant le débat
	 * @param n le nombre d'argument
	 * @return renvoie true si c'est vrai et faux sinon*/
	private boolean condition2SansErreur(Debat g,int n) {
		for(int i=0;i< n;i++) {
			for(int j= 0;j<E.size();j++) {
				if(verif2(i,E.get(j),g)) {
					if(!verif3(E.get(j),i,g)) {
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
		for(int i=0;i<E.size();i++) {
			for( int j=0;j<E.size();j++) {
				if(verif(E.get(i),E.get(j),g)) {
					System.out.println("Il existe une contradiction entre "+ E.get(i)+" et " + E.get(j));
					return false;
				}
				if(verif(E.get(j),E.get(i),g)) {
					System.out.println("Il existe une contradiction entre "+ E.get(j)+" et " + E.get(i));
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * fonction qui permet de vérifier la condition 1 de la solution admissible sans afficher l'erreur
	 * @param g la garphe modélisant le débat
	 * @return renvoie true si c'est vrai et faux sinon*/
	private boolean condition1SansErreur(Debat g) {
		for(int i=0;i<E.size();i++) {
			for( int j=0;j<E.size();j++) {
				if(verif(E.get(i),E.get(j),g)) {
					return false;
				}
				if(verif(E.get(j),E.get(i),g)) {
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
	private boolean verif(String arg1,String arg2,Debat g) {
		String[] str1 = arg1.split("A");
		String [] str2 = arg2.split("A");
		if(g.verifContradiction(Integer.parseInt(str1[1]) - 1,Integer.parseInt(str2[1]) - 1)) {
			return true;
		}
		return false;
	}
	
	/**
	 * fonction permet de vérifier s'il existe une contradiction entre n et arg
	 * @param n l'indice d'argument dans la matrice d'adjacence qui contredit 
	 * @param arg l'argument qui subit la contradiction
	 * @return renvoie true si n contredit arg et faux sinon*/
	private boolean verif2(int n,String arg,Debat g) {
		String[] str = arg.split("A");
		if(g.verifContradiction(n, Integer.parseInt(str[1]) - 1)){
			return true;
		}
		return false;
	}
	
	/**
	 * fonction permet de vérifier s'il existe une contradiction entre arg et n
	 * @param arg l'argument qui contredit
	 * @param l'indice d'argument dans la matrice d'adjacence qui subit la contradiction
	 * @return renvoie true si arg contredit n et faux sinon*/
	private boolean verif3(String arg,int n,Debat g) {
		String[] str = arg.split("A");
		if(g.verifContradiction((Integer.parseInt(str[1]) - 1) , n )){
			return true;
		}
		return false;
	}
	
	/**
	 * fonction qui permet d'afficher la solution*/
	public void affichage() {
	    System.out.println("E = "+E);
	}
	
}
