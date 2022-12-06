package up.mi.jgm.projet.phase2;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import up.mi.jgm.projet.phase1.*;
public class SolutionAuto extends Solution{

    private ArrayList<String> solutionAdmissibles;
	private ArrayList<String> solutionPreferees;
	private String derniereSolutionAffiche;
	private String path;
    
    private int j = 0;
    
    public SolutionAuto(){
    	solutionAdmissibles = new ArrayList<>();
		solutionPreferees=new ArrayList<>();
    }

	 /**
     * Méthode qui permet de rechrcher une solution admissible 
     * @param g le debat qui a été chargé a partir du fichier "graphe"
     * @param tailleGraphe la taille du graphe
     * @return true si une solution a été trouvée sinon false
     */
    public void solutionAdmissibleAuto(CreerDebat g, int tailleGraphe,Boolean[][] tableVerite){
		if(solutionAdmissibles.isEmpty()){
        	remplirSolutionAdmissible(g, tailleGraphe, tableVerite);
		}
        affichageSolution(solutionAdmissibles);
    }
	 
	public void solutionPrefere(CreerDebat g, int tailleGraphe,Boolean[][] tableVerite) {
		int j=0;
		if(solutionPreferees.isEmpty()){
			this.remplirSolutionAdmissible(g, tailleGraphe, tableVerite);
			solutionPreferees.clear();
			for(int i=1;i<solutionAdmissibles.size();i++) {
				boolean inclus = false;
				j=1;
				while(j<solutionAdmissibles.size() && !inclus){
						if(!solutionAdmissibles.get(i).equals(solutionAdmissibles.get(j))) {
							if(inclusion(solutionAdmissibles.get(i),solutionAdmissibles.get(j))) {
								inclus=true;
							} 
						}
						j++;
				}
				if(!inclus){
					solutionPreferees.add(solutionAdmissibles.get(i));
				}
			}
			
		}
		affichageSolution(solutionPreferees);
	}

	public void sauvegarderSolution(){

		if(solutionAdmissibles.isEmpty()){
			System.out.println("Veuillez choisir une option 1 ou 2");
		}else{
				Scanner sc = new Scanner(System.in);
				lireChemin(sc);
				File f = new File(path);
				if(!f.exists()){
					try{
						f.createNewFile();
					}catch(IOException e){
						e.printStackTrace();
					}
				}
				try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(path))){
					if(derniereSolutionAffiche.length() > 1){
						affichageSolutionFichier();;
					}
					bWriter.write(derniereSolutionAffiche);
				}catch(FileNotFoundException e){
					e.printStackTrace();
				}catch(IOException e){
					e.printStackTrace();
				}
		}
	}

	private void remplirSolutionAdmissible(CreerDebat g, int tailleGraphe,Boolean[][] tableVerite){
	    solutionAdmissibles.clear();
	    for(int i=0 ; i<Math.pow(2, tailleGraphe) ;i++){
	        remplirEnsemble(g.getArguments(),tableVerite,i);
                if(this.solutionAdmissible(g, tailleGraphe-1)){
                    solutionAdmissibles.add(this.toString());
                }
        }
	}

	private void affichageSolution(ArrayList<String> sol){
		
		
		String[] arguments = sol.get(j).split(" ");
		if(arguments.length == 1){
			System.out.println(arguments[0]);
		}else{
			System.out.print(arguments[0]);
			for(int i=1 ; i<arguments.length ; i++){
				System.out.print(","+arguments[i]);
			}
			System.out.println();
		}
		derniereSolutionAffiche=sol.get(j);
		sol.remove(j);
		
		// if(sol.get(j).length() > 1) {
		// 	for(int k =0;k <sol.get(j).length();k++) {
		// 		if(k==0) {
		// 			System.out.print(sol.get(j).charAt(k));
		// 		}
		// 		else {
		// 		System.out.print(","+sol.get(j).charAt(k));
		// 		}
		// 	}
		// 	System.out.println();
		// }else{
		// 	System.out.println(sol.get(j));
		// }
		
	}
	
	/**
	 * Méthode qui vérifie si un ensemble est inclus dans un autre
	 * @param s1 ensemble de solution admissible 1
	 * @param s2 ensemble de solution admissible 2
	 * @return true si S1 est inclus dans S2
	 */
	private boolean inclusion(String s1,String s2) {
		if(s2.contains(s1)) {	
			return true;
		}
		return false;
	}
	 
    /**
     * Remplit l'ensemble de solution a partir de la table de vérité 
     * @param args les arguments du débat
     * @param tableVerite la table de vérité par rapport au nombre d'arguments
     * @param ligne la ligne de la table de vérité 
     */
    private void remplirEnsemble(ArrayList<Argument> args,Boolean[][] tableVerite,int ligne){
        
        this.getEnsembleSolution().clear();
        for(int i=0 ; i<args.size() ; i++ ){
            if(tableVerite[ligne][i] == true){
                this.ajouteArgument(args.get(i));
            }
        }   
	}

	private void lireChemin(Scanner sc){
		
		boolean lectureOK = false;

		while (!lectureOK) {
			try {
				System.out.print("Veuillez entrer le chemin du fichier");
				path = sc.nextLine();
				lectureOK = true;
			} catch (InputMismatchException e) {
				System.out.println("Le chemin n'a pas été trouvé");
				sc.nextLine();
			}
		}
		
	}

	private void affichageSolutionFichier(){
		StringBuilder sb = new StringBuilder();
		if(derniereSolutionAffiche.length() > 1){
			for(int k =0;k <derniereSolutionAffiche.length();k++) {
				if(k==0) {
					sb.append(derniereSolutionAffiche.charAt(k));	
				}
				else {
					sb.append(","+derniereSolutionAffiche.charAt(k));
				}
			}
			derniereSolutionAffiche = sb.toString();

		}
	} 
}