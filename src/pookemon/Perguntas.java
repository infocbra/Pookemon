package pookemon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Perguntas {
    public String[][] arrayDePerguntas = new String[25][5];

    public void lerArquivo() {
        
        String arquivoCSV = "perguntas2.csv";
        BufferedReader leitor = null;
        String linha = "";
        String divisor = ";";
        int i = 0;

        try {
            
              
            InputStream input = getClass().getResourceAsStream("/perguntas2.csv");
           
             leitor = new BufferedReader(new InputStreamReader(input));
            
           // leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoCSV), "UTF8"));
            
            while ((linha = leitor.readLine()) != null) {
                int j = 0;
                String[] perguntas = linha.split(divisor);
                for (String pergunta : perguntas) {
                    this.arrayDePerguntas[i][j] = pergunta;
                    j++;
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (leitor != null) {
                try {
                    leitor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String getEnunciado(int numeroDaQuestao){
        return this.arrayDePerguntas[numeroDaQuestao][0];
    }
    public String getResposta(int numeroDaQuestao, int numeroDaResposta){
        return this.arrayDePerguntas[numeroDaQuestao][numeroDaResposta];
    }
}
