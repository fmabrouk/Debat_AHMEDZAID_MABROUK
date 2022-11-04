package up.mi.jgm.debat;

public class TestSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println("Liste avant changement");
		sol.affichage();
		System.out.println("Liste apres changement");
		sol.AjouteArgument("A1");
		sol.AjouteArgument("A2");
		sol.AjouteArgument("A3");
		sol.AjouteArgument("A4");
		sol.affichage();
		System.out.println("Liste apres retire");
		sol.retireArgument("A1");
		sol.affichage();
	}

}
