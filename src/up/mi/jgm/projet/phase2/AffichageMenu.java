package up.mi.jgm.projet.phase2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AffichageMenu {
    
	
	
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Méthode qui affiche le menu et exécute les différentes fonctionnalités du projet
	 * @param d le debat qui a été chargé à partir du fichier graphe
	 */
	public static void menuPrincipal(CreerDebat d) {
		System.out.println("Veuillez entrer votre choix: ");
		int choix=0;
		int tailleGraphe= d.tailleGraphe();
		SolutionAuto s = new SolutionAuto();
		
		Boolean[][] tableVeriteArguments = TableVerite.generateTruthTable(tailleGraphe);
		

		do{
			affichageOptions();
			choix = lireLeChoixDeUI(sc);
			switch(choix){
				case 1:
					s.solutionAdmissibleAuto(d, tailleGraphe,tableVeriteArguments);
					break;
				case 2:
					s.solutionPrefere(d, tailleGraphe, tableVeriteArguments);
					break;
				case 3:
					s.sauvegarderSolution();
					break;
				case 4:
					break;
				default:
					System.out.println("Veuillez choisir un nombre entre 1 et 4");
					break;
			}

		}while(choix != 4);
		sc.close();
	}

	private static void affichageOptions(){
		System.out.println("1) Chercher une solution admissible");
		System.out.println("2) Chercher une solution preferee");
		System.out.println("3) Sauvegarder la solution");
		System.out.println("4) fin");
	}

	private static int lireLeChoixDeUI(Scanner sc){
		int choix = 0;
		boolean lectureOK = false;

		while (!lectureOK) {
			try {
				choix = sc.nextInt();
				lectureOK = true;
			} catch (InputMismatchException e) {
				System.out.println("La chaine de caracteres est interdite\nVeuillez entrer un nombre entre 1 et 4");
				affichageOptions();
				sc.nextLine();
			}
		}
		return choix;
	}
	
	
}
