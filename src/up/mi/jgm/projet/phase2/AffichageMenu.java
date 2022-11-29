package up.mi.jgm.projet.phase2;

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
			System.out.println("1) Chercher une solution admissible");
			System.out.println("2) Chercher une solution preferee");
			System.out.println("3) Sauvegarder la solution");
			System.out.println("4) fin");

			try{
				choix=sc.nextInt();
				switch(choix){
					case 1:
						s.solutionAdmissibleAuto(d, tailleGraphe,tableVeriteArguments);
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					default:
						break;
				}

			}catch(IllegalArgumentException e){
				e.printStackTrace();
			}
			
		}while(choix != 4);

	}
	
	
<<<<<<< HEAD
}
=======
}
>>>>>>> 83696112eed9ff8897ff5a3c26f84fc909cf66cd
