package up.mi.jgm.projet.phase2;

import java.util.Scanner;
import up.mi.jgm.projet.phase1.*;
public class AffichageMenu {
    
	
	/**
	 * variable Scanner globale*/
	private static Scanner sc = new Scanner(System.in);
	/**
	 * fonction qui permet d'afficher le menu principal de programme*/
	public static void menuPrincipal() {
		System.out.println("Veuillez entrer le nombre d'arguments ?");
		CreerDebat d =new CreerDebat();
        int n= d.tailleGraphe();
		Debat g = new Debat(n);
		int choix = 0;
		do {
			System.out.println("1)ajouter une contradiction");
			System.out.println("2)fin");
			choix = sc.nextInt();
			switch(choix) {
			case 1:
				System.out.println("Veuillez entrer les deux arguments qui se contredisent (un argument par ligne)");
				String chaine1 = sc.next();
				String chaine2 = sc.next();
				String[] str1 = chaine1.split("A");
				String[] str2 = chaine2.split("A");
				if(Integer.parseInt(str1[1]) > n || Integer.parseInt(str2[1]) > n ){
					System.out.println("L'argument entree n'est pas valide");
				}else{
					g.addContradiction(Integer.parseInt(str1[1]) - 1, Integer.parseInt(str2[1]) - 1);
				}
				break;
			case 2: 
				menu2(g,n);
				break;
			default:
				System.out.println("Il n'y a pas d'option "+choix+" ,réssayez (entre 1 et 2) ");
			}
		}while(choix != 0);
		sc.close();
	}
	
	
	/**
	 * fonction qui permet d'afficher la deuxiéme menu de programme
	 * @param g le graphe modélisant le débat
	 * @param n le nombre d'argument*/
	private static void menu2(Debat g,int n) {
		Solution sol = new Solution();
		int choix1 = 0;
		do {
			System.out.println("1)ajouter un argument");
			System.out.println("2)retirer un argument");
			System.out.println("3)vérifier la solution");
			System.out.println("4)fin");
			choix1 = sc.nextInt();
			switch(choix1) {
			case 1:
				System.out.println("Veuillez entrer le nom d'argument?");
				String arg = sc.next();
				sol.ajouteArgument(arg);
				break;
			case 2:
				System.out.println("Veuillez entrer l'argument à retirer");
				String arg1 = sc.next();
				sol.retireArgument(arg1);
				break;
			case 3:
				sol.affichage();
				if(sol.solutionAdmissible(g, n)) {
					System.out.println("la solution est admissible");
				} else {
				System.out.println("la solution n'est pas admissible");
				}
				break;
			case 4:
				sol.affichage();
				if(sol.solutionAdmissibleSansErreur(g, n)) {
					System.out.println("la solution est admissible");
				} else {
				System.out.println("la solution n'est pas admissible");
				}
				System.exit(0);
				break;
			default:
				System.out.println("Il n'y a pas d'option "+choix1+" ,réssayez (entre 1 et 4) ");
			}
		}while(choix1 != 0);
	}
	
	
}


