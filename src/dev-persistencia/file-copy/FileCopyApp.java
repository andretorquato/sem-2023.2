import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyApp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: FileCopyApp <arquivo_origem> <arquivo_destino>");
            System.exit(1);
        }

        String sourceFileName = args[0];
        String destFileName = args[1];

        try {
            long startTime = System.currentTimeMillis();

            FileInputStream inputFile = new FileInputStream(sourceFileName);
            FileOutputStream outputFile = new FileOutputStream(destFileName);

            int byteRead;
            while ((byteRead = inputFile.read()) != -1) {
                outputFile.write(byteRead);
            }

            inputFile.close();
            outputFile.close();

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.println("Copia bem sucedida! Tempo total: " + totalTime + " ms");
        } catch (IOException e) {
            System.err.println("Erro durante a cópia do arquivo: " + e.getMessage());
        }
    }
}