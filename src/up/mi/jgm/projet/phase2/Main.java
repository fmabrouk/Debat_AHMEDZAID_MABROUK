package up.mi.jgm.projet.phase2;

import java.io.File;

//Classe répresentant la main de notre programme 
public class Main {

    public static void main(String[] args){
    	//Creer la grahe de notre debat à partir de fichier qui est passé en argument
        CreerDebat debat = new CreerDebat();
        File f = new File(args[0]);
        try{
        	//charger le debat dans un graphe
            debat.chargerGraphe(f);

        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        //affichage de menu Principal
        AffichageMenu.menuPrincipal(debat);
        
       
    }
}