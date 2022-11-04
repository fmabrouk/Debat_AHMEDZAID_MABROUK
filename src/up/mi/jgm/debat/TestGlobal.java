package up.mi.jgm.debat;



public class TestGlobal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//nombre d'arguments 4
		Graphe g = new Graphe(5);
		g.addContradiction(0, 1);
		g.addContradiction(1, 0);
		g.addContradiction(1, 2);
		g.addContradiction(2, 1);
		g.addContradiction(2, 3);
		g.addContradiction(3, 2);
		g.addContradiction(3, 4);
		//System.out.print(g.toString());
		Solution E = new Solution();
		//E.affichage();
		E.AjouteArgument("A1");
		//E.AjouteArgument("A2");
		//E.AjouteArgument("A3");
		//E.AjouteArgument("A4");
		E.AjouteArgument("A5");
		E.affichage();
		if(E.solutionAdmissible(g,5)) {
			System.out.println("la solution E est admissible");
		}else {
			System.out.println("la solution E n'est pas admissible");
		}
		//E.AjouteArgument("A2");
		//E.AjouteArgument("A2");
		
		
		
	}

}
