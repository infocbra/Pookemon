/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pookemon2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import pookemon.Fogo;
import pookemon.Perguntas;
import pookemon.Grama;
//import pookemon.Pookemon;

public class JanelaPerguntasController implements Initializable {
    
    // instancias para ordenamento de perguntas e alternativas
    // ordemPerguntas é static para ser acessada na TelaDeResposta
    // ordemAlternativas, por ser utilizada apenas nesta classe, é não static
    static int[] ordemPerguntas = new int[15];
    int[] ordemAlternativas = new int[4];
    
    static Perguntas matrizPergunta = new Perguntas();
    
    // ESTAÇÃO DE FLUXO DE TELAS
    void mudaJanelaParaTelaDeRespostaController() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("TelaDeResposta.fxml"));
        cenaPerguntas.getChildren().setAll(pane);
    }
    
    void mudaJanelaParaTelaDePontuacao() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("TelaDePontuacao.fxml"));
        cenaPerguntas.getChildren().setAll(pane);
    }
    
    // construtor para executar a leitura do arquivo CSV antes de atualizar a tela
    public JanelaPerguntasController(){
        matrizPergunta.lerArquivo();
    }
    
    // AnchorPane da Tela
    @FXML
    private AnchorPane cenaPerguntas;
    
    // contador de perguntas respondidas
    // ele é incrementado a cada resposta feita
    public static int contadorDePerguntas = 0;
    
    // botões de resposta (sentido horário)
    @FXML
    private Button btnResposta1;
    @FXML
    private Button btnResposta2;
    @FXML
    private Button btnResposta3;
    @FXML
    private Button btnResposta4;
    
    // Área de Texto para ENUNCIADO DA PERGUNTA
    @FXML
    private TextArea txtEnunciado;
    
    // Área de Texto para ATAQUE DO POOKEMON
    @FXML
    private TextArea txtAreaHabilidadePokemon;
    
    // Barras de Progresso
    @FXML
    private ProgressBar BarraProgresssoInimigo;
    @FXML
    private ProgressBar BarraProgresssoPlayer1;
    
    // Labels (nome do pookemonRobo e do pookemonDoJogador ou apelido do usuário)
    @FXML
    private Label labelPookemonRobo;
    @FXML
    private Label labelPookemonJogador;
    
    // imagens dos pokemons lado Jogador (direito)
    @FXML
    private ImageView imgPookemonJogadorFogo;
    @FXML
    private ImageView imgPookemonJogadorGrama;
    @FXML
    private ImageView imgPookemonJogadorAgua;
    
    // imagens dos pokemons lado Robô (esquerdo)
    @FXML
    private ImageView imgPookemonRoboGrama;
    @FXML
    private ImageView imgPookemonRoboAgua;
    @FXML
    private ImageView imgPookemonRoboFogo;
    
    void sortearOrdemDasPerguntas(){
        // Sorteia a ordem das perguntas
            int aleatorio;

            for (int i = 0; i < 15; i++) {
                aleatorio = (int) (Math.random() * 20);
                for (int x = 0; x < i; x++) {
                    if (ordemPerguntas[x] == aleatorio) {
                        aleatorio = (int) (Math.random() * 20);
                        x = -1;
                    }
                }
                ordemPerguntas[i] = aleatorio;
                System.out.print(" " + ordemPerguntas[i]);
            }
    }
    
    void sortearAlternativas(){
        // Sorteia a ordem das alternativas
        int aleatorioA;

        for (int i = 0; i < 4; i++) {
            aleatorioA = (int) (Math.random() * 4) + 1;
            for (int x = 0; x < i; x++) {
                if (ordemAlternativas[x] == aleatorioA) {
                    aleatorioA = (int) (Math.random() * 4) + 1;
                    x = -1;
                }
            }
            ordemAlternativas[i] = aleatorioA;
            System.out.print(" " + ordemAlternativas[i]);
        }
    }
    
    public void geraPerguntas(){
        /* muda o texto do textArea do enunciado
        * muda o texto dos botões de resposta
        * aplica a aleatoriedade das perguntas (gerada no método iniciarPartida())
        */
        
        // Sorteia a ordem das alternativas a cada rodada
        sortearAlternativas();
        
        // atualiza os texts dos botões e o txtArea do enunciado a cada rodada
        if (contadorDePerguntas < 15) {
            txtEnunciado.setText(matrizPergunta.getEnunciado(ordemPerguntas[contadorDePerguntas]));
            btnResposta1.setText(matrizPergunta.getResposta(ordemPerguntas[contadorDePerguntas], ordemAlternativas[0]));
            btnResposta2.setText(matrizPergunta.getResposta(ordemPerguntas[contadorDePerguntas], ordemAlternativas[1]));
            btnResposta3.setText(matrizPergunta.getResposta(ordemPerguntas[contadorDePerguntas], ordemAlternativas[2]));
            btnResposta4.setText(matrizPergunta.getResposta(ordemPerguntas[contadorDePerguntas], ordemAlternativas[3]));
        } else {
            txtEnunciado.setText("Acabou");
        }
    }
    
    @FXML
    void escolherResposta1(MouseEvent event) throws IOException {
        
        String respostaEscolhidaPeloJogador = btnResposta1.getText(); // resgata a resposta escolhida pelo jogador (que é o texto que está no botão escolhido)
        
        System.out.println("Resposta escolhida pelo user: " + respostaEscolhidaPeloJogador);
        System.out.println("RESPOSTA CORRETA DA ALTERNATIVA: " + matrizPergunta.getResposta(ordemPerguntas[contadorDePerguntas], 1));

        // método para validar a resposta escolhida pelo jogador
        validaResposta(respostaEscolhidaPeloJogador);

        // incrementa para gerar a próxima pergunta
        contadorDePerguntas++;

        // faz o balanço e as alterações finais, e encerra a rodada
        finalizaRodada();
    }

    @FXML
    void escolherResposta2(MouseEvent event) throws IOException {
        String respostaEscolhidaPeloJogador = btnResposta2.getText(); // resgata a resposta escolhida pelo jogador (que é o texto que está no botão escolhido)
        
        System.out.println("Resposta escolhida pelo user: " + respostaEscolhidaPeloJogador);
        System.out.println("RESPOSTA CORRETA DA ALTERNATIVA: " + matrizPergunta.getResposta(ordemPerguntas[contadorDePerguntas], 1));

        // método para validar a resposta escolhida pelo jogador
        validaResposta(respostaEscolhidaPeloJogador);

        // incrementa para gerar a próxima pergunta
        contadorDePerguntas++;

        // faz o balanço e as alterações finais, e encerra a rodada
        finalizaRodada();
    }

    @FXML
    void escolherResposta3(MouseEvent event) throws IOException {
        String respostaEscolhidaPeloJogador = btnResposta3.getText(); // resgata a resposta escolhida pelo jogador (que é o texto que está no botão escolhido)
        
        System.out.println("Resposta escolhida pelo user: " + respostaEscolhidaPeloJogador);
        System.out.println("RESPOSTA CORRETA DA ALTERNATIVA: " + matrizPergunta.getResposta(ordemPerguntas[contadorDePerguntas], 1));

        // método para validar a resposta escolhida pelo jogador
        validaResposta(respostaEscolhidaPeloJogador);

        // incrementa para gerar a próxima pergunta
        contadorDePerguntas++;

        // faz o balanço e as alterações finais, e encerra a rodada
        finalizaRodada();
    }

    @FXML
    void escolherResposta4(MouseEvent event) throws IOException {
        String respostaEscolhidaPeloJogador = btnResposta4.getText(); // resgata a resposta escolhida pelo jogador (que é o texto que está no botão escolhido)
        
        System.out.println("Resposta escolhida pelo user: " + respostaEscolhidaPeloJogador);
        System.out.println("RESPOSTA CORRETA DA ALTERNATIVA: " + matrizPergunta.getResposta(ordemPerguntas[contadorDePerguntas], 1));

        // método para validar a resposta escolhida pelo jogador
        validaResposta(respostaEscolhidaPeloJogador);

        // incrementa para gerar a próxima pergunta
        contadorDePerguntas++;
        
        // faz o balanço e as alterações finais, e encerra a rodada
        finalizaRodada();
    }
    
    void validaResposta(String respostaEscolhidaPeloJogador) throws IOException{
        // valida a resposta comparando com o GABARITO
        // modifica a vida dos pokemons de acordo com acertos ou erros
        // recebe como parâmetro a resposta escolhida pelo jogador para comparação
        
        if (respostaEscolhidaPeloJogador.equals(matrizPergunta.getResposta(ordemPerguntas[contadorDePerguntas], 1))) { // se a resposta estiver correta
            System.out.println("acertô");
            
            FXMLDocumentController.pookemonRobo.setVidaPookemon(FXMLDocumentController.pookemonRobo.getVidaPookemon() - 20);
            txtAreaHabilidadePokemon.setText(FXMLDocumentController.pookemonJogador.atacar());
            
            BarraProgresssoInimigo.setProgress(BarraProgresssoInimigo.getProgress() - 0.20); // diminui 20% da vida do inimigo
        } else { // se a resposta estiver incorreta
            FXMLDocumentController.jogador.retiraPontos();

            
            FXMLDocumentController.pookemonJogador.setVidaPookemon(FXMLDocumentController.pookemonJogador.getVidaPookemon() - 20);
            txtAreaHabilidadePokemon.setText(FXMLDocumentController.pookemonRobo.atacar());
            
            BarraProgresssoPlayer1.setProgress(BarraProgresssoPlayer1.getProgress() - 0.20); // diminui 20% da vida do jogador
            Pookemon2.trocarParaTelaDeResposta();
        }
        System.out.println("pontuação do jogador: " + FXMLDocumentController.jogador.getPontuacao());
        
        // mostra vida dos pookemons
        System.out.println("vida do pookemon do jogador: " + FXMLDocumentController.pookemonJogador.getVidaPookemon());
        System.out.println("vida do pookemon do ROBÔ: " + FXMLDocumentController.pookemonRobo.getVidaPookemon());
        
        System.out.println("respostaValidada");
    }
    
    void finalizaRodada() throws IOException{
        
        // checa se a partida foi finalizada. Se sim, muda pra TelaDePontuação
        // else: modifica/atualiza os textos dos botões e do enunciado
        
        if(FXMLDocumentController.pookemonJogador.getVidaPookemon() == 0){
            mudaJanelaParaTelaDePontuacao();
        } else if (FXMLDocumentController.pookemonRobo.getVidaPookemon() == 0){
            mudaJanelaParaTelaDePontuacao();
        } else {
            geraPerguntas();
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Sorteia a ordem das alternativas
        sortearAlternativas();

        if(btnResposta1.getText().equals("Clique para iniciar")){ // NÃO MODIFICAR (deve ser o mesmo text do botão 1 de resposta)
            // esta condição serve para sortar a ordem das perguntas no início da partida
            // e gerarPerguntas() atualiza os textos Enunciado e botões
            
            // Sorteia a ordem das perguntas
            sortearOrdemDasPerguntas();
            
            // atualiza as áreas de texto para a primeira rodada
            geraPerguntas();
        }
        
        // a condição atualiza o label de nome dos personagems na tela
        if(FXMLDocumentController.jogador.getNomeDoJogador().equals("")){
            labelPookemonJogador.setText("Anônimo" + " (" + FXMLDocumentController.pookemonJogador.getNomePookemon() + ")");
        } else {
            labelPookemonJogador.setText(FXMLDocumentController.jogador.getNomeDoJogador() + " (" + FXMLDocumentController.pookemonJogador.getNomePookemon() + ")");
        }
        
        // atualiza o label de nome do personagem robô na tela
        labelPookemonRobo.setText("Pookemon Robô" + " (" + FXMLDocumentController.pookemonRobo.getNomePookemon() + ")");
        
        // procedimentos para mostrar apenas os pookemons escolhidos na batalha
        if(FXMLDocumentController.pookemonJogador instanceof Grama){
            imgPookemonJogadorAgua.setTranslateX(+300);
            imgPookemonJogadorFogo.setTranslateX(+300);
        } else if(FXMLDocumentController.pookemonJogador instanceof Fogo){
            imgPookemonJogadorAgua.setTranslateX(+300);
            imgPookemonJogadorGrama.setTranslateX(+300);
        } else {
            imgPookemonJogadorGrama.setTranslateX(+300);
            imgPookemonJogadorFogo.setTranslateX(+300);
        }
        
        if(FXMLDocumentController.pookemonRobo instanceof Grama){
            imgPookemonRoboAgua.setTranslateX(-300);
            imgPookemonRoboFogo.setTranslateX(-300);
        } else if(FXMLDocumentController.pookemonRobo instanceof Fogo){
            imgPookemonRoboAgua.setTranslateX(-300);
            imgPookemonRoboGrama.setTranslateX(-300);
        } else {
            imgPookemonRoboGrama.setTranslateX(-300);
            imgPookemonRoboFogo.setTranslateX(-300);
        }
    }

}
