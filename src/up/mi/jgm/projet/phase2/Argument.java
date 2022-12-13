package up.mi.jgm.projet.phase2;


//Classe répresentant l'argument
public class Argument {

	//attribut : indice de l'argument
    private int indice;
    
    //attribut:le nom de l'argument
    private String arg;
    
   
    //Constructeur de la classe argument
    public Argument(int indice, String arg){
        this.indice=indice;
        this.arg=arg;
    }
    
    //getters & setters
    public int getIndice() {
        return indice;
    }
    
    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }
    
    @Override
    public String toString(){
        return arg+"";
    }
    
    @Override
    public boolean equals(Object obj){
	      if(this==obj){
	    	  return true;
	      }
	
	      if(obj==null){
	    	  return false;
	      }
	    
	      Argument other = (Argument) obj;
	      if (!this.arg.equals(other.arg)){
	    	  return false;
	      }
	
	      if(this.indice != other.indice){
	    	  return false;
	      }
	      return true;
	      
    }


}