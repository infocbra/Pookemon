package pookemon;

public class Grama extends Pookemon {

    public Grama(String nomePookemon, float vidaPookemon) {
        super(nomePookemon, vidaPookemon);
    }

    @Override
    public String atacar() {
        String texto = "Bulbasaur usa Chicote de Cipó!\n É muito efetivo!";
        return texto;
    }
}
