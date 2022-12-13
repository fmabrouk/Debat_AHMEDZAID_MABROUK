package up.mi.jgm.projet.phase2;

public class Argument {

    private int indice;
    public int getIndice() {
        return indice;
    }


    public void setIndice(int indice) {
        this.indice = indice;
    }

    private String arg;

    public String getArg() {
        return arg;
    }


    public void setArg(String arg) {
        this.arg = arg;
    }

    public Argument(int indice, String arg){
        this.indice=indice;
        this.arg=arg;
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