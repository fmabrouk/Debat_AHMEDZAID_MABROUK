package up.mi.jgm.debat;

import java.util.ArrayList;


public class Solution {
	private static  ArrayList<String> E;
	
	public  Solution() {
		E = new ArrayList<String>();
		
	}
	
	public  void AjouteArgument(String arg) {
		if(E.contains(arg))
			System.out.println(" Argument "+arg +" déjà dans la solution");
		
		else {
			E.add(arg);
		}
	}
	
	public  void retireArgument(String arg) {
		if(!E.contains(arg))
			System.out.println(" Argument "+ arg +" n'est pas dans la solution");
		else {
			E.remove(arg);
		}
	}
	
	public boolean solutionAdmissible(Graphe g,int n) {
		if(E.isEmpty()) {
			System.out.println("La solution est vide donc admissible ");
			return true;
		}
		if(condition1(g) && condition2(g,n)) {
			return true;
		}
		return false;
		
	}
	/*
	private boolean condition2(Graphe g,int n) {
		for(int i=0;i< n;i++) {
			for(int j= 0;j<E.size();) {
				if(verif2(i,E.get(j),g) && verif3(E.get(j),i,g)) {
					return true;
				}
				System.out.println("l'argument "+E.get(j)+ " ne se defend pas contre A"+ (i+1));
				return false;
				}
		}
		return false;

	}
	*/
	
	private boolean condition2(Graphe g,int n) {
		for(int i=0;i< n;i++) {
			for(int j= 0;j<E.size();j++) {
				//System.out.println(" i :" +i +" || j : "+j);
				if(verif2(i,E.get(j),g)) {
					if(!verif3(E.get(j),i,g)) {
						//System.out.println("E.get("+j+") : "+E.get(j));
						//System.out.println("i : "+i);
						System.out.println("l'argument "+E.get(j)+ " ne se defend pas contre A"+ (i+1));
						return false;
					}
					
					//return false;
				}
			}

		}
		return true;

	}
	
	private boolean condition1(Graphe g) {
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
	
	private boolean verif(String arg1,String arg2,Graphe g) {
		String[] str1 = arg1.split("A");
		String [] str2 = arg2.split("A");
		if(g.verifContradiction(Integer.parseInt(str1[1]) - 1,Integer.parseInt(str2[1]) - 1)) {
			return true;
		}
		return false;
		
	}
	
	private boolean verif2(int n,String arg,Graphe g) {
		String[] str = arg.split("A");
		if(g.verifContradiction(n, Integer.parseInt(str[1]) - 1)){
			return true;
		}
		return false;
	}
	
	private boolean verif3(String arg,int n,Graphe g) {
		String[] str = arg.split("A");
		//System.out.println("Arg : "+arg+" || n : "+n);
		//System.out.println("(Integer.parseInt(str[1]) - 1) : "+(Integer.parseInt(str[1]) - 1));
		if(g.verifContradiction((Integer.parseInt(str[1]) - 1) , n )){
			return true;
		}
		return false;
	}
	
	public void affichage() {
	    if(E.isEmpty())
	    	System.out.println("La solution est vide");
	    System.out.println("E = "+E);
	}
	
}
