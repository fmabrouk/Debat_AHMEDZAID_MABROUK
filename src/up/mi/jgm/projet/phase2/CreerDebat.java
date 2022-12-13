package up.mi.jgm.projet.phase2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreerDebat extends Debat {

    private ArrayList<Argument> arguments;

    public ArrayList<Argument> getArguments() {
        return arguments;
    }


    public void setArguments(ArrayList<Argument> arguments) {
        this.arguments = arguments;
    }


    public CreerDebat(){
        arguments=new ArrayList<>();
    }



    /**
     * Méthode qui permet de charger la matrice d'adjacence a partir d'un fichier texte
     * @param f Fichier passe en invite de commandes qui contient le graphe
     */
    public void chargerGraphe(File f){

        
        String ligne=null;
        try(BufferedReader br = new BufferedReader(new FileReader(f));){
            int i=0;
            while((ligne = br.readLine()) != null){
                if(ligne.startsWith("argument")){
                    parseArgument(new Argument(i, ligne));
                    i++;
                    adjMatrice = new boolean[arguments.size()][arguments.size()];
                }
                else if(ligne.startsWith("contradiction")){
                    String [] contradiction = parseContradiction(ligne);
                    try{
                        this.addContradiction(getIndexByArgument(contradiction[0]), getIndexByArgument(contradiction[1]));
                    }catch(ArgumentNotDefinedException e){
                        System.out.println(e.getMessage()); 
                        System.exit(0);
                    }
                }else{
                    throw new IllegalArgumentException("La ligne est incorrecte:\n"+ligne);
                }
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }catch(IOException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        
    }

    
    /**
     * Méthode qui permet de récuperer les informations concernant un argument 
     * Ajout de l'arg dans l'arraylist d'arguments
     * @param arg
     */
    private void parseArgument(Argument arg){
        String [] argumentSplit = new String[3];
        argumentSplit = arg.getArg().split("\\(");
        arg.setArg(argumentSplit[1].substring(0, argumentSplit[1].length()-2));
        arguments.add(arg);           
    }
    
    /**
     * Méthode qui permet de récuperer une contradiction entre arguments
     * @param ligne
     * @return tableau de String qui contient l'arg[0] qui contredit arg[1]
     */
    private String[] parseContradiction(String ligne){
        String [] argumentSplit = new String[3];
        argumentSplit = ligne.split("\\(");
        String sbstrContradicton = argumentSplit[1].substring(0,argumentSplit[1].length()-2);
        argumentSplit = sbstrContradicton.split(",");
        return argumentSplit;
    }


    /**
     * Méthode qui retourne le nombre de sommet d'un graphe (taille)
     * @return taille du l'arraylist arguments
     */
    public int tailleGraphe(){
        return arguments.size();
    }


    /**
     * Méthode qui permet de récuperer l'indice d'un argument passé en parametres
     * @param str
     * @return l'indeice de l'argument dans l'arraylist
     * @throws ArgumentNotDefinedException
     */
    private int getIndexByArgument(String argument) throws ArgumentNotDefinedException{
        for(int i=0 ; i<arguments.size() ; i++){
            if(arguments.get(i).getArg().equals(argument)){
                return arguments.get(i).getIndice();
            }
        }
        throw new ArgumentNotDefinedException("Fichier mal formé\nArgument non prédéfini");
    }

}