package up.mi.jgm.debat;

import java.util.Scanner;

public class Menu {
	
	private static Scanner sc = new Scanner(System.in) ;
	
	
	
	public static void printMenu1() {
		
		System.out.println("Veuillez entrer le nombre d'arguments n ");
		int n = sc.nextInt();
		menuAffichage();
		System.out.println("Veuillez entrer votre choix ");
		int choix = sc.nextInt();
		if((choix < 1) || (choix > 2)) {
			System.err.println("Le choix "+ choix +" n'est pas valide");
			System.exit(1);
		}
		switch (choix) {
		case 1:
			afficheAjouterContradiction(n);
			break;
		case 2:
			printMenu2();
			break;
		}
	}
	
	/**
	 * fonction permet d'afficher les choix 
	*/
	private static void menuAffichage() {
		System.out.println(" 1) ajouter une contradiction");
		System.out.println(" 2) fin");
	}
	private static void afficheAjouterContradiction(int n) {
		Graphe g = new Graphe(n);
		System.out.println("Veuillez entrer les arguments qui se contredisent (un argument par ligne) ");
		System.out.println("Veuillez entrer l'argument qui contredit");
		String arg1 = sc.next();
		System.out.println("Veuillez entrer l'argument qui subit la contradiction");
		String arg2 = sc.next();
		String[] str1 = arg1.split("A");
		String[] str2 = arg2.split("A");
		g.addContradiction(Integer.parseInt(str1[1]), Integer.parseInt(str2[1]));
	}
	
	public static void printMenu2() {
		menu2Affichage();
		System.out.println("Veuillez entrer votre choix ");
		int choix = sc.nextInt();
		if((choix < 1) || (choix > 4)) {
			System.err.println("Le choix "+ choix +" n'est pas valide");
			System.exit(1);
		}
		switch(choix) {
		case 1:
			
		}
	}
	
	private static void menu2Affichage() {
		System.out.println(" 1) ajouter un argument ");
		System.out.println(" 2) retirer un argument ");
		System.out.println(" 3) vérifier la solution ");
		System.out.println(" 4) fin ");
	}
	
}
