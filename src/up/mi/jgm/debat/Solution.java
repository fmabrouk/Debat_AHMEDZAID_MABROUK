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
	
	public boolean solutionAdmissible(Graphe g) {
		if(E.isEmpty()) {
			System.out.println("La solution est vide donc admissible ");
			return true;
		}
		if(condition1(g) && condition2(g)) {
			return true;
		}
		return false;
		
	}
	
	private boolean condition2(Graphe g) {
		if(E.size() == 1) {
			return true;
		}else {
			for(int i=0;i<E.size();i++) {
				for(int j = 0;j < E.size();j++) {
					if(verif(E.get(i),E.get(j),g) && verif(E.get(j),E.get(i),g)) {
						return true;
					}
				}
			}
		}
		return false;

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
	
	public void affichage() {
	    if(E.isEmpty())
	    	System.out.println("La solution est vide");
	    System.out.println("E = "+E);
	}
	
}
