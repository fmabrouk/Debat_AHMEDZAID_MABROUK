package up.mi.jgm.projet.phase2;

//Classe representant les exceptions
public class ArgumentNotDefinedException extends Exception {
    public ArgumentNotDefinedException(){
        super();
    }

    public ArgumentNotDefinedException(String s){
        super(s);
    }
}