package up.mi.jgm.projet.phase2;

import java.io.File;

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
<<<<<<< HEAD
}
=======
}
>>>>>>> a3c2ea1b9e7f3e25be6ca6ea3612f593a738a6e2
