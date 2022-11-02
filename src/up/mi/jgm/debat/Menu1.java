package up.mi.jgm.debat;

import java.util.Scanner;

public class Menu1 {
	
	
	
	
	public static void printMenu1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrer le nombre d'arguments n ");
		int n = sc.nextInt();
		menuAffichage();
		int choix =sc.nextInt();
		if((choix < 1) || (choix > 2)) {
			System.err("Le choix "+ choix +" n'est pas valide");
			System.exit(1);
		}
		switch (choix) {
		case 1:
			
		}
	}
	
	/**
	 * fonction permet d'afficher les choix 
	*/
	private static void menuAffichage() {
		System.out.println(" 1) ajouter une contradiction");
		System.out.println(" 2) fin");
	}
	private static void afficheAjouterContradiction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrer les arguments qui se contredisent (un argument par ligne) ");
		System.out.println("Veuillez entrer l'argument qui contredit");
		String arg1 = sc.next();
		System.out.println("Veuillez entrer l'argument qui subit la contradiction");
		String arg2 = sc.next();
		String[] str1 = arg1.split("A");
		String[] str2 = arg2.split("A");
	}
}
