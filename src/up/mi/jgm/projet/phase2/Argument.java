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

    


}
