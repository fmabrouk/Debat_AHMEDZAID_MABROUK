package up.mi.jgm.projet.phase2;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//Classe representant la gestion de solutions d'une maniere automatique et la sauvegarde dans le fichier
public class SolutionAuto extends Solution{
	
	//Attributs:
	//ArrayList contenant tous les solutions admissibles 
    private ArrayList<String> solutionAdmissibles;
    
    //ArrayList contenant tous les solutions preferes 
	private ArrayList<String> solutionPreferees;
	
	//Attribut pour sauvegarder dans le ficher la derniere solutions affichee
	private String derniereSolutionAffiche;
	
	//Attribut le nom de ficher pour sauvegarder la solution
	private String path;
    
    //Constructeur de la classe solutionAuto
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
			//remplir la table de vérité
        	remplirSolutionAdmissible(g, tailleGraphe, tableVerite);
		}
        affichageSolution(solutionAdmissibles);
    }
	 
    /**
     * Méthode qui permet de rechrcher une solution preferee 
     * @param g le debat qui a été chargé a partir du fichier "graphe"
     * @param tailleGraphe la taille du graphe
     * @param tableverite a remplir
     */
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
	
	
	/**
	 * fonction qui permet de sauvegarder la solution dans le fichier*/
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
	
	/**
	 * fonction qui permet de remplir tous les solutions admissibles dans le table de verité
	 * @param g la graphe de notre debat
	 * @param tailleGraphe la taille de notre graphe
	 * @param tableVerite la table de verite a remplir */
	private void remplirSolutionAdmissible(CreerDebat g, int tailleGraphe,Boolean[][] tableVerite){
	    solutionAdmissibles.clear();
	    for(int i=0 ; i<Math.pow(2, tailleGraphe) ;i++){
	        remplirEnsemble(g.getArguments(),tableVerite,i);
                if(this.solutionAdmissible(g, tailleGraphe-1)){
                    solutionAdmissibles.add(this.toString());
                }
        }
	}
	
	/**
	 * fonction permet d'afficher la solution avec les virgules
	 * @param sol ArrayList des solutions a afficher*/
	private void affichageSolution(ArrayList<String> sol){
		
		int j=0;
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
		
	}
	
	/**
	 * Méthode qui vérifie si un ensemble est inclus dans un autre
	 * @param s1 ensemble de solution admissible 1
	 * @param s2 ensemble de solution admissible 2
	 * @return true si S1 est inclus dans S2
	 */
	private boolean inclusion(String s1,String s2) {
		int i=0;
		int j=0;
		boolean inclus=false;
		if(s2.length() > s1.length()){
			System.out.println(s1+" "+s2);
			String[] s1Split = s1.split(" ");
			String[] s2Split = s2.split(" ");
			while(i<s1Split.length){
				inclus=false;
				j=0;
				while(j<s2Split.length && !inclus){
					if(s1Split[i].equals(s2Split[j])){
							inclus = true;
					}
					j++;
				}
				if(inclus==false){
					return false;
				}
				i++;
			}
			if(inclus){
				return true;
			}else
				return false;
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
    
    /**
     * fonction qui permet de lire le chemin d'accés vers le fichier
     * @param sc le chemin de fichier à taper*/
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
	
	
	/**
	 * fonction qui permet d'afficher la solution dans le fihcer 
	 * */
	private void affichageSolutionFichier(){
		StringBuilder sb = new StringBuilder();
		if(derniereSolutionAffiche.length() > 1){
			String[] arguments = derniereSolutionAffiche.split(" ");	
			sb.append(arguments[0]);
			if(arguments.length > 1){
				for(int i=1 ; i<arguments.length ; i++){
					sb.append(","+arguments[i]);
				}
				sb.append("\n");
			}
			
			derniereSolutionAffiche = sb.toString();

		}
	} 
}