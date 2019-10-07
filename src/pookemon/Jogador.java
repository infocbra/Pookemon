package pookemon;

public class Jogador {
    
    private String nomeDoJogador;
    private int tipoPookemon;
    private int pontuacao;
    
    // Construtor
    public Jogador() {
        System.out.println("criou jogador");
        this.pontuacao = 5000;
    }
    
    public String getNomeDoJogador() {
        return nomeDoJogador;
    }

    public void setNomeDoJogador(String nomeDoJogador) {
        this.nomeDoJogador = nomeDoJogador;
    }
    
    public int getPontuacao() {
        return pontuacao;
    }
    
    public void retiraPontos() {
        pontuacao -= 750;
    }

}
