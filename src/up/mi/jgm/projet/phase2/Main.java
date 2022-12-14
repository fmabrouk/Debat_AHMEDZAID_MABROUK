package up.mi.jgm.projet.phase2;

import java.io.File;


//Classe representant notre main de projet
public class Main {

    public static void main(String[] args){
        CreerDebat debat = new CreerDebat();
        File f = new File(args[0]);
        try{
            debat.chargerGraphe(f);

        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        AffichageMenu.menuPrincipal(debat);
        
       
    }
}