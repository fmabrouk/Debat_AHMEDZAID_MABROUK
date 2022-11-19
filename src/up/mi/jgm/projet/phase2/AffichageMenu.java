package up.mi.jgm.projet.phase2;

import java.util.Scanner;
import up.mi.jgm.projet.phase1.*;
public class AffichageMenu {
    
	
	/**
	 * variable Scanner globale*/
	private static Scanner sc = new Scanner(System.in);
	/**
	 * fonction qui permet d'afficher le menu principal de programme*/
	public static void menuPrincipal(CreerDebat d) {
		System.out.println("Veuillez entrer votre choix: ");
		int choix=0;
		int tailleGraphe= d.tailleGraphe();
		
		do{
			System.out.println("1) Chercher une solution admissible");
			System.out.println("2) Chercher une solution preferee");
			System.out.println("3) Sauvegarder la solution");
			System.out.println("4) fin");

			try{
				choix=sc.nextInt();
				switch(choix){
					case 1:
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
	
	
}


