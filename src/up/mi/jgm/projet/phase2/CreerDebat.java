package up.mi.jgm.projet.phase2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CreerDebat {

    private static ArrayList<String> arguments;

    public CreerDebat(){
        arguments=new ArrayList<>();
    }
    public  void recupererArguments(){
        String ligne=null;
        String [] temp = new String[3];
        File f = new File("graphe");
        try(BufferedReader br = new BufferedReader(new FileReader(f));){
            ligne=br.readLine();
            while(!ligne.contains("contradiction")){
                // System.out.println(ligne);
                temp = ligne.split("\\(");
                System.out.println("Premier case "+temp[0]+"\nDeuxieme case "+temp[1]);
                ligne = temp[1].substring(0, 1);
                arguments.add(ligne);
                ligne=br.readLine();
            }
            temp = ligne.split("\\(");
            String temp1 = temp[1].substring(0,2);
            temp = temp1.split(",");
            while((ligne = br.readLine()) != null){

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public void chargerGraphe(){

    }
    public int tailleGraphe(){
        return arguments.size();
    }



}
