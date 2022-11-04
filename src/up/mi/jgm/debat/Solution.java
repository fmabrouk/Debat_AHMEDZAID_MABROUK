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
	
	
	public void affichage() {
	    if(E.isEmpty())
	    	System.out.println("La solution est vide");
	    System.out.println(E);
	}
	
}
