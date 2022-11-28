package up.mi.jgm.projet.phase2;

import java.io.File;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreerDebat debat = new CreerDebat();
        File f = new File("graphe.txt");
        debat.chargerGraphe(f);
       // AffichageMenu.menuPrincipal(debat);
        SolutionAuto s = new SolutionAuto();
        int n = debat.tailleGraphe();
        System.out.println("Taille de graphe = "+ n);
        s.solutionAdmissibleAuto(debat, n);

	}

}
