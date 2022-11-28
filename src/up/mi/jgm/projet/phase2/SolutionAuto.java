package up.mi.jgm.projet.phase2;
import java.util.ArrayList;

import up.mi.jgm.projet.phase1.*;
public class SolutionAuto extends Solution{

    private ArrayList<String> solutionAffiches;

    public SolutionAuto(){
        super();
        solutionAffiches=new ArrayList<>();
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


    /**
     * Méthode qui permet de rechrcher une solution admissible 
     * @param g le debat qui a été chargé a partir du fichier "graphe"
     * @param tailleGraphe la taille du graphe
     * @return true si une solution a été trouvée sinon false
     */
    public boolean solutionAdmissibleAuto(CreerDebat g, int tailleGraphe){
        Boolean[][] tableVeriteArguments = TableVerite.generateTruthTable(tailleGraphe-1);
        
        for(int i=0 ; i<Math.pow(2, tailleGraphe-1) ;i++){
            remplirEnsemble(g.getArguments(),tableVeriteArguments,i);

                if(this.solutionAdmissible(g, tailleGraphe-1) && !this.isSolutionDejaAffiche()){
                        solutionAffiches.add(this.toString());
                        this.affichageEnsembleSolution();
                        return true;
                }
            
        }

        if(!solutionAffiches.isEmpty()){
            System.out.println("Solution admissible = ["+solutionAffiches.get(0)+"]");
            solutionAffiches.remove(0);
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
        for(int i=0 ; i<args.size()-1 ; i++ ){
            if(tableVerite[ligne][i] == true){
                this.ajouteArgument(args.get(i));
            }
        }
    
    }

    
<<<<<<< HEAD
}
=======
}
>>>>>>> a3c2ea1b9e7f3e25be6ca6ea3612f593a738a6e2
