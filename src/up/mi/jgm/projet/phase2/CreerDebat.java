package up.mi.jgm.projet.phase2;

import up.mi.jgm.projet.phase1.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreerDebat {

    private ArrayList<Argument> arguments= new ArrayList<>();

    public CreerDebat(){
        arguments=new ArrayList<>();
    }


    public void chargerGraphe(File f){

        
        String ligne=null;
        try(BufferedReader br = new BufferedReader(new FileReader(f));){
            int i=0;
            do{
                ligne=br.readLine();
                compterArgument(new Argument(i, ligne));
                i++;
            }while(!ligne.contains("contradiction"));
            Debat d = new Debat(tailleGraphe());
            do{
                String [] contradiction = creerContradiction(ligne);
                try{
                    d.addContradiction(getIndexByArgument(contradiction[0]), getIndexByArgument(contradiction[1]));
                }catch(ArgumentNotDefinedException e){
                    System.out.println(e.getMessage()); 
                    System.exit(0);
                }
                
            }while((ligne = br.readLine()) != null);
            
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }catch(IOException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        
    }

    
    public void compterArgument(Argument arg){
        String [] argumentSplit = new String[3];
        argumentSplit = arg.getArg().split("\\(");
        arg.setArg(argumentSplit[1].substring(0, 1));
        arguments.add(arg);           
    }
    
    public String[] creerContradiction(String ligne){
        String [] argumentSplit = new String[3];
        argumentSplit = ligne.split("\\(");
        String sbstrContradicton = argumentSplit[1].substring(0,3);
        argumentSplit = sbstrContradicton.split(",");
        return argumentSplit;
    }

    public int tailleGraphe(){
        return arguments.size();
    }

    public int getIndexByArgument(String str) throws ArgumentNotDefinedException{
        for(int i=0 ; i<arguments.size() ; i++){
            if(arguments.get(i).getArg().equals(str)){
                return arguments.get(i).getIndice();
            }
        }
        throw new ArgumentNotDefinedException("Fichier mal formé\nArgument non prédéfini");
    }

}
