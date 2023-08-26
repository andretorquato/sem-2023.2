import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyAppV2 {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: FileCopyAppV2 <arquivo_origem> <arquivo_destino>");
            System.exit(1);
        }

        String sourceFileName = args[0];
        String destFileName = args[1];

        try {
            long startTime = System.currentTimeMillis();

            FileInputStream inputFile = new FileInputStream(sourceFileName);
            FileOutputStream outputFile = new FileOutputStream(destFileName);

            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputFile.read(buffer)) != -1) {
                outputFile.write(buffer, 0, bytesRead);
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
