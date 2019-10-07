/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pookemon2;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import pookemon.Agua;
import pookemon.Fogo;
import pookemon.Grama;
import pookemon.Jogador;
import pookemon.Pookemon;

public class FXMLDocumentController implements Initializable {
    
    // instâncias (são static para serem acessadas por qualquer outra tela)
    // aqui entra o polimorfismo, que é finalizado após a escolha do jogador
    public static Jogador jogador = new Jogador();
    public static Pookemon pookemonRobo = null;
    public static Pookemon pookemonJogador = null;
    
    @FXML
    private AnchorPane painelMenuPersonagem;
    
    // botões de escolha de personagem
    @FXML
    private ImageView escolhaBulbasaur;
    @FXML
    private ImageView escolhaCharmander;
    @FXML
    private ImageView escolhaSquirtle;
    
    void mudaJanelaParaJanelaPerguntasController() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("JanelaPerguntas.fxml"));
        painelMenuPersonagem.getChildren().setAll(pane);
    }
    
    void criarPokemonRoboAleatorio(){
        Random r = new Random();
        int numeroRandomico = r.nextInt(3)+1;
//      
        System.out.println("numero sorteado: " + numeroRandomico);
        
        switch(numeroRandomico){
            case 1:
                pookemonRobo = new Grama("Bulbasaur", 100);
                System.out.println("pookemon aleatorio grama criado");
                break;
            case 2:
                pookemonRobo = new Fogo("Charmander", 100);
                System.out.println("pookemon aleatorio fogo criado");
                break;
            case 3:
                pookemonRobo = new Agua("Squirtle", 100);
                System.out.println("pookemon aleatorio agua criado");
                break;
            default:
                pookemonRobo = null;
        }
    }
    
    @FXML
    void escolheBulbasaur(MouseEvent event) throws IOException {
//        janelaPerguntas.atualizaImagemPookemonJogador();
        criarPokemonRoboAleatorio();
        pookemonJogador = new Grama("Bulbasaur", 100); // instancia bulbasauro
        mudaJanelaParaJanelaPerguntasController(); // faz exatamente o que está aí heheh
    }

    @FXML
    void escolheCharmander(MouseEvent event) throws IOException {
        criarPokemonRoboAleatorio(); // cria pookemon Robô (adversário) aleatório
        pookemonJogador = new Fogo("Charmander", 100); // instancia Charmander
        mudaJanelaParaJanelaPerguntasController(); // faz exatamente o que está aí heheh
    }

    @FXML
    void escolheSquirtle(MouseEvent event) throws IOException {
        criarPokemonRoboAleatorio(); // cria pookemon Robô (adversário) aleatório
        pookemonJogador = new Agua("Squirtle", 100); // instancia Squirtle
        mudaJanelaParaJanelaPerguntasController(); // faz exatamente o que está aí heheh
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
