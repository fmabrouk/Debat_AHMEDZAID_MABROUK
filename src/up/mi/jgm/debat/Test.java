package up.mi.jgm.debat;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphe g = new Graphe(6);
		 Scanner sc = new Scanner(System.in) ;
		System.out.println("Veuillez entrer l'argument qui contredit");
		String arg1 = sc.next();
		System.out.println("Veuillez entrer l'argument qui subit la contradiction");
		String arg2 = sc.next();
		String [] str1 = arg1.split("A");
		String[] str2 = arg2.split("A");
		//print(str1);
		//System.out.println(str1[1]);
		
		
		g.addContradiction(Integer.parseInt(str1[1]) - 1, Integer.parseInt(str2[1]) - 1);
		System.out.print(g.toString());
		
	}
	
	static void print(String[] arr) {
        System.out.println(Arrays.toString(arr));
    }

	/*Résultat 
	 * Veuillez entrer l'argument qui contredit
	A1
	Veuillez entrer l'argument qui subit la contradiction
	A2
	0: 0 1 0 0 0 0 
	1: 0 0 0 0 0 0 
	2: 0 0 0 0 0 0 
	3: 0 0 0 0 0 0 
	4: 0 0 0 0 0 0 
	5: 0 0 0 0 0 0 

	 * */
}
