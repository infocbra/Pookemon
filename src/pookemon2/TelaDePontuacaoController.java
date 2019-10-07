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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import pookemon.Fogo;
import pookemon.Grama;

public class TelaDePontuacaoController implements Initializable {
    
    @FXML
    private AnchorPane cenaPontuacao;
    @FXML
    private TextField txtAreaPontuacao;
    @FXML
    private Label nomeDoPookemon;
    @FXML
    private ImageView imgCharmander;
    @FXML
    private ImageView imgBulbasaur;
    @FXML
    private ImageView imgSquirtle;
    @FXML
    private Button btnVoltarParaMenuPrincipal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomeDoPookemon.setText(FXMLDocumentController.pookemonJogador.getNomePookemon());
        txtAreaPontuacao.setText(FXMLDocumentController.jogador.getPontuacao() + "");
        
        // procedimentos para mostrar apenas o pookemon escolhido na batalha
        if(FXMLDocumentController.pookemonJogador instanceof Grama){
            imgSquirtle.setTranslateX(+600);
            imgCharmander.setTranslateX(+600);
        } else if(FXMLDocumentController.pookemonJogador instanceof Fogo){
            imgSquirtle.setTranslateX(+600);
            imgBulbasaur.setTranslateX(+600);
        } else {
            imgBulbasaur.setTranslateX(+600);
            imgCharmander.setTranslateX(+600);
        }   
    }
    // ESTAÇÃO DE FLUXO DE TELAS
    @FXML
    private void mudaJanelaParaTelaInicial(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        cenaPontuacao.getChildren().setAll(pane);
    }
}
