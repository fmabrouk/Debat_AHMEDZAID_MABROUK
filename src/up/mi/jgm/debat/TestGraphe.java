package up.mi.jgm.debat;

public class TestGraphe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphe g = new Graphe(5);

	    g.addContradiction(0, 1);
	    g.addContradiction(1, 0);
	    g.addContradiction(1, 2);
	    g.addContradiction(2, 1);
	    g.addContradiction(2, 3);
	    g.addContradiction(3, 2);
	    g.addContradiction(4,3);
	    g.addContradiction(0,4);
	    
	    System.out.print(g.toString());
	}
	
	/*
     * Resultat
     *  0: 0 1 0 0 1 
		1: 1 0 1 0 0 
		2: 0 1 0 1 0 
		3: 0 0 1 0 0 
		4: 0 0 0 1 0 
	*/

}
