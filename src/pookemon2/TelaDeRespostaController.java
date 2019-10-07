/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pookemon2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class TelaDeRespostaController implements Initializable {
    
    @FXML
    private AnchorPane painelTelaDeResposta;
    
    @FXML
    private TextArea txtAreaTipoDeAtaque;

    @FXML
    private TextArea txtAreaResposta;
    
    @FXML
    void mudaTextArea(MouseEvent event) {
        txtAreaTipoDeAtaque.setText("Enunciado:\n" + JanelaPerguntasController.matrizPergunta.getEnunciado(JanelaPerguntasController.ordemPerguntas[JanelaPerguntasController.contadorDePerguntas]));
        txtAreaResposta.setText("Resposta correta:\n" + JanelaPerguntasController.matrizPergunta.getResposta(JanelaPerguntasController.ordemPerguntas[JanelaPerguntasController.contadorDePerguntas], 1));
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
