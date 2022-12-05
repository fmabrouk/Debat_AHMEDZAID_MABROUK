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

    private ArrayList<String> solutionAdmissibleAffiches;
    private ArrayList<String> solutionAdmissibles;
	private ArrayList<String> solutionPreferees;
	private String derniereSolutionAffiche;
	private String path;
    
    private int j = 0;
    
    public SolutionAuto(){
        super();
        solutionAdmissibleAffiches=new ArrayList<>();
    	solutionAdmissibles = new ArrayList<>();
		solutionPreferees=new ArrayList<>();
    }


    /**
     * Vérifie si une solution a déja été affiché
     * @return true si elle a déjà été affichée sinon false
     */
    private boolean isSolutionDejaAffiche(){
        for(int i=0 ; i<solutionAdmissibleAffiches.size() ; i++){ 
            if(this.ensembleSoltoString().equals(solutionAdmissibleAffiches.get(i))){
                return true;
            }
        }
        return false;
    }

	public void solutionPrefereeAuto(CreerDebat g, int tailleGraphe,Boolean[][] tableVerite){
	    solutionAdmissibles.clear();
	    for(int i=0 ; i<Math.pow(2, tailleGraphe) ;i++){
	        remplirEnsemble(g.getArguments(),tableVerite,i);
                if(this.solutionAdmissible(g, tailleGraphe-1)){
                		this.ensembleSoltoString();
                        solutionAdmissibles.add(this.toString());
                }
        }
	        //affichage(solutionAdmissibles);  
	}
	 
	public void solutionPrefere(CreerDebat g, int tailleGraphe,Boolean[][] tableVerite) {
		this.solutionPrefereeAuto(g, tailleGraphe, tableVerite);
		if(solutionAdmissibles.size() == 1) {
			System.out.println(" "); 
		}
		solutionPreferees.clear();
		for(int i=1;i<solutionAdmissibles.size();i++) {
			boolean defense = false;
			if( i == solutionAdmissibles.size() - 1) {
				solutionPreferees.add(solutionAdmissibles.get(i)); 
			}
			for(int j = 1;j<solutionAdmissibles.size();j++) {
				if(defense == false) {
					if(!solutionAdmissibles.get(i).equals(solutionAdmissibles.get(j))) {
						if(!inclusion(solutionAdmissibles.get(i),solutionAdmissibles.get(j))) {
							 //System.out.println("ensemble prefere = "+ solutionAdmissibles.get(i));
							if(j == solutionAdmissibles.size() - 1) {
								solutionPreferees.add(solutionAdmissibles.get(i));
								 
							}
						}
						else {
							//return false;
							defense = true;
						}
						 
					}
				}
				
			}
			 
		}

		if(!solutionPreferees.isEmpty()){
			// System.out.println("ensemble vide");
			 if(j==solutionPreferees.size()) {
				 j = 0;
			 }	
			
			 if(solutionPreferees.get(j).length() > 1) {
				 for(int k =0;k <solutionPreferees.get(j).length();k++) {
					 if(k==0) {
						 System.out.print(solutionPreferees.get(j).charAt(k));
					 }
					 else {
					 System.out.print(","+solutionPreferees.get(j).charAt(k));
					 }
				 }
				  System.out.println();
			 } else  {
				 System.out.println(solutionPreferees.get(j));
			 }
			 derniereSolutionAffiche=solutionPreferees.get(j);
			 j++;
			// System.out.println("Solution admissible = ["+solutionAdmissibleAffiches.get(0)+"]");
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
     * Méthode qui permet de rechrcher une solution admissible 
     * @param g le debat qui a été chargé a partir du fichier "graphe"
     * @param tailleGraphe la taille du graphe
     * @return true si une solution a été trouvée sinon false
     */
    public boolean solutionAdmissibleAuto(CreerDebat g, int tailleGraphe,Boolean[][] tableVerite){
        
        for(int i=0 ; i<Math.pow(2, tailleGraphe) ;i++){
            remplirEnsemble(g.getArguments(),tableVerite,i);
                if(this.solutionAdmissible(g, tailleGraphe) && !this.isSolutionDejaAffiche()){
                        solutionAdmissibleAffiches.add(this.toString());
                        this.affichageEnsembleSolution();
						derniereSolutionAffiche = solutionAdmissibleAffiches.get(solutionAdmissibleAffiches.size()-1);
                        return true;
                }  
        }
        
        //System.out.println(solutionAdmissibleAffiches);
        if(!solutionAdmissibleAffiches.isEmpty()){
           // System.out.println("ensemble vide");
        	if(j==solutionAdmissibleAffiches.size()) {
        		j = 0;
        	}	
        	if(j == 0) {
        		System.out.print(" ");
        	}
        	if(solutionAdmissibleAffiches.get(j).length() > 1) {
        		for(int k =0;k <solutionAdmissibleAffiches.get(j).length();k++) {
        			if(k==0) {
        				System.out.print(solutionAdmissibleAffiches.get(j).charAt(k));
        			}
        			else {
        			System.out.print(","+solutionAdmissibleAffiches.get(j).charAt(k));
        			}
        		}
        		 System.out.println();
        	} else  {
        		System.out.println(solutionAdmissibleAffiches.get(j));
        	}
			derniereSolutionAffiche = solutionAdmissibleAffiches.get(j);
        	j++;
           // System.out.println("Solution admissible = ["+solutionAdmissibleAffiches.get(0)+"]");
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

	public void sauvegarderSolution(){

		if(solutionAdmissibleAffiches.isEmpty() && solutionPreferees.isEmpty()){
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
				}catch(InputMismatchException e){
					e.printStackTrace();
				}
		}
	}

	private void lireChemin(Scanner sc ){
		
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
}