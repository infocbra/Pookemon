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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class TelaInicialController implements Initializable {
    
    @FXML
    private AnchorPane telaDeInicio;
    
    @FXML
    private ImageView btnPressStart;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    void mudaJanelaParaTelaCadastroJogador(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("CadastroJogador.fxml"));
        telaDeInicio.getChildren().setAll(pane);
    }
    
    
}
