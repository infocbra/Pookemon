/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pookemon2;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//import pookemon.Jogador;

/**
 *
 * @author Pichau
 */
public class Pookemon2 extends Application {
    // esta é a classe Principal
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void trocarParaTelaDeResposta(){
               
        try {
        
        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(TelaDeRespostaController.class.getResource("TelaDeResposta.fxml"));       
                 
        AnchorPane page = (AnchorPane) loader.load();

        // Cria o palco dialogStage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Feedback de Resposta");

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
    
        // Mostra a janela e espera até o usuário fechar.
        dialogStage.showAndWait();

        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}
