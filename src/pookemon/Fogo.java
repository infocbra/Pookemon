package pookemon;

public class Fogo extends Pookemon {

    public Fogo(String nomePookemon, float vidaPookemon) {
        super(nomePookemon, vidaPookemon);
    }

    @Override
    public String atacar() {
        String texto = "Charmander usa Lança-Chamas!\n É muito efetivo!";
        return texto;
    }

}
