package up.mi.jgm.projet.phase2;

public class TableVerite {
    
   
	
		/**
		 * Permet de générer une table de vérité de n arguments
		 * @param tailleGraphe
		 * @return table de vérité des combinaisons possible des n arguments
		 */
		public static Boolean[][] generateTruthTable(int tailleGraphe){
			double ligne = Math.pow(2, tailleGraphe);
			Boolean[][] truthTable = new Boolean[(int)ligne][tailleGraphe];
			for(int subset = 0; subset<ligne; subset++){
				String subsetBits = Integer.toBinaryString(subset);
				
				while(subsetBits.length() < tailleGraphe){
					subsetBits = "0" + subsetBits;
				}
				for(int i=0; i<subsetBits.length(); i++){
					truthTable[subset][i] = (subsetBits.charAt(i) == '1');
				}
			}
			return truthTable;
		}

		
}
// Code récupéré https://github.com/youssefAli11997/Truth-Table-Generator/blob/master/Truth-Table-Generator/src/Model/TruthTableHandler.java
