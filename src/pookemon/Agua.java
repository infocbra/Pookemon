package pookemon;

public class Agua extends Pookemon {

    public Agua(String nomePookemon, float vidaPookemon) {
        super(nomePookemon, vidaPookemon);
    }

    @Override
    public String atacar() {
        String texto = "Squirtle usa Rajada de Bolhas!\n É muito efetivo!";
        return texto;
    }
}
