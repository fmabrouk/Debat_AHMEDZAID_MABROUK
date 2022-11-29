package up.mi.jgm.projet.phase2;
import java.util.ArrayList;

import up.mi.jgm.projet.phase1.*;
public class SolutionAuto extends Solution{

    private ArrayList<String> solutionAffiches;
    private ArrayList<String> solutionAdmissibles;
    
    private int j = 0;
    
    public SolutionAuto(){
        super();
        solutionAffiches=new ArrayList<>();
       solutionAdmissibles = new ArrayList<>();
    }


    /**
     * Vérifie si une solution a déja été affiché
     * @return true si elle a déjà été affichée sinon false
     */
    private boolean isSolutionDejaAffiche(){
        for(int i=0 ; i<solutionAffiches.size() ; i++){ 
            if(this.ensembleSoltoString().equals(solutionAffiches.get(i))){
                return true;
            }
        }
        return false;
    }

	 public void solutionPrefereeAuto(CreerDebat g, int tailleGraphe,Boolean[][] tableVerite){
	        
	        for(int i=0 ; i<Math.pow(2, tailleGraphe) ;i++){
	            remplirEnsemble(g.getArguments(),tableVerite,i);
	                if(this.solutionAdmissible(g, tailleGraphe-1)){
	                		this.ensembleSoltoString();
	                        solutionAdmissibles.add(this.toString());
	                }
	        }
	        affichage(solutionAdmissibles);  
	 }
	 
	 public void solutionPrefere(CreerDebat g, int tailleGraphe,Boolean[][] tableVerite) {
		 this.solutionPrefereeAuto(g, tailleGraphe, tableVerite);
		 if(solutionAdmissibles.size() == 1) {
			 System.out.println("ensemble prefere =  ensemble vide");
		 }
		 for(int i=1;i<solutionAdmissibles.size();i++) {
			 
			 if( i == solutionAdmissibles.size() - 1) {
				 System.out.println("ensemble prefere = "+solutionAdmissibles.get(i));
			 }
			 for(int j = 1;j<solutionAdmissibles.size();j++) {
				 
				 if(solutionAdmissibles.get(i) != (solutionAdmissibles.get(j))) {
					 if(!inclusion(solutionAdmissibles.get(i),solutionAdmissibles.get(j))) {
						 //System.out.println("ensemble prefere = "+ solutionAdmissibles.get(i));
						 
						 if(j == solutionAdmissibles.size() - 1) {
							 System.out.println("ensemble prefere = "+solutionAdmissibles.get(i));
						 }
					 }
					 else {
						 return false;
					 }
					 
				 }
			 }
			 
		 }
	 }
	 
	private boolean inclusion(String s1,String s2) {
		
//			System.out.println("s1.charAt("+i+") : "+s1.charAt(i));
//		System.out.println("s2 = "+s2);
//		System.out.println("s1 = "+s1);
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
                if(this.solutionAdmissible(g, tailleGraphe-1) && !this.isSolutionDejaAffiche()){
                        solutionAffiches.add(this.toString());
                        this.affichageEnsembleSolution();
                        return true;
                }
               
        }
        
        //System.out.println(solutionAffiches);
        
        if(!solutionAffiches.isEmpty()){

           // System.out.println("ensemble vide");
        	if(j==solutionAffiches.size()) {
        		j = 0;
        	}
        		
        	if(j == 0) {
        		System.out.print("ensemble vide");
        		
        	}
        	
        	
        	if(solutionAffiches.get(j).length() > 1) {
        		for(int k =0;k <solutionAffiches.get(j).length();k++) {
        			if(k==0) {
        				System.out.print(solutionAffiches.get(j).charAt(k));
        			}
        			else {
        			System.out.print(","+solutionAffiches.get(j).charAt(k));
        			}
        		}
        		 System.out.println();
        	} else  {
        		System.out.println(solutionAffiches.get(j));
        	}
        	
        	j++;
           // System.out.println("Solution admissible = ["+solutionAffiches.get(0)+"]");

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
    
    private void affichage(ArrayList<String> E) {
    	System.out.println("E = " + E);
    }
    
   
    

    
}