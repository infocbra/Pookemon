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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class CadastroJogadorController implements Initializable {

    @FXML
    private AnchorPane telaCadastroJogador;
    @FXML
    private Button btnConfirmarCadastro;
    @FXML
    private TextField txtFieldApelido;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    // ESTAÇÃO DE FLUXO DE TELAS
    @FXML
    private void mudaJanelaParaTelaEscolhaDePersonagem(MouseEvent event) throws IOException {
        
        guardarApelidoDoJogador();
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        telaCadastroJogador.getChildren().setAll(pane);
    }
    
    void guardarApelidoDoJogador(){
        FXMLDocumentController.jogador.setNomeDoJogador(txtFieldApelido.getText());
    }
    
}
