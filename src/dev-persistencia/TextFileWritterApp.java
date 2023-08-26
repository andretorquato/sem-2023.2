import java.io.*;

public class TextFileWriterApp {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder text = new StringBuilder();
        String line;

        try {
            System.out.println("Digite as linhas de texto. Digite 'FIM' em uma linha para encerrar:");

            while (!(line = reader.readLine()).equalsIgnoreCase("FIM")) {
                text.append(line).append(System.lineSeparator());
            }

            System.out.print("Digite o nome do arquivo para salvar o texto: ");
            String fileName = reader.readLine();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(text.toString());
                System.out.println("Texto salvo no arquivo com sucesso!");
            } catch (IOException e) {
                System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Erro de entrada/saída: " + e.getMessage());
        }
    }
}
