// 3. Escreva um arquivo de propriedades Java via editor de textos. Esse arquivo deve ter os dados de chave e valor. Exemplo:

// arquivo config.properties
// arquivo = meu_arquivo.txt
// linha_inicial = 1
// linha_final = 3
// Depois, escreva uma classe Java que exibe da linha_inicial até a linha_final do arquivo, conforme definidos no arquivo de propriedades config.properties.
import java.io.*;
import java.util.Properties;

public class CSVReader {
    public static void main(String[] args) {
        try (FileInputStream configFile = new FileInputStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(configFile);

            String fileName = properties.getProperty("arquivo");
            int startLine = Integer.parseInt(properties.getProperty("linha_inicial"));
            int endLine = Integer.parseInt(properties.getProperty("linha_final"));

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                int totalLines = 0;

                while ((line = br.readLine()) != null) {
                    totalLines++;

                    if (totalLines >= startLine && totalLines <= endLine) {
                        System.out.println(line);
                    }

                    if (totalLines > endLine) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
